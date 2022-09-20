/*
 * Copyright (c) 2020 Mark A. Hunter (ACT Health)
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
package net.fhirfactory.dricats.model.configuration.filebased.archetypes.subsystems.hestia.dam.im;

import net.fhirfactory.dricats.model.configuration.filebased.archetypes.common.WildflyBasedServerPropertyFile;
import net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.base.SocketBasedServerPortSegment;
import net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.http.HTTPServerEndpointSegment;

public class HestiaDAMIMPropertyFile extends WildflyBasedServerPropertyFile {

	// Edge :: Answer (FHIR API Server)
	//
	private HTTPServerEndpointSegment edgeAnswer;

	// Edge :: Receive (FHIR::Media Receivers)
	//
	private SocketBasedServerPortSegment edgeReceiveMediaLadonNexusIM;
	private SocketBasedServerPortSegment edgeReceiveMediaCommunicateIrisIM;
	private SocketBasedServerPortSegment edgeReceiveMediaFHIRBreakLDAPScanner;
	private SocketBasedServerPortSegment edgeReceiveMediaFHIRBreakEmailGateway;
	private SocketBasedServerPortSegment edgeReceiveMediaMITaFSMSGateway;

	//
	// Constructors
	//

	public HestiaDAMIMPropertyFile() {
		super();
		this.edgeAnswer = null;
		this.edgeReceiveMediaCommunicateIrisIM = null;
		this.edgeReceiveMediaLadonNexusIM = null;
		this.edgeReceiveMediaFHIRBreakEmailGateway = null;
		this.edgeReceiveMediaFHIRBreakLDAPScanner = null;
		this.edgeReceiveMediaMITaFSMSGateway = null;
	}

	//
	// Getters and Setters
	//

	public HTTPServerEndpointSegment getEdgeAnswer() {
		return edgeAnswer;
	}

	public void setEdgeAnswer(HTTPServerEndpointSegment edgeAnswer) {
		this.edgeAnswer = edgeAnswer;
	}

	public SocketBasedServerPortSegment getEdgeReceiveMediaLadonNexusIM() {
		return edgeReceiveMediaLadonNexusIM;
	}

	public void setEdgeReceiveMediaLadonNexusIM(SocketBasedServerPortSegment edgeReceiveMediaLadonNexusIM) {
		this.edgeReceiveMediaLadonNexusIM = edgeReceiveMediaLadonNexusIM;
	}

	public SocketBasedServerPortSegment getEdgeReceiveMediaCommunicateIrisIM() {
		return edgeReceiveMediaCommunicateIrisIM;
	}

	public void setEdgeReceiveMediaCommunicateIrisIM(SocketBasedServerPortSegment edgeReceiveMediaCommunicateIrisIM) {
		this.edgeReceiveMediaCommunicateIrisIM = edgeReceiveMediaCommunicateIrisIM;
	}

	public SocketBasedServerPortSegment getEdgeReceiveMediaFHIRBreakLDAPScanner() {
		return edgeReceiveMediaFHIRBreakLDAPScanner;
	}

	public void setEdgeReceiveMediaFHIRBreakLDAPScanner(
			SocketBasedServerPortSegment edgeReceiveMediaFHIRBreakLDAPScanner) {
		this.edgeReceiveMediaFHIRBreakLDAPScanner = edgeReceiveMediaFHIRBreakLDAPScanner;
	}

	public SocketBasedServerPortSegment getEdgeReceiveMediaFHIRBreakEmailGateway() {
		return edgeReceiveMediaFHIRBreakEmailGateway;
	}

	public void setEdgeReceiveMediaFHIRBreakEmailGateway(
			SocketBasedServerPortSegment edgeReceiveMediaFHIRBreakEmailGateway) {
		this.edgeReceiveMediaFHIRBreakEmailGateway = edgeReceiveMediaFHIRBreakEmailGateway;
	}

	public SocketBasedServerPortSegment getEdgeReceiveMediaMITaFSMSGateway() {
		return edgeReceiveMediaMITaFSMSGateway;
	}

	public void setEdgeReceiveMediaMITaFSMSGateway(SocketBasedServerPortSegment edgeReceiveMediaMITaFSMSGateway) {
		this.edgeReceiveMediaMITaFSMSGateway = edgeReceiveMediaMITaFSMSGateway;
	}
}
