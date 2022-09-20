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

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workshops.base.WorkshopTopologyNodeBase;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.base.WorkUnitProcessorTopologyNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mhunter
 */
public class TransformWorkshopTN extends WorkshopTopologyNodeBase{
    private static final Logger LOG = LoggerFactory.getLogger(TransformWorkshopTN.class);
    
    private ConcurrentHashMap<String, WorkUnitProcessorTopologyNode> transformationWorkUnitProcessorMap;
    private Object transformationWorkUnitProcessorMapLock;
    
    
    private static final String WORKSHOP_NAME = "Transforms";
       
    //
    // Constructor(s)
    //
    
    public TransformWorkshopTN(){
        super();
        this.transformationWorkUnitProcessorMap = new ConcurrentHashMap<>();
        this.transformationWorkUnitProcessorMapLock = new Object();
    }
    
    public TransformWorkshopTN(String processingPlantParticipantName, String processingPlantVersion){
        super();
        this.transformationWorkUnitProcessorMap = new ConcurrentHashMap<>();
        this.transformationWorkUnitProcessorMapLock = new Object();
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

    public ConcurrentHashMap<String, WorkUnitProcessorTopologyNode> getTransformationWorkUnitProcessorMap() {
        return transformationWorkUnitProcessorMap;
    }

    public void setTransformationWorkUnitProcessorMap(ConcurrentHashMap<String, WorkUnitProcessorTopologyNode> transformationWorkUnitProcessorMap) {
        this.transformationWorkUnitProcessorMap = transformationWorkUnitProcessorMap;
    }

    public Object getTransformationWorkUnitProcessorMapLock() {
        return transformationWorkUnitProcessorMapLock;
    }

    public void setTransformationWorkUnitProcessorMapLock(Object transformationWorkUnitProcessorMapLock) {
        this.transformationWorkUnitProcessorMapLock = transformationWorkUnitProcessorMapLock;
    }

    @JsonIgnore
    @Override
    public Set<WorkUnitProcessorTopologyNode> getWUPSet(){
        Set<WorkUnitProcessorTopologyNode> wupSet = new HashSet<>();
        if(getTransformationWorkUnitProcessorMap().isEmpty()){
            return(wupSet);
        }
        synchronized (getTransformationWorkUnitProcessorMapLock()){
            wupSet.addAll(getTransformationWorkUnitProcessorMap().values());
        }
        return(wupSet);
    }
    
    //
    // toString
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransformWorkshopTopologyNode{");
        sb.append("transformationWorkUnitProcessorMap=").append(transformationWorkUnitProcessorMap);
        sb.append(", transformationWorkUnitProcessorMapLock=").append(transformationWorkUnitProcessorMapLock);
        sb.append(", ").append(super.toString()).append('}');
        return sb.toString();
    }

    
   
    
    
}
