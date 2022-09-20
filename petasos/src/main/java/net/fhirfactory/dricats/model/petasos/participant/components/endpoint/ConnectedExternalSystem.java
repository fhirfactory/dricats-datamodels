package net.fhirfactory.dricats.model.petasos.participant.components.endpoint;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fhirfactory.dricats.model.petasos.participant.components.adapter.AdapterBase;

public class ConnectedExternalSystem implements Serializable {
	private static final Logger LOG = LoggerFactory.getLogger(ConnectedExternalSystem.class);

	private String owningOrganizationName;
	private String solutionName;
	private String subsystemName;
	private String subsystemVersion;
	private String externalisedServiceName;
	private String externalisedServiceEndpointName;
	private List<AdapterBase> targetPorts;

	public ConnectedExternalSystem() {
		this.targetPorts = new ArrayList<>();
	}

	public String getOwningOrganizationName() {
		return owningOrganizationName;
	}

	public void setOwningOrganizationName(String owningOrganizationName) {
		this.owningOrganizationName = owningOrganizationName;
	}

	public String getSolutionName() {
		return solutionName;
	}

	public void setSolutionName(String solutionName) {
		this.solutionName = solutionName;
	}

	public String getSubsystemName() {
		return subsystemName;
	}

	public void setSubsystemName(String subsystemName) {
		this.subsystemName = subsystemName;
	}

	public String getSubsystemVersion() {
		return subsystemVersion;
	}

	public void setSubsystemVersion(String subsystemVersion) {
		this.subsystemVersion = subsystemVersion;
	}

	public String getExternalisedServiceName() {
		return externalisedServiceName;
	}

	public void setExternalisedServiceName(String externalisedServiceName) {
		this.externalisedServiceName = externalisedServiceName;
	}

	public String getExternalisedServiceEndpointName() {
		return externalisedServiceEndpointName;
	}

	public void setExternalisedServiceEndpointName(String externalisedServiceEndpointName) {
		this.externalisedServiceEndpointName = externalisedServiceEndpointName;
	}

	public List<AdapterBase> getTargetPorts() {
		return targetPorts;
	}

	public void setTargetPorts(List<AdapterBase> targetPorts) {
		this.targetPorts.clear();
		this.targetPorts.addAll(targetPorts);
	}

	@Override
	public String toString() {
		return "ConnectedExternalSystemTopologyNode{" + "owningOrganizationName=" + owningOrganizationName
				+ ", solutionName=" + solutionName + ", subsystemName=" + subsystemName + ", subsystemVersion="
				+ subsystemVersion + ", externalisedServiceName=" + externalisedServiceName
				+ ", externalisedServiceEndpointName=" + externalisedServiceEndpointName + ", targetPorts="
				+ targetPorts + '}';
	}
}
