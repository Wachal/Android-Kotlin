class Tools (wytrzymalosc_par: Int, opis_par: String, nazwa_par: String, licznik_uzyc_par: Int, metoda_uzycia_par: String) {

    var wytrzymalosc = wytrzymalosc_par;
    val opis = opis_par;
    val nazwa = nazwa_par;
    var licznik_uzyc = licznik_uzyc_par;
    val metoda_uzycia = metoda_uzycia_par;

    fun przedstawPrzedmiot(){
        println("Utworzyles nowy przedmiot:")
        println("jego wytrzymalosc to: $wytrzymalosc")
        println("Opis przedmiotu: $opis")
        println("Nazwa przedmiotu: $nazwa")
        println("Liczba uzyc: $licznik_uzyc")
        println("Metoda uzyca: $metoda_uzycia")
    }



}