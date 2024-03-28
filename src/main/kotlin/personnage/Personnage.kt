package personnage

import item.*


open class Personnage(
    open val nom: String,
    var pointDeVie: Int,
    val pointDeVieMax: Int,
    var attaque: Int,
    var defense: Int,
    var endurance: Int,
    var vitesse: Int,
    var armePrincipal: Arme?,
    var armure: Armure?,
    val inventaire: MutableList<Item> = mutableListOf(),


    ) {

    fun equipeArme(arme: Arme) {

        if (inventaire?.contains(arme) == true) {

            this.armePrincipal = arme
            println("$nom équipe ${arme.nom}")
        } else {
            println("$nom ne peut pas équiper ${arme.nom} car il ne l'a pas dans son inventaire.")
        }
    }

    fun equipeArmure(armure: Armure) {

        if (inventaire?.contains(armure) == true) {

            this.armure = armure
            println("$nom équipe ${armure.nom}")
        } else {
            println("$nom ne peut pas équiper ${armure.nom} car il ne l'a pas dans son inventaire.")
        }
    }


    fun calculTotalDefense(): Int {
        val defenseDeBase = this.defense / 2

        if (this.armure != null) {
            val bonusProtection = this.armure!!.calculProtection()
            return defenseDeBase + bonusProtection
        } else {

            return defenseDeBase
        }
    }


    // Méthode pour attaquer un adversaire

    fun attaque(adversaire: Personnage) {
        val degatsDeBase = this.attaque / 2


        if (this.armePrincipal != null) {
            val degatsArme = this.armePrincipal!!.calculDegat()
            val degatsTotal = degatsDeBase + degatsArme


            val degatsInfliges = maxOf(1, degatsTotal - adversaire.defense)

            adversaire.pointDeVie -= degatsInfliges
            println("$nom attaque ${adversaire.nom} avec une attaque de base et inflige $degatsInfliges points de dégâts.")
        } else {
            // Ajuster les dégâts de base en fonction de la défense de l'adversaire (minimum 1 point de dégât)
            val degatsInfliges = maxOf(1, degatsDeBase - adversaire.defense)

            adversaire.pointDeVie -= degatsInfliges
            println("$nom attaque ${adversaire.nom} avec une attaque de base et inflige $degatsInfliges points de dégâts.")
        }
    }

    override fun toString(): String {
        return "$nom (PV: $pointDeVie/$pointDeVieMax, Attaque: $attaque, Défense: $defense, Endurance: $endurance, Vitesse: $vitesse)"
    }

    fun popo(): Boolean {
        for (item in this.inventaire!!) {
            if (item is Potion) {
                return true
            }
        }
        return false
    }
    fun spike(): Boolean {
        for (item in this.inventaire!!) {
            if (item is Bombe) {
                return true
            }
        }
        return false
    }

    fun boirePotion() {

        val potion = inventaire?.find { it is Potion } as? Potion

        if (potion != null) {
            val montantSoin = potion.soin

            pointDeVie += montantSoin

            if (pointDeVie > pointDeVieMax) {
                pointDeVie = pointDeVieMax
            }

            inventaire?.remove(potion)

            println("$nom boit une ${potion.nom} et récupère $montantSoin points de vie. " +
                    "Il reste $pointDeVie pv")
        } else {
            println("$nom n'a pas de potion dans son inventaire.")
        }
    }

    fun afficheInventaire() {
        println("Inventaire de $nom:")

        inventaire?.withIndex()?.forEach { (index, item) ->
            println("$index => ${item.nom}")
        }
    }

    fun loot(cible: Personnage) {

        if (cible.pointDeVie <= 0) {

            cible.armePrincipal = null

            cible.armure = null

            inventaire?.addAll(cible.inventaire.orEmpty())

            cible.inventaire?.clear()
        }
    }
}






