package dinoscientist.components;

import br.unicamp.mc322.zumbidocapi.Examine;
import dinoscientist.components.ICRM;
import dinoscientist.components.IComponent;

public class CRM implements ICRM{
    
    Examine examine;
  
    public connect(Examine examine){
        this.examine = examine;
    }
    
    public getExamine(){
        return this.examine;
    }
    
    public List<String> update( List<Intenger> respostas ){
        return this.examine.execute(dataset, respostas);
    }
}
