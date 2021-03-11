package pe.com.claro.tiendavirtual.notificacion.mailing.exception;

public class MailerInitializationException extends RuntimeException{

	public MailerInitializationException(String msg, Throwable cause) {
		super(msg,cause);
	}
	public MailerInitializationException(String msg) {
		super(msg);
	}
	
}
