package dinoscientist.components;

import java.util.List;

import dinoapi.components.Examine;
import dinoscientist.interfaces.ICRM;
import dinoscientist.interfaces.IComponent;

public class CRM implements ICRM{
    
    private Examine examine;
    private String dataset;
  
    public void connect(Examine examine, String dataset){
        this.examine = examine;
        this.dataset = dataset;
    }
    
    public Examine getExamine(){
        return this.examine;
    }
    
    public List<String> update( List<Integer> respostas ) throws Exception{
        return this.examine.execute(dataset, respostas);
    }
}
