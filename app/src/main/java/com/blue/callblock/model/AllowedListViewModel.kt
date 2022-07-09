package com.blue.callblock.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blue.callblock.repository.CallEventRepository
import com.blue.callblock.repository.CallerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AllowedListViewModel @Inject constructor(private val callerRepository: CallerRepository) :
    ViewModel() {
    val allowedList = callerRepository.getAllAllowed()

}