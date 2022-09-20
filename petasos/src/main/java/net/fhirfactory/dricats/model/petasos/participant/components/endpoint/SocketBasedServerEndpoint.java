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
package net.fhirfactory.dricats.model.petasos.participant.components.endpoint;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.fhirfactory.dricats.model.petasos.participant.components.servicegateway.SocketBasedServiceGatewayBase;
import net.fhirfactory.dricats.model.petasos.participant.components.servicegateway.valuesets.ServiceGatewayTypeEnum;

public abstract class SocketBasedServerEndpoint extends PetasosEnabledEndpointBase {
	private static final Logger LOG = LoggerFactory.getLogger(SocketBasedServerEndpoint.class);

	private Map<ServiceGatewayTypeEnum, SocketBasedServiceGatewayBase> publishedServiceNodes;

	//
	// Constructor(s)
	//

	public SocketBasedServerEndpoint() {
		super();
		this.publishedServiceNodes = new HashMap<>();
	}

	public SocketBasedServerEndpoint(SocketBasedServerEndpoint ori) {
		super(ori);
		this.publishedServiceNodes = new HashMap<>();
		if (publishedServiceNodes != null) {
			Set<ServiceGatewayTypeEnum> keySet = ori.getPublishedServiceNodes().keySet();
			for (ServiceGatewayTypeEnum currentKey : keySet) {
				SocketBasedServiceGatewayBase currentServiceNode = SerializationUtils
						.clone(ori.getPublishedServiceNodes().get(currentKey));
				getPublishedServiceNodes().put(currentKey, currentServiceNode);
			}
		}
	}

	//
	// Getters and Setters
	//

	//
	// Exposed Socket Details

	public Map<ServiceGatewayTypeEnum, SocketBasedServiceGatewayBase> getPublishedServiceNodes() {
		return publishedServiceNodes;
	}

	public void setPublishedServiceNodes(
			Map<ServiceGatewayTypeEnum, SocketBasedServiceGatewayBase> publishedServiceNodes) {
		this.publishedServiceNodes = publishedServiceNodes;
	}

