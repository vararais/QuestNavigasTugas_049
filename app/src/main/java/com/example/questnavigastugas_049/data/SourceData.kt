package com.example.questnavigastugas_049.data

data class FormData(
    val nama: String,
    val gender: String,
    val status: String,
    val alamat: String
)

object DataSource {
    val dataList = listOf(

        FormData(
            nama = "Asep Kopling",
            gender = "Laki - Laki",
            status = "Cerai",
            alamat = "Sleman"
        ),


        FormData(
            nama = "Widya Tali Gas",
            gender = "Perempuan",
            status = "Lajang",
            alamat = "Bantul"
        ),


        FormData(
            nama = "Asroni Stecu",
            gender = "Laki - Laki",
            status = "Kawin",
            alamat = "Jogja"
        ),


        FormData(
            nama = "Pur Skep",
            gender = "Laki - Laki",
            status = "Lajang",
            alamat = "Bantul"
        ),


        FormData(
            nama = "Putri Noken",
            gender = "Perempuan",
            status = "Kawin",
            alamat = "Sleman"
        ),


        FormData(
            nama = "Budi Josjis",
            gender = "Laki - Laki",
            status = "Lajang",
            alamat = "Gunungkidul"
        ),


        FormData(
            nama = "Siti Santun",
            gender = "Perempuan",
            status = "Cerai",
            alamat = "Kulon Progo"
        ),


        FormData(
            nama = "Ahmad M Top",
            gender = "Laki - Laki",
            status = "Kawin",
            alamat = "Jogja"
        ),


        FormData(
            nama = "Dewi Shantikok",
            gender = "Perempuan",
            status = "Lajang",
            alamat = "Bantul"
        ),


        FormData(
            nama = "Eko Velocity",
            gender = "Laki - Laki",
            status = "Lajang",
            alamat = "Sleman"
        )
    )
}