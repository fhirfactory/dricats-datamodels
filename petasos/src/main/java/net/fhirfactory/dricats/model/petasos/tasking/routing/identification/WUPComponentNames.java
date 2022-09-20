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

package net.fhirfactory.dricats.model.petasos.tasking.routing.identification;

import net.fhirfactory.dricats.configuration.defaults.petasos.PetasosPropertyConstants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @author Mark A. Hunter
 * @since 2020-06-01
 */
public class WUPComponentNames {
    private static final Logger LOG = LoggerFactory.getLogger(WUPComponentNames.class);

    private String componentAddressKey;
    private String participantName;
    private boolean mustBeDirect;
    private String participantVersion;
    private String sedaParameters;
    private static final String INTRA_FUNCTION_DIRECT_TYPE = "direct:";
    private static final String DIRECT_INTER_FUNCTION_DIRECT_TYPE = "direct:";
    private static final String SEDA_INTER_FUNCTION_DIRECT_TYPE = "seda://";
    
    //
    // Constructor(s)
    //

    public WUPComponentNames(String participantName, String participantVersion, boolean mustBeDirect, String sedaParameters){
        getLogger().debug(".RouteElementNames(): Entry, participantName->{}, mustBeDirect->{}", participantName, mustBeDirect);
        this.participantName = participantName;
        this.participantVersion = participantVersion;
        buildComponentAddressKey();
        this.mustBeDirect = mustBeDirect;
        this.sedaParameters = sedaParameters;
    }

    public WUPComponentNames(String participantName, String participantVersion){
        getLogger().debug(".RouteElementNames(): Entry, participantName->{}", participantName);
        this.participantName = participantName;
        this.participantVersion = participantVersion;
        buildComponentAddressKey();
        this.mustBeDirect = false;
        this.sedaParameters = null;
    }

    private void buildComponentAddressKey(){
        if(StringUtils.isEmpty(participantName) || StringUtils.isEmpty(participantVersion)){
            getLogger().error(".buildComponentAddressKey(): Unable to resolve Participant address");
        }
        String versionSimplified = participantVersion.replace(".", "").replace("-", "");
        this.componentAddressKey = participantName + "." + versionSimplified;
    }
    
    //
    // Getters (and Setters)
    //
    
    protected Logger getLogger(){
        return(LOG);
    }

    //
    // Business Methods
    //

    public String getEndPointWUPContainerIngresProcessorIngres() {
        getLogger().debug(".getEndPointWUPContainerIngresProcessorIngres(): Entry");
        String endpointName;
        if(this.mustBeDirect){
            endpointName = DIRECT_INTER_FUNCTION_DIRECT_TYPE + participantName + ".WUPContainer.IngresProcessor.Ingres";
        } else {
            if(StringUtils.isEmpty(this.sedaParameters)) {
                endpointName = SEDA_INTER_FUNCTION_DIRECT_TYPE + participantName + ".WUPContainer.IngresProcessor.Ingres";
            } else {
                endpointName = SEDA_INTER_FUNCTION_DIRECT_TYPE + participantName + ".WUPContainer.IngresProcessor.Ingres" + sedaParameters;
            }
        }
        return(endpointName);
    }

    public String getEndPointWUPContainerIngresProcessorEgress() {
        getLogger().debug(".getEndPointWUPContainerIngresProcessorEgress(): Entry");
        String endpointName = INTRA_FUNCTION_DIRECT_TYPE + participantName + ".WUPContainer.IngresProcessor.Egress";
        return(endpointName);
    }

    public String getEndPointWUPContainerIngresGatekeeperIngres() {
        getLogger().debug(".getEndPointWUPContainerIngresGatekeeperIngres(): Entry");
        String endpointName = INTRA_FUNCTION_DIRECT_TYPE + participantName + ".WUPContainer.IngresGatekeeper.Ingres";
        return(endpointName);
    }

