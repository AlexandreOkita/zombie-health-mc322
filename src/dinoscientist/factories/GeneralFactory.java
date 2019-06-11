package dinoscientist.factories;

public abstract class GeneralFactory{
    public ComponentFactory createFactory(String ftype){
        ComponentFactory result = null;
        if(ftype.equals("client")){
            result = new ClientFactory();
        }
        return result;
    }
}
