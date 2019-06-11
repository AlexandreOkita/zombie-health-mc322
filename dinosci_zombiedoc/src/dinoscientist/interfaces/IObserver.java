package dinoscientist.interfaces;

import java.util.List;

public interface IObserver{
    public List<String> update( List<Integer> respostas ) throws Exception;
}