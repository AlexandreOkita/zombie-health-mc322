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
    ArrayList<String> others_opinions;
    connect(pat);
    ArrayList<String> answers = new ArrayList<String>();
    for(SintomaDoenca ques: questions){
      answers.add(pat.getSintoma(ques.getSintoma()))//USAR HASH AQUI
      
    }
    opinion = get();//TROCAR AQUI NOME DA FUNCAO
    others_opinions = notifyCRM(pat);
    if((second_opinion.get(0)).equalsIgnoreCase(f_opinion)){
      System.out.println("It is "+f_opinion+" ,but could be "+others_opinions.get(1));
      return f_opinion;
    }
    else{
      f_opinion = f_opinion + " or " + others_opinions.get(0);
      System.out.println(" "+f_opinion);
    }
    return f_opinion;
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
