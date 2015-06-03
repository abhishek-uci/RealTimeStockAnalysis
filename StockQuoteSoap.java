/**
 * StockQuoteSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package NET.webserviceX.www;

public interface StockQuoteSoap extends java.rmi.Remote {

    /**
     * Get Stock quote for a company Symbol
     */
    public java.lang.String getQuote(java.lang.String symbol) throws java.rmi.RemoteException;
}
