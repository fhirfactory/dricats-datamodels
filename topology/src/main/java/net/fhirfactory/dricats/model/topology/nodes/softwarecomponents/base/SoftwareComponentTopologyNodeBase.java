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
package net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.Instant;

import net.fhirfactory.dricats.model.constants.DeploymentPropertyConstants;
import net.fhirfactory.dricats.model.topology.nodes.base.TopologyNode;
import net.fhirfactory.dricats.model.topology.nodes.physical.DeploymentSiteTN;
import net.fhirfactory.dricats.model.topology.nodes.physical.InfrastructureTN;
import net.fhirfactory.dricats.model.topology.nodes.physical.PlatformTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.base.valuesets.SoftwareComponentExecutionControlEnum;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.base.valuesets.InformationSystemComponentStatusEnum;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.subsystems.SubsystemTopologyNode;
import net.fhirfactory.dricats.model.topology.nodes.valuesets.TopologyNodeConcurrencyModeEnum;
import net.fhirfactory.dricats.model.topology.nodes.valuesets.TopologyNodeResilienceModeEnum;

/**
 *
 * @author mhunter
 */
public abstract class SoftwareComponentTopologyNodeBase extends TopologyNode{
    
    private String subsystemParticipantName;
    private DeploymentSiteTN siteNode;
    private SubsystemTopologyNode systemNode;
    private InfrastructureTN infrastructureNode;
    private PlatformTN platformNode;
    private Integer replicationCount;
    private TopologyNodeConcurrencyModeEnum concurrencyMode;
    private TopologyNodeResilienceModeEnum resilienceMode;
    private InformationSystemComponentStatusEnum componentStatus;
    private SoftwareComponentExecutionControlEnum componentExecutionControl;
    private boolean frameworkEnabled;
    private boolean enabled;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSXXX", timezone = DeploymentPropertyConstants.DEFAULT_TIMEZONE)
    private Instant lastActivityInstant;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSXXX", timezone = DeploymentPropertyConstants.DEFAULT_TIMEZONE)
    private Instant lastReportingInstant;
    
    //
    // Constructor(s)
    //
    
    public SoftwareComponentTopologyNodeBase(){
        super();
        this.subsystemParticipantName = null;
        this.siteNode = null;
        this.systemNode = null;
        this.infrastructureNode = null;
        this.platformNode = null;
        this.replicationCount = null;
        this.frameworkEnabled = true;
        this.enabled = true;
        this.concurrencyMode = TopologyNodeConcurrencyModeEnum.CONCURRENCY_MODE_STANDALONE;
        this.resilienceMode = TopologyNodeResilienceModeEnum.RESILIENCE_MODE_STANDALONE;
    }
    
    public SoftwareComponentTopologyNodeBase(SoftwareComponentTopologyNodeBase ori){
        super(ori);
        this.subsystemParticipantName = null;
        this.siteNode = null;
        this.systemNode = null;
        this.infrastructureNode = null;
        this.platformNode = null;
        this.replicationCount = null;
        this.frameworkEnabled = true;
        this.enabled = true;
        if(ori.hasSubsystemParticipantName()){
            setSubsystemParticipantName(ori.getSubsystemParticipantName());
        }
        if(ori.hasSiteNode()){
            setSiteNode(ori.getSiteNode());
        }
        if(ori.hasSystemNode()){
            setSystemNode(ori.getSystemNode());
        }
        if(ori.hasPlatformNode()){
            setPlatformNode(ori.getPlatformNode());
        }
        if(ori.hasInstructureNode()){
            setInfrastructureNode(ori.getInfrastructureNode());
        }
        if(ori.hasReplicationCount()){
            setReplicationCount(ori.getReplicationCount());
        }
        setConcurrencyMode(ori.getConcurrencyMode());
        setResilienceMode(ori.getResilienceMode());
        setEnabled(ori.isEnabled());
        setFrameworkEnabled(ori.isFrameworkEnabled());
        setComponentStatus(ori.getComponentStatus());
        setComponentExecutionControl(ori.getComponentExecutionControl());
    }
    
    //
    // Getters and Setters
    //

    public InformationSystemComponentStatusEnum getComponentStatus() {
        return componentStatus;
    }

    public void setComponentStatus(InformationSystemComponentStatusEnum componentStatus) {
        this.componentStatus = componentStatus;
    }

    public SoftwareComponentExecutionControlEnum getComponentExecutionControl() {
        return componentExecutionControl;
    }

