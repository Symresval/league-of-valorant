package personnage

import item.Arme
import item.Armure
import item.Item

class Guerrier(
    nom: String,
    pointDeVie: Int,
    pointDeVieMax: Int,
    attaque: Int,
    defense: Int,
    endurance: Int,
    vitesse: Int,
    armePrincipal: Arme?,
    armure: Armure?,
    val armeSecondaire: Arme?,
    inventaire: MutableList<Item> = mutableListOf(),


    ) : Personnage(
    nom,
    pointDeVie,
    pointDeVieMax,
    attaque,
    defense,
    endurance,
    vitesse,
    armePrincipal,
    armure,
    inventaire
) {
    fun choixdelarme() {

        println("Vous devez choisir entre votre arme principale (&) ou votre arme secondaire (é) : ")
        val action = readLine()?.toUpperCase()

        when (action) {
            "&" -> {
                this.armePrincipal
            }

            "é" -> {
                this.armeSecondaire
            }

        }
    }
}

