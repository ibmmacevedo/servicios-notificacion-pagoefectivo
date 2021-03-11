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

@Component("A")
public class A365Notifier implements CallCenterNotifier{

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	AuditoriaRepository auditoriaRepository;

	Logger log = LoggerFactory.getLogger(A365Notifier.class);

	@Value("${call.center.a365Url}")
	String callCenterA365Url;
	
	String params;
	
	@Override
	public void notify(C2CRequest request) {
		try {
			
			params=generateUrlParams(request);			
			
			audit(request, "C2C_A365-request", params);
			
			ResponseEntity<String> response=performPostRequest(callCenterA365Url, params);
			
			audit(request,"C2C_A365-response",response.toString());
											
		} catch (CallCenterException | CallCenterTimeoutException e) {
			throw e;
		} catch (JsonProcessingException e) {
			throw new CallCenterException("Error en generar los parametros para la invocacion", e);
		}	
	}

		public  ResponseEntity<String> performPostRequest(String url,String postDataStr){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<String> entity = new HttpEntity<String>(postDataStr, headers);
		try {
			ResponseEntity<String> response= restTemplate.exchange(url,
					HttpMethod.POST, entity, String.class);
			return response;
		} catch (ResourceAccessException e) {
			if(e.getCause() instanceof SocketTimeoutException) {
				throw new CallCenterTimeoutException(e.getCause());
			}
			log.error("error performing call Center");
			throw new CallCenterException(e.getMessage(),e);
		}
		
	}
	
	private String generateUrlParams(C2CRequest request) throws JsonProcessingException {
		RegistroPedido requestPedido=request.getPedidoRequest();
		String campania = requestPedido.getCampania();
		if ( "Renovación".equals(campania)) {
			campania = "CLTDVALT";
		} else if ("Portabilidad".equals(campania)) {
			campania = "CLTDPOR";
		} else {
			campania = "CLTDVIR";
		}
		String postDataStr = "";
		postDataStr += "id=POST" + requestPedido.getFormId() + "&";
		postDataStr += "telefono=" + requestPedido.getFormNumTel1() + "&";
		postDataStr += "telefono2=" + requestPedido.getFormNumTel2() + "&";
		postDataStr += "campania=" + campania + "&";
		postDataStr += "nombre=" + requestPedido.getFormNombre() + "&";
		postDataStr += "pedido=" + generarPaquetePedido(request.getPedidoRequest()) + "&";
		postDataStr += "dni=" + requestPedido.getFormNumDoc() + "&";
		postDataStr += "departamento=" + requestPedido.getFormDepartamento() + "&";
		postDataStr += "provincia=" + requestPedido.getFormProvincia() + "&";
		postDataStr += "distrito=" + requestPedido.getFormDistrito() + "&";
		postDataStr += "tarjeta=" + requestPedido.getFormTarjeta() + "&";
		postDataStr += "tipo_despacho=" + requestPedido.getTipoDespacho() + "&";
		postDataStr += "utm=" + requestPedido.getFormBambulytics();
		return postDataStr;

		
	}


	private void audit(C2CRequest request, String title, String message) {
		RegistroPedido requestPedido=request.getPedidoRequest();
		log.info("{} : {} : {}",requestPedido.getTransactionId(), title , message);
		try {
			auditoriaRepository.insertarAuditoria(requestPedido.getFormNombre(), requestPedido.getFormEmail(),
					requestPedido.getTipoProd(), null, null, title, message);

		} catch (DataAccessException e) {
			log.error("Error al guardar auditoria "+ e.getMessage(), e.getCause());
		}
		
		
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
		ObjectMapper mapper=new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		return mapper.writeValueAsString(paquete);
	}
	
	
}
