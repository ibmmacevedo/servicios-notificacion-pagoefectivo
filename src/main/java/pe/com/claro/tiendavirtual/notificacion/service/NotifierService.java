package pe.com.claro.tiendavirtual.notificacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import pe.com.claro.tiendavirtual.notificacion.c2c.exception.CallCenterException;
import pe.com.claro.tiendavirtual.notificacion.c2c.request.C2CRequest;
import pe.com.claro.tiendavirtual.notificacion.c2c.request.RegistroPedido;
import pe.com.claro.tiendavirtual.notificacion.c2cnotifier.config.NotifierFactory;
import pe.com.claro.tiendavirtual.notificacion.mailing.Mailer;
import pe.com.claro.tiendavirtual.notificacion.mailing.exception.MailingException;
import pe.com.claro.tiendavirtual.notificacion.messaging.MessageDTO;
import pe.com.claro.tiendavirtual.notificacion.repository.C2CRepository;
import pe.com.claro.tiendavirtual.notificacion.repository.model.C2C;

@Service
public class NotifierService implements Notifier {

	@Autowired
	C2CRepository c2cRepo;

	@Autowired
	NotifierFactory notifierFactory;

	@Autowired
	Mailer mailer;

	@Override
	public void notifyToC2C(RegistroPedido request) {

		C2CRequest c2cRequest = getC2CRequest(request);
		notifierFactory.getNotifier(c2cRequest.getC2c()).notify(c2cRequest);

	}

	@Override
	public void notifyMail(MessageDTO messageDto) throws MailingException {
		mailer.sendMailPedido(messageDto);

	}

	private C2CRequest getC2CRequest(RegistroPedido request) {
		if (request.getPiId() == null && request.getzFormId() != null) {
			C2CRequest c2cRequest = new C2CRequest();
			c2cRequest.setPedidoRequest(request);
			c2cRequest.setC2c("F");
			c2cRequest.setCampaniaListaPrecio("");
			return c2cRequest;
		
		} else {
			try {
				String piId = request.getPiId();
				C2C c2c = c2cRepo.getC2C(piId);
				C2CRequest c2cRequest = new C2CRequest();
				c2cRequest.setPedidoRequest(request);
				c2cRequest.setC2c((request.getzFormId() != null)? "F": c2c.getC2c());
				c2cRequest.setCampaniaListaPrecio(c2c.getCampana());
				return c2cRequest;

			} catch (DataAccessException dae) {
				throw new CallCenterException("Error de consulta en BD ", dae);
			}
		}
	}

}
