package dinoscientist.components;

import dinoscientist.interfaces.IClient;
import java.util.Random;

public class Patient implements IClient{

    private int[] disease;

    private IDataSet DataSet;

    public void dataSetConnect( IDataSet data ){
        this.DataSet = data;    // (2) pegue um sintoma randômico;
    }
    
    public void generateDisease(){
        
        int n_diseases;
        String sintomas[] = DataSet.requestAttributes();
        for ( n_diseases = 0; n_diseases < sintomas.length; n_diseases++ ){} // Incrementador de n_diseases.
        
        Random rand = new Random();
        
        this.disease = new int[n_diseases];
        
        for ( int idx = 0 ; idx < n_diseases ; idx++ ){
            disease[idx] = rand.nextInt(2);
            System.out.println(disease[idx]);
        }
    }

    public int[] getSintomas(){
        return this.disease; // 0 terá string
    }
}
