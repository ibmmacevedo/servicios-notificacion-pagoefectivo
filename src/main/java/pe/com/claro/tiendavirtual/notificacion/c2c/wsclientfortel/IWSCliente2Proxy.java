package pe.com.claro.tiendavirtual.notificacion.c2c.wsclientfortel;

public class IWSCliente2Proxy implements pe.com.claro.tiendavirtual.notificacion.c2c.wsclientfortel.IWSCliente2 {
  private String _endpoint = null;
  private pe.com.claro.tiendavirtual.notificacion.c2c.wsclientfortel.IWSCliente2 iWSCliente2 = null;
  
  private IWSCliente2Proxy() {
    _initIWSCliente2Proxy();
  }
  
  public IWSCliente2Proxy(String endpoint) {
    _endpoint = endpoint;
    _initIWSCliente2Proxy();
  }
  
  private void _initIWSCliente2Proxy() {
    try {
      iWSCliente2 = (new pe.com.claro.tiendavirtual.notificacion.c2c.wsclientfortel.WSCliente2Locator(_endpoint)).getBasicHttpBinding_IWSCliente2();
      if (iWSCliente2 != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iWSCliente2)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iWSCliente2)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iWSCliente2 != null)
      ((javax.xml.rpc.Stub)iWSCliente2)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public pe.com.claro.tiendavirtual.notificacion.c2c.wsclientfortel.IWSCliente2 getIWSCliente2() {
    if (iWSCliente2 == null)
      _initIWSCliente2Proxy();
    return iWSCliente2;
  }
  
  public java.lang.String agregarCliente(Cliente2 cliente) throws java.rmi.RemoteException{
    if (iWSCliente2 == null)
      _initIWSCliente2Proxy();
    return iWSCliente2.agregarCliente(cliente);
  }
  
  
}