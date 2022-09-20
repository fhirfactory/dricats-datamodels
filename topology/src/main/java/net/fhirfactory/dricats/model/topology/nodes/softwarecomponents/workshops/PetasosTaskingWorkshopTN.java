/*
 * The MIT License
 *
 * Copyright 2022 Mark A. Hunter (ACT Health).
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
package net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workshops;

import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workshops.base.WorkshopTopologyNodeBase;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.PetasosOversightTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.tasking.PetasosActionableTaskActivityManagerTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.tasking.PetasosActionableTaskOversightManagerTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.tasking.PetasosAuditEventServicesManagerTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.tasking.PetasosFulfillmentTaskActivityManagerTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.tasking.PetasosFulfillmentTaskOutcomeProcessorTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.tasking.PetasosParticipantOversightManagerTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.tasking.PetasosTaskContinuityProcessorTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.tasking.PetasosTaskRoutingProcessorTN;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mhunter
 */
public class PetasosTaskingWorkshopTN extends WorkshopTopologyNodeBase{
    private static final Logger LOG = LoggerFactory.getLogger(PetasosTaskingWorkshopTN.class);
    
    private PetasosFulfillmentTaskActivityManagerTN fulfillmentManager;
    private PetasosFulfillmentTaskOutcomeProcessorTN outcomeProcessor;
    
    private PetasosTaskRoutingProcessorTN routingService;
    private PetasosTaskContinuityProcessorTN continuityService;
    
    private PetasosActionableTaskActivityManagerTN actionableTaskActivityManager;
    private PetasosActionableTaskOversightManagerTN actionableTaskOversightManager;
    
    private PetasosParticipantOversightManagerTN participantOversightManager;
    private PetasosOversightTN oversightService;
    private PetasosAuditEventServicesManagerTN auditService;
    
    private static final String WORKSHOP_NAME = "Petasos.Tasking";
    
    //
    // Constructor(s)
    //
    
    public PetasosTaskingWorkshopTN(){
        super();
        this.fulfillmentManager = null;
        this.outcomeProcessor = null;
        this.routingService = null;
        this.continuityService = null;
        this.actionableTaskActivityManager = null;
        this.actionableTaskOversightManager = null;
        this.oversightService = null;
        this.participantOversightManager = null;
        this.auditService = null;
    }
    
    public PetasosTaskingWorkshopTN(String processingPlantParticipantName, String processingPlantVersion){
        super();
        this.routingService = null;
        this.outcomeProcessor = null;
        this.fulfillmentManager = null;
        this.auditService = null;
        this.setParticipantDisplayName(WORKSHOP_NAME);
        this.setParticipantName(processingPlantParticipantName + "." + WORKSHOP_NAME);
        this.setNodeVersion(processingPlantVersion);
    }
    
    
    //
    // Overriden Methods
    //
    
    @Override
    protected Logger getLogger(){
        return(LOG);
    }
    
    //
    // Getters and Setters
    //

    public PetasosFulfillmentTaskActivityManagerTN getFulfillmentManager() {
        return fulfillmentManager;
    }

    public void setFulfillmentManager(PetasosFulfillmentTaskActivityManagerTN fulfillmentManager) {
        this.fulfillmentManager = fulfillmentManager;
        addWorkUnitProcessor(fulfillmentManager);
    }

    public PetasosFulfillmentTaskOutcomeProcessorTN getOutcomeProcessor() {
        return outcomeProcessor;
    }

    public void setOutcomeProcessor(PetasosFulfillmentTaskOutcomeProcessorTN outcomeProcessor) {
        this.outcomeProcessor = outcomeProcessor;
        addWorkUnitProcessor(outcomeProcessor);
    }

    public PetasosTaskRoutingProcessorTN getRoutingService() {
        return routingService;
    }

    public void setRoutingService(PetasosTaskRoutingProcessorTN routingService) {
        this.routingService = routingService;
        addWorkUnitProcessor(routingService);
    }

    public PetasosTaskContinuityProcessorTN getContinuityService() {
        return continuityService;
    }

    public void setContinuityService(PetasosTaskContinuityProcessorTN continuityService) {
        this.continuityService = continuityService;
        addWorkUnitProcessor(continuityService);
    }

    public PetasosActionableTaskActivityManagerTN getActionableTaskActivityManager() {
        return actionableTaskActivityManager;
    }

    public void setActionableTaskActivityManager(PetasosActionableTaskActivityManagerTN actionableTaskActivityManager) {
        this.actionableTaskActivityManager = actionableTaskActivityManager;
        addWorkUnitProcessor(actionableTaskActivityManager);
    }

    public PetasosActionableTaskOversightManagerTN getActionableTaskOversightManager() {
        return actionableTaskOversightManager;
    }

    public void setActionableTaskOversightManager(PetasosActionableTaskOversightManagerTN actionableTaskOversightManager) {
        this.actionableTaskOversightManager = actionableTaskOversightManager;
        addWorkUnitProcessor(actionableTaskOversightManager);
    }

    public PetasosParticipantOversightManagerTN getParticipantOversightManager() {
        return participantOversightManager;
    }

    public void setParticipantOversightManager(PetasosParticipantOversightManagerTN participantOversightManager) {
        this.participantOversightManager = participantOversightManager;
        addWorkUnitProcessor(participantOversightManager);
    }

    public PetasosOversightTN getOversightService() {
        return oversightService;
    }

    public void setOversightService(PetasosOversightTN oversightService) {
        this.oversightService = oversightService;
        addWorkUnitProcessor(oversightService);
    }

    public PetasosAuditEventServicesManagerTN getAuditService() {
        return auditService;
    }

    public void setAuditService(PetasosAuditEventServicesManagerTN auditService) {
        this.auditService = auditService;
        addWorkUnitProcessor(auditService);
    }

    //
    // toString
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PetasosTaskingWorkshopTN{");
        sb.append("fulfillmentManager=").append(fulfillmentManager);
        sb.append(", outcomeProcessor=").append(outcomeProcessor);
        sb.append(", routingService=").append(routingService);
        sb.append(", continuityService=").append(continuityService);
        sb.append(", actionableTaskActivityManager=").append(actionableTaskActivityManager);
        sb.append(", actionableTaskOversightManager=").append(actionableTaskOversightManager);
        sb.append(", participantOversightManager=").append(participantOversightManager);
        sb.append(", oversightService=").append(oversightService);
        sb.append(", auditService=").append(auditService);
        sb.append(", ").append(super.toString()).append('}');
        return sb.toString();
    }

}
