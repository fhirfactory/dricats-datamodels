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
package net.fhirfactory.dricats.model.petasos.observations.metrics.component;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import net.fhirfactory.dricats.model.component.datatypes.ComponentId;

import net.fhirfactory.dricats.model.constants.DeploymentPropertyConstants;
import net.fhirfactory.dricats.model.petasos.observations.metrics.component.common.CommonComponentMetricsData;

public class ProcessingPlantMetricsData extends CommonComponentMetricsData {
	private Map<String, Integer> localCacheSize;
	private int synchronousAuditEventsWritten;
	private int asynchronousAuditEventsWritten;
	private int asynchronousAuditEventsQueued;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSXXX", timezone = DeploymentPropertyConstants.DEFAULT_TIMEZONE)
	private Instant lastAsynchronousAuditEventWrite;

	//
	// Constructor(s)
	//

	public ProcessingPlantMetricsData() {
		super();
		this.localCacheSize = new HashMap<>();
		this.synchronousAuditEventsWritten = 0;
		this.asynchronousAuditEventsWritten = 0;
		this.asynchronousAuditEventsQueued = 0;
		this.lastAsynchronousAuditEventWrite = null;
	}

	public ProcessingPlantMetricsData(ComponentId componentId) {
		super(componentId);
		this.localCacheSize = new HashMap<>();
		this.synchronousAuditEventsWritten = 0;
		this.asynchronousAuditEventsWritten = 0;
		this.asynchronousAuditEventsQueued = 0;
		this.lastAsynchronousAuditEventWrite = null;
	}

	//
	// Getters and Setters
	//

	public Map<String, Integer> getLocalCacheSize() {
		return localCacheSize;
	}

	public void setLocalCacheSize(Map<String, Integer> localCacheSize) {
		this.localCacheSize = localCacheSize;
	}

	public int getSynchronousAuditEventsWritten() {
		return synchronousAuditEventsWritten;
	}

	public void setSynchronousAuditEventsWritten(int synchronousAuditEventsWritten) {
		this.synchronousAuditEventsWritten = synchronousAuditEventsWritten;
	}

	public int getAsynchronousAuditEventsWritten() {
		return asynchronousAuditEventsWritten;
	}

	public void setAsynchronousAuditEventsWritten(int asynchronousAuditEventsWritten) {
		this.asynchronousAuditEventsWritten = asynchronousAuditEventsWritten;
	}

	public int getAsynchronousAuditEventsQueued() {
		return asynchronousAuditEventsQueued;
	}

	public void setAsynchronousAuditEventsQueued(int asynchronousAuditEventsQueued) {
		this.asynchronousAuditEventsQueued = asynchronousAuditEventsQueued;
	}

	public Instant getLastAsynchronousAuditEventWrite() {
		return lastAsynchronousAuditEventWrite;
	}

	public void setLastAsynchronousAuditEventWrite(Instant lastAsynchronousAuditEventWrite) {
		this.lastAsynchronousAuditEventWrite = lastAsynchronousAuditEventWrite;
	}

	//
	// To String
	//

	@Override
	public String toString() {
		return "ProcessingPlantMetricsData{" + "localCacheStatusMap=" + localCacheSize
				+ ", synchronousAuditEventsWritten=" + synchronousAuditEventsWritten
				+ ", asynchronousAuditEventsWritten=" + asynchronousAuditEventsWritten
				+ ", asynchronousAuditEventsQueued=" + asynchronousAuditEventsQueued
				+ ", lastAsynchronousAuditEventWrite=" + lastAsynchronousAuditEventWrite + ", ingresMessageCount="
				+ getIngresMessageCount() + ", egressMessageCount=" + getEgressMessageAttemptCount()
				+ ", distributedMessageCount=" + getInternalDistributedMessageCount() + ", distributionCountMap="
				+ getInternalDistributionCountMap() + ", componentID=" + getComponentID() + ", participantName="
				+ getParticipantName() + ", metricsType='" + getComponentType() + '\'' + ", lastActivityInstant="
				+ getLastActivityInstant() + ", componentStartupInstant=" + getComponentStartupInstant()
				+ ", componentStatus='" + getComponentStatus() + '\'' + '}';
	}
}
