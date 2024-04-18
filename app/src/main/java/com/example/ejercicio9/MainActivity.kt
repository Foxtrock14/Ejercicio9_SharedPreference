package com.example.ejercicio9

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preferencias = getSharedPreferences("misdatos", Context.MODE_PRIVATE)

        val txtViewNombre = findViewById<TextView>(R.id.txtNombre)
        val txtViewCarrera = findViewById<TextView>(R.id.txtCarrera)
        val txtViewTelefono = findViewById<TextView>(R.id.txtTelefono)


        txtViewNombre.text = preferencias.getString("nombre", "xxx")
        txtViewCarrera.text = preferencias.getString("carrera", "xxx")
        txtViewTelefono.text = preferencias.getString("telefono", "xxx")



    }
    fun atras(v: View){

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        val preferencia = getSharedPreferences("misdatos", Context.MODE_PRIVATE)
        val editor = preferencia.edit()

        editor.putBoolean("sesion", false)
        editor.commit()
        Toast.makeText(this, "Atras", Toast.LENGTH_LONG).show()
        finish()

    }
    fun Modificar(v: View){

        val intent = Intent(this, ModificarActivity::class.java)
        startActivity(intent)

        Toast.makeText(this, "Entrando a modificar", Toast.LENGTH_LONG).show()


    }
}