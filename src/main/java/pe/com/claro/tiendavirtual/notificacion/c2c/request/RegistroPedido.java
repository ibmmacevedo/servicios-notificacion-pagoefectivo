package pe.com.claro.tiendavirtual.notificacion.c2c.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegistroPedido {

	@JsonProperty("form_id")
	private String formId;
	@JsonProperty("form_nombre")
	private String formNombre;
	@JsonProperty("form_tipo_doc")
	private String formTipoDoc; 
	@JsonProperty("form_num_doc")
	private String formNumDoc;
	@JsonProperty("form_num_tel_1")
	private String formNumTel1;
	@JsonProperty("form_num_tel_2")
	private String formNumTel2;
	@JsonProperty("form_horario")
	private String formHorario;
	@JsonProperty("form_email")
	private String formEmail;
	@JsonProperty("form_departamento")
	private String formDepartamento;
	@JsonProperty("form_provincia")
	private String formProvincia;
	@JsonProperty("form_tarjeta")
	private String formTarjeta;
	@JsonProperty("tipo_despacho")
	private String tipoDespacho;
	@JsonProperty("form_pedido")
	private String formPedido; 
	@JsonProperty("form_num_pedido")
	private String formNumPedido;
	@JsonProperty("form_datetime")
	private Date formDatetime;
	@JsonProperty("fam_id")
	private Integer famId; 
	@JsonProperty("form_bambulytics")
	private String formBambulytics; 
	private String campania;
	@JsonProperty("form_distrito")
	private String formDistrito;
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
	private String familia;
	@JsonProperty("pi_id")
	private String piId;
	@JsonProperty("tipo_prod")
	private String tipoProd;
	@JsonProperty("form_direccion")
	private String formDireccion;
	@JsonProperty("name_empresa")
	private String nameEmpresa;
	@JsonProperty("empresa_comi")
	private String empresaComi;
	@JsonProperty("total_precio")
	private Double totalPrecio;
	@JsonProperty("tlf_portab")
	private String tlfPortab;
	@JsonProperty("emp_portab")
	private String empPortab;
	private String purchaseNumber;
	@JsonProperty("active_cupon")
	private Integer activeCupon;
	@JsonProperty("html_niubiz")
	private String htmlNiubiz;
	@JsonProperty("precio_niubiz")
	private Double precioNiubiz; 
	private String transactionId;
	@JsonProperty("transaction_token")
	private String transactionToken;
	@JsonProperty("zform_id")
	private Integer zFormId;
	
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public String getFormNombre() {
		return formNombre;
	}
	public void setFormNombre(String formNombre) {
		this.formNombre = formNombre;
	}
	public String getFormTipoDoc() {
		return formTipoDoc;
	}
	public void setFormTipoDoc(String formTipoDoc) {
		this.formTipoDoc = formTipoDoc;
	}
	public String getFormNumDoc() {
		return formNumDoc;
	}
	public void setFormNumDoc(String formNumDoc) {
		this.formNumDoc = formNumDoc;
	}
	public String getFormNumTel1() {
		return formNumTel1;
	}
	public void setFormNumTel1(String formNumTel1) {
		this.formNumTel1 = formNumTel1;
	}
	public String getFormNumTel2() {
		return formNumTel2;
	}
	public void setFormNumTel2(String formNumTel2) {
		this.formNumTel2 = formNumTel2;
	}
	public String getFormHorario() {
		return formHorario;
	}
	public void setFormHorario(String formHorario) {
		this.formHorario = formHorario;
	}
	public String getFormEmail() {
		return formEmail;
	}
	public void setFormEmail(String formEmail) {
		this.formEmail = formEmail;
	}
	public String getFormDepartamento() {
		return formDepartamento;
	}
	public void setFormDepartamento(String formDepartamento) {
		this.formDepartamento = formDepartamento;
	}
	public String getFormProvincia() {
		return formProvincia;
	}
	public void setFormProvincia(String formProvincia) {
		this.formProvincia = formProvincia;
	}
	public String getFormTarjeta() {
		return formTarjeta;
	}
	public void setFormTarjeta(String formTarjeta) {
		this.formTarjeta = formTarjeta;
	}
	public String getTipoDespacho() {
		return tipoDespacho;
	}
	public void setTipoDespacho(String tipoDespacho) {
		this.tipoDespacho = tipoDespacho;
	}
	public String getFormPedido() {
		return formPedido;
	}
	public void setFormPedido(String formPedido) {
		this.formPedido = formPedido;
	}
	public String getFormNumPedido() {
		return formNumPedido;
	}
	public void setFormNumPedidoo(String formNumPedido) {
		this.formNumPedido = formNumPedido;
	}
	public Date getFormDatetime() {
		return formDatetime;
	}
	public void setFormDatetime(Date formDatetime) {
		this.formDatetime = formDatetime;
	}
	public Integer getFamId() {
		return famId;
	}
	public void setFamId(Integer famId) {
		this.famId = famId;
	}
	public String getFormBambulytics() {
		return formBambulytics;
	}
	public void setFormBambulytics(String formBambulytics) {
		this.formBambulytics = formBambulytics;
	}
	public String getCampania() {
		return campania;
	}
	public void setCampania(String campania) {
		this.campania = campania;
	}
	public String getFormDistrito() {
		return formDistrito;
	}
	public void setFormDistrito(String formDistrito) {
		this.formDistrito = formDistrito;
	}
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
	public String getFamilia() {
		return familia;
	}
	public void setFamilia(String familia) {
		this.familia = familia;
	}
	public String getPiId() {
		return piId;
	}
	public void setPiId(String piId) {
		this.piId = piId;
	}
	public String getTipoProd() {
		return tipoProd;
	}
	public void setTipoProd(String tipoProd) {
		this.tipoProd = tipoProd;
	}
	public String getFormDireccion() {
		return formDireccion;
	}
	public void setFormDireccion(String formDireccion) {
		this.formDireccion = formDireccion;
	}
	public String getNameEmpresa() {
		return nameEmpresa;
	}
	public void setNameEmpresa(String nameEmpresa) {
		this.nameEmpresa = nameEmpresa;
	}
	public String getEmpresaComi() {
		return empresaComi;
	}
	public void setEmpresaComi(String empresaComi) {
		this.empresaComi = empresaComi;
	}
	public Double getTotalPrecio() {
		return totalPrecio;
	}
	public void setTotalPrecio(Double totalPrecio) {
		this.totalPrecio = totalPrecio;
	}
	public String getTlfPortab() {
		return tlfPortab;
	}
	public void setTlfPortab(String tlfPortab) {
		this.tlfPortab = tlfPortab;
	}
	public String getEmpPortab() {
		return empPortab;
	}
	public void setEmpPortab(String empPortab) {
		this.empPortab = empPortab;
	}
	public String getPurchaseNumber() {
		return purchaseNumber;
	}
	public void setPurchaseNumber(String purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}
	public Integer getActiveCupon() {
		return activeCupon;
	}
	public void setActiveCupon(Integer activeCupon) {
		this.activeCupon = activeCupon;
	}
	public String getHtmlNiubiz() {
		return htmlNiubiz;
	}
	public void setHtmlNiubiz(String htmlNiubiz) {
		this.htmlNiubiz = htmlNiubiz;
	}
	public Double getPrecioNiubiz() {
		return precioNiubiz;
	}
	public void setPrecioNiubiz(Double precioNiubiz) {
		this.precioNiubiz = precioNiubiz;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionToken() {
		return transactionToken;
	}
	public void setTransactionToken(String transactionToken) {
		this.transactionToken = transactionToken;
	}
	public Integer getzFormId() {
		return zFormId;
	}
	public void setzFormId(Integer zFormId) {
		this.zFormId = zFormId;
	}
	public void setFormNumPedido(String formNumPedido) {
		this.formNumPedido = formNumPedido;
	}
	
}
