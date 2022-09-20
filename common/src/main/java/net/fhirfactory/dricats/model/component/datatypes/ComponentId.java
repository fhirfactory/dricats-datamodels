/*
 * Copyright (c) 2020 Mark A. Hunter (ACT Health)
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
package net.fhirfactory.dricats.model.component.datatypes;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import org.apache.commons.lang3.SerializationUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import net.fhirfactory.dricats.model.constants.DeploymentPropertyConstants;
import org.apache.commons.lang3.StringUtils;

public class ComponentId implements Serializable {
	private String id;
	private String name;
	private String version;
	private String displayName;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSXXX", timezone = DeploymentPropertyConstants.DEFAULT_TIMEZONE)
	private Instant idValidityStartInstant;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSXXX", timezone = DeploymentPropertyConstants.DEFAULT_TIMEZONE)
	private Instant idValidityEndInstant;

	//
	// Constructor(s)
	//

	public ComponentId() {
		this.id = null;
		this.idValidityStartInstant = null;
		this.idValidityEndInstant = null;
		this.displayName = null;
		this.name = null;
		this.version = null;
	}

	public ComponentId(ComponentId ori) {
		this.id = null;
		this.idValidityStartInstant = null;
		this.idValidityEndInstant = null;
		this.displayName = null;
		if (ori.hasId()) {
			setId(SerializationUtils.clone(ori.getId()));
		}
		if (ori.hasIdValidityStartInstant()) {
			setIdValidityStartInstant(SerializationUtils.clone(ori.getIdValidityStartInstant()));
		}
		if (ori.hasIdValidityEndInstant()) {
			setIdValidityEndInstant(SerializationUtils.clone(ori.getIdValidityEndInstant()));
		}
		if (ori.hasDisplayName()) {
			setDisplayName(SerializationUtils.clone(ori.getDisplayName()));
		}
	}

	public ComponentId(String componentName, String componentVersion){
		this.name = componentName;
		this.version = componentVersion;
		String uuid = UUID.randomUUID().toString();
		this.displayName = componentName + ":" + componentVersion + "(" + uuid + ")";
		this.id = uuid;
		this.setIdValidityStartInstant(Instant.now());
		this.setIdValidityEndInstant(Instant.MAX);
	}

	//
	// Getters and Setters (Bean Methods)
	//

	@JsonIgnore
	public boolean hasId() {
		boolean hasValue = this.id != null;
		return (hasValue);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonIgnore
	public boolean hasDisplayName() {
		boolean hasValue = this.displayName != null;
		return (hasValue);
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@JsonIgnore
	public boolean hasIdValidityStartInstant() {
		boolean hasValue = this.idValidityStartInstant != null;
		return (hasValue);
	}

	public Instant getIdValidityStartInstant() {
		return idValidityStartInstant;
	}

	public void setIdValidityStartInstant(Instant idValidityStartInstant) {
		this.idValidityStartInstant = idValidityStartInstant;
	}

	@JsonIgnore
	public boolean hasIdValidityEndInstant() {
		boolean hasValue = this.idValidityEndInstant != null;
		return (hasValue);
	}

	public Instant getIdValidityEndInstant() {
		return idValidityEndInstant;
	}

	public void setIdValidityEndInstant(Instant idValidityEndInstant) {
		this.idValidityEndInstant = idValidityEndInstant;
	}

	@JsonIgnore
	public boolean hasName(){
		boolean hasValue = this.name != null;
		return(hasValue);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public boolean hasVersion(){
		boolean hasValue = this.version != null;
		return(hasValue);
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	//
	// Equals and Hashcodes
	//

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ComponentId))
			return false;
		ComponentId that = (ComponentId) o;
                boolean sameId = false;
                if(StringUtils.isEmpty(this.getId()) && StringUtils.isEmpty(that.getId())){
                    sameId = true;
                } else if(StringUtils.isNotEmpty(this.getId())){
                    sameId = this.getId().contentEquals(that.getId());
                }
                boolean sameDisplayName = false;
                if(StringUtils.isEmpty(this.getDisplayName()) && StringUtils.isEmpty(that.getDisplayName())){
                    sameDisplayName = true;
                } else if(StringUtils.isNotEmpty(this.getDisplayName())){
                    sameId = this.getDisplayName().contentEquals(that.getDisplayName());
                }
                boolean validStartTime = false;
                if(this.getIdValidityStartInstant() == null && that.getIdValidityStartInstant() == null){
                    validStartTime = true;
                } else if(this.getIdValidityStartInstant() != null){
                    if(that.getIdValidityStartInstant() != null){
                        validStartTime = this.getIdValidityStartInstant().isBefore(that.getIdValidityStartInstant()) || (this.getIdValidityStartInstant() == that.getIdValidityStartInstant());
                    }
                }
                boolean validEndTime = false;
                if(this.getIdValidityEndInstant() == null && that.getIdValidityEndInstant()== null){
                    validEndTime = true;
                } else if(this.getIdValidityEndInstant()!= null){
                    if(that.getIdValidityEndInstant() != null){
                        validEndTime = this.getIdValidityEndInstant().isAfter(that.getIdValidityEndInstant()) || (this.getIdValidityEndInstant() == that.getIdValidityEndInstant());
                    }
                }
                boolean theyAreEqual = sameId && sameDisplayName && validStartTime && validEndTime;
		return (theyAreEqual);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	//
	// To String
	//

	@Override
	public String toString() {
		return "ComponentIdType{" + "id='" + id + '\'' + ", displayName='" + displayName + '\''
				+ ", idValidityStartInstant=" + idValidityStartInstant + ", idValidityEndInstant="
				+ idValidityEndInstant + '}';
	}
}
