package pe.com.claro.tiendavirtual.notificacion.c2c.exception;

public class CallCenterTimeoutException extends RuntimeException {

	private final static String message="Tiempo de espera agotado al invocar al callcenter";
	
	public CallCenterTimeoutException(Throwable cause) {
		super(message,cause);
	}
}
