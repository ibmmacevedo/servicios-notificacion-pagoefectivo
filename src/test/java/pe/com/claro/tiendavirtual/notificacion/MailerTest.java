package pe.com.claro.tiendavirtual.notificacion;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atMost;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.internal.verification.AtMost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pe.com.claro.tiendavirtual.notificacion.mailing.Mail;
import pe.com.claro.tiendavirtual.notificacion.mailing.MailProvider;
import pe.com.claro.tiendavirtual.notificacion.mailing.exception.MailProviderException;
import pe.com.claro.tiendavirtual.notificacion.mailing.exception.MailingException;
import pe.com.claro.tiendavirtual.notificacion.messaging.MessageDTO;
import pe.com.claro.tiendavirtual.notificacion.service.Notifier;

@SpringBootTest
public class MailerTest {

	
	@Autowired
	Notifier notifier;
	
	@SpyBean
	MailProvider mailProvider;
	
	String msgValido="{\"request\":{\"campania\":\"Hogar\",\"equipo\":\"Hogar 1 Play Internet 20Mbps\",\"precio\":0.0,\"plan\":\"Hogar 1 Play Internet 20Mbps\",\"acuerdo\":\"mensual\",\"familia\":\"Personas\",\"purchaseNumber\":\"\",\"transactionId\":null,\"form_id\":\"1300159\",\"form_nombre\":\"Fidel limaylla\",\"form_tipo_doc\":\"DNI\",\"form_num_doc\":\"45939933\",\"form_num_tel_1\":\"999999999\",\"form_num_tel_2\":\"\",\"form_horario\":\"\",\"form_email\":\"fidel.lc@gmail.com\",\"form_departamento\":\"AREQUIPA-04\",\"form_provincia\":\"AREQUIPA-0401\",\"form_tarjeta\":\"contraentrega\",\"tipo_despacho\":\"\",\"form_pedido\":\"39045;Hogar 1 Play Internet 20Mbps;0.00;Hogar 1 Play Internet 20Mbps;Pago mensual;mensual;Hogar;1;Personas;0.00;0;\",\"form_num_pedido\":\"\",\"form_datetime\":1601497477000,\"fam_id\":1,\"form_bambulytics\":\"{\\\"HTTP_REFERER\\\":\\\"http://4e214eb3-us-south.lb.appdomain.cloud/\\\",\\\"utm_source\\\":\\\"\\\",\\\"utm_campaign\\\":\\\"\\\",\\\"utm_medium\\\":\\\"\\\",\\\"utm_content\\\":\\\"\\\"}\",\"form_distrito\":\"AREQUIPA-040101\",\"precio_promocional\":0.0,\"precio_plan\":59.0,\"como_pago\":\"Pago mensual\",\"pi_id\":\"39045\",\"tipo_prod\":\"Fijos Alambricos\",\"form_direccion\":\"jr lima 123\",\"name_empresa\":\"CLARO\",\"empresa_comi\":\"\",\"total_precio\":0.0,\"tlf_portab\":\"\",\"emp_portab\":\"\",\"active_cupon\":null,\"html_niubiz\":\"1\",\"precio_niubiz\":0.0,\"transaction_token\":\"\"},\"autorizacion\":\"{\\\"header\\\":{\\\"ecoreTransactionUUID\\\":{\\\"_value\\\":\\\"a3fa2c14-1778-4d99-8e00-e5076cecb26d\\\"},\\\"ecoreTransactionDate\\\":{\\\"_value\\\":1601499716288},\\\"millis\\\":{\\\"_value\\\":2670}},\\\"fulfillment\\\":{\\\"channel\\\":{\\\"_value\\\":\\\"web\\\"},\\\"merchantId\\\":{\\\"_value\\\":\\\"650161518\\\"},\\\"terminalId\\\":{\\\"_value\\\":\\\"\\\"},\\\"captureType\\\":{\\\"_value\\\":\\\"manual\\\"},\\\"countable\\\":{\\\"_value\\\":true},\\\"fastPayment\\\":{\\\"_value\\\":false},\\\"signature\\\":{\\\"_value\\\":\\\"a3fa2c14-1778-4d99-8e00-e5076cecb26d\\\"}},\\\"order\\\":{\\\"tokenId\\\":{\\\"_value\\\":\\\"7781BC8CFAFA46B081BC8CFAFAB6B04E\\\"},\\\"purchaseNumber\\\":{\\\"_value\\\":\\\"207330\\\"},\\\"amount\\\":{\\\"_value\\\":1.0},\\\"installment\\\":{\\\"_value\\\":0},\\\"currency\\\":{\\\"_value\\\":\\\"PEN\\\"},\\\"authorizedAmount\\\":{\\\"_value\\\":1.0},\\\"authorizationCode\\\":{\\\"_value\\\":\\\"001206\\\"},\\\"actionCode\\\":{\\\"_value\\\":\\\"000\\\"},\\\"traceNumber\\\":{\\\"_value\\\":\\\"182839\\\"},\\\"transactionDate\\\":{\\\"_value\\\":\\\"200930160153\\\"},\\\"transactionId\\\":{\\\"_value\\\":\\\"995202747579227\\\"}},\\\"dataMap\\\":{\\\"CURRENCY\\\":{\\\"_value\\\":\\\"0604\\\"},\\\"TERMINAL\\\":{\\\"_value\\\":\\\"00000001\\\"},\\\"TRANSACTION_DATE\\\":\\\"200930160153\\\",\\\"ACTION_CODE\\\":{\\\"_value\\\":\\\"000\\\"},\\\"TRACE_NUMBER\\\":{\\\"_value\\\":\\\"182839\\\"},\\\"CVV2_VALIDATION_RESULT\\\":{\\\"_value\\\":\\\"M\\\"},\\\"ECI_DESCRIPTION\\\":{\\\"_value\\\":\\\"Transaccion no autenticada pero enviada en canal seguro\\\"},\\\"ECI\\\":{\\\"_value\\\":\\\"07\\\"},\\\"ID_RESOLUTOR\\\":{\\\"_value\\\":\\\"300274757146180\\\"},\\\"SIGNATURE\\\":{\\\"_value\\\":\\\"a3fa2c14-1778-4d99-8e00-e5076cecb26d\\\"},\\\"CARD\\\":\\\"428082******0190\\\",\\\"MERCHANT\\\":\\\"650161518\\\",\\\"BRAND\\\":\\\"visa\\\",\\\"STATUS\\\":\\\"Authorized\\\",\\\"ACTION_DESCRIPTION\\\":{\\\"_value\\\":\\\"Aprobado y completado con exito\\\"},\\\"ADQUIRENTE\\\":{\\\"_value\\\":\\\"570009\\\"},\\\"ID_UNICO\\\":{\\\"_value\\\":\\\"995202747579227\\\"},\\\"AMOUNT\\\":\\\"1.00\\\",\\\"PROCESS_CODE\\\":{\\\"_value\\\":\\\"000000\\\"},\\\"TRANSACTION_ID\\\":{\\\"_value\\\":\\\"995202747579227\\\"},\\\"AUTHORIZATION_CODE\\\":\\\"001206\\\"}}\",\"dias_despacho\":5}";
	ObjectMapper mapper=new ObjectMapper();
	
	@Test
	void debeHacer3Reintentos() throws  JsonProcessingException, MailingException, MailProviderException {
		MessageDTO messageDto=armarMensaje();
		
		assertThrows(MailingException.class,()->notifier.notifyMail(messageDto));
		
		Mockito.verify(mailProvider,atMost(3)).sendMail(Mockito.any(Mail.class));
		
	}
	
	
	private MessageDTO armarMensaje() throws JsonMappingException, JsonProcessingException {
		return mapper.readValue(msgValido, MessageDTO.class);
	}
	
}
