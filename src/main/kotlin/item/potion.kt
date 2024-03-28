package item

import personnage.Personnage

class Potion(var soin: Int, nom: String, description: String):Item (nom, description)

fun utiliser(cible: Personnage) {
    cible.boirePotion()
}

