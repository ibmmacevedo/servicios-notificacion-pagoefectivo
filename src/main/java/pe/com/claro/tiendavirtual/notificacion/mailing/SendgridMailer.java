package pe.com.claro.tiendavirtual.notificacion.mailing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import pe.com.claro.tiendavirtual.notificacion.mailing.exception.MailProviderException;

@Component
public class SendgridMailer implements MailProvider{

	@Autowired
	RestTemplate restTemplate;
	
	Logger log =LoggerFactory.getLogger(SendgridMailer.class);
	
	@Value("${sendgrid.url.base}")
	private String sendgridUrlBase;
	@Value("${sendgrid.module.action}")
	private String sendgridModuleAction;
	@Value("${sendgrid.api.user}")
	private String sendgridApiUser;
	@Value("${sendgrid.api.key}")
	private String sendgridApiKey;
	
	@Override
	public String sendMail(Mail mail) throws MailProviderException{
		log.info("call sendgrid api");
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

			String url = sendgridUrlBase + sendgridModuleAction;

			MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
			map.add("api_user", sendgridApiUser);
			map.add("api_key", sendgridApiKey);
			map.add("to", mail.getTo());
			map.add("subject", mail.getSubject());
			map.add("html", mail.getBody());
			map.add("text", null);
			map.add("from", mail.getFrom());

			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map,
					headers);
			ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
		} catch (Exception e) {
			throw new MailProviderException(e.getMessage(), e.getCause());
		}
		return "OK";
	} 
		
	
}
