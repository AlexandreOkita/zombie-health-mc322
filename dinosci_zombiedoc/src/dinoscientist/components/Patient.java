package dinoscientist.components;

import dinoscientist.interfaces.IComponent;
import dinoscientist.interfaces.IDataSet;
import dinoscientist.interfaces.ICRM;
import dinoscientist.interfaces.IClient;
import java.util.Random;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class Patient implements IClient{

    private Hashtable<String,Integer> disease;

    private IDataSet DataSet;
    
    private String name;
    
    private List<Integer> symp;
    
    public Patient() {
    	this.name = "Teste";
    }
    

    public void connectDataSet( IDataSet data ){
        this.DataSet = data;
    }
    
    public void setDisease(){
        
        Random rand = new Random();
        symp = new ArrayList<Integer>();
        this.disease = new Hashtable<String,Integer>();
        
        String[] att = DataSet.requestAttributes();
        for (int idx = 0; idx < att.length-1; idx++){
        	
			disease.put( att[idx] , rand.nextInt(2) );
			symp.add(disease.get(att[idx]));
		}
    }
    
    public List<Integer> getSymp(){
    	return symp;
    }
    
    public List<Integer> getEstados(){
    	List <Integer> listEstado = new ArrayList<Integer>();
    	for (Enumeration<Integer> e = disease.elements(); e.hasMoreElements();)
    	       listEstado.add(e.nextElement());
    	return listEstado;
    }
    
    public int getSintoma( String key ){
        return this.disease.get(key);
    }
    
    public String getName(){
        return this.name;
    }
}
