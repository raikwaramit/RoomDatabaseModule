package com.raikwaramit.roomdatabasemodule.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.raikwaramit.roomdatabasemodule.room.User
import com.raikwaramit.roomdatabasemodule.ui.theme.RoomDatabaseModuleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = hiltViewModel<ViewModel>()
            RoomDatabaseModuleTheme {
                // A surface container using the 'background' color from the theme
                Box(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        InsertDataUI {
                            viewModel.insertData(it)
                        }
                        val state = viewModel.state
                        LazyColumn(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(10.dp)
                        ) {
                            items(state.value) {
                                Text("Item: ${it.name}, ${it.city}, ${it.address} ${it.phone}")
                                IconButton(
                                    onClick = { viewModel.deleteData(it) }
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Delete,
                                        contentDescription = "",
                                        modifier = Modifier.size(50.dp)
                                    )
                                }
                                Divider(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(1.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable

fun InsertDataUI(onInsertData: (User) -> Unit) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        var name by remember { mutableStateOf("") }
        var address by remember { mutableStateOf("") }
        var phone by remember { mutableStateOf("") }
        var city by remember { mutableStateOf("") }
        TextField(
            label = { Text(text = "Name") },
            value = name, onValueChange = { name = it }, modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(4.dp))
        TextField(
            label = { Text(text = "Address") },
            value = address,
            onValueChange = { address = it },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(4.dp))
        TextField(
            label = { Text(text = "Phone") },
            value = phone, onValueChange = { phone = it }, modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(4.dp))
        TextField(
            label = { Text(text = "City") },
            value = city, onValueChange = { city = it }, modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(4.dp))


        Button(
            onClick = {
                val user = User(
                    name = name,
                    address = address,
                    phone = phone,
                    city = city
                )
                onInsertData(user)
            }, modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally)
        ) {
            Text(text = "Save")
        }
    }
}