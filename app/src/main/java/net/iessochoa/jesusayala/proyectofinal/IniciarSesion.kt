package net.iessochoa.jesusayala.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class IniciarSesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion)

        //DECLARO VARIABLES DE LOS EDIT TEXT
        val etCorreoElectronicoInicio = findViewById<EditText>(R.id.etCorreoElectronicoInicio)
        val etContraseñaInicio = findViewById<EditText>(R.id.etContraseñaInicio)
        var pantalla = "pantallaX"

        //FUNCIÓN QUE COMPRUEBE QUE LOS CAMPOS ESTÉN CORRECTAMENTE RELLENADOS
        fun onRegistrarseClick() {
            val name = etContraseñaInicio.text.toString().trim()
            val email = etCorreoElectronicoInicio.text.toString().trim()

            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Por favor, rellene todos los campos", Toast.LENGTH_SHORT).show()
                return
            }

            // valida si el email es correcto
            val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
            if (!email.matches(emailPattern)) {
                Toast.makeText(this, "Por favor, ingrese un correo electrónico válido", Toast.LENGTH_SHORT).show()
                return
            }

            // si todos los campos están correctamente rellenos, pasa a la siguiente pantalla
            if (pantalla == "PantallaPrincipalComprador") {
                val intent = Intent(this, PantallaPrincipalComprador::class.java)
                startActivity(intent)
            } else if (pantalla == "PantallaPrincipalVendedor") {
                val intent = Intent(this, PantallaPrincipalVendedor::class.java)
                startActivity(intent)
            }

        }

        //ABRE EL ACTIVITY PANTALLA PRINCIPAL
        val btInicioSesion = findViewById<Button>(R.id.btInicioSesion)
        btInicioSesion.setOnClickListener {
            pantalla = "PantallaPrincipalVendedor"
            onRegistrarseClick()
        }

    }
}