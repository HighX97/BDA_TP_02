package defClasseApplicationTouristique;

import java.util.HashSet;
import java.util.Set;

public abstract class Agglomeration 
{
	//Attributs
	
	int codePostal;
	String nom;
	int nbHabit;
	String description;
	Departement departement;
	Set<Caracteristique> caracteristiques;
	Region region;
	
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
		System.out.println(this+" a été typeCarcateristiquecorrectement enregistré.");
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
}
