package defClasseApplicationTouristique;

import java.util.List;

interface Agglomeration {
	int codePostal = 0;
	String nom = "";
	int nbHabit = 0;
	String descritpion = "";
	Departement departement = new Departement();
	//List<Caracteristiques> caracteristiques_agglomeration;
	
	//Relationship Departement departement inverse agglomerations;
	//Relationship set<Caracteristique> caracteristiques_agglomeration inverse agglomeration_caracteristique;
	//Relationship Region est_prefecture inverse possede_prefecture;
	//Relationship Region est_chefLieu inverse possede_chefLieu;

}
