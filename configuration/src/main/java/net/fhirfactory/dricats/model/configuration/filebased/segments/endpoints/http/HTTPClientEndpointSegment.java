/*
 * Copyright (c) 2022 Mark A. Hunter (ACT Health)
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
package net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.http;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.base.SocketBasedClientPortSegment;

public class HTTPClientEndpointSegment extends SocketBasedClientPortSegment {

    private String contextPath;

    //
    // Constructor(s)
    //

    public HTTPClientEndpointSegment() {
        super();
        this.contextPath = null;
    }

    //
    // Getters and Setters
    //
    
    @JsonIgnore
    public boolean hasContextPath(){
        boolean hasValue = this.contextPath != null;
        return(hasValue);
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    //
    // To String
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTPClientPortSegment{");
        sb.append("contextPath=").append(contextPath);
        sb.append(", ").append(super.toString()).append('}');
        return sb.toString();
    }
}
