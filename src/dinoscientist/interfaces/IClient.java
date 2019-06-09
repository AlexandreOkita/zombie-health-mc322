package dinoscientist.interfaces;

import dinoscientist.interfaces.IComponent;

public interface IClient extends IComponent{
    public void dataSetConnect( IDataSet data );
    public void generateDisease();
    public int[] getSintomas();
}
