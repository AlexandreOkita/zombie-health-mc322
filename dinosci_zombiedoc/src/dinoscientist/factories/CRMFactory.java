package dinoscientist.factories;

import dinoscientist.interfaces.IComponent;
import dinoscientist.components.CRM;

public class CRMFactory extends ComponentFactory{
    @Override
    public IComponent getComponent() {
        return new CRM();
    }
}
