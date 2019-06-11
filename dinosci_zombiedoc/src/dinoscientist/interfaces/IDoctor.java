package dinoscientist.interfaces;

import java.util.ArrayList;
import java.util.List;

import dinoapi.components.SintomaDoenca;

public interface IDoctor extends IComponent{
    public List<SintomaDoenca> getSintoma();
    public List<Integer> getRespostas();
    public String getFOpinion();
    public void connect( ICRM crm );
    public void connect(IClient patient);
    public List<String> diagnostic(List<SintomaDoenca> questions);
}
