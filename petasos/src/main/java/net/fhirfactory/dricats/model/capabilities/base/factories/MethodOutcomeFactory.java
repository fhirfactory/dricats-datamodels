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
package net.fhirfactory.dricats.model.capabilities.base.factories;

import ca.uhn.fhir.rest.api.MethodOutcome;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.fhirfactory.dricats.model.transaction.model.PegacornTransactionOutcome;
import net.fhirfactory.dricats.model.transaction.model.SimpleResourceID;
import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.r4.model.IdType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MethodOutcomeFactory {
    private static final Logger LOG = LoggerFactory.getLogger(MethodOutcomeFactory.class);

    private ObjectMapper jsonMapper;

    //
    // Constructor(s)
    //

    public MethodOutcomeFactory(){
        this.jsonMapper = new ObjectMapper();
    }

    public MethodOutcome convertToMethodOutcome(String methodOutcomeString) {
        if (StringUtils.isEmpty(methodOutcomeString)) {
            MethodOutcome outcome = new MethodOutcome();
            outcome.setCreated(false);
            return (outcome);
        }
        PegacornTransactionOutcome transactionOutcome = null;
        try {
            transactionOutcome = getJSONMapper().readValue(methodOutcomeString, PegacornTransactionOutcome.class);
        } catch (JsonProcessingException e) {
            getLogger().error(".convertToMethodOutcome(): Cannot parse MethodOutcome object! ", e);
        }
        MethodOutcome methodOutcome = null;
        if (transactionOutcome != null) {
            String resourceURL = null;
            String resourceType = "AuditEvent";
            if (transactionOutcome.isTransactionSuccessful()) {
                String resourceValue = transactionOutcome.getResourceID().getValue();
                String resourceVersion = SimpleResourceID.DEFAULT_VERSION;
                if (transactionOutcome.getResourceID() != null) {
                    if (transactionOutcome.getResourceID().getResourceType() != null) {
                        resourceType = transactionOutcome.getResourceID().getResourceType();
                    }
                    if (transactionOutcome.getResourceID().getVersion() != null) {
                        resourceVersion = transactionOutcome.getResourceID().getVersion();
                    }
                    if (transactionOutcome.getResourceID().getUrl() != null) {
                        resourceURL = transactionOutcome.getResourceID().getUrl();
                    }
                    IdType id = new IdType();
                    id.setParts(resourceURL, resourceType, resourceValue, resourceVersion);
                    methodOutcome = new MethodOutcome();
                    methodOutcome.setId(id);
                    methodOutcome.setCreated(transactionOutcome.isTransactionSuccessful());
                }
            }
        }
        if (methodOutcome == null) {
            methodOutcome = new MethodOutcome();
            methodOutcome.setCreated(false);
        }
        return (methodOutcome);
    }

    //
    // Getters (and Setters)
    //

    protected Logger getLogger(){
        return(LOG);
    }

    ObjectMapper getJSONMapper() {
        return (jsonMapper);
    }
}
