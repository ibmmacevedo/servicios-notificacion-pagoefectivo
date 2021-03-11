package pe.com.claro.tiendavirtual.notificacion.messaging;

import com.fasterxml.jackson.annotation.JsonProperty;

import pe.com.claro.tiendavirtual.notificacion.c2c.request.RegistroPedido;

public class MessageDTO {
	
	private RegistroPedido request;
    private String autorizacion;
    @JsonProperty("dias_despacho")
    private Integer diasDespacho;
    public RegistroPedido getRequest() {
        return request;
    }
    public void setRequest(RegistroPedido request) {
        this.request = request;
    }
    public String getAutorizacion() {
        return autorizacion;
    }
    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }
    public Integer getDiasDespacho() {
        return diasDespacho;
    }
    public void setDiasDespacho(Integer diasDespacho) {
        this.diasDespacho = diasDespacho;
    }


}
