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

    lateinit var texto: TextView
    lateinit var opcao : Spinner
    lateinit var botao : Button
    lateinit var chave : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        texto = findViewById(R.id.txtTexto)
        opcao = findViewById(R.id.spnOpc)
        botao = findViewById(R.id.btnConvert)
        chave = findViewById(R.id.txtChave)
        var a = CifraDeCesar("",0)
        var opcoes = arrayOf("Criptografar","Descriptografar")

        opcao.adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,opcoes)
        texto.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                a.text=texto.text.toString()
                //adicionar testes para validação de letras inválidas
            }

            override fun afterTextChanged(p0: Editable?) {
                a.text=texto.text.toString()
            }
        })
        chave.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                a.chave=chave.text.toString().toInt()
            }

        })


        botao.setOnClickListener {
            //Toast.makeText(applicationContext,opcoes[opcao.selectedItem.toString()],Toast.LENGTH_LONG).show()

//            print(opcao.selectedItemPosition.toString())
            if(opcao.selectedItemPosition.toString() == opcoes[0]){
                Toast.makeText(applicationContext,"Texto criptografado!!",Toast.LENGTH_SHORT).show()
                texto.text=a.criptografar()
            }else if(opcao.selectedItemPosition.toString()==opcoes[1]){
                Toast.makeText(applicationContext,"Texto descriptografado!!",Toast.LENGTH_SHORT).show()
                texto.text=a.descriptografar()

            }

        }
    }
}