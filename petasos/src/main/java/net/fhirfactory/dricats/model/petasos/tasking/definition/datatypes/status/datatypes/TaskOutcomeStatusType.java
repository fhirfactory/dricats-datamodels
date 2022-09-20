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
package net.fhirfactory.dricats.model.petasos.tasking.definition.datatypes.status.datatypes;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

import net.fhirfactory.dricats.model.constants.DeploymentPropertyConstants;
import net.fhirfactory.dricats.model.petasos.tasking.definition.datatypes.status.valuesets.ActionableTaskOutcomeStatusEnum;

public class TaskOutcomeStatusType implements Serializable {

    private ActionableTaskOutcomeStatusEnum outcomeStatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSXXX", timezone = DeploymentPropertyConstants.DEFAULT_TIMEZONE)
    private Instant entryInstant;

    //
    // Constructor(s)
    //

    public TaskOutcomeStatusType(){
        super();
        entryInstant = Instant.now();
        this.outcomeStatus = ActionableTaskOutcomeStatusEnum.ACTIONABLE_TASK_OUTCOME_STATUS_UNKNOWN;
    }

    //
    // Getters and Setters (Bean Methods)
    //


    public Instant getEntryInstant() {
        return entryInstant;
    }

    public void setEntryInstant(Instant entryInstant) {
        this.entryInstant = entryInstant;
    }

    public ActionableTaskOutcomeStatusEnum getOutcomeStatus() {
        return outcomeStatus;
    }

    public void setOutcomeStatus(ActionableTaskOutcomeStatusEnum outcomeStatus) {
        this.outcomeStatus = outcomeStatus;
    }

    //
    // To String
    //


    @Override
    public String toString() {
        return "OutcomeStatusSegment{" +
                "outcomeStatus=" + outcomeStatus +
                ", entryInstant=" + getEntryInstant() +
                '}';
    }
}
