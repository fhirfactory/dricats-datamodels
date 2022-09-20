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
package net.fhirfactory.dricats.model.simplified.resources.summaries.isc.base;

import net.fhirfactory.dricats.model.component.datatypes.ComponentId;
import net.fhirfactory.dricats.model.component.valuesets.ComponentTypeEnum;
import net.fhirfactory.dricats.model.simplified.resources.summaries.LocationSummary;
import net.fhirfactory.dricats.model.simplified.resources.summaries.common.ResourceSummaryBase;
import net.fhirfactory.dricats.model.simplified.resources.summaries.isc.ISCInfrastructureNodeSummary;
import net.fhirfactory.dricats.model.simplified.resources.summaries.isc.ISCPlatformNodeSummary;

public class ISCSummary extends ResourceSummaryBase {
    private ComponentId componentId;
    private String subsystemParticipantName;
    private String concurrencyMode;
    private String resilienceMode;
    private LocationSummary site;
    private ISCInfrastructureNodeSummary infrastructureNode;
    private ISCPlatformNodeSummary platformNode;
    private ComponentTypeEnum componentType;

    //
    // Constructor(s)
    //

    public ISCSummary(){
        super();
        this.componentId = null;
        this.subsystemParticipantName = null;
        this.concurrencyMode = null;
        this.resilienceMode = null;
        this.componentType = null;
        this.site = null;
        this.infrastructureNode = null;
        this.platformNode = null;
    }

    //
    // Getters and Setters
    //


    public LocationSummary getSite() {
        return site;
    }

    public void setSite(LocationSummary site) {
        this.site = site;
    }

    public ISCInfrastructureNodeSummary getInfrastructureNode() {
        return infrastructureNode;
    }

    public void setInfrastructureNode(ISCInfrastructureNodeSummary infrastructureNode) {
        this.infrastructureNode = infrastructureNode;
    }

    public ISCPlatformNodeSummary getPlatformNode() {
        return platformNode;
    }

    public void setPlatformNode(ISCPlatformNodeSummary platformNode) {
        this.platformNode = platformNode;
    }

    public void setComponentType(ComponentTypeEnum componentType) {
        this.componentType = componentType;
    }

    public ComponentTypeEnum getComponentType() {
        return componentType;
    }

    public String getSubsystemParticipantName() {
        return subsystemParticipantName;
    }

    public void setSubsystemParticipantName(String subsystemParticipantName) {
        this.subsystemParticipantName = subsystemParticipantName;
    }

    public ComponentId getComponentId() {
        return componentId;
    }

    public void setComponentId(ComponentId componentId) {
        this.componentId = componentId;
    }

    public String getConcurrencyMode() {
        return concurrencyMode;
    }

    public void setConcurrencyMode(String concurrencyMode) {
        this.concurrencyMode = concurrencyMode;
    }

    public String getResilienceMode() {
        return resilienceMode;
    }

    public void setResilienceMode(String resilienceMode) {
        this.resilienceMode = resilienceMode;
    }

    //
    // To String
    //


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ISCSummary{");
        sb.append("componentId=").append(componentId);
        sb.append(", subsystemParticipantName='").append(subsystemParticipantName).append('\'');
        sb.append(", concurrencyMode='").append(concurrencyMode).append('\'');
        sb.append(", resilienceMode='").append(resilienceMode).append('\'');
        sb.append(", site='").append(site).append('\'');
        sb.append(", infrastructureNode='").append(infrastructureNode).append('\'');
        sb.append(", platformNode='").append(platformNode).append('\'');
        sb.append(", componentType=").append(componentType);
        sb.append(", ").append(super.toString()).append('}');
        return sb.toString();
    }
}
