package pe.com.claro.tiendavirtual.notificacion.repository;

import java.util.HashMap;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.claro.tiendavirtual.notificacion.repository.model.Auditoria;


@Repository
public interface AuditoriaRepository extends CrudRepository<Auditoria, Integer> {
	
	@Transactional
	@Procedure(name = "INSERTAR_AUDITORIA")
	public HashMap<String, ?> insertarAuditoria(
			@Param("aud_nombre") String nombre,
			@Param("aud_email") String email,
			@Param("aud_tipo_prod") String tipoProd,
			@Param("aud_form_id") Integer formId,
			@Param("aud_pucharsenumber") Integer pucharsenumber,
			@Param("aud_tipo") String tipo,
			@Param("aud_log") String log);

}
