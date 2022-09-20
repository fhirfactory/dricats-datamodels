package net.fhirfactory.dricats.interfaces.capabilities;

public interface CapabilityFulfillmentManagementInterface {
    public void registerCapabilityFulfillmentService(String capabilityName, CapabilityFulfillmentInterface fulfillmentInterface);
}