    public String getEndPointWUPIngresConduitIngres() {
        getLogger().debug(".getEndPointWUPIngresConduitIngres(): Entry");
        String endpointName = INTRA_FUNCTION_DIRECT_TYPE + participantName + ".WUP.IngresConduit.Ingres";
        return(endpointName);
    }

    public String getEndPointWUPIngres() {
        getLogger().debug(".getEndPointWUPIngres(): Entry");
        String endpointName = INTRA_FUNCTION_DIRECT_TYPE + participantName + ".WUP.Ingres";
        return(endpointName);
    }

    public String getEndPointWUPEgress() {
        getLogger().debug(".getEndPointWUPEgress(): Entry");
        String endpointName = INTRA_FUNCTION_DIRECT_TYPE + participantName + ".WUP.Egress";
        return(endpointName);
    }

    public String getEndPointWUPEgressConduitEgress() {
        getLogger().debug(".getEndPointWUPEgressConduitEgress(): Entry");
        String endpointName = INTRA_FUNCTION_DIRECT_TYPE + participantName + ".WUP.EgressConduit.Egress";
        return(endpointName);
    }

    public String getEndPointWUPContainerInterceptionRedirectPointIngres() {
        getLogger().debug(".getEndPointWUPContainerInterceptionRedirectPointIngres(): Entry");
        String endpointName = INTRA_FUNCTION_DIRECT_TYPE + participantName + ".WUPContainer.InterceptionRedirectPoint.Ingres";
        return(endpointName);
    }

    public String getEndPointWUPContainerEgressMetadataProcessorIngres() {
        getLogger().debug(".getEndPointWUPContainerEgressMetadataProcessorIngres(): Entry");
        String endpointName = INTRA_FUNCTION_DIRECT_TYPE + participantName + ".WUPContainer.MetadataProcessor.Ingres";
        return(endpointName);
    }

    public String getEndPointWUPContainerInterceptionReturnPointIngres() {
        getLogger().debug(".getEndPointWUPContainerInterceptionReturnPointIngres(): Entry");
        String endpointName = INTRA_FUNCTION_DIRECT_TYPE + participantName + ".WUPContainer.InterceptionReturnPoint.Ingres";
        return(endpointName);
    }

    public String getEndPointWUPContainerEgressProcessorIngres() {
        getLogger().debug(".getEndPointWUPContainerEgressProcessorIngres(): Entry");
        String endpointName = INTRA_FUNCTION_DIRECT_TYPE + participantName + ".WUPContainer.EgressProcessor.Ingres";
        return(endpointName);
    }

    public String getEndPointWUPContainerEgressProcessorEgress() {
        getLogger().debug(".getEndPointWUPContainerEgressProcessorEgress(): Entry");
        String endpointName = INTRA_FUNCTION_DIRECT_TYPE + participantName + ".WUPContainer.EgressProcessor.Egress";
        return(endpointName);
    }

    public String getEndpointTaskOutcomeCollection() {
        getLogger().debug(".getEndPointInterchangePayloadTransformerIngres(): Entry");
        String endpointName = PetasosPropertyConstants.TASK_OUTCOME_COLLECTION_QUEUE;
        return(endpointName);
    }

    public String getEndpointNewTaskCreationCompletion() {
        getLogger().debug(".getEndPointInterchangePayloadTransformerEgress(): Entry");
        String endpointName = PetasosPropertyConstants.TASK_DISTRIBUTION_QUEUE;
        return(endpointName);
    }

    public String getEndPointTaskDistributionQueueIngres() {
        getLogger().debug(".getEndPointInterchangeRouterIngres(): Entry");
        String endpointName = PetasosPropertyConstants.TASK_DISTRIBUTION_QUEUE;
        return(endpointName);
    }

    public String getEndPointInterchangeRouterEgress() {
        getLogger().debug(".getEndPointInterchangeRouterEgress(): Entry");
        String endpointName = INTRA_FUNCTION_DIRECT_TYPE + participantName + ".Interchange.Router.Egress";
        return(endpointName);
    }

