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
package net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.interact;

import java.util.ArrayList;
import java.util.List;

public class OtherInteractEndpointSet {
    private List<InteractClusteredServerEndpointSegment> socketBasedServers;
    private List<InteractSocketBasedClientEndpointSegment> socketBasedClients;
    private List<InteractClientEndpointSegment> genericClients;

    //
    // Constructor(s)
    //

    public OtherInteractEndpointSet(){
        this.socketBasedClients = new ArrayList<>();
        this.socketBasedServers = new ArrayList<>();
        this.genericClients = new ArrayList<>();
    }

    //
    // Getters and Setters
    //

    public List<InteractClusteredServerEndpointSegment> getSocketBasedServers() {
        return socketBasedServers;
    }

    public void setSocketBasedServers(List<InteractClusteredServerEndpointSegment> socketBasedServers) {
        this.socketBasedServers = socketBasedServers;
    }

    public List<InteractSocketBasedClientEndpointSegment> getSocketBasedClients() {
        return socketBasedClients;
    }

    public void setSocketBasedClients(List<InteractSocketBasedClientEndpointSegment> socketBasedClients) {
        this.socketBasedClients = socketBasedClients;
    }

    public List<InteractClientEndpointSegment> getGenericClients() {
        return genericClients;
    }

    public void setGenericClients(List<InteractClientEndpointSegment> genericClients) {
        this.genericClients = genericClients;
    }

    //
    // toString()
    //

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OtherInteractEndpointSet{");
        sb.append("socketBasedServers=").append(socketBasedServers);
        sb.append(", socketBasedClients=").append(socketBasedClients);
        sb.append(", genericClients=").append(genericClients);
        sb.append('}');
        return sb.toString();
    }
}
