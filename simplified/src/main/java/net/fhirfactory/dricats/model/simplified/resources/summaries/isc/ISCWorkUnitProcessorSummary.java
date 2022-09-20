/*
 * Copyright (c) 2021 Mark A. Hunter (ACT Health)
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
package net.fhirfactory.dricats.model.simplified.resources.summaries.isc;

import net.fhirfactory.dricats.model.component.datatypes.ComponentId;
import net.fhirfactory.dricats.model.simplified.resources.summaries.isc.base.ISCSummary;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ISCWorkUnitProcessorSummary extends ISCSummary {
    Map<ComponentId, ISCEndpointSummary> endpoints;
    private String workshopParticipantName;

    //
    // Constructor(s)
    //

    public ISCWorkUnitProcessorSummary(){
        super();
        this.endpoints = new ConcurrentHashMap<>();
        this.workshopParticipantName = null;
    }

    //
    // Getters and Setters
    //

    public String getWorkshopParticipantName() {
        return workshopParticipantName;
    }

    public void setWorkshopParticipantName(String workshopParticipantName) {
        this.workshopParticipantName = workshopParticipantName;
    }

    public Map<ComponentId, ISCEndpointSummary> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(Map<ComponentId, ISCEndpointSummary> endpoints) {
        this.endpoints = endpoints;
    }

    public void removeEndpoint(ComponentId componentID){
        if(endpoints.containsKey(componentID)){
            endpoints.remove(componentID);
        }
    }

    public void addEndpoint(ISCEndpointSummary endpoint){
        removeEndpoint(endpoint.getComponentId());
        endpoints.put(endpoint.getComponentId(), endpoint);
    }

    //
    // To String
    //


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ISCWorkUnitProcessorSummary{");
        sb.append("endpoints=").append(endpoints);
        sb.append(", workshopParticipantName='").append(workshopParticipantName).append('\'');
        sb.append(", ").append(super.toString()).append('}');
        return sb.toString();
    }
}
