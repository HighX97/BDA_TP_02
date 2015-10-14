package defClasseApplicationTouristique;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.db4o.*;
import com.db4o.query.Predicate;

public class Departement 
{
	//Attributs
	
	private int idDept;
	private String nom;
	private float surface;
	private Region region;//Relationship Region region inverse departement;
	Set<Agglomeration> agglomerations;	//Relationship set<Agglomeration> agglomerations inverse departement;
	
	//Constructeurs
	
	public Departement()
	{
		this.agglomerations = new HashSet<Agglomeration>();
		System.out.println("Département enregistré.");
	}
	
	public Departement(int idDept, String nom)
	{
		this.idDept = idDept;
		this.nom = nom;
		this.agglomerations = new HashSet<Agglomeration>();
		System.out.println("Le département "+this.nom+" de numéro "+this.idDept+" a été correctement enregistré.");
	}
	
	public Departement(int idDept, String nom, float surface, Region region, Set<Agglomeration> agglomerations )
	{
		this.idDept = idDept;
		this.nom = nom;
		this.surface = surface;
		this.region = region;
		this.agglomerations = agglomerations;
		System.out.println(this+" a été correctement enregistré.");
	}
	
	//Accesseurs
	
	public int getId()
	{
		return this.idDept;
	}
	
	public String getNom()
	{
		return this.nom;
	}
	
	public float getSurface()
	{
		return this.surface;
	}
	
	public Region getRegion()
	{
		return this.region;
	}
	
	public Set<Agglomeration> getAgglomeration()
	{
		return this.agglomerations;
	}

	//Mutateurs
	
	public void setId(int idDept)
	{
		this.idDept = idDept;
		System.out.println("Départment - idDept MAJ");
	}
	
	public void setNom(String nom)
	{
		this.nom = nom;
		System.out.println("Départment - nom MAJ");
	}
	
	public void setSurface(float surface)
	{
		this.surface = surface;
		System.out.println("Départment - surface MAJ");
	}
	
	public void setRegion(Region region )
	{
		this.region = region;
		System.out.println("Départment - region MAJ");
	}
	
	public void setAgglomeration(Set<Agglomeration> agglomerations)
	{
		this.agglomerations = agglomerations;
		System.out.println("Départment - agglomerations MAJ");
	}
	
	//Methodes
	
		//Agglomeration
	int nbAgglomeration()
	{
		return this.agglomerations.size();
	}
	
	boolean addAgglomeration(Agglomeration agg)
	{
		if(this.agglomerations.add(agg))
			{
				System.out.println("Le département "+agg.getNom()+" a été ajouté à la région "+this.getNom());
				return true;
			}
		else
			{
				System.out.println("Le département "+agg.getNom()+" n'a pas été ajouté à la région "+this.getNom()+" car déja présent dans la collection des départements");
				return false;
			}
	}
	
	boolean removeAgglomeration(Agglomeration agg)
	{
		if(this.agglomerations.remove(agg))
		{
			System.out.println("Le département "+agg.getNom()+" a été supprimé de la région "+this.getNom());
			return true;
		}
		else
		{
			System.out.println("Le département "+agg.getNom()+" n'a pas été trouvé dans la région "+this.getNom());
			return false;
		}
	}
	
			//Divers
	
	int getPopulationDept()
	{
		int populationTotal=0;
		Iterator i = agglomerations.iterator();
		while(i.hasNext())
		{
			populationTotal += ((Agglomeration)i.next()).getNbHabit();
		}
		return populationTotal;
	}
	
			//Réimplémentations
	
	public String toString()
	{
		String toStringDept="";
		//nom
		toStringDept += "Le département "+this.nom;
		//idDept
		toStringDept += " de numéro "+this.idDept;
		//region
		toStringDept += " de la region "+this.region.getNom();
		//surface
		toStringDept += " de surface "+this.surface+" km2";
		//agglomerations
		toStringDept += " composé des agglomerations:\n";
		Iterator i = agglomerations.iterator();
		while(i.hasNext())
		{
			toStringDept += "-"+((Agglomeration)i.next()).getNom()+"\n";
		}
		return toStringDept;
	}
	
	protected static void showAgglomerationsInfoFromDeparment(ObjectContainer bd, String depId)
	{
	  
	  ObjectSet<Departement> oc=bd.query
		(
			new Predicate<Departement>(){
				public boolean match(Departement d)
				{
					return true;
				}
			}
		);
	  for(Departement d:oc){
	    if (d.getNom() == depId)
	    {
	      for (Agglomeration ag:d.agglomerations ){
    		  System.out.println("codePostal: " + ag.codePostal + " nom: " + ag.nom + " descritpion: " + ag.description + " nbHabit: " + ag.description + " surface: " + d.surface);
    	  }
        }
	  }
	}
	
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
