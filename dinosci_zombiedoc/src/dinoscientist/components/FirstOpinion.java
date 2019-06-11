package dinoscientist.components;

import dinoscientist.interfaces.IFirst;

import java.util.List;

import dinoapi.components.SintomaDoenca;
import dinoapi.interfaces.IQuestions;

import dinoscientist.interfaces.IComponent;

public class FirstOpinion implements IFirst{
    
    IQuestions question;

    public void connect ( IQuestions question ){
        this.question = question;
    }

    public List<SintomaDoenca> getBestQuestion( String dataset ) throws Exception{
        return this.question.list(dataset);
    }
}