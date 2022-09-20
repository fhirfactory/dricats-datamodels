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
package net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.fhirfactory.dricats.model.component.datatypes.ComponentTypeDefinition;
import net.fhirfactory.dricats.model.component.valuesets.ComponentTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.base.SoftwareComponentTopologyNodeBase;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workshops.base.WorkshopTopologyNodeBase;

public abstract class WorkUnitProcessorTopologyNode extends SoftwareComponentTopologyNodeBase {
    private static final Logger LOG = LoggerFactory.getLogger(WorkUnitProcessorTopologyNode.class);

    //
    // Constructor(s)
    //

    public WorkUnitProcessorTopologyNode(){
        super();
        ComponentTypeDefinition componentType = new ComponentTypeDefinition();
        componentType.setComponentArchetype(ComponentTypeEnum.WUP);
        componentType.setTypeName("WorkUnitProcessor");
        componentType.setDisplayTypeName("WorkUnitProcessor");
        setNodeType(componentType);
    }

    //
    // Getters and Setters
    //

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
        sb.append("WorkUnitProcessorTopologyNode{");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }
    
    //
    // Helper Methods
    //
    
    public void loadConfigurationFromParent(WorkshopTopologyNodeBase workshopNode){
        if(workshopNode.hasInstructureNode()){
            setInfrastructureNode(workshopNode.getInfrastructureNode());
        }
        if(workshopNode.hasPlatformNode()){
            setPlatformNode(workshopNode.getPlatformNode());
        }
        setResilienceMode(workshopNode.getResilienceMode());
        setConcurrencyMode(workshopNode.getConcurrencyMode());
        setEnabled(workshopNode.isEnabled());
        setNetworkContext(workshopNode.getNetworkContext());
        setReplicationCount(workshopNode.getReplicationCount());
        if(workshopNode.hasSystemNode()){
            setSystemNode(workshopNode.getSystemNode());
        }
        if(workshopNode.hasSiteNode()){
            setSiteNode(workshopNode.getSiteNode());
        }
        if(workshopNode.hasSubsystemParticipantName()){
            setSubsystemParticipantName(workshopNode.getSubsystemParticipantName());
        }
    }

}
