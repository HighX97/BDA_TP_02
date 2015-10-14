package defClasseApplicationTouristique;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.db4o.*;
import com.db4o.query.Predicate;


public class Region 
{
	//Attributs
	String nom;
	String description;
	Set<Departement> departements;
	Plan plan;
	Set<Agglomeration> prefectures;
	Agglomeration chefLieu;
	
	//Constructeurs
	
	public Region ()
	{
		this.departements = new HashSet<Departement>();
		this.prefectures = new HashSet<Agglomeration>();
		System.out.println("Région enregistrée.");
	}
	
	public Region (String nom, String Description)
	{
		this.nom = nom;
		this.description = Description;
		this.departements = new HashSet<Departement>();
		this.prefectures = new HashSet<Agglomeration>();
		System.out.println("La région "+this.nom+" qui est "+this.description+" a correctement été enregistrée.");
	}
	
	public Region (String nom, String Description, HashSet<Departement> departements, Plan plan, HashSet<Agglomeration> prefecture, Agglomeration chefLieu)
	{
		this.nom = nom;
		this.description = Description;
		this.departements = departements;
		this.plan = plan;
		this.prefectures = prefecture;
		this.chefLieu = chefLieu;
		System.out.println(this+" a été correctement enregistrée.");
	}
	
	//Accesseurs
	
	String getNom()
	{
		return this.nom;
	}
	
	String getDescription()
	{
		return this.description;
	}
	
	Set<Departement> getDepartements()
	{
		return this.departements;
	}
	
	Plan getPlan()
	{
		return this.plan;
	}
	
	Set<Agglomeration> getPrefectures()
	{
		return this.prefectures;
	}
	
	Agglomeration getChefLieu()
	{
		return this.chefLieu;
	}
	
	//Mutateurs
	
	void setNom(String nomReg)
	{
		this.nom=nomReg;
		System.out.println("Région - nom MAJ");
	}
	
	void setDescription(String descrip)
	{
		this.description=descrip;
		System.out.println("Région - description MAJ");
	}
	
	void setDepartements(Set<Departement> dep)
	{
		this.departements=dep;
		System.out.println("Région - liste départements MAJ");
	}
	
	void setPlan(Plan plan)
	{
		this.plan=plan;
		System.out.println("Région - plan MAJ");
	}
	
	void setPrefectures(Set<Agglomeration> prefectures)
	{
		this.prefectures= prefectures;
		System.out.println("Région - prefectures MAJ");
	}
	
	void setChefLieu(Agglomeration  chefLieu)
	{
		this.chefLieu = chefLieu;
		System.out.println("Région - chef lieu MAJ");
	}
	
	//Methodes
	
		//Departement
	int nbDepartement()
	{
		return this.departements.size();
	}
	
	boolean addDepartement(Departement dep)
	{
		if(this.departements.add(dep))
			{
				System.out.println("Le département "+dep.getNom()+" a été ajouté à la région "+this.getNom());
				return true;
			}
		else
			{
				System.out.println("Le département "+dep.getNom()+" n'a pas été ajouté à la région "+this.getNom()+" car déja présent dans la collection des départements");
				return false;
			}
	}
	
	boolean removeDepartement(Departement dep)
	{
		if(this.departements.remove(dep))
		{
			System.out.println("Le département "+dep.getNom()+" a été supprimé de la région "+this.getNom());
			return true;
		}
		else
		{
			System.out.println("Le département "+dep.getNom()+" n'a pas été trouvé dans la région "+this.getNom());
			return false;
		}
	}
		//Prefecture
	int nbPrefecture()
	{
		return this.prefectures.size();
	}
	
	boolean addPrefecture(Agglomeration prefecture)
	{
		if(this.prefectures.add(prefecture))
			{
				System.out.println("La préfecture "+prefecture.getNom()+" a été ajouté à la région "+this.getNom());
				return true;
			}
		else
			{
				System.out.println("La préfecture "+prefecture.getNom()+" n'a pas été ajouté à la région "+this.getNom()+" car déja présent dans la collection des préfectures");
				return false;
			}
	}
	
	boolean removePrefecture(Agglomeration prefecture)
	{
		if(this.prefectures.remove(prefecture))
		{
			System.out.println("La prefecture "+prefecture.getNom()+" a été supprimé de la région "+this.getNom());
			return true;
		}
		else
		{
			System.out.println("La prefecture "+prefecture.getNom()+" n'a pas été trouvé dans la région "+this.getNom());
			return false;
		}
	}
	
			//Divers
	
	float getSurfaceTotal()
	{
		float surfaceTotal=0;
		Iterator i = departements.iterator();
		while(i.hasNext())
		{
			surfaceTotal += ((Departement)i.next()).getSurface();
		}
		return surfaceTotal;
	}
	
	int getPopulationRegion()
	{
		int populationTotal=0;
		Iterator i = departements.iterator();
		while(i.hasNext())
		{
			populationTotal += ((Departement)i.next()).getPopulationDept();
		}
		return populationTotal;
	}
	
			//Reimplémentations
	
	public String toString()
	{
		String toStringRegion="";
		//nom
		toStringRegion += "La région "+this.nom;
		//description
		toStringRegion += " qui est "+this.description;
		//départements
		toStringRegion += " composé des départements:\n";
		Iterator i = departements.iterator();
		while(i.hasNext())
		{
			toStringRegion += "-"+((Departement)i.next()).getNom()+"\n";
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
		Iterator j = prefectures.iterator();
		while(j.hasNext())
		{
			toStringRegion += "-"+((Agglomeration) j.next()).getNom()+"\n";
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
	    if (r.getNom() == idRegion)
	    {
	      for (Departement d:r.departements)	
	      {
	        System.out.println(d);
	      }
	    }
	  }
	}
	
}
