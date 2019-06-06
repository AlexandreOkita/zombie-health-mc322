public class Doctor implements IDoctor, ISubject{
  private String name;
  private String f_opinion;
  private ICRM conselho;

  public Doctor(String name){
    this.name = name;
    f_opinion = null;
    conselho = null;
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
    this.conselho = conselho;
  }

  public void dettachCRM(){
    conselho = null;
  }
}
