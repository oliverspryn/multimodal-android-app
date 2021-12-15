package com.oliverspryn.android.multimodal.ui.adaptivelayouts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class AdaptiveLayoutsViewModel : ViewModel() {
    private val viewModelState = MutableStateFlow(AdaptiveLayoutsUiState())

    val uiState = viewModelState
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            AdaptiveLayoutsUiState()
        )

    fun closeDetails() {
        viewModelState.update {
            it.copy(
                numberSelected = false,
                numberFromList = 0
            )
        }
    }

    fun openDetails(selectedNumber: Int) {
        viewModelState.update {
            it.copy(
                numberSelected = true,
                numberFromList = selectedNumber
            )
        }
    }
}

data class AdaptiveLayoutsUiState(
    val numberSelected: Boolean = false,
    val numberFromList: Int = 0
)
