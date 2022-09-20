/*
 * The MIT License
 *
 * Copyright 2022 Mark A. Hunter
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

import java.io.Serializable;
import net.fhirfactory.dricats.model.petasos.participant.components.servicegateway.valuesets.ServiceGatewayTypeEnum;

/**
 *
 * @author mhunter
 */
public abstract class ServiceGatewayBase implements Serializable{
    private String serviceName;
    private String serviceDisplayName;
    private ServiceGatewayTypeEnum serviceType;
    
    //
    // Constructor(s)
    //
    
    public ServiceGatewayBase(){
        this.serviceName = null;
        this.serviceDisplayName = null;
        this.serviceType = ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_STANDALONE;
    }
    
    //
    // Abstract Methods
    //
    
    abstract protected Logger getLogger();
    
    //
    // Getters and Setters
    //

    public ServiceGatewayTypeEnum getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceGatewayTypeEnum serviceType) {
        this.serviceType = serviceType;
    }

    @JsonIgnore
    public boolean hasServiceName(){
        boolean hasValue = this.serviceName != null;
        return(hasValue);
    }
    
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    
    @JsonIgnore
    public boolean hasParticipantName(){
        return(hasServiceName());
    }
    
    @JsonIgnore
    public String getParticipantName(){
        return(getServiceName());
    }

    @JsonIgnore
    public void setParticipantName(String serviceName){
        setServiceName(serviceName);
    }
    
    @JsonIgnore
    public boolean hasServiceDisplayName(){
        boolean hasValue = this.serviceDisplayName != null;
        return(hasValue);
    }
    
    public String getServiceDisplayName() {
        return serviceDisplayName;
    }

    public void setServiceDisplayName(String serviceDisplayName) {
        this.serviceDisplayName = serviceDisplayName;
    }
    
    @JsonIgnore
    public boolean hasParticipantDisplayName(){
        return(hasServiceDisplayName());
    }
    
    @JsonIgnore
    public String getParticipantDisplayName(){
        return(getServiceDisplayName());
    }
    
    @JsonIgnore
    public void setParticipantDisplayName(String displayName){
        setServiceDisplayName(displayName);
    }
    
    //
    // toString
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ServiceNode{");
        sb.append("serviceName=").append(serviceName);
        sb.append(", serviceDisplayName=").append(serviceDisplayName);
        sb.append(", serviceType=").append(serviceType);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
