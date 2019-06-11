package dinoscientist.factories;

import dinoscientist.components.Doctor;
import dinoscientist.interfaces.IComponent;

public class DoctorFactory extends ComponentFactory{
  public IComponent getComponent(){
    return new Doctor(); 
  }
}
