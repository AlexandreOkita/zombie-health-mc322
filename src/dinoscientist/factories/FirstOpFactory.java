package dinoscientist.factories;

import dinoscientist.interfaces.IComponent;
import dinoscientist.components.FirstOpinion;

public class FirstOpFactory extends ComponentFactory{
    @Override
    public IComponent getComponent() {
        return new FirstOpinion();
    }
}
