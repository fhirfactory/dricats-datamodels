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
package net.fhirfactory.dricats.model.topology.nodes.physical;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fhirfactory.dricats.model.topology.nodes.base.TopologyNode;

public class InfrastructureTN extends TopologyNode {
    private static final Logger LOG = LoggerFactory.getLogger(InfrastructureTN.class);

    private String actualHostIP;
    private String actualPodIP;
    private ConcurrentHashMap<String, PlatformTN> platformMap;
    private Object platformMapLock;

    //
    // Constructor(s)
    //

    public InfrastructureTN(){
        super();
        this.actualPodIP = null;
        this.actualHostIP = null;
        this.platformMap = new ConcurrentHashMap<>();
        this.platformMapLock = new Object();
    }

    //
    // Getters and Setters
    //

    @Override
    protected Logger getLogger() {
        return (LOG);
    }

    public String getActualHostIP() {
        return actualHostIP;
    }

    public void setActualHostIP(String actualHostIP) {
        this.actualHostIP = actualHostIP;
    }

    public String getActualPodIP() {
        return actualPodIP;
    }

    public void setActualPodIP(String actualPodIP) {
        this.actualPodIP = actualPodIP;
    }

    public ConcurrentHashMap<String, PlatformTN> getPlatformMap() {
        return platformMap;
    }

    public void setPlatformMap(ConcurrentHashMap<String, PlatformTN> platformMap) {
        this.platformMap = platformMap;
    }

    public Object getPlatformMapLock() {
        return platformMapLock;
    }

    public void setPlatformMapLock(Object platformMapLock) {
        this.platformMapLock = platformMapLock;
    }
    
    public void addPlatformNode(PlatformTN platformNode){
        if(platformNode == null){
            return;
        }
        synchronized(getPlatformMapLock()){
            if(getPlatformMap().containsKey(platformNode.getParticipantName())){
                getPlatformMap().remove(platformNode.getParticipantName());
            }
            getPlatformMap().put(platformNode.getParticipantName(), platformNode);
        }
    }
    
    public Set<PlatformTN> getAllPlatformNodes(){
        Set<PlatformTN> nodeSet = new HashSet<>();
        if(getPlatformMap().isEmpty()){
            return(nodeSet);
        }
        synchronized(getPlatformMapLock()){
            nodeSet.addAll(getPlatformMap().values());
        }
        return(nodeSet);
    }
    
    //
    // To String
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InfrastructureTopologyNode{");
        sb.append("actualHostIP=").append(actualHostIP);
        sb.append(", actualPodIP=").append(actualPodIP);
        sb.append(", platformMap=").append(platformMap);
        sb.append(", platformMapLock=").append(platformMapLock);
        sb.append(", ").append(super.toString()).append("}");
        return sb.toString();
    }
    
    

}
