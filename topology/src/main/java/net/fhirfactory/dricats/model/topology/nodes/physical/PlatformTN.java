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

import net.fhirfactory.dricats.model.topology.nodes.base.TopologyNode;

public class PlatformTN extends TopologyNode {
    private static final Logger LOG = LoggerFactory.getLogger(PlatformTN.class);

    private String actualIP;

    //
    // Constructor(s)
    //

    public PlatformTN(){
        super();
        this.actualIP = null;
    }

    //
    // Getters and Setters
    //

    @Override
    protected Logger getLogger() {
        return (LOG);
    }

    public String getActualIP() {
        return actualIP;
    }

    public void setActualIP(String actualIP) {
        this.actualIP = actualIP;
    }

    //
    // To String
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InfrastructureTopologyNode{");
        sb.append("actualIP=").append(actualIP);
        sb.append(", ").append(super.toString()).append("}");
        return sb.toString();
    }
    
    

}
