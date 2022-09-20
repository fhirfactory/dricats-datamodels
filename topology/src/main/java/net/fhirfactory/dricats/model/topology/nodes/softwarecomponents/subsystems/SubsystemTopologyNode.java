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
package net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.subsystems;

import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.processingplants.base.ProcessingPlantTopologyNode;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.base.SoftwareComponentTopologyNodeBase;

public class SubsystemTopologyNode extends SoftwareComponentTopologyNodeBase {
    private static final Logger LOG = LoggerFactory.getLogger(SubsystemTopologyNode.class);

    // ConcurrentHashMap<ParticipantName, ProcessingPlantTopologyNode>
    private ConcurrentHashMap<String, ProcessingPlantTopologyNode> processingPlantMap;
    private Object processingPlantMapLock;
    
    //
    // Constructor(s)
    //

    public SubsystemTopologyNode(){
        super();
        processingPlantMap = new ConcurrentHashMap<>();
        processingPlantMapLock = new Object();
    }
    
    //
    // Getters and Setters
    // 

    @Override
    protected Logger getLogger() {
        return (LOG);
    }

    public ConcurrentHashMap<String, ProcessingPlantTopologyNode> getProcessingPlantMap() {
        return processingPlantMap;
    }

    public void setProcessingPlantMap(ConcurrentHashMap<String, ProcessingPlantTopologyNode> processingPlantMap) {
        this.processingPlantMap = processingPlantMap;
    }

    public Object getProcessingPlantMapLock() {
        return processingPlantMapLock;
    }

    public void setProcessingPlantMapLock(Object processingPlantMapLock) {
        this.processingPlantMapLock = processingPlantMapLock;
    }
    
    public void addProcessingPlant(ProcessingPlantTopologyNode processingPlantNode){
        if(processingPlantNode != null){
            synchronized(getProcessingPlantMapLock()){
                if(getProcessingPlantMap().containsKey(processingPlantNode.getParticipantName())){
                    getProcessingPlantMap().remove(processingPlantNode.getParticipantName());
                }
                getProcessingPlantMap().put(processingPlantNode.getParticipantName(), processingPlantNode);
            }
        }
    }
    
    public Set<ProcessingPlantTopologyNode> getProcessingPlantSet(){
        Set<ProcessingPlantTopologyNode> plantSet = new HashSet<>();
        if(getProcessingPlantMap().isEmpty()){
            return(plantSet);
        }
        synchronized(getProcessingPlantMapLock()){
            plantSet.addAll(getProcessingPlantMap().values());
        }
        return(plantSet);
    }

    
    //
    // To String
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SubsystemTopologyNode{");
        sb.append("processingPlantMap=").append(processingPlantMap);
        sb.append("processingPlantMapLock=").append(processingPlantMapLock);
        sb.append(", ").append(super.toString()).append("}");
        return sb.toString();
    }
    
}
