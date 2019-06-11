import java.util.Random;
import java.util.Hashtable<K,V>;

public class Patient implements IClient{

    private Hashtable<String,Int> disease;

    private IDataSet DataSet;
    
    private ICRM crm;
    
    pubic void connectCRM ( ICRM crm ){
        this.crm = crm;
    }

    public void connectDataSet( IDataSet data ){
        this.DataSet = data;    // (2) pegue um sintoma randômico
    }
    
    public void setDisease(int n_diseases){
        
        Random rand = new Random();
        
        this.disease = new Hashtable<String,Int>();
        
        String[] att = dataset.requestAttributes();
        for ( String sin : att ){
            disease.put( sin , rand.nextInt(2) );
            System.out.println(disease.get(idx));
        }
    }
    
    public void getSecondOpinion(){
        
		List<String> outrasOpcoes = crm.execute(dataset, SintomasPat); // dataset é um pathing de um dataset global;
		int i = 1;
		for ( String opc : outrasOpcoes ) {
			System.out.println(i+": "+opc);
			i++;
		}
    }
    
    public int getSintoma( String key ){
        return this.disease.get(idx);
    }
    
    public String getName(){
        return this.name
    }
}
