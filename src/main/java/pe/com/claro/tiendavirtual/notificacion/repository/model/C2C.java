package pe.com.claro.tiendavirtual.notificacion.repository.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class C2C implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="item_id")
	private Integer itemId;
	@Column(name="c2c")
	private String c2c; 
	@Column(name="campana")
	private String campana;
	@Column(name="empresa_id")
	private Integer empresaId;
	@Column(name="cuota_inicial")
	private Double cuotaInicial;
	
	
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getC2c() {
		return c2c;
	}
	public void setC2c(String c2c) {
		this.c2c = c2c;
	}
	public String getCampana() {
		return campana;
	}
	public void setCampana(String campana) {
		this.campana = campana;
	}
	public Integer getEmpresaId() {
		return empresaId;
	}
	public void setEmpresaId(Integer empresaId) {
		this.empresaId = empresaId;
	}
	public Double getCuotaInicial() {
		return cuotaInicial;
	}
	public void setCuotaInicial(Double cuotaInicial) {
		this.cuotaInicial = cuotaInicial;
	}
	
	
	}
