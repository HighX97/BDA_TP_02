package defClasseApplicationTouristique;

import java.util.List;

import com.db4o.*;
import com.db4o.query.Predicate;


public class Region 
{
	//Attributs
	String nom;
	String description;
	List<Departement> departements;
	Plan plan;
	List<Agglomeration> prefectures;
	Agglomeration chefLieu;
	
	//Constructeur
	public Region ()
	{
		System.out.println("Région créée.");
	}
	
	public Region (String nom, String Description)
	{
		this.nom = nom;
		this.description = Description;
		System.out.println("La région "+this.nom+" qui est "+this.description+" à correctement été créée.");
	}
	
	public Region (String nom, String Description, List<Departement> departements, Plan plan, List<Agglomeration> prefecture, Agglomeration chefLieu)
	{
		this.nom = nom;
		this.description = Description;
		this.departements = departements;
		this.plan = plan;
		this.prefectures = prefecture;
		this.chefLieu = chefLieu;
		System.out.println(this+" créée.");
	}
	
	//Accesseurs
	public String getName()
	{
		return nom;
	}
	
	//Mutateurs
	
	
	//Methodes
	
	public String toString()
	{
		String toStringRegion="";
		//nom
		toStringRegion += "La région "+this.nom;
		//description
		toStringRegion += " qui est "+this.description;
		//départements
		toStringRegion += " composé des départements:\n";
		int i;
		for(i=0;i<this.departements.size();i++)
		{
			toStringRegion += "-"+this.departements.get(i).getName()+"\n";
		}
		//prefecture
		if (this.prefectures.size()>1)
		{
			toStringRegion += "dont les préfectures sont:\n";
		}
		else
		{
			toStringRegion += "dont la préfecture est:\n";
		}
		int j;
		for(j=0;j<this.prefectures.size();j++)
		{
			toStringRegion += "-"+this.prefectures.get(j).getNom()+"\n";
		}
		//chefLieu
		toStringRegion += "et dont la chef lieu est "+this.chefLieu.getNom();
		return toStringRegion;
	}
	
	protected static void showDepartementFromRegion(ObjectContainer bd, String idRegion)
	{
	  ObjectSet<Region> oc=bd.query
	  (
	    new Predicate<Region>()
	    {
	      public boolean match(Region candidat)
	      {
	        return true;
	      }
	    }
	  );
	  for(Region r:oc){
	    if (r.getName() == idRegion)
	    {
	      for (Departement d:r.departements)	
	      {
	        System.out.println(d);
	      }
	    }
	  }
	}
	
}
