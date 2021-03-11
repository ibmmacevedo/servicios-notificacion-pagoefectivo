package pe.com.claro.tiendavirtual.notificacion.repository.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@NamedStoredProcedureQuery(name = Auditoria.SP_INSERTAR_AUDITORIA, procedureName = Auditoria.SP_INSERTAR_AUDITORIA, parameters = {
		@StoredProcedureParameter(name = "aud_nombre", type = String.class, mode = ParameterMode.IN),
		@StoredProcedureParameter(name = "aud_email", type = String.class, mode = ParameterMode.IN),
		@StoredProcedureParameter(name = "aud_tipo_prod", type = String.class, mode = ParameterMode.IN),
		@StoredProcedureParameter(name = "aud_form_id", type = Integer.class, mode = ParameterMode.IN),
		@StoredProcedureParameter(name = "aud_pucharsenumber", type = Integer.class, mode = ParameterMode.IN),
		@StoredProcedureParameter(name = "aud_tipo", type = String.class, mode = ParameterMode.IN),
		@StoredProcedureParameter(name = "aud_log", type = String.class, mode = ParameterMode.IN),

		@StoredProcedureParameter(name = "PO_COD_RESPUESTA", type = Integer.class, mode = ParameterMode.OUT),
		@StoredProcedureParameter(name = "PO_MENSAJE_RESPUESTA", type = String.class, mode = ParameterMode.OUT),
		@StoredProcedureParameter(name = "PO_ID", type = Integer.class, mode = ParameterMode.OUT) })

@Entity
public class Auditoria implements Serializable {
	
	public static final String SP_INSERTAR_AUDITORIA = "INSERTAR_AUDITORIA";

	private static final long serialVersionUID = 1L;

	public Auditoria() {
	}

	@Id
	private Integer codigo;
	private String mensaje;
	private Integer resultado;

	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Integer getResultado() {
		return resultado;
	}
	public void setResultado(Integer resultado) {
		this.resultado = resultado;
	}
}
