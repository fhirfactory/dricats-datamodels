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
package net.fhirfactory.dricats.internals.fhir.r4.resources.communication.factories;

import net.fhirfactory.dricats.internals.fhir.r4.codesystems.PegacornIdentifierCodeEnum;
import net.fhirfactory.dricats.internals.fhir.r4.resources.identifier.PegacornIdentifierFactory;
import org.hl7.fhir.r4.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.Instant;
import java.util.Date;

@ApplicationScoped
public class CommunicationFactory {
    private static final Logger LOG = LoggerFactory.getLogger(CommunicationFactory.class);

    @Inject
    private PegacornIdentifierFactory identifierFactory;

    public Communication newCommunicationResource(String idValue, Date date) {
        LOG.debug(".newCommunicationResource(): Entry, idValue->{}, date->{}", idValue, date);
        Communication communicationResource = new Communication();
        Period newPeriod = new Period();
        if(date != null) {
            newPeriod.setStart(date);
        } else {
            newPeriod.setStart(Date.from(Instant.now()));
        }
        Identifier baseIdentifier = identifierFactory.newIdentifier(PegacornIdentifierCodeEnum.IDENTIFIER_CODE_HL7V2_COMMUNICATION_CONTAINER,idValue,newPeriod);
        communicationResource.addIdentifier(baseIdentifier);

        LOG.debug(".newCommunicationResource(): Exit, communicationResource->{}", communicationResource);
        return(communicationResource);
    }
}
