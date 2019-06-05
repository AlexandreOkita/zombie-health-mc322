package dinoscientist.main;

import dinoscientist.factories.GeneralFactory;
import dinoscientist.interfaces.IComponentFactory;

public class Main{
    public static void main(String[] args){
        /**
         * Primeira atividade da main será abrir a tabela de entrada e mandar para os responsáveis
         * aka segunda opiniao e tabela de correlações
         * Então, vamos pedir ao factory esses componentes e mandar a tabela para eles
        */
        IComponentFactory opinionFactory = GeneralFactory.createFactory("Opinion");
        //    GeneralFactory.createFactory("opinion").createSecondOpinion(DATASET) ????
        //aqui fica a tabela que lê o dataset... nao sei como criar
        
        /**
         * primeiraOpiniao = opinionFactory.createPrimeiraOpiniao(tabela);

            conselhoDeDoutores(segundaopiniao);

            opinionFactory.createDoctor(primeiraOPiniao, paciente);

         */
        
    }
}