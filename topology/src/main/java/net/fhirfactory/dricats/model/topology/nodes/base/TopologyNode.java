/*
 * The MIT License
 *
 * Copyright 2022 MArk A. Hunter.
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
package net.fhirfactory.dricats.model.topology.nodes.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.fhirfactory.dricats.model.capability.Capability;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import net.fhirfactory.dricats.model.component.datatypes.ComponentId;
import net.fhirfactory.dricats.model.component.datatypes.ComponentTypeDefinition;
import net.fhirfactory.dricats.model.topology.nodes.valuesets.TopologyNodeNetworkingContextEnum;
import net.fhirfactory.dricats.model.topology.nodes.valuesets.TopologyNodeNetworkSecurityZoneEnum;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

/**
 *
 * @author mhunter
 */
public abstract class TopologyNode implements Serializable{
    private ComponentId nodeId;
    private String nodeVersion;
    private String participantName;
    private String participantDisplayName;
    private ComponentTypeDefinition nodeType;
    private TopologyNodeNetworkSecurityZoneEnum networkZone;
    private Set<Capability> capabilities;
    private TopologyNodeNetworkingContextEnum networkContext;
    private ComponentId parentNode;
    private String description;
    private HashMap<String, String> otherConfigurationParameters;
    
    //
    // Constructor(s)
    //
    
    public TopologyNode(){
        this.nodeId = null;
        this.participantName = null;
        this.participantDisplayName = null;
        this.otherConfigurationParameters = new HashMap<>();
        this.parentNode = null;
        this.description = null;
        this.capabilities = new HashSet<>();
        this.networkZone = TopologyNodeNetworkSecurityZoneEnum.INTERNET;
        this.networkContext = TopologyNodeNetworkingContextEnum.COMPONENT_ROLE_SUBSYSTEM_INTERNAL;
        this.nodeVersion = null;
    }
    
    public TopologyNode(TopologyNode ori){
        this.nodeId = null;
        this.participantName = null;
        this.participantDisplayName = null;
        this.otherConfigurationParameters = new HashMap<>();
        this.parentNode = null;
        this.description = null;
        this.capabilities = new HashSet<>();
        this.networkZone = TopologyNodeNetworkSecurityZoneEnum.INTERNET;
        this.networkContext = TopologyNodeNetworkingContextEnum.COMPONENT_ROLE_SUBSYSTEM_INTERNAL;
        if(ori.getNodeId() != null){
            setNodeId(ori.getNodeId());
        }
        if(StringUtils.isNotEmpty(ori.getParticipantName())){
            setParticipantName(ori.getParticipantName());
        }
        if(StringUtils.isNotEmpty(ori.getParticipantDisplayName())){
            setParticipantDisplayName(ori.getParticipantDisplayName());
        }
        if(ori.getNodeType() != null){
            setNodeType(ori.getNodeType());
        }
        this.capabilities = new HashSet<Capability>();
        if(ori.getCapabilities() != null){
            setCapabilities(ori.getCapabilities());
        }
        if(ori.hasDescription()){
            setDescription(ori.getDescription());
        }
        if(ori.hasParentNode()){
            setParentNode(ori.getParentNode());
        }
        if(ori.hasNodeVersion()){
            setNodeVersion(ori.getNodeVersion());
        }
        setNetworkZone(ori.getNetworkZone());
        setNetworkContext(ori.getNetworkContext());
        if (ori.getOtherConfigurationParameters() != null) {
            if (!ori.getOtherConfigurationParameters().isEmpty()) {
                Set<String> keys = ori.getOtherConfigurationParameters().keySet();
                for(String currrentKey: keys) {
                    getOtherConfigurationParameters().put(currrentKey, ori.getOtherConfigurationParameter(currrentKey));
                }
            }
        }
    }
    
    //
    // Abstract Methods
    // 
    
    protected abstract Logger getLogger();
    
    //
    // Getters and Setters
    //

    @JsonIgnore
    public boolean hasNodeVersion(){
        boolean hasValue = this.nodeVersion != null;
        return(hasValue);
    }

    public String getNodeVersion() {
        return nodeVersion;
    }

    public void setNodeVersion(String nodeVersion) {
        this.nodeVersion = nodeVersion;
    }

    public Map<String, String> getOtherConfigurationParameters() {
        return otherConfigurationParameters;
    }

