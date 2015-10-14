package defClasseApplicationTouristique;

public class Plan 
{
	//Attributs
	String idPlan; // contient le chemind accès au plan image ou autre type de fichier
	Region region;//Relationship Region region_plan inverse plan_region;
	
	//Constructeur	
	
	Plan()
	{
		System.out.println("Plan ajouté");
	}
	
	Plan(String idPlan, Region region)
	{
		this.idPlan = idPlan;
		this.region = region;
		System.out.println("Le plan de la region "+this.region.getNom()+" a été ajouté. Chemin d'accès: "+this.idPlan);
	}
	
	//Accesseurs
	String getIdPlan()
	{
		return this.idPlan;
	}
	
	Region getRegion()
	{
		return this.region;
	}
	
	//Mutateurs
	void setIdPlan(String idPlan)
	{
		this.idPlan = idPlan;
	}
	
	void setRegion(Region region)
	{
		this.region = region;
	}
	
	//Methodes
}
