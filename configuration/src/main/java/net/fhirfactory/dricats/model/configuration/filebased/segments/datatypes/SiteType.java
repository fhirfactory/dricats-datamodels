/*
 * The MIT License
 *
 * Copyright 2022 mhunter.
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
package net.fhirfactory.dricats.model.configuration.filebased.segments.datatypes;

/**
 *
 * @author mhunter
 */
public class SiteType {
    private String siteName;
    private String siteAlias;
    private Integer siteNumber;
    
    //
    // Constructor(s)
    //
    
    public SiteType(){
        this.siteName = null;
        this.siteNumber = null;
        this.siteAlias = null;
    }
    
    //
    // Getters and Setters
    //

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Integer getSiteNumber() {
        return siteNumber;
    }

    public void setSiteNumber(Integer siteNumber) {
        this.siteNumber = siteNumber;
    }

    public String getSiteAlias() {
        return siteAlias;
    }

    public void setSiteAlias(String siteAlias) {
        this.siteAlias = siteAlias;
    }
    
    
    //
    // toString
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SiteType{");
        sb.append("siteName=").append(siteName);
        sb.append(", siteNumber=").append(siteNumber);
        sb.append(", siteAlias=").append(siteAlias);
        sb.append('}');
        return sb.toString();
    }
    
}
