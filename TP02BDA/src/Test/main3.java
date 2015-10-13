package Test;

import java.io.File;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.Configuration;
import com.db4o.query.Predicate;

import defClasseApplicationTouristique.Region;

public class main3 {

	public static void main(String[] args){		
		ObjectContainer bd = null;
		try {
			new File(".", "regions.data").delete();
			//connexion
			bd = Db4o.openFile("regions.data");
			//creation des instances de la classe Etudiant
			Region r1=new Region("Languedoc", "Test desc");
			System.out.println("");
			bd.close();
			
		} finally {
			if (bd != null) {
				bd.close();
			}
		}
		
	}

}
