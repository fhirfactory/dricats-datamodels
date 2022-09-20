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
package net.fhirfactory.dricats.model.configuration.filebased.archetypes;

import net.fhirfactory.dricats.model.configuration.filebased.archetypes.valuesets.ClusterFunctionNameEnum;
import net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.http.HTTPClientEndpointSegment;
import net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.http.HTTPServerEndpointSegment;
import net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.jgroups.JGroupsInterZoneRepeaterClientPortSegment;

public class PetasosClusterPropertyFile {

    private static final Integer DEFAULT_PEER_FAILURE_RETRIES = 1;
    private static final Integer DEFAULT_PEER_STARTUP_DELAY = 30;
    private static final Integer DEFAULT_PETASOS_IPC_WATCHDOG_CHECK_PERIOD = 30;
    private static final Integer DEFAULT_PETASOS_IPC_WATCHDOG_STARTUP_DELAY = 30;
    private static final Integer DEFAULT_PETASOS_TASK_WATCHDOG_CHECK_PERIOD = 30;
    private static final Integer DEFAULT_PETASOS_TASK_WATCHDOG_STARTUP_DELAY = 30;

    private Integer defaultPetasosIPCWatchdogStartupDelay;
    private Integer defaultPetasosIPCWatchdogCheckPeriod;
    private Integer defaultPeerStartupDelay;
    private Integer defaultPeerFailureRetries;
    private Integer defaultPetasosTaskWatchdogStartupDelay;
    private Integer defaultPetasosTaskWatchdogCheckPeriod;
    private JGroupsInterZoneRepeaterClientPortSegment petasosMessagingEndpoint;
    private JGroupsInterZoneRepeaterClientPortSegment petasosTopologyServicesEndpoint;
    private JGroupsInterZoneRepeaterClientPortSegment petasosRoutingServicesEndpoint;
    private JGroupsInterZoneRepeaterClientPortSegment petasosAuditServicesEndpoint;
    private JGroupsInterZoneRepeaterClientPortSegment petasosInterceptionEndpoint;
    private JGroupsInterZoneRepeaterClientPortSegment petasosTaskingServicesEndpoint;
    private JGroupsInterZoneRepeaterClientPortSegment petasosObservationsEndpoint;
    private JGroupsInterZoneRepeaterClientPortSegment petasosMediaServicesEndpoint;
    private JGroupsInterZoneRepeaterClientPortSegment multiuseInfinispanEndpoint;
    private HTTPServerEndpointSegment edgeAnswer;
    private HTTPClientEndpointSegment edgeAsk;

    //
    // Constructor(s)
    //

    public PetasosClusterPropertyFile() {
            super();
            edgeAnswer = new HTTPServerEndpointSegment();
            edgeAsk = new HTTPClientEndpointSegment();
            defaultPeerFailureRetries = DEFAULT_PEER_FAILURE_RETRIES;
            defaultPeerStartupDelay = DEFAULT_PEER_STARTUP_DELAY;
            defaultPetasosTaskWatchdogCheckPeriod = DEFAULT_PETASOS_TASK_WATCHDOG_CHECK_PERIOD;
            defaultPetasosTaskWatchdogStartupDelay = DEFAULT_PETASOS_TASK_WATCHDOG_STARTUP_DELAY;
            defaultPetasosIPCWatchdogStartupDelay = DEFAULT_PETASOS_IPC_WATCHDOG_STARTUP_DELAY;
            defaultPetasosIPCWatchdogCheckPeriod = DEFAULT_PETASOS_IPC_WATCHDOG_CHECK_PERIOD;
            petasosMessagingEndpoint = new JGroupsInterZoneRepeaterClientPortSegment();
            petasosTopologyServicesEndpoint = new JGroupsInterZoneRepeaterClientPortSegment();
            petasosRoutingServicesEndpoint = new JGroupsInterZoneRepeaterClientPortSegment();
            petasosAuditServicesEndpoint = new JGroupsInterZoneRepeaterClientPortSegment();
            petasosInterceptionEndpoint = new JGroupsInterZoneRepeaterClientPortSegment();
            petasosTaskingServicesEndpoint = new JGroupsInterZoneRepeaterClientPortSegment();
            multiuseInfinispanEndpoint = new JGroupsInterZoneRepeaterClientPortSegment();
            petasosObservationsEndpoint = new JGroupsInterZoneRepeaterClientPortSegment();
            petasosMediaServicesEndpoint = new JGroupsInterZoneRepeaterClientPortSegment();
    }

    //
    // Getters and Setters
    //

    public Integer getDefaultPetasosIPCWatchdogStartupDelay() {
        return defaultPetasosIPCWatchdogStartupDelay;
    }

