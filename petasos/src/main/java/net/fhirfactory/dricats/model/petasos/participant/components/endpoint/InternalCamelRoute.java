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
package net.fhirfactory.dricats.model.petasos.participant.components.endpoint;

import java.io.Serializable;

import net.fhirfactory.dricats.interfaces.petasos.participant.endpoint.WorkUnitProcessorEndpointInterface;
import net.fhirfactory.dricats.model.component.datatypes.ComponentId;
import net.fhirfactory.dricats.model.petasos.participant.components.endpoint.valuesets.EndpointTypeEnum;
import net.fhirfactory.dricats.model.petasos.participant.datatypes.PetasosParticipantId;
import net.fhirfactory.dricats.model.petasos.tasking.routing.identification.WUPComponentNames;

/**
 *
 * @author mhunter
 */
public class InternalCamelRoute implements Serializable, WorkUnitProcessorEndpointInterface {
	private PetasosParticipantId participantId;
	private String parameters;
	private boolean consumer;
	private WUPComponentNames routeElementNames;
	private static final String VERSION = "1.0.0";

	// Constructor(s)

	public InternalCamelRoute(PetasosParticipantId participantId, String parameters, boolean isConsumer) {
		this.participantId = participantId;
		this.parameters = parameters;
		this.consumer = isConsumer;
		this.routeElementNames = new WUPComponentNames(participantId.getParticipantName(), participantId.getParticipantVersion());
	}

	//
	// Getters and Setters
	//

	@Override
	public String getEndpointDescription() {
		if (isConsumer()) {
			return (routeElementNames.getEndPointWUPEgress());
		} else {
			return (routeElementNames.getEndPointWUPIngres());
		}
	}

	@Override
	public boolean isUsingStandardCamelRoute() {
		return (true);
	}

	@Override
	public EndpointTypeEnum getEndpointType() {
		return (EndpointTypeEnum.DIRECT_CAMEL_ENDPOINT);
	}

	public boolean isConsumer() {
		return consumer;
	}

	public void setConsumer(boolean consumer) {
		this.consumer = consumer;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public PetasosParticipantId getParticipantId() {
		return participantId;
	}

	public void setParticipantId(PetasosParticipantId participantId) {
		this.participantId = participantId;
	}

	public WUPComponentNames getRouteElementNames() {
		return routeElementNames;
	}

	public void setRouteElementNames(WUPComponentNames routeElementNames) {
		this.routeElementNames = routeElementNames;
	}

	@Override
	public String getEndpointURL() {
		return (routeElementNames.getEndPointWUPIngres());
	}

	@Override
	public ComponentId getEndpointComponentId() {
		return null;
	}

	@Override
	public PetasosParticipantId getEndpointParticipantId() {
		return (participantId);
	}

	//
	// toString
	//

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("InternalCamelRouteEndpoint{");
		sb.append("participantId=").append(participantId);
		sb.append(", consumer=").append(isConsumer());
		sb.append(", parameters=").append(parameters);
		sb.append(", routeElementNames=").append(routeElementNames);
		sb.append('}');
		return sb.toString();
	}

}
