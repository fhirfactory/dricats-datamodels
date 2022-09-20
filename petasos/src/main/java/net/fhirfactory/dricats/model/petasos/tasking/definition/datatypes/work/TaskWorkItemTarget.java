package net.fhirfactory.dricats.model.petasos.tasking.definition.datatypes.work;

import net.fhirfactory.dricats.model.petasos.participant.datatypes.PetasosParticipantId;

public class TaskWorkItemTarget {
    private String sourceSystem;
    private String sourceInterface;
    private PetasosParticipantId sourceProcessingPlantParticipantName;
    private PetasosParticipantId sourceWorkUnitProcessorParticipantName;
    private PetasosParticipantId sourceEndpointParticipantName;
    private String sourceEndpointInterfaceName;
    private String sourceType;
}
