/**
 * VideoLibraryManagementServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package services;

public class VideoLibraryManagementServiceLocator extends org.apache.axis.client.Service implements services.VideoLibraryManagementService {

    public VideoLibraryManagementServiceLocator() {
    }


    public VideoLibraryManagementServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public VideoLibraryManagementServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for VideoLibraryManagement
    private java.lang.String VideoLibraryManagement_address = "http://localhost:8080/svlm/services/VideoLibraryManagement";

    public java.lang.String getVideoLibraryManagementAddress() {
        return VideoLibraryManagement_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String VideoLibraryManagementWSDDServiceName = "VideoLibraryManagement";

    public java.lang.String getVideoLibraryManagementWSDDServiceName() {
        return VideoLibraryManagementWSDDServiceName;
    }

    public void setVideoLibraryManagementWSDDServiceName(java.lang.String name) {
        VideoLibraryManagementWSDDServiceName = name;
    }

    public services.VideoLibraryManagement getVideoLibraryManagement() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(VideoLibraryManagement_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getVideoLibraryManagement(endpoint);
    }

    public services.VideoLibraryManagement getVideoLibraryManagement(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            services.VideoLibraryManagementSoapBindingStub _stub = new services.VideoLibraryManagementSoapBindingStub(portAddress, this);
            _stub.setPortName(getVideoLibraryManagementWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setVideoLibraryManagementEndpointAddress(java.lang.String address) {
        VideoLibraryManagement_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (services.VideoLibraryManagement.class.isAssignableFrom(serviceEndpointInterface)) {
                services.VideoLibraryManagementSoapBindingStub _stub = new services.VideoLibraryManagementSoapBindingStub(new java.net.URL(VideoLibraryManagement_address), this);
                _stub.setPortName(getVideoLibraryManagementWSDDServiceName());
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
        if ("VideoLibraryManagement".equals(inputPortName)) {
            return getVideoLibraryManagement();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://services", "VideoLibraryManagementService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://services", "VideoLibraryManagement"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("VideoLibraryManagement".equals(portName)) {
            setVideoLibraryManagementEndpointAddress(address);
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
