/*
 * Copyright (c) 2020 Mark A. Hunter (ACT Health)
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
package net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workshops.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.base.SoftwareComponentTopologyNodeBase;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.processingplants.base.ProcessingPlantTopologyNode;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.base.WorkUnitProcessorTopologyNode;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class WorkshopTopologyNodeBase extends SoftwareComponentTopologyNodeBase {

    private Map<String, WorkUnitProcessorTopologyNode> wupMap;
    private Object wupMapLock;
      
    //
    // Constructor(s)
    //
    
    public WorkshopTopologyNodeBase(){
        super();
        wupMap = new ConcurrentHashMap<>();
        wupMapLock = new Object();
    }
        
    //
    // Getters and Setters
    //

    public Map<String, WorkUnitProcessorTopologyNode> getWUPMap() {
        return wupMap;
    }

    public void setWUPMap(Map<String, WorkUnitProcessorTopologyNode> wupSet) {
        this.wupMap = wupSet;
    }

    public Object getWupMapLock(){
        return(wupMapLock);
    }

    @JsonIgnore
    public void addWorkUnitProcessor(WorkUnitProcessorTopologyNode wupNode){
        if(wupNode != null) {
            if(StringUtils.isNotEmpty(wupNode.getParticipantName())) {
                synchronized (getWupMapLock()) {
                    if (getWUPMap().containsKey(wupNode.getParticipantName())){
                        getWUPMap().remove(wupNode.getParticipantName());
                    }
                    getWUPMap().put(wupNode.getParticipantName(), wupNode);
                }
            }
        }
    }

    @JsonIgnore
    public Set<WorkUnitProcessorTopologyNode> getWUPSet(){
        Set<WorkUnitProcessorTopologyNode> wupSet = new HashSet<>();
        if(getWUPMap().isEmpty()){
            return(wupSet);
        }
        synchronized (getWupMapLock()){
            wupSet.addAll(getWUPMap().values());
        }
        return(wupSet);
    }

    //
    // toString()
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WorkshopTopologyNode{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
    
    //
    // Helper Methods
    //
    
    public void loadConfigurationFromParent(ProcessingPlantTopologyNode processingPlantNode){
        if(processingPlantNode.hasInstructureNode()){
            setInfrastructureNode(processingPlantNode.getInfrastructureNode());
        }
        if(processingPlantNode.hasPlatformNode()){
            setPlatformNode(processingPlantNode.getPlatformNode());
        }
        setResilienceMode(processingPlantNode.getResilienceMode());
        setConcurrencyMode(processingPlantNode.getConcurrencyMode());
        setEnabled(processingPlantNode.isEnabled());
        setNetworkContext(processingPlantNode.getNetworkContext());
        setReplicationCount(processingPlantNode.getReplicationCount());
        if(processingPlantNode.hasSystemNode()){
            setSystemNode(processingPlantNode.getSystemNode());
        }
        if(processingPlantNode.hasSiteNode()){
            setSiteNode(processingPlantNode.getSiteNode());
        }
        if(processingPlantNode.hasSubsystemParticipantName()){
            setSubsystemParticipantName(processingPlantNode.getSubsystemParticipantName());
        }
    }
    
}
