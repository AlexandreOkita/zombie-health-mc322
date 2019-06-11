package dinoscientist.interfaces;

import dinoscientist.interfaces.IComponent;

public interface IClient extends IComponent{
    public void connectDataSet( IDataSet data );
    public void setDisease();
    public List<Integer> getSymp();
    public int getSintoma( String key );
    public String getName();
}
