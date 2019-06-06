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
    
  public String diagnostic(IPatient pat, ArrayList...){ //ARRUMAR PARAMETROS
    String opinion;
    opinion = method();//TROCAR AQUI NOME DA FUNCAO
    f_opinion = opinion;
    return f_opinion;
  }

  public String askOpinion2(IPatient pat){
    String second_opinion;
    second_opinion = conselho.searchfordesease(pat); //trocar aqui nome da funcao
    if(second_opinion.equalsIgnoreCase(f_opinion))
      return f_opinion;
    else{
      f_opinion = f_opinion + " or " + second_opinion;
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
