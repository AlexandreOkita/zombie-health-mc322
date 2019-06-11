public class DoctorFactory implements IComponentFactory{
  Doctor createDoctor(String name){
    return new Doctor(name); 
  }
}