    public void setOtherConfigurationParameters(Map<String, String> otherConfigurationParameters) {
        this.otherConfigurationParameters.clear();
        if(otherConfigurationParameters != null){
            for(String currentKey: otherConfigurationParameters.keySet()){
                this.otherConfigurationParameters.put(currentKey, otherConfigurationParameters.get(currentKey));
            }
        }
    }
    
    @JsonIgnore
    public void addOtherConfigurationParameter(String key, String value) {
            if (getOtherConfigurationParameters().containsKey(key)) {
                    getOtherConfigurationParameters().remove(key);
            }
            getOtherConfigurationParameters().put(key, value);
    }

    @JsonIgnore
    public String getOtherConfigurationParameter(String key) {
            if (getOtherConfigurationParameters().containsKey(key)) {
                    String value = getOtherConfigurationParameters().get(key);
                    return (value);
            }
            return (null);
    }
    
    @JsonIgnore
    public boolean hasParentNode(){
        boolean hasValue = this.parentNode != null;
        return(hasValue);
    }

    public ComponentId getParentNode() {
        return parentNode;
    }

    public void setParentNode(ComponentId parentNode) {
        this.parentNode = parentNode;
    }
    
    @JsonIgnore
    public boolean hasDescription(){
        boolean hasValue = this.description != null;
        return(hasValue);
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TopologyNodeNetworkingContextEnum getNetworkContext() {
        return networkContext;
    }

    public void setNetworkContext(TopologyNodeNetworkingContextEnum networkContext) {
        this.networkContext = networkContext;
    }

    public TopologyNodeNetworkSecurityZoneEnum getNetworkZone() {
        return networkZone;
    }

    public void setNetworkZone(TopologyNodeNetworkSecurityZoneEnum networkZone) {
        this.networkZone = networkZone;
    }
    
    @JsonIgnore
    public boolean hasCapabilities(){
        boolean hasValue = this.capabilities != null;
        return(hasValue);
    }
    
    public Set<Capability> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(Set<Capability> capabilities) {
        this.capabilities = capabilities;
    }
    
    @JsonIgnore
    public boolean hasNodeType(){
        boolean hasValue = this.nodeType != null;
        return(hasValue);
    }
    
    public ComponentTypeDefinition getNodeType() {
        return nodeType;
    }

    public void setNodeType(ComponentTypeDefinition nodeType) {
        this.nodeType = nodeType;
    }

    @JsonIgnore
    public boolean hasId(){
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
    public boolean hasParticipantName(){
        boolean hasValue = this.participantName != null;
        return(hasValue);
    }
    
    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    @JsonIgnore
    public boolean hasParticipantDisplayName(){
        boolean hasValue = this.participantDisplayName != null;
        return(hasValue);
    }
    
    public String getParticipantDisplayName() {
        return participantDisplayName;
    }

    public void setParticipantDisplayName(String participantDisplayName) {
        this.participantDisplayName = participantDisplayName;
    }

    //
    // toString
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TopologyNode{");
        sb.append("id=").append(nodeId);
        sb.append(", participantName=").append(participantName);
        sb.append(", participantDisplayName=").append(participantDisplayName);
        sb.append(", nodeType=").append(nodeType);
        sb.append(", capabilities=").append(capabilities);
        sb.append(", networkZone=").append(networkZone);
        sb.append(", networkContext=").append(networkContext);
        sb.append(", parentNode=").append(parentNode);
        sb.append(", nodeVerison=").append(nodeVersion);
        sb.append('}');
        return sb.toString();
    }
    
    //
    // Helper Methods
    //

    @JsonIgnore
    public void constructNodeID(String name){
        if(!hasId()){
            ComponentId newId = new ComponentId();
            UUID uuid = UUID.randomUUID();
            String idUniqueDetail = Long.toHexString(uuid.getMostSignificantBits())+Long.toHexString(uuid.getLeastSignificantBits());
            String idValue = name + "." + idUniqueDetail;
            String idDisplayName = name + "(" + idUniqueDetail + ")";
            newId.setId(idValue);
            newId.setDisplayName(idDisplayName);
            newId.setIdValidityStartInstant(Instant.now());
            newId.setIdValidityEndInstant(Instant.MAX);
            setNodeId(newId);
        }
    }    
}
