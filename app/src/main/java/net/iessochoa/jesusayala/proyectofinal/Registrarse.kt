package net.iessochoa.jesusayala.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Registrarse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)

        //DECLARO VARIABLES DE LOS EDIT TEXT
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etLocalidad = findViewById<EditText>(R.id.etLocalidad)
        val etDomicilio = findViewById<EditText>(R.id.etDomicilio)
        val etCorreoElectrónico = findViewById<EditText>(R.id.etCorreoElectronico)
        val etContraseña = findViewById<EditText>(R.id.etContraseña)
        var pantalla = "pantallaX"

        //FUNCIÓN QUE COMPRUEBE QUE LOS CAMPOS ESTÉN CORRECTAMENTE RELLENADOS
        fun onRegistrarseClick() {
            val name = etNombre.text.toString().trim()
            val location = etLocalidad.text.toString().trim()
            val address = etDomicilio.text.toString().trim()
            val email = etCorreoElectrónico.text.toString().trim()
            val password = etContraseña.text.toString().trim()

            if (name.isEmpty() || location.isEmpty() || address.isEmpty() || email.isEmpty() || password.isEmpty()) {
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

        //ABRE EL ACTIVITY PANTALLA PRINCIPAL COMPRADOR
        val btRegistrarComprador = findViewById<Button>(R.id.btRegistrarComprador)
        btRegistrarComprador.setOnClickListener {
            pantalla = "PantallaPrincipalComprador"
            onRegistrarseClick()
        }

        //ABRE EL ACTIVITY PANTALLA PRINCIPAL COMPRADOR
        val btRegistrarVendedor = findViewById<Button>(R.id.btRegistrarVendedor)
        btRegistrarVendedor.setOnClickListener {
            pantalla = "PantallaPrincipalVendedor"
            onRegistrarseClick()
        }

    }
}