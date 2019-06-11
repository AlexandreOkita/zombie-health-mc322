package dinoscientist.main;

import java.util.ArrayList;
import java.util.List;

import dinoapi.components.Examine;
import dinoapi.components.Questoes;
import dinoapi.components.SintomaDoenca;
import dinoscientist.components.DataSet;
import dinoscientist.components.Doctor;
import dinoscientist.components.Patient;
import dinoscientist.factories.DoctorFactory;
import dinoscientist.factories.GeneralFactory;

import pt.clubedohardware.userinterface.*;

public class DinoMaincer {
	public static void main(String[] args) throws Exception {
		
		String dataset = "zombie-health-cases500.csv";
		
		DataSet ds = new DataSet();
		ds.setDataSource(dataset);
		Patient patient = new Patient();
		patient.connectDataSet(ds);
		patient.setDisease();
		
		Questoes q = new Questoes();
		List <SintomaDoenca> questions = q.list(dataset);
		
		
		Doctor doctor = new Doctor();
		doctor.connect(patient);
		List<String> answers = doctor.diagnostic(questions);
		for (String answer : answers) {
			System.out.println(answer);
		}
		
		Examine examine = new Examine();
		List<String> otherOpinion = examine.execute(dataset, patient.getSymp());
		for (String other : otherOpinion) {
			System.out.println(other);
		}
		
		
		UserInterface g = new UserInterface(answers);
		IAnimationC teste = new AnimationC();
		teste.setWindowName("Dino Scientists");
        teste.setDocName("Doutor");
        teste.setPacientName("Paciente");
        g.addAnswer("Pode dar uma an�lise melhor?");
        g.addAnswer("Analisando melhor voc� pode possuir " + otherOpinion.get(0) + " ou " + otherOpinion.get(1));
        String[] falas = g.getStringArray();
        String[] personagem = g.getOrder();
        teste.story(falas, personagem);
	}
}
