package dinoscientist.components;

import dinoscientist.interfaces.IFirst;
import dinoapi.interfaces.IQuestion;

import dinoscientist.interfaces.IComponent;

public class FirstOpinion extends IFirst{
    
    IQuestion question;

    public connect ( IQuestion question ){
        this.question = question;
    }

    public List<SintomaDoenca> getBestQuestion( String dataset ){
        return this.question.list(String dataset);
    }
}