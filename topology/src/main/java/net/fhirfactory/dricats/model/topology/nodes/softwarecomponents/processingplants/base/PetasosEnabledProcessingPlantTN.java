/*
 * The MIT License
 *
 * Copyright 2022 Mark Hunter (ACT Health).
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
package net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.processingplants.base;

import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workshops.PetasosIPCWorkshopTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workshops.PetasosObservationsWorkshopTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workshops.PetasosTaskingWorkshopTN;

/**
 *
 * @author mhunter
 */
public abstract class PetasosEnabledProcessingPlantTN extends ProcessingPlantTopologyNode{
    private PetasosIPCWorkshopTN petasosInternalIPCWorkshop;
    private PetasosObservationsWorkshopTN petasosObservationsWorkshop;
    private PetasosTaskingWorkshopTN petasosTaskingWorkshop;
    
    //
    // Constructor(s)
    //
    
    public PetasosEnabledProcessingPlantTN(){
        super();
        this.petasosInternalIPCWorkshop = null;
        this.petasosObservationsWorkshop = null;
        this.petasosTaskingWorkshop = null;
    }
    
    //
    // Getters and Setters
    //
    
    public PetasosIPCWorkshopTN getPetasosInternalIPCWorkshop() {
        return petasosInternalIPCWorkshop;
    }

    public void setPetasosInternalIPCWorkshop(PetasosIPCWorkshopTN petasosInternalIPCWorkshop) {
        this.petasosInternalIPCWorkshop = petasosInternalIPCWorkshop;
        synchronized (getWorkshopMapLock()) {
            if(getWorkshopMap().containsKey(petasosInternalIPCWorkshop.getParticipantName())){
                getWorkshopMap().remove(petasosInternalIPCWorkshop.getParticipantName());
            }
            getWorkshopMap().put(petasosInternalIPCWorkshop.getParticipantName(),petasosInternalIPCWorkshop );
        }
    }

    public PetasosObservationsWorkshopTN getPetasosObservationsWorkshop() {
        return petasosObservationsWorkshop;
    }

    public void setPetasosObservationsWorkshop(PetasosObservationsWorkshopTN petasosObservationsWorkshop) {
        this.petasosObservationsWorkshop = petasosObservationsWorkshop;
        synchronized (getWorkshopMapLock()) {
            if(getWorkshopMap().containsKey(petasosObservationsWorkshop.getParticipantName())){
                getWorkshopMap().remove(petasosObservationsWorkshop.getParticipantName());
            }
            getWorkshopMap().put(petasosObservationsWorkshop.getParticipantName(),petasosObservationsWorkshop );
        }
    }

    public PetasosTaskingWorkshopTN getPetasosTaskingWorkshop() {
        return petasosTaskingWorkshop;
    }

    public void setPetasosTaskingWorkshop(PetasosTaskingWorkshopTN petasosTaskingWorkshop) {
        this.petasosTaskingWorkshop = petasosTaskingWorkshop;
        synchronized (getWorkshopMapLock()) {
            if(getWorkshopMap().containsKey(petasosTaskingWorkshop.getParticipantName())){
                getWorkshopMap().remove(petasosTaskingWorkshop.getParticipantName());
            }
            getWorkshopMap().put(petasosTaskingWorkshop.getParticipantName(),petasosTaskingWorkshop );
        }
    }
    
    //
    // toString
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PetasosEnabledProcessingPlantTN{");
        sb.append("petasosInternalIPCWorkshop=").append(petasosInternalIPCWorkshop);
        sb.append(", petasosObservationsWorkshop=").append(petasosObservationsWorkshop);
        sb.append(", petasosTaskingWorkshop=").append(petasosTaskingWorkshop);
        sb.append(", ").append(super.toString()).append('}');
        return sb.toString();
    }
    
    
}
