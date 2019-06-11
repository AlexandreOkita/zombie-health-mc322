package dinoscientist.main;

import dinoscientist.components.Patient;
import dinoscientist.factories.ComponentFactory;
import dinoscientist.factories.GeneralFactory;
import dinoscientist.interfaces.IClient;
import dinoscientist.interfaces.IComponent;

public class Main{

    public static void main(String[] args) {
        ComponentFactory factory = GeneralFactory.createFactory("client");
        IClient patient = (IClient) factory.getComponent();
        System.out.println(patient.test());
        
    }
}