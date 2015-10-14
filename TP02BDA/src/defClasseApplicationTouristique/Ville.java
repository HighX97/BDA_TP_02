package defClasseApplicationTouristique;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.db4o.ObjectContainer;

public class Ville extends Agglomeration 
{
	//Attributs
	private Set<Hotel> hotels;//Relationship set<Hotel> hotels inverse ville_hotel;
	private Set<Restaurant> restaurants;//Relationship set<Restaurant> restaurants inverse ville_restaurant;
	
	
	//Constructeur
	
	Ville()
	{
		this.caracteristiques = new HashSet<Caracteristique>();
		System.out.println("Ville enregistrée");
	}
	
	Ville(int cdPost,String nomAgg)
	{
		this.codePostal = cdPost;
		this.nom = nomAgg;
		this.caracteristiques = new HashSet<Caracteristique>();
		System.out.println("La ville "+this.nom+" de code postal "+this.codePostal+"à correctement été enregistrée");
	}
	
	Ville(int cdPost,String nomAgg, int nbHabit, String description, Departement departement,Set<Caracteristique> caracteristiques,Region region)
	{
		this.codePostal = cdPost;
		this.nom = nomAgg;
		this.nbHabit = nbHabit;
		this.description = description;
		this.departement = departement;
		this.caracteristiques = caracteristiques;
		this.region = region;
		System.out.println(this+" a été correctement enregistré.");
	}
	
	Ville(int cdPost,String nomAgg, int nbHabit, String description, Departement departement,Set<Caracteristique> caracteristiques,Region region, Set<Hotel> hotels, Set<Restaurant> restaurants)
	{
		this.codePostal = cdPost;
		this.nom = nomAgg;
		this.nbHabit = nbHabit;
		this.description = description;
		this.departement = departement;
		this.caracteristiques = caracteristiques;
		this.region = region;
		this.hotels = hotels;
		this.restaurants = restaurants;
		System.out.println(this+" a été correctement enregistré.");
	}
	
	//Accesseurs
	public Set<Hotel> getHotels() {
		return hotels;
	}
	public Set<Restaurant> getRestaurants() {
		return restaurants;
	}
	
	//Mutateurs
	public void setHotels(Set<Hotel> hotels) {
		this.hotels = hotels;
	}

	public void setRestaurants(Set<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	
	//Methode
	
	//Réimplémentation
	
	public String toString()
	{
		String toStringAgg="";
		//nom
		toStringAgg += "La ville "+this.nom;
		//codePostal
		toStringAgg += " de code postal "+this.codePostal;
		//departement
		toStringAgg += " du departement "+this.departement.getNom();
		//chefLieu &&prefecture
		if (estChefLieu() && estPrefecture() )
		{
			toStringAgg += " chef lieu et préfecture de la région "+this.region.getNom();
		}
		else if (estChefLieu())
		{
			toStringAgg += " chef lieu de la région "+this.region.getNom();
		}
		else if (estPrefecture())
		{
			toStringAgg += " préfecture de la région "+this.region.getNom();
		}
		//nbHabitant
		toStringAgg += ".\n Elle possède"+this.nbHabit+" habitants";
		//descrtiption
		toStringAgg += "et se décrit de la façon suivante : \n"+this.description;
		//caracteristiques
		toStringAgg += ".\nElle possède les caractéristiques suivantes:\n";
		Iterator i = caracteristiques.iterator();
		while(i.hasNext())
		{
			Caracteristique carac =((Caracteristique)i.next());
			toStringAgg += "-("+carac.getTypeCarcateristique().getNom()+") "+carac.getNom()+"\n";
		}
		return toStringAgg;
	}

//	//@TODO pending because its a interface an
//	public void showAgglomerationsByRegion(ObjectContainer bd, String idRegion)
//	{
//		
//	}
}	
