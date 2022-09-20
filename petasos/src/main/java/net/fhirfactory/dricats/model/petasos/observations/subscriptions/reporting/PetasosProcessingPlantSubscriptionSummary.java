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
package net.fhirfactory.dricats.model.petasos.observations.subscriptions.reporting;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import net.fhirfactory.dricats.model.component.datatypes.ComponentId;

import net.fhirfactory.dricats.model.petasos.tasking.routing.subscriptions.datatypes.DataParcelManifestSubscriptionMask;

public class PetasosProcessingPlantSubscriptionSummary implements Serializable {
	private Map<ComponentId, PetasosSubscriberSubscriptionSummary> asSubscriber;
	private Map<String, PetasosPublisherSubscriptionSummary> asPublisher;
	private ComponentId componentID;
	private String participantName;

	//
	// Constructor(s)
	//

	public PetasosProcessingPlantSubscriptionSummary() {
		asPublisher = new HashMap<>();
		asSubscriber = new HashMap<>();
		componentID = new ComponentId();
		componentID.setId("unknown");
		componentID.setDisplayName("unknown");
		this.participantName = null;
	}

	//
	// Getters and Setters
	//

	public Map<ComponentId, PetasosSubscriberSubscriptionSummary> getAsSubscriber() {
		return asSubscriber;
	}

	public void setAsSubscriber(Map<ComponentId, PetasosSubscriberSubscriptionSummary> asSubscriber) {
		this.asSubscriber = asSubscriber;
	}

	public Map<String, PetasosPublisherSubscriptionSummary> getAsPublisher() {
		return asPublisher;
	}

	public void setAsPublisher(Map<String, PetasosPublisherSubscriptionSummary> asPublisher) {
		this.asPublisher = asPublisher;
	}

	public ComponentId getComponentID() {
		return componentID;
	}

	public void setComponentID(ComponentId componentID) {
		this.componentID = componentID;
	}

	public String getParticipantName() {
		return participantName;
	}

	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}

	//
	// Helper Methods
	//

	public void addPublisherSummary(PetasosPublisherSubscriptionSummary publisherSubscriptionSummary) {
		if (asPublisher.containsKey(publisherSubscriptionSummary.getSubscriberParticipantName())) {
			asPublisher.remove(publisherSubscriptionSummary.getSubscriberComponentId());
		}
		asPublisher.put(publisherSubscriptionSummary.getSubscriberParticipantName(), publisherSubscriptionSummary);
	}

	public void addSubscriberSummary(PetasosSubscriberSubscriptionSummary subscriberSubscriptionSummary) {
		if (asSubscriber.containsKey(subscriberSubscriptionSummary.getPublisherComponentId())) {
			asSubscriber.remove(subscriberSubscriptionSummary.getPublisherComponentId());
		}
		asSubscriber.put(subscriberSubscriptionSummary.getPublisherComponentId(), subscriberSubscriptionSummary);
	}

	public boolean addSubscriptionForExistingSubscriber(ComponentId componentID,
                                                        DataParcelManifestSubscriptionMask topic) {
		if (asPublisher.containsKey(componentID)) {
			asPublisher.get(componentID).addTopic(topic);
			return (true);
		} else {
			return (false);
		}
	}

	//
	// To String
	//

	@Override
	public String toString() {
		return "PetasosProcessingPlantSubscriptionSummary{" + "asSubscriber=" + asSubscriber + ", asPublisher="
				+ asPublisher + ", componentID=" + componentID + ", participantName='" + participantName + '\'' + '}';
	}
}
