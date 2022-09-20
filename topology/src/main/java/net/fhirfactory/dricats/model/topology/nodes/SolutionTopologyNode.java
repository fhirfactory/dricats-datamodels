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
package net.fhirfactory.dricats.model.topology.nodes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.fhirfactory.dricats.model.topology.nodes.base.TopologyNode;
import net.fhirfactory.dricats.model.topology.nodes.physical.DeploymentSiteTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.subsystems.SubsystemTopologyNode;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.r4.model.Organization;

public class SolutionTopologyNode extends TopologyNode {
    private static final Logger LOG = LoggerFactory.getLogger(SolutionTopologyNode.class);

    private Organization systemOwner;
    private Map<String, DeploymentSiteTN> siteMap;
    private Map<String, SubsystemTopologyNode> subsystemMap;
    
    //
    // Constructor(s)
    //

    public SolutionTopologyNode(){
        super();
        this.systemOwner = null;
        this.siteMap = new ConcurrentHashMap<>();
        this.subsystemMap = new ConcurrentHashMap<>();
    }
    
    //
    // Getters and Setters
    //

    public Map<String, DeploymentSiteTN> getSiteMap() {
        return siteMap;
    }

    public void setSiteMap(Map<String, DeploymentSiteTN> siteMap) {
        if(siteMap != null){
            this.siteMap.clear();
            Set<String> siteNames = siteMap.keySet();
            for(String currentSiteName: siteNames){
                this.siteMap.put(currentSiteName, SerializationUtils.clone(siteMap.get(currentSiteName)));
            }
        }
    }
    
    @JsonIgnore
    public void addSite(DeploymentSiteTN site){
        if(site != null){
            String siteName = site.getParticipantName();
            if(StringUtils.isNotEmpty(siteName)){
                if(this.siteMap.containsKey(siteName)){
                    this.siteMap.remove(siteName);
                }
                this.siteMap.put(siteName, site);
            }
        }
    }

    public Organization getSystemOwner() {
        return systemOwner;
    }

    public void setSystemOwner(Organization systemOwner) {
        this.systemOwner = systemOwner;

    }

    public Map<String, SubsystemTopologyNode> getSubsystemMap() {
        return subsystemMap;
    }

    public void setSubsystemMap(Map<String, SubsystemTopologyNode> subsystemMap) {
        this.subsystemMap = subsystemMap;
    }
    
    //
    // Overriden Methods
    //
    
    @Override
    protected Logger getLogger() {
        return (LOG);
    }
    
    //
    // ToString
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SolutionTopologyNode{");
        sb.append(", systemOwner=").append(systemOwner);
        sb.append(", siteMap=").append(siteMap);
        sb.append(", subsystemMap=").append(subsystemMap);
        sb.append(", ").append(super.toString()).append("}");
        return sb.toString();
    }
    
    
}
