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
package net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workshops;

import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workshops.base.WorkshopTopologyNodeBase;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.PetasosObservationServicesConnectionTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.ipc.InternalMessagingEgressProxyTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.ipc.InternalMessagingIngressProxyTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.ipc.PetasosAuditServicesConnectionTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.ipc.PetasosEdgeAskTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.ipc.PetasosInterceptionServicesConnectionTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.ipc.PetasosMediaServicesConnectionTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.ipc.PetasosMessagingServicesConnectionTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.ipc.PetasosRoutingServicesConnectionTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.ipc.PetasosTaskingServicesConnectionTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.ipc.PetasosTopologyServicesConnectionTN;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mhunter
 */
public class PetasosIPCWorkshopTN extends WorkshopTopologyNodeBase{
    private static final Logger LOG = LoggerFactory.getLogger(PetasosIPCWorkshopTN.class);
    
    private static final String WORKSHOP_NAME = "Petasos.IPC";
    
    private PetasosTopologyServicesConnectionTN topologyServicesConnection;
    private PetasosTaskingServicesConnectionTN taskingServicesConnection;
    private PetasosRoutingServicesConnectionTN routingServicesConnection;
    private PetasosObservationServicesConnectionTN observationsServicesConnection;
    private PetasosMessagingServicesConnectionTN messagingServicesConnection;
    private PetasosMediaServicesConnectionTN mediaServicesConnection;
    private PetasosInterceptionServicesConnectionTN interceptionServicesConnection;
    private PetasosAuditServicesConnectionTN auditServicesConnection;
    
    private InternalMessagingIngressProxyTN ingresProxy;
    private InternalMessagingEgressProxyTN egressProxy;
    private PetasosEdgeAskTN edgeAsk;
    
    //
    // Constructor(s)
    //
    
    public PetasosIPCWorkshopTN(){
        super();
        this.topologyServicesConnection = null;
        this.taskingServicesConnection = null;
        this.routingServicesConnection = null;
        this.observationsServicesConnection = null;
        this.messagingServicesConnection = null;
        this.mediaServicesConnection = null;
        this.interceptionServicesConnection = null;
        this.auditServicesConnection = null;
        this.ingresProxy = null;
        this.egressProxy = null;
        this.edgeAsk = null;
    }
    
