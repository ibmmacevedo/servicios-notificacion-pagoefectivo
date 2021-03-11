package pe.com.claro.tiendavirtual.notificacion;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.SocketException;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Any;
import org.mockito.internal.verification.Times;
import org.mockito.verification.VerificationMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.dao.QueryTimeoutException;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pe.com.claro.tiendavirtual.notificacion.c2c.exception.CallCenterException;
import pe.com.claro.tiendavirtual.notificacion.c2c.request.C2CRequest;
import pe.com.claro.tiendavirtual.notificacion.c2c.request.RegistroPedido;
import pe.com.claro.tiendavirtual.notificacion.c2cnotifier.A365Notifier;
import pe.com.claro.tiendavirtual.notificacion.c2cnotifier.GrupoConectaNotifier;
import pe.com.claro.tiendavirtual.notificacion.repository.AuditoriaRepository;
import pe.com.claro.tiendavirtual.notificacion.repository.C2CRepository;
import pe.com.claro.tiendavirtual.notificacion.repository.model.C2C;
import pe.com.claro.tiendavirtual.notificacion.service.Notifier;

@SpringBootTest
class ServiciosNotificacionPagoEfectivoApplicationTests {

	@Autowired
	Notifier c2cNotifier;
	
	
	@MockBean
	AuditoriaRepository auditoriaRepository;
	
	@MockBean
	C2CRepository c2cRepo;
	@SpyBean
	A365Notifier a365Notifier;
	
	@SpyBean
	GrupoConectaNotifier konectaNotifier;
	
	
	@BeforeEach
	public void previoTest() {	
		MockitoAnnotations.initMocks(this);
		
	}
	
	
	@Test
	 void testA365NotifierOK() {
		defaultMocking("A");
		RegistroPedido request=generateRequest();
		c2cNotifier.notifyToC2C(request);
		Mockito.verify(a365Notifier,Mockito.atLeast(1)).notify(Mockito.any(C2CRequest.class));
	}
	
	@Test
	 void testConectaNotifierOK() {
		defaultMocking("K");
		RegistroPedido request=generateRequest();
		c2cNotifier.notifyToC2C(request);
		Mockito.verify(konectaNotifier,Mockito.atLeast(1)).notify(Mockito.any(C2CRequest.class));
	}
	
	

	
	private RegistroPedido generateRequest()  {
		
		String pedidoJson="{\"form_id\":\"1300159\",\"form_nombre\":\"Fidel limaylla\",\"form_tipo_doc\":\"DNI\",\"form_num_doc\":\"45939933\",\"form_num_tel_1\":\"999999999\",\"form_num_tel_2\":\"\",\"form_horario\":\"\",\"form_email\":\"fidel.lc@gmail.com\",\"form_departamento\":\"AREQUIPA-04\",\"form_provincia\":\"AREQUIPA-0401\",\"form_tarjeta\":\"contraentrega\",\"tipo_despacho\":\"\",\"form_pedido\":\"39045;Hogar 1 Play Internet 20Mbps;0.00;Hogar 1 Play Internet 20Mbps;Pago mensual;mensual;Hogar;1;Personas;0.00;0;\",\"form_num_pedido\":\"\",\"form_datetime\":\"2020-09-30T15:24:37-05:00\",\"fam_id\":1,\"form_bambulytics\":\"{\\\"HTTP_REFERER\\\":\\\"http://4e214eb3-us-south.lb.appdomain.cloud/\\\",\\\"utm_source\\\":\\\"\\\",\\\"utm_campaign\\\":\\\"\\\",\\\"utm_medium\\\":\\\"\\\",\\\"utm_content\\\":\\\"\\\"}\",\"campania\":\"Hogar\",\"form_distrito\":\"AREQUIPA-040101\",\"equipo\":\"Hogar 1 Play Internet 20Mbps\",\"precio\":0.0,\"precio_promocional\":0.0,\"plan\":\"Hogar 1 Play Internet 20Mbps\",\"precio_plan\":59.0,\"como_pago\":\"Pago mensual\",\"acuerdo\":\"mensual\",\"familia\":\"Personas\",\"pi_id\":\"39045\",\"tipo_prod\":\"Fijos Alambricos\",\"form_direccion\":\"jr lima 123\",\"name_empresa\":\"CLARO\",\"empresa_comi\":\"\",\"total_precio\":0.0,\"tlf_portab\":\"\",\"emp_portab\":\"\",\"purchaseNumber\":\"\",\"html_niubiz\":\"0\",\"precio_niubiz\":0.0,\"transaction_token\":\"\"}";
		RegistroPedido pedido=null;
		try {
			pedido=new ObjectMapper().readValue(pedidoJson, RegistroPedido.class);
		
		}
		catch(JsonProcessingException e) {
				e.printStackTrace();
		}
		
		return pedido;
		
		
	}

	private void defaultMocking(String c2c) {
		C2C c2cBean=new C2C();
		c2cBean.setC2c(c2c);
		Mockito.when(c2cRepo.getC2C(Mockito.any()))
		.thenReturn(c2cBean);
		
		Mockito.when(auditoriaRepository.insertarAuditoria(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any()))
		.thenReturn(new HashMap());
	}
	
}
