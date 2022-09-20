/*
 * Copyright (c) 2021 Mark A. Hunter
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
package net.fhirfactory.dricats.model.petasos.tasking.definition;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.fhirfactory.dricats.model.petasos.tasking.definition.datatypes.fulfillment.datatypes.TaskFulfillmentType;
import net.fhirfactory.dricats.model.petasos.tasking.definition.datatypes.identity.datatypes.TaskIdType;
import net.fhirfactory.dricats.model.petasos.tasking.definition.datatypes.interception.TaskInterceptionType;
import net.fhirfactory.dricats.model.petasos.tasking.definition.datatypes.tasktype.TaskTypeType;
import net.fhirfactory.dricats.model.petasos.tasking.definition.datatypes.tasktype.valuesets.TaskTypeTypeEnum;
import net.fhirfactory.dricats.model.petasos.tasking.fulfillment.execctrl.PetasosTaskJobCard;

public class PetasosFulfillmentTask extends PetasosTask{

    private TaskFulfillmentType taskFulfillment;

    private PetasosTaskJobCard taskJobCard;

    private TaskIdType actionableTaskId;

    private TaskInterceptionType taskInterception;

    private boolean aRetry;

    //
    // Constructor(s)
    //

    public PetasosFulfillmentTask(){
        super();
        this.actionableTaskId = null;
        this.taskFulfillment = new TaskFulfillmentType();
        this.taskJobCard = null;
        this.aRetry = false;
        setTaskType(new TaskTypeType(TaskTypeTypeEnum.PETASOS_FULFILLMENT_TASK_TYPE));
    }

    //
    // Getters and Setters (Bean Methods)
    //

    @JsonIgnore
    public boolean hasTaskFulfillment(){
        boolean hasValue = this.taskFulfillment != null;
        return(hasValue);
    }

    public TaskFulfillmentType getTaskFulfillment() {
        return taskFulfillment;
    }

    public void setTaskFulfillment(TaskFulfillmentType taskFulfillment) {
        this.taskFulfillment = taskFulfillment;
    }

    @JsonIgnore
    public boolean hasActionableTaskId(){
        boolean hasValue = this.actionableTaskId != null;
        return(hasValue);
    }

    public TaskIdType getActionableTaskId() {
        return actionableTaskId;
    }

    public void setActionableTaskId(TaskIdType fulfilledTaskPetasosTaskIdentity) {
        this.actionableTaskId = fulfilledTaskPetasosTaskIdentity;
    }

    @JsonIgnore
    public boolean hasTaskJobCard(){
        boolean hasValue = this.taskJobCard != null;
        return(hasValue);
    }

    public PetasosTaskJobCard getTaskJobCard() {
        return taskJobCard;
    }

    public void setTaskJobCard(PetasosTaskJobCard taskJobCard) {
        this.taskJobCard = taskJobCard;
    }


    public boolean isaRetry() {
        return aRetry;
    }

    public void setaRetry(boolean aRetry) {
        this.aRetry = aRetry;
    }

    @JsonIgnore
    public boolean hasTaskInterception(){
        boolean hasValue = this.taskInterception != null;
        return(hasValue);
    }

    public TaskInterceptionType getTaskInterception() {
        return taskInterception;
    }

    public void setTaskInterception(TaskInterceptionType taskInterception) {
        this.taskInterception = taskInterception;
    }

    //
    // Hash and Equals
    //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PetasosFulfillmentTask that = (PetasosFulfillmentTask) o;
        return isaRetry() == that.isaRetry() && Objects.equals(getTaskFulfillment(), that.getTaskFulfillment()) && Objects.equals(getTaskJobCard(), that.getTaskJobCard()) && Objects.equals(getActionableTaskId(), that.getActionableTaskId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTaskFulfillment(), getTaskJobCard(), getActionableTaskId(), isaRetry());
    }

    //
    // ToString
    //

    @Override
    public String toString() {
        return "PetasosFulfillmentTask{" +
                "  taskFulfillment=" + taskFulfillment +
                "  taskJobCard=" + taskJobCard +
                "  actionableTaskId=" + actionableTaskId +
                "  sourceResourceId=" + getSourceResourceId() +
                "  taskId=" + getTaskId() +
                "  hasTaskType=" + hasTaskType() +
                "  taskType=" + getTaskType() +
                "  taskWorkItem=" + getTaskWorkItem() +
                "  taskTraceability=" + getTaskTraceability() +
                "  taskOutcomeStatus=" + getTaskOutcomeStatus() +
                "  registered=" + isRegistered() +
                "  taskPerformerTypes=" + getTaskPerformerTypes() +
                "  isARetry=" + isaRetry() +
                "  taskMetadata=" + getTaskContext() +
                ", executionStatus=" + getExecutionStatus() +
                ", taskInterception=" + getTaskInterception() +
                '}';
    }
}
