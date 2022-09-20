/*
 * The MIT License
 *
 * Copyright 2022 Mark A. Hunter.
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
package net.fhirfactory.dricats.model.configuration.filebased.segments;

/**
 *
 * @author mhunter
 */
public class SolutionSegment {
    private String solutionName;
    private String solutionVersion;
    private String solutionOwner;
    private String solutionDescription;
  
    //
    // Constructor(s)
    //
    
    public SolutionSegment(){
        this.solutionName = null;
        this.solutionVersion = null;
        this.solutionOwner = null;
        this.solutionDescription = null;
  
    }
    
    //
    // Getters and Setters
    //

    public String getSolutionName() {
        return solutionName;
    }

    public void setSolutionName(String solutionName) {
        this.solutionName = solutionName;
    }

    public String getSolutionVersion() {
        return solutionVersion;
    }

    public void setSolutionVersion(String solutionVersion) {
        this.solutionVersion = solutionVersion;
    }

    public String getSolutionOwner() {
        return solutionOwner;
    }

    public void setSolutionOwner(String solutionOwner) {
        this.solutionOwner = solutionOwner;
    }

    public String getSolutionDescription() {
        return solutionDescription;
    }

    public void setSolutionDescription(String solutionDescription) {
        this.solutionDescription = solutionDescription;
    }
    
    //
    // toString
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SolutionSegment{");
        sb.append("solutionName=").append(solutionName);
        sb.append(", solutionVersion=").append(solutionVersion);
        sb.append(", solutionOwner=").append(solutionOwner);
        sb.append(", solutionDescription=").append(solutionDescription);
        sb.append('}');
        return sb.toString();
    }
    
}
