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
package net.fhirfactory.dricats.model.configuration.filebased.segments;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;

public class SubsystemInstanceSegment {
    private String subsystemParticipantName;
    private String subsystemParticipantDisplayName;
    private String subsystemVersion;

    //
    // Constructor(s)
    //

    public SubsystemInstanceSegment(){
        subsystemParticipantName = null;
        subsystemVersion = null;
        subsystemParticipantDisplayName = null;
    }

    //
    // Getters and Setters
    //

    @JsonIgnore
    public boolean hasSubsystemParticipantDisplayName(){
        boolean has = !(StringUtils.isEmpty(subsystemParticipantDisplayName));
        return(has);
    }

    
    @JsonIgnore
    public boolean hasSubsystemParticipantName(){
        boolean has = !(StringUtils.isEmpty(this.subsystemParticipantName));
        return(has);
    }

    @JsonIgnore
    public boolean hasSubsystemVersion(){
        boolean has = !(StringUtils.isEmpty(this.subsystemVersion));
        return(has);
    }

    
    public String getSubsystemParticipantName() {
        return subsystemParticipantName;
    }

    public void setSubsystemParticipantName(String subsystemParticipantName) {
        this.subsystemParticipantName = subsystemParticipantName;
    }

    public String getSubsystemVersion() {
        return subsystemVersion;
    }

    public void setSubsystemVersion(String subsystemVersion) {
        this.subsystemVersion = subsystemVersion;
    }

   
    public String getSubsystemParticipantDisplayName() {
        return subsystemParticipantDisplayName;
    }

    public void setSubsystemParticipantDisplayName(String subsystemParticipantDisplayName) {
        this.subsystemParticipantDisplayName = subsystemParticipantDisplayName;
    }

   
    //
    // toString
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SubsystemInstanceSegment{");
        sb.append("subsystemParticipantName=").append(subsystemParticipantName);
        sb.append(", subsystemParticipantDisplayName=").append(subsystemParticipantDisplayName);
        sb.append(", subsystemVersion=").append(subsystemVersion);
        sb.append('}');
        return sb.toString();
    }
    
}
