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
package net.fhirfactory.dricats.model.petasos.ipc.fhir.server.common;

import java.io.Serializable;
import java.util.Map;

import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Property;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.model.ResourceType;

import ca.uhn.fhir.rest.api.MethodOutcome;
import net.fhirfactory.dricats.internals.fhir.r4.transactions.TransactionOutcome;

public interface ResourceAccessorInterfaceBase {
	public TransactionOutcome getResource(IdType id);

	public TransactionOutcome createResource(Resource newResource);

	public TransactionOutcome updateResource(Resource resourceToUpdate);

	public TransactionOutcome deleteResource(Resource resourceToRemove);

	public boolean supportsSearch(String searchName, Map<Property, Serializable> parameterSet);

	public TransactionOutcome searchUsingCriteria(ResourceType resourceType, String searchName,
			Map<Property, Serializable> parameterSet);

	public TransactionOutcome searchUsingIdentifier(Identifier identifier);

	public Identifier getBestIdentifier(MethodOutcome outcome);

	public void initialiseServices();
}
