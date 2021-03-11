package pe.com.claro.tiendavirtual.notificacion.c2cnotifier;

import java.net.SocketTimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pe.com.claro.tiendavirtual.notificacion.c2c.exception.CallCenterException;
import pe.com.claro.tiendavirtual.notificacion.c2c.exception.CallCenterTimeoutException;
import pe.com.claro.tiendavirtual.notificacion.c2c.request.C2CRequest;
import pe.com.claro.tiendavirtual.notificacion.c2c.request.RegistroPedido;
import pe.com.claro.tiendavirtual.notificacion.repository.AuditoriaRepository;
import pe.com.claro.tiendavirtual.notificacion.repository.model.Paquete;

@Component("K")
public class GrupoConectaNotifier implements CallCenterNotifier {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	AuditoriaRepository auditoriaRepository;

	Logger log = LoggerFactory.getLogger(GrupoConectaNotifier.class);

	@Value("${call.center.conectaUrl}")
	String callCenterConectaUrl;

	@Override
	public void notify(C2CRequest request) {
		try {

			String urlParams = generateUrlParamsForConecta(request);

			audit(request, ": C2C_GRUPOKONECTA-request: ", urlParams);

			ResponseEntity<String> response = performPostRequest(callCenterConectaUrl, urlParams);

			audit(request, ": C2C_GRUPOKONECTA-response: ", response.toString());

		} catch (CallCenterException | CallCenterTimeoutException e) {
			throw e;
		} catch (JsonProcessingException e) {
			throw new CallCenterException("Error en generar los parametros para la invocacion", e);
		}

	}

	private ResponseEntity<String> performPostRequest(String url, String postDataStr) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		HttpEntity<String> entity = new HttpEntity<String>(postDataStr, headers);
		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
			return response;
		} catch (ResourceAccessException e) {
			if (e.getCause() instanceof SocketTimeoutException) {
				throw new CallCenterTimeoutException(e.getCause());
			}
			throw new CallCenterException(e.getMessage(), e);
		}

	}

	private void audit(C2CRequest request, String title, String message) {
		RegistroPedido requestPedido = request.getPedidoRequest();
		log.info("{} : {} : {}", requestPedido.getTransactionId(), title, message);
		try {
			auditoriaRepository.insertarAuditoria(requestPedido.getFormNombre(), requestPedido.getFormEmail(),
					requestPedido.getTipoProd(), null, null, title, message);

		} catch (DataAccessException e) {
			log.error("Error al guardar auditoria "+ e.getMessage(), e.getCause());
		}

	}

	private String generateUrlParamsForConecta(C2CRequest request) throws JsonProcessingException {
		RegistroPedido requestPedido = request.getPedidoRequest();
		String campos = "";
		campos += "id=" + requestPedido.getFormId() + "&";
		campos += "telefono1=" + requestPedido.getFormNumTel1() + "&";
		campos += "campania=" + requestPedido.getCampania() + "&";
		campos += "nombres=" + requestPedido.getFormNombre() + "&";
		campos += "pedido=" + generarPaquetePedido(request.getPedidoRequest()) + "&";
		campos += "tipodocumento=" + requestPedido.getFormTipoDoc() + "&";
		campos += "num_doc=" + requestPedido.getFormNumDoc() + "&";
		campos += "direccion=" + requestPedido.getFormDireccion() + "&";
		campos += "correo=" + requestPedido.getFormEmail() + "&";
		campos += "departamento=" + requestPedido.getFormDepartamento() + "&";
		campos += "provincia=" + requestPedido.getFormProvincia() + "&";
		campos += "distrito=" + requestPedido.getFormDistrito() + "&";
		campos += "tarjeta=" + requestPedido.getFormTarjeta() + "&";
		campos += "tipo_despacho=" + requestPedido.getTipoDespacho() + "&";
		campos += "utm=" + requestPedido.getFormBambulytics();
		return campos;
	}

	private String generarPaquetePedido(RegistroPedido request) throws JsonProcessingException {
		Paquete paquete = new Paquete();
		paquete.setEquipo(request.getEquipo());
		paquete.setPrecio(request.getPrecio());
		paquete.setPrecioPromocional(request.getPrecioPromocional());
		paquete.setPlan(request.getPlan());
		paquete.setPrecioPlan(request.getPrecioPlan());
		paquete.setComoPago(request.getComoPago());
		paquete.setAcuerdo(request.getAcuerdo());
		paquete.setCampania(request.getCampania());
		paquete.setFamilia(request.getFamilia());
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		return mapper.writeValueAsString(paquete);
	}

}
