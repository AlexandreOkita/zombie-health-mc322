package dinoscientist.interfaces;

import dinoscientist.interfaces.IObserver;

public interface ICRM extends IObserver, IComponent{
    public List<String> update( List<Intenger> respostas );
}
