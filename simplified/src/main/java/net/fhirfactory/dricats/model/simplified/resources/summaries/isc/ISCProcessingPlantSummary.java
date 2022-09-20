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

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.fhirfactory.dricats.model.component.datatypes.ComponentId;
import net.fhirfactory.dricats.model.simplified.resources.summaries.isc.base.ISCSummary;

import java.util.HashMap;
import java.util.Map;

public class ISCProcessingPlantSummary extends ISCSummary {
    private String securityZone;
    private Integer replicationCount;
    private Map<ComponentId, ISCWorkshopSummary> workshops;

    //
    // Constructor(s)
    //

    public ISCProcessingPlantSummary(){
        super();
        this.replicationCount = null;
        this.workshops = new HashMap<>();
        this.securityZone = null;
    }

    //
    // Getters and Setters
    //

    public Integer getReplicationCount() {
        return replicationCount;
    }

    public void setReplicationCount(Integer replicationCount) {
        this.replicationCount = replicationCount;
    }

    public Map<ComponentId, ISCWorkshopSummary> getWorkshops() {
        return workshops;
    }

    public void setWorkshops(Map<ComponentId, ISCWorkshopSummary> workshops) {
        this.workshops = workshops;
    }

    @JsonIgnore
    public void addWorkshop(ISCWorkshopSummary workshop){
        removeWorkshop(workshop.getComponentId());
        workshops.put(workshop.getComponentId(), workshop);
    }

    @JsonIgnore
    public void removeWorkshop(ComponentId componentID){
        if(workshops.containsKey(componentID)){
            workshops.remove(componentID);
        }
    }

    public String getSecurityZone() {
        return securityZone;
    }

    public void setSecurityZone(String securityZone) {
        this.securityZone = securityZone;
    }


    //
    // To String
    //


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ISCProcessingPlantSummary{");
        sb.append("securityZone='").append(securityZone).append('\'');
        sb.append(", replicationCount=").append(replicationCount);
        sb.append(", workshops=").append(workshops);
        sb.append(", ").append(super.toString()).append('}');
        return sb.toString();
    }
}
