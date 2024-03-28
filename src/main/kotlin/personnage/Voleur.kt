package personnage

import item.Arme
import item.Armure
import item.Item

class Voleur (nom: String,
              pointDeVie: Int,
              pointDeVieMax: Int,
              attaque: Int,
              defense: Int,
              endurance: Int,
              vitesse: Int,
              armePrincipal: Arme?,
              armure: Armure?,
              inventaire: MutableList<Item> = mutableListOf(),
             ):Personnage(nom, pointDeVie, pointDeVieMax, attaque, defense, endurance, vitesse, armePrincipal, armure, inventaire)

{
    fun vole(voleur: Personnage, victime: Personnage) {
        if (victime.inventaire.isNotEmpty()) {
            val randomChance = (0..99).random()

            if (randomChance < 80) {
                val indexItemVictime = (0 until victime.inventaire.size).random()

                val objetVictime = victime.inventaire[indexItemVictime]

                val indexItemVoleur = (0 until voleur.inventaire.size).random()

                val objetVoleur = voleur.inventaire[indexItemVoleur]

                voleur.inventaire[indexItemVoleur] = objetVictime
                victime.inventaire[indexItemVictime] = objetVoleur

                println("${voleur.nom} a réussi à voler ${objetVictime} à ${victime.nom} et a laissé ${objetVoleur} en échange.")
            } else {
                println("${voleur.nom} a essayé de voler ${victime.nom}, mais a échoué.")
            }
        } else {
            println("${victime.nom} n'a rien à voler.")
        }
    }


}