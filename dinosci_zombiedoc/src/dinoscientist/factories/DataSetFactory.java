package dinoscientist.factories;

import dinoscientist.interfaces.IComponent;
import dinoscientist.components.DataSet

public class DataSetFactory extends ComponentFactory{

  @Override
  public IComponent getComponent(){
    return new DataSet();
  }
}
