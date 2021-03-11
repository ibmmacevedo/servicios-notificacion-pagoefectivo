package pe.com.claro.tiendavirtual.notificacion.c2cnotifier;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import org.apache.axis.AxisFault;
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
import pe.com.claro.tiendavirtual.notificacion.c2c.wsclientfortel.Cliente2;
import pe.com.claro.tiendavirtual.notificacion.c2c.wsclientfortel.IWSCliente2Proxy;
import pe.com.claro.tiendavirtual.notificacion.c2c.wsclientfortel.Pedido;
import pe.com.claro.tiendavirtual.notificacion.repository.AuditoriaRepository;

@Component("F")
public class FortelNotifier implements CallCenterNotifier {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	AuditoriaRepository auditoriaRepository;

	Logger log = LoggerFactory.getLogger(FortelNotifier.class);

	@Value("${call.center.forteUrl}")
	String callCenterFortelUrl;

	@Override
	public void notify(C2CRequest request) {
		RegistroPedido requestPedido = request.getPedidoRequest();
		try {
			IWSCliente2Proxy proxy = new IWSCliente2Proxy(callCenterFortelUrl);
			Cliente2 cliente = new Cliente2();

			cliente.setId("POST".concat(requestPedido.getFormId()));
			cliente.setTelefono1(requestPedido.getFormNumTel1());
			cliente.setTelefono2(requestPedido.getFormNumTel2());
			cliente.setCampania(request.getCampaniaListaPrecio());
			cliente.setNombres(requestPedido.getFormNombre());
			cliente.setDni(requestPedido.getFormNumDoc());
			cliente.setDepartamento(requestPedido.getFormDepartamento());
			cliente.setProvincia(requestPedido.getFormProvincia());
			cliente.setDistrito(requestPedido.getFormDistrito());
			cliente.setTarjeta(requestPedido.getFormTarjeta());
			cliente.setTipo_despacho(requestPedido.getTipoDespacho());
			cliente.setUtm(requestPedido.getFormBambulytics());
			
			Pedido pedido2 = new Pedido();
            
            String precio = null;
            if(requestPedido.getPrecio() != null)
                precio = requestPedido.getPrecio().toString();
            
            String precio_promocional = null;
            if(requestPedido.getPrecioPromocional() != null)
                precio_promocional = requestPedido.getPrecioPromocional().toString();
            
            String precio_plan = null;
            if(requestPedido.getPrecioPlan() != null)
                precio_plan = requestPedido.getPrecioPlan().toString();
            
            pedido2.setEquipo(requestPedido.getEquipo());
            pedido2.setPrecio(precio);
            pedido2.setPrecioPromocional(precio_promocional);
            pedido2.setPlan(requestPedido.getPlan());
            pedido2.setPrecioPlan(precio_plan);
            pedido2.setComoPago(requestPedido.getComoPago());
            pedido2.setAcuerdo(requestPedido.getAcuerdo());
            pedido2.setLista(requestPedido.getCampania());
            pedido2.setFamilia(requestPedido.getFamilia());

			List<Pedido> lstPedido = new ArrayList<Pedido>();
			lstPedido.add(pedido2);
			cliente.setPedido(lstPedido.stream().toArray(n -> new Pedido[n]));

			String jsonAuditoria = new ObjectMapper().writeValueAsString(cliente);
			audit(request, "C2C_FORTEL-request", jsonAuditoria);

			String response = proxy.agregarCliente(cliente);

			audit(request, "C2C_FORTEL-response", response);

		} catch (AxisFault e) {
			throw new CallCenterException("Error SOAP Fault al invocar el servicio de Telestant", e);
		} catch (Exception e) {
			if (e.getCause() instanceof SocketTimeoutException) {
				throw new CallCenterTimeoutException(e.getCause());
			}
			throw new CallCenterException("Error al invocar el servicio de Telestant", e);
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

}
