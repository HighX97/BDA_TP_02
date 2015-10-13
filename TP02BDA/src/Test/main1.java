package Test;

import java.io.File;

import DefClasse.Etudiant;

import com.db4o.*;
import com.db4o.query.Predicate;


public class main1
{
	
	//une fonction qui affichier tous les etudiants
	protected static void showAllStudents(ObjectContainer bd)
	{
		ObjectSet<Etudiant> oc=bd.query(new Predicate<Etudiant>() 
				{
			public boolean match(Etudiant candidat) 
			{
				return true;
			}
		});
		for(Etudiant e:oc){
			System.out.println(e);
		}
	}
	
	public static void main(String[] args)
	{		
		
		ObjectContainer bd = null;
		
		try {
			//si existe, supprime l'ancien fichier
			new File(".", "etudiants.data").delete();
			
			//connexion
			bd = Db4o.openFile("etudiants.data");
			
			
			//creation des instances de la classe Etudiant
			Etudiant e1=new Etudiant("Pierre",23,true);
			Etudiant e2=new Etudiant("Mary",19,true);
			Etudiant e3=new Etudiant("Antony",21,false);
			System.out.println("");
			

			//inserer
			bd.store(e1);
			bd.store(e2);
			bd.store(e3);
			
			//valider
			bd.commit();
			//bien sur ca existe aussi rollback
			//bd.rollback();
			
			/*//fermeture de la connexion
			bd.close();
			
			//reconnecter
			bd = Db4o.openFile("personne.data");*/
			
			
			////////////la recherche
			//une requete simple qui retourne les personnes qui ont plus de 20ans
			ObjectSet<Etudiant> oc=bd.query(new Predicate<Etudiant>() {
				public boolean match(Etudiant candidat) {
					System.out.println("---------"+candidat.getNom()+"*****"+candidat.getAge());
					return candidat.getAge()>20;
				}
			});
			
			//afficher les resultats
			for(Etudiant e:oc){
				System.out.println(e);
			}

			System.out.println("");
			
			
			
			////////////la modification
			//modification d'age, ajouter un an a tout le monde
			//d'abord trouver tout le monde
			oc=bd.query(new Predicate<Etudiant>() {
				public boolean match(Etudiant candidat) {
					return true;
				}
			});
			//modifier et enregistrer
			for(Etudiant e:oc){
				e.setAge(e.getAge()+1);
				bd.store(e);
			}
			//enfin valider
			bd.commit();

			showAllStudents(bd);
			
			System.out.println("");
			
			
			////////////la suppression
			//supprimer les etudiants qui n'ont pas fait l'inscription
			//recuperer les gens qui n'ont pas inscrit
			oc=bd.query(new Predicate<Etudiant>() {
				public boolean match(Etudiant candidat) {
					return !candidat.getInscrit();
				}
			});
			
			//supprimer
			for(Etudiant e:oc){
				bd.delete(e);
			}
			//enfin valider
			bd.commit();
			
			showAllStudents(bd);

			
		} finally {
			if (bd != null) {
				bd.close();
			}
		}
		
	}
	
}