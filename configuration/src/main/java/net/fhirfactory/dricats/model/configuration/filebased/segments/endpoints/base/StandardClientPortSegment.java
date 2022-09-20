/*
 * Copyright (c) 2021 Mark A. Hunter (ACT Health)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class StandardClientPortSegment  extends StandardExternalFacingPort {

    private Integer retryCount;
    private Integer retryWaitPeriod;
    private Integer connectionTimeout;

    //
    // Constructor(s)
    //

    public StandardClientPortSegment(){
        super();
        this.retryCount = 1;
        this.retryWaitPeriod = 30;
        this.connectionTimeout = 15;
    }

    //
    // Getters and Setters
    //

    @JsonIgnore 
    public boolean hasRetryCount(){
        boolean hasValue = this.retryCount != null;
        return(hasValue);
    }
    
    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }
    
    @JsonIgnore
    public boolean hasRetryWaitPeriod(){
        boolean hasValue = this.retryWaitPeriod != null;
        return(hasValue);
    }

    public int getRetryWaitPeriod() {
        return retryWaitPeriod;
    }

    public void setRetryWaitPeriod(int retryWaitPeriod) {
        this.retryWaitPeriod = retryWaitPeriod;
    }

    @JsonIgnore
    public Boolean hasConnectionTimeout(){
        boolean hasValue = this.connectionTimeout != null;
        return(hasValue);
    }
    
    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    //
    // To String
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StandardClientPortSegment{");
        sb.append("retryCount=").append(retryCount);
        sb.append(", retryWaitPeriod=").append(retryWaitPeriod);
        sb.append(", connectionTimeout=").append(connectionTimeout);
        sb.append(", ").append(super.toString()).append('}');
        return sb.toString();
    }


}
