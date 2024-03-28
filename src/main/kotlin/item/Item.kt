package item

import personnage.Personnage

open class Item  (val nom: String, val description: String) {
    open fun utiliser(cible: Personnage) {
        println("$nom ne peut pas être utilisé.")
    }

    fun toSting(): String {
        return "${nom} (nom='$nom', description='$description')"
    }

}