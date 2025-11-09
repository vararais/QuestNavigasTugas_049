package com.example.questnavigastugas_049.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.questnavigastugas_049.R

data class FormData(
    val nama: String,
    val gender: String,
    val status: String,
    val alamat: String
)

fun getListData(): List<FormData> {
    return listOf(
        FormData("Asroni Sukirman", "Laki - Laki", "Cerai", "Sleman"),
        FormData("Aprilia Kurnianti", "Perempuan", "Lajang", "Bantul"),
        FormData("Haris Setyawan", "Laki - Laki", "Kawin", "Jogja"),
        FormData("Dwijoko Purbohadi", "Laki - Laki", "Lajang", "Bantul")
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    onBerandaClick: () -> Unit,
    onFormulirClick: () -> Unit
) {
    val dataList = getListData()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.list_peserta), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_medium)),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = onBerandaClick, modifier = Modifier.weight(1f)) {
                    Text(stringResource(id = R.string.beranda))
                }
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_medium)))
                Button(onClick = onFormulirClick, modifier = Modifier.weight(1f)) {
                    Text(stringResource(id = R.string.formulir))
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
        ) {
            items(dataList) { data ->
                PesertaCard(data = data)
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            }
        }
    }
}

