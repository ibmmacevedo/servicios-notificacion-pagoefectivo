package pe.com.claro.tiendavirtual.notificacion.mailing.exception;

/***
 * 
 * @author wcvaler
 *
 *	Clase que encapsula las excepciones ocurridas al enviar el mail
 *  via el proveedor
 */

public class MailProviderException extends Exception{

	public MailProviderException(String msg,Throwable cause) {
		super(msg,cause);
	}
}
