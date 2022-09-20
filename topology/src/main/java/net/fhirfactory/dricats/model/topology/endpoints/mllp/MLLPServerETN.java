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
package net.fhirfactory.dricats.model.topology.endpoints.mllp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.fhirfactory.dricats.model.topology.connector.ActiveIPCConnection;
import net.fhirfactory.dricats.model.topology.endpoints.mllp.adapters.MLLPServerAdapter;

import java.util.Set;
import net.fhirfactory.dricats.model.topology.endpoints.base.valuesets.EndpointTopologyNodeTypeEnum;
import net.fhirfactory.dricats.model.topology.endpoints.interact.StandardInteractSocketBasedServerETN;

public class MLLPServerETN extends StandardInteractSocketBasedServerETN implements ActiveIPCConnection {

    //
    // Constructor(s)
    //
    public MLLPServerETN(){
        super();
        setEndpointType(EndpointTopologyNodeTypeEnum.MLLP_SERVER);
//        setComponentSystemRole(SoftwareComponentConnectivityContextEnum.COMPONENT_ROLE_INTERACT_INGRES);
    }

    //
    // Getters and Setters
    //

    @JsonIgnore
    public MLLPServerAdapter getMLLPServerAdapter(){
        if(getAdapterList().isEmpty()){
            return(null);
        }
        MLLPServerAdapter mllpServer = (MLLPServerAdapter) getAdapterList().get(0);
        return(mllpServer);
    }

    @JsonIgnore
    public void setMLLPServerAdapter(MLLPServerAdapter mllpServer){
        if(mllpServer != null){
            getAdapterList().add(mllpServer);
        }
    }

    @JsonIgnore
    @Override
    public String getTargetSystemName() {
        return(getConnectedSystemName());
    }

    @JsonIgnore
    @Override
    public String getTargetConnectionDescription() {
        if(!getAdapterList().isEmpty()) {
            MLLPServerAdapter mllpServer = (MLLPServerAdapter) getAdapterList().get(0);
            String portDescription = "mllp://" + mllpServer.getHostName() + ":" + mllpServer.getPortNumber();
            return(portDescription);
        }
        return(null);
    }

    @JsonIgnore
    @Override
    public String getDetailedConnectionDescription() {
        if(!getAdapterList().isEmpty()) {
            MLLPServerAdapter mllpServer = (MLLPServerAdapter) getAdapterList().get(0);
            StringBuilder portDescription = new StringBuilder();
            portDescription.append("mllp://" + mllpServer.getHostName() + ":" + mllpServer.getPortNumber());
            if (mllpServer.getAdditionalParameters().isEmpty()) {
                return (portDescription.toString());
            }
            portDescription.append("?");
            Set<String> configurationParameterNames = mllpServer.getAdditionalParameters().keySet();
            int size = configurationParameterNames.size();
            int count = 0;
            for(String currentConfigParameterName: configurationParameterNames){
                String value = mllpServer.getAdditionalParameters().get(currentConfigParameterName);
                portDescription.append(currentConfigParameterName + "=" + value);
                if (count < (size-1)) {
                    portDescription.append("&");
                }
                count += 1;
            }
            return (portDescription.toString());
        }
        return(null);
    }

    //
    // toString
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MLLPServerEndpoint{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
