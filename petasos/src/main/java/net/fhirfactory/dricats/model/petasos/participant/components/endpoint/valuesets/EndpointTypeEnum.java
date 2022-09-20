/*
 * Copyright (c) 2020 Mark A. Hunter
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
package net.fhirfactory.dricats.model.petasos.participant.components.endpoint.valuesets;

import org.apache.commons.lang3.StringUtils;

public enum EndpointTypeEnum {
	JGROUPS_INTEGRATION_POINT("JGroups.IntegrationPoint", "dricats.endpoint.type.jgroups.integration_point", "endpoint.ipc_messaging.jgroups_interzone_client"),
	PETASOS_MESSAGE_SENDER("Petasos.Messaging.Sender", "dricats.endpoint.type.petasos.message_sender", ""),
	PETASOS_MESSAGE_RECEIVER("Petasos.Messaging.Receiver", "dricats.endpoint.type.petasos.message_sender", ""),
	HTTP_API_SERVER("HTTP.Server", "dricats.endpoint.type.http_api_server", "endpoint.http.server"),
	HTTP_API_CLIENT("HTTP.Client", "dricats.endpoint.type.http_api_client", "endpoint.http.client"),
	MLLP_SERVER("MLLP.Server", "dricats.endpoint.type.mllp_server", "endpoint.mllp.server"),
	MLLP_CLIENT("MLLP.Client", "dricats.endpoint.type.mllp_client", "endpoint.mllp.client"),
	SQL_SERVER("SQL.Server", "dricats..endpoint.sql_server", "endpoint.sql.server"),
	SQL_CLIENT("SQL.Client", "dricats.endpoint.type.sql_client", "endpoint.sql.client"),
	LDAP_SERVER("LDAP.Server", "dricats.endpoint.type.ldap_server", "endpoint.ldap.server"),
	LDAP_CLIENT("LDAP.Client", "dricats.endpoint.type.ldap_client", "endpoint.ldap.client"),
	FILE_SHARE_SOURCE("FILE.Source", "dricats.endpoint.type.file_source", "endpoint.file.source"),
	FILE_SHARE_SINK("FILE.Sink", "dricats.endpoint.type.file_sink", "endpoint.file.sink"),
	OTHER_API_SERVER("API.Server", "dricats.endpoint.type.other_type_of_server", "endpoint.other_api.server"),
	OTHER_API_CLIENT("API.Client", "dricats.endpoint.type.other_type_of_client", "endpoint.other_api.client"),
	OTHER_SERVER("Other.Server", "dricats.endpoint.type.other_server", "endpoint.other.server"),
	OTHER_CLIENT("Other.Client", "dricats.endpoint.type.other_client", "endpoint.other.client"),
	DIRECT_CAMEL_ENDPOINT("Camel.Direct.Endpoint", "dricats.endpoint.type.camel.direct", "endpoint.camel.direct"),
	SEDA_CAMEL_ENDPOINT("Camel.Direct.SEDA", "dricats.endpoint.type.camel.seda", "endpoint.camel.seda");

	private String token;
	private String displayName;
	private String configTypeName;

	private EndpointTypeEnum(String displayName, String token, String configTypeName) {
		this.token = token;
		this.displayName = displayName;
		this.configTypeName = configTypeName;
	}

	public String getToken() {
		return (this.token);
	}

	public String getDisplayName() {
		return (this.displayName);
	}

	public String getConfigTypeName() {
		return (this.configTypeName);
	}

	public static EndpointTypeEnum fromConfigTypeName(String configName) {
		if (StringUtils.isEmpty(configName)) {
			return (null);
		}
		for (EndpointTypeEnum currentType : EndpointTypeEnum.values()) {
			if (currentType.getConfigTypeName().equalsIgnoreCase(configName)) {
				return (currentType);
			}
		}
		return (null);
	}
}
