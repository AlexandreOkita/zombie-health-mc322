package dinoscientist.factories;

import dinoscientist.factories.ComponentFactory;
import dinoscientist.factories.ClientFactory;

public class GeneralFactory{
    public static ComponentFactory createFactory(String ftype){
        ComponentFactory result = null;
        if(ftype.equals("client")){
            result = new ClientFactory();
        }
        return result;
    }
}