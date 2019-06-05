package dinoscientist.factories;

import dinoscientist.interfaces.IComponentFactory;

public class GeneralFactory{
    public static IComponentFactory createFactory(String ftype){
        IComponentFactory result = null;
        if(ftype.equals("Opinion")){
            result = new OpinionFactory();
        }
        return result;
    }
}