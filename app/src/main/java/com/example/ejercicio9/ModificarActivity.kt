package com.example.ejercicio9

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.text.set
import com.google.android.material.textfield.TextInputLayout

class ModificarActivity : AppCompatActivity() {

    lateinit var layout4: TextInputLayout
    lateinit var layout5: TextInputLayout
    lateinit var layout6: TextInputLayout

    lateinit var edNombre : EditText
    lateinit var edCarrera : EditText
    lateinit var edTelefono : EditText


    var nom = ""
    var car = ""
    var tele = ""
    var sesion = false

    fun Modificar (v: View) {


        val nuevonom = edNombre.text.toString()
        val nuevocar = edCarrera.text.toString()
        val nuevotel = edTelefono.text.toString()


        if (nuevonom == "") {
            layout4.setError("Rellene el campo")
        } else if (nuevocar == "") {
            layout5.setError("Rellene el campo")
        } else if (nuevotel == "") {
            layout6.setError("Rellene el campo")
        } else {


            Log.w("Modificado los datos", "Todos mis datos estan correctos")
            val preferencia = getSharedPreferences("misdatos", Context.MODE_PRIVATE)
            val editor = preferencia.edit()

            editor.putString("nombre", nuevonom)
            editor.putString("carrera", nuevocar)
            editor.putString("telefono", nuevotel)
            editor.putBoolean("sesion", false)
            editor.commit()
            Toast.makeText(this, "Se guardo el usuario", Toast.LENGTH_LONG).show()
            finish()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            Log.w("Modificado", "El usuario registrado es ${nuevonom}")
            Log.w("Modificado ", "Con Carrera registrada ${nuevocar}")
            Log.w("Modificado ", "Con telefono registrada ${nuevotel}")

        }


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificar)



        layout4 = findViewById(R.id.tl4)
        layout5 = findViewById(R.id.tl5)
        layout6 = findViewById(R.id.tl6)


        edNombre = findViewById(R.id.edNombre)
        edCarrera = findViewById(R.id.edCarrera)
        edTelefono = findViewById(R.id.edTelefono)

        val preferencias = getSharedPreferences("misdatos" , Context.MODE_PRIVATE)


        nom = preferencias.getString("nombre", "xxx").toString()
        car = preferencias.getString("carrera", "xxx").toString()
        tele = preferencias.getString("telefono", "xxx").toString()
        sesion = preferencias.getBoolean("sesion", false)


        edNombre.setText(nom)
        edCarrera.setText(car)
        edTelefono.setText(tele)
    }
}