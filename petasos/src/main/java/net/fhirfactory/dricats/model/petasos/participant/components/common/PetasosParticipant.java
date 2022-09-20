/*
 * The MIT License
 *
 * Copyright 2022 mhunter.
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
package net.fhirfactory.dricats.model.petasos.participant.components.common;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import net.fhirfactory.dricats.model.capability.Capability;
import net.fhirfactory.dricats.model.component.datatypes.ComponentId;
import net.fhirfactory.dricats.model.constants.DeploymentPropertyConstants;
import net.fhirfactory.dricats.model.petasos.participant.datatypes.PetasosParticipantId;
import net.fhirfactory.dricats.model.petasos.participant.valuesets.PetasosParticipantExecutionControlEnum;
import net.fhirfactory.dricats.model.petasos.tasking.definition.datatypes.work.TaskWorkItemManifestType;
import net.fhirfactory.dricats.model.petasos.tasking.fulfillment.replication.PetasosParticipantFulfillment;
import net.fhirfactory.dricats.model.petasos.tasking.routing.subscriptions.datatypes.DataParcelManifestSubscriptionMask;

/**
 *
 * @author mhunter
 */
public class PetasosParticipant implements Serializable  {
    private PetasosParticipantId participantId;

    private Set<DataParcelManifestSubscriptionMask> subscriptions;
    private Set<TaskWorkItemManifestType> publishedWorkItemManifests;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSXXX", timezone = DeploymentPropertyConstants.DEFAULT_TIMEZONE)
    private Instant utilisationUpdateInstant;
    private PetasosParticipantFulfillment fulfillmentState;
    private PetasosParticipantExecutionControlEnum executionControlStatus;
    private Set<Capability> capabilitySet;
    
    //
    // Constructor(s)
    //
    
    public PetasosParticipant(){
        super();
        this.participantId = null;
        this.utilisationUpdateInstant = null;
        this.subscriptions = new HashSet<>();
        this.publishedWorkItemManifests = new HashSet<>();
        this.fulfillmentState = null;
        this.capabilitySet = new HashSet<>();
        this.executionControlStatus = PetasosParticipantExecutionControlEnum.EXECUTION_CONTROL_ACTIVE;
    }

    public PetasosParticipant(PetasosParticipant ori){
        this.capabilitySet = new HashSet<>();
        this.utilisationUpdateInstant = null;
        this.subscriptions = new HashSet<>();
        this.publishedWorkItemManifests = new HashSet<>();
        this.participantId = null;
        
        this.executionControlStatus = ori.getExecutionControlStatus();
        if (ori.hasUtilisationUpdateInstant()) {
            this.setUtilisationUpdateInstant(ori.getUtilisationUpdateInstant());
        }
        if (!ori.getSubscriptions().isEmpty()) {
            this.getSubscriptions().addAll(ori.getSubscriptions());
        }
        if (!ori.getPublishedWorkItemManifests().isEmpty()) {
            this.getPublishedWorkItemManifests().addAll(ori.getPublishedWorkItemManifests());
        }
        if (ori.hasFulfillmentState()) {
            this.setFulfillmentState(ori.getFulfillmentState());
        }
        if(!ori.getCapabilitySet().isEmpty()){
            this.getCapabilitySet().clear();
            this.getCapabilitySet().addAll(ori.getCapabilitySet());
        }
        if(ori.hasParticipantId()){
            setParticipantId(ori.getParticipantId());
        }
    }
    
    //
    // Getters and Setters
    //
    
    public PetasosParticipantExecutionControlEnum getExecutionControlStatus() {
    	return(this.executionControlStatus);
    }
    
    public void setExecutionControlStatus(PetasosParticipantExecutionControlEnum status) {
    	this.executionControlStatus = status;
    }

    @JsonIgnore
    public boolean hasParticipantId(){
        boolean hasValue = this.participantId != null;
        return(hasValue);
    }

    public PetasosParticipantId getParticipantId() {
        return participantId;
    }

    public void setParticipantId(PetasosParticipantId participantName) {
        this.participantId = participantName;
    }

    public Set<Capability> getCapabilitySet() {
        return capabilitySet;
    }

    public void setCapabilitySet(Set<Capability> capabilitySet) {
        this.capabilitySet = capabilitySet;
    }

    public boolean hasFulfillmentState() {
        boolean hasValue = this.fulfillmentState != null;
        return (hasValue);
    }

    public PetasosParticipantFulfillment getFulfillmentState() {
        return fulfillmentState;
    }

    public void setFulfillmentState(PetasosParticipantFulfillment fulfillmentState) {
        this.fulfillmentState = fulfillmentState;
    }

    @JsonIgnore
    public boolean hasUtilisationUpdateInstant() {
        boolean hasValue = this.utilisationUpdateInstant != null;
        return (hasValue);
    }

    public void setUtilisationUpdateInstant(Instant utilisationUpdateInstant) {
        this.utilisationUpdateInstant = utilisationUpdateInstant;
    }

    public Instant getUtilisationUpdateInstant() {
        return utilisationUpdateInstant;
    }

    public Set<DataParcelManifestSubscriptionMask> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<DataParcelManifestSubscriptionMask> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Set<TaskWorkItemManifestType> getPublishedWorkItemManifests() {
        return publishedWorkItemManifests;
    }

    public void setPublishedWorkItemManifests(Set<TaskWorkItemManifestType> publishedWorkItemManifests) {
        this.publishedWorkItemManifests = publishedWorkItemManifests;
    }

    //
    // toString
    //

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PetasosParticipant{");
        sb.append("participantId=").append(participantId);
        sb.append(", subscriptions=").append(subscriptions);
        sb.append(", publishedWorkItemManifests=").append(publishedWorkItemManifests);
        sb.append(", utilisationUpdateInstant=").append(utilisationUpdateInstant);
        sb.append(", fulfillmentState=").append(fulfillmentState);
        sb.append(", capabilitySet=").append(capabilitySet);
        sb.append(", ").append(super.toString()).append('}');
        return sb.toString();
    }
}
