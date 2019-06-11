package dinoscientist.components;

import java.util.ArrayList;
import java.util.List;

import dinoapi.components.SintomaDoenca;
import dinoscientist.interfaces.ICRM;
import dinoscientist.interfaces.IClient;
import dinoscientist.interfaces.IDoctor;
import dinoscientist.interfaces.ISubject;

public class Doctor implements IDoctor{
    private String name;
    private String f_opinion;
    private ICRM council;
    private IClient patient;
    private List<SintomaDoenca> sintomas; //importantes para o uso da interface gráfica
    private List<Integer> respostas;

    public Doctor(){
        this.name = this.toString();
        f_opinion = null;
        council = null;
        patient = null;
        sintomas = null;
        respostas = null;
    }
    
    public List<SintomaDoenca> getSintoma() {
        return sintomas;   
    }
    
    public List<Integer> getRespostas() {
        return respostas;
    }
    
    public String getFOpinion() {
        return f_opinion;   
    }
    
    public void connect(IClient patient){
       this.patient = patient; 
    }

    public List<String> diagnostic(List<SintomaDoenca> questions){ //ARRUMAR PARAMETROS
        String opinion;
        List<String> text = new ArrayList<String>();
        int answer;
        List<String> others_opinion = new ArrayList<String>();

        text.add("Hello, "+patient.getName()+ " I'm "+name);

        List<Integer> answers = new ArrayList<Integer>();

        for(SintomaDoenca ques: questions)
        {
            text.add(ques.getSintoma()+"?");
            answer = (patient.getSintoma(ques.getSintoma())); 

            if (answer == 1)
            {  
                text.add("Yes");
                answers.add(answer);
                f_opinion = ques.getDoenca();
                break;
            }
            text.add("No");
        }

        text.add("I think it is "+f_opinion);
        
        return text;
          }

//      public void notifyCRM(IClient pat, List<Integer> respostas){
//          List<String> second_opinion;
//          second_opinion = council.update(respostas);
//          for ( int idx = 0 ; idx < second_opinion.size() ; ++idx ){
//              System.out.println(idx + "." + second_opinion.get(idx) );
//          }
//      }
      public void attachCRM(ICRM council){
          this.council = council;
      }
      public void dettachCRM(){
          council = null;
      }
}