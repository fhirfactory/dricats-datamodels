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
package net.fhirfactory.dricats.model.petasos.participant.valuesets;

public enum DefaultWorkshopSetEnum {
    DATA_GRID_WORKSHOP("DataGrid", "LocalDataGrid"),
    INTER_SUBSYSTEM_INTEGRATION_WORKSHOP("ISSI", "ISSI"),
    BEHAVIOUR_WORKSHOP("Behaviour", "Behaviour"),
    INTERACT_WORKSHOP("Interact", "ExternalIPC"),
    TRANSFORM_WORKSHOP("Transform", "Transform"),
    WORKFLOW_WORKSHOP("Workflow", "Workflow"),
    POLICY_ENFORCEMENT_WORKSHOP("PolicyEnforcement","PolicyEnforcement"),
    FRAMEWORK_SERVICES_WORKSHOP("FrameworkFramework","FrameworkServices"),
    EDGE_WORKSHOP("Edge", "InternalIPC");

    private String componentName;
    private String participantDisplayName;

    private DefaultWorkshopSetEnum(String name, String displayName){
        this.componentName = name;
        this.participantDisplayName = displayName;
    }

    public String getComponentName() {
        return componentName;
    }

    public String getParticipantDisplayName() {
        return participantDisplayName;
    }
}
