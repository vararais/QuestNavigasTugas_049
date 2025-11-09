package com.example.questnavigastugas_049.view

import android.R.attr.text
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questnavigastugas_049.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun WelcomeScreen(
    onMasukClick: () -> Unit
) {
    var isLoading by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.selamat_datang),
            fontSize = 35.sp
        )

        Spacer(modifier = Modifier.height(80.dp))

        Image(
            painter = painterResource(id = R.drawable.welcomee),
            contentDescription = "Logo Aplikasi",
            modifier = Modifier.size(300.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = stringResource(id = R.string.nama_anan))
        Text(text = stringResource(id = R.string.nim_anan))

        Spacer(modifier = Modifier.height(120.dp))

        Button(
            onClick = {
                if (!isLoading) {
                    coroutineScope.launch {
                        isLoading = true
                        delay(2000)
                        onMasukClick()
                        isLoading = false
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(52.dp)
        ) {
            Text(
                text = stringResource(id = R.string.masuk),
                fontSize = 20.sp
            )
        }
    }
}