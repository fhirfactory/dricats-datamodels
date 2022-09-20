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

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workshops.base.WorkshopTopologyNodeBase;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.base.WorkUnitProcessorTopologyNode;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.fileshare.FileReaderProcessorTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.fileshare.FileWriterProcessorTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.tap.TAPSenderProcessorTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.tap.TAPReceiverProcessorTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.mllp.MLLPReceiverProcessorTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.mllp.MLLPSenderProcessorTN;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mhunter
 */
public class ExternalIPCWorkshopTN extends WorkshopTopologyNodeBase{
    private static final Logger LOG = LoggerFactory.getLogger(ExternalIPCWorkshopTN.class);
    
    private ConcurrentHashMap<String, WorkUnitProcessorTopologyNode> externalIPCProcessorMap;
    private Object externalIPCProcessorMapLock;
    
    private static final String WORKSHOP_NAME = "ExternalIPC";
    
    //
    // Constructor(s)
    //
    
    public ExternalIPCWorkshopTN(){
        super();
        this.externalIPCProcessorMap = new ConcurrentHashMap<>();
        this.externalIPCProcessorMapLock = new Object();
    }
    
    public ExternalIPCWorkshopTN(String processingPlantParticipantName, String processingPlantVersion){
        super();
        this.externalIPCProcessorMap = new ConcurrentHashMap<>();
        this.externalIPCProcessorMapLock = new Object();
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

    public ConcurrentHashMap<String, WorkUnitProcessorTopologyNode> getExternalIPCProcessorMap() {
        return externalIPCProcessorMap;
    }

    public void setExternalIPCProcessorMap(ConcurrentHashMap<String, WorkUnitProcessorTopologyNode> ipcWorkUnitProcessorMap) {
        this.externalIPCProcessorMap = ipcWorkUnitProcessorMap;
    }

    public Object getExternalIPCProcessorMapLock() {
        return externalIPCProcessorMapLock;
    }

    public void setExternalIPCProcessorMapLock(Object ipcWorkUnitProcessorMapLock) {
        this.externalIPCProcessorMapLock = ipcWorkUnitProcessorMapLock;
    }
    
    @JsonIgnore
    public Set<TAPSenderProcessorTN> getHTTPClientProcessors(){
        Set<TAPSenderProcessorTN> processorSet = new HashSet<>();
        if(!getExternalIPCProcessorMap().isEmpty()){
            synchronized(getExternalIPCProcessorMapLock()){
                for(WorkUnitProcessorTopologyNode currentNode: getExternalIPCProcessorMap().values()){
                    if(currentNode instanceof TAPSenderProcessorTN){
                        TAPSenderProcessorTN currentHTTPClientNode = (TAPSenderProcessorTN)currentNode;
                        processorSet.add(currentHTTPClientNode);
                    }

                }
            }
        }
        return(processorSet);
    }
    
    @JsonIgnore
    public Set<TAPReceiverProcessorTN> getHTTPServerProcessors(){
        Set<TAPReceiverProcessorTN> processorSet = new HashSet<>();
        if(!getExternalIPCProcessorMap().isEmpty()){
            synchronized(getExternalIPCProcessorMapLock()){
                for(WorkUnitProcessorTopologyNode currentNode: getExternalIPCProcessorMap().values()){
                    if(currentNode instanceof TAPReceiverProcessorTN){
                        TAPReceiverProcessorTN currentHTTPServerNode = (TAPReceiverProcessorTN)currentNode;
                        processorSet.add(currentHTTPServerNode);
                    }

                }
            }
        }
        return(processorSet);
    }
    
    @JsonIgnore
    public Set<MLLPSenderProcessorTN> getMLLPSenderProcessors(){
        Set<MLLPSenderProcessorTN> processorSet = new HashSet<>();
        if(!getExternalIPCProcessorMap().isEmpty()){
            synchronized(getExternalIPCProcessorMapLock()){
                for(WorkUnitProcessorTopologyNode currentNode: getExternalIPCProcessorMap().values()){
                    if(currentNode instanceof MLLPSenderProcessorTN){
                        MLLPSenderProcessorTN currentMLLPSenderNode = (MLLPSenderProcessorTN)currentNode;
                        processorSet.add(currentMLLPSenderNode);
                    }

                }
            }
        }
        return(processorSet);
    }
    
    @JsonIgnore
    public Set<MLLPReceiverProcessorTN> getMLLPReceiverProcessors(){
        Set<MLLPReceiverProcessorTN> processorSet = new HashSet<>();
        if(!getExternalIPCProcessorMap().isEmpty()){
            synchronized(getExternalIPCProcessorMapLock()){
                for(WorkUnitProcessorTopologyNode currentNode: getExternalIPCProcessorMap().values()){
                    if(currentNode instanceof MLLPReceiverProcessorTN){
                        MLLPReceiverProcessorTN currentMLLPReceiverNode = (MLLPReceiverProcessorTN)currentNode;
                        processorSet.add(currentMLLPReceiverNode);
                    }

                }
            }
        }
        return(processorSet);
    }
    
    @JsonIgnore
    public Set<FileReaderProcessorTN> getFileReaderProcessors(){
        Set<FileReaderProcessorTN> processorSet = new HashSet<>();
        if(!getExternalIPCProcessorMap().isEmpty()){
            synchronized(getExternalIPCProcessorMapLock()){
                for(WorkUnitProcessorTopologyNode currentNode: getExternalIPCProcessorMap().values()){
                    if(currentNode instanceof FileReaderProcessorTN){
                        FileReaderProcessorTN currentFileReaderNode = (FileReaderProcessorTN)currentNode;
                        processorSet.add(currentFileReaderNode);
                    }

                }
            }
        }
        return(processorSet);
    }
    
    @JsonIgnore
    public Set<FileWriterProcessorTN> getFileWriterProcessors(){
        Set<FileWriterProcessorTN> processorSet = new HashSet<>();
        if(!getExternalIPCProcessorMap().isEmpty()){
            synchronized(getExternalIPCProcessorMapLock()){
                for(WorkUnitProcessorTopologyNode currentNode: getExternalIPCProcessorMap().values()){
                    if(currentNode instanceof FileWriterProcessorTN){
                        FileWriterProcessorTN currentFileWriterNode = (FileWriterProcessorTN)currentNode;
                        processorSet.add(currentFileWriterNode);
                    }

                }
            }
        }
        return(processorSet);
    }
    
    @JsonIgnore
    public Set<TAPSenderProcessorTN> getTAPSenderProcessors(){
        Set<TAPSenderProcessorTN> processorSet = new HashSet<>();
        if(!getExternalIPCProcessorMap().isEmpty()){
            synchronized(getExternalIPCProcessorMapLock()){
                for(WorkUnitProcessorTopologyNode currentNode: getExternalIPCProcessorMap().values()){
                    if(currentNode instanceof TAPSenderProcessorTN){
                        TAPSenderProcessorTN currentTAPSenderNode = (TAPSenderProcessorTN)currentNode;
                        processorSet.add(currentTAPSenderNode);
                    }

                }
            }
        }
        return(processorSet);
    }
    
        
    @JsonIgnore
    public Set<TAPReceiverProcessorTN> getTAPReceiverProcessors(){
        Set<TAPReceiverProcessorTN> processorSet = new HashSet<>();
        if(!getExternalIPCProcessorMap().isEmpty()){
            synchronized(getExternalIPCProcessorMapLock()){
                for(WorkUnitProcessorTopologyNode currentNode: getExternalIPCProcessorMap().values()){
                    if(currentNode instanceof TAPReceiverProcessorTN){
                        TAPReceiverProcessorTN currentTAPReceiverNode = (TAPReceiverProcessorTN)currentNode;
                        processorSet.add(currentTAPReceiverNode);
                    }

                }
            }
        }
        return(processorSet);
    }

    @JsonIgnore
    @Override
    public Set<WorkUnitProcessorTopologyNode> getWUPSet(){
        Set<WorkUnitProcessorTopologyNode> wupSet = new HashSet<>();
        if(getExternalIPCProcessorMap().isEmpty()){
            return(wupSet);
        }
        synchronized (getExternalIPCProcessorMapLock()){
            wupSet.addAll(getExternalIPCProcessorMap().values());
        }
        return(wupSet);
    }
    
    //
    // toString
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExternalIPCWorkshopTopologyNode{");
        sb.append("externalIPCProcessorMap=").append(externalIPCProcessorMap);
        sb.append(", externalIPCProcessorLock=").append(externalIPCProcessorMapLock);
        sb.append(", ").append(super.toString()).append('}');
        return sb.toString();
    }
    
    
    
}
