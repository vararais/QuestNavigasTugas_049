package com.example.questnavigastugas_049.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.questnavigastugas_049.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormulirScreen(
    onBackBtnClick: () -> Unit
) {
    var nama by rememberSaveable { mutableStateOf("") }
    var alamat by rememberSaveable { mutableStateOf("") }

    val jenisKelaminOptions = listOf(
        stringResource(id = R.string.laki_laki),
        stringResource(id = R.string.perempuan)
    )
    var jenisKelamin by rememberSaveable { mutableStateOf("") }

    val statusOptions = listOf("Janda", "Lajang", "Duda")
    var statusPerkawinan by rememberSaveable { mutableStateOf("") }
    var isDropdownExpanded by remember { mutableStateOf(false) }

    var showSuccessDialog by remember { mutableStateOf(false) }
    var showErrorDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.formulir_daftar), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                label = { Text(stringResource(id = R.string.nama_lengkap)) },
                placeholder = { Text(stringResource(id = R.string.isi_nama_lengkap)) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))

            Text(stringResource(id = R.string.jenis_kelamin), modifier = Modifier.fillMaxWidth())
            Row(modifier = Modifier.fillMaxWidth()) {
                jenisKelaminOptions.forEach { option ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = (jenisKelamin == option),
                            onClick = { jenisKelamin = option }
                        )
                        Text(text = option)
                    }
                }
            }
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))

            ExposedDropdownMenuBox(
                expanded = isDropdownExpanded,
                onExpandedChange = { isDropdownExpanded = !isDropdownExpanded }
            ) {
                OutlinedTextField(
                    value = statusPerkawinan,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text(stringResource(id = R.string.status_perkawinan)) },
                    placeholder = { Text(stringResource(id = R.string.pilih_statuskawin)) },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = isDropdownExpanded)
                    },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                )
                ExposedDropdownMenu(
                    expanded = isDropdownExpanded,
                    onDismissRequest = { isDropdownExpanded = false }
                ) {
                    statusOptions.forEach { option ->
                        DropdownMenuItem(
                            text = { Text(option) },
                            onClick = {
                                statusPerkawinan = option
                                isDropdownExpanded = false
                            }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))

            OutlinedTextField(
                value = alamat,
                onValueChange = { alamat = it },
                label = { Text(stringResource(id = R.string.alamat)) },
                placeholder = { Text(stringResource(id = R.string.isi_alamat)) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    onClick = onBackBtnClick,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(stringResource(id = R.string.kembali))
                }
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_medium)))
                Button(
                    onClick = {
                        if (nama.isBlank() || alamat.isBlank() || jenisKelamin.isBlank() || statusPerkawinan.isBlank()) {
                            showErrorDialog = true
                        } else {
                            showSuccessDialog = true
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(stringResource(id = R.string.submit))
                }
            }
        }

        if (showSuccessDialog) {
            AlertDialog(
                onDismissRequest = { showSuccessDialog = false },
                title = { Text(stringResource(id = R.string.data_disimpan)) },
                text = {
                    Column {
                        Text("Nama : $nama")
                        Text("Jenis Kelamin : $jenisKelamin")
                        Text("Status : $statusPerkawinan")
                        Text("Alamat : $alamat")
                    }
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            showSuccessDialog = false
                            nama = ""
                            alamat = ""
                            jenisKelamin = ""
                            statusPerkawinan = ""
                            onBackBtnClick()
                        }
                    ) {
                        Text("OK")
                    }
                }
            )
        }