    public String getRouteIngresProcessorEgress2IngresGatekeeperIngres() {
        getLogger().debug(".getRouteIngresProcessorEgress2IngresGatekeeperIngres(): Entry");
        String endpointName = "FROM-" + participantName + ".WUPC.IP.E-To-" + participantName +".WUPC.IG.I" ;
        return(endpointName);
    }

    public String getRouteIngresConduitIngres2WUPIngres() {
        getLogger().debug(".getRouteIngresConduitIngres2WUPIngres(): Entry");
        String endpointName = "FROM-" + participantName + ".WUP.IC.I-To-" + participantName +".WUP.I" ;
        return(endpointName);
    }

    public String getRouteWUPEgress2WUPEgressConduitEgress() {
        getLogger().debug(".getRouteWUPEgress2WUPEgressConduitEgress(): Entry");
        String endpointName = "FROM-" + participantName + ".WUP.E-To-" + participantName +".WUP.EC.E" ;
        return(endpointName);
    }

    public String getRouteWUPEgressConduitEgress2WUPEgressProcessorIngres() {
        getLogger().debug(".getRouteWUPEgressConduitEgress2WUPEgressProcessorIngres(): Entry");
        String endpointName = "FROM-" + participantName + ".WUP.EC.E-To-" + participantName +".WUPC.EP.I" ;
        return(endpointName);
    }

    public String getRouteWUPEgressProcessorEgress2WUPEgressGatekeeperIngres() {
        getLogger().debug(".getRouteWUPEgressProcessorEgress2WUPEgressGatekeeperIngres(): Entry");
        String endpointName = "FROM-" + participantName + ".WUP.EP.E-To-" + participantName +".WUPC.EG.I" ;
        return(endpointName);
    }

    public String getRouteInterchangePayloadTransformerEgress2InterchangePayloadRouterIngres() {
        getLogger().debug(".getRouteInterchangePayloadTransformerEgress2InterchangePayloadRouterIngres(): Entry");
        String endpointName = "FROM-" + participantName + ".IC.PT.E-To-" + participantName +".IC.R.I" ;
        return(endpointName);
    }

    public String getRouteWUPContainerIngressProcessor() {
        getLogger().debug(".getRouteWUPContainerIngressProcessor(): Entry");
        String endpointName = "FROM-" + participantName + ".WUPC.IP.I-To-" + participantName +".WUPC.IP.E" ;
        return(endpointName);
    }

    public String getRouteWUPContainerIngresGateway() {
        getLogger().debug(".getRouteWUPContainerIngresGateway(): Entry");
        String endpointName = "FROM-" + participantName + ".WUPC.IG.I-To-" + participantName +".WUPC.IG.E" ;
        return(endpointName);
    }

    public String getRouteWUPContainerEgressGateway() {
        getLogger().debug(".getRouteWUPContainerEgressGateway(): Entry");
        String endpointName = "FROM-" + participantName + ".WUPC.EG.I-To-" + participantName +".WUPC.EG.E" ;
        return(endpointName);
    }

    public String getRouteWUPContainerEgressProcessor() {
        getLogger().debug(".getRouteWUPContainerEgressProcessor(): Entry");
        String endpointName = "FROM-" + participantName + ".WUPC.EP.I-To-" + participantName +".WUPC.EP.E" ;
        return(endpointName);
    }

    public String getRouteTaskOutcomeCollectionAndProcessing(){
        getLogger().debug(".getRouteInterchangePayloadTransformer(): Entry");
        String endpointName = "FROM-" + participantName + ".IC.PT.I-To-" + participantName +".IC.PT.E" ;
        return(endpointName);
    }

    public String getRouteInterchangeRouter(){
        getLogger().debug(".getRouteInterchangeRouter(): Entry");
        String endpointName = "FROM-" + participantName + ".IC.R.I-To-" + participantName +".IC.R.E" ;
        return(endpointName);
    }
}
