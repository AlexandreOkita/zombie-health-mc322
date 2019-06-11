
package dinoscientist.interfaces;

import dinoscientist.interfaces.IComponent;
import dinoscientist.interfaces.IQuestion;

import dinoscientist.components.FirstOpinion;

public interface IFirst extends IComponent{
    public void connect( IQuestion );
    public List<SintomaDoenca> getBestQuestion( String dataset );
}
