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
package net.fhirfactory.dricats.model.topology.nodes.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import net.fhirfactory.dricats.model.component.datatypes.ComponentId;

/**
 *
 * @author mhunter
 */
public class TopologyNodeId implements Serializable{
    private ComponentId nodeId;
    private TopologyNodeFDN nodeFDN;
    
    //
    // Constructors
    //
    
    public TopologyNodeId(){
        this.nodeId = null;
        this.nodeFDN = null;
    }
    
    //
    // Getters and Setters
    //
    
    @JsonIgnore
    public boolean hasNodeId(){
        boolean hasValue = this.nodeId != null;
        return(hasValue);
    }

    public ComponentId getNodeId() {
        return nodeId;
    }

    public void setNodeId(ComponentId nodeId) {
        this.nodeId = nodeId;
    }

    @JsonIgnore
    public boolean hasNodeFDN(){
        boolean hasValue = this.nodeFDN != null;
        return(hasValue);
    }
    
    public TopologyNodeFDN getNodeFDN() {
        return nodeFDN;
    }

    public void setNodeFDN(TopologyNodeFDN nodeFDN) {
        this.nodeFDN = nodeFDN;
    }
    
    //
    // toString
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TopologyNodeId{");
        sb.append("nodeId=").append(nodeId);
        sb.append(", nodeFDN=").append(nodeFDN);
        sb.append('}');
        return sb.toString();
    }
    
    
}
