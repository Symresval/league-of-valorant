package item

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import qualiteCommun
import typeArmureClassic

class ArmureTest {

    @Test
    fun calculProtection() {
        val armureetoffe = Armure ("Armure d'étoffe", "Armure basique", typeArmureClassic , qualiteCommun)
        val result = armureetoffe.calculProtection()
        println(" result = $result")

    }

}