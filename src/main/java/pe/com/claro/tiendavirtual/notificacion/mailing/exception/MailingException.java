package pe.com.claro.tiendavirtual.notificacion.mailing.exception;

/**
 * 
 * @author wcvaler
 *	Excepcion general para el envio de mail
 *
 */

public class MailingException extends Exception {

	
	public MailingException(String msg,Throwable cause) {
		super(msg,cause);
	}
}
