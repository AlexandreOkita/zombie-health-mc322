package dinoscientist.interfaces;

import dinoscientist.interfaces.IComponent;

public interface IClient extends IComponent{
    public void dataSetConnect( IDataSet data );
    public void setDisease( int n_diseases );
    public ArrayList<Integer> getSintomas();
    public int getN_sintomas();
}
