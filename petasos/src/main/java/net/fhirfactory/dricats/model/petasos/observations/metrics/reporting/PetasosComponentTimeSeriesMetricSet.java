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
package net.fhirfactory.dricats.model.petasos.observations.metrics.reporting;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import net.fhirfactory.dricats.model.component.datatypes.ComponentId;

import org.apache.commons.lang3.SerializationUtils;

import net.fhirfactory.dricats.model.internals.SerializableObject;

public class PetasosComponentTimeSeriesMetricSet implements Serializable {

	ComponentId componentId;
	List<PetasosComponentMetric> metricTimeSeries;
	SerializableObject metricTimeSeriesLock;

	//
	// Constructor(s)
	//

	public PetasosComponentTimeSeriesMetricSet() {
		this.metricTimeSeries = new ArrayList<>();
		this.componentId = null;
		this.metricTimeSeriesLock = new SerializableObject();
	}

	//
	// Business Method Helpers
	//

	public void addMetric(PetasosComponentMetric metric) {
		synchronized (this.metricTimeSeriesLock) {
			if (getComponentId() == null) {
				this.componentId = SerializationUtils.clone(metric.getMetricSource());
			}
			if (getComponentId().equals(metric.getMetricSource())) {
				getMetricTimeSeries().add(metric);
			}
		}
	}

	public void clearSet() {
		synchronized (this.metricTimeSeriesLock) {
			getMetricTimeSeries().clear();
		}
	}

	//
	// Getters and Setters
	//

	public ComponentId getComponentId() {
		return componentId;
	}

	public void setComponentId(ComponentId componentId) {
		this.componentId = componentId;
	}

	public List<PetasosComponentMetric> getMetricTimeSeries() {
		return metricTimeSeries;
	}

	public void setMetricTimeSeries(List<PetasosComponentMetric> metricTimeSeries) {
		this.metricTimeSeries = metricTimeSeries;
	}
}
