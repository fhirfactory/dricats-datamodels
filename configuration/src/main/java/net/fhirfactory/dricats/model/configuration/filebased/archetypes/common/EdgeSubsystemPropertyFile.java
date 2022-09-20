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
package net.fhirfactory.dricats.model.configuration.filebased.archetypes.common;

import net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.fileshare.FileShareEndpointSet;
import net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.http.HTTPEndpointSet;
import net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.interact.OtherInteractEndpointSet;
import net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.mllp.MLLPEndpointSet;
import net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.tap.TAPEndpointSet;

public abstract class EdgeSubsystemPropertyFile extends WildflyBasedServerPropertyFile {

    private FileShareEndpointSet fileShareSet;
    private HTTPEndpointSet httpEndpointSet;
    private MLLPEndpointSet mllpEndpointSet;
    private TAPEndpointSet tapEndpointSet;
    private OtherInteractEndpointSet otherEndpointSet;

    //
    // Constructor(s)
    //

    public EdgeSubsystemPropertyFile() {
            super();
            this.fileShareSet = new FileShareEndpointSet();
            this.httpEndpointSet = new HTTPEndpointSet();
            this.mllpEndpointSet = new MLLPEndpointSet();
            this.tapEndpointSet = new TAPEndpointSet();
            this.otherEndpointSet = new OtherInteractEndpointSet();
    }

    //
    // Getters and Setters
    //

    public FileShareEndpointSet getFileShareSet() {
        return fileShareSet;
    }

    public void setFileShareSet(FileShareEndpointSet fileShareSet) {
        this.fileShareSet = fileShareSet;
    }

    public HTTPEndpointSet getHttpEndpointSet() {
        return httpEndpointSet;
    }

    public void setHttpEndpointSet(HTTPEndpointSet httpEndpointSet) {
        this.httpEndpointSet = httpEndpointSet;
    }

    public MLLPEndpointSet getMllpEndpointSet() {
        return mllpEndpointSet;
    }

    public void setMllpEndpointSet(MLLPEndpointSet mllpEndpointSet) {
        this.mllpEndpointSet = mllpEndpointSet;
    }

    public TAPEndpointSet getTapEndpointSet() {
        return tapEndpointSet;
    }

    public void setTapEndpointSet(TAPEndpointSet tapEndpointSet) {
        this.tapEndpointSet = tapEndpointSet;
    }

    public OtherInteractEndpointSet getOtherEndpointSet() {
        return otherEndpointSet;
    }

    public void setOtherEndpointSet(OtherInteractEndpointSet otherEndpointSet) {
        this.otherEndpointSet = otherEndpointSet;
    }

    //
    // toString()
    //

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EdgeSubsystemPropertyFile{");
        sb.append("fileShareSet=").append(fileShareSet);
        sb.append(", httpEndpointSet=").append(httpEndpointSet);
        sb.append(", mllpEndpointSet=").append(mllpEndpointSet);
        sb.append(", tapEndpointSet=").append(tapEndpointSet);
        sb.append(", otherEndpointSet=").append(otherEndpointSet);
        sb.append('}');
        return sb.toString();
    }
}
