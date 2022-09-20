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
package net.fhirfactory.dricats.model.configuration.filebased.archetypes.subsystems.fhirpersistence.im;

import net.fhirfactory.dricats.model.configuration.filebased.archetypes.common.WildflyBasedServerPropertyFile;
import net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.http.ClusteredHTTPServerPortSegment;
import net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.http.HTTPServerEndpointSegment;

public abstract class FHIRInformationManagerPropertyFile extends WildflyBasedServerPropertyFile {

	HTTPServerEndpointSegment edgeAnswerConformance;
	HTTPServerEndpointSegment edgeAnswerTerminology;
	HTTPServerEndpointSegment edgeAnswerSecurity;
	HTTPServerEndpointSegment edgeAnswerDocuments;
	HTTPServerEndpointSegment edgeAnswerOther;
	HTTPServerEndpointSegment edgeAnswerIndividuals;
	HTTPServerEndpointSegment edgeAnswerEntities;
	HTTPServerEndpointSegment edgeAnswerWorkflow;
	HTTPServerEndpointSegment edgeAnswerManagement;
	HTTPServerEndpointSegment edgeAnswerSummary;
	HTTPServerEndpointSegment edgeAnswerDiagnostics;
	HTTPServerEndpointSegment edgeAnswerMedications;
	HTTPServerEndpointSegment edgeAnswerCareProvision;
	HTTPServerEndpointSegment edgeAnswerRequestAndResponse;
	HTTPServerEndpointSegment edgeAnswerSupport;
	HTTPServerEndpointSegment edgeAnswerBilling;
	HTTPServerEndpointSegment edgeAnswerPayment;
	HTTPServerEndpointSegment edgeAnswerGeneral;

	public HTTPServerEndpointSegment getEdgeAnswerConformance() {
		return edgeAnswerConformance;
	}

	public void setEdgeAnswerConformance(HTTPServerEndpointSegment edgeAnswerConformance) {
		this.edgeAnswerConformance = edgeAnswerConformance;
	}

	public HTTPServerEndpointSegment getEdgeAnswerTerminology() {
		return edgeAnswerTerminology;
	}

	public void setEdgeAnswerTerminology(HTTPServerEndpointSegment edgeAnswerTerminology) {
		this.edgeAnswerTerminology = edgeAnswerTerminology;
	}

	public HTTPServerEndpointSegment getEdgeAnswerSecurity() {
		return edgeAnswerSecurity;
	}

	public void setEdgeAnswerSecurity(HTTPServerEndpointSegment edgeAnswerSecurity) {
		this.edgeAnswerSecurity = edgeAnswerSecurity;
	}

	public HTTPServerEndpointSegment getEdgeAnswerDocuments() {
		return edgeAnswerDocuments;
	}

	public void setEdgeAnswerDocuments(HTTPServerEndpointSegment edgeAnswerDocuments) {
		this.edgeAnswerDocuments = edgeAnswerDocuments;
	}

	public HTTPServerEndpointSegment getEdgeAnswerOther() {
		return edgeAnswerOther;
	}

	public void setEdgeAnswerOther(HTTPServerEndpointSegment edgeAnswerOther) {
		this.edgeAnswerOther = edgeAnswerOther;
	}

	public HTTPServerEndpointSegment getEdgeAnswerIndividuals() {
		return edgeAnswerIndividuals;
	}

	public void setEdgeAnswerIndividuals(HTTPServerEndpointSegment edgeAnswerIndividuals) {
		this.edgeAnswerIndividuals = edgeAnswerIndividuals;
	}

	public HTTPServerEndpointSegment getEdgeAnswerEntities() {
		return edgeAnswerEntities;
	}

	public void setEdgeAnswerEntities(HTTPServerEndpointSegment edgeAnswerEntities) {
		this.edgeAnswerEntities = edgeAnswerEntities;
	}

	public HTTPServerEndpointSegment getEdgeAnswerWorkflow() {
		return edgeAnswerWorkflow;
	}

	public void setEdgeAnswerWorkflow(HTTPServerEndpointSegment edgeAnswerWorkflow) {
		this.edgeAnswerWorkflow = edgeAnswerWorkflow;
	}

	public HTTPServerEndpointSegment getEdgeAnswerManagement() {
		return edgeAnswerManagement;
	}

	public void setEdgeAnswerManagement(HTTPServerEndpointSegment edgeAnswerManagement) {
		this.edgeAnswerManagement = edgeAnswerManagement;
	}

	public HTTPServerEndpointSegment getEdgeAnswerSummary() {
		return edgeAnswerSummary;
	}

	public void setEdgeAnswerSummary(HTTPServerEndpointSegment edgeAnswerSummary) {
		this.edgeAnswerSummary = edgeAnswerSummary;
	}

	public HTTPServerEndpointSegment getEdgeAnswerDiagnostics() {
		return edgeAnswerDiagnostics;
	}

	public void setEdgeAnswerDiagnostics(HTTPServerEndpointSegment edgeAnswerDiagnostics) {
		this.edgeAnswerDiagnostics = edgeAnswerDiagnostics;
	}

	public HTTPServerEndpointSegment getEdgeAnswerMedications() {
		return edgeAnswerMedications;
	}

	public void setEdgeAnswerMedications(HTTPServerEndpointSegment edgeAnswerMedications) {
		this.edgeAnswerMedications = edgeAnswerMedications;
	}

	public HTTPServerEndpointSegment getEdgeAnswerCareProvision() {
		return edgeAnswerCareProvision;
	}

	public void setEdgeAnswerCareProvision(HTTPServerEndpointSegment edgeAnswerCareProvision) {
		this.edgeAnswerCareProvision = edgeAnswerCareProvision;
	}

	public HTTPServerEndpointSegment getEdgeAnswerRequestAndResponse() {
		return edgeAnswerRequestAndResponse;
	}

	public void setEdgeAnswerRequestAndResponse(HTTPServerEndpointSegment edgeAnswerRequestAndResponse) {
		this.edgeAnswerRequestAndResponse = edgeAnswerRequestAndResponse;
	}

	public HTTPServerEndpointSegment getEdgeAnswerSupport() {
		return edgeAnswerSupport;
	}

	public void setEdgeAnswerSupport(HTTPServerEndpointSegment edgeAnswerSupport) {
		this.edgeAnswerSupport = edgeAnswerSupport;
	}

	public HTTPServerEndpointSegment getEdgeAnswerBilling() {
		return edgeAnswerBilling;
	}

	public void setEdgeAnswerBilling(HTTPServerEndpointSegment edgeAnswerBilling) {
		this.edgeAnswerBilling = edgeAnswerBilling;
	}

	public HTTPServerEndpointSegment getEdgeAnswerPayment() {
		return edgeAnswerPayment;
	}

	public void setEdgeAnswerPayment(HTTPServerEndpointSegment edgeAnswerPayment) {
		this.edgeAnswerPayment = edgeAnswerPayment;
	}

	public HTTPServerEndpointSegment getEdgeAnswerGeneral() {
		return edgeAnswerGeneral;
	}

	public void setEdgeAnswerGeneral(HTTPServerEndpointSegment edgeAnswerGeneral) {
		this.edgeAnswerGeneral = edgeAnswerGeneral;
	}
}
