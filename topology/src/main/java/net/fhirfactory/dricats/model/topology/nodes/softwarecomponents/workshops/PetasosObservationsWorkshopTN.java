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
package net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workshops;

import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workshops.base.WorkshopTopologyNodeBase;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.observations.PetasosAbnormalEventsAgentTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.observations.PetasosConfigurationReportsAgentTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.observations.PetasosMetricsAgentTN;
import net.fhirfactory.dricats.model.topology.nodes.softwarecomponents.workunitprocessors.petasos.observations.PetasosNotificationsAgentTN;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mhunter
 */
public class PetasosObservationsWorkshopTN extends WorkshopTopologyNodeBase{
    private static final Logger LOG = LoggerFactory.getLogger(PetasosObservationsWorkshopTN.class);
    
    private PetasosNotificationsAgentTN notificationsService;
    private PetasosConfigurationReportsAgentTN configurationReportService;
    private PetasosMetricsAgentTN metricsService;
    private PetasosAbnormalEventsAgentTN abnormalEventsService;
    
    private static final String WORKSHOP_NAME = "Petasos.Tasking";
    
    //
    // Constructor(s)
    //
    
    public PetasosObservationsWorkshopTN(){
        super();
        this.notificationsService = null;
        this.configurationReportService = null;
        this.metricsService = null;
        this.abnormalEventsService = null;
    }
    
    public PetasosObservationsWorkshopTN(String processingPlantParticipantName, String processingPlantVersion){
        super();
        this.notificationsService = null;
        this.configurationReportService = null;
        this.metricsService = null;
        this.abnormalEventsService = null;
        this.setParticipantDisplayName(WORKSHOP_NAME);
        this.setParticipantName(processingPlantParticipantName + "." + WORKSHOP_NAME);
        this.setNodeVersion(processingPlantVersion);
    }
    
    
    //
    // Overriden Methods
    //
    
    @Override
    protected Logger getLogger(){
        return(LOG);
    }
    
    //
    // Getters and Setters
    //

    public PetasosNotificationsAgentTN getNotificationsService() {
        return notificationsService;
    }

    public void setNotificationsService(PetasosNotificationsAgentTN notificationsService) {
        this.notificationsService = notificationsService;
        addWorkUnitProcessor(notificationsService);
    }

    public PetasosConfigurationReportsAgentTN getConfigurationReportService() {
        return configurationReportService;
    }

    public void setConfigurationReportService(PetasosConfigurationReportsAgentTN configurationReportService) {
        this.configurationReportService = configurationReportService;
        addWorkUnitProcessor(configurationReportService);
    }

    public PetasosMetricsAgentTN getMetricsService() {
        return metricsService;
    }

    public void setMetricsService(PetasosMetricsAgentTN metricsService) {
        this.metricsService = metricsService;
        addWorkUnitProcessor(metricsService);
    }

    public PetasosAbnormalEventsAgentTN getAbnormalEventsService() {
        return abnormalEventsService;
    }

    public void setAbnormalEventsService(PetasosAbnormalEventsAgentTN abnormalEventsService) {
        this.abnormalEventsService = abnormalEventsService;
        addWorkUnitProcessor(abnormalEventsService);
    }
    
    //
    // toString
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PetasosObservationsWorkshopTopologyNode{");
        sb.append("notificationsService=").append(notificationsService);
        sb.append(", configurationReportService=").append(configurationReportService);
        sb.append(", metricsService=").append(metricsService);
        sb.append(", abnormalEventsService=").append(abnormalEventsService);
        sb.append(", ").append(super.toString()).append('}');
        return sb.toString();
    }


    



    
    
    
}
