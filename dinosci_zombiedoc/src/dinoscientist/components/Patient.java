package dinoscientist.components;

import dinoscientist.interfaces.IComponent;
import dinoscientist.interfaces.IDataSet;
import dinoscientist.interfaces.ICRM;
import dinoscientist.interfaces.IClient;
import java.util.Random;
import java.util.Hashtable;

public class Patient implements IClient{

    private Hashtable<String,Integer> disease;

    private IDataSet DataSet;
    
    private String name;
    
    public Patient() {
    	this.name = "Teste";
    }
    

    public void connectDataSet( IDataSet data ){
        this.DataSet = data;
    }
    
    public void setDisease(){
        
        Random rand = new Random();
        
        this.disease = new Hashtable<String,Integer>();
        
        String[] att = DataSet.requestAttributes();
        for (int idx = 0; idx < att.length-1; idx++){
			disease.put( att[idx] , rand.nextInt(2) );
		}
    }
    
    public int getSintoma( String key ){
        return this.disease.get(key);
    }
    
    public String getName(){
        return this.name;
    }
}
