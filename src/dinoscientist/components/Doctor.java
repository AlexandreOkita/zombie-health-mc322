public class Doctor implements IDoctor, ISubject{
    private String name;
    private String f_opinion;
    private ICRM council;
    private IPatient patient;
    private List<SintomaDoenca> sintomas;

    public Doctor(){
        this.name = this.toString();
        f_opinion = null;
        council = null;
        patient = null;
    }
    
    public List<SintomaDoenca> getSintoma() {
        return sintomas;   
    }
    public void connect(IPatient patient){
       this.patient = patient; 
    }

    public String diagnostic(IPatient pat, ArrayList<SintomaDoenca> questions){ //ARRUMAR PARAMETROS
        String opinion;
        int answer;
        List<String> others_opinions;

        connect(pat);

        System.out.println("Doctor: Hello, "+pat.getName()+ " I'm "+name);

        List<Integer> answers = new ArrayList<Integer>(); //ta certo o tipo okita?

        for(SintomaDoenca ques: questions)
        {
            System.out.println(ques+" ?");
            answer = (pat.getSintoma(ques.getSintoma()); 

            if (answer == 1)
            {  
                System.out.println("Patient: Yes");
                answers.add(answer);
                f_opinion = ques.getDoenca();
                break;
            }
            System.out.println("No");
        }

        System.out.println("Doctor: I think it is "+f_opinion);
        System.out.println("**Taking care of patient**");

    //     if(pat.getDoenca().equalsIgnoreCase(f_opinion)){
    //       System.out.println("We save "+pat.getNome());
    //       return f_opinion;
    //     }               
    //     else{ 
    //       System.out.println(pat.getName()+" is not getting better :(");
    //       System.out.println("I will check with the council");     

    //       others_opinions = notifyCRM(pat,answers);

    //       System.out.println("Then, it is " + others_opinions.get(1) );
    //       System.out.println("**Taking care of patient (again)**")

    //       if(pat.getDoenca().equalsIgnoreCase(f_opinion))
    //       {
    //         System.out.println("We save "+pat.getNome());
    //         return others_opinions.get(1);
    //       }
    //     }
      }

      public void notifyCRM(IPatient pat, List<Integer> respostas){
          List<String> second_opinion;
          second_opinion = council.update(respostas);
          for ( int idx = 0 ; i < second_opinion.size() ; ++i ){
              System.out.println(idx + ". second_opinion.get(idx) );
          }
      }

      public void attachCRM(ICRM council){
          this.council = council;
      }

      public void dettachCRM(){
          council = null;
      }
}
