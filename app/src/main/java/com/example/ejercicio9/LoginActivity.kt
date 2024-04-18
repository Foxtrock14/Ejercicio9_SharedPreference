package com.example.ejercicio9

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.sax.StartElementListener
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class LoginActivity : AppCompatActivity() {
    var usuario = ""
    var pass = ""
    var sesion = false

    lateinit var edUsuario : EditText
    lateinit var edpass : EditText

    fun registrarNuevo (v: View){
        val intent = Intent(this, RegistroActivity::class.java)
        startActivity(intent)

    }

    fun autentificar(v: View){
        val usuario = edUsuario.text.toString()
        val password = edpass.text.toString()

        if(!this.usuario.equals("xxx") && usuario.equals(this.usuario) && password.equals(pass)){

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            val preferencia = getSharedPreferences("misdatos", Context.MODE_PRIVATE)
            val editor = preferencia.edit()

            editor.putBoolean("sesion", true)
            editor.commit()
            Toast.makeText(this, "Entrando", Toast.LENGTH_LONG).show()
            finish()
        }else{
            edUsuario.setError("No se encontro")
            edpass.setError("No se encontro")
        }

        Toast.makeText(this,"Se presiono" , Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginactivity)
        val preferencias = getSharedPreferences("misdatos" , Context.MODE_PRIVATE)

        usuario = preferencias.getString("usuario", "xxx").toString()
        pass = preferencias.getString("password", "xxx").toString()
        sesion = preferencias.getBoolean("sesion", false)

        if (sesion == true) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }else{

        }
        Log.w("Ejercicio 9", "El usuario registrado es ${usuario}")
        Log.w("Ejercicio 9", "Con contraseña registrada ${pass}")
        Log.w("Ejercicio 9", "Con contraseña registrada ${sesion}")
        edUsuario = findViewById(R.id.edUsuario)
        edpass = findViewById(R.id.edpass)
    }
}