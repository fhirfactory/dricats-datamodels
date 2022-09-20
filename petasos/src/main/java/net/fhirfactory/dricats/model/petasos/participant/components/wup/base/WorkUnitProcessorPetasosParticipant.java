/*
 * The MIT License
 *
 * Copyright 2022 MArk A. Hunter (ACT Health).
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
package net.fhirfactory.dricats.model.petasos.participant.components.wup.base;

import net.fhirfactory.dricats.model.petasos.participant.components.common.PetasosParticipant;
import net.fhirfactory.dricats.model.petasos.participant.components.wup.valuesets.WUPArchetypeEnum;
import net.fhirfactory.dricats.model.petasos.participant.components.wup.valuesets.WUPClusterModeEnum;
import net.fhirfactory.dricats.model.petasos.participant.components.wup.valuesets.WUPSystemModeEnum;

/**
 *
 * @author mhunter
 */
public abstract class WorkUnitProcessorPetasosParticipant extends PetasosParticipant {
	private WUPArchetypeEnum archetype;
	private WUPClusterModeEnum clusterMode;
	private WUPSystemModeEnum systemMode;

	//
	// Constructor(s)
	//

	public WorkUnitProcessorPetasosParticipant() {
		super();
		this.archetype = WUPArchetypeEnum.WUP_NATURE_MESSAGE_WORKER;
		this.clusterMode = WUPClusterModeEnum.CLUSTER_SINGLE_STANDALONE;
		this.systemMode = WUPSystemModeEnum.SYSTEMWIDE_SINGLE_STANDALONE;
	}

	//
	// Getters and Setters
	//

	public WUPArchetypeEnum getArchetype() {
		return archetype;
	}

	public void setArchetype(WUPArchetypeEnum archetype) {
		this.archetype = archetype;
	}

	public WUPClusterModeEnum getClusterMode() {
		return clusterMode;
	}

	public void setClusterMode(WUPClusterModeEnum clusterMode) {
		this.clusterMode = clusterMode;
	}

	public WUPSystemModeEnum getSystemMode() {
		return systemMode;
	}

	public void setSystemMode(WUPSystemModeEnum systemMode) {
		this.systemMode = systemMode;
	}

	//
	// toString()
	//

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("WorkUnitProcessorPetasosParticipant{");
		sb.append("archetype=").append(archetype);
		sb.append(", clusterMode=").append(clusterMode);
		sb.append(", systemMode=").append(systemMode);
		sb.append(", ").append(super.toString()).append('}');
		return sb.toString();
	}

}
