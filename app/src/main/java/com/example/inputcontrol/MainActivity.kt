package com.example.inputcontrol

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var btnDatePicker: Button
    private lateinit var btnAlert: Button
    private lateinit var txtTanggal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Tambahkan Log bahwa aplikasi sudah berjalan
        Log.d("MainActivity", "Aplikasi dimulai dengan sukses.")

        // Inisialisasi tombol dan text view
        btnDatePicker = findViewById(R.id.btnDatePicker)
        btnAlert = findViewById(R.id.btnAlert)
        txtTanggal = findViewById(R.id.txtTanggal)

        // Event klik untuk Date Picker
        btnDatePicker.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    txtTanggal.text = selectedDate

                    // Tambahkan Log saat tanggal dipilih
                    Log.d("MainActivity", "Tanggal dipilih: $selectedDate")
                }, year, month, day)

            datePickerDialog.show()

            // Tambahkan Toast saat membuka DatePicker
            Toast.makeText(this, "Membuka Date Picker", Toast.LENGTH_SHORT).show()
        }

        // Event klik untuk Alert Dialog
        btnAlert.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Pesan Penting")
                .setMessage("Ini adalah contoh Alert Dialog!")
                .setPositiveButton("OK", null)
                .show()

            // Tambahkan Toast saat Alert ditekan
            Toast.makeText(this, "Tombol Alert ditekan", Toast.LENGTH_SHORT).show()

            // Tambahkan Log saat Alert ditampilkan
            Log.i("MainActivity", "Alert Dialog ditampilkan.")
        }
    }
}
