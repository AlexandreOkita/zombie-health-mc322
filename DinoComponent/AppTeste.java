package br.unicamp.mc322.zumbidocapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AppTeste {

	public static void main(String[] args) throws Exception {
		Questoes quest = new Questoes();
		String dataset = "zombie-health-new-cases500.csv";
		List<SintomaDoenca> ret = quest.list(dataset);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> resp = new ArrayList<>();
		for (SintomaDoenca sd : ret) {
			System.out.println(sd.getSintoma()+", "+sd.getDoenca());
		}
		SintomaDoenca primeira = null;
		for (SintomaDoenca sd : ret) {
			System.out.println(sd.getSintoma()+"?(1 tem ou 0 nao tem)");
			String r = reader.readLine();
			resp.add(Integer.parseInt(r));
			if ( r.equals("1") && primeira == null) {
				primeira = sd;
				break;
			}
		}
		System.out.println("Primeira opção: "+primeira.getDoenca());
		List xx = new ArrayList<Integer>();
		xx.add(0);
		xx.add(1);
		xx.add(0);
		xx.add(0);
		xx.add(0);
		xx.add(0);
		xx.add(0);
		xx.add(1);
		
		Examine examine = new Examine();
		List<String> outrasOpcoes =examine.execute(dataset, xx);
		int i = 1;
		for (String opc : outrasOpcoes) {
			System.out.println("Doenca "+i+":"+opc);
			i++;
		}
	}
}
