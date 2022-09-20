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
package net.fhirfactory.dricats.model.configuration.filebased.segments;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author mhunter
 */
public class MITaFInstanceConfigurationSegment {
    private Boolean allowSoftFailuresOnTransforms;
    private String transformationRulesLocation;
    
    //
    // Constructor(s)
    //
    
    public MITaFInstanceConfigurationSegment(){
        
    }
    
    //
    // Getters and Setters
    //
    
    @JsonIgnore
    public Boolean hasAllowSoftFailureOnTransforms(){
        boolean hasValue = this.allowSoftFailuresOnTransforms != null;
        return(hasValue);
    }

    public Boolean getAllowSoftFailuresOnTransforms() {
        return allowSoftFailuresOnTransforms;
    }

    public void setAllowSoftFailuresOnTransforms(Boolean allowSoftFailuresOnTransforms) {
        this.allowSoftFailuresOnTransforms = allowSoftFailuresOnTransforms;
    }
    
    @JsonIgnore
    public Boolean hasTransformationRulesLocation(){
        boolean hasValue = this.transformationRulesLocation != null;
        return(hasValue);
    }

    public String getTransformationRulesLocation() {
        return transformationRulesLocation;
    }

    public void setTransformationRulesLocation(String transformationRulesLocation) {
        this.transformationRulesLocation = transformationRulesLocation;
    }
    
    //
    // toString
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MITaFInstanceConfigurationSegment{");
        sb.append("allowSoftFailuresOnTransforms=").append(allowSoftFailuresOnTransforms);
        sb.append(", transformationRulesLocation=").append(transformationRulesLocation);
        sb.append(", ").append(super.toString()).append('}');
        return sb.toString();
    }
    
    
}
