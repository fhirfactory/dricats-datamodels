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
package net.fhirfactory.dricats.model.petasos.participant.components.adapter;

import com.fasterxml.jackson.annotation.JsonFormat;
import net.fhirfactory.dricats.model.component.datatypes.ComponentId;
import net.fhirfactory.dricats.model.constants.DeploymentPropertyConstants;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import net.fhirfactory.dricats.model.petasos.participant.capabilities.valuesets.ResilienceModeEnum;
import net.fhirfactory.dricats.model.petasos.participant.components.adapter.datatypes.AdapterDefinition;

public class AdapterBase implements Serializable {
    private ComponentId componentId;
    private String componentName;
    private String componentVersion;

    private String targetSystemName;
    private String groupName;
    private boolean encrypted;
    private boolean active;
    private ArrayList<ResilienceModeEnum> supportedDeploymentModes;
    private ArrayList<AdapterDefinition> supportedInterfaceDefinitions;
    private Map<String, String> additionalParameters;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSXXX", timezone = DeploymentPropertyConstants.DEFAULT_TIMEZONE)
    private Instant lastActivity;

    //
    // Constructor(s)
    //
    public AdapterBase(){
        this.supportedDeploymentModes = new ArrayList<>();
        this.supportedInterfaceDefinitions = new ArrayList<>();
        this.encrypted = false;
        this.active = false;
        this.targetSystemName = null;
        this.groupName = null;
        this.componentId = null;
        this.additionalParameters = new HashMap<>();
        lastActivity = Instant.EPOCH;
    }

    //
    // Getters and Setters
    //

    public ArrayList<ResilienceModeEnum> getSupportedDeploymentModes() {
        return supportedDeploymentModes;
    }

    public void setSupportedDeploymentModes(ArrayList<ResilienceModeEnum> supportedDeploymentModes) {
        this.supportedDeploymentModes = supportedDeploymentModes;
    }

    public String getTargetSystemName() {
        return targetSystemName;
    }

    public void setTargetSystemName(String targetSystemName) {
        this.targetSystemName = targetSystemName;
    }

    public ComponentId getComponentId() {
        return componentId;
    }

    public void setComponentId(ComponentId componentId) {
        this.componentId = componentId;
    }

    public ArrayList<AdapterDefinition> getSupportedInterfaceDefinitions() {
        return supportedInterfaceDefinitions;
    }

    public void setSupportedInterfaceDefinitions(ArrayList<AdapterDefinition> supportedInterfaceDefinitions) {
        this.supportedInterfaceDefinitions = supportedInterfaceDefinitions;
    }

    public ArrayList<String> getSupportInterfaceTags(){
        ArrayList<String> tags = new ArrayList<>();
        for(AdapterDefinition ipcInterface: getSupportedInterfaceDefinitions()){
            tags.add(ipcInterface.getInterfaceDefinitionTag());
        }
        return(tags);
    }

    public boolean supportsInterface(String interfaceTag ){
        for(AdapterDefinition ipcInterface: getSupportedInterfaceDefinitions()){
            if(interfaceTag.contentEquals(ipcInterface.getInterfaceDefinitionTag())){
                return(true);
            }
        }
        return(false);
    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public void setEncrypted(boolean encrypted) {
        this.encrypted = encrypted;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Map<String, String> getAdditionalParameters() {
        return additionalParameters;
    }

    public void setAdditionalParameters(Map<String, String> additionalParameters) {
        this.additionalParameters = additionalParameters;
    }

    public Instant getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(Instant lastActivity) {
        this.lastActivity = lastActivity;
    }

    //
    // To String
    //

    @Override
    public String toString() {
        return "IPCInterface{" +
                "componentId=" + componentId +
                ", targetNameInstant=" + targetSystemName +
                ", groupName=" + groupName +
                ", encrypted=" + encrypted +
                ", supportedDeploymentModes=" + supportedDeploymentModes +
                ", supportedInterfaceDefinitions=" + supportedInterfaceDefinitions +
                ", supportInterfaceTags=" + getSupportInterfaceTags() +
                ", active=" + active +
                ", lastActivity=" + lastActivity +
                '}';
    }

    //
    // Hashcode and Comparator
    //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdapterBase)) return false;
        AdapterBase that = (AdapterBase) o;
        return isEncrypted() == that.isEncrypted() && isActive() == that.isActive() && Objects.equals(getComponentId(), that.getComponentId()) && Objects.equals(getTargetSystemName(), that.getTargetSystemName()) && Objects.equals(getGroupName(), that.getGroupName()) && Objects.equals(getSupportedDeploymentModes(), that.getSupportedDeploymentModes()) && Objects.equals(getSupportedInterfaceDefinitions(), that.getSupportedInterfaceDefinitions()) && Objects.equals(getAdditionalParameters(), that.getAdditionalParameters()) && Objects.equals(getLastActivity(), that.getLastActivity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getComponentId(), getTargetSystemName(), getGroupName(), isEncrypted(), isActive(), getSupportedDeploymentModes(), getSupportedInterfaceDefinitions(), getAdditionalParameters(), getLastActivity());
    }
}
