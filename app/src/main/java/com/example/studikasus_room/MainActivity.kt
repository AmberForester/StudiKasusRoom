package com.example.studikasus_room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.studikasus_room.ui.theme.StudiKasus_RoomTheme

/*
File ini merupakan MainActivity. Sesuai namanya, MainActivity adalah activity utama dari aplikasi ini
dan awal dari aplikasi ini. Activity inilah yang pertama kali dijalankan ketika aplikasi di "klik".
Terdapat beberapa pengaturan tema dengan memanggil fungsi StudiKasus_RoomTheme. Activity memanggil
InventoryApp yang merupakan sebuah fungsi utama yang mengatur keseluruhan tampilan aplikasi
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudiKasus_RoomTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    InventoryApp()
                }
            }
        }
    }
}

