//ObserverPattern - Subject
public interface IDoctor extends IComponent{
  public String diagnostic(ArrayList<SintomaDoenca> questions); //ESTAO CERTOS OS PARAMETROS?
  public List<String> notifyCRM(IPatient pat, List<Integer> respostas); //notify do pattern
}
