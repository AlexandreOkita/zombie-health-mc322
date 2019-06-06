package br.unicamp.mc322.zumbidocapi;

import java.util.List;

public class DatatasetTeste {

	public static void main(String[] args) {
		Dataset dataset = new Dataset();
		try {
			dataset.upload("datasets/zombie-health-cases500-2.csv");
			List<String> datasets = dataset.list();
			for (String ds : datasets) {
				System.out.println(ds);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
