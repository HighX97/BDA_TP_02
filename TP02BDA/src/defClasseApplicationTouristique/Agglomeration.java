package defClasseApplicationTouristique;

import java.util.List;

public abstract class Agglomeration 
{
	//Attributs
	
	int codePostal;
	String nom;
	int nbHabit;
	String description;
	Departement departement;
	List<Caracteristiques> caracteristiques;
	Region estPrefectureDe;
	Region estChefLieuDe;
	
	//Constructeurs
	
	Agglomeration()
	{
		System.out.println("Agglomération créée");
	}
	
	Agglomeration(int cdPost,String nomAgg)
	{
		this.nom = nomAgg;
		System.out.println("L'agglomération "+this.nom+" de code postal "+this.codePostal+"à correctement été créée");
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
	
	List<Caracteristiques> getCaracteristiques()
	{
		return this.caracteristiques;
	}
	
	Region getRegPref()
	{
		return this.estPrefectureDe;
	}
	
	Region getRegChefLieu()
	{
		return this.estChefLieuDe;
	}
	
	
	//Mutateurs
	
	void setCodePostal(int cP)
	{
		this.codePostal = cP;
	}
	
	void setNom(String nomAgg)
	{
		this.nom = nomAgg;
	}
	
	void setNbHabit(int nbHab)
	{
		this.nbHabit = nbHab;
	}
	
	void setDescription(String descrip)
	{
		this.description = descrip;
	}
	
	void setDepartement(Departement dep)
	{
		this.departement=dep;
	}
	
	void setCaracteristiques(List<Caracteristiques> caracs)
	{
		this.caracteristiques = caracs;
	}
	
	void setRegPref(Region reg)
	{
		this.estPrefectureDe = reg;
	}
	
	void setRegChefLieu(Region reg)
	{
		this.estChefLieuDe = reg;
	}
	
	//Methodes
}
