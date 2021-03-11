package pe.com.claro.tiendavirtual.notificacion.mailing;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

import pe.com.claro.tiendavirtual.notificacion.mailing.exception.MailProviderException;

public interface MailProvider {

	@Retryable(value  = {MailProviderException.class},
		      maxAttempts = 3, backoff = @Backoff(delay = 3000))
	public String sendMail(Mail mail) throws MailProviderException;
}
