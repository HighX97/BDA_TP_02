package defClasseApplicationTouristique;

import java.util.HashSet;
import java.util.Set;

public class TypeCarcateristique 
{
	
	//Attributs
	
	private String nom;
	private Set<Caracteristique> caracteristiques;
	
	//Constructeurs
	
	public TypeCarcateristique()
	{
		this.caracteristiques = new HashSet<Caracteristique>();
		System.out.println("TypeCarcateristique enregistré.");
	}
	
	public TypeCarcateristique(String nom, Set<Caracteristique> caracteristiques)
	{
		this.nom = nom;
		this.caracteristiques = caracteristiques;
		System.out.println(this+" a été correctement enregistré.");
	}
	//Accesseurs
	
	public String getNom() 
	{
		return nom;
	}
	
	public Set<Caracteristique> getCaracteristiques() 
	{
		return caracteristiques;
	}
	
	//Mutateurs
	
	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	
	public void setCaracteristiques(Set<Caracteristique> caracteristiques) 
	{
		this.caracteristiques = caracteristiques;
	}
	
	//Méthodes
	
}
