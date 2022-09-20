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
package net.fhirfactory.dricats.model.petasos.tasking.definition.datatypes.dataparcel;


import net.fhirfactory.dricats.model.dataparcel.DataDescriptor;
import java.io.Serializable;
import java.util.Objects;
import net.fhirfactory.dricats.model.petasos.tasking.definition.datatypes.dataparcel.valuesets.DataParcelFragmentQualityEnum;

public class DataParcelFragmentQualityStatement extends DataDescriptor implements Serializable {
    private DataParcelFragmentQualityEnum fragmentQuality;

    //
    // Constructor(s)
    //

    public DataParcelFragmentQualityStatement(){
        super();
        fragmentQuality = null;
    }

    public DataParcelFragmentQualityStatement(DataDescriptor ori){
        super(ori);
        fragmentQuality = null;
    }

    public DataParcelFragmentQualityStatement(DataParcelFragmentQualityStatement ori){
        super(ori);
        if(ori.getFragmentQuality() != null){
            setFragmentQuality(ori.getFragmentQuality());
        }
    }

    //
    // Getters and Setters
    //

    public DataParcelFragmentQualityEnum getFragmentQuality() {
        return fragmentQuality;
    }

    public void setFragmentQuality(DataParcelFragmentQualityEnum fragmentQuality) {
        this.fragmentQuality = fragmentQuality;
    }

    //
    // Equals and Hashcode
    //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataParcelFragmentQualityStatement)) return false;
        if (!super.equals(o)) return false;
        DataParcelFragmentQualityStatement that = (DataParcelFragmentQualityStatement) o;
        return getFragmentQuality() == that.getFragmentQuality();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getFragmentQuality());
    }

    //
    // toString
    //

    @Override
    public String toString() {
        return "DataParcelFragmentQualityStatement{" +
                "dataParcelDefiner=" + getDataParcelDefiner() +
                ", dataParcelCategory=" + getDataParcelCategory() +
                ", dataParcelSubCategory=" + getDataParcelSubCategory() +
                ", dataParcelResource=" + getDataParcelResource() +
                ", dataParcelSegment=" + getDataParcelSegment() +
                ", dataParcelAttribute=" + getDataParcelAttribute() +
                ", version=" + getVersion() +
                ", fragmentQuality=" + fragmentQuality +
                '}';
    }
}
