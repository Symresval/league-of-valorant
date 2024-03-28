package item

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions
import qualiteLegendaire
import typeCourtePorte


class ArmeTest {

    @Test
    fun calculDegat() {
        val hacheDeGuerre = Arme( "Hache De Guerre", "Seuls les dieux héritent de cette hache !", typeCourtePorte, qualiteLegendaire )
        val result = hacheDeGuerre.calculDegat()
        println(" result = $result")
        Assertions.assertTrue(result >= 3)
        Assertions.assertTrue(result <= 27)
    }
}