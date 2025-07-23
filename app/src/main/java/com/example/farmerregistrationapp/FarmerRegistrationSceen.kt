package com.example.farmerregistrationapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FarmerRegistrationScreen(viewModel: FarmerViewModel) {
    var name by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }
    var crop by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
        OutlinedTextField(value = id, onValueChange = { id = it }, label = { Text("National ID") })
        OutlinedTextField(value = crop, onValueChange = { crop = it }, label = { Text("Crop Type") })

        Button(onClick = {
            if (name.isNotBlank() && id.isNotBlank() && crop.isNotBlank()) {
                viewModel.insert(Farmer(name = name, nationalId = id, cropType = crop))
                name = ""; id = ""; crop = ""
            }
        }, modifier = Modifier.padding(vertical = 8.dp)) {
            Text("Save Farmer")
        }

        Text("Registered Farmers:", style = MaterialTheme.typography.titleMedium)

        val farmers by viewModel.allFarmers.collectAsState()
        for (farmer in farmers) {
            Text("${farmer.name} - ${farmer.nationalId} - ${farmer.cropType}")
        }
    }
}
