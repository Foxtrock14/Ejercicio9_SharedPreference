package com.example.ejercicio9

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class RegistroActivity : AppCompatActivity() {

    lateinit var layout1 : TextInputLayout
    lateinit var layout2: TextInputLayout
    lateinit var layout3: TextInputLayout
    lateinit var layout4: TextInputLayout
    lateinit var layout5: TextInputLayout
    lateinit var layout6: TextInputLayout
    lateinit var edUsuario : EditText
    lateinit var edPassword : EditText
    lateinit var edPassword2 : EditText
    lateinit var edNombre : EditText
    lateinit var edCarrera : EditText
    lateinit var edTelefono : EditText



    fun vacio (v: View) {


        val usuario = edUsuario.text.toString()
        val pass = edPassword.text.toString()
        val pass2 = edPassword2.text.toString()
        val nom = edNombre.text.toString()
        val car = edCarrera.text.toString()
        val tele = edTelefono.text.toString()




        if (usuario == "") {
            layout1.setError("Rellene el campo")
        } else if (pass == "") {
            layout2.setError("Rellene el campo")
        } else if (pass2 == "") {
            layout3.setError("Rellene el campo")
        } else if (pass2 != pass) {
            layout3.setError("Contraseña no coincide")
            edPassword2.text = null
        } else if (nom == "") {
            layout4.setError("Rellene el campo")
        } else if (car == "") {
            layout5.setError("Rellene el campo")
        } else if (tele == "") {
            layout6.setError("Rellene el campo")
        } else {

            Log.w("Ejercicio 9", "Todos mis datos estan correctos")
            val preferencia = getSharedPreferences("misdatos", Context.MODE_PRIVATE)
            val editor = preferencia.edit()
            editor.putString("usuario", usuario)
            editor.putString("password", pass)
            editor.putString("nombre", nom)
            editor.putString("carrera", car)
            editor.putString("telefono", tele)
            editor.putBoolean("sesion", false)
            editor.commit()
            Toast.makeText(this, "Se guardo el usuario", Toast.LENGTH_LONG).show()
            finish()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            Log.w("Modificado", "El usuario registrado es ${usuario}")
            Log.w("Modificado ", "Con Contraseña registrada ${pass}")
            Log.w("Modificado ", "Con telefono registrada ${tele}")
        }


    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        layout1 = findViewById(R.id.tl1)
        layout2 = findViewById(R.id.tl2)
        layout3 = findViewById(R.id.tl3)
        layout4 = findViewById(R.id.tl4)
        layout5 = findViewById(R.id.tl5)
        layout6 = findViewById(R.id.tl6)

        edUsuario = findViewById(R.id.edUsuario)
        edPassword = findViewById(R.id.edPassword)
        edPassword2 = findViewById(R.id.edPassword2)
        edNombre = findViewById(R.id.edNombre)
        edCarrera = findViewById(R.id.edCarrera)
        edTelefono = findViewById(R.id.edTelefono)

    }
}