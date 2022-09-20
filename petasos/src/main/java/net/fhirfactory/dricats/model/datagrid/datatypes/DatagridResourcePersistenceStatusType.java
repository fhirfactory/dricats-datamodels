package net.fhirfactory.dricats.model.datagrid.datatypes;

import net.fhirfactory.dricats.model.datagrid.valuesets.DatagridPersistenceResourceStatusEnum;
import java.io.Serializable;
import java.util.Objects;
import net.fhirfactory.dricats.model.dataparcel.DataDescriptor;

public class DatagridResourcePersistenceStatusType implements Serializable {
    private String resourceId;
    private DatagridPersistenceResourceStatusEnum persistenceStatus;
    private DataDescriptor resourceType;

    //
    // Constructor(s)
    //

    public DatagridResourcePersistenceStatusType(){
        this.resourceId = null;
        this.persistenceStatus = null;
        this.resourceType = null;
    }

    //
    // Getters and Setters
    //

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public DatagridPersistenceResourceStatusEnum getPersistenceStatus() {
        return persistenceStatus;
    }

    public void setPersistenceStatus(DatagridPersistenceResourceStatusEnum persistenceStatus) {
        this.persistenceStatus = persistenceStatus;
    }

    public DataDescriptor getResourceType() {
        return resourceType;
    }

    public void setResourceType(DataDescriptor resourceType) {
        this.resourceType = resourceType;
    }

    //
    // Equals and Hashcode
    //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatagridResourcePersistenceStatusType that = (DatagridResourcePersistenceStatusType) o;
        return Objects.equals(getResourceId(), that.getResourceId()) && getPersistenceStatus() == that.getPersistenceStatus() && Objects.equals(getResourceType(), that.getResourceType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResourceId(), getPersistenceStatus(), getResourceType());
    }

    //
    // To String
    //

    @Override
    public String toString() {
        return "DatagridResourcePersistenceStatusType{" +
                "resourceId='" + resourceId + '\'' +
                ", persistenceStatus=" + persistenceStatus +
                ", resourceType=" + resourceType +
                '}';
    }
}
