package pe.com.claro.tiendavirtual.notificacion.c2c.request;

public class C2CRequest {
	
	private String id;
	private String c2c;
	private String pedido;
	private String campaniaListaPrecio;
	private RegistroPedido pedidoRequest;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getC2c() {
		return c2c;
	}
	public void setC2c(String c2c) {
		this.c2c = c2c;
	}
	public String getPedido() {
		return pedido;
	}
	public void setPedido(String pedido) {
		this.pedido = pedido;
	}
	public String getCampaniaListaPrecio() {
		return campaniaListaPrecio;
	}
	public void setCampaniaListaPrecio(String campaniaListaPrecio) {
		this.campaniaListaPrecio = campaniaListaPrecio;
	}
	public RegistroPedido getPedidoRequest() {
		return pedidoRequest;
	}
	public void setPedidoRequest(RegistroPedido pedidoRequest) {
		this.pedidoRequest = pedidoRequest;
	}
	
	

}
