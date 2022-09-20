/*
 * Copyright (c) 2022 Mark A. Hunter (ACT Health)
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
package net.fhirfactory.dricats.model.petasos.participant.datatypes;

import java.util.Objects;

import net.fhirfactory.dricats.model.component.datatypes.ComponentId;
import org.apache.commons.lang3.SerializationUtils;

public class PetasosParticipantId extends ComponentId {
    private String participantName;
    private String participantVersion;
    private String subsystemName;
    private String participantDisplayName;

    //
    // Constructor
    //

    public PetasosParticipantId(){
        super();
        this.participantName = null;
        this.participantVersion = null;
        this.participantDisplayName = null;
        this.subsystemName = null;
    }

    public PetasosParticipantId(String participantName){
        super(participantName, "1.0.0");
        this.participantName = SerializationUtils.clone(participantName);
        this.participantVersion = "1.0.0";
        this.participantDisplayName = participantName;
        this.subsystemName = null;
    }

    public PetasosParticipantId(String subsystemName, String parentParticipantName, String participantName, String version){
        super(participantName, version);
        this.participantName = parentParticipantName +  "." + participantName;
        this.participantVersion = version;
        this.participantDisplayName = participantName;
        this.subsystemName = subsystemName;
    }

    //
    // Getters and Setters
    //

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getParticipantVersion() {
        return participantVersion;
    }

    public void setParticipantVersion(String participantVersion) {
        this.participantVersion = participantVersion;
    }

    public String getSubsystemName() {
        return subsystemName;
    }

    public void setSubsystemName(String subsystemName) {
        this.subsystemName = subsystemName;
    }

    public String getParticipantDisplayName() {
        return participantDisplayName;
    }

    public void setParticipantDisplayName(String participantDisplayName) {
        this.participantDisplayName = participantDisplayName;
    }

    //
    // Equals and Hash
    //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PetasosParticipantId)) return false;
        PetasosParticipantId that = (PetasosParticipantId) o;
        return Objects.equals(getParticipantName(), that.getParticipantName()) && Objects.equals(getParticipantVersion(), that.getParticipantVersion()) && Objects.equals(getSubsystemName(), that.getSubsystemName()) && Objects.equals(getParticipantDisplayName(), that.getParticipantDisplayName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getParticipantName(), getParticipantVersion(), getSubsystemName(), getParticipantDisplayName());
    }


    //
    // To String
    //

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PetasosParticipantId{");
        sb.append("name=").append(participantName);
        sb.append(", version=").append(participantVersion);
        sb.append(", subsystemName=").append(subsystemName);
        sb.append(", displayName=").append(participantDisplayName);
        sb.append(", ").append(super.toString()).append('}');
        return sb.toString();
    }
}
