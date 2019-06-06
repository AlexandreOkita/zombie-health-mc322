public class DoctorFactory implements IComponentFactory{
  Doctor createDoctor(String name){ //talvez precise de mais parametros para linkar com a tabela etc
    return new Doctor(name); 
  }
}
