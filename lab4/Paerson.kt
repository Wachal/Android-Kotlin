package com.example.lab3

import java.util.*

class Person (name_par: String, nameOwner_par: String, nameCreator_par: String ) {
    var name = name_par;
    var nameOwner = nameOwner_par;
    var nameCreator = nameCreator_par;

    fun personName(): String{
        return name;
    }

    fun returnDesription(): String{
        return  nameOwner + " and " + nameCreator;
    }

}
