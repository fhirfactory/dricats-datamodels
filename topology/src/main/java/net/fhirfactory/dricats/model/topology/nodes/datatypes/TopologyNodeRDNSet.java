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
package net.fhirfactory.dricats.model.topology.nodes.datatypes;

import net.fhirfactory.dricats.model.topology.nodes.datatypes.TopologyNodeRDN;
import java.util.ArrayList;
import java.util.HashMap;

public class TopologyNodeRDNSet {
    private HashMap<Integer, TopologyNodeRDN> payload;

    public TopologyNodeRDNSet(ArrayList<TopologyNodeRDN> rdnArrayList){
        this.payload = new HashMap<>();
        if(rdnArrayList == null){
            return;
        }
        int counter = 0;
        for(TopologyNodeRDN currentRDN: rdnArrayList){
            payload.put(counter, currentRDN);
            counter += 1;
        }
    }

    public TopologyNodeRDNSet(){
        this.payload = new HashMap<>();
    }

    public HashMap<Integer, TopologyNodeRDN> getPayload() {
        return payload;
    }

    public void setPayload(HashMap<Integer, TopologyNodeRDN> payload) {
        this.payload = payload;
    }
}
