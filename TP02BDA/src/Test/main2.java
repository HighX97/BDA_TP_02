package Test;

import java.io.File;

import DefClasse.*;

import com.db4o.*;
import com.db4o.config.Configuration;
import com.db4o.query.Predicate;

public class main2 {
	
	protected static void showAllGroups(ObjectContainer bd) {
		ObjectSet<Groupe> oc = bd.query(new Predicate<Groupe>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 6825988700802544025L;

			public boolean match(Groupe candidat) {
				return true;
			}
		});

		// afficher les resultats
		for (Groupe g : oc) {
			System.out.println(g);
		}
	}
	
	protected static void showAllStudents(ObjectContainer bd){
		ObjectSet<Etudiant> oc=bd.query(new Predicate<Etudiant>() {
			public boolean match(Etudiant candidat) {
				return true;
			}
		});
		for(Etudiant e:oc){
			System.out.println("ici");
			System.out.println(e);
		}
	}
	
	public static void main(String[] args){		
		
		ObjectContainer bd = null;
		
		try {
			//si existe, supprime l'ancien fichier
			new File(".", "Groupes.data").delete();
			
			//connexion
			bd = Db4o.openFile("Groupes.data");
			
			
			//creation des instances de la classe Etudiant
			Etudiant e1=new Etudiant("Pierre",23,true);
			Etudiant e2=new Etudiant("Mary",20,true);
			Etudiant e3=new Etudiant("Antony",21,false);
			Etudiant e4=new Etudiant("Julie",19,true);
			Etudiant e5=new Etudiant("Isabelle",20,true);
			Etudiant e6=new Etudiant("Sebastien",22,false);
			Etudiant e7=new Etudiant("Olivier",21,false);
			Etudiant e8=new Etudiant("Camille",18,true);
			Etudiant e9=new Etudiant("Helene",21,false);
			Etudiant e10=new Etudiant("Thomas",21,true);
			
			//creation des instances de la classe Groupe
			Groupe g1=new Groupe("G1");
			g1.addMembre(e1);
			g1.addMembre(e2);
			g1.addMembre(e3);
			
			Groupe g2=new Groupe("G2");
			g2.addMembre(e4);
			g2.addMembre(e5);
			
			
			Groupe g3=new Groupe("G3");
			
			Groupe g4=new Groupe("G4");
			g4.addMembre(e6);
			g4.addMembre(e7);
			
			Groupe g5=new Groupe("G5");
			g5.addMembre(e8);
			g5.addMembre(e9);
			g5.addMembre(e10);
			
			System.out.println("------------------------");

			
			//inserer les groupes
			bd.store(g1);
			bd.store(g2);
			bd.store(g3);
			bd.store(g4);
			bd.store(g5);
			
			bd.commit();
			
			//retourver tous les groupes, meme avec les etudiants de chaque groupe.
			//Sachant qu'au moment d'insertion, nous avons insere que les groupes mais pas les etudiants
			showAllGroups(bd);
			showAllStudents(bd);
			System.out.println("------------------------");
			
			
			//on montre la suppression de tous les groupes qui ont moins que 3 personnes
			//cela permet de faire les operations en mdoe "cascade". Mais il faut d'abord fermer la session actuelle et reconfigurer avant de reconnecter
			bd.close();
			//reconfigurer en ajoutant cascade de suppression sur la classe groupe
			Configuration cf=Db4o.newConfiguration();
			cf.objectClass("DefClasse.Groupe").cascadeOnDelete(true);
			bd = Db4o.openFile(cf,"Groupes.data");
			
			
			ObjectSet<Groupe> oc=bd.query(new Predicate<Groupe>() {
				public boolean match(Groupe candidat) {
					return candidat.getTaille()<3;
				}
			});
			
			//afficher les resultats
			for(Groupe g:oc){
				bd.delete(g);
			}
			
			showAllGroups(bd);
			showAllStudents(bd);
			System.out.println("------------------------");
			
			
			
		} finally {
			if (bd != null) {
				bd.close();
			}
		}
		
	}
}
