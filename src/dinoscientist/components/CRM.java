package dinoscientist.components;

import dinoscientist.interfaces.IComponent;
import dinoscientist.interfaces.ICRM;

public class CRM implements ICRM{
    
    Examine examine;
  
    public connect( Examine examine ){
        this.examine = examine;
    }
    
    public getExamine(){
        return this.examine;
    }
    
    public List<String> update( List<Intenger> respostas ){
        return this.examine.execute(dataset, respostas);
    }
}
