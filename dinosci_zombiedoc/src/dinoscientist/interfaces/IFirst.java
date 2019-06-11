package dinoscientist.interfaces;

import dinoscientist.interfaces.IComponent;
import dinoapi.interfaces.IQuestions;

import java.util.List;

import dinoapi.components.SintomaDoenca;
import dinoscientist.components.FirstOpinion;

public interface IFirst extends IComponent{
    public void connect(IQuestions question);
    public List<SintomaDoenca> getBestQuestion( String dataset ) throws Exception;
}