    public PetasosIPCWorkshopTN(String processingPlantParticipantName, String processingPlantVersion){
        super();
        this.setParticipantDisplayName(WORKSHOP_NAME);
        this.setParticipantName(processingPlantParticipantName + "." + WORKSHOP_NAME);
        this.setNodeVersion(processingPlantVersion);
        this.topologyServicesConnection = new PetasosTopologyServicesConnectionTN(this.getParticipantName(), processingPlantVersion);
        this.taskingServicesConnection = new PetasosTaskingServicesConnectionTN(this.getParticipantName(), processingPlantVersion);
        this.routingServicesConnection = new PetasosRoutingServicesConnectionTN(this.getParticipantName(), processingPlantVersion);
        this.observationsServicesConnection = new PetasosObservationServicesConnectionTN(this.getParticipantName(), processingPlantVersion);
        this.messagingServicesConnection = new PetasosMessagingServicesConnectionTN(this.getParticipantName(), processingPlantVersion);
        this.mediaServicesConnection = new PetasosMediaServicesConnectionTN(this.getParticipantName(), processingPlantVersion);
        this.interceptionServicesConnection = new PetasosInterceptionServicesConnectionTN(this.getParticipantName(), processingPlantVersion);
        this.auditServicesConnection = new PetasosAuditServicesConnectionTN(this.getParticipantName(), processingPlantVersion);
        this.ingresProxy = new InternalMessagingIngressProxyTN(this.getParticipantName(), processingPlantVersion);
        this.egressProxy = new InternalMessagingEgressProxyTN(this.getParticipantName(), processingPlantVersion);
        this.edgeAsk = new PetasosEdgeAskTN(this.getParticipantName(), processingPlantVersion);
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

    public PetasosTopologyServicesConnectionTN getTopologyServicesConnection() {
        return topologyServicesConnection;
    }

    public void setTopologyServicesConnection(PetasosTopologyServicesConnectionTN topologyServicesConnection) {
        this.topologyServicesConnection = topologyServicesConnection;
        addWorkUnitProcessor(topologyServicesConnection);
    }

    public PetasosTaskingServicesConnectionTN getTaskingServicesConnection() {
        return taskingServicesConnection;
    }

    public void setTaskingServicesConnection(PetasosTaskingServicesConnectionTN taskingServicesConnection) {
        this.taskingServicesConnection = taskingServicesConnection;
        addWorkUnitProcessor(taskingServicesConnection);
    }

    public PetasosRoutingServicesConnectionTN getRoutingServicesConnection() {
        return routingServicesConnection;
    }

    public void setRoutingServicesConnection(PetasosRoutingServicesConnectionTN routingServicesConnection) {
        this.routingServicesConnection = routingServicesConnection;
        addWorkUnitProcessor(routingServicesConnection);
    }

    public PetasosObservationServicesConnectionTN getObservationsServicesConnection() {
        return observationsServicesConnection;
    }

    public void setObservationsServicesConnection(PetasosObservationServicesConnectionTN observationsServicesConnection) {
        this.observationsServicesConnection = observationsServicesConnection;
        addWorkUnitProcessor(observationsServicesConnection);
    }

    public PetasosMessagingServicesConnectionTN getMessagingServicesConnection() {
        return messagingServicesConnection;
    }

    public void setMessagingServicesConnection(PetasosMessagingServicesConnectionTN messagingServicesConnection) {
        this.messagingServicesConnection = messagingServicesConnection;
        addWorkUnitProcessor(messagingServicesConnection);
    }

    public PetasosMediaServicesConnectionTN getMediaServicesConnection() {
        return mediaServicesConnection;
    }

    public void setMediaServicesConnection(PetasosMediaServicesConnectionTN mediaServicesConnection) {
        this.mediaServicesConnection = mediaServicesConnection;
        addWorkUnitProcessor(mediaServicesConnection);
    }

    public PetasosInterceptionServicesConnectionTN getInterceptionServicesConnection() {
        return interceptionServicesConnection;
    }

    public void setInterceptionServicesConnection(PetasosInterceptionServicesConnectionTN interceptionServicesConnection) {
        this.interceptionServicesConnection = interceptionServicesConnection;
        addWorkUnitProcessor(interceptionServicesConnection);
    }

    public PetasosAuditServicesConnectionTN getAuditServicesConnection() {
        return auditServicesConnection;
    }

    public void setAuditServicesConnection(PetasosAuditServicesConnectionTN auditServicesConnection) {
        this.auditServicesConnection = auditServicesConnection;
        addWorkUnitProcessor(auditServicesConnection);
    }

    public InternalMessagingIngressProxyTN getIngresProxy() {
        return ingresProxy;
    }

    public void setIngresProxy(InternalMessagingIngressProxyTN ingresProxy) {
        this.ingresProxy = ingresProxy;
        addWorkUnitProcessor(ingresProxy);
    }

    public InternalMessagingEgressProxyTN getEgressProxy() {
        return egressProxy;
    }

    public void setEgressProxy(InternalMessagingEgressProxyTN egressProxy) {
        this.egressProxy = egressProxy;
        addWorkUnitProcessor(egressProxy);
    }

    public PetasosEdgeAskTN getEdgeAsk() {
        return edgeAsk;
    }

    public void setEdgeAsk(PetasosEdgeAskTN edgeAsk) {
        this.edgeAsk = edgeAsk;
        addWorkUnitProcessor(edgeAsk);
    }
    
    //
    // toString
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PetasosIPCWorkshopTN{");
        sb.append("topologyServicesConnection=").append(topologyServicesConnection);
        sb.append(", taskingServicesConnection=").append(taskingServicesConnection);
        sb.append(", routingServicesConnection=").append(routingServicesConnection);
        sb.append(", observationsServicesConnection=").append(observationsServicesConnection);
        sb.append(", messagingServicesConnection=").append(messagingServicesConnection);
        sb.append(", mediaServicesConnection=").append(mediaServicesConnection);
        sb.append(", interceptionServicesConnection=").append(interceptionServicesConnection);
        sb.append(", auditServicesConnection=").append(auditServicesConnection);
        sb.append(", ingresProxy=").append(ingresProxy);
        sb.append(", egressProxy=").append(egressProxy);
        sb.append(", edgeAsk=").append(edgeAsk);
        sb.append(", ").append(super.toString()).append('}');
        return sb.toString();
    }
    

    
}
