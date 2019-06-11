package dinoscientist.components;

import dinoscientist.interfaces.IFirst;
import dinoscientist.interfaces.IComponent;

public class FirstOpinion extends IFirst{
    Question question;

    public connect ( Question question ){
        this.question = question;
    }

    public List<SintomaDoenca> getBestQuestion( String dataset ){
        return this.question.list(String dataset);
    }
}

