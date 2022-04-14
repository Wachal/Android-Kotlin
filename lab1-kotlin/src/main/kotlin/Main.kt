import javax.xml.stream.events.Characters
import kotlin.random.Random

fun main(args: Array<String>) {

    val itemsList = mutableListOf<Tools>()

    fun checkIsNotEmpty(): Boolean {
        if(itemsList.isNullOrEmpty()){
            println("twoje eq jest puste")
            return false
        }else return true
    }

    fun pokazEq(){
        if(checkIsNotEmpty()){
            for(item in itemsList){
                println(item.nazwa.uppercase()+ ": " + "opis: "+item.opis + ", " + "wytrzymalosc: " + item.wytrzymalosc +
                        ", " + "licznik uzyc: " + item.licznik_uzyc + ", " + "metoda uzycia: " + item.metoda_uzycia)
            }
            println()
        }
    }

    fun addNewTool(kostka_pre: Int, liczba_uzyc_pre: Int){
        println("Jaka bron chcesz utowrzyc?: (lopata, miecz, tarcza, helm, sztylet, pierscien, buty, zbroja, kubek)")
        var playerChoice = readLine()
        var liczbaDoKostki = kostka_pre
        var liczba_uzyc = liczba_uzyc_pre
        val nowy_przedmiot = when (playerChoice){
            "lopata" -> {
                println("jaką kostką chcesz rzucic?")
                var lopata = Tools(liczbaDoKostki, "metalowa lopata", "lopata", liczba_uzyc, "do kopania")
                lopata.przedstawPrzedmiot()
                itemsList.add(lopata)
            }
            "miecz" -> {
                var miecz = Tools(liczbaDoKostki, "metalowy miecz", "miecz", liczba_uzyc, "do bicia")
                miecz.przedstawPrzedmiot()
                itemsList.add(miecz)
                println()
            }
            "tarcza" -> {
                var tarcza = Tools(liczbaDoKostki, "super tarcza", "tarcza", liczba_uzyc, "do obrony")
                tarcza.przedstawPrzedmiot()
                itemsList.add(tarcza)

                println()
            }
            "helm" -> {
                var helm = Tools(liczbaDoKostki, "mocny helm", "helm", liczba_uzyc, "do obrony glowy")
                helm.przedstawPrzedmiot()
                itemsList.add(helm)
                println()
            }
            "sztylet" -> {
                var sztylet = Tools(liczbaDoKostki, "drewniany sztylet", "sztylet", liczba_uzyc, "do dzgania")
                sztylet.przedstawPrzedmiot()
                itemsList.add(sztylet)
                println()
            }
            "pierscien" -> {
                var pierscien = Tools(liczbaDoKostki, "zloty pierscien", "pierscien", liczba_uzyc, "do obrony")
                pierscien.przedstawPrzedmiot()
                itemsList.add(pierscien)
                println()
            }
            "buty" -> {
                var buty = Tools(liczbaDoKostki, "czarne buty", "buty", liczba_uzyc, "do ubrania")
                buty.przedstawPrzedmiot()
                itemsList.add(buty)
                println()
            }
            "zbroja" -> {
                var zbroja = Tools(liczbaDoKostki, "metalowa zbroja", "zbroja", liczba_uzyc, "do ochrony")
                zbroja.przedstawPrzedmiot()
                itemsList.add(zbroja)
                println()
            }
            "kubek" -> {
                var kubek = Tools(liczbaDoKostki, "maly kubek", "kubek", liczba_uzyc, "do picia")
                kubek.przedstawPrzedmiot()
                itemsList.add(kubek)
                println()
            }
            else -> "nie ma takiej opcji\n"
        }
    }

    fun isNumber(s: String): Boolean {
        return try {
            s.toInt()
            true
        } catch (ex: NumberFormatException) {
            println("musisz podac liczbe")
            false
        }
    }

    fun rzutKostka(){
        println("jaka kostka chcesz rzucic?")
        println("mozesz wybrac liczbe od 1 do 10")
        var chosenNumber: String? = readLine()
        var randomNumber = Random.nextInt(0, 10)
        if(chosenNumber != null){
            if (isNumber(chosenNumber)){
                var playerChoice: Int = chosenNumber.toInt()
                if(playerChoice <= 10 && playerChoice >= 1){
                    var result = playerChoice * randomNumber;
                    addNewTool(result, randomNumber)
                }else{
                    println("liczba musi byc z przedzialu od 1 do 10\n")
                }
                println()
            }
        }
    }

    fun usunElement(){
        if(checkIsNotEmpty()) {
            println("co chcesz usunąć?")
            var toDelete = readLine()
            for (item in itemsList) {
                if (item.nazwa == toDelete.toString()) {
                    println("jest taki przedmiot")
                    itemsList.remove(item)
                    println("przedmiot usunięty\n")
                    return
                } else {
                    println("nie ma takiego przedmiotu w eq\n")
                }
            }
        }
    }

    fun uzyjElement(){
        if(checkIsNotEmpty()){
            println("co chcesz uzyc?")
            var doUzycia = readLine()
            for (item in itemsList){
                if( item.nazwa == doUzycia.toString()){
                    println("jest taki przedmiot")
                    var use = item.licznik_uzyc - 1
                    var resilience = item.wytrzymalosc - 5
                    item.licznik_uzyc = use
                    item.wytrzymalosc = resilience
                    println("Pozostała liczba uzyc: " + item.licznik_uzyc + "\n")
                    println("pozostala wytrzymalosc: "+ item.wytrzymalosc +"\n")
                    if(item.licznik_uzyc <= 0){
                        itemsList.remove(item)
                        println("przedmiot stracił liczbe uzyc i ulegl zniczeniu\n")
                        return
                    }
                    if(item != null){
                        if(item.wytrzymalosc <= 0){
                            itemsList.remove(item)
                            println("przedmiot stracił wytrzymalosc i ulegl zniczeniu\n")
                            return
                        }
                        return
                    }
                    return
                }else {
                    println("nie ma takiego przedmiotu w eq\n")
                }
            }
        }
    }

    while (true){
        println("co chcesz zrobic? masz do wyboru:")
        println("ekwipunek, dodaj, usun, uzyj, zakoncz")
        val wybor = readLine()
        val rezultat = when (wybor){
            "dodaj" -> rzutKostka()
            "ekwipunek" -> pokazEq()
            "usun" -> usunElement()
            "uzyj" -> uzyjElement()
            "zakoncz" -> break
            else -> "nie ma takiej opcji\n"
        }
    }
}