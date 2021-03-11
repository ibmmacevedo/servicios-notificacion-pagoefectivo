package pe.com.claro.tiendavirtual.notificacion.service;


import pe.com.claro.tiendavirtual.notificacion.c2c.request.RegistroPedido;
import pe.com.claro.tiendavirtual.notificacion.mailing.exception.MailingException;
import pe.com.claro.tiendavirtual.notificacion.messaging.MessageDTO;

public interface Notifier {
	
	public void notifyToC2C(RegistroPedido request);
	
	public void notifyMail(MessageDTO messageDto) throws MailingException;

}
