package dinoscientist.components;

import java.util.List;

import dinoapi.components.Examine;
import dinoscientist.interfaces.ICRM;
import dinoscientist.interfaces.IComponent;

public class CRM implements ICRM{
    
    Examine examine;
  
    public void connect(Examine examine){
        this.examine = examine;
    }
    
    public Examine getExamine(){
        return this.examine;
    }
    
    public List<String> update( List<Intenger> respostas ){
        return this.examine.execute(dataset, respostas);
    }
}
