package dinoscientist.interfaces;
//Interface da Fabrica Abstrata que as outras fabricas implementarão

public interface IComponentFactory{
  public IComponent createComponent(String type);
}
