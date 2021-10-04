package com.example.criptografiacifracesar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.core.view.get
import com.example.criptografiacifracesar.cifras.CifraDeCesar

class MainActivity : AppCompatActivity() {

    lateinit var texto: EditText
    lateinit var opcao : Spinner
    lateinit var botao : Button
    lateinit var chave : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        botao = findViewById(R.id.btnConvert)
        botao.setOnClickListener {
            //Toast.makeText(applicationContext,opcoes[opcao.selectedItem.toString()],Toast.LENGTH_LONG).show()
            cripto()
        }
    }
    fun cripto(){

        var opcoes = arrayOf("Criptografar","Descriptografar")

        opcao.adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,opcoes)
        texto = findViewById(R.id.txtTexto)
        opcao = findViewById(R.id.spnOpc)

        chave = findViewById(R.id.txtChave)


        val texto1 = texto.text.toString()
        val opcao = opcao.toString().toInt()
        val chave = chave.text.toString().toInt()

        val cifrar = CifraDeCesar(texto1, chave)


//        val vtexto =a.criptografar(texto.text.toString(),chave.text.toString().toInt())
//        val vtexto2=a.descriptografar(texto.text.toString(),chave.text.toString().toInt())

        if(opcao == 0){
            Toast.makeText(applicationContext,"Texto criptografado!!",Toast.LENGTH_SHORT).show();
            texto.text= cifrar.criptografar()
        }else if(opcao==1){
            Toast.makeText(applicationContext,"Texto descriptografado!!",Toast.LENGTH_SHORT).show();
            texto.text= cifrar.descriptografar()
        }
    }
}