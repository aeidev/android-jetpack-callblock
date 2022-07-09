package com.blue.callblock.model

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ManageViewModel @Inject constructor() : ViewModel() {
    val blockAllState = false
}