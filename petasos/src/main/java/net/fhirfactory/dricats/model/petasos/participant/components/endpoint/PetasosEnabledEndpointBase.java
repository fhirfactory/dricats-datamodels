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
package net.fhirfactory.dricats.model.petasos.participant.components.endpoint;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.fhirfactory.dricats.interfaces.petasos.participant.endpoint.WorkUnitProcessorEndpointInterface;
import net.fhirfactory.dricats.model.component.datatypes.ComponentId;
import net.fhirfactory.dricats.model.petasos.participant.components.adapter.AdapterBase;
import net.fhirfactory.dricats.model.petasos.participant.components.endpoint.valuesets.EndpointStatusEnum;
import net.fhirfactory.dricats.model.petasos.participant.components.endpoint.valuesets.EndpointTypeEnum;

public abstract class PetasosEnabledEndpointBase implements Serializable, WorkUnitProcessorEndpointInterface {
	private ComponentId endpointComponentId;
	private String connectedSystemName;
	private boolean server;
	private List<AdapterBase> adapterList;
	private String endpointConfigurationName;
	private EndpointTypeEnum endpointType;
	private EndpointStatusEnum endpointStatus;

	//
	// Constructor(s)
	//

	public PetasosEnabledEndpointBase() {
		super();
		this.connectedSystemName = null;
		this.server = true;
		this.adapterList = new ArrayList<>();
		this.endpointConfigurationName = null;
		this.endpointType = EndpointTypeEnum.OTHER_CLIENT;
		this.endpointStatus = EndpointStatusEnum.DRICATS_ENDPOINT_STATUS_UNKNOWN;
		ComponentId newComponentId = new ComponentId(specifyComponentName(), specifyComponentVersion());
		this.endpointComponentId = newComponentId;
	}

	public PetasosEnabledEndpointBase(PetasosEnabledEndpointBase ori) {
		this.adapterList = new ArrayList<>();
		if (ori.hasConnectedSystemName()) {
			setConnectedSystemName(ori.getConnectedSystemName());
		}
		if (ori.hasEndpointConfigurationName()) {
			setEndpointConfigurationName(ori.getEndpointConfigurationName());
		}
		setServer(ori.isServer());
		if (!adapterList.isEmpty()) {
			this.adapterList.addAll(ori.getAdapterList());
		}
		setEndpointStatus(ori.getEndpointStatus());
		setEndpointComponentId(ori.endpointComponentId);
	}

	//
	// Abstract Methods
	//

	protected abstract Logger getLogger();

	protected abstract String specifyComponentName();

	protected abstract String specifyComponentVersion();

	//
	// Getters and Setters
	//

	@JsonIgnore
	public boolean hasComponentId() {
		boolean hasValue = this.endpointComponentId != null;
		return (hasValue);
	}

	public ComponentId getEndpointComponentId() {
		return endpointComponentId;
	}

	public void setEndpointComponentId(ComponentId endpointComponentId) {
		this.endpointComponentId = endpointComponentId;
	}

	@JsonIgnore
	public boolean hasEndpointType() {
		boolean hasValue = this.endpointType != null;
		return (hasValue);
	}

	public EndpointTypeEnum getEndpointType() {
		return endpointType;
	}

	public void setEndpointType(EndpointTypeEnum endpointType) {
		this.endpointType = endpointType;
	}

	@JsonIgnore
	public boolean hasEndpointConfigurationName() {
		boolean hasValue = this.endpointConfigurationName != null;
		return (hasValue);
	}

	public String getEndpointConfigurationName() {
		return endpointConfigurationName;
	}

	public void setEndpointConfigurationName(String endpointConfigurationName) {
		this.endpointConfigurationName = endpointConfigurationName;
	}

	public boolean isServer() {
		return server;
	}

	public void setServer(boolean server) {
		this.server = server;
	}

	@JsonIgnore
	public boolean hasConnectedSystemName() {
		boolean hasValue = this.connectedSystemName != null;
		return (hasValue);
	}

	public String getConnectedSystemName() {
		return connectedSystemName;
	}

	public void setConnectedSystemName(String connectedSystemName) {
		this.connectedSystemName = connectedSystemName;
	}

	public List<AdapterBase> getAdapterList() {
		return adapterList;
	}

	public void setAdapterList(List<AdapterBase> adapterList) {
		this.adapterList = adapterList;
	}

	public EndpointStatusEnum getEndpointStatus() {
		return endpointStatus;
	}

	public void setEndpointStatus(EndpointStatusEnum endpointStatus) {
		this.endpointStatus = endpointStatus;
	}

	//
	// to String
	//

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("IPCTopologyEndpoint{");
		sb.append("connectedSystemName=").append(connectedSystemName);
		sb.append(", server=").append(server);
		sb.append(", adapterList=").append(adapterList);
		sb.append(", endpointConfigurationName=").append(endpointConfigurationName);
		sb.append(", endpointType=").append(endpointType);
		sb.append(", endpointStatus=").append(endpointStatus);
		sb.append(", ").append(super.toString()).append("}");
		return sb.toString();
	}

}
