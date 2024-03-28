package personnage

import item.Arme
import item.Armure
import item.Item
import item.Sort

class Mage(
    nom: String,
    pointDeVie: Int,
    pointDeVieMax: Int,
    attaque: Int,
    defense: Int,
    endurance: Int,
    vitesse: Int,
    armePrincipal: Arme?,
    armure: Armure?,
    inventaire: MutableList<Item> = mutableListOf(),
    val grimoire: MutableList<Sort> = mutableListOf(),
    var sort: Sort? = null
): Personnage(nom, pointDeVie, pointDeVieMax, attaque, defense, endurance, vitesse, armePrincipal, armure, inventaire)

{
    fun afficheGrimoire() {
        println("Grimoire du Mage")

        grimoire?.withIndex()?.forEach { (index, Sort) ->
            println("$index => ${Sort.nom}")
        }
    }

}
