package com.example.questnavigastugas_049.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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