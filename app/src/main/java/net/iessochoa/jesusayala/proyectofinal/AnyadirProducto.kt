package net.iessochoa.jesusayala.proyectofinal

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.EditText
import android.widget.ImageView

class AnyadirProducto : AppCompatActivity() {

    //DECLARO VARIABLES
    private lateinit var etNombreProducto: EditText
    private lateinit var etDescripcionProducto: EditText
    private lateinit var ivProducto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anyadir_producto)

        //UNO LAS VARIABLES CON LOS CORRESPONDIENTES COMPONENTES
        etNombreProducto = findViewById(R.id.etNombreProducto)
        etDescripcionProducto = findViewById(R.id.etDescripcionProducto)
        ivProducto = findViewById(R.id.ivProducto)

        //BAJO LA IMAGEN POR DEFECTO Y LA HAGO PEQUEÑA
        val BMoriginalImagenproducto = BitmapFactory.decodeResource(resources, R.drawable.imagenproducto)
        val BMescaladoImagenproducto = Bitmap.createScaledBitmap(BMoriginalImagenproducto, 400, 400, false)

        //APLICO LA IMAGEN POR DEFECTO
        ivProducto.setImageBitmap(BMescaladoImagenproducto)

        //ABRE LA GALERÍA PARA ELEGIR UNA IMAGEN DEL PRODUCTO
        ivProducto.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, REQUEST_CODE_GALLERY)
        }
    }

    //ESCALA EL TAMAÑO DE LA IMAGEN AÑADIDA
    private fun cambiarTamañoImagen(uri: Uri) {
        val inputStream = contentResolver.openInputStream(uri)
        val originalBitmap = BitmapFactory.decodeStream(inputStream)
        val scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, 400, 400, false)
        ivProducto.setImageBitmap(scaledBitmap)
    }

    private val REQUEST_CODE_GALLERY = 1

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_GALLERY && resultCode == Activity.RESULT_OK) {
            val uri = data?.data
            if (uri != null) {
                cambiarTamañoImagen(uri)
            }
        }
    }


}