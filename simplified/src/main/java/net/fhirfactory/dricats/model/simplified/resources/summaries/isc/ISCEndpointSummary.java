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
package net.fhirfactory.dricats.model.simplified.resources.summaries.isc;

import java.util.HashSet;
import java.util.Set;

import net.fhirfactory.dricats.model.simplified.resources.summaries.isc.base.ISCSummary;

public class ISCEndpointSummary extends ISCSummary {

	private String connectedSystemName;
	private String endpointType;
	private boolean server;
	private Set<ISCPortSummary> serverPorts;
	private Set<ISCPortSummary> clientPorts;
	private String wupParticipantName;

	//
	// Constructor(s)
	//

	public ISCEndpointSummary() {
		this.connectedSystemName = null;
		this.endpointType = null;
		this.server = false;
		this.serverPorts = new HashSet<>();
		this.clientPorts = new HashSet<>();
		this.wupParticipantName = null;
	}

	//
	// Getters and Setters
	//

	public String getWupParticipantName() {
		return wupParticipantName;
	}

	public void setWupParticipantName(String wupParticipantName) {
		this.wupParticipantName = wupParticipantName;
	}

	public String getConnectedSystemName() {
		return connectedSystemName;
	}

	public void setConnectedSystemName(String connectedSystemName) {
		this.connectedSystemName = connectedSystemName;
	}

	public String getEndpointType() {
		return endpointType;
	}

	public void setEndpointType(String endpointType) {
		this.endpointType = endpointType;
	}

	public boolean isServer() {
		return server;
	}

	public void setServer(boolean server) {
		this.server = server;
	}

	public Set<ISCPortSummary> getServerPorts() {
		return serverPorts;
	}

	public void setServerPorts(Set<ISCPortSummary> serverPorts) {
		this.serverPorts = serverPorts;
	}

	public Set<ISCPortSummary> getClientPorts() {
		return clientPorts;
	}

	public void setClientPorts(Set<ISCPortSummary> clientPorts) {
		this.clientPorts = clientPorts;
	}

	//
	// To String
	//

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("EndpointSummary{");
		sb.append("connectedSystemName=").append(connectedSystemName);
		sb.append(", endpointType=").append(endpointType);
		sb.append(", server=").append(server);
		sb.append(", serverPorts=").append(serverPorts);
		sb.append(", clientPorts=").append(clientPorts);
		sb.append(", wupParticipantName=").append(wupParticipantName);
		sb.append(", ").append(super.toString()).append('}');
		return sb.toString();
	}

}
