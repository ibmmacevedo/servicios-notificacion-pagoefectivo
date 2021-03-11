package pe.com.claro.tiendavirtual.notificacion.c2cnotifier.config;

import pe.com.claro.tiendavirtual.notificacion.c2cnotifier.CallCenterNotifier;

public interface NotifierFactory {

	CallCenterNotifier getNotifier(String c2c);
}
