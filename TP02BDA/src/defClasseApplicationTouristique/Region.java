package defClasseApplicationTouristique;

import java.util.List;

import com.db4o.*;
import com.db4o.query.Predicate;


public class Region 
{
	
	String nom;
	String Description;
	List<Departement> departements;
	Plan plan;
	Agglomeration prefecture;
	Agglomeration chefLieu;
	
	public Region ()
	{
		System.out.println(this+" cree.");
	}
	
	public Region (String nom, String Description)
	{
		this.nom = nom;
		this.Description = Description;
		System.out.println(this+" cree.");
	}
	
	public Region (String nom, String Description, List<Departement> departements, Plan plan, Agglomeration prefecture, Agglomeration chefLieu)
	{
		this.nom = nom;
		this.Description = Description;
		this.departements = departements;
		this.plan = plan;
		this.prefecture = prefecture;
		this.chefLieu = chefLieu;
		System.out.println(this+" cree.");
	}
	
	
	public String getName()
	{
		return nom;
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
