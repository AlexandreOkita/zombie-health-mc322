package dinoscientist.interfaces;

import dinoscientist.interfaces.IComponent;

public interface IDataSet extends IComponent{
    public String[] requestAttributes();
    public String[][] requestInstances();
}
