package dinoscientist.factories;

public class GeneralFactory{
    public static ComponentFactory createFactory(String ftype){
        ComponentFactory result = null;
        if(ftype.equals("client")){
            result = new ClientFactory();
        }
        return result;
    }
}