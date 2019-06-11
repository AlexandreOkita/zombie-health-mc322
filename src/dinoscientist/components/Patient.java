package dinoscientist.components;

import dinoscientist.interfaces.IComponent;
import dinoscientist.interfaces.IClient;

import java.util.Random;
import java.util.Hashtable;

public class Patient implements IClient{
	
	private String nome;
	
	private Hashtable<String,Int> disease;

	private IDataSet DataSet;

	public void connectDataSet( IDataSet data ){
		this.DataSet = data;    // (2) pegue um sintoma randômico
	}

	public void setDisease(){

		Random rand = new Random();

		this.disease = new Hashtable<String,Int>();

		String[] att = dataset.requestAttributes();
		
		for (int idx = 0; idx < att.length-1; idx++){
			disease.put( att[idx] , rand.nextInt(2) );
			System.out.print(att[idx] + ", ");
		}
		System.out.println("");
	}
	public int getSintoma( String key ){
		return this.disease.get(key);
	}
	public String getName(){
		return this.name
	}
}
