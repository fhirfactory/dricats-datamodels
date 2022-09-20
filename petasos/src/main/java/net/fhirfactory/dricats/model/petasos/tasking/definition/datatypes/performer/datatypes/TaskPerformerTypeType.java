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
package net.fhirfactory.dricats.model.petasos.tasking.definition.datatypes.performer.datatypes;

import java.io.Serializable;

import net.fhirfactory.dricats.model.component.datatypes.ComponentId;
import net.fhirfactory.dricats.model.petasos.participant.datatypes.PetasosParticipantId;

public class TaskPerformerTypeType implements Serializable {
	private PetasosParticipantId requiredPerformerType;
	private ComponentId knownFulfillerInstance;
	private String requiredParticipantName;
	private String requiredSubsystemParticipantName;
	private String requiredPerformerTypeDescription;

	//
	// Constructor(s)
	//

	public TaskPerformerTypeType() {
		this.requiredPerformerType = null;
		this.requiredPerformerTypeDescription = null;
		this.requiredParticipantName = null;
		this.knownFulfillerInstance = null;
		this.requiredSubsystemParticipantName = null;
	}

	//
	// Getters and Setters
	//

	public String getRequiredSubsystemParticipantName() {
		return requiredSubsystemParticipantName;
	}

	public void setRequiredSubsystemParticipantName(String requiredSubsystemParticipantName) {
		this.requiredSubsystemParticipantName = requiredSubsystemParticipantName;
	}

	public ComponentId getKnownFulfillerInstance() {
		return knownFulfillerInstance;
	}

	public void setKnownFulfillerInstance(ComponentId knownFulfillerInstance) {
		this.knownFulfillerInstance = knownFulfillerInstance;
	}

	public PetasosParticipantId getRequiredPerformerType() {
		return requiredPerformerType;
	}

	public void setRequiredPerformerType(PetasosParticipantId requiredPerformerType) {
		this.requiredPerformerType = requiredPerformerType;
	}

	public String getRequiredPerformerTypeDescription() {
		return requiredPerformerTypeDescription;
	}

	public void setRequiredPerformerTypeDescription(String requiredPerformerTypeDescription) {
		this.requiredPerformerTypeDescription = requiredPerformerTypeDescription;
	}

	public String getRequiredParticipantName() {
		return requiredParticipantName;
	}

	public void setRequiredParticipantName(String requiredParticipantName) {
		this.requiredParticipantName = requiredParticipantName;
	}

	//
	// To String
	//

	@Override
	public String toString() {
		return "TaskPerformerTypeType{" + "requiredPerformerType=" + requiredPerformerType + ", knownFulfillerInstance="
				+ knownFulfillerInstance + ", requiredParticipantName='" + requiredParticipantName + '\''
				+ ", requiredSubsystemParticipantName=" + requiredSubsystemParticipantName
				+ ", requiredPerformerTypeDescription='" + requiredPerformerTypeDescription + '\'' + '}';
	}
}
