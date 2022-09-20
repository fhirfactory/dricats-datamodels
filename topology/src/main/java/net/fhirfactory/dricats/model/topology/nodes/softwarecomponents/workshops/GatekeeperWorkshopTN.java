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

import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.processingplants.base.ProcessingPlantTopologyNode;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workshops.base.WorkshopTopologyNodeBase;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.gatekeeper.InboundCheckpointTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.gatekeeper.OutboundCheckpointTN;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mhunter
 */
public class GatekeeperWorkshopTN extends WorkshopTopologyNodeBase{
    private static final Logger LOG = LoggerFactory.getLogger(GatekeeperWorkshopTN.class);
    
    private InboundCheckpointTN inboundCheckpoint;
    private OutboundCheckpointTN outboundCheckpoint;
    
    
    private static final String WORKSHOP_NAME = "Gatekeeper";
       
    //
    // Constructor(s)
    //
    
    public GatekeeperWorkshopTN(){
        super();
        this.inboundCheckpoint = null;
        this.outboundCheckpoint = null;
    }
    
    public GatekeeperWorkshopTN(ProcessingPlantTopologyNode processingPlant){
        super();
        this.setParticipantDisplayName(WORKSHOP_NAME);
        this.setParticipantName(processingPlant.getParticipantName() + "." + WORKSHOP_NAME);
        this.setNodeVersion(processingPlant.getNodeVersion());
        this.loadConfigurationFromParent(processingPlant);
        this.inboundCheckpoint = new InboundCheckpointTN(this.getParticipantName(), processingPlant.getNodeVersion());
        this.outboundCheckpoint = new OutboundCheckpointTN(this.getParticipantName(), processingPlant.getNodeVersion());
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

    public InboundCheckpointTN getInboundCheckpoint() {
        return inboundCheckpoint;
    }

    public void setInboundCheckpoint(InboundCheckpointTN inboundCheckpoint) {
        this.inboundCheckpoint = inboundCheckpoint;
        addWorkUnitProcessor(inboundCheckpoint);
    }

    public OutboundCheckpointTN getOutboundCheckpoint() {
        return outboundCheckpoint;
    }

    public void setOutboundCheckpoint(OutboundCheckpointTN outboundCheckpoint) {
        this.outboundCheckpoint = outboundCheckpoint;
        addWorkUnitProcessor(outboundCheckpoint);
    }


    
    //
    // toString
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GatekeeperWorkshopTopologyNode{");
        sb.append("inboundCheckpoint=").append(inboundCheckpoint);
        sb.append(", outboundCheckpoint=").append(outboundCheckpoint);
        sb.append(", ").append(super.toString()).append('}');
        return sb.toString();
    }


    
}
