package item

import armureetoffe
import epee
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import personnage.Personnage

class BombeConstructorTest {

    @Test
    fun utiliser() {
        val bombe = Bombe ("Spike", 1, 5, "Dispositif explosif")
        val Troll = Personnage(
            "\u001B[32m \u001B[1m Trundle le Roi des Trolls \u001B[0m ",
            pointDeVie = 20,
            pointDeVieMax = 20,
            attaque = 10,
            defense = 4,
            vitesse = 11,
            endurance = 6,
            armePrincipal = epee,
            armure = armureetoffe,

        )
        bombe.utiliser(Troll)
        val result = 20 - Troll.pointDeVie

        println(" result = $result")
        Assertions.assertTrue( result>= 1)
        Assertions.assertTrue(result <= 3)
    }
}