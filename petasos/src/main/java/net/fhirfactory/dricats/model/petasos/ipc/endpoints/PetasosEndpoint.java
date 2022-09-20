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
package net.fhirfactory.dricats.model.petasos.ipc.endpoints;

import java.io.Serializable;

import org.slf4j.Logger;

import net.fhirfactory.dricats.model.petasos.participant.components.endpoint.valuesets.EndpointStatusEnum;
import net.fhirfactory.dricats.model.petasos.participant.components.endpoint.valuesets.EndpointTypeEnum;

public abstract class PetasosEndpoint implements Serializable {
	private EndpointStatusEnum endpointStatus;
	private EndpointTypeEnum interfaceFunction;

	//
	// Constructor(s)
	//

	public PetasosEndpoint() {
		super();
		this.endpointStatus = EndpointStatusEnum.DRICATS_ENDPOINT_STATUS_UNKNOWN;
		this.interfaceFunction = null;
	}

	public PetasosEndpoint(PetasosEndpoint ori) {
		this.setEndpointStatus(ori.getEndpointStatus());
		this.setInterfaceFunction(ori.getInterfaceFunction());
	}

	//
	// Abstract methods
	//

	abstract protected Logger getLogger();

	//
	// Getters and Setters
	//

	public EndpointTypeEnum getInterfaceFunction() {
		return interfaceFunction;
	}

	public void setInterfaceFunction(EndpointTypeEnum interfaceFunction) {
		this.interfaceFunction = interfaceFunction;
	}

	public EndpointStatusEnum getEndpointStatus() {
		return endpointStatus;
	}

	public void setEndpointStatus(EndpointStatusEnum endpointStatus) {
		this.endpointStatus = endpointStatus;
	}

	//
	// To String
	//

	@Override
	public String toString() {
		return "PetasosEndpoint{" + "endpointStatus=" + endpointStatus + ", interfaceFunction=" + interfaceFunction + '}';
	}

}
