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
package net.fhirfactory.dricats.model.petasos.ipc.endpoints.valuesets;

public enum JGroupsChannelStatusEnum {
	JGROUPS_CHANNEL_REMOTE_STATUS_SAME("RemoteChannel.Same", "dricats.petasos.ipc.technologies.remote_status.same"), 
	JGROUPS_CHANNEL_REMOTE_STATUS_DETECTED("RemoteChannel.Detected", "dricats.petasos.ipc.technologies.remote_status.detected"),
	JGROUPS_CHANNEL_REMOTE_STATUS_REACHABLE("RemoteChannel.Reachable", "dricats.petasos.ipc.technologies.remote_status.reachable"), 
	JGROUPS_CHANNEL_REMOTE_STATUS_UNREACHABLE("RemoteChannel.Unreachable", "dricats.petasos.ipc.technologies.remote_status.unreachable"),
	JGROUPS_CHANNEL_REMOTE_STATUS_SUSPECT("RemoteChannel.Suspect", "dricats.petasos.ipc.technologies.Remote_status.suspect"), 
	JGROUPS_CHANNEL_LOCAL_STATUS_STARTED("LocalChannel.Started", "dricats.petasos.ipc.technologies.local_status.started"), 
	JGROUPS_CHANNEL_LOCAL_STATUS_OPERATIONAL("LocalChannel.Operational", "dricats.petasos.ipc.technologies.local_status.operational"),
	JGROUPS_CHANNEL_LOCAL_STATUS_UNKNOWN("LocalChannel.Unknown", "dricats.petasos.ipc.technologies.local_status.unknown"),
	JGROUPS_CHANNEL_LOCAL_STATUS_FAILED("Localchannel.Failed", "dricats.petasos.ipc.technologies.local_status.failed");

	private String token;
	private String displayName;

	private JGroupsChannelStatusEnum(String displayName, String token) {
		this.displayName = displayName;
		this.token = token;
	}

	public String getToken() {
		return token;
	}
}
