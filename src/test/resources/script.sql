CREATE TABLE IF NOT EXISTS `auditoria` (
  `aud_fecha` datetime DEFAULT NULL,
  `aud_nombre` varchar(200) DEFAULT NULL,
  `aud_email` varchar(200) DEFAULT NULL,
  `aud_form_id` int(11) DEFAULT NULL,
  `aud_tipo_prod` varchar(200) DEFAULT NULL,
  `aud_pucharsenumber` int(11) DEFAULT NULL,
  `aud_tipo` varchar(100) DEFAULT NULL,
  `aud_log` varchar(8000)  DEFAULT NULL
) ;

CREATE ALIAS IF NOT EXISTS INSERTAR_AUDITORIA FOR "pe.com.claro.tiendavirtual.notificacion.h2.StoredProcedures.insertarAuditoria";
