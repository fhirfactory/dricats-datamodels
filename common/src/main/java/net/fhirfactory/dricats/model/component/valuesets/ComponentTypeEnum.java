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
package net.fhirfactory.dricats.model.component.valuesets;

public enum ComponentTypeEnum {
    OAM_WORKSHOP("OAM.Workshop", "dricats.component_type.operations_administration_and_maintenance_workshop"),
    OAM_WORK_UNIT_PROCESSOR("OAM.WUP", "dricats.component_type.operations_administration_and_maintenance_wup"),
    WUP("WUP", "dricats.component_type.wup"),
    WUP_CORE("WUP.Core", "dricats.component_type.wup_core"),
    PROCESSING_PLANT_PAYLOAD_TRANSFORMER("ProcessingPlant.Transformer", "dricats.component_type.processing_plant_payload_transfomer"),
    PROCESSING_PLANT_ROUTER("ProcessingPlant.Router", "dricats.component_type.processing_plant_router"),
    WUP_CONTAINER_INGRES_PROCESSOR("WUP.Container.IngresProcessor", "dricats.component_type.wup_ingres_processor"),
    WUP_CONTAINER_INGRES_GATEKEEPER("WUP.Container.IngresGatekeeper", "dricats.component_type.wup_ingres_gatekeeper"),
    WUP_CONTAINER_INGRES_CONDUIT("WUP.Container.IngresConduit", "dricats.component_type.wup_ingres_conduit"),
    WUP_CONTAINER_EGRESS_CONDUIT("WUP.Container.EgressConduit","dricats.component_type.wup_egress_conduit"),
    WUP_CONTAINER_EGRESS_PROCESSOR("WUP.Container.EgressProcessor", "dricats.component_type.wup_egress_processor"),
    WUP_CONTAINER_EGRESS_GATEKEEPER("WUP.Container.EgressGatekeeper", "dricats.component_type.wup_egress_gatekeeper"),
    WORKSHOP("Workshop", "dricats.component_type.workshop"),
    PROCESSING_PLANT("ProcessingPlant", "dricats.component_type.processing_plant"),
    INFRASTRUCTURE_NODE("InfrastructureNode", "dricats.component_type.infrastructure_node"),
    PLATFORM("Platform", "dricats.component_type.platform_service"),
    CLUSTER_SERVICE("ClusterService", "dricats.component_type.cluster_service"),
    SITE("Site", "dricats.component_type.site"),
    EXTERNALISED_SERVICE("ExternalisedService","dricats.component_type.externalised_service"),
    SUBSYSTEM("Subsystem", "dricats.component_type.subsystem"),
    SOLUTION("Solution", "dricats.component_type.solution"),
    ENDPOINT("Endpoint", "dricats.component_type.endpoint");

    private String token;
    private String displayName;

    private ComponentTypeEnum(String displayName, String  token){
        this.displayName = displayName;
        this.token = token;
    }

    public String getToken(){
        return(this.token);
    }

    public String getDisplayName(){
        return(this.displayName);
    }
}
