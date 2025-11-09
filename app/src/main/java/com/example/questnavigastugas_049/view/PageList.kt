package com.example.questnavigastugas_049.view

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