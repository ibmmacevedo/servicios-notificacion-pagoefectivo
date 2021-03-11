package pe.com.claro.tiendavirtual.notificacion.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pe.com.claro.tiendavirtual.notificacion.c2c.exception.CallCenterException;
import pe.com.claro.tiendavirtual.notificacion.c2c.exception.CallCenterTimeoutException;
import pe.com.claro.tiendavirtual.notificacion.mailing.exception.MailingException;
import pe.com.claro.tiendavirtual.notificacion.service.NotifierService;

@Component
public class RabbitMQListener implements MessageListener {
	
	Logger log = LoggerFactory.getLogger(RabbitMQListener.class);
	
	@Autowired
	NotifierService service;

	@Override
	@RabbitListener(queues = "pedidos_notificacion_c2c_pagoefectivo")
	public void recieveMessageForC2C(String msg) {
		log.info("Recibiendo mensaje de pedidos para notificar c2c ");
		try {
			MessageDTO message=new ObjectMapper().readValue(msg, MessageDTO.class);
			service.notifyToC2C(message.getRequest());
		} catch (JsonProcessingException e) {
			log.error(String.format("El mensaje recibido no es válido para deserializar: '%s'",msg),e);
		} catch (CallCenterException | CallCenterTimeoutException e) {
			throw e; //dlq 
		} 
		
		
	}
	
	
	@Override
	@RabbitListener(queues = "pedidos_notificacion_mail")
	public void recieveMessageForMail(String msg) throws MailingException {
		log.info("Recibiendo mensaje de pedidos para notificar por mail ");
		try {
			MessageDTO message=new ObjectMapper().readValue(msg, MessageDTO.class);
			service.notifyMail(message);
			
		} catch (JsonProcessingException e) {
			log.error(String.format("El mensaje recibido no es válido para deserializar: '%s'",msg),e);
		} catch (MailingException e) {
			throw e; //dlq
		} 
		
	}

}
