package DefClasse;

public class Etudiant {

	public Etudiant(String nom, int age, boolean inscrit){
		this.nom=nom;
		this.age=age;
		this.inscrit=inscrit;
		System.out.println(this+" cree.");
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean getInscrit() {
		return inscrit;
	}
	public void setInscrit(boolean inscrit) {
		this.inscrit = inscrit;
	}
	
	public String toString(){
		return this.nom+" "+this.age+"ans "+this.inscrit;
	}
	
	public boolean equals(Etudiant p){
		return (p.getNom().equals(this.getNom()) && (p.getInscrit() == this.getInscrit()) && (p.getAge() == this.getAge()));
	}

	private String nom;
	private int age;
	private boolean inscrit;
	
}
