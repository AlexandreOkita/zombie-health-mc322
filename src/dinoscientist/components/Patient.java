package dinoscientist.components;

import dinoscientist.interfaces.IClient;

// public interface IDataSet
// {
//     public String[] getSintoma();
// }

// public class DataSet implements IDataSet{
//     public String[] getSintoma()
//     {
//         return null; // (1) retorna vetor randômico de strings da doença
//     }
// }

public class Patient implements IClient{

    private String[] disease;
    private String disease_name;

    private IDataSet DataSet;

    public Patient(){
        this.disease = DataSet.getSintoma();
    }

    public void DataSetConnect( IDataSet data ){
        this.DataSet = data;    // (2) pegue um sintoma randômico
    }

    public String getDoencaName(){
        return disease_name; // 0 terá string
    }
}
