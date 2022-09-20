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
package net.fhirfactory.dricats.model.petasos.ipc.technologies.jgroups;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fhirfactory.dricats.model.component.datatypes.ComponentId;
import net.fhirfactory.dricats.model.configuration.filebased.archetypes.valuesets.ClusterFunctionNameEnum;
import net.fhirfactory.dricats.model.petasos.ipc.technologies.jgroups.datatypes.JGroupsClientAdapter;
import net.fhirfactory.dricats.model.petasos.participant.components.endpoint.valuesets.EndpointStatusEnum;
import net.fhirfactory.dricats.model.petasos.participant.components.endpoint.valuesets.EndpointTypeEnum;

public class JGroupsChannelConnector {
	private static final Logger LOG = LoggerFactory.getLogger(JGroupsChannelConnector.class);
	private ComponentId componentId;
	private ComponentId associatedEndpoint;
	private String groupName;
	private String channelName;
	private String configurationFileName;
	private ClusterFunctionNameEnum channelServiceType;
	private String connectedSystemName;
	private boolean server;
	private List<JGroupsClientAdapter> adapterList;
	private String endpointConfigurationName;
	private EndpointTypeEnum endpointType;
	private EndpointStatusEnum endpointStatus;

	//
	// Constructor(s)
	//

	public JGroupsChannelConnector() {
		this.componentId = null;
		this.adapterList = new ArrayList<>();
		this.associatedEndpoint = null;
		this.channelName = null;
		this.groupName = null;
		this.configurationFileName = null;
		this.channelServiceType = null;
		this.connectedSystemName = null;
		this.server = false;
		this.endpointConfigurationName = null;
		this.endpointType = EndpointTypeEnum.JGROUPS_INTEGRATION_POINT;
		this.endpointStatus = EndpointStatusEnum.DRICATS_ENDPOINT_STATUS_UNKNOWN;
	}

	//
	// Getters and Setters
	//

	public ComponentId getComponentId() {
		return componentId;
	}

	public void setComponentId(ComponentId componentId) {
		this.componentId = componentId;
	}

	public ComponentId getAssociatedEndpoint() {
		return associatedEndpoint;
	}

	public void setAssociatedEndpoint(ComponentId associatedEndpoint) {
		this.associatedEndpoint = associatedEndpoint;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getConfigurationFileName() {
		return configurationFileName;
	}

	public void setConfigurationFileName(String configurationFileName) {
		this.configurationFileName = configurationFileName;
	}

	public ClusterFunctionNameEnum getChannelServiceType() {
		return channelServiceType;
	}

	public void setChannelServiceType(ClusterFunctionNameEnum channelServiceType) {
		this.channelServiceType = channelServiceType;
	}

	public String getConnectedSystemName() {
		return connectedSystemName;
	}

	public void setConnectedSystemName(String connectedSystemName) {
		this.connectedSystemName = connectedSystemName;
	}

	public boolean isServer() {
		return server;
	}

	public void setServer(boolean server) {
		this.server = server;
	}

	public List<JGroupsClientAdapter> getAdapterList() {
		return adapterList;
	}

	public void setAdapterList(List<JGroupsClientAdapter> adapterList) {
		this.adapterList = adapterList;
	}

	public String getEndpointConfigurationName() {
		return endpointConfigurationName;
	}

	public void setEndpointConfigurationName(String endpointConfigurationName) {
		this.endpointConfigurationName = endpointConfigurationName;
	}

	public EndpointTypeEnum getEndpointType() {
		return endpointType;
	}

	public void setEndpointType(EndpointTypeEnum endpointType) {
		this.endpointType = endpointType;
	}

	public EndpointStatusEnum getEndpointStatus() {
		return endpointStatus;
	}

	public void setEndpointStatus(EndpointStatusEnum endpointStatus) {
		this.endpointStatus = endpointStatus;
	}

	protected Logger getLogger() {
		return (LOG);
	}

	//
	// Summary Creation
	//

	public JGroupsChannelConnectorSummary toSummary() {
		JGroupsChannelConnectorSummary summary = new JGroupsChannelConnectorSummary();
		summary.setFunction(getChannelServiceType());
		summary.setComponentId(getComponentId());
		summary.setLastRefreshInstant(Instant.now());
		summary.setChannelName(getChannelName());
		return (summary);
	}

	//
	// To String
	//

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("JGroupsChannelConnector{");
		sb.append("componentId=").append(componentId);
		sb.append(", associatedEndpoint=").append(associatedEndpoint);
		sb.append(", groupName=").append(groupName);
		sb.append(", channelName=").append(channelName);
		sb.append(", configurationFileName=").append(configurationFileName);
		sb.append(", channelServiceType=").append(channelServiceType);
		sb.append(", connectedSystemName=").append(connectedSystemName);
		sb.append(", server=").append(server);
		sb.append(", adapterList=").append(adapterList);
		sb.append(", endpointConfigurationName=").append(endpointConfigurationName);
		sb.append(", endpointType=").append(endpointType);
		sb.append(", endpointStatus=").append(endpointStatus);
		sb.append('}');
		return sb.toString();
	}
}
