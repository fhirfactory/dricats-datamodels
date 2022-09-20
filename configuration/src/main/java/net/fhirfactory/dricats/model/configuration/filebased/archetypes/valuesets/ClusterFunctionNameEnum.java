/*
 * The MIT License
 *
 * Copyright 2022 mhunter.
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
package net.fhirfactory.dricats.model.configuration.filebased.archetypes.valuesets;

/**
 *
 * @author mhunter
 */
public enum ClusterFunctionNameEnum {
    PETASOS_TOPOLOGY_SERVICES("Petasos.Topology", "petasos-top", "InternalIPC.TopologyServices"),
    PETASOS_ROUTING_SERVICES("Petasos.Routing", "petasos-rte", "InternalIPC.RoutingServices"),
    PETASOS_TASKING_SERVICES("Petasos.Tasking", "petasos-task", "InternalIPC.TaskingServices"),
    PETASOS_INTERCEPTION_SERVICES("Petasos.Snoop", "petasos-snoop", "InternalIPC.InterceptionServices"),
    PETASOS_OBSERVATION_SERVICES("Petasos.Observations", "petasos-obs", "InternalIPC.ObservationsServices"),
    PETASOS_AUDIT_SERVICES("Petasos.Audit", "petasos-audit", "InternalIPC.AuditService"),
    PETASOS_RMI_SERVICES("Petasos.RMI", "petasos-rmi", "InternalIPC.RMI"),
    PETASOS_MEDIA_SERVICES("Petasos.Media", "petasos-media", "InternalIPC.Media"),
    PETASOS_FHIR_SERVICES("Petasos.FHIR", "petasos-fhir", "InternalIPC.FHIR-RMI"),
    PETASOS_EDGE_ANSWER("EdgeAnswer", "edge-answer", "InternalIPC.FHIR.Servers"),
    PETASOS_EDGE_ASK("EdgeAsk", "edge-ask", "InternalIPC.FHIR.Clients"),
    PETASOS_MULTI_INFINISPAN("DataGrid", "multi-infini", "InternalIPC.DataGridServices");

    private String configName;
    private String groupName;
    private String participantName;

    private ClusterFunctionNameEnum(String groupName, String configName, String participantName){
        this.configName = configName;
        this.groupName = groupName;
        this.participantName = participantName;
    }

    public String getConfigName() {
        return configName;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getParticipantName() {
        return participantName;
    }

    public static ClusterFunctionNameEnum fromConfigName(String configName){
        if(configName == null){
            return(null);
        }
        for(ClusterFunctionNameEnum currentName: ClusterFunctionNameEnum.values()){
            if(currentName.getConfigName().equalsIgnoreCase(configName)){
                return(currentName);
            }
        }
        return(null);
    }   
    
        public static ClusterFunctionNameEnum fromGroupName(String groupName){
        if(groupName == null){
            return(null);
        }
        for(ClusterFunctionNameEnum currentName: ClusterFunctionNameEnum.values()){
            if(currentName.getGroupName().equalsIgnoreCase(groupName)){
                return(currentName);
            }
        }
        return(null);
    }
}
