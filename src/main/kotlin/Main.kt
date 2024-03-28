import item.*
import jeu.Jeu
import personnage.Personnage

//instanciation des qualités des objets
val qualiteCommun = Qualite("commun", 0, "\u001B[32m")
val qualiteRare = Qualite("rare", 1, couleur = "\u001B[34m")
val qualiteEpic = Qualite("epic", 2, "\u001B[35m")
val qualiteLegendaire = Qualite("legendaire", 3, "\u001B[33m")

val typeCourtePorte = TypeArme ( "Epee Longue", 1, 2, 5, 15)
val typePompe = TypeArme ("Shorty", 1, 4, 4, 16)
val typeAR = TypeArme ("Vandal", 1, 7, 3, 17)
val typeSnipe = TypeArme ("Operator", 1, 10, 2, 18)
val typeOrbe = TypeArme ("Orbe", 1, 10, 2, 15)

//Instantiation des Types Armes

val typeArmureClassic = TypeArmure ("Armure classic", "+10",10)
val typeArmureRare= TypeArmure ("Armure rare", "+15",15)
val typeArmureEpic = TypeArmure ("Armure épic", "+20",20)
val typeArmureLegendaire = TypeArmure ("Armure légendaire", "+25",25)

//Instantiation des Armes

val epee = Arme ("Epee Longue", "Epee Longue de premier niveau", typeCourtePorte, qualiteCommun)
val pompe = Arme ("Shorty", "Shorty le petit pompe", typePompe, qualiteRare)
val aR = Arme ("Vandal", "Arme principal à rafale ", typeAR, qualiteEpic)
val sniper = Arme ("Operator", "Arme de longue distance", typeSnipe, qualiteLegendaire)
val hacheDeGuerre = Arme( "Hache De Guerre", "Seuls les dieux héritent de cette hache !", typeCourtePorte, qualiteLegendaire)
val piedDeBiche = Arme ("Pied De Biche", "Faites attention à vos poches", typeCourtePorte, qualiteRare)
val orbedIllision = Arme( "Orbe d'Illusion", "Orbe d'Ahri", typeOrbe, qualiteRare )
val lameDeDemacia = Arme( "Lame de Demacia", "DEMACIAAAA!!!",typeCourtePorte,qualiteLegendaire)

//Instantiation des Bombes
val bombe = Bombe ("Spike", 1, 5, "Dispositif explosif")

//Instantiation des Potions
val minipotion = Potion (15, "Mini pot", "Vous règène de +15 vos pv")
val potionarmure = Potion (15, "Shield pot", "Vous règène de +15 votre armure" )
val grossepotion = Potion (99999, "Gourde du Brave", "Vous règène au max de pv")

//Instantiation des Armures

val armureetoffe = Armure ("Armure d'étoffe", "Armure basique", typeArmureClassic , qualiteCommun)
val plaquedumort = Armure ("Plaque du Mort", "(Cuirassé) vous déplacer augmentant votre vitesse de déplacement", typeArmureEpic , qualiteEpic )
val maillegardien = Armure ("Maille du Gardien", "Armure qui vous confère une bonne protection ", typeArmureRare , qualiteRare)
val angegardien = Armure ("Ange Gardien", "Ranime votre guerrier lorsqu'il meurt, tout en vous donnant une protection.", typeArmureLegendaire , qualiteCommun)


//Instantiation des Monstres
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
    inventaire = mutableListOf(),

)

// TODO Intermission 1 Ajouter d'autres monstres
val Chogath = Personnage(
    "\u001B[1m Cho'gath la terreur noir",
    pointDeVie =100,
    pointDeVieMax = 100,
    attaque = 5,
    defense = 4,
    vitesse = 5,
    endurance = 6,
    armePrincipal = pompe,
    armure = armureetoffe,
    inventaire = mutableListOf(),

)

val Darius = Personnage(
    "\u001B[35m \u001B[1m Dieu-roi Darius \u001B[0m",
    pointDeVie = 75,
    pointDeVieMax = 75,
    attaque = 24,
    defense = 5,
    vitesse = 15,
    endurance = 8,
    armePrincipal = hacheDeGuerre,
    armure = armureetoffe,
    inventaire = mutableListOf(),

)




fun main(args: Array<String>) {




    //On ajoute les monstres a la liste de monstres du jeu
    val jeu = Jeu(listOf( Troll , Chogath , Darius ))
    //Lancement du jeu
    jeu.lancerCombat()
}