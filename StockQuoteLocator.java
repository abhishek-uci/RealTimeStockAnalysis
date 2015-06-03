/**
 * StockQuoteLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package NET.webserviceX.www;

public class StockQuoteLocator extends org.apache.axis.client.Service implements NET.webserviceX.www.StockQuote {

    public StockQuoteLocator() {
    }


    public StockQuoteLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public StockQuoteLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for StockQuoteSoap
    private java.lang.String StockQuoteSoap_address = "http://www.webservicex.net/stockquote.asmx";

    public java.lang.String getStockQuoteSoapAddress() {
        return StockQuoteSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String StockQuoteSoapWSDDServiceName = "StockQuoteSoap";

    public java.lang.String getStockQuoteSoapWSDDServiceName() {
        return StockQuoteSoapWSDDServiceName;
    }

    public void setStockQuoteSoapWSDDServiceName(java.lang.String name) {
        StockQuoteSoapWSDDServiceName = name;
    }

    public NET.webserviceX.www.StockQuoteSoap getStockQuoteSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(StockQuoteSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getStockQuoteSoap(endpoint);
    }

    public NET.webserviceX.www.StockQuoteSoap getStockQuoteSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            NET.webserviceX.www.StockQuoteSoapStub _stub = new NET.webserviceX.www.StockQuoteSoapStub(portAddress, this);
            _stub.setPortName(getStockQuoteSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setStockQuoteSoapEndpointAddress(java.lang.String address) {
        StockQuoteSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (NET.webserviceX.www.StockQuoteSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                NET.webserviceX.www.StockQuoteSoapStub _stub = new NET.webserviceX.www.StockQuoteSoapStub(new java.net.URL(StockQuoteSoap_address), this);
                _stub.setPortName(getStockQuoteSoapWSDDServiceName());
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
        if ("StockQuoteSoap".equals(inputPortName)) {
            return getStockQuoteSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.webserviceX.NET/", "StockQuote");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.webserviceX.NET/", "StockQuoteSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("StockQuoteSoap".equals(portName)) {
            setStockQuoteSoapEndpointAddress(address);
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
