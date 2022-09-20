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
package net.fhirfactory.dricats.model.simplified.resources.summaries;

import java.util.HashSet;
import java.util.Set;

import net.fhirfactory.dricats.model.simplified.resources.summaries.common.ResourceSummaryBase;
import net.fhirfactory.dricats.model.simplified.resources.summaries.isc.ISCPortSummary;

public class EndpointSummary extends ResourceSummaryBase {

	private String connectedSystemName;
	private String endpointType;
	private boolean server;
	private Set<ISCPortSummary> serverPorts;
	private Set<ISCPortSummary> clientPorts;
	private String wupParticipantName;

	//
	// Constructor(s)
	//

	public EndpointSummary() {
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
		StringBuilder builder = new StringBuilder();
		builder.append("EndpointSummary [connectedSystemName=");
		builder.append(connectedSystemName);
		builder.append(", endpointType=");
		builder.append(endpointType);
		builder.append(", server=");
		builder.append(server);
		builder.append(", serverPorts=");
		builder.append(serverPorts);
		builder.append(", clientPorts=");
		builder.append(clientPorts);
		builder.append(", wupParticipantName=");
		builder.append(wupParticipantName);
		builder.append(", getLastSynchronisationInstant()=");
		builder.append(getLastSynchronisationInstant());
		builder.append(", getLastActivityInstant()=");
		builder.append(getLastActivityInstant());
		builder.append(", getSimplifiedId()=");
		builder.append(getSimplifiedId());
		builder.append(", getDisplayName()=");
		builder.append(getDisplayName());
		builder.append(", getName()=");
		builder.append(getName());
		builder.append(", getVersion()=");
		builder.append(getVersion());
		builder.append(", getResourceESRType()=");
		builder.append(getResourceESRType());
		builder.append("]");
		return builder.toString();
	}

}
