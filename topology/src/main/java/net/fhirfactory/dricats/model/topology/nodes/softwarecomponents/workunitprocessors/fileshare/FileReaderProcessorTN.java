/*
 * The MIT License
 *
 * Copyright 2022 Mark A. Hunter (ACT Health).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.fileshare;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.fhirfactory.dricats.model.component.datatypes.ComponentTypeDefinition;
import net.fhirfactory.dricats.model.component.valuesets.ComponentTypeEnum;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workshops.ExternalIPCWorkshopTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.base.PetasosEnabledExternalIPCIngresWUPTopologyNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mhunter
 */
public class FileReaderProcessorTN extends PetasosEnabledExternalIPCIngresWUPTopologyNode{
    private static final Logger LOG = LoggerFactory.getLogger(FileReaderProcessorTN.class);
    
    
    //
    // Constructor(s)
    //
    
    public FileReaderProcessorTN(){
        super();
    }
    
    public FileReaderProcessorTN(ExternalIPCWorkshopTN workshop, String participantName, String participantDisplayName, String configurationName){
        super();
        setParticipantName(participantName);
        setParticipantDisplayName(participantDisplayName);
        ComponentTypeDefinition componentType = new ComponentTypeDefinition();
        componentType.setComponentArchetype(ComponentTypeEnum.WUP);
        componentType.setDisplayTypeName("File Reader Processor");
        componentType.setTypeName("FileReaderProcessor");
        loadConfigurationFromParent(workshop);
    }
    
    //
    // Overriden Methods
    //
    
    @JsonIgnore
    @Override
    protected Logger getLogger() {
        return (LOG);
    }
    
    //
    // Getters and Setters
    //
    
    //
    // toString
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FileReaderProcessorTN{");
        sb.append(super.toString()).append('}');
        return sb.toString();
    }
    
    
}
