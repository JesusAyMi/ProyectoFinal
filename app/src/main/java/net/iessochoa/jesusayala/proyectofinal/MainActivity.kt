package net.iessochoa.jesusayala.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ABRE EL ACTIVITY REGISTRAR
        val btRegistrarse = findViewById<Button>(R.id.btRegistrarse)
        btRegistrarse.setOnClickListener {
            val intent = Intent(this, Registrarse::class.java)
            startActivity(intent)
        }

        //ABRE EL ACTIVITY INICIAR SESIÓN
        val btIniciarSesion = findViewById<Button>(R.id.btIniciarSesion)
        btIniciarSesion.setOnClickListener {
            val intent = Intent(this, IniciarSesion::class.java)
            startActivity(intent)
        }

    }
}