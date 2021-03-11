/**
 * Cliente2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.claro.tiendavirtual.notificacion.c2c.wsclientfortel;



public class Cliente2 implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private java.lang.String campania;

	private java.lang.String departamento;

	private java.lang.String distrito;

	private java.lang.String dni;

	private java.lang.String id;

	private java.lang.String nombres;

	private Pedido[] pedido;

	private java.lang.String provincia;

	private java.lang.String tarjeta;

	private java.lang.String telefono1;

	private java.lang.String telefono2;

	private java.lang.String tipo_despacho;

	private java.lang.String utm;
	
	private final static String SCHEMA="http://schemas.datacontract.org/2004/07/ClaroC2CWS";

	public Cliente2() {
	}

	public Cliente2(java.lang.String campania, java.lang.String departamento, java.lang.String distrito,
			java.lang.String dni, java.lang.String id, java.lang.String nombres,
			Pedido[] pedido, java.lang.String provincia,
			java.lang.String tarjeta, java.lang.String telefono1, java.lang.String telefono2,
			java.lang.String tipo_despacho, java.lang.String utm) {
		this.campania = campania;
		this.departamento = departamento;
		this.distrito = distrito;
		this.dni = dni;
		this.id = id;
		this.nombres = nombres;
		this.pedido = pedido;
		this.provincia = provincia;
		this.tarjeta = tarjeta;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.tipo_despacho = tipo_despacho;
		this.utm = utm;
	}

	/**
	 * Gets the campania value for this Cliente2.
	 * 
	 * @return campania
	 */
	public java.lang.String getCampania() {
		return campania;
	}

	/**
	 * Sets the campania value for this Cliente2.
	 * 
	 * @param campania
	 */
	public void setCampania(java.lang.String campania) {
		this.campania = campania;
	}

	/**
	 * Gets the departamento value for this Cliente2.
	 * 
	 * @return departamento
	 */
	public java.lang.String getDepartamento() {
		return departamento;
	}

	/**
	 * Sets the departamento value for this Cliente2.
	 * 
	 * @param departamento
	 */
	public void setDepartamento(java.lang.String departamento) {
		this.departamento = departamento;
	}

	/**
	 * Gets the distrito value for this Cliente2.
	 * 
	 * @return distrito
	 */
	public java.lang.String getDistrito() {
		return distrito;
	}

	/**
	 * Sets the distrito value for this Cliente2.
	 * 
	 * @param distrito
	 */
	public void setDistrito(java.lang.String distrito) {
		this.distrito = distrito;
	}

	/**
	 * Gets the dni value for this Cliente2.
	 * 
	 * @return dni
	 */
	public java.lang.String getDni() {
		return dni;
	}

	/**
	 * Sets the dni value for this Cliente2.
	 * 
	 * @param dni
	 */
	public void setDni(java.lang.String dni) {
		this.dni = dni;
	}

	/**
	 * Gets the id value for this Cliente2.
	 * 
	 * @return id
	 */
	public java.lang.String getId() {
		return id;
	}

	/**
	 * Sets the id value for this Cliente2.
	 * 
	 * @param id
	 */
	public void setId(java.lang.String id) {
		this.id = id;
	}

	/**
	 * Gets the nombres value for this Cliente2.
	 * 
	 * @return nombres
	 */
	public java.lang.String getNombres() {
		return nombres;
	}

	/**
	 * Sets the nombres value for this Cliente2.
	 * 
	 * @param nombres
	 */
	public void setNombres(java.lang.String nombres) {
		this.nombres = nombres;
	}

	/**
	 * Gets the pedido value for this Cliente2.
	 * 
	 * @return pedido
	 */
	public Pedido[] getPedido() {
		return pedido;
	}

	/**
	 * Sets the pedido value for this Cliente2.
	 * 
	 * @param pedido
	 */
	public void setPedido(Pedido[] pedido) {
		this.pedido = pedido;
	}

	/**
	 * Gets the provincia value for this Cliente2.
	 * 
	 * @return provincia
	 */
	public java.lang.String getProvincia() {
		return provincia;
	}

	/**
	 * Sets the provincia value for this Cliente2.
	 * 
	 * @param provincia
	 */
	public void setProvincia(java.lang.String provincia) {
		this.provincia = provincia;
	}

	/**
	 * Gets the tarjeta value for this Cliente2.
	 * 
	 * @return tarjeta
	 */
	public java.lang.String getTarjeta() {
		return tarjeta;
	}

	/**
	 * Sets the tarjeta value for this Cliente2.
	 * 
	 * @param tarjeta
	 */
	public void setTarjeta(java.lang.String tarjeta) {
		this.tarjeta = tarjeta;
	}

	/**
	 * Gets the telefono1 value for this Cliente2.
	 * 
	 * @return telefono1
	 */
	public java.lang.String getTelefono1() {
		return telefono1;
	}

	/**
	 * Sets the telefono1 value for this Cliente2.
	 * 
	 * @param telefono1
	 */
	public void setTelefono1(java.lang.String telefono1) {
		this.telefono1 = telefono1;
	}

	/**
	 * Gets the telefono2 value for this Cliente2.
	 * 
	 * @return telefono2
	 */
	public java.lang.String getTelefono2() {
		return telefono2;
	}

	/**
	 * Sets the telefono2 value for this Cliente2.
	 * 
	 * @param telefono2
	 */
	public void setTelefono2(java.lang.String telefono2) {
		this.telefono2 = telefono2;
	}

	/**
	 * Gets the tipo_despacho value for this Cliente2.
	 * 
	 * @return tipo_despacho
	 */
	public java.lang.String getTipo_despacho() {
		return tipo_despacho;
	}

	/**
	 * Sets the tipo_despacho value for this Cliente2.
	 * 
	 * @param tipo_despacho
	 */
	public void setTipo_despacho(java.lang.String tipo_despacho) {
		this.tipo_despacho = tipo_despacho;
	}

	/**
	 * Gets the utm value for this Cliente2.
	 * 
	 * @return utm
	 */
	public java.lang.String getUtm() {
		return utm;
	}

	/**
	 * Sets the utm value for this Cliente2.
	 * 
	 * @param utm
	 */
	public void setUtm(java.lang.String utm) {
		this.utm = utm;
	}

	private java.lang.Object __equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof Cliente2))
			return false;
		Cliente2 other = (Cliente2) obj;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (__equalsCalc != null) {
			return (__equalsCalc == obj);
		}
		__equalsCalc = obj;
		boolean _equals;
		_equals = true
				&& ((this.campania == null && other.getCampania() == null)
						|| (this.campania != null && this.campania.equals(other.getCampania())))
				&& ((this.departamento == null && other.getDepartamento() == null)
						|| (this.departamento != null && this.departamento.equals(other.getDepartamento())))
				&& ((this.distrito == null && other.getDistrito() == null)
						|| (this.distrito != null && this.distrito.equals(other.getDistrito())))
				&& ((this.dni == null && other.getDni() == null)
						|| (this.dni != null && this.dni.equals(other.getDni())))
				&& ((this.id == null && other.getId() == null) || (this.id != null && this.id.equals(other.getId())))
				&& ((this.nombres == null && other.getNombres() == null)
						|| (this.nombres != null && this.nombres.equals(other.getNombres())))
				&& ((this.pedido == null && other.getPedido() == null)
						|| (this.pedido != null && java.util.Arrays.equals(this.pedido, other.getPedido())))
				&& ((this.provincia == null && other.getProvincia() == null)
						|| (this.provincia != null && this.provincia.equals(other.getProvincia())))
				&& ((this.tarjeta == null && other.getTarjeta() == null)
						|| (this.tarjeta != null && this.tarjeta.equals(other.getTarjeta())))
				&& ((this.telefono1 == null && other.getTelefono1() == null)
						|| (this.telefono1 != null && this.telefono1.equals(other.getTelefono1())))
				&& ((this.telefono2 == null && other.getTelefono2() == null)
						|| (this.telefono2 != null && this.telefono2.equals(other.getTelefono2())))
				&& ((this.tipo_despacho == null && other.getTipo_despacho() == null)
						|| (this.tipo_despacho != null && this.tipo_despacho.equals(other.getTipo_despacho())))
				&& ((this.utm == null && other.getUtm() == null)
						|| (this.utm != null && this.utm.equals(other.getUtm())));
		__equalsCalc = null;
		return _equals;
	}

	private boolean __hashCodeCalc = false;

	public synchronized int hashCode() {
		if (__hashCodeCalc) {
			return 0;
		}
		__hashCodeCalc = true;
		int _hashCode = 1;
		if (getCampania() != null) {
			_hashCode += getCampania().hashCode();
		}
		if (getDepartamento() != null) {
			_hashCode += getDepartamento().hashCode();
		}
		if (getDistrito() != null) {
			_hashCode += getDistrito().hashCode();
		}
		if (getDni() != null) {
			_hashCode += getDni().hashCode();
		}
		if (getId() != null) {
			_hashCode += getId().hashCode();
		}
		if (getNombres() != null) {
			_hashCode += getNombres().hashCode();
		}
		if (getPedido() != null) {
			for (int i = 0; i < java.lang.reflect.Array.getLength(getPedido()); i++) {
				java.lang.Object obj = java.lang.reflect.Array.get(getPedido(), i);
				if (obj != null && !obj.getClass().isArray()) {
					_hashCode += obj.hashCode();
				}
			}
		}
		if (getProvincia() != null) {
			_hashCode += getProvincia().hashCode();
		}
		if (getTarjeta() != null) {
			_hashCode += getTarjeta().hashCode();
		}
		if (getTelefono1() != null) {
			_hashCode += getTelefono1().hashCode();
		}
		if (getTelefono2() != null) {
			_hashCode += getTelefono2().hashCode();
		}
		if (getTipo_despacho() != null) {
			_hashCode += getTipo_despacho().hashCode();
		}
		if (getUtm() != null) {
			_hashCode += getUtm().hashCode();
		}
		__hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
			Cliente2.class, true);

	static {
		typeDesc.setXmlType(
				new javax.xml.namespace.QName(SCHEMA, "Cliente2"));
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("campania");
		elemField.setXmlName(
				new javax.xml.namespace.QName(SCHEMA, "Campania"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("departamento");
		elemField.setXmlName(
				new javax.xml.namespace.QName(SCHEMA, "Departamento"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("distrito");
		elemField.setXmlName(
				new javax.xml.namespace.QName(SCHEMA, "Distrito"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("dni");
		elemField
				.setXmlName(new javax.xml.namespace.QName(SCHEMA, "Dni"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("id");
		elemField.setXmlName(new javax.xml.namespace.QName(SCHEMA, "Id"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("nombres");
		elemField.setXmlName(
				new javax.xml.namespace.QName(SCHEMA, "Nombres"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("pedido");
		elemField.setXmlName(
				new javax.xml.namespace.QName(SCHEMA, "Pedido"));
		elemField.setXmlType(
				new javax.xml.namespace.QName(SCHEMA, "Pedido"));
		elemField.setMinOccurs(0);
		elemField.setNillable(true);
		elemField.setItemQName(
				new javax.xml.namespace.QName(SCHEMA, "Pedido"));
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("provincia");
		elemField.setXmlName(
				new javax.xml.namespace.QName(SCHEMA, "Provincia"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("tarjeta");
		elemField.setXmlName(
				new javax.xml.namespace.QName(SCHEMA, "Tarjeta"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("telefono1");
		elemField.setXmlName(
				new javax.xml.namespace.QName(SCHEMA, "Telefono1"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("telefono2");
		elemField.setXmlName(
				new javax.xml.namespace.QName(SCHEMA, "Telefono2"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("tipo_despacho");
		elemField.setXmlName(
				new javax.xml.namespace.QName(SCHEMA, "Tipo_despacho"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("utm");
		elemField
				.setXmlName(new javax.xml.namespace.QName(SCHEMA, "Utm"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
	}

	/**
	 * Return type metadata object
	 */
	public static org.apache.axis.description.TypeDesc getTypeDesc() {
		return typeDesc;
	}

	/**
	 * Get Custom Serializer
	 */
	public static org.apache.axis.encoding.Serializer getSerializer(java.lang.String mechType,
			java.lang.Class _javaType, javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanSerializer(_javaType, _xmlType, typeDesc);
	}

	/**
	 * Get Custom Deserializer
	 */
	public static org.apache.axis.encoding.Deserializer getDeserializer(java.lang.String mechType,
			java.lang.Class _javaType, javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanDeserializer(_javaType, _xmlType, typeDesc);
	}

}
