package defClasseApplicationTouristique;

import java.util.List;
import com.db4o.*;
import com.db4o.query.Predicate;

interface Agglomeration {
	int codePostal = 0;
	String nom = "";
	int nbHabit = 0;
	String descritpion = "";
	Departement departement = new Departement();////Relationship Departement departement inverse agglomerations;
	//@TODO pending to review the instance
	List<Caracteristiques> caracteristiques_agglomeration = null;//Relationship set<Caracteristique> caracteristiques_agglomeration inverse agglomeration_caracteristique;
	Region est_prefecture = new Region();//Relationship Region est_prefecture inverse possede_prefecture;
	Region est_chefLieu = new Region();//Relationship Region est_chefLieu inverse possede_chefLieu;
	
	//@TODO pending because its a interface an
	public void showAgglomerationsByRegion(ObjectContainer bd, String idRegion);
	
}
