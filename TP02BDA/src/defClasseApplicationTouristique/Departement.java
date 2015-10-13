package defClasseApplicationTouristique;

import java.util.List;

public class Departement {
	int idDept;
	String nom;
	float surface;
	Region region;//Relationship Region region inverse departement;
	List<Agglomeration> agglomerations;	//Relationship set<Agglomeration> agglomerations inverse departement;
}
