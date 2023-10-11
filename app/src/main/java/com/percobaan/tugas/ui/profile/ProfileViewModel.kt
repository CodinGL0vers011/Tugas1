package com.percobaan.tugas.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "MUHAMMAD FAJAR DWI PUTRA"
    }
    val text: LiveData<String> = _text
}