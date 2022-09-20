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
package net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.processingplants.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;

import java.util.concurrent.ConcurrentHashMap;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.base.SoftwareComponentTopologyNodeBase;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workshops.base.WorkshopTopologyNodeBase;

public abstract class ProcessingPlantTopologyNode extends SoftwareComponentTopologyNodeBase {

    private ConcurrentHashMap<String, WorkshopTopologyNodeBase> workshopMap;
    private Object workshopMapLock;

    private String actualHostIP;
    private String actualPodIP;
    private String assignedDNSName;

    //
    // Constructor(s)
    //

    public ProcessingPlantTopologyNode(){
        super();
        
        this.setParticipantDisplayName(specifyParticipantName());
        this.setParticipantName(specifyParticipantDisplayName());
        this.setNodeVersion(specifyProcessingPlantVersion());
        
        this.workshopMap = new ConcurrentHashMap<>();
        this.workshopMapLock = new Object();

        this.assignedDNSName = null;
        this.actualHostIP = null;
        this.actualPodIP = null;

    }
    
    //
    // Abstract Methods
    //
    
    abstract protected String specifyParticipantName();
    abstract protected String specifyParticipantDisplayName();
    abstract protected String specifyProcessingPlantVersion();

    //
    // Getters and Setters
    //
    
    @JsonIgnore
    public boolean hasActualHostIP(){
        boolean hasValue = this.actualHostIP != null;
        return(hasValue);
    }

    public String getActualHostIP() {
        return actualHostIP;
    }

    public void setActualHostIP(String actualHostIP) {
        this.actualHostIP = actualHostIP;
    }

    @JsonIgnore
    public boolean hasActualPodIP(){
        boolean hasValue = this.actualPodIP != null;
        return(hasValue);
    }
    
    public String getActualPodIP() {
        return actualPodIP;
    }

    public void setActualPodIP(String actualPodIP) {
        this.actualPodIP = actualPodIP;
    }

    
    public ConcurrentHashMap<String, WorkshopTopologyNodeBase> getWorkshopMap() {
        return workshopMap;
    }

    public void setWorkshopMap(ConcurrentHashMap<String, WorkshopTopologyNodeBase> workshopMap) {
        this.workshopMap = workshopMap;
    }

    @JsonIgnore
    public Object getWorkshopMapLock() {
        return workshopMapLock;
    }

    @JsonIgnore
    public void setWorkshopMapLock(Object workshopMapLock) {
        this.workshopMapLock = workshopMapLock;
    }

    @JsonIgnore
    public boolean hasAssignedDNSName(){
        boolean hasValue = this.assignedDNSName != null;
        return(hasValue);
    }
    
    public String getAssignedDNSName() {
        return assignedDNSName;
    }

    public void setAssignedDNSName(String assignedDNSName) {
        this.assignedDNSName = assignedDNSName;
    }

    public void addWorkshop(WorkshopTopologyNodeBase workshopNode){
        if(workshopNode != null){
            synchronized(getWorkshopMapLock()){
                if(getWorkshopMap().containsKey(workshopNode.getParticipantName())){
                    getWorkshopMap().remove(workshopNode.getParticipantName());
                }
                getWorkshopMap().put(workshopNode.getParticipantName(), workshopNode);
            }
        }
    }
    
    public Set<WorkshopTopologyNodeBase> getWorkshopSet(){
        Set<WorkshopTopologyNodeBase> workshopSet = new HashSet<>();
        if(getWorkshopMap().isEmpty()){
            return(workshopSet);
        }
        synchronized(getWorkshopMapLock()){
            workshopSet.addAll(getWorkshopMap().values());
        }
        return(workshopSet);
    }

    //
    // To String
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProcessingPlantTopologyNode{");
        sb.append("workshopMap=").append(workshopMap);
        sb.append(", workshopMapLock=").append(workshopMapLock);
        sb.append(", actualHostIP=").append(actualHostIP);
        sb.append(", actualPodIP=").append(actualPodIP);
        sb.append(", assignedDNSName=").append(assignedDNSName);
        sb.append(", ").append(super.toString()).append("}");
        return sb.toString();
    }


}
