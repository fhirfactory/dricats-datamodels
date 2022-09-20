/*
 * Copyright (c) 2020 Mark A. Hunter (ACT Health)
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
package net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.processingplants;


import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.processingplants.base.PetasosEnabledProcessingPlantTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workshops.ExternalIPCWorkshopTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workshops.GatekeeperWorkshopTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workshops.PetasosIPCWorkshopTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workshops.PetasosObservationsWorkshopTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workshops.PetasosTaskingWorkshopTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workshops.TransformWorkshopTN;

public abstract class FHIRBreakProcessingPlantTN extends PetasosEnabledProcessingPlantTN {

    private ExternalIPCWorkshopTN externalIPCWorkshop;
    private TransformWorkshopTN transformWorkshop;
    private GatekeeperWorkshopTN gatekeeperWorkshop;

    //
    // Constructor(s)
    //

    public FHIRBreakProcessingPlantTN(){
        super();
        this.externalIPCWorkshop = null;
        this.transformWorkshop = null;
        this.gatekeeperWorkshop = null;
    }

    //
    // Getters and Setters
    //

    public ExternalIPCWorkshopTN getExternalIPCWorkshop() {
        return externalIPCWorkshop;
    }

    public void setExternalIPCWorkshop(ExternalIPCWorkshopTN externalIPCWorkshop) {
        this.externalIPCWorkshop = externalIPCWorkshop;
    }

    public TransformWorkshopTN getTransformWorkshop() {
        return transformWorkshop;
    }

    public void setTransformWorkshop(TransformWorkshopTN transformWorkshop) {
        this.transformWorkshop = transformWorkshop;
    }

    public GatekeeperWorkshopTN getGatekeeperWorkshop() {
        return gatekeeperWorkshop;
    }

    public void setGatekeeperWorkshop(GatekeeperWorkshopTN gatekeeperWorkshop) {
        this.gatekeeperWorkshop = gatekeeperWorkshop;
    }
    
    
    //
    // To String
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FHIRBreakProcessingPlantTN{");
        sb.append("externalIPCWorkshop=").append(externalIPCWorkshop);
        sb.append(", transformWorkshop=").append(transformWorkshop);
        sb.append(", gatekeeperWorkshop=").append(gatekeeperWorkshop);
        sb.append(", ").append(super.toString()).append("}");
        return sb.toString();
    }


}
