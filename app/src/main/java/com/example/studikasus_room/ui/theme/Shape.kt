package com.example.studikasus_room.ui.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

/*
file ini mendefinisikan bentuk corner shape menjadi 3 kategori dengan ukuran tertentu untuk
masing masing kategorinya.
 */
val Shapes = Shapes(

    extraSmall = CutCornerShape(topEnd = 8.dp, bottomStart = 8.dp),
    small = CutCornerShape(topEnd = 8.dp, bottomStart = 8.dp),
    medium = CutCornerShape(topEnd = 16.dp, bottomStart = 16.dp)
)