package net.iessochoa.jesusayala.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PantallaPrincipalVendedor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_principal_vendedor)

        // Botón Ver mis productos
        val btVerProductos = findViewById<Button>(R.id.btVerProductos)
        btVerProductos.setOnClickListener {
            val intent = Intent(this, AnyadirProducto::class.java)
            startActivity(intent)
        }

        // Botón Añadir producto
        val btAñadirProducto = findViewById<Button>(R.id.btAñadirProducto)
        btAñadirProducto.setOnClickListener {
            val intent = Intent(this, AnyadirProducto::class.java)
            startActivity(intent)
        }

        // Botón Ver pedidos
        val btVerPedidos = findViewById<Button>(R.id.btVerPedidos)
        btVerPedidos.setOnClickListener {
            val intent = Intent(this, AnyadirProducto::class.java)
            startActivity(intent)
        }

    }
}