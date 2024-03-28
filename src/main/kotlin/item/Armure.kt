package item
import personnage.Personnage

class Armure (nom: String, description: String, val typeArmure: TypeArmure, var qualite: Qualite):Item(nom,description)


{

    fun calculProtection(): Int {
        val additionProtection = this.typeArmure.bonus + this.qualite.bonusRarete
        return additionProtection
    }
}
