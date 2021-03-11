package pe.com.claro.tiendavirtual.notificacion.c2cnotifier;

import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.annotation.Backoff;
import pe.com.claro.tiendavirtual.notificacion.c2c.exception.CallCenterException;
import pe.com.claro.tiendavirtual.notificacion.c2c.exception.CallCenterTimeoutException;
import pe.com.claro.tiendavirtual.notificacion.c2c.request.C2CRequest;

public interface CallCenterNotifier {
	
	
	@Retryable(value  = {CallCenterTimeoutException.class, CallCenterException.class},
		      maxAttempts = 3, backoff = @Backoff(delay = 3000))
	public void notify(C2CRequest request);

}
