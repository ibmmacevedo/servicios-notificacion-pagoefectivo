package pe.com.claro.tiendavirtual.notificacion.c2cnotifier.config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pe.com.claro.tiendavirtual.notificacion.c2c.exception.UnknownCallCenterException;

@Configuration
public class C2CNotifierConfig {
	
	
	@Bean("c2cNotifierFactory")
	  public FactoryBean serviceLocatorFactoryBean() {
		try {
	    ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
	    factoryBean.setServiceLocatorInterface(NotifierFactory.class);
	    return factoryBean;
	    }
		catch(UnsatisfiedDependencyException e) {
			throw new UnknownCallCenterException("No se pudo hallar la implementacion para el callcenter", e);
		}
	  }

}
