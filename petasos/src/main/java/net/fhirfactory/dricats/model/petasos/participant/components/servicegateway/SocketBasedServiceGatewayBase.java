/*
 * The MIT License
 *
 * Copyright 2022 Mark A. Hunter.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.fhirfactory.dricats.model.petasos.participant.components.servicegateway;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mhunter
 */
public class SocketBasedServiceGatewayBase extends ServiceGatewayBase {
    private static final Logger LOG = LoggerFactory.getLogger(SocketBasedServiceGatewayBase.class);
    
    private String serviceDNSName;
    private String serviceHostIP;
    private String servicePort;
    
    //
    // Constructor(s)
    //
    
    public SocketBasedServiceGatewayBase(){
        super();
        this.serviceDNSName = null;
        this.serviceHostIP = null;
        this.servicePort = null;
    }
    
    //
    // Overridden Methods
    //
    
    @Override
    protected Logger getLogger(){
        return(LOG);
    }
    
    //
    // Getters and Setters
    //

    @JsonIgnore
    public boolean hasServiceDNSName(){
        boolean hasValue = this.serviceDNSName != null;
        return(hasValue);
    }
    
    public String getServiceDNSName() {
        return serviceDNSName;
    }

    public void setServiceDNSName(String serviceHostName) {
        this.serviceDNSName = serviceHostName;
    }
    
    @JsonIgnore
    public boolean hasServiceHostIP(){
        boolean hasValue = this.serviceHostIP != null;
        return(hasValue);
    }

    public String getServiceHostIP() {
        return serviceHostIP;
    }

    public void setServiceHostIP(String serviceHostIP) {
        this.serviceHostIP = serviceHostIP;
    }
    
    
    @JsonIgnore
    public boolean hasServicePort(){
        boolean hasValue = this.servicePort != null;
        return(hasValue);
    }

    public String getServicePort() {
        return servicePort;
    }

    public void setServicePort(String servicePort) {
        this.servicePort = servicePort;
    }
    
    //
    // toString
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NetworkServiceEndpointNode{");
        sb.append("serviceDNSName=").append(serviceDNSName);
        sb.append(", serviceHostIP=").append(serviceHostIP);
        sb.append(", servicePort=").append(servicePort);
        sb.append(", ").append(super.toString()).append('}');
        return sb.toString();
    }
    
    
}
