package DefClasse;

import java.util.ArrayList;

public class Groupe {
	public Groupe(String nom){
		this.nom=nom;
		System.out.println("Groupe cree");
	}
	
	public Groupe(String nom, ArrayList<Etudiant> membres){
		this.nom=nom;
		this.membres=membres;
		System.out.println("Groupe cree");
	}
	
	public int getTaille(){
		if(this.membres!=null){
			return this.membres.size();
		}
		else{
			return 0;
		}
	}
	
	public void addMembre(Etudiant e){
		if(this.membres==null){
			this.membres=new ArrayList<Etudiant>();
		}
		if(!this.membres.contains(e)){
			this.membres.add(e);
		}
		else{
			System.out.println("-------Etudiant deja existe dans le groupe!---------");
		}
	}
	
	public void removeMembre(Etudiant e){
		if(this.membres==null){
			System.out.println("-------Le groupe est vide!---------");
		}
		else{
			if(this.membres.contains(e)){
				this.membres.remove(e);
				System.out.println(e.toString()+" supprime!");
			}
			else{
				System.out.println(e.toString()+" n'existe pas!");
			}
		}
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<Etudiant> getMembres() {
		return this.membres;
	}

	public void setMembres(ArrayList<Etudiant> membres) {
		this.membres = membres;
	}
	
	public String toString() {
		String s="Groupe " + nom + " :\n";
		
		if(this.membres==null){
			s+="Groupe vide!\n";
		}
		else{
			for(Etudiant e:this.membres){
				s+=e.toString()+"\n";
			}
		}
		
		return s;
	}



	private String nom;
	private ArrayList<Etudiant> membres;
}
