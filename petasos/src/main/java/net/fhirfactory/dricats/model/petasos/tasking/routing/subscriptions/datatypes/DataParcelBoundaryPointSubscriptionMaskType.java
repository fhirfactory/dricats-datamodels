/*
 * Copyright (c) 2022 Mark A. Hunter
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
package net.fhirfactory.dricats.model.petasos.tasking.routing.subscriptions.datatypes;

import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.fhirfactory.dricats.model.petasos.participant.datatypes.PetasosParticipantId;
import net.fhirfactory.dricats.model.petasos.tasking.definition.datatypes.dataparcel.DataParcelBoundaryPointType;
import net.fhirfactory.dricats.model.petasos.tasking.routing.subscriptions.datatypes.common.SubscriptionMaskBase;

public class DataParcelBoundaryPointSubscriptionMaskType extends SubscriptionMaskBase {
    private static final Logger LOG = LoggerFactory.getLogger(DataParcelBoundaryPointSubscriptionMaskType.class);

    private PetasosParticipantId boundaryPointProcessingPlantParticipantNameMask;
    private PetasosParticipantId boundaryPointWorkUnitProcessorParticipantNameMask;
    private PetasosParticipantId boundaryPointEndpointParticipantNameMask;
    private String boundaryPointInterfaceNameMask;

    private String boundaryPointExternalEndpointInterfaceNameMask;
    private String boundaryPointExternalSubsystemNameMask;
    private String boundaryPointExternalTypeMask;

    //
    // Constructor(s)
    //

    public DataParcelBoundaryPointSubscriptionMaskType(){
        super();
        this.boundaryPointEndpointParticipantNameMask = new PetasosParticipantId(DataParcelManifestSubscriptionMask.WILDCARD_CHARACTER);
        this.boundaryPointExternalTypeMask = DataParcelManifestSubscriptionMask.WILDCARD_CHARACTER;
        this.boundaryPointExternalSubsystemNameMask = DataParcelManifestSubscriptionMask.WILDCARD_CHARACTER;
        this.boundaryPointInterfaceNameMask = DataParcelManifestSubscriptionMask.WILDCARD_CHARACTER;
        this.boundaryPointExternalEndpointInterfaceNameMask = DataParcelManifestSubscriptionMask.WILDCARD_CHARACTER;
        this.boundaryPointProcessingPlantParticipantNameMask = new PetasosParticipantId(DataParcelManifestSubscriptionMask.WILDCARD_CHARACTER);
        this.boundaryPointWorkUnitProcessorParticipantNameMask = new PetasosParticipantId(DataParcelManifestSubscriptionMask.WILDCARD_CHARACTER);
    }

    public DataParcelBoundaryPointSubscriptionMaskType(DataParcelBoundaryPointType ori){
        super();
        this.boundaryPointEndpointParticipantNameMask = new PetasosParticipantId(DataParcelManifestSubscriptionMask.WILDCARD_CHARACTER);
        this.boundaryPointExternalTypeMask = DataParcelManifestSubscriptionMask.WILDCARD_CHARACTER;
        this.boundaryPointExternalSubsystemNameMask = DataParcelManifestSubscriptionMask.WILDCARD_CHARACTER;
        this.boundaryPointInterfaceNameMask = DataParcelManifestSubscriptionMask.WILDCARD_CHARACTER;
        this.boundaryPointExternalEndpointInterfaceNameMask = DataParcelManifestSubscriptionMask.WILDCARD_CHARACTER;
        this.boundaryPointProcessingPlantParticipantNameMask = new PetasosParticipantId(DataParcelManifestSubscriptionMask.WILDCARD_CHARACTER);
        this.boundaryPointWorkUnitProcessorParticipantNameMask = new PetasosParticipantId(DataParcelManifestSubscriptionMask.WILDCARD_CHARACTER);

        if(ori.hasBoundaryPointExternalSubsystemName()){
            setBoundaryPointExternalSubsystemNameMask(ori.getBoundaryPointExternalSubsystemName());
        }

        if(ori.hasBoundaryPointProcessingPlantParticipantName()){
            setBoundaryPointProcessingPlantParticipantNameMask(SerializationUtils.clone(ori.getBoundaryPointProcessingPlantParticipantName()));
        }

        if(ori.hasBoundaryPointExternalType()){
            setBoundaryPointExternalTypeMask(SerializationUtils.clone(ori.getBoundaryPointExternalType()));
        }

        if(ori.hasBoundaryPointInterfaceName()){
            setBoundaryPointInterfaceNameMask(SerializationUtils.clone(ori.getBoundaryPointInterfaceName()));
        }

        if(ori.hasBoundaryPointWorkUnitProcessorParticipantName()){
            setBoundaryPointWorkUnitProcessorParticipantNameMask(SerializationUtils.clone(ori.getBoundaryPointWorkUnitProcessorParticipantName()));
        }

        if(ori.hasBoundaryPointEndpointParticipantName()){
            setBoundaryPointEndpointParticipantNameMask(SerializationUtils.clone(ori.getBoundaryPointEndpointParticipantName()));
        }

        if(ori.hasBoundaryPointExternalEndpointInterfaceName()){
            setBoundaryPointExternalEndpointInterfaceNameMask(SerializationUtils.clone(ori.getBoundaryPointExternalEndpointInterfaceName()));
        }
    }

    public DataParcelBoundaryPointSubscriptionMaskType(DataParcelBoundaryPointSubscriptionMaskType ori){
        super(ori);
        this.boundaryPointEndpointParticipantNameMask = new PetasosParticipantId(DataParcelManifestSubscriptionMask.WILDCARD_CHARACTER);
        this.boundaryPointExternalTypeMask = DataParcelManifestSubscriptionMask.WILDCARD_CHARACTER;
        this.boundaryPointExternalSubsystemNameMask = DataParcelManifestSubscriptionMask.WILDCARD_CHARACTER;
        this.boundaryPointInterfaceNameMask = DataParcelManifestSubscriptionMask.WILDCARD_CHARACTER;
        this.boundaryPointExternalEndpointInterfaceNameMask = DataParcelManifestSubscriptionMask.WILDCARD_CHARACTER;
        this.boundaryPointProcessingPlantParticipantNameMask = new PetasosParticipantId(DataParcelManifestSubscriptionMask.WILDCARD_CHARACTER);
        this.boundaryPointWorkUnitProcessorParticipantNameMask = new PetasosParticipantId(DataParcelManifestSubscriptionMask.WILDCARD_CHARACTER);

        if(ori.hasBoundaryPointExternalSubsystemNameMask()){
            setBoundaryPointExternalSubsystemNameMask(ori.getBoundaryPointExternalSubsystemNameMask());
        }

        if(ori.hasBoundaryPointProcessingPlantParticipantNameMask()){
            setBoundaryPointProcessingPlantParticipantNameMask(SerializationUtils.clone(ori.getBoundaryPointProcessingPlantParticipantNameMask()));
        }

        if(ori.hasBoundaryPointExternalTypeMask()){
            setBoundaryPointExternalTypeMask(SerializationUtils.clone(ori.getBoundaryPointExternalTypeMask()));
        }

        if(ori.hasBoundaryPointInterfaceNameMask()){
            setBoundaryPointInterfaceNameMask(SerializationUtils.clone(ori.getBoundaryPointInterfaceNameMask()));
        }

        if(ori.hasBoundaryPointWorkUnitProcessorParticipantNameMask()){
            setBoundaryPointWorkUnitProcessorParticipantNameMask(SerializationUtils.clone(ori.getBoundaryPointWorkUnitProcessorParticipantNameMask()));
        }

        if(ori.hasBoundaryPointEndpointParticipantNameMask()){
            setBoundaryPointEndpointParticipantNameMask(SerializationUtils.clone(ori.getBoundaryPointEndpointParticipantNameMask()));
        }

        if(ori.hasBoundaryPointExternalEndpointInterfaceNameMask()){
            setBoundaryPointExternalEndpointInterfaceNameMask(SerializationUtils.clone(ori.getBoundaryPointExternalEndpointInterfaceNameMask()));
        }
    }

    //
    // ifExists (has)
    //

    @JsonIgnore
    public boolean hasBoundaryPointProcessingPlantParticipantNameMask(){
        boolean hasValue = this.boundaryPointProcessingPlantParticipantNameMask != null;
        return(hasValue);
    }

    @JsonIgnore
    public boolean hasBoundaryPointWorkUnitProcessorParticipantNameMask(){
        boolean hasValue = this.boundaryPointWorkUnitProcessorParticipantNameMask != null;
        return(hasValue);
    }

    @JsonIgnore
    public boolean hasBoundaryPointEndpointParticipantNameMask(){
        boolean hasValue = this.boundaryPointEndpointParticipantNameMask != null;
        return(hasValue);
    }

    @JsonIgnore
    public boolean hasBoundaryPointInterfaceNameMask(){
        boolean hasValue = this.boundaryPointInterfaceNameMask != null;
        return(hasValue);
    }

    @JsonIgnore
    public boolean hasBoundaryPointExternalEndpointInterfaceNameMask(){
        boolean hasValue = this.boundaryPointExternalEndpointInterfaceNameMask != null;
        return(hasValue);
    }

    @JsonIgnore
    public boolean hasBoundaryPointExternalSubsystemNameMask(){
        boolean hasValue = this.boundaryPointExternalSubsystemNameMask != null;
        return(hasValue);
    }

    @JsonIgnore
    public boolean hasBoundaryPointExternalTypeMask(){
        boolean hasValue = this.boundaryPointExternalTypeMask != null;
        return(hasValue);
    }

    //
    // Getters and Setters
    //

    public PetasosParticipantId getBoundaryPointProcessingPlantParticipantNameMask() {
        return boundaryPointProcessingPlantParticipantNameMask;
    }

    public void setBoundaryPointProcessingPlantParticipantNameMask(PetasosParticipantId boundaryPointProcessingPlantParticipantNameMask) {
        this.boundaryPointProcessingPlantParticipantNameMask = boundaryPointProcessingPlantParticipantNameMask;
    }

    public PetasosParticipantId getBoundaryPointWorkUnitProcessorParticipantNameMask() {
        return boundaryPointWorkUnitProcessorParticipantNameMask;
    }

    public void setBoundaryPointWorkUnitProcessorParticipantNameMask(PetasosParticipantId boundaryPointWorkUnitProcessorParticipantNameMask) {
        this.boundaryPointWorkUnitProcessorParticipantNameMask = boundaryPointWorkUnitProcessorParticipantNameMask;
    }

    public PetasosParticipantId getBoundaryPointEndpointParticipantNameMask() {
        return boundaryPointEndpointParticipantNameMask;
    }

    public void setBoundaryPointEndpointParticipantNameMask(PetasosParticipantId boundaryPointEndpointParticipantNameMask) {
        this.boundaryPointEndpointParticipantNameMask = boundaryPointEndpointParticipantNameMask;
    }

    public String getBoundaryPointInterfaceNameMask() {
        return boundaryPointInterfaceNameMask;
    }

    public void setBoundaryPointInterfaceNameMask(String boundaryPointInterfaceNameMask) {
        this.boundaryPointInterfaceNameMask = boundaryPointInterfaceNameMask;
    }

    public String getBoundaryPointExternalEndpointInterfaceNameMask() {
        return boundaryPointExternalEndpointInterfaceNameMask;
    }

    public void setBoundaryPointExternalEndpointInterfaceNameMask(String boundaryPointExternalEndpointInterfaceNameMask) {
        this.boundaryPointExternalEndpointInterfaceNameMask = boundaryPointExternalEndpointInterfaceNameMask;
    }

    public String getBoundaryPointExternalSubsystemNameMask() {
        return boundaryPointExternalSubsystemNameMask;
    }

    public void setBoundaryPointExternalSubsystemNameMask(String boundaryPointExternalSubsystemNameMask) {
        this.boundaryPointExternalSubsystemNameMask = boundaryPointExternalSubsystemNameMask;
    }

    public String getBoundaryPointExternalTypeMask() {
        return boundaryPointExternalTypeMask;
    }

    public void setBoundaryPointExternalTypeMask(String boundaryPointExternalTypeMask) {
        this.boundaryPointExternalTypeMask = boundaryPointExternalTypeMask;
    }

    //
    // Logger Getter

    @JsonIgnore
    @Override
    protected Logger getLogger(){
        return(LOG);
    }

    //
    // toString()
    //

    @Override
    public String toString() {
        return "DataParcelBoundaryPointType{" +
                "boundaryPointProcessingPlantParticipantName=" + boundaryPointProcessingPlantParticipantNameMask +
                ", boundaryPointWorkUnitProcessorParticipantName=" + boundaryPointWorkUnitProcessorParticipantNameMask +
                ", boundaryPointEndpointParticipantName=" + boundaryPointEndpointParticipantNameMask +
                ", boundaryPointInterfaceName='" + boundaryPointInterfaceNameMask + '\'' +
                ", boundaryPointExternalEndpointInterfaceName='" + boundaryPointExternalEndpointInterfaceNameMask + '\'' +
                ", boundaryPointExternalSubsystemName='" + boundaryPointExternalSubsystemNameMask + '\'' +
                ", boundaryPointExternalType='" + boundaryPointExternalTypeMask + '\'' +
                ", allowAll=" + getAllowAll()+
                '}';
    }

    //
    // Mask Test
    //

    public boolean applyMask(DataParcelBoundaryPointType boundaryPoint){
        getLogger().debug(".applyMask(): Entry, boundaryPoint->{}", boundaryPoint);

        if(hasAllowAll()){
            if(getAllowAll()){
                getLogger().debug(".applyMask(): Exit, allowAll is true, returning -true-");
                return(true);
            }
        }

        boolean processingPlantNamePasses = participantNamePasses(getBoundaryPointProcessingPlantParticipantNameMask(), boundaryPoint.getBoundaryPointProcessingPlantParticipantName());
        boolean workingUnitProcessorNamePasses = participantNamePasses(getBoundaryPointWorkUnitProcessorParticipantNameMask(), boundaryPoint.getBoundaryPointWorkUnitProcessorParticipantName());
        boolean EndpointNamePasses = participantNamePasses(getBoundaryPointEndpointParticipantNameMask(), boundaryPoint.getBoundaryPointEndpointParticipantName());
        boolean interfaceNamePasses = namePasses(getBoundaryPointInterfaceNameMask(), boundaryPoint.getBoundaryPointInterfaceName());
        boolean externalSubsystemNamePasses = namePasses(getBoundaryPointExternalSubsystemNameMask(), boundaryPoint.getBoundaryPointExternalSubsystemName());
        boolean externalInterfaceNamePasses = namePasses(getBoundaryPointExternalEndpointInterfaceNameMask(), boundaryPoint.getBoundaryPointExternalEndpointInterfaceName());
        boolean externalInterfaceTypePasses = namePasses(getBoundaryPointExternalTypeMask(), boundaryPoint.getBoundaryPointExternalType());

        boolean passesMask = processingPlantNamePasses
                && workingUnitProcessorNamePasses
                && EndpointNamePasses
                && interfaceNamePasses
                && externalSubsystemNamePasses
                && externalInterfaceNamePasses
                && externalInterfaceTypePasses;

        getLogger().debug(".applyMask(): Exit, passesMask->{}", passesMask);
        return(passesMask);
    }



}
