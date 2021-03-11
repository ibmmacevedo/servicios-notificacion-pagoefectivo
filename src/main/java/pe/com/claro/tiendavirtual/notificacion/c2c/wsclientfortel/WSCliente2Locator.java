/**
 * WSCliente2Locator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.claro.tiendavirtual.notificacion.c2c.wsclientfortel;


public class WSCliente2Locator extends org.apache.axis.client.Service implements pe.com.claro.tiendavirtual.notificacion.c2c.wsclientfortel.WSCliente2 {

    private WSCliente2Locator() {
    }

    public WSCliente2Locator(String wsUrl) {
    	BasicHttpBinding_IWSCliente2_address=wsUrl;
    }


    public WSCliente2Locator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSCliente2Locator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_IWSCliente2
    private java.lang.String BasicHttpBinding_IWSCliente2_address;

    public java.lang.String getBasicHttpBinding_IWSCliente2Address() {
        return BasicHttpBinding_IWSCliente2_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBinding_IWSCliente2WSDDServiceName = "BasicHttpBinding_IWSCliente2";

    public java.lang.String getBasicHttpBinding_IWSCliente2WSDDServiceName() {
        return BasicHttpBinding_IWSCliente2WSDDServiceName;
    }

    public void setBasicHttpBinding_IWSCliente2WSDDServiceName(java.lang.String name) {
        BasicHttpBinding_IWSCliente2WSDDServiceName = name;
    }

    public pe.com.claro.tiendavirtual.notificacion.c2c.wsclientfortel.IWSCliente2 getBasicHttpBinding_IWSCliente2() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_IWSCliente2_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_IWSCliente2(endpoint);
    }

    public pe.com.claro.tiendavirtual.notificacion.c2c.wsclientfortel.IWSCliente2 getBasicHttpBinding_IWSCliente2(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            pe.com.claro.tiendavirtual.notificacion.c2c.wsclientfortel.BasicHttpBinding_IWSCliente2Stub _stub = new pe.com.claro.tiendavirtual.notificacion.c2c.wsclientfortel.BasicHttpBinding_IWSCliente2Stub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_IWSCliente2WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_IWSCliente2EndpointAddress(java.lang.String address) {
        BasicHttpBinding_IWSCliente2_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (pe.com.claro.tiendavirtual.notificacion.c2c.wsclientfortel.IWSCliente2.class.isAssignableFrom(serviceEndpointInterface)) {
                pe.com.claro.tiendavirtual.notificacion.c2c.wsclientfortel.BasicHttpBinding_IWSCliente2Stub _stub = new pe.com.claro.tiendavirtual.notificacion.c2c.wsclientfortel.BasicHttpBinding_IWSCliente2Stub(new java.net.URL(BasicHttpBinding_IWSCliente2_address), this);
                _stub.setPortName(getBasicHttpBinding_IWSCliente2WSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BasicHttpBinding_IWSCliente2".equals(inputPortName)) {
            return getBasicHttpBinding_IWSCliente2();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "WSCliente2");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "BasicHttpBinding_IWSCliente2"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_IWSCliente2".equals(portName)) {
            setBasicHttpBinding_IWSCliente2EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
