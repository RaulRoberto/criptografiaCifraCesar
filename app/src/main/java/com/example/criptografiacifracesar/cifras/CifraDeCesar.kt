package com.example.criptografiacifracesar.cifras

class CifraDeCesar (var mensagem: String, var chave: Int){

    var cifrado=""
    val A=65 //cod limite minimo para alfabeto
    val Z=90 //cod limite maximo para o alfabeto
    val alfabeto=26

    fun criptografar(): String {
        var aux= ""
        var mensagem = mensagem.uppercase()
        for (x in 0..mensagem.length-1){

            if(mensagem[x].code >Z || mensagem[x].code <A){
                aux += " "
            }else if((mensagem[x].code + chave)>Z){
                aux += (mensagem[x].code - (alfabeto-chave)).toChar()
            }
            else{
                aux += (mensagem[x].code + chave).toChar()
            }

        }
//        cifrado = aux
        return aux.uppercase().toString()
    }

    fun descriptografar():String{
        var aux=""
        var mensagem = mensagem.uppercase()
        for (x in 0..mensagem.length-1){
            if(mensagem[x].code >Z || mensagem[x].code <A){
                aux += " "
            }else if((mensagem[x].code - chave)<A){
                aux += (mensagem[x].code + (alfabeto-chave)).toChar()
            }
            else{
                aux += (mensagem[x].toChar() - chave).toChar()
            }
        }
        return aux.uppercase().toString()
    }
}

