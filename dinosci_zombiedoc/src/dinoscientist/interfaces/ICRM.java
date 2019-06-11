package dinoscientist.interfaces;

import java.util.List;

import dinoscientist.interfaces.IObserver;

public interface ICRM extends IObserver, IComponent{
    public List<String> update( List<Integer> respostas ) throws Exception;
}
