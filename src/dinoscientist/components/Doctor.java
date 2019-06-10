public class Doctor implements IDoctor, ISubject{
  private String name;
  private String f_opinion;
  private ICRM council;
  private IPatient patient;

  public Doctor(String name){
    this.name = name;
    f_opinion = null;
    council = null;
    patient = null;
  }
  
  public void connect(IPatient patient){
    this.patient = patient;
  }
    
  public String diagnostic(IPatient pat, ArrayList<SintomaDoenca> questions){ //ARRUMAR PARAMETROS
    String opinion;
    int answer;
    ArrayList<String> others_opinions;
    connect(pat);
    System.out.println("Doctor: Hello, "+pat.getName());

    ArrayList<String> answers = new ArrayList<String>();
    for(SintomaDoenca ques: questions){
      System.out.println(ques+" ?");
      answer = (pat.getSintoma(ques.getSintoma()); 
      if (answer == 1){
        System.out.println("Yes");
        answers.add(ques.getSintoma());
        f_opinion = ques.getDoenca();
        break;
      }
      System.out.println("No");
    }
    System.out.println("Doctor: I think it is "+f_opinion);
    System.out.println("**Taking care of patient**")
    if(pat.getDoenca().equalsIgnoreCase(f_opinion)){
      System.out.println("We save "+pat.getNome());
      return f_opinion;
    }
    else{
      System.out.println(pat.getName()+" is not getting better :(");
      System.out.println("I will check with the council");
      others_opinions = notifyCRM(pat);
      System.out.println("Then, it is "+others_opinions.get(1));
      return others_opinions.get(1);
    }
  }

  public String notifyCRM(IPatient pat, ArrayList<String> retList){
    String second_opinion;
    second_opinion = council.updateDesease(pat); //trocar aqui nome da funcao
      return f_opinion;
    }
  }

  public void attachCRM(ICRM conselho){
    this.council = council;
  }

  public void dettachCRM(){
    council = null;
  }
}
