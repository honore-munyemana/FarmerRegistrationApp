package com.example.farmerregistrationapp

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FarmerViewModelFactory(private val app: Application) : ViewModelProvider.AndroidViewModelFactory(app) {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FarmerViewModel(app) as T
    }
}
