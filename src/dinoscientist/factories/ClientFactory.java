package dinoscientist.factories;

import dinoscientist.interfaces.IComponent;
import dinoscientist.components.Patient;

public class ClientFactory extends ComponentFactory{

    @Override
    public IComponent getComponent() {
        return new Patient();
    }
}