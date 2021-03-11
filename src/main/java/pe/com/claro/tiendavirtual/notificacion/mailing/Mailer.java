package pe.com.claro.tiendavirtual.notificacion.mailing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import pe.com.claro.tiendavirtual.notificacion.c2c.request.RegistroPedido;
import pe.com.claro.tiendavirtual.notificacion.mailing.exception.MailProviderException;
import pe.com.claro.tiendavirtual.notificacion.mailing.exception.MailerInitializationException;
import pe.com.claro.tiendavirtual.notificacion.mailing.exception.MailingException;
import pe.com.claro.tiendavirtual.notificacion.messaging.MessageDTO;
import pe.com.claro.tiendavirtual.notificacion.util.Util;

@Component
public class Mailer {
	
	@Autowired
	MailProvider mailProvider;
	
	Logger log =LoggerFactory.getLogger(Mailer.class);
	
	RegistroPedido request;
	JsonNode autorizacion;
	int diasDespacho;
	Mail mail;
	ObjectMapper mapper=new ObjectMapper();
	
	private static final String FROM="tienda@claro.com.pe";
	private static final String SUBJECT="Tienda Claro Online - Pedido #";
	
	
	public void sendMailPedido(MessageDTO message) throws MailingException  {
		try {
			setMessage(message);
			
			generateMailObject();
			log.info("{} - enviando mail ",request.getTransactionId());
			String resp=mailProvider.sendMail(mail);
			log.info("{} - respuesta mail :{} ",request.getTransactionId(),resp);
			
		} catch (MailProviderException | MailerInitializationException e) {
			throw new MailingException("El mail no pudo ser enviado", e);
		}
		
		
	}
	
	private void generateMailObject() {
		mail=new Mail();
		mail.setFrom(FROM);
		mail.setTo(request.getFormEmail());
		mail.setBody(getEmailBodyContent());
		mail.setSubject(SUBJECT+getFormIdFormatted());
	}
	
	
	private void setMessage(MessageDTO message) {
		request=message.getRequest();
		diasDespacho=message.getDiasDespacho();
		if (request.getHtmlNiubiz().equals("1")) {
		try {
			
		    autorizacion=mapper.readValue(message.getAutorizacion(),JsonNode.class);
		}  catch (JsonProcessingException e) {
			throw new MailerInitializationException("No se pudo deserializar el campo autorizacion que es necesario porque html_niubiz=1 , verifique sea un json valido :'"+message.getAutorizacion()+"'", e);
		}
		}
	}


	private String getEmailBodyContent() {
		if(request.getFamId() == 3) {
			
			return emailNegocio();
		}
		else {
			
			if("market".equals(request.getTipoProd())) {
				return emailMarket();
			}else {
				return emailNiubiz();
			}
			
		}
		
	}
	
	

	private String emailNiubiz() {
		
		Map<String, String> params = new HashMap<>();
		params.put("#{formId}", getFormIdFormatted());
		params.put("#{formNombre}", request.getFormNombre().toUpperCase());
		params.put("#{htmlNiubiz}", getHtmlNiubizSection());

		return bindTemplateWithParams("/templates/mailNiubizTemplate.html", params);

	}

	
	
