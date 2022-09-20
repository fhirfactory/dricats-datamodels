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
package net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.base;

import net.fhirfactory.dricats.model.topology.endpoints.base.EndpointTopologyNode;
import net.fhirfactory.dricats.model.topology.endpoints.base.InternalCamelRouteETN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.base.WorkUnitProcessorTopologyNode;


public abstract class PetasosEnabledExternalIPCIngresWUPTopologyNode extends WorkUnitProcessorTopologyNode {
    
    private EndpointTopologyNode ingresEndpoint;
    private InternalCamelRouteETN egressEndpoint;

    //
    // Constructor(s)
    //

    public PetasosEnabledExternalIPCIngresWUPTopologyNode(){
        super();
        this.ingresEndpoint = null;
        this.egressEndpoint = null;
        getNodeType().setTypeName("PetasosEnabledExternalIPCIngresWorkUnitProcessor");
        getNodeType().setDisplayTypeName("Petasos-Enabled-ExternalIPC-Ingres-WorkUnitProcessor");
    }

    //
    // Getters and Setters
    //

    public EndpointTopologyNode getIngresEndpoint() {
        return ingresEndpoint;
    }

    public void setIngresEndpoint(EndpointTopologyNode ingresEndpoint) {
        this.ingresEndpoint = ingresEndpoint;
    }

    public InternalCamelRouteETN getEgressEndpoint() {
        return egressEndpoint;
    }

    public void setEgressEndpoint(InternalCamelRouteETN egressEndpoint) {
        this.egressEndpoint = egressEndpoint;
    }

    //
    // To String
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PetasosEnabledExternalIPCIngresWUPTopologyNode{");
        sb.append("ingresEndpoint=").append(ingresEndpoint);
        sb.append(", egressEndpoint=").append(egressEndpoint);
        sb.append(", ").append(super.toString());
        sb.append('}');
        return sb.toString();
    }

}
