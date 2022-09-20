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
package net.fhirfactory.dricats.model.component.valuesets;

public enum ComponentStatusEnum {
    SOFTWARE_COMPONENT_STARTING("Starting", "pegacorn.fhir.device.status.starting", "Software Component is Starting"),
    SOFTWARE_COMPONENT_STOPPING("Stopping", "pegacorn.fhir.device.status.stopping", "Software Component is Shutting Down"),
    SOFTWARE_COMPONENT_OPERATIONAL("Operational", "pegaccorn.fhir.device.status.operational", "Software Component is Operational"),
    SOFTWARE_COMPONENT_STATUS_UNKNOWN("OperationalStatusUnknown", "pegacorn.fhir.device.status.unknown", "Software Component Status is Unknown"),
    SOFTWARE_COMPONENT_FAILED("Failed", "pegacorn.fhir.device.status.faield", "Software Component Failed");

    private String token;
    private String displayName;
    private String displayText;

    private ComponentStatusEnum(String name, String token, String displayText){
        this.token = token;
        this.displayName = name;
        this.displayText = displayText;
    }

    public String getDisplayName(){
        return(this.displayName);
    }

    public String getToken(){
        return(this.token);
    }

    public String getDisplayText(){
        return(this.displayText);
    }
}
