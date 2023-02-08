package net.iessochoa.jesusayala.proyectofinal

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView

class AnyadirProducto : AppCompatActivity() {

    //DECLARO VARIABLES
    private lateinit var nombreProducto: EditText
    private lateinit var descripcionProducto: EditText
    private lateinit var imagenProducto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anyadir_producto)

        //UNO LAS VARIABLES CON LOS CORRESPONDIENTES COMPONENTES
        nombreProducto = findViewById(R.id.etNombreProducto)
        descripcionProducto = findViewById(R.id.etDescripcionProducto)
        imagenProducto = findViewById(R.id.ivProducto)

        //ABRE LA GALERÍA PARA ELEGIR UNA IMAGEN DEL PRODUCTO
        imagenProducto.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, IMAGE_PICK_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            imagenProducto.setImageURI(data?.data)
        }
    }

    companion object {
        private const val IMAGE_PICK_CODE = 1000
    }


}