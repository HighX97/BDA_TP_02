package defClasseApplicationTouristique;

import java.util.List;
import com.db4o.*;
import com.db4o.query.Predicate;

public class Departement 
{
	//Attributs
	int idDept;
	String nom;
	float surface;
	Region region;//Relationship Region region inverse departement;
	List<Agglomeration> agglomerations;	//Relationship set<Agglomeration> agglomerations inverse departement;
	
	public String getNom()
	{
		return this.nom;
	}
	
//	protected static void getAglomerationsAndDeparmentsData(ObjectContainer db, String depId)
//	{
//		/*
//		ObjectSet<Departement> oc=bd.query
//		(
//			new Predicate<Departement>(){
//				public boolean match(Region candidat)
//				{
//					return true;
//				}
//			}
//		);
//		for(Departement d:oc){
//			if( d.getName() == depId ){
//				for (Agglomeration ag:d.agglomerations ){
//					System.out.println(ag);
//					System.out.println("codePostal: " + ag.codePostal + " nom: " + ag.nom + " descritpion: " + ag.descritpion + " nbHabit:  surface: " + d.surface);
//				}
//			}
//		}
//		*/
//	}
}
