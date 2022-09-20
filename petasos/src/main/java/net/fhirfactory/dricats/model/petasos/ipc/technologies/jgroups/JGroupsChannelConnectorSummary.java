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
package net.fhirfactory.dricats.model.petasos.ipc.technologies.jgroups;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import net.fhirfactory.dricats.model.component.datatypes.ComponentId;
import net.fhirfactory.dricats.model.component.valuesets.ComponentStatusEnum;
import net.fhirfactory.dricats.model.configuration.filebased.archetypes.valuesets.ClusterFunctionNameEnum;
import net.fhirfactory.dricats.model.constants.DeploymentPropertyConstants;
import net.fhirfactory.dricats.model.petasos.ipc.endpoints.valuesets.JGroupsChannelStatusEnum;
import net.fhirfactory.dricats.model.petasos.participant.valuesets.NetworkSecurityZoneEnum;

public class JGroupsChannelConnectorSummary implements Serializable {
    private ComponentId componentId;
    private ClusterFunctionNameEnum function;
    private NetworkSecurityZoneEnum zone;
    private String site;
    private String subsystemParticipantName;
    private ComponentId processingPlantInstanceId;
    private String uniqueIdQualifier;
    private String channelName;
    private ComponentStatusEnum participantStatus;
    private JGroupsChannelStatusEnum integrationPointStatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSXXX", timezone = DeploymentPropertyConstants.DEFAULT_TIMEZONE)
    private Instant lastRefreshInstant;

    //
    // Constructor(s)
    //

    public JGroupsChannelConnectorSummary(){
        this.componentId = null;
        this.function = null;
        this.channelName = null;
        this.zone = null;
        this.site = null;
        this.subsystemParticipantName = null;
        this.processingPlantInstanceId = null;
        this.participantStatus = null;
        this.lastRefreshInstant = Instant.now();
        this.integrationPointStatus = JGroupsChannelStatusEnum.JGROUPS_CHANNEL_LOCAL_STATUS_STARTED;
    }

    public JGroupsChannelConnectorSummary(JGroupsChannelConnectorSummary ori){
        this.componentId = null;
        this.function = null;
        this.channelName = null;
        this.zone = null;
        this.site = null;
        this.subsystemParticipantName = null;
        this.processingPlantInstanceId = null;
        this.participantStatus = null;
        this.lastRefreshInstant = Instant.now();
        this.integrationPointStatus = JGroupsChannelStatusEnum.JGROUPS_CHANNEL_LOCAL_STATUS_STARTED;

        if(ori.getComponentId() != null){
            setComponentId(ori.getComponentId());
        }
        if(ori.getFunction() != null){
            setFunction(ori.getFunction());
        }
        if(ori.getChannelName() != null){
            setChannelName(ori.getChannelName());
        }
        if(ori.getZone() != null){
            setZone(ori.getZone());
        }
        if(ori.getSite() != null){
            setSite(ori.getSite());
        }
        if(ori.getSubsystemParticipantName() != null){
            setSubsystemParticipantName(ori.getSubsystemParticipantName());
        }
        if(ori.getProcessingPlantInstanceId() != null){
            setProcessingPlantInstanceId(ori.getProcessingPlantInstanceId());
        }
        if(ori.getParticipantStatus() != null){
            setParticipantStatus(ori.getParticipantStatus());
        }
        if(ori.getIntegrationPointStatus() != null){
            setIntegrationPointStatus(ori.getIntegrationPointStatus());
        }
    }

    //
    // Getters and Setters
    //

    public JGroupsChannelStatusEnum getIntegrationPointStatus() {
        return integrationPointStatus;
    }

    public void setIntegrationPointStatus(JGroupsChannelStatusEnum integrationPointStatus) {
        this.integrationPointStatus = integrationPointStatus;
    }

    public ComponentId getComponentId() {
        return componentId;
    }

    public void setComponentId(ComponentId componentId) {
        this.componentId = componentId;
    }

    public ClusterFunctionNameEnum getFunction() {
        return function;
    }

    public void setFunction(ClusterFunctionNameEnum function) {
        this.function = function;
    }

    public NetworkSecurityZoneEnum getZone() {
        return zone;
    }

    public void setZone(NetworkSecurityZoneEnum zone) {
        this.zone = zone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSubsystemParticipantName() {
        return subsystemParticipantName;
    }

    public void setSubsystemParticipantName(String subsystemParticipantName) {
        this.subsystemParticipantName = subsystemParticipantName;
    }

    public ComponentId getProcessingPlantInstanceId() {
        return processingPlantInstanceId;
    }

    public void setProcessingPlantInstanceId(ComponentId processingPlantInstanceId) {
        this.processingPlantInstanceId = processingPlantInstanceId;
    }

    public String getUniqueIdQualifier() {
        return uniqueIdQualifier;
    }

    public void setUniqueIdQualifier(String uniqueIdQualifier) {
        this.uniqueIdQualifier = uniqueIdQualifier;
    }

    public ComponentStatusEnum getParticipantStatus() {
        return participantStatus;
    }

    public void setParticipantStatus(ComponentStatusEnum participantStatus) {
        this.participantStatus = participantStatus;
    }

    public Instant getLastRefreshInstant() {
        return lastRefreshInstant;
    }

    public void setLastRefreshInstant(Instant lastRefreshInstant) {
        this.lastRefreshInstant = lastRefreshInstant;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    //
    // To String
    //

    @Override
    public String toString() {
        return "JGroupsIntegrationPointSummary{" +
                "componentId=" + componentId +
                ", function=" + function +
                ", zone=" + zone +
                ", site=" + site +
                ", subsystemParticipantName=" + subsystemParticipantName +
                ", processingPlantInstanceId=" + processingPlantInstanceId +
                ", uniqueIdQualifier=" + uniqueIdQualifier +
                ", participantStatus=" + participantStatus +
                ", lastRefreshInstant=" + lastRefreshInstant +
                ", channelName=" + channelName +
                ", integrationPointStatus=" + integrationPointStatus +
                '}';
    }

    //
    // Hashcode and Equals
    //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JGroupsChannelConnectorSummary)) return false;
        JGroupsChannelConnectorSummary that = (JGroupsChannelConnectorSummary) o;
        return Objects.equals(getComponentId(), that.getComponentId()) && getFunction() == that.getFunction() && getZone() == that.getZone() && Objects.equals(getSite(), that.getSite()) && Objects.equals(getSubsystemParticipantName(), that.getSubsystemParticipantName()) && Objects.equals(getProcessingPlantInstanceId(), that.getProcessingPlantInstanceId()) && Objects.equals(getUniqueIdQualifier(), that.getUniqueIdQualifier()) && getParticipantStatus() == that.getParticipantStatus() && Objects.equals(getLastRefreshInstant(), that.getLastRefreshInstant());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getComponentId(), getFunction(), getZone(), getSite(), getSubsystemParticipantName(), getProcessingPlantInstanceId(), getUniqueIdQualifier(), getParticipantStatus(), getLastRefreshInstant());
    }
}
