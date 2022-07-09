package com.blue.callblock.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blue.callblock.repository.CallEventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val callEventRepository: CallEventRepository) :
    ViewModel() {
    val recentCalls = callEventRepository.getCallEventsWLimit(3)
    var hasCallScreeningRole by mutableStateOf(false)

    fun onRoleResult(granted: Boolean) {
        viewModelScope.launch {
            hasCallScreeningRole = granted
        }
    }
}