    public void setDefaultPetasosIPCWatchdogStartupDelay(Integer defaultPetasosIPCWatchdogStartupDelay) {
        this.defaultPetasosIPCWatchdogStartupDelay = defaultPetasosIPCWatchdogStartupDelay;
    }

    public Integer getDefaultPetasosIPCWatchdogCheckPeriod() {
        return defaultPetasosIPCWatchdogCheckPeriod;
    }

    public void setDefaultPetasosIPCWatchdogCheckPeriod(Integer defaultPetasosIPCWatchdogCheckPeriod) {
        this.defaultPetasosIPCWatchdogCheckPeriod = defaultPetasosIPCWatchdogCheckPeriod;
    }

    public Integer getDefaultPeerStartupDelay() {
        return defaultPeerStartupDelay;
    }

    public void setDefaultPeerStartupDelay(Integer defaultPeerStartupDelay) {
        this.defaultPeerStartupDelay = defaultPeerStartupDelay;
    }

    public Integer getDefaultPeerFailureRetries() {
        return defaultPeerFailureRetries;
    }

    public void setDefaultPeerFailureRetries(Integer defaultPeerFailureRetries) {
        this.defaultPeerFailureRetries = defaultPeerFailureRetries;
    }

    public Integer getDefaultPetasosTaskWatchdogStartupDelay() {
        return defaultPetasosTaskWatchdogStartupDelay;
    }

    public void setDefaultPetasosTaskWatchdogStartupDelay(Integer defaultPetasosTaskWatchdogStartupDelay) {
        this.defaultPetasosTaskWatchdogStartupDelay = defaultPetasosTaskWatchdogStartupDelay;
    }

    public Integer getDefaultPetasosTaskWatchdogCheckPeriod() {
        return defaultPetasosTaskWatchdogCheckPeriod;
    }

    public void setDefaultPetasosTaskWatchdogCheckPeriod(Integer defaultPetasosTaskWatchdogCheckPeriod) {
        this.defaultPetasosTaskWatchdogCheckPeriod = defaultPetasosTaskWatchdogCheckPeriod;
    }

    public JGroupsInterZoneRepeaterClientPortSegment getPetasosRoutingServicesEndpoint() {
            return petasosRoutingServicesEndpoint;
    }

    public void setPetasosRoutingServicesEndpoint(
                    JGroupsInterZoneRepeaterClientPortSegment petasosRoutingServicesEndpoint) {
            this.petasosRoutingServicesEndpoint = petasosRoutingServicesEndpoint;
    }

    public HTTPClientEndpointSegment getEdgeAsk() {
            return edgeAsk;
    }

    public void setEdgeAsk(HTTPClientEndpointSegment edgeAsk) {
            this.edgeAsk = edgeAsk;
    }

    public JGroupsInterZoneRepeaterClientPortSegment getPetasosAuditServicesEndpoint() {
            return petasosAuditServicesEndpoint;
    }

    public void setPetasosAuditServicesEndpoint(
                    JGroupsInterZoneRepeaterClientPortSegment petasosAuditServicesEndpoint) {
            this.petasosAuditServicesEndpoint = petasosAuditServicesEndpoint;
    }

    public JGroupsInterZoneRepeaterClientPortSegment getPetasosInterceptionEndpoint() {
            return petasosInterceptionEndpoint;
    }

    public void setPetasosInterceptionEndpoint(JGroupsInterZoneRepeaterClientPortSegment petasosInterceptionEndpoint) {
            this.petasosInterceptionEndpoint = petasosInterceptionEndpoint;
    }

    public JGroupsInterZoneRepeaterClientPortSegment getPetasosTaskingServicesEndpoint() {
            return petasosTaskingServicesEndpoint;
    }

    public void setPetasosTaskingServicesEndpoint(JGroupsInterZoneRepeaterClientPortSegment petasosTaskingServicesEndpoint) {
            this.petasosTaskingServicesEndpoint = petasosTaskingServicesEndpoint;
    }

    public JGroupsInterZoneRepeaterClientPortSegment getMultiuseInfinispanEndpoint() {
            return multiuseInfinispanEndpoint;
    }

    public void setMultiuseInfinispanEndpoint(JGroupsInterZoneRepeaterClientPortSegment multiuseInfinispanEndpoint) {
            this.multiuseInfinispanEndpoint = multiuseInfinispanEndpoint;
    }

    public JGroupsInterZoneRepeaterClientPortSegment getPetasosObservationsEndpoint() {
            return petasosObservationsEndpoint;
    }

    public void setPetasosObservationsEndpoint(JGroupsInterZoneRepeaterClientPortSegment petasosObservationsEndpoint) {
            this.petasosObservationsEndpoint = petasosObservationsEndpoint;
    }

