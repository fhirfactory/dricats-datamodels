/*
 * Copyright (c) 2022 Mark A. Hunter
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
package net.fhirfactory.dricats.model.petasos.tasking.definition.datatypes.dataparcel;

import java.io.Serializable;
import java.time.Instant;

import org.apache.commons.lang3.SerializationUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import net.fhirfactory.dricats.model.constants.DeploymentPropertyConstants;
import net.fhirfactory.dricats.model.petasos.participant.datatypes.PetasosParticipantId;

public class DataParcelActivityLocation implements Serializable {
	private PetasosParticipantId processingPlantParticipantName;
	private PetasosParticipantId workUnitProcessorParticipantName;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSXXX", timezone = DeploymentPropertyConstants.DEFAULT_TIMEZONE)
	private Instant activityInstant;

	//
	// Constructor(s)
	//

	public DataParcelActivityLocation() {
		this.activityInstant = null;
		this.processingPlantParticipantName = null;
		this.workUnitProcessorParticipantName = null;
	}

	public DataParcelActivityLocation(String processingPlant, String workUnitProcessor) {
		this.processingPlantParticipantName = new PetasosParticipantId(processingPlant);
		this.workUnitProcessorParticipantName = new PetasosParticipantId(workUnitProcessor);
	}

	public DataParcelActivityLocation(String processingPlant, String workUnitProcessor, Instant instant) {
		this.processingPlantParticipantName = new PetasosParticipantId(processingPlant);
		this.workUnitProcessorParticipantName = new PetasosParticipantId(workUnitProcessor);
		this.activityInstant = SerializationUtils.clone(instant);
	}

	public DataParcelActivityLocation(DataParcelActivityLocation ori) {
		if (ori.hasActivityInstant()) {
			setActivityInstant(SerializationUtils.clone(ori.getActivityInstant()));
		} else {
			setActivityInstant(null);
		}
		if (ori.hasWorkUnitProcessorParticipantName()) {
			setWorkUnitProcessorParticipantName(SerializationUtils.clone(ori.getWorkUnitProcessorParticipantName()));
		} else {
			setWorkUnitProcessorParticipantName(null);
		}
		if (ori.hasProcessingPlantParticipantName()) {
			setProcessingPlantParticipantName(SerializationUtils.clone(ori.getProcessingPlantParticipantName()));
		}
	}

	//
	// Getters and Setters
	//

	@JsonIgnore
	public boolean hasProcessingPlantParticipantName() {
		boolean hasValue = this.processingPlantParticipantName != null;
		return (hasValue);
	}

	public PetasosParticipantId getProcessingPlantParticipantName() {
		return processingPlantParticipantName;
	}

	public void setProcessingPlantParticipantName(PetasosParticipantId processingPlantParticipantName) {
		this.processingPlantParticipantName = processingPlantParticipantName;
	}

	@JsonIgnore
	public boolean hasWorkUnitProcessorParticipantName() {
		boolean hasValue = this.workUnitProcessorParticipantName != null;
		return (hasValue);
	}

	public PetasosParticipantId getWorkUnitProcessorParticipantName() {
		return workUnitProcessorParticipantName;
	}

	public void setWorkUnitProcessorParticipantName(PetasosParticipantId workUnitProcessorParticipantName) {
		this.workUnitProcessorParticipantName = workUnitProcessorParticipantName;
	}

	@JsonIgnore
	public boolean hasActivityInstant() {
		boolean hasValue = this.activityInstant != null;
		return (hasValue);
	}

	public Instant getActivityInstant() {
		return activityInstant;
	}

	public void setActivityInstant(Instant activityInstant) {
		this.activityInstant = activityInstant;
	}

	//
	// toString
	//

	@Override
	public String toString() {
		return "ParcelOfWorkActivityPoint{" + "processingPlantParticipantName=" + processingPlantParticipantName
				+ ", workUnitProcessorParticipantName=" + workUnitProcessorParticipantName + ", activityInstant="
				+ activityInstant + '}';
	}
}
