package com.example.farmerregistrationapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FarmerViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: FarmerRepository
    val allFarmers: StateFlow<List<Farmer>>

    init {
        val dao = FarmerDatabase.getDatabase(application).farmerDao()
        repository = FarmerRepository(dao)
        allFarmers = repository.allFarmers.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )
    }

    fun insert(farmer: Farmer) = viewModelScope.launch {
        repository.insert(farmer)
    }
}
