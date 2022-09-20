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

import java.util.List;

import org.hl7.fhir.r4.model.ResourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fhirfactory.dricats.model.simplified.resources.simple.common.ExtremelySimplifiedResource;

public class InformationSystemComponentESR extends ExtremelySimplifiedResource {
	private static final Logger LOG = LoggerFactory.getLogger(InformationSystemComponentESR.class);

	private String site;
	private String enablingInfrastructureNode;
	private String enablingPlatformNode;
	private String status;
	private String parent;
	private List<String> subsystems;

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
		return (ResourceType.Device);
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getEnablingInfrastructureNode() {
		return enablingInfrastructureNode;
	}

	public void setEnablingInfrastructureNode(String enablingInfrastructureNode) {
		this.enablingInfrastructureNode = enablingInfrastructureNode;
	}

	public String getEnablingPlatformNode() {
		return enablingPlatformNode;
	}

	public void setEnablingPlatformNode(String enablingPlatformNode) {
		this.enablingPlatformNode = enablingPlatformNode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public List<String> getSubsystems() {
		return subsystems;
	}

	public void setSubsystems(List<String> subsystems) {
		this.subsystems = subsystems;
	}

	//
	// toString
	//

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("InformationSystemComponentESR{");
		sb.append("site='").append(site).append('\'');
		sb.append(", enablingInfrastructureNode='").append(enablingInfrastructureNode).append('\'');
		sb.append(", enablingPlatformNode='").append(enablingPlatformNode).append('\'');
		sb.append(", status=").append(status);
		sb.append(", parent='").append(parent).append('\'');
		sb.append(", subsystems=").append(subsystems);
		sb.append(", ").append(super.toString()).append('}');
		return sb.toString();
	}
}
