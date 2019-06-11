package dinoscientist.interfaces;

import java.util.ArrayList;
import java.util.List;

import dinoapi.components.SintomaDoenca;
//ObserverPattern - Subject
public interface IDoctor extends IComponent{
  public List<String> diagnostic(List<SintomaDoenca> questions); //ESTAO CERTOS OS PARAMETROS?
//  public List<String> notifyCRM(IClient pat, List<Integer> respostas); //notify do pattern
}
