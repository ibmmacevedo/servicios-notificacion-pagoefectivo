package pe.com.claro.tiendavirtual.notificacion.repository.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Paquete implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private String equipo;
    private Double precio;
    @JsonProperty("precio_promocional")
    private Double precioPromocional;
    private String plan;
    @JsonProperty("precio_plan")
    private Double precioPlan;
    @JsonProperty("como_pago")
    private String comoPago;
    private String acuerdo;
    private String campania;
    private String familia;
    
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Double getPrecioPromocional() {
		return precioPromocional;
	}
	public void setPrecioPromocional(Double precioPromocional) {
		this.precioPromocional = precioPromocional;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public Double getPrecioPlan() {
		return precioPlan;
	}
	public void setPrecioPlan(Double precioPlan) {
		this.precioPlan = precioPlan;
	}
	public String getComoPago() {
		return comoPago;
	}
	public void setComoPago(String comoPago) {
		this.comoPago = comoPago;
	}
	public String getAcuerdo() {
		return acuerdo;
	}
	public void setAcuerdo(String acuerdo) {
		this.acuerdo = acuerdo;
	}
	public String getCampania() {
		return campania;
	}
	public void setCampania(String campania) {
		this.campania = campania;
	}
	public String getFamilia() {
		return familia;
	}
	public void setFamilia(String familia) {
		this.familia = familia;
	}
}

