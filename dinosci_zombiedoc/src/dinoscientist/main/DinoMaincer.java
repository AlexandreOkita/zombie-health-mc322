package dinoscientist.main;

import java.util.ArrayList;
import java.util.List;

import dinoapi.components.Questoes;
import dinoapi.components.SintomaDoenca;
import dinoscientist.components.DataSet;
import dinoscientist.components.Doctor;
import dinoscientist.components.Patient;
import dinoscientist.factories.DoctorFactory;
import dinoscientist.factories.GeneralFactory;

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
	}
}