    public void setComponentExecutionControl(SoftwareComponentExecutionControlEnum componentExecutionControl) {
        this.componentExecutionControl = componentExecutionControl;
    }

    public Instant getLastActivityInstant() {
        return lastActivityInstant;
    }

    public void setLastActivityInstant(Instant lastActivityInstant) {
        this.lastActivityInstant = lastActivityInstant;
    }

    public Instant getLastReportingInstant() {
        return lastReportingInstant;
    }

    public void setLastReportingInstant(Instant lastReportingInstant) {
        this.lastReportingInstant = lastReportingInstant;
    }
    

    public TopologyNodeResilienceModeEnum getResilienceMode() {
        return resilienceMode;
    }

    public void setResilienceMode(TopologyNodeResilienceModeEnum resilienceMode) {
        this.resilienceMode = resilienceMode;
    }

    public TopologyNodeConcurrencyModeEnum getConcurrencyMode() {
        return concurrencyMode;
    }

    public void setConcurrencyMode(TopologyNodeConcurrencyModeEnum concurrencyMode) {
        this.concurrencyMode = concurrencyMode;
    }
    
    @JsonIgnore
    public boolean hasReplicationCount(){
        boolean hasValue = this.replicationCount != null;
        return(hasValue);
    }
    
    public Integer getReplicationCount() {
        return replicationCount;
    }

    public void setReplicationCount(Integer replicationCount) {
        this.replicationCount = replicationCount;
    }
    
    @JsonIgnore
    public boolean hasSubsystemParticipantName(){
        boolean hasValue = this.subsystemParticipantName != null;
        return(hasValue);
    }

    public String getSubsystemParticipantName() {
        return subsystemParticipantName;
    }

    public void setSubsystemParticipantName(String subsystemParticipantName) {
        this.subsystemParticipantName = subsystemParticipantName;
    }

    @JsonIgnore
    public boolean hasSiteNode(){
        boolean hasValue = this.siteNode != null;
        return(hasValue);
    }
    
    public DeploymentSiteTN getSiteNode() {
        return siteNode;
    }

    public void setSiteNode(DeploymentSiteTN siteNode) {
        this.siteNode = siteNode;
    }

    @JsonIgnore
    public boolean hasSystemNode(){
        boolean hasValue = this.systemNode != null;
        return(hasValue);
    }
    
    public SubsystemTopologyNode getSystemNode() {
        return systemNode;
    }

    public void setSystemNode(SubsystemTopologyNode systemNode) {
        this.systemNode = systemNode;
    }

    @JsonIgnore
    public boolean hasInstructureNode(){
        boolean hasValue = this.infrastructureNode != null;
        return(hasValue);
    }
    
    public InfrastructureTN getInfrastructureNode() {
        return infrastructureNode;
    }

    public void setInfrastructureNode(InfrastructureTN infrastructureNode) {
        this.infrastructureNode = infrastructureNode;
    }

    @JsonIgnore
    public boolean hasPlatformNode(){
        boolean hasValue = this.platformNode != null;
        return(hasValue);
    }
    
    public PlatformTN getPlatformNode() {
        return platformNode;
    }

    public void setPlatformNode(PlatformTN platformNode) {
        this.platformNode = platformNode;
    }

    public boolean isFrameworkEnabled() {
        return frameworkEnabled;
    }

    public void setFrameworkEnabled(boolean frameworkEnabled) {
        this.frameworkEnabled = frameworkEnabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    //
    // toString
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SoftwareComponentTopologyNodeBase{");
        sb.append("subsystemParticipantName=").append(subsystemParticipantName);
        sb.append(", siteNode=").append(siteNode);
        sb.append(", systemNode=").append(systemNode);
        sb.append(", infrastructureNode=").append(infrastructureNode);
        sb.append(", platformNode=").append(platformNode);
        sb.append(", replicationCount=").append(replicationCount);
        sb.append(", concurrencyMode=").append(concurrencyMode);
        sb.append(", resilienceMode=").append(resilienceMode);
        sb.append(", componentStatus=").append(componentStatus);
        sb.append(", componentExecutionControl=").append(componentExecutionControl);
        sb.append(", frameworkEnabled=").append(frameworkEnabled);
        sb.append(", enabled=").append(enabled);
        sb.append(", lastActivityInstant=").append(lastActivityInstant);
        sb.append(", lastReportingInstant=").append(lastReportingInstant);
        sb.append(", ").append(super.toString()).append('}');
        return sb.toString();
    }


    
}
