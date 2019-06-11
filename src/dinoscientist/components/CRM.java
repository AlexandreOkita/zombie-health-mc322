package dinoscientist.components;

import dinoscientist.interfaces.IComponent;
import dinoscientist.interfaces.ICRM;

public class CRM implements ICRM{
    
    Examine examine;
  
    public CRM( Examine examine){
        this.examine = examine;
    }
    
    public List<String> update( List<Intenger> respostas ){
        return this.examine.execute(dataset, respostas);
    }
}
