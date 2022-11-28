/*
 * Copyright (c) 2022 gematik GmbH
 * 
 * Licensed under the EUPL, Version 1.2 or – as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the Licence);
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 * 
 *     https://joinup.ec.europa.eu/software/page/eupl
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 * 
 */

package de.gematik.ti.erp.app.attestation.repository

import de.gematik.ti.erp.app.attestation.model.AttestationData
import de.gematik.ti.erp.app.db.entities.v1.SafetynetAttestationEntityV1
import de.gematik.ti.erp.app.db.writeOrCopyToRealm
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AttestationLocalDataSource(
    private val realm: Realm
) {
    suspend fun persistReport(attestation: AttestationData.SafetynetAttestation) {
        realm.writeOrCopyToRealm(::SafetynetAttestationEntityV1) {
            it.jws = attestation.jws
            it.ourNonce = attestation.ourNonce
        }
    }

    fun fetchAttestations(): Flow<AttestationData.SafetynetAttestation?> =
        realm.query<SafetynetAttestationEntityV1>().first().asFlow().map {
            it.obj?.let {
                AttestationData.SafetynetAttestation(
                    jws = it.jws,
                    ourNonce = it.ourNonce
                )
            }
        }
}
