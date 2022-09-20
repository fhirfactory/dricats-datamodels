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
package net.fhirfactory.dricats.model.petasos.ipc.endpoints.valuesets;

@Deprecated
public enum ClusterServiceTypeEnum {
    PETASOS_INFINISPAN_ENDPOINT("petasos.endpoint_function.infinispan", "Infinispan", "JGroups.Infinispan"),
    PETASOS_INTERACT_ENDPOINT("petasos.endpoint_function.interact", "Interact", "JGroups.Interact"),
    PETASOS_MESSAGING_ENDPOINT("petasos.endpoint_function.messaging_services","MessagingServices", "JGroups.MessagingServices"),
    PETASOS_ROUTING_ENDPOINT("petasos.endpoint_function.routing_services", "RoutingServices","JGroups.RoutingServices"),
    PETASOS_INTERCEPTION_ENDPOINT("petasos.endpoint_function.interception_services", "InterceptionServices", "JGroups.InterceptionServices"),
    PETASOS_TASKING_ENDPOINT("petasos.endpoint_function.tasking_services", "TaskingServices", "JGroups.TaskingServices"),
    PETASOS_AUDIT_ENDPOINT("petasos.endpoint_function.audit_services", "AuditServices", "JGroups.AuditServices"),
    PETASOS_OBSERVATIONS_ENDPOINT("petasos.endpoint_function.observation_services", "ObservationServices", "JGroups.Observations"),
    PETASOS_TOPOLOGY_ENDPOINT("petasos.endpoint_function.topology_services", "TopologyServices", "JGroups.TopologyServices");

    private String token;
    private String displayName;
    private String endpointParticipantName;

    private ClusterServiceTypeEnum(String functionType, String displayName, String participantName ){
        this.token = functionType;
        this.displayName = displayName;
        this.endpointParticipantName = participantName;
    }

    public String getToken(){
        return(this.token);
    }

    public String getDisplayName(){
        return(this.displayName);
    }

    public String getEndpointParticipantName(){
        return(this.endpointParticipantName);
    }

    public static ClusterServiceTypeEnum getFunctionEnumFromDisplayName(String displayName){
        for(ClusterServiceTypeEnum currentFunction: ClusterServiceTypeEnum.values()){
            if(currentFunction.getDisplayName().equalsIgnoreCase(displayName)){
                return(currentFunction);
            }
        }
        return(null);
    }
}
