package com.example.formulario

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import android.widget.CheckBox

import androidx.appcompat.app.AlertDialog
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    //Creacion de las variables Globales

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //CREACION DE LA VARIABLE SPINNER
        val spinner: Spinner = findViewById(R.id.carreraspinner)
        ArrayAdapter.createFromResource(this,R.array.carreras,android.R.layout.simple_spinner_item).also {
            adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            spinner.adapter = adapter }

        var nombre: EditText = findViewById(R.id.nombreEt)
        var edad: EditText = findViewById(R.id.edad)
        var aceptar: Button = findViewById(R.id.aceptar)
        var genero: CheckBox = findViewById(R.id.genero)
        var genero2: CheckBox = findViewById(R.id.genero2)
        var limpiar: Button = findViewById(R.id.limpiar)


        aceptar.setOnClickListener {
            // Validar que se haya ingresado un nombre
            if (nombre.text.toString().isEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle("¡¡¡ERROR!!!")
                    .setMessage("No se ha ingresado un valor o nombre")
                    .show()
                return@setOnClickListener
            }

            // Construir el mensaje a mostrar
            val opcionesSeleccionadas = StringBuilder()
            opcionesSeleccionadas.append("Nombre: ${nombre.text}\n")
            opcionesSeleccionadas.append("Edad: ${edad.text}\n")

            // Verificar género seleccionado
            opcionesSeleccionadas.append("Género: ")
            if (genero.isChecked) {
                opcionesSeleccionadas.append("Masculino\n")
            } else if (genero2.isChecked) {
                opcionesSeleccionadas.append("Femenino\n")
            } else {
                opcionesSeleccionadas.append("No especificado\n")
            }

            // Obtener carrera seleccionada del spinner
            val carreraSeleccionada = spinner.selectedItem.toString()
            opcionesSeleccionadas.append("Carrera: $carreraSeleccionada")

            // Mostrar alerta con las opciones seleccionadas
            AlertDialog.Builder(this)
                .setTitle("Opciones Seleccionadas")
                .setMessage(opcionesSeleccionadas.toString())
                .setPositiveButton("Aceptar", null)
                .show()
        }


    }//Termina el metodo oncreate


}//Fin programa