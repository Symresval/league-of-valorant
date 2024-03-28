package jeu

import item.Bombe
import personnage.Personnage
import kotlin.random.Random

class Combat(
    val jeu :Jeu,
    val monstre: Personnage
) {
    var nombreTours: Int = 1

    // Méthode pour simuler un tour de combat du joueur
    fun tourDeJoueur() {
        println("\u001B[34m --- C'est votre tour ${this.jeu.joueur.nom} ! (pv: ${this.jeu.joueur.pointDeVie}) ---")

        println("Vous devez choisir entre Attaquer (A), utiliser un objet (U) ou passer votre tour (P) : ")
        val action = readLine()?.toUpperCase()

        when (action) {
            "A" -> {
                this.jeu.joueur.attaque(monstre)
            }
            "P" -> {
                println("Vous avez décidé de passer votre tour.")
            }
            "I" -> {

                this.jeu.joueur.afficheInventaire()


                println("Choisissez un objet dans votre inventaire en entrant son index (0 pour annuler) : ")
                val indexObjet = readln()

                if (indexObjet != null && indexObjet >= 0.toString() && indexObjet < this.jeu.joueur.inventaire!!.size.toString()) {

                    this.jeu.joueur.afficheInventaire()
                    println("Selectionnez un item")
                    val selection:Int = readln().toInt()
                    val objet= this.jeu.joueur.inventaire[selection]
                    if (objet is Bombe){
                        objet.utiliser(monstre)
                    }
                    else {

                        println("Saisie invalide ou annulée.")
                    }
                    objet.utiliser(this.jeu.joueur)


                }
            }
            else -> {
                println("Commande non reconnue. Veuillez choisir entre Attaquer (A), utiliser un objet (U) ou passer votre tour (P).")
            }
        }

        println("\u001b[0m")
    }



    // Méthode pour simuler un tour de combat du monstre
    fun tourDeMonstre() {
        println("\u001B[31m \u001B[1m---Tour de ${monstre.nom} (pv: ${monstre.pointDeVie}) ---")
        //TODO Mission 1.3

        val randomDiceRoll = Random.nextInt(1, 101)

        if (randomDiceRoll <= 70) {

            monstre.attaque(jeu.joueur)
        } else {

            println("${monstre.nom} passe son tour.")


            if (monstre.pointDeVie < monstre.pointDeVieMax / 2) {

                val chancePotion = Random.nextInt(1, 11)


                if (chancePotion == 1) {
                    monstre.boirePotion()
                    println("${monstre.nom} boit une potion.")
                }
            }
        }
        println("\u001b[0m")
    }


    // Méthode pour exécuter le combat complet
    fun executerCombat() {
        println("Début du combat : ${this.jeu.joueur.nom} vs ${monstre.nom}")
        //La vitesse indique qui commence
        var tourJoueur = this.jeu.joueur.vitesse >= this.monstre.vitesse
        //Tant que le joueur et le monstre sont vivants
        while (this.jeu.joueur.pointDeVie > 0 && monstre.pointDeVie > 0) {
            println("Tours de jeu : ${nombreTours}")
            if (tourJoueur) {
                tourDeJoueur()
            } else {
                tourDeMonstre()
            }
            nombreTours++
            tourJoueur = !tourJoueur // Alternance des tours entre le joueur et le monstre
            println("${this.jeu.joueur.nom}: ${this.jeu.joueur.pointDeVie} points de vie | ${monstre.nom}: ${monstre.pointDeVie} points de vie")
            println("")
        }

        if (this.jeu.joueur.pointDeVie <= 0) {
            println("Game over ! ${this.jeu.joueur.nom} a été vaincu !")
            println("Le combat recommence")

            this.jeu.joueur.pointDeVie = this.jeu.joueur.pointDeVieMax
            this.monstre.pointDeVie = this.monstre.pointDeVieMax
            this.executerCombat()
        } else {
            println("BRAVO ! ${monstre.nom} a été vaincu !")
        }
    }
}