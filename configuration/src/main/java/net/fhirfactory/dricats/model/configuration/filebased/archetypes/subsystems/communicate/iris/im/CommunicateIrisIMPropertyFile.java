package net.fhirfactory.dricats.model.configuration.filebased.archetypes.subsystems.communicate.iris.im;

import net.fhirfactory.dricats.model.configuration.filebased.archetypes.subsystems.communicate.common.CommunicateSubsystemPropertyFile;
import net.fhirfactory.dricats.model.configuration.filebased.segments.SecurityCredentialSegment;
import net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.http.ClusteredHTTPServerPortSegment;
import net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.http.HTTPClientEndpointSegment;
import net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.http.HTTPServerEndpointSegment;

public class CommunicateIrisIMPropertyFile extends CommunicateSubsystemPropertyFile {

	private HTTPClientEndpointSegment interactMatrixClientServicesClient;
	private HTTPServerEndpointSegment interactMatrixApplicationServicesServer;
	private HTTPServerEndpointSegment interactPegacornVoIPServicesServer;
	private SecurityCredentialSegment wildflyUser;

	//
	// Constructor(s)
	//

	public CommunicateIrisIMPropertyFile() {
		super();
		this.wildflyUser = new SecurityCredentialSegment();
		this.interactMatrixClientServicesClient = new HTTPClientEndpointSegment();
		this.interactMatrixApplicationServicesServer = new HTTPServerEndpointSegment();
		this.interactPegacornVoIPServicesServer = new HTTPServerEndpointSegment();
	}

	//
	// Getters and Setters
	//

	public HTTPClientEndpointSegment getInteractMatrixClientServicesClient() {
		return interactMatrixClientServicesClient;
	}

	public void setInteractMatrixClientServicesClient(HTTPClientEndpointSegment interactMatrixClientServicesClient) {
		this.interactMatrixClientServicesClient = interactMatrixClientServicesClient;
	}

	public HTTPServerEndpointSegment getInteractMatrixApplicationServicesServer() {
		return interactMatrixApplicationServicesServer;
	}

	public void setInteractMatrixApplicationServicesServer(
			HTTPServerEndpointSegment interactMatrixApplicationServicesServer) {
		this.interactMatrixApplicationServicesServer = interactMatrixApplicationServicesServer;
	}

	public HTTPServerEndpointSegment getInteractPegacornVoIPServicesServer() {
		return interactPegacornVoIPServicesServer;
	}

	public void setInteractPegacornVoIPServicesServer(
			HTTPServerEndpointSegment interactPegacornVoIPServicesServer) {
		this.interactPegacornVoIPServicesServer = interactPegacornVoIPServicesServer;
	}

	public SecurityCredentialSegment getWildflyUser() {
		return wildflyUser;
	}

	public void setWildflyUser(SecurityCredentialSegment wildflyUser) {
		this.wildflyUser = wildflyUser;
	}

	//
	// To String
	//

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CommunicateIrisIMPropertyFile{");
        sb.append("interactMatrixClientServicesClient=").append(interactMatrixClientServicesClient);
        sb.append(", interactMatrixApplicationServicesServer=").append(interactMatrixApplicationServicesServer);
        sb.append(", interactPegacornVoIPServicesServer=").append(interactPegacornVoIPServicesServer);
        sb.append(", wildflyUser=").append(wildflyUser);
        sb.append(", ").append(super.toString()).append('}');
        return sb.toString();
    }


}
