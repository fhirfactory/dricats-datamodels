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
package net.fhirfactory.dricats.model.configuration.filebased.archetypes.common;

import net.fhirfactory.dricats.model.configuration.filebased.segments.ConfigFilenameSetSegment;
import net.fhirfactory.dricats.model.configuration.filebased.segments.DeploymentSegment;
import net.fhirfactory.dricats.model.configuration.filebased.segments.DeploymentZoneSegment;
import net.fhirfactory.dricats.model.configuration.filebased.segments.SecurityCredentialSegment;
import net.fhirfactory.dricats.model.configuration.filebased.segments.SubsystemImageSegment;
import net.fhirfactory.dricats.model.configuration.filebased.segments.SubsystemInstanceSegment;
import net.fhirfactory.dricats.model.configuration.filebased.segments.VolumeMountSegment;

public class BaseSubsystemPropertyFile {

    private SubsystemInstanceSegment subsystemInstant;
    private ConfigFilenameSetSegment configFiles;
    private DeploymentSegment deploymentMode;
    private DeploymentZoneSegment deploymentZone;
    private SubsystemImageSegment subsystemImageProperties;
    private SecurityCredentialSegment trustStorePassword;
    private SecurityCredentialSegment keyPassword;
    private VolumeMountSegment volumeMounts;

    //
    // Constructor(s)
    //

    public BaseSubsystemPropertyFile() {
            subsystemInstant = new SubsystemInstanceSegment();
            deploymentMode = new DeploymentSegment();
            subsystemImageProperties = new SubsystemImageSegment();
            trustStorePassword = new SecurityCredentialSegment();
            keyPassword = new SecurityCredentialSegment();
            deploymentZone = new DeploymentZoneSegment();
            volumeMounts = new VolumeMountSegment();
            configFiles = new ConfigFilenameSetSegment();
    }

    //
    // Getters And Setters
    //

    public ConfigFilenameSetSegment getConfigFiles() {
        return configFiles;
    }

    public void setConfigFiles(ConfigFilenameSetSegment configFiles) {
        this.configFiles = configFiles;
    }

    public VolumeMountSegment getVolumeMounts() {
        return volumeMounts;
    }

    public void setVolumeMounts(VolumeMountSegment volumeMounts) {
        this.volumeMounts = volumeMounts;
    }

    public SubsystemInstanceSegment getSubsystemInstant() {
            return subsystemInstant;
    }

    public void setSubsystemInstant(SubsystemInstanceSegment subsystemInstant) {
            this.subsystemInstant = subsystemInstant;
    }

    public DeploymentSegment getDeploymentMode() {
            return deploymentMode;
    }

    public void setDeploymentMode(DeploymentSegment deploymentMode) {
            this.deploymentMode = deploymentMode;
    }

    public SubsystemImageSegment getSubsystemImageProperties() {
            return subsystemImageProperties;
    }

    public void setSubsystemImageProperties(SubsystemImageSegment subsystemImageProperties) {
            this.subsystemImageProperties = subsystemImageProperties;
    }

    public SecurityCredentialSegment getTrustStorePassword() {
            return trustStorePassword;
    }

    public void setTrustStorePassword(SecurityCredentialSegment trustStorePassword) {
            this.trustStorePassword = trustStorePassword;
    }

    public SecurityCredentialSegment getKeyPassword() {
            return keyPassword;
    }

    public void setKeyPassword(SecurityCredentialSegment keyPassword) {
            this.keyPassword = keyPassword;
    }

    public DeploymentZoneSegment getDeploymentZone() {
            return deploymentZone;
    }

    public void setDeploymentZone(DeploymentZoneSegment deploymentZone) {
            this.deploymentZone = deploymentZone;
    }

    //
    // toString 
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BaseSubsystemPropertyFile{");
        sb.append("subsystemInstant=").append(subsystemInstant);
        sb.append(", deploymentMode=").append(deploymentMode);
        sb.append(", deploymentZone=").append(deploymentZone);
        sb.append(", subsystemImageProperties=").append(subsystemImageProperties);
        sb.append(", trustStorePassword=").append(trustStorePassword);
        sb.append(", keyPassword=").append(keyPassword);
        sb.append(", volumeMounts=").append(volumeMounts);
        sb.append(", configFiles=").append(configFiles);
        sb.append('}');
        return sb.toString();
    }
        
}
