/*
 * Copyright (c) 2021 Mark A. Hunter
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
package net.fhirfactory.dricats.model.simplified.resources.summaries.common;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.Instant;
import net.fhirfactory.dricats.model.component.datatypes.ComponentId;
import net.fhirfactory.dricats.model.constants.DeploymentPropertyConstants;
import net.fhirfactory.dricats.model.simplified.resources.simple.valuesets.ExtremelySimplifiedResourceTypeEnum;

public class ResourceSummaryBase implements Serializable {
    private String simplifiedId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSXXX", timezone = DeploymentPropertyConstants.DEFAULT_TIMEZONE)
    private Instant lastSynchronisationInstant;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSXXX", timezone = DeploymentPropertyConstants.DEFAULT_TIMEZONE)
    private Instant lastActivityInstant;
    private String name;
    private String displayName;
    private String version;
    private ExtremelySimplifiedResourceTypeEnum resourceESRType;

    //
    // Constructor(s)
    //

    public ResourceSummaryBase(){
        this.simplifiedId = null;
        this.lastActivityInstant = null;
        this.lastSynchronisationInstant = null;
        this.name = null;
        this.version = null;
        this.resourceESRType = null;
        this.displayName = null;
    }

    //
    // Getters And Setters
    //

    public Instant getLastSynchronisationInstant() {
        return lastSynchronisationInstant;
    }

    public void setLastSynchronisationInstant(Instant lastSynchronisationInstant) {
        this.lastSynchronisationInstant = lastSynchronisationInstant;
    }

    public Instant getLastActivityInstant() {
        return lastActivityInstant;
    }

    public void setLastActivityInstant(Instant lastActivityInstant) {
        this.lastActivityInstant = lastActivityInstant;
    }

    public String getSimplifiedId() {
        return simplifiedId;
    }

    public void setSimplifiedId(String simplifiedId) {
        this.simplifiedId = simplifiedId;
    }
    
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public ExtremelySimplifiedResourceTypeEnum getResourceESRType() {
        return resourceESRType;
    }

    public void setResourceESRType(ExtremelySimplifiedResourceTypeEnum resourceESRType) {
        this.resourceESRType = resourceESRType;
    }

    //
    // To String
    //

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResourceSummaryBase{");
        sb.append("simplifiedId='").append(simplifiedId).append('\'');
        sb.append(", lastSynchronisationInstant=").append(lastSynchronisationInstant);
        sb.append(", lastActivityInstant=").append(lastActivityInstant);
        sb.append(", name='").append(name).append('\'');
        sb.append(", displayName='").append(displayName).append('\'');
        sb.append(", version='").append(version).append('\'');
        sb.append(", resourceESRType=").append(resourceESRType);
        sb.append('}');
        return sb.toString();
    }
}
