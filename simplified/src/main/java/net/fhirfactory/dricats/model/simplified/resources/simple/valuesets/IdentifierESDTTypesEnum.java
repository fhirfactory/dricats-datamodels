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
package net.fhirfactory.dricats.model.simplified.resources.simple.valuesets;

public enum IdentifierESDTTypesEnum {
    ESR_IDENTIFIER_TYPE_SHORT_NAME("ShortName", "dricats.simplified_resource.practitioner_role.short_name"),
    ESR_IDENTIFIER_TYPE_LONG_NAME("LongName", "dricats.simplified_resource.practitioner_role.long_name"),
    ESR_IDENTIFIER_TYPE_EMAIL_ADDRESS("EmailAddress", "dricats.simplified_resource.practitioner.email_address"),
    ESR_IDENTIFIER_TYPE_MATRIX_ROOM_ID("matrix.room_id", "dricats.simplified_resource.group.communicate_room_id"),
    ESR_IDENTIFIER_TYPE_ROOM_SYSTEM_ID("RoomSystemID", "dricats.simplified_resource.group.communicate_system_room_id"),
    ESR_IDENTIFIER_TYPE_MATRIX_USER_ID("matrix.user_id", "dricats.simplified_resource.practitioner.communicate_user_id"),
    ESR_IDENTIFIER_TYPE_PATIENT_URN("patient_urn", "dricats.simplified_resource.patient.urn"),
    ESR_IDENTIFIER_TYPE_COMMUNICATE_SESSION("SessionID", "dricats.simplified_resource.encounter.communicate_session_id");

    private String displayName;
    private String token;

    private IdentifierESDTTypesEnum(String displayName, String token){
        this.displayName = displayName;
        this.token = token;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static IdentifierESDTTypesEnum fromDisplayName(String text) {
        for (IdentifierESDTTypesEnum b : IdentifierESDTTypesEnum.values()) {
            if (b.displayName.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