    public JGroupsInterZoneRepeaterClientPortSegment getPetasosMessagingEndpoint() {
            return petasosMessagingEndpoint;
    }

    public void setPetasosMessagingEndpoint(JGroupsInterZoneRepeaterClientPortSegment petasosMessagingEndpoint) {
            this.petasosMessagingEndpoint = petasosMessagingEndpoint;
    }

    public HTTPServerEndpointSegment getEdgeAnswer() {
            return edgeAnswer;
    }

    public void setEdgeAnswer(HTTPServerEndpointSegment edgeAnswer) {
            this.edgeAnswer = edgeAnswer;
    }

    public JGroupsInterZoneRepeaterClientPortSegment getPetasosTopologyServicesEndpoint() {
            return petasosTopologyServicesEndpoint;
    }

    public void setPetasosTopologyServicesEndpoint(
                    JGroupsInterZoneRepeaterClientPortSegment petasosTopologyServicesEndpoint) {
            this.petasosTopologyServicesEndpoint = petasosTopologyServicesEndpoint;
    }
    
    public JGroupsInterZoneRepeaterClientPortSegment getPetasosMediaServicesEndpoint() {
		return petasosMediaServicesEndpoint;
	}

	public void setPetasosMediaServicesEndpoint(JGroupsInterZoneRepeaterClientPortSegment petasosMediaServicesEndpoint) {
		this.petasosMediaServicesEndpoint = petasosMediaServicesEndpoint;
	}
	
    //
    // functionConfigurationFileReturn
    //
    

	public JGroupsInterZoneRepeaterClientPortSegment resolveConfigurationDetail(ClusterFunctionNameEnum functionName) {
    	if(functionName == null) {
    		return(null);
    	}	
    	switch(functionName) {
	    	case PETASOS_TOPOLOGY_SERVICES:{
	    		return(getPetasosTopologyServicesEndpoint());
	    	}
	    	case PETASOS_ROUTING_SERVICES:{
	    		return(getPetasosRoutingServicesEndpoint());
	    	}
	    	case PETASOS_TASKING_SERVICES:{
	    		return(getPetasosTaskingServicesEndpoint());
	    	}
	    	case PETASOS_INTERCEPTION_SERVICES:{
	    		return(getPetasosInterceptionEndpoint());
	    	}
	    	case PETASOS_OBSERVATION_SERVICES:{
	    		return(getPetasosObservationsEndpoint());
	    	}
	    	case PETASOS_AUDIT_SERVICES:{
	    		return(getPetasosAuditServicesEndpoint());
	    	}
	    	case PETASOS_RMI_SERVICES:{
	    		return(getPetasosMessagingEndpoint());
	    	}
	    	case PETASOS_MULTI_INFINISPAN:{
	    		return(getMultiuseInfinispanEndpoint());
	    	}
	    	default:{
	    		return(null);
	    	}
    	}
    }

    //
    // To String
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PetasosPropertyFile{");
        sb.append("petasosMessagingEndpoint=").append(petasosMessagingEndpoint);
        sb.append(", petasosTopologyDiscoveryEndpoint=").append(petasosTopologyServicesEndpoint);
        sb.append(", petasosSubscriptionsEndpoint=").append(petasosRoutingServicesEndpoint);
        sb.append(", petasosAuditServicesEndpoint=").append(petasosAuditServicesEndpoint);
        sb.append(", petasosInterceptionEndpoint=").append(petasosInterceptionEndpoint);
        sb.append(", petasosTaskServicesEndpoint=").append(petasosTaskingServicesEndpoint);
        sb.append(", petasosMetricsEndpoint=").append(petasosObservationsEndpoint);
        sb.append(", multiuseInfinispanEndpoint=").append(multiuseInfinispanEndpoint);
        sb.append(", defaultPeerFailureRetries=").append(defaultPeerFailureRetries);
        sb.append(", defaultPeerStartupDelay=").append(defaultPeerStartupDelay);
        sb.append(", defaultPetasosIPCWatchdogCheckPeriod=").append(defaultPetasosIPCWatchdogCheckPeriod);
        sb.append(", defaultPetasosIPCWatchdogStartupDelay=").append(defaultPetasosIPCWatchdogStartupDelay);
        sb.append(", defaultPetasosTaskWatchdogCheckPeriod=").append(defaultPetasosTaskWatchdogCheckPeriod);
        sb.append(", defaultPetassoTaskWatchdogStartupDelay=").append(defaultPetasosTaskWatchdogStartupDelay);
        sb.append(", edgeAnswer=").append(edgeAnswer);
        sb.append(", edgeAsk=").append(edgeAsk);
        sb.append('}');
        return sb.toString();
    }


}
