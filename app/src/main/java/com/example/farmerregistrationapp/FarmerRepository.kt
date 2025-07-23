package com.example.farmerregistrationapp

import kotlinx.coroutines.flow.Flow

class FarmerRepository(private val dao: FarmerDao) {
    val allFarmers: Flow<List<Farmer>> = dao.getAllFarmers()

    suspend fun insert(farmer: Farmer) {
        dao.insert(farmer)
    }
}