	private String emailMarket() {
		

		String nombreEmpresa = request.getNameEmpresa().equals("") ? "CLARO" : request.getNameEmpresa();

		Map<String, String> params = new HashMap<>();
		params.put("#{formId}", getFormIdFormatted());
		params.put("#{formNombre}", request.getFormNombre().toUpperCase());
		params.put("#{direccionCompleta}", getDireccionCompleta());
		params.put("#{purchaseNumber}", request.getPurchaseNumber());
		params.put("#{equipo}", request.getEquipo());
		params.put("#{dataMap.AMOUNT}", autorizacion.get("dataMap").get("AMOUNT").asText());
		params.put("#{dataMap.CARD}", autorizacion.get("dataMap").get("CARD").asText());
		params.put("#{dataMap.BRAND}", autorizacion.get("dataMap").get("BRAND").asText());
		params.put("#{dataMap.TRANSACTIONDATE}",
				Util.formatDate(autorizacion.get("dataMap").get("TRANSACTION_DATE").asText()));
		params.put("#{fechaEstimadaEntrega}", Util.DateToExtendDate(diasDespacho));
		params.put("#{nombreEmpresa}", nombreEmpresa);

		return bindTemplateWithParams("/templates/mailMarketTemplate.html", params);

	}

	
	private String emailNegocio() {
		
		Map<String, String> params = new HashMap<>();
		params.put("#{formId}", getFormIdFormatted());
		params.put("#{formNombre}", request.getFormNombre().toUpperCase());
		params.put("#{htmlNiubiz}", getHtmlNiubizSection());

		return bindTemplateWithParams("/templates/mailNiubizTemplate.html", params);

	}

	private String getFormIdFormatted() {
		String prefix=(request.getTipoProd().equals("market") && request.getFamId()!=3)?"M":"";
		String formId=request.getFormId();
		return prefix+("0000000000" + formId).substring(formId.length());
	}
	
	private String getDireccionCompleta() {
		return request.getFormDepartamento() + " " + request.getFormProvincia() + " "
				+ request.getFormDistrito().split("-")[0] + " " + request.getFormDireccion();
		
	}


	private String bindTemplateWithParams(String mailTemplateFile, Map<String, String> params) {
		String mailTemplate = loadMailTemplate(mailTemplateFile);
		for (Map.Entry<String, String> e : params.entrySet()) {
			mailTemplate = mailTemplate.replace(e.getKey(), e.getValue());
		}

		return mailTemplate;
	}

	
	private String loadMailTemplate(String templatePath) {
		StringBuilder sb = new StringBuilder();
		try (InputStream is = this.getClass().getResourceAsStream(templatePath)) {
			if (is == null)
				throw new IOException(templatePath + " no se halla como recurso");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + System.lineSeparator());
			}
			return sb.toString();

		} catch (IOException e) {
			throw new MailerInitializationException("Error al cargar el template de mail", e);
		}
	}

	
	private String getHtmlNiubizSection() {
		String htmlNiubiz="";
		if (request.getHtmlNiubiz().equals("1")) {
			checkAutorizacionData();
			String mod_plan = "<strong>Modalidad:</strong>" + request.getCampania() + "<br>\r\n"
					+ "<strong>Plan:</strong>" + request.getPlan() + "<br>\r\n";
			
			if (request.getTipoProd().equalsIgnoreCase("Accesorios-Ventas")) {
				mod_plan = "";
			}			
			htmlNiubiz="<p>Estos son los datos de tu compra: </p>\r\n" + "<strong>ID Transaccion:</strong>"
					+ request.getPurchaseNumber() + "<br>\r\n" + "<strong>Nombre:</strong>" + request.getFormNombre()
					+ "<br>\r\n" + "<strong>Pedido:</strong>" + request.getEquipo() + "<br>\r\n"
					+ mod_plan
					+ "<strong>Monto:</strong>" + autorizacion.get("dataMap").get("AMOUNT").asText() + "<br>\r\n"
					+ "<strong>Tarjeta:</strong>" + autorizacion.get("dataMap").get("CARD").asText() + " ("
					+ autorizacion.get("dataMap").get("BRAND").asText() + ")<br> \r\n"
					+ "<strong>Fecha de Pedido:</strong>"
					+ Util.formatDate(autorizacion.get("dataMap").get("TRANSACTION_DATE").asText()) + "<br>\r\n"
					+ "<strong>Direccion de entrega:</strong>" + getDireccionCompleta() + "<br>";

		}
		return htmlNiubiz;
	}
	
	private void checkAutorizacionData() {
		if(!autorizacion.has("dataMap")) {
			throw new MailerInitializationException("El objeto autorizacion no contiene los campos para generar el mensaje");
		}
	}
	
	
}
