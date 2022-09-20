package net.fhirfactory.dricats.model.configuration.filebased.archetypes.subsystems.mitaf.smsgateway;

import net.fhirfactory.dricats.model.configuration.filebased.archetypes.subsystems.mitaf.MITaFSubsystemPropertyFile;
import net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.base.SocketBasedServerPortSegment;
import net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.interact.InteractSocketBasedServerEndpointSegment;

public class MITaFSMSGatewayPropertyFile extends MITaFSubsystemPropertyFile {

    private InteractSocketBasedServerEndpointSegment smsGateway;

    private SocketBasedServerPortSegment edgeReceiveCommunication;

    public InteractSocketBasedServerEndpointSegment getSmsGateway() {
        return smsGateway;
    }

    public void setSmsGateway(InteractSocketBasedServerEndpointSegment smsGateway) {
        this.smsGateway = smsGateway;
    }

    public SocketBasedServerPortSegment getEdgeReceiveCommunication() {
        return edgeReceiveCommunication;
    }

    public void setEdgeReceiveCommunication(SocketBasedServerPortSegment edgeReceiveCommunication) {
        this.edgeReceiveCommunication = edgeReceiveCommunication;
    }
}
