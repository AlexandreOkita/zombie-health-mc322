package dinoscientist.interfaces;

public interface ISubject{
  public void attachCRM(ICRM council);
  public void dettachCRM(ICRM council);
  public void notifyCRM(IPatient pat, List<Integer> respostas);
}
