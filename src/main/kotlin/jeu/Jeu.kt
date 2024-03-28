package jeu

import personnage.Personnage
import epee
import armureetoffe
import lameDeDemacia
import orbedIllision
import personnage.Guerrier
import personnage.Mage
import personnage.Voleur
import piedDeBiche
import pompe


class Jeu(monstres: List<Personnage>) {
    lateinit var joueur: Personnage
     var combats: MutableList<Combat> = mutableListOf()
    var score: Int = 0

    // Corps du constructeur
    init {
        // Lancement de la création du personage du joueur
        this.creerPersonnage()
        val nom =readln()
        // Pour chaque monstre dans la liste de monstres
        for (unMonstre in monstres){
            // On créer un combat
            val unCombat= Combat(this,unMonstre)
            combats.add(unCombat)
        }
    }

    fun lancerCombat() {
        for (unCombat in this.combats) {
            unCombat.executerCombat()
            // Mettre à jour le score en fonction du nombre de tours
            val tours = unCombat.nombreTours
            score += calculerScore(tours)
        }
        println("Score final du joueur: $score")
    }

    private fun calculerScore(tours: Int): Int {
        // Par exemple, vous pouvez attribuer plus de points pour moins de tours
        return 500 - tours * 10
    }

    /**
     *  Méthode pour créer le personnage du joueur en demandant les informations à l'utilisateur
     *
     */
    fun creerPersonnage() {
        println("Choisissez votre pseudo:")
        val nom = readln()

        var hero: Personnage

        println("Voici les scores de base qui vous sont proposés:")
        println("\u001B[31m Attaque : 12 \u001B[0m")
        println("\u001B[37m Défense : 8")
        println("\u001B[33m Endurance : 8 \u001B[0m")
        println("\u001B[93m Vitesse : 12 \u001B[0m")
        println("Voulez-vous changer ces scores ? (oui/non) :")
        println()

        val choix = readLine()
        var pv=50

        if (choix?.toLowerCase() == "oui") {
            do {
                println("\u001B[1m Vous avez un total de 40 points, répartissez-les sur l'ensemble de vos capacités. \u001B[0m")
                println()
                println("\u001B[1m Vos points de vie maximum sont calculés en fonction de votre endurance. \u001B[0m")
                println()

                println("Saisissez votre score \u001B[31m \u001B[1m Attaque \u001B[0m : ")
                var attaque = readLine()?.toIntOrNull() ?: 0

                println("Saisissez votre score \u001B[37m \u001B[1m Défense \u001B[0m :")
                var defense = readLine()?.toIntOrNull() ?: 0

                println("Saisissez votre score \u001B[33m \u001B[1m Endurance \u001B[0m :")
                var endurance = readLine()?.toIntOrNull() ?: 0
                pv=pv+(10*endurance)

                println("Saisissez votre score \u001B[93m \u001B[1m Vitesse \u001B[0m :")
                var vitesse = readLine()?.toIntOrNull() ?: 0

                val totalPoints = attaque + defense + endurance + vitesse

                if (totalPoints > 40) {
                    println(" \u001B[1m Vous avez dépassé le total de 40 points. Réessayez. \u001B[0m ")
                } else {
                    hero =  Personnage(nom , pv, pv, attaque, defense, endurance, vitesse,
                        armePrincipal = epee ,
                        armure = armureetoffe,
                        inventaire = mutableListOf(),
                       ).also { hero = it }
                    this.joueur=hero
                    break
                }
            } while (totalPoints > 40)
        } else {
            hero = Personnage(nom ?: "YYY", 50, 50, 12, 8, 8, 12,
                armePrincipal = epee ,
                armure = armureetoffe,
                inventaire = mutableListOf(),
         )
            this.joueur=hero
        }

        println("Choisissez la classe de votre personnage (Maître Gims/Larab/Moudjahed) :")
        val classe = readln()

        if (classe.lowercase()=="maître gims") {
            hero = Mage(nom, 50, 50, 12, 8, 8, 12, orbedIllision, armureetoffe)
        } else if (classe.lowercase()=="larab") {
            hero = Voleur(nom, 50, 50, 12, 8, 8, 12, piedDeBiche, armureetoffe)
        } else if (classe.lowercase()=="moudjahed") {
            hero = Guerrier(nom, 50, 50, 12, 8, 8, 12, lameDeDemacia, armureetoffe, pompe)
        } else {
            // Gestion de l'erreur si l'utilisateur entre une classe invalide
            println("Classe invalide. Choisissez parmi Maître Gims, Larab ou Moudjahed.")
            return
        }

        println()
        println(this.joueur)

    }





}