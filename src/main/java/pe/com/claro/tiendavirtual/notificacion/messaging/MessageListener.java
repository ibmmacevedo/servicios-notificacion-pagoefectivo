package pe.com.claro.tiendavirtual.notificacion.messaging;

import pe.com.claro.tiendavirtual.notificacion.mailing.exception.MailingException;

public interface MessageListener {
	
	public void recieveMessageForC2C (String msg) ;
	public void recieveMessageForMail(String msg) throws MailingException;

}
