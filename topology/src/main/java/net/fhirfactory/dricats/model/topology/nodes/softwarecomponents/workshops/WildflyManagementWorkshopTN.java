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
package net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workshops;

import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workshops.base.WorkshopTopologyNodeBase;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.wildfly.WildflyJolokiaServiceTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.wildfly.WildflyLivelinessServiceTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.wildfly.WildflyPrometheusServiceTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.wildfly.WildflyReadinessServiceTN;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mhunter
 */
public class WildflyManagementWorkshopTN extends WorkshopTopologyNodeBase{
    private static final Logger LOG = LoggerFactory.getLogger(GatekeeperWorkshopTN.class);
    
    private WildflyLivelinessServiceTN livelinessServiceNode;
    private WildflyReadinessServiceTN readinessServiceNode;
    private WildflyPrometheusServiceTN prometheusServiceNode;
    private WildflyJolokiaServiceTN jolokiaServiceNode;
    
    private static final String WORKSHOP_NAME = "WildflyManagement";
    
    public WildflyManagementWorkshopTN(){
        super();
        this.livelinessServiceNode = null;
        this.readinessServiceNode = null;
        this.prometheusServiceNode = null;
        this.jolokiaServiceNode = null;
    }
    
    public WildflyManagementWorkshopTN(String processingPlantParticipantName, String processingPlantVersion){
        super();
        this.setParticipantDisplayName(WORKSHOP_NAME);
        this.setParticipantName(processingPlantParticipantName + "." + WORKSHOP_NAME);
        this.setNodeVersion(processingPlantVersion);
        this.livelinessServiceNode = new WildflyLivelinessServiceTN(getParticipantName(), processingPlantVersion);
        this.readinessServiceNode = new WildflyReadinessServiceTN(getParticipantName(), processingPlantVersion);
        this.prometheusServiceNode = new WildflyPrometheusServiceTN(getParticipantName(), processingPlantVersion);
        this.jolokiaServiceNode = new WildflyJolokiaServiceTN(getParticipantName(), processingPlantVersion);
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

    public WildflyLivelinessServiceTN getLivelinessServiceNode() {
        return livelinessServiceNode;
    }

    public void setLivelinessServiceNode(WildflyLivelinessServiceTN livelinessServiceNode) {
        this.livelinessServiceNode = livelinessServiceNode;
        addWorkUnitProcessor(livelinessServiceNode);
    }

    public WildflyReadinessServiceTN getReadinessServiceNode() {
        return readinessServiceNode;
    }

    public void setReadinessServiceNode(WildflyReadinessServiceTN readinessServiceNode) {
        this.readinessServiceNode = readinessServiceNode;
        addWorkUnitProcessor(readinessServiceNode);
    }

    public WildflyPrometheusServiceTN getPrometheusServiceNode() {
        return prometheusServiceNode;
    }

    public void setPrometheusServiceNode(WildflyPrometheusServiceTN prometheusServiceNode) {
        this.prometheusServiceNode = prometheusServiceNode;
        addWorkUnitProcessor(prometheusServiceNode);
    }

    public WildflyJolokiaServiceTN getJolokiaServiceNode() {
        return jolokiaServiceNode;
    }

    public void setJolokiaServiceNode(WildflyJolokiaServiceTN jolokiaServiceNode) {
        this.jolokiaServiceNode = jolokiaServiceNode;
        addWorkUnitProcessor(jolokiaServiceNode);
    }
    
    
    //
    // toString
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WildflyManagementWorkshopTopologyNode{");
        sb.append("livelinessServiceNode=").append(livelinessServiceNode);
        sb.append(", readinessServiceNode=").append(readinessServiceNode);
        sb.append(", prometheusServiceNode=").append(prometheusServiceNode);
        sb.append(", jolokiaServiceNode=").append(jolokiaServiceNode);
        sb.append(", ").append(super.toString()).append('}');
        return sb.toString();
    }
    
    
}
