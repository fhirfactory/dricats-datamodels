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
package net.fhirfactory.dricats.interfaces.pathway;

import java.util.Set;

import net.fhirfactory.dricats.model.component.datatypes.ComponentId;
import net.fhirfactory.dricats.model.petasos.participant.capabilities.PetasosParticipantRegistration;
import net.fhirfactory.dricats.model.petasos.participant.components.common.PetasosParticipant;
import net.fhirfactory.dricats.model.petasos.participant.datatypes.PetasosParticipantId;

public interface TaskPathwayManagementServiceInterface {
    public boolean isPetasosParticipantRegistered(PetasosParticipant publisher);

    // Producer (Subscription) Maps
    public Set<PetasosParticipant> getDownstreamTaskPerformersForTaskProducer(String producerServiceName);

    // Participant Registration/De-Registration
    public PetasosParticipantRegistration registerPetasosParticipant(PetasosParticipant participant);
    public PetasosParticipantRegistration updatePetasosParticipant(PetasosParticipant participant);
    public PetasosParticipantRegistration deregisterPetasosParticipant(PetasosParticipantId participant);

    // Performer Maps
    public PetasosParticipantRegistration getPetasosParticipantRegistration(ComponentId participantId);
    public Set<PetasosParticipantRegistration> getParticipantRegistrationSetForParticipantName(String participantSeviceName);

    // Macro
    public Set<PetasosParticipantRegistration> getAllRegistrations();

    //
    public PetasosParticipant getMyPetasosParticipant();
}
