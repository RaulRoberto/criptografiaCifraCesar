package com.example.criptografiacifracesar.cifras

import java.util.*

class CifraDeCesar (texto: String,chav: Int){
    //  deixando o texto totalmente em uppercase;
    var text= texto.uppercase(Locale.getDefault())
    var chave = chav

//  variavel para já utilizar a função de descriptografar sem
//  necessidade de passar parâmetros

    var cifrado=""
    val A=65 //cod limite minimo para alfabeto
    val Z=90 //cod limite maximo para o alfabeto
    val alfabeto=26

    fun criptografar(): String {
        var aux= ""
        for (x in 0..text.length-1){

            if(text[x].code >Z || text[x].code <A){
                aux += " "
            }else if((text[x].code + chave)>Z){
                aux += (text[x].code - (alfabeto-chave)).toChar()
            }
            else{
                aux += (text[x].code + chave).toChar()
            }

        }
        cifrado = aux
        return aux.toString()
    }

    fun descriptografar():String{
        var aux=""
        for (x in 0..cifrado.length-1){
            if(cifrado[x].code >Z || text[x].code <A){
                aux += " "
            }else if((cifrado[x].code - chave)<A){
                aux += (cifrado[x].code + (alfabeto-chave)).toChar()
            }
            else{
                aux += (cifrado[x].toChar() - chave).toChar()
            }
        }
        return aux.toString()
    }
}

