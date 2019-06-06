package br.unicamp.mc322.zumbidocapi;

import java.net.URLEncoder;
import java.util.List;

public class Questoes {

	public List<SintomaDoenca> list(String dataset) throws Exception {
		HttpServerConnection con = new HttpServerConnection();
		StringBuilder sb = new StringBuilder();
		int ret = con.get("questions?dataset="+URLEncoder.encode(dataset, "UTF-8"), sb);
		if ( ret == 200 ) {
			return JSON.toSintomaDoencaList(sb.toString());
		} else {
			return null;
		}
	}
	
}
