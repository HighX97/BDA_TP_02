package defClasseApplicationTouristique;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

public abstract class Agglomeration 
{
	//Attributs
	
	protected int codePostal;
	protected String nom;
	protected int nbHabit;
	protected String description;
	protected Departement departement;
	protected Set<Caracteristique> caracteristiques;
	protected Set<Hotel> hotels;//Relationship set<Hotel> hotels inverse ville_hotel;
	protected Region region;
	
	//Constructeurs
	
	Agglomeration()
	{
		this.caracteristiques = new HashSet<Caracteristique>();
		System.out.println("Agglomération enregistrée");
	}
	
	Agglomeration(int cdPost,String nomAgg)
	{
		this.codePostal = cdPost;
		this.nom = nomAgg;
		this.caracteristiques = new HashSet<Caracteristique>();
		System.out.println("L'agglomération "+this.nom+" de code postal "+this.codePostal+"à correctement été enregistrée");
	}
	
	Agglomeration(int cdPost,String nomAgg, int nbHabit, String description, Departement departement,Set<Caracteristique> caracteristiques,Region region)
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
	
	//Accesseurs
	
	int getCodePostal()
	{
		return this.codePostal;
	}
	
	String getNom()
	{
		return this.nom;
	}
	
	int getNbHabit()
	{
		return this.nbHabit;
	}
	
	String getDescription()
	{
		return this.description;
	}
	
	Departement getDepartement()
	{
		return this.departement;
	}
	
	Set<Caracteristique> getCaracteristiques()
	{
		return this.caracteristiques;
	}
	
	Region getRegion()
	{
		return this.region;
	}
	
	
	
	//Mutateurs
	
	void setCodePostal(int cP)
	{
		this.codePostal = cP;
		System.out.println("Agglomeration - codePostal MAJ");
	}
	
	void setNom(String nomAgg)
	{
		this.nom = nomAgg;
		System.out.println("Agglomeration - nom MAJ");
	}
	
	void setNbHabit(int nbHab)
	{
		this.nbHabit = nbHab;
		System.out.println("Agglomeration - nbHabit MAJ");
	}
	
	void setDescription(String descrip)
	{
		this.description = descrip;
		System.out.println("Agglomeration - description MAJ");
	}
	
	void setDepartement(Departement dep)
	{
		this.departement=dep;
		System.out.println("Agglomeration - departement MAJ");
	}
	
	void setCaracteristiques(Set<Caracteristique> caracs)
	{
		this.caracteristiques = caracs;
		System.out.println("Agglomeration - caracteristiques MAJ");
	}
	
	void setRegion(Region reg)
	{
		this.region = reg;
		System.out.println("Agglomeration - region MAJ");
	}
	
	//Methodes
	
		//Caracterisiques
	int nbCaracteristiques()
	{
		return this.caracteristiques.size();
	}
	
	boolean addCaracteristique(Caracteristique carac)
	{
		if(this.caracteristiques.add(carac))
			{
				System.out.println("La caractéristique "+carac.getNom()+" a été ajouté à l'agglomération "+this.getNom());
				return true;
			}
		else
			{
				System.out.println("Le caractéristique "+carac.getNom()+" n'a pas été ajouté à l'agglomération "+this.getNom()+" car déja présent dans la collection des caractéristiques");
				return false;
			}
	}
	
	boolean removeCaracteristique(Caracteristique carac)
	{
		if(this.caracteristiques.remove(carac))
		{
			System.out.println("La caractéristique"+carac.getNom()+" a été supprimé de l'agglomération "+this.getNom());
			return true;
		}
		else
		{
			System.out.println("La caractéristique "+carac.getNom()+" n'a pas été trouvé dans l'agglomération "+this.getNom());
			return false;
		}
	}
	
		//Prefecture & ChefLieu
	
	boolean estPrefecture()
	{
		Iterator j = this.getRegion().getPrefectures().iterator();
		boolean estPrefecture=false;
		while(j.hasNext() && !estPrefecture)
		{
			estPrefecture=((Agglomeration) j.next()).getNom().equalsIgnoreCase(this.nom);
		}
		return estPrefecture;
	}
	
	boolean estChefLieu()
	{
		return (this.getRegion().getChefLieu().equals(this));
	}
	
		//Réimplémentation
	
	public String toString()
	{
		String toStringAgg="";
		//nom
		toStringAgg += "L'agglomération "+this.nom;
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
	
	protected void getAgglomerationsWithMonuments(ObjectContainer bd)
	{
	  
	  ObjectSet<Agglomeration> oc=bd.query
	  (
	    new Predicate<Agglomeration>()
	    {
	      public boolean match(Agglomeration ag)
	      {
	        return true;
	      }
	    }
	  );
	  for(Agglomeration ag:oc){
	      for (Caracteristique car:caracteristiques ){
	    	  if( car.getType() = "monument" ){
	    		  System.out.println(" nom: " + ag.getNom());
	    	  }
			  
		  }
      }
	}
	
	protected void getAgglomerationsHotelsByStars(ObjectContainer bd, int etoiles)
	{
	  
	  ObjectSet<Agglomeration> oc=bd.query
	  (
	    new Predicate<Agglomeration>()
	    {
	      public boolean match(Agglomeration ag)
	      {
	        return true;
	      }
	    }
	  );
	  for(Agglomeration ag:oc){
	      for (Hotel hot:hotels ){
	    	  if( (int) hot.nbEtoiles == etoiles ){
	    		  System.out.println(" nom: " + hot.nom);
	    	  }
			  
		  }
      }
	}
}
