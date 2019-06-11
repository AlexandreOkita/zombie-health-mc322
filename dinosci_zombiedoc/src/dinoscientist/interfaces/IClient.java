package dinoscientist.interfaces;

import dinoscientist.interfaces.IComponent;

public interface IClient extends IComponent{
    public void connectCRM ( ICRM crm );
    public void connectDataSet( IDataSet data );
    public void setDisease( int n_diseases );
    public int getSintoma( String key );
    public String getName();
}
