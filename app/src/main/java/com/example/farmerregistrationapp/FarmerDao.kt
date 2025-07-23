package com.example.farmerregistrationapp

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface FarmerDao {
    @Insert
    suspend fun insert(farmer: Farmer)

    @Query("SELECT * FROM farmers")
    fun getAllFarmers(): Flow<List<Farmer>>
}
