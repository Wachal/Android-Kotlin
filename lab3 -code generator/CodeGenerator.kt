package com.example.aplikacja_lab2

import java.util.*

class CodeGenerator (codeChoice_par: String, userText_par: String ) {

    var codeChoice = codeChoice_par;
    var userText = userText_par

    fun code1(userString_par: String): String {
        var userString = userString_par
        var code = ""
        var stringsArray = arrayOf("asdf", "sdfsf", "ghtjv", "fgds", "dfgds", "dsfs", "cxvb", "ertyu", "uiukn")

        for(i in 0..userString.length-1){
            code += userString[i] + stringsArray[i]
        }
        return code
    }

    fun code2(userString_par: String): String {
        var userString = userString_par
        var code = ""
        var charsArray = arrayOf("a", "f", "t", "d", "g", "s", "b", "u", "k")

        for(i in 0..userString.length-1){
            code += userString[i]+charsArray[i]
        }

        return code.uppercase().reversed()
    }

    fun code3(userString_par: String): String {
        var userString = userString_par
        val encoder: Base64.Encoder = Base64.getEncoder()
        val encoded: String = encoder.encodeToString(userString.toByteArray())
        return encoded
    }

    fun wrong(): String {
        return "something wrong!"
    }

    var result = when (codeChoice){
        "szyfr1" -> code1(userText)
        "szyfr2" -> code2(userText)
        "szyfr3" -> code3(userText)
        else -> wrong()
    }
}
