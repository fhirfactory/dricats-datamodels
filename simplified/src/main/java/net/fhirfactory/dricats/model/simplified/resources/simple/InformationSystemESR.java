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
package net.fhirfactory.dricats.model.simplified.resources.simple;

import net.fhirfactory.dricats.model.simplified.resources.simple.common.ExtremelySimplifiedResource;
import net.fhirfactory.dricats.model.simplified.resources.simple.datatypes.IdentifierESDT;
import org.hl7.fhir.r4.model.ResourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class InformationSystemESR extends ExtremelySimplifiedResource {
    private static final Logger LOG = LoggerFactory.getLogger(InformationSystemESR.class);

    private IdentifierESDT owningOrganisation;
    private IdentifierESDT operatingOrganisation;
    private IdentifierESDT serviceDeliveryLocation;
    private List<IdentifierESDT> infrastructureSites;
    private List<IdentifierESDT> subsystems;

    //
    // Constructor(s)
    //


    //
    // Getters and Setters
    //

    @Override
    protected Logger getLogger() {
        return (LOG);
    }

    @Override
    protected ResourceType specifyResourceType() {
        return (ResourceType.HealthcareService);
    }

    public IdentifierESDT getOwningOrganisation() {
        return owningOrganisation;
    }

    public void setOwningOrganisation(IdentifierESDT owningOrganisation) {
        this.owningOrganisation = owningOrganisation;
    }

    public IdentifierESDT getOperatingOrganisation() {
        return operatingOrganisation;
    }

    public void setOperatingOrganisation(IdentifierESDT operatingOrganisation) {
        this.operatingOrganisation = operatingOrganisation;
    }

    public IdentifierESDT getServiceDeliveryLocation() {
        return serviceDeliveryLocation;
    }

    public void setServiceDeliveryLocation(IdentifierESDT serviceDeliveryLocation) {
        this.serviceDeliveryLocation = serviceDeliveryLocation;
    }

    public List<IdentifierESDT> getInfrastructureSites() {
        return infrastructureSites;
    }

    public void setInfrastructureSites(List<IdentifierESDT> infrastructureSites) {
        this.infrastructureSites = infrastructureSites;
    }

    public List<IdentifierESDT> getSubsystems() {
        return subsystems;
    }

    public void setSubsystems(List<IdentifierESDT> subsystems) {
        this.subsystems = subsystems;
    }

    //
    // toString()
    //


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InformationSystemESR{");
        sb.append("owningOrganisation=").append(owningOrganisation);
        sb.append(", operatingOrganisation=").append(operatingOrganisation);
        sb.append(", serviceDeliveryLocation=").append(serviceDeliveryLocation);
        sb.append(", infrastructureSites=").append(infrastructureSites);
        sb.append(", subsystems=").append(subsystems);
        sb.append(", ").append(super.toString()).append('}');
        return sb.toString();
    }
}
