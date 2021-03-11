/**
 * Pedido.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.claro.tiendavirtual.notificacion.c2c.wsclientfortel;


public class Pedido implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private java.lang.String acuerdo;

	private java.lang.Integer cliente;

	private java.lang.String comoPago;

	private java.lang.String equipo;

	private java.lang.String familia;

	private java.lang.String lista;

	private java.lang.String plan;

	private java.lang.String precio;

	private java.lang.String precioPlan;

	private java.lang.String precioPromocional;
	
	private final static String SCHEMA="http://schemas.datacontract.org/2004/07/ClaroC2CWS";


	public Pedido() {
	}

	public Pedido(java.lang.String acuerdo, java.lang.Integer cliente, java.lang.String comoPago,
			java.lang.String equipo, java.lang.String familia, java.lang.String lista, java.lang.String plan,
			java.lang.String precio, java.lang.String precioPlan, java.lang.String precioPromocional) {
		this.acuerdo = acuerdo;
		this.cliente = cliente;
		this.comoPago = comoPago;
		this.equipo = equipo;
		this.familia = familia;
		this.lista = lista;
		this.plan = plan;
		this.precio = precio;
		this.precioPlan = precioPlan;
		this.precioPromocional = precioPromocional;
	}

	/**
	 * Gets the acuerdo value for this Pedido.
	 * 
	 * @return acuerdo
	 */
	public java.lang.String getAcuerdo() {
		return acuerdo;
	}

	/**
	 * Sets the acuerdo value for this Pedido.
	 * 
	 * @param acuerdo
	 */
	public void setAcuerdo(java.lang.String acuerdo) {
		this.acuerdo = acuerdo;
	}

	/**
	 * Gets the cliente value for this Pedido.
	 * 
	 * @return cliente
	 */
	public java.lang.Integer getCliente() {
		return cliente;
	}

	/**
	 * Sets the cliente value for this Pedido.
	 * 
	 * @param cliente
	 */
	public void setCliente(java.lang.Integer cliente) {
		this.cliente = cliente;
	}

	/**
	 * Gets the comoPago value for this Pedido.
	 * 
	 * @return comoPago
	 */
	public java.lang.String getComoPago() {
		return comoPago;
	}

	/**
	 * Sets the comoPago value for this Pedido.
	 * 
	 * @param comoPago
	 */
	public void setComoPago(java.lang.String comoPago) {
		this.comoPago = comoPago;
	}

	/**
	 * Gets the equipo value for this Pedido.
	 * 
	 * @return equipo
	 */
	public java.lang.String getEquipo() {
		return equipo;
	}

	/**
	 * Sets the equipo value for this Pedido.
	 * 
	 * @param equipo
	 */
	public void setEquipo(java.lang.String equipo) {
		this.equipo = equipo;
	}

	/**
	 * Gets the familia value for this Pedido.
	 * 
	 * @return familia
	 */
	public java.lang.String getFamilia() {
		return familia;
	}

	/**
	 * Sets the familia value for this Pedido.
	 * 
	 * @param familia
	 */
	public void setFamilia(java.lang.String familia) {
		this.familia = familia;
	}

	/**
	 * Gets the lista value for this Pedido.
	 * 
	 * @return lista
	 */
	public java.lang.String getLista() {
		return lista;
	}

	/**
	 * Sets the lista value for this Pedido.
	 * 
	 * @param lista
	 */
	public void setLista(java.lang.String lista) {
		this.lista = lista;
	}

	/**
	 * Gets the plan value for this Pedido.
	 * 
	 * @return plan
	 */
	public java.lang.String getPlan() {
		return plan;
	}

	/**
	 * Sets the plan value for this Pedido.
	 * 
	 * @param plan
	 */
	public void setPlan(java.lang.String plan) {
		this.plan = plan;
	}

	/**
	 * Gets the precio value for this Pedido.
	 * 
	 * @return precio
	 */
	public java.lang.String getPrecio() {
		return precio;
	}

	/**
	 * Sets the precio value for this Pedido.
	 * 
	 * @param precio
	 */
	public void setPrecio(java.lang.String precio) {
		this.precio = precio;
	}

	/**
	 * Gets the precioPlan value for this Pedido.
	 * 
	 * @return precioPlan
	 */
	public java.lang.String getPrecioPlan() {
		return precioPlan;
	}

	/**
	 * Sets the precioPlan value for this Pedido.
	 * 
	 * @param precioPlan
	 */
	public void setPrecioPlan(java.lang.String precioPlan) {
		this.precioPlan = precioPlan;
	}

	/**
	 * Gets the precioPromocional value for this Pedido.
	 * 
	 * @return precioPromocional
	 */
	public java.lang.String getPrecioPromocional() {
		return precioPromocional;
	}

	/**
	 * Sets the precioPromocional value for this Pedido.
	 * 
	 * @param precioPromocional
	 */
	public void setPrecioPromocional(java.lang.String precioPromocional) {
		this.precioPromocional = precioPromocional;
	}

	private java.lang.Object __equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof Pedido))
			return false;
		Pedido other = (Pedido) obj;
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
				&& ((this.acuerdo == null && other.getAcuerdo() == null)
						|| (this.acuerdo != null && this.acuerdo.equals(other.getAcuerdo())))
				&& ((this.cliente == null && other.getCliente() == null)
						|| (this.cliente != null && this.cliente.equals(other.getCliente())))
				&& ((this.comoPago == null && other.getComoPago() == null)
						|| (this.comoPago != null && this.comoPago.equals(other.getComoPago())))
				&& ((this.equipo == null && other.getEquipo() == null)
						|| (this.equipo != null && this.equipo.equals(other.getEquipo())))
				&& ((this.familia == null && other.getFamilia() == null)
						|| (this.familia != null && this.familia.equals(other.getFamilia())))
				&& ((this.lista == null && other.getLista() == null)
						|| (this.lista != null && this.lista.equals(other.getLista())))
				&& ((this.plan == null && other.getPlan() == null)
						|| (this.plan != null && this.plan.equals(other.getPlan())))
				&& ((this.precio == null && other.getPrecio() == null)
						|| (this.precio != null && this.precio.equals(other.getPrecio())))
				&& ((this.precioPlan == null && other.getPrecioPlan() == null)
						|| (this.precioPlan != null && this.precioPlan.equals(other.getPrecioPlan())))
				&& ((this.precioPromocional == null && other.getPrecioPromocional() == null)
						|| (this.precioPromocional != null
								&& this.precioPromocional.equals(other.getPrecioPromocional())));
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
		if (getAcuerdo() != null) {
			_hashCode += getAcuerdo().hashCode();
		}
		if (getCliente() != null) {
			_hashCode += getCliente().hashCode();
		}
		if (getComoPago() != null) {
			_hashCode += getComoPago().hashCode();
		}
		if (getEquipo() != null) {
			_hashCode += getEquipo().hashCode();
		}
		if (getFamilia() != null) {
			_hashCode += getFamilia().hashCode();
		}
		if (getLista() != null) {
			_hashCode += getLista().hashCode();
		}
		if (getPlan() != null) {
			_hashCode += getPlan().hashCode();
		}
		if (getPrecio() != null) {
			_hashCode += getPrecio().hashCode();
		}
		if (getPrecioPlan() != null) {
			_hashCode += getPrecioPlan().hashCode();
		}
		if (getPrecioPromocional() != null) {
			_hashCode += getPrecioPromocional().hashCode();
		}
		__hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
			Pedido.class, true);

	static {
		typeDesc.setXmlType(
				new javax.xml.namespace.QName(SCHEMA, "Pedido"));
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("acuerdo");
		elemField.setXmlName(
				new javax.xml.namespace.QName(SCHEMA, "Acuerdo"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("cliente");
		elemField.setXmlName(
				new javax.xml.namespace.QName(SCHEMA, "Cliente"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("comoPago");
		elemField.setXmlName(
				new javax.xml.namespace.QName(SCHEMA, "ComoPago"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("equipo");
		elemField.setXmlName(
				new javax.xml.namespace.QName(SCHEMA, "Equipo"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("familia");
		elemField.setXmlName(
				new javax.xml.namespace.QName(SCHEMA, "Familia"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("lista");
		elemField.setXmlName(
				new javax.xml.namespace.QName(SCHEMA, "Lista"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("plan");
		elemField.setXmlName(
				new javax.xml.namespace.QName(SCHEMA, "Plan"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("precio");
		elemField.setXmlName(
				new javax.xml.namespace.QName(SCHEMA, "Precio"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("precioPlan");
		elemField.setXmlName(
				new javax.xml.namespace.QName(SCHEMA, "PrecioPlan"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("precioPromocional");
		elemField.setXmlName(new javax.xml.namespace.QName(SCHEMA,
				"PrecioPromocional"));
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
