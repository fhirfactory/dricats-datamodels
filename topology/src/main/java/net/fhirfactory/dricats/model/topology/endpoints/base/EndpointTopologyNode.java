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
package net.fhirfactory.dricats.model.topology.endpoints.base;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EndpointTopologyNode extends TopologyNode {
    private static final Logger LOG = LoggerFactory.getLogger(EndpointTopologyNode.class);


    private String connectedSystemName;
    private boolean server;
    private List<IPCAdapter> adapterList;
    private String endpointConfigurationName;
    private EndpointTopologyNodeTypeEnum endpointType;
    private EndpointStatusEnum endpointStatus;
    
    //
    // Constructor(s)
    //

    public EndpointTopologyNode(){
        super();

        this.connectedSystemName = null;
        this.server = true;
        this.adapterList = new ArrayList<>();
        this.endpointConfigurationName = null;
        this.endpointType = EndpointTopologyNodeTypeEnum.OTHER_CLIENT;
        this.endpointStatus = EndpointStatusEnum.DRICATS_ENDPOINT_STATUS_UNKNOWN;
    }

    public EndpointTopologyNode(EndpointTopologyNode ori){
        super(ori);
        this.adapterList = new ArrayList<>();
        if(ori.hasConnectedSystemName()){
            setConnectedSystemName(ori.getConnectedSystemName());
        }
        if(ori.hasEndpointConfigurationName()){
            setEndpointConfigurationName(ori.getEndpointConfigurationName());
        }
        setServer(ori.isServer());
        if(!adapterList.isEmpty()){
            this.adapterList.addAll(ori.getAdapterList());
        }
        setEndpointStatus(ori.getEndpointStatus());
    }

    //
    // Getters and Setters
    //
    
    
   
    @JsonIgnore
    public boolean hasEndpointType(){
        boolean hasValue = this.endpointType != null;
        return(hasValue);
    }

    public EndpointTopologyNodeTypeEnum getEndpointType() {
        return endpointType;
    }

    public void setEndpointType(EndpointTopologyNodeTypeEnum endpointType) {
        this.endpointType = endpointType;
    }

    @JsonIgnore
    public boolean hasEndpointConfigurationName(){
        boolean hasValue = this.endpointConfigurationName != null;
        return(hasValue);
    }

    public String getEndpointConfigurationName() {
        return endpointConfigurationName;
    }

    public void setEndpointConfigurationName(String endpointConfigurationName) {
        this.endpointConfigurationName = endpointConfigurationName;
    }

    public boolean isServer() {
        return server;
    }

    public void setServer(boolean server) {
        this.server = server;
    }

    @JsonIgnore
    public boolean hasConnectedSystemName(){
        boolean hasValue = this.connectedSystemName != null;
        return(hasValue);
    }

    public String getConnectedSystemName() {
        return connectedSystemName;
    }

    public void setConnectedSystemName(String connectedSystemName) {
        this.connectedSystemName = connectedSystemName;
    }

    public List<IPCAdapter> getAdapterList() {
        return adapterList;
    }

    public void setAdapterList(List<IPCAdapter> adapterList) {
        this.adapterList = adapterList;
    }

    public EndpointStatusEnum getEndpointStatus() {
		return endpointStatus;
	}

	public void setEndpointStatus(EndpointStatusEnum endpointStatus) {
		this.endpointStatus = endpointStatus;
	}

	@JsonIgnore
    @Override
    protected Logger getLogger() {
        return (LOG);
    }

    //
    // to String
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IPCTopologyEndpoint{");
        sb.append("connectedSystemName=").append(connectedSystemName);
        sb.append(", server=").append(server);
        sb.append(", adapterList=").append(adapterList);
        sb.append(", endpointConfigurationName=").append(endpointConfigurationName);
        sb.append(", endpointType=").append(endpointType);
        sb.append(", endpointStatus=").append(endpointStatus);
        sb.append(", ").append(super.toString()).append("}");
        return sb.toString();
    }


}
