package pe.com.claro.tiendavirtual.notificacion.c2cnotifier;

import java.net.SocketTimeoutException;

import org.apache.axis.AxisFault;
import org.apache.axis.client.Call;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.com.claro.tiendavirtual.notificacion.c2c.exception.CallCenterException;
import pe.com.claro.tiendavirtual.notificacion.c2c.exception.CallCenterTimeoutException;
import pe.com.claro.tiendavirtual.notificacion.c2c.request.C2CRequest;
import pe.com.claro.tiendavirtual.notificacion.c2c.request.RegistroPedido;
import pe.com.claro.tiendavirtual.notificacion.repository.AuditoriaRepository;

@Component("T")
public class TelestantNotifier implements CallCenterNotifier{

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	AuditoriaRepository auditoriaRepository;

	Logger log = LoggerFactory.getLogger(TelestantNotifier.class);

	@Value("${call.center.telestantUrl}")
	String callCenterTelestantUrl;
	
	@Override
	public void notify(C2CRequest request) {
		RegistroPedido requestPedido=request.getPedidoRequest();
		try {
			String tsource = "";
			switch (requestPedido.getTipoProd()) {
			case "Fijos Alambricos":
				tsource = "2920";
				break;
			case "Fijos Inalambricos":
				tsource = "2920";
				break;
			default:
				tsource = "2921";
				break;
			}

			Call call = null;
			//String REGISTRY_URL = "http://panel.digitalion.com/wss/cobalt.lead.php?wsdl";
			String registryUri = "wsLeads";
			String method = "lead";

			Object[] parameters = new Object[] { "catalogo.claro.com.pe", "c2c", tsource, "POST" + requestPedido.getFormId(),
					requestPedido.getFormNombre().trim(), "", "-", "", requestPedido.getFormNumTel1().trim(),
					request.getPedido().trim(), "CLAROPEOFICIAL",
					requestPedido.getFormNumDoc() + "|" + requestPedido.getFormTarjeta() + "|"
							+ requestPedido.getTipoDespacho() + "|" + request.getCampaniaListaPrecio(),
					requestPedido.getCampania() + "|" + requestPedido.getFormBambulytics(), "", "", "", "", "", "1",
					"", "", "", "", "", "", "", "", "1", "", "", "", "", "", "Perú",
					requestPedido.getFormDepartamento(), requestPedido.getFormProvincia(),
					requestPedido.getFormDistrito(), "", "", "" };

			String jsonAuditoria = new ObjectMapper().writeValueAsString(parameters);
			
			audit(request, "C2C_TELESTANT-request", jsonAuditoria);
			
			org.apache.axis.client.Service service = new org.apache.axis.client.Service();
			call = (Call) service.createCall();
			call.setTargetEndpointAddress(callCenterTelestantUrl);
			call.setTimeout(new Integer(0));
			call.setSOAPActionURI(registryUri + "#" + method);
			String response = (String) call.invoke(registryUri, method, parameters);

			audit(request, "C2C_TELESTANT-response", response);
			
			
		} catch (AxisFault e) {
			throw new CallCenterException("Error SOAP Fault al invocar el servicio de Telestant", e);
		} catch (Exception e) {
			if( e.getCause() instanceof SocketTimeoutException) {
				throw new CallCenterTimeoutException(e.getCause());
			}
			throw new CallCenterException("Error al invocar el servicio de Telestant", e);
		}

		
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
	
}
