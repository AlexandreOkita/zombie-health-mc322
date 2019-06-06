package dinoscientist.factories;

import dinoscientist.factories.ComponentFactory;
import dinoscientist.interfaces.IComponent;
import dinoscientist.components.Patient;

public class ClientFactory extends ComponentFactory{
    public IComponent getClient(){
        return new Patient();
    }
}