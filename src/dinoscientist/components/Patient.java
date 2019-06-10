public class Patient implements IClient{

    private ArrayList<Integer> disease;
    private int n_sintomas;

    private IDataSet DataSet;

    public void dataSetConnect( IDataSet data ){
        this.DataSet = data;    // (2) pegue um sintoma randômico;
        String[] att = dataset.requestAttributes();
        int i;
        for ( i = 0 ; i < att.length ; ++i ){}
        this.n_sintomas = i;
    }
    
    public void setDisease(int n_diseases){
        
        Random rand = new Random();
        
        this.disease = new ArrayList<>();
        
        for ( int idx = 0 ; idx < n_diseases ; idx++ ){
            disease.add(rand.nextInt(2));
            System.out.println(disease.get(idx));
        }
    }
    public ArrayList<Integer> getSintomas(){
        return this.disease;
    }
    public int getN_sintomas(){
        return this.n_sintomas;
    }
}
