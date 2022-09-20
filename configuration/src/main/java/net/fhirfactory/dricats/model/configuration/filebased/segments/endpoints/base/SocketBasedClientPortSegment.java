/*
 * Copyright (c) 2021 Mark A. Hunter (ACT Health)
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
package net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.base;


import java.util.ArrayList;

public abstract class SocketBasedClientPortSegment extends StandardClientPortSegment{

    private Integer targetPort;
    private String targetHostname;
    private ArrayList<InterfaceDefinitionSegment> supportedInterfaceProfiles;

    //
    // Constructor(s)
    //

    public SocketBasedClientPortSegment(){
        super();
        this.supportedInterfaceProfiles = new ArrayList<>();
        this.targetPort = null;
        this.targetHostname = null;
    }

    //
    // Getters and Setters
    //
    
    public Integer getTargetPort() {
        return targetPort;
    }

    public void setTargetPort(Integer targetPort) {
        this.targetPort = targetPort;
    }

    public ArrayList<InterfaceDefinitionSegment> getSupportedInterfaceProfiles() {
        return supportedInterfaceProfiles;
    }

    public void setSupportedInterfaceProfiles(ArrayList<InterfaceDefinitionSegment> supportedInterfaceProfiles) {
        this.supportedInterfaceProfiles = supportedInterfaceProfiles;
    }

    public String getTargetHostname() {
        return targetHostname;
    }

    public void setTargetHostname(String targetHostname) {
        this.targetHostname = targetHostname;
    }

    //
    // To String
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SocketBasedClientPortSegment{");
        sb.append("targetPort=").append(targetPort);
        sb.append(", targetHostname=").append(targetHostname);
        sb.append(", supportedInterfaceProfiles=").append(supportedInterfaceProfiles);
        sb.append(", ").append(super.toString()).append('}');
        return sb.toString();
    }


}
