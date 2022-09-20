/*
 * Copyright (c) 2022 Mark A. Hunter (ACT Health)
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
package net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.fileshare;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.base.StandardClientPortSegment;

public class FileShareEndpointSegment extends StandardClientPortSegment {

    private String fileShareName;
    private String fileShareProtocol;
    private String fileSharePath;
    private String fileSharePathAlias;
    private String fileShareServer;
    
    //
    // Constructor(s)
    //
    
    public FileShareEndpointSegment(){
        this.fileShareName = null;
        this.fileSharePath = null;
        this.fileSharePathAlias = null;
        this.fileShareProtocol = null;
        this.fileShareServer = null;
    }
    
    //
    // Getters and Setters
    // 

    @JsonIgnore
    public Boolean hasFileShareName(){
        boolean hasValue = this.fileShareName != null;
        return(hasValue);
    }
    
    public String getFileShareName() {
        return fileShareName;
    }

    public void setFileShareName(String fileShareName) {
        this.fileShareName = fileShareName;
    }
    
    @JsonIgnore
    public Boolean hasFileShareProtocol(){
        boolean hasValue = this.fileShareProtocol != null;
        return(hasValue);
    }

    public String getFileShareProtocol() {
        return fileShareProtocol;
    }

    public void setFileShareProtocol(String fileShareProtocol) {
        this.fileShareProtocol = fileShareProtocol;
    }
    
    @JsonIgnore
    public Boolean hasFileSharePath(){
        boolean hasValue = this.fileSharePath != null;
        return(hasValue);
    }

    public String getFileSharePath() {
        return fileSharePath;
    }

    public void setFileSharePath(String fileSharePath) {
        this.fileSharePath = fileSharePath;
    }
    
    @JsonIgnore
    public Boolean hasFileSharePathAlias(){
        boolean hasValue = this.fileSharePathAlias != null;
        return(hasValue);
    }

    public String getFileSharePathAlias() {
        return fileSharePathAlias;
    }

    public void setFileSharePathAlias(String fileSharePathAlias) {
        this.fileSharePathAlias = fileSharePathAlias;
    }
    
    @JsonIgnore
    public Boolean hasFileShareServer(){
        boolean hasValue = this.fileShareServer != null;
        return(hasValue);
    }

    public String getFileShareServer() {
        return fileShareServer;
    }

    public void setFileShareServer(String fileShareServer) {
        this.fileShareServer = fileShareServer;
    }
    
    //
    // toString()
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FileShareEndpointSegment{");
        sb.append("fileShareName=").append(fileShareName);
        sb.append(", fileShareProtocol=").append(fileShareProtocol);
        sb.append(", fileSharePath=").append(fileSharePath);
        sb.append(", fileSharePathAlias=").append(fileSharePathAlias);
        sb.append(", fileShareServer=").append(fileShareServer);
        sb.append(", ").append(super.toString()).append('}');
        return sb.toString();
    }
    
    
}
