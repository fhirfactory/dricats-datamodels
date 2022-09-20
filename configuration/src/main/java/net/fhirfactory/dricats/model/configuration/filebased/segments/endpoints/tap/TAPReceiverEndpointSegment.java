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
package net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.tap;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.interact.InteractClusteredServerEndpointSegment;

/**
 *
 * @author mhunter
 */
public class TAPReceiverEndpointSegment extends InteractClusteredServerEndpointSegment {
    private Integer maximumConcurrentConsumers;
    private Boolean convertToStringPayload;
    private Boolean validatePayload;
    private Integer acceptTimeout;
    private Integer bindTimeout;

    //
    // Constructor(s)
    //

    public TAPReceiverEndpointSegment(){
        this.maximumConcurrentConsumers = null;
        this.bindTimeout = null;
        this.convertToStringPayload = null;
        this.acceptTimeout = null;
        this.convertToStringPayload = null;
    }
    
    //
    // Getters and Setters
    //

    @JsonIgnore
    public Boolean hasMaximumConcurrentConsumers(){
        boolean hasValue = this.maximumConcurrentConsumers != null;
        return(hasValue);
    }
    
    public Integer getMaximumConcurrentConsumers() {
        return maximumConcurrentConsumers;
    }

    public void setMaximumConcurrentConsumers(Integer maximumConcurrentConsumers) {
        this.maximumConcurrentConsumers = maximumConcurrentConsumers;
    }
    
    @JsonIgnore
    public Boolean hasConvertToStringPayload(){
        boolean hasValue = this.convertToStringPayload != null;
        return(hasValue);
    }

    public Boolean getConvertToStringPayload() {
        return convertToStringPayload;
    }

    public void setConvertToStringPayload(Boolean convertToStringPayload) {
        this.convertToStringPayload = convertToStringPayload;
    }

    @JsonIgnore
    public Boolean hasValidatePayload(){
        boolean hasValue = this.validatePayload != null;
        return(hasValue);
    }
    
    public Boolean getValidatePayload() {
        return validatePayload;
    }

    public void setValidatePayload(Boolean validatePayload) {
        this.validatePayload = validatePayload;
    }

    @JsonIgnore
    public Boolean hasAcceptTimeout(){
        boolean hasValue = this.acceptTimeout != null;
        return(hasValue);
    }
    
    public Integer getAcceptTimeout() {
        return acceptTimeout;
    }

    public void setAcceptTimeout(Integer acceptTimeout) {
        this.acceptTimeout = acceptTimeout;
    }

    @JsonIgnore
    public Boolean hasBindTimeout(){
        boolean hasValue = this.bindTimeout != null;
        return(hasValue);
    }
    
    public Integer getBindTimeout() {
        return bindTimeout;
    }

    public void setBindTimeout(Integer bindTimeout) {
        this.bindTimeout = bindTimeout;
    }
    
    //
    // toString
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MLLPReceiverPortSegment{");
        sb.append("maximumConcurrentConsumers=").append(maximumConcurrentConsumers);
        sb.append(", convertToStringPayload=").append(convertToStringPayload);
        sb.append(", validatePayload=").append(validatePayload);
        sb.append(", acceptTimeout=").append(acceptTimeout);
        sb.append(", bindTimeout=").append(bindTimeout);
        sb.append(", ").append(super.toString()).append('}');
        return sb.toString();
    }
    
    
    
}
