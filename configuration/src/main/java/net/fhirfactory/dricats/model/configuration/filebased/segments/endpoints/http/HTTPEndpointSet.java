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

import java.util.ArrayList;
import java.util.List;

public class HTTPEndpointSet {
    private List<HTTPClientEndpointSegment> httpClients;
    private List<HTTPServerEndpointSegment> httpServers;

    //
    // Constructor(s)
    //

    public HTTPEndpointSet(){
        this.httpClients = new ArrayList<>();
        this.httpServers = new ArrayList<>();
    }

    //
    // Getter and Setters
    //

    public List<HTTPClientEndpointSegment> getHttpClients() {
        return httpClients;
    }

    public void setHttpClients(List<HTTPClientEndpointSegment> httpClients) {
        this.httpClients = httpClients;
    }

    public List<HTTPServerEndpointSegment> getHttpServers() {
        return httpServers;
    }

    public void setHttpServers(List<HTTPServerEndpointSegment> httpServers) {
        this.httpServers = httpServers;
    }

    //
    // toString
    //

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HTTPEndpointSet{");
        sb.append("httpClients=").append(httpClients);
        sb.append(", httpServers=").append(httpServers);
        sb.append('}');
        return sb.toString();
    }
}
