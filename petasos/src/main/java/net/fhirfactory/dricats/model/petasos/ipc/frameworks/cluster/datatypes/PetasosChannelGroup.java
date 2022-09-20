/*
 * Copyright (c) 2020 Mark A. Hunter
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
package net.fhirfactory.dricats.model.petasos.ipc.frameworks.cluster.datatypes;

import java.io.Serializable;

import net.fhirfactory.dricats.model.petasos.ipc.frameworks.cluster.valuesets.PetasosChannelScopeEnum;
import net.fhirfactory.dricats.model.petasos.ipc.technologies.jgroups.JGroupsChannelConnector;

public class PetasosChannelGroup implements Serializable {
    PetasosChannelScopeEnum channelGroupScope;
    JGroupsChannelConnector messagingServicesConnector;
    JGroupsChannelConnector topologyServicesConnector;
    JGroupsChannelConnector routingServicesConnector;
    JGroupsChannelConnector interceptionServicesConnector;
    JGroupsChannelConnector auditServicesConnector;
    JGroupsChannelConnector observationServicesConnector;
    
    //
    // Constructor(s)
    //
    
    
    //
    // Getters and Setters
    //
    
	public PetasosChannelScopeEnum getChannelGroupScope() {
		return channelGroupScope;
	}
	public void setChannelGroupScope(PetasosChannelScopeEnum channelGroupScope) {
		this.channelGroupScope = channelGroupScope;
	}
	
	public JGroupsChannelConnector getMessagingServicesConnector() {
		return messagingServicesConnector;
	}
	public void setMessagingServicesConnector(JGroupsChannelConnector messagingServicesConnector) {
		this.messagingServicesConnector = messagingServicesConnector;
	}
	
	public JGroupsChannelConnector getTopologyServicesConnector() {
		return topologyServicesConnector;
	}
	public void setTopologyServicesConnector(JGroupsChannelConnector topologyServicesConnector) {
		this.topologyServicesConnector = topologyServicesConnector;
	}
	
	public JGroupsChannelConnector getRoutingServicesConnector() {
		return routingServicesConnector;
	}
	public void setRoutingServicesConnector(JGroupsChannelConnector routingServicesConnector) {
		this.routingServicesConnector = routingServicesConnector;
	}
	
	public JGroupsChannelConnector getInterceptionServicesConnector() {
		return interceptionServicesConnector;
	}
	public void setInterceptionServicesConnector(JGroupsChannelConnector interceptionServicesConnector) {
		this.interceptionServicesConnector = interceptionServicesConnector;
	}
	
	public JGroupsChannelConnector getAuditServicesConnector() {
		return auditServicesConnector;
	}
	public void setAuditServicesConnector(JGroupsChannelConnector auditServicesConnector) {
		this.auditServicesConnector = auditServicesConnector;
	}
	
	public JGroupsChannelConnector getObservationServicesConnector() {
		return observationServicesConnector;
	}
	public void setObservationServicesConnector(JGroupsChannelConnector observationServicesConnector) {
		this.observationServicesConnector = observationServicesConnector;
	}
	
	//
	// toString()
	//
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PetasosChannelGroup {channelGroupScope=").append(channelGroupScope);
		builder.append(", messagingServicesConnector=").append(messagingServicesConnector);
		builder.append(", topologyServicesConnector=").append(topologyServicesConnector);
		builder.append(", routingServicesConnector=").append(routingServicesConnector);
		builder.append(", interceptionServicesConnector=").append(interceptionServicesConnector);
		builder.append(", auditServicesConnector=").append(auditServicesConnector);
		builder.append(", observationServicesConnector=").append(observationServicesConnector).append("}");
		return builder.toString();
	}
    

	




    
}
