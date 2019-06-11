package dinoscientist.factories;

import dinoscientist.factories.*;

public class GeneralFactory{
    public static ComponentFactory createFactory(String ftype){
        ComponentFactory result = null;
        if(ftype.equals("client")){
            result = new ClientFactory();
        }
        else if(ftype.equals("doctor")){
            result = new DoctorFactory();
        }
        return result;
    }
}