	@JsonIgnore
	public boolean hasAssignedDNSName() {
		if (getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_STANDALONE)) {
			SocketBasedServiceGatewayBase standaloneSocketServer = getPublishedServiceNodes()
					.get(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_STANDALONE);
			if (standaloneSocketServer.hasServiceHostIP()) {
				return (true);
			}
		}
		return (false);
	}

	@JsonIgnore
	public String getAssignedDNSName() {
		if (getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_STANDALONE)) {
			SocketBasedServiceGatewayBase standaloneSocketServer = getPublishedServiceNodes()
					.get(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_STANDALONE);
			return (standaloneSocketServer.getServiceDNSName());
		}
		return (null);
	}

	@JsonIgnore
	public void setAssignedDNSName(String assignedDNSName) {
		SocketBasedServiceGatewayBase serviceNode = null;
		if (!getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_STANDALONE)) {
			serviceNode = new SocketBasedServiceGatewayBase();
		} else {
			serviceNode = getPublishedServiceNodes().get(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_STANDALONE);
		}
		serviceNode.setServiceDNSName(assignedDNSName);
	}

	@JsonIgnore
	public boolean hasActualHostIP() {
		if (getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_STANDALONE)) {
			SocketBasedServiceGatewayBase standaloneSocketServer = getPublishedServiceNodes()
					.get(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_STANDALONE);
			if (standaloneSocketServer.hasServiceHostIP()) {
				return (true);
			}
		}
		return (false);
	}

	@JsonIgnore
	public String getActualHostIP() {
		if (getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_STANDALONE)) {
			SocketBasedServiceGatewayBase standaloneSocketServer = getPublishedServiceNodes()
					.get(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_STANDALONE);
			return (standaloneSocketServer.getServiceHostIP());
		}
		return (null);
	}

	@JsonIgnore
	public void setActualHostIP(String actualHostIP) {
		SocketBasedServiceGatewayBase serviceNode = null;
		if (!getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_STANDALONE)) {
			serviceNode = new SocketBasedServiceGatewayBase();
		} else {
			serviceNode = getPublishedServiceNodes().get(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_STANDALONE);
		}
		serviceNode.setServiceHostIP(actualHostIP);
	}

	@JsonIgnore
	public boolean hasPort() {
		if (getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_STANDALONE)) {
			SocketBasedServiceGatewayBase standaloneSocketServer = getPublishedServiceNodes()
					.get(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_STANDALONE);
			if (standaloneSocketServer.hasServicePort()) {
				return (true);
			}
		}
		return (false);
	}

	@JsonIgnore
	public Integer getPort() {
		if (getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_STANDALONE)) {
			SocketBasedServiceGatewayBase standaloneSocketServer = getPublishedServiceNodes()
					.get(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_STANDALONE);
			int portValue = Integer.parseInt(standaloneSocketServer.getServicePort());
			return (portValue);
		}
		return (null);
	}

	@JsonIgnore
	public void setPort(Integer portValue) {
		SocketBasedServiceGatewayBase serviceNode = null;
		if (!getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_STANDALONE)) {
			serviceNode = new SocketBasedServiceGatewayBase();
		} else {
			serviceNode = getPublishedServiceNodes().get(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_STANDALONE);
		}
		serviceNode.setServicePort(Integer.toString(portValue));
	}

	//
	// Kubernetes Service Port

	@JsonIgnore
	public boolean hasServicePortValue() {
		if (getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_CLUSTERED)) {
			SocketBasedServiceGatewayBase standaloneSocketServer = getPublishedServiceNodes()
					.get(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_CLUSTERED);
			if (standaloneSocketServer.hasServicePort()) {
				return (true);
			}
		}
		return (false);
	}

	@JsonIgnore
	public Integer getServicePortValue() {
		if (getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_CLUSTERED)) {
			SocketBasedServiceGatewayBase standaloneSocketServer = getPublishedServiceNodes()
					.get(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_CLUSTERED);
			int portValue = Integer.parseInt(standaloneSocketServer.getServicePort());
			return (portValue);
		}
		return (null);
	}

	@JsonIgnore
	public void setServicePortValue(Integer servicePortValue) {
		SocketBasedServiceGatewayBase serviceNode = null;
		if (!getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_CLUSTERED)) {
			serviceNode = new SocketBasedServiceGatewayBase();
		} else {
			serviceNode = getPublishedServiceNodes().get(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_CLUSTERED);
		}
		serviceNode.setServicePort(Integer.toString(servicePortValue));
	}

	@JsonIgnore
	public boolean hasServiceDNSName() {
		if (getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_CLUSTERED)) {
			SocketBasedServiceGatewayBase standaloneSocketServer = getPublishedServiceNodes()
					.get(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_CLUSTERED);
			if (standaloneSocketServer.hasServiceDNSName()) {
				return (true);
			}
		}
		return (false);
	}

	@JsonIgnore
	public String getServiceDNSName() {
		if (getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_CLUSTERED)) {
			SocketBasedServiceGatewayBase standaloneSocketServer = getPublishedServiceNodes()
					.get(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_CLUSTERED);
			return (standaloneSocketServer.getServiceDNSName());
		}
		return (null);
	}

	@JsonIgnore
	public void setServiceDNSName(String servicePortName) {
		SocketBasedServiceGatewayBase serviceNode = null;
		if (!getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_CLUSTERED)) {
			serviceNode = new SocketBasedServiceGatewayBase();
		} else {
			serviceNode = getPublishedServiceNodes().get(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_CLUSTERED);
		}
		serviceNode.setServiceDNSName(servicePortName);
	}

	@JsonIgnore
	public boolean hasServiceActualIP() {
		if (getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_CLUSTERED)) {
			SocketBasedServiceGatewayBase standaloneSocketServer = getPublishedServiceNodes()
					.get(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_CLUSTERED);
			if (standaloneSocketServer.hasServiceHostIP()) {
				return (true);
			}
		}
		return (false);
	}

	@JsonIgnore
	public String getServiceActualIP() {
		if (getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_CLUSTERED)) {
			SocketBasedServiceGatewayBase standaloneSocketServer = getPublishedServiceNodes()
					.get(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_CLUSTERED);
			return (standaloneSocketServer.getServiceHostIP());
		}
		return (null);
	}

	@JsonIgnore
	public void setServiceActualIP(String serivceIP) {
		SocketBasedServiceGatewayBase serviceNode = null;
		if (!getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_CLUSTERED)) {
			serviceNode = new SocketBasedServiceGatewayBase();
		} else {
			serviceNode = getPublishedServiceNodes().get(ServiceGatewayTypeEnum.SERVICE_TYPE_SINGLE_SITE_CLUSTERED);
		}
		serviceNode.setServiceHostIP(serivceIP);
	}

	//
	// Multi-Site/Multi-Cluster Load-Balancer Service Port

	@JsonIgnore
	public boolean hasMultiSiteLoadBalancerPortValue() {
		if (getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_MULTI_SITE_LOAD_BALANCED)) {
			SocketBasedServiceGatewayBase standaloneSocketServer = getPublishedServiceNodes()
					.get(ServiceGatewayTypeEnum.SERVICE_TYPE_MULTI_SITE_LOAD_BALANCED);
			if (standaloneSocketServer.hasServicePort()) {
				return (true);
			}
		}
		return (false);
	}

	@JsonIgnore
	public Integer getMultiSiteLoadBalancerPortValue() {
		if (getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_MULTI_SITE_LOAD_BALANCED)) {
			SocketBasedServiceGatewayBase standaloneSocketServer = getPublishedServiceNodes()
					.get(ServiceGatewayTypeEnum.SERVICE_TYPE_MULTI_SITE_LOAD_BALANCED);
			int portValue = Integer.parseInt(standaloneSocketServer.getServicePort());
			return (portValue);
		}
		return (null);
	}

	@JsonIgnore
	public void setMultiSiteLoadBalancerPortValue(Integer servicePortValue) {
		SocketBasedServiceGatewayBase serviceNode = null;
		if (!getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_MULTI_SITE_LOAD_BALANCED)) {
			serviceNode = new SocketBasedServiceGatewayBase();
		} else {
			serviceNode = getPublishedServiceNodes().get(ServiceGatewayTypeEnum.SERVICE_TYPE_MULTI_SITE_LOAD_BALANCED);
		}
		serviceNode.setServicePort(Integer.toString(servicePortValue));
	}

	@JsonIgnore
	public boolean hasMultiSiteLoadBalancerDNSName() {
		if (getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_MULTI_SITE_LOAD_BALANCED)) {
			SocketBasedServiceGatewayBase standaloneSocketServer = getPublishedServiceNodes()
					.get(ServiceGatewayTypeEnum.SERVICE_TYPE_MULTI_SITE_LOAD_BALANCED);
			if (standaloneSocketServer.hasServiceDNSName()) {
				return (true);
			}
		}
		return (false);
	}

	@JsonIgnore
	public String getMultiSiteLoadBalancerDNSName() {
		if (getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_MULTI_SITE_LOAD_BALANCED)) {
			SocketBasedServiceGatewayBase standaloneSocketServer = getPublishedServiceNodes()
					.get(ServiceGatewayTypeEnum.SERVICE_TYPE_MULTI_SITE_LOAD_BALANCED);
			return (standaloneSocketServer.getServiceDNSName());
		}
		return (null);
	}

	@JsonIgnore
	public void setMultiSiteLoadBalancerDNSName(String servicePortName) {
		SocketBasedServiceGatewayBase serviceNode = null;
		if (!getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_MULTI_SITE_LOAD_BALANCED)) {
			serviceNode = new SocketBasedServiceGatewayBase();
		} else {
			serviceNode = getPublishedServiceNodes().get(ServiceGatewayTypeEnum.SERVICE_TYPE_MULTI_SITE_LOAD_BALANCED);
		}
		serviceNode.setServiceDNSName(servicePortName);
	}

	@JsonIgnore
	public boolean hasMultiSiteLoadBalancerActualIP() {
		if (getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_MULTI_SITE_LOAD_BALANCED)) {
			SocketBasedServiceGatewayBase standaloneSocketServer = getPublishedServiceNodes()
					.get(ServiceGatewayTypeEnum.SERVICE_TYPE_MULTI_SITE_LOAD_BALANCED);
			if (standaloneSocketServer.hasServiceHostIP()) {
				return (true);
			}
		}
		return (false);
	}

	@JsonIgnore
	public String getMultiSiteLoadBalancerActualIP() {
		if (getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_MULTI_SITE_LOAD_BALANCED)) {
			SocketBasedServiceGatewayBase standaloneSocketServer = getPublishedServiceNodes()
					.get(ServiceGatewayTypeEnum.SERVICE_TYPE_MULTI_SITE_LOAD_BALANCED);
			return (standaloneSocketServer.getServiceHostIP());
		}
		return (null);
	}

	@JsonIgnore
	public void setMultiSiteLoadBalancerActualIP(String serivceIP) {
		SocketBasedServiceGatewayBase serviceNode = null;
		if (!getPublishedServiceNodes().containsKey(ServiceGatewayTypeEnum.SERVICE_TYPE_MULTI_SITE_LOAD_BALANCED)) {
			serviceNode = new SocketBasedServiceGatewayBase();
		} else {
			serviceNode = getPublishedServiceNodes().get(ServiceGatewayTypeEnum.SERVICE_TYPE_MULTI_SITE_LOAD_BALANCED);
		}
		serviceNode.setServiceHostIP(serivceIP);
	}

	@JsonIgnore
	@Override
	protected Logger getLogger() {
		return (LOG);
	}

	//
	// To String
	//

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SocketBasedServerTopologyEndpoint{");
		sb.append("publishedServiceNodes=").append(publishedServiceNodes);
		sb.append(", ").append(super.toString()).append('}');
		return sb.toString();
	}

}
