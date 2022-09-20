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
package net.fhirfactory.dricats.model.configuration.filebased.archetypes.subsystems.fhirbreak.emailgateway;

import net.fhirfactory.dricats.model.configuration.filebased.archetypes.subsystems.fhirbreak.common.FHIRBreakSubsystemPropertyFile;
import net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.base.SocketBasedServerPortSegment;
import net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.interact.InteractClusteredServerEndpointSegment;

public class FHIRBreakEmailGatewayPropertyFile extends FHIRBreakSubsystemPropertyFile {

	private InteractClusteredServerEndpointSegment smtpGateway;
	private InteractClusteredServerEndpointSegment imapGateway;

	private SocketBasedServerPortSegment edgeReceiveCommunication;

	public InteractClusteredServerEndpointSegment getSmtpGateway() {
		return smtpGateway;
	}

	public void setSmtpGateway(InteractClusteredServerEndpointSegment smtpGateway) {
		this.smtpGateway = smtpGateway;
	}

	public InteractClusteredServerEndpointSegment getImapGateway() {
		return imapGateway;
	}

	public void setImapGateway(InteractClusteredServerEndpointSegment imapGateway) {
		this.imapGateway = imapGateway;
	}

	public SocketBasedServerPortSegment getEdgeReceiveCommunication() {
		return edgeReceiveCommunication;
	}

	public void setEdgeReceiveCommunication(SocketBasedServerPortSegment edgeReceiveCommunication) {
		this.edgeReceiveCommunication = edgeReceiveCommunication;
	}
}
