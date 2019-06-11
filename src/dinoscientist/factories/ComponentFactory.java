package dinoscientist.factories;

import dinoscientist.interfaces.IComponent;
import dinoscientist.interfaces.IComponentFactory;

public abstract class ComponentFactory implements IComponentFactory{
    public abstract IComponent getComponent();
}
