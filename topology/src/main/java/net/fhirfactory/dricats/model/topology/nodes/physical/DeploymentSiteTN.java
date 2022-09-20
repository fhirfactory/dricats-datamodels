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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import net.fhirfactory.dricats.model.topology.nodes.base.TopologyNode;

public class DeploymentSiteTN extends TopologyNode {
    private static final Logger LOG = LoggerFactory.getLogger(DeploymentSiteTN.class);

    private Integer instanceCount;
    private ConcurrentHashMap<String, InfrastructureTN> infrastructureMap;
    private Object infrastructureMapLock;
    //
    // Constructor(s)
    // 

    public DeploymentSiteTN(){
        super();
        this.instanceCount = 0;
        this.infrastructureMap = new ConcurrentHashMap<>();
        this.infrastructureMapLock = new Object();
    }
    
    //
    // Overridden Methods
    //

    @Override
    protected Logger getLogger() {
        return (LOG);
    }
    
    //
    // Getters and Setters
    //

    public ConcurrentHashMap<String, InfrastructureTN> getInfrastructureMap() {
        return infrastructureMap;
    }

    public void setInfrastructureMap(ConcurrentHashMap<String, InfrastructureTN> infrastructureMap) {
        this.infrastructureMap = infrastructureMap;
    }

    public Integer getInstanceCount() {
        return instanceCount;
    }

    public void setInstanceCount(Integer instanceCount) {
        this.instanceCount = instanceCount;
    }

    public Object getInfrastructureMapLock() {
        return infrastructureMapLock;
    }

    public void setInfrastructureMapLock(Object infrastructureMapLock) {
        this.infrastructureMapLock = infrastructureMapLock;
    }

    public void addInfrastructureNode(InfrastructureTN newInfrastructureNode){
        if(newInfrastructureNode == null){
            return;
        }
        synchronized(getInfrastructureMapLock()){
            if(getInfrastructureMap().containsKey(newInfrastructureNode.getParticipantName())){
                getInfrastructureMap().remove(newInfrastructureNode.getParticipantName());
            }
            getInfrastructureMap().put(newInfrastructureNode.getParticipantName(), newInfrastructureNode);
        }
    }
    
    //
    // toString
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeploymentSiteTopologyNode{");
        sb.append("instanceCount=").append(instanceCount);
        sb.append(", infrastructureMap=").append(infrastructureMap);
        sb.append(", infrastructureMapLock=").append(infrastructureMapLock);
        sb.append(", ").append(super.toString()).append("}");
        return sb.toString();
    }
    
}
