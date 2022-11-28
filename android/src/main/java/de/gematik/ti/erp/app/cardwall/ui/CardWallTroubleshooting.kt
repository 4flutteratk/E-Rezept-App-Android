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

package de.gematik.ti.erp.app.cardwall.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import de.gematik.ti.erp.app.profiles.repository.ProfileIdentifier
import kotlinx.coroutines.launch

@Composable
fun CardWallTroubleshootingPageA(
    viewModel: CardWallViewModel,
    authenticationData: CardWallAuthenticationData,
    profileId: ProfileIdentifier,
    onFinal: () -> Unit,
    onNext: () -> Unit,
    onBack: () -> Unit,
    onRetryCan: () -> Unit,
    onRetryPin: () -> Unit,
    onUnlockEgk: () -> Unit
) {
    val dialogState = rememberCardWallAuthenticationDialogState()

    CardWallAuthenticationDialog(
        profileId = profileId,
        dialogState = dialogState,
        viewModel = viewModel,
        authenticationData = authenticationData,
        onFinal = onFinal,
        onRetryCan = onRetryCan,
        onRetryPin = onRetryPin,
        onUnlockEgk = onUnlockEgk
    )
    val coroutineScope = rememberCoroutineScope()
    TroubleshootingPageAContent(
        onBack = onBack,
        onNext = onNext,
        onClickTryMe = {
            coroutineScope.launch { dialogState.show() }
        }
    )
}

@Composable
fun CardWallTroubleshootingPageB(
    viewModel: CardWallViewModel,
    authenticationData: CardWallAuthenticationData,
    profileId: ProfileIdentifier,
    onFinal: () -> Unit,
    onNext: () -> Unit,
    onBack: () -> Unit,
    onRetryCan: () -> Unit,
    onRetryPin: () -> Unit,
    onUnlockEgk: () -> Unit
) {
    val dialogState = rememberCardWallAuthenticationDialogState()

    CardWallAuthenticationDialog(
        dialogState = dialogState,
        viewModel = viewModel,
        authenticationData = authenticationData,
        profileId = profileId,
        onFinal = onFinal,
        onRetryCan = onRetryCan,
        onRetryPin = onRetryPin,
        onUnlockEgk = onUnlockEgk
    )

    val coroutineScope = rememberCoroutineScope()
    TroubleshootingPageBContent(
        onBack,
        onNext,
        onClickTryMe = {
            coroutineScope.launch { dialogState.show() }
        }
    )
}

@Composable
fun CardWallTroubleshootingPageC(
    viewModel: CardWallViewModel,
    authenticationData: CardWallAuthenticationData,
    profileId: ProfileIdentifier,
    onFinal: () -> Unit,
    onNext: () -> Unit,
    onBack: () -> Unit,
    onRetryCan: () -> Unit,
    onRetryPin: () -> Unit,
    onUnlockEgk: () -> Unit
) {
    val dialogState = rememberCardWallAuthenticationDialogState()

    CardWallAuthenticationDialog(
        profileId = profileId,
        dialogState = dialogState,
        viewModel = viewModel,
        authenticationData = authenticationData,
        onFinal = onFinal,
        onRetryCan = onRetryCan,
        onRetryPin = onRetryPin,
        onUnlockEgk = onUnlockEgk
    )

    val coroutineScope = rememberCoroutineScope()
    TroubleshootingPageCContent(
        onBack,
        onNext,
        onClickTryMe = {
            coroutineScope.launch { dialogState.show() }
        }
    )
}

@Composable
fun CardWallTroubleshootingNoSuccessPage(
    onNext: () -> Unit,
    onBack: () -> Unit
) {
    TroubleshootingNoSuccessPageContent(
        onNext,
        onBack
    )
}
