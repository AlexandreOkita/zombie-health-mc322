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
    ArrayList<String> answers = new ArrayList<String>();
    for(SintomaDoenca ques: questions){
      answer = (pat.getSintoma(ques.getSintoma()))//USAR HASH AQUI
      if (answer == 1){
        answers.add(ques.getSintoma());
        f_opinion = ques.getDoenca();
        break;
      }
    }
    if(pat.getDoenca().equalsIgnoreCase(f_opinion)){
      System.out.println("It is for sure "+f_opinion);
    }
    else{
      others_opinions = notifyCRM(pat);
      System.out.println("It is "+others_opinions.get(1));
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
