package br.unicamp.mc322.zumbidocapi;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class Examine {
	public List<String> execute(String dataset, List<Integer> respostas) throws Exception {
		HttpServerConnection con = new HttpServerConnection();
		StringBuilder respostasStr = new StringBuilder();
		int i = 0;
		for (Integer r : respostas) {
			if ( i++ > 0) {
				respostasStr.append(",");
			}
			respostasStr.append(r);
		}
		StringBuilder sb = new StringBuilder();
		int ret = con.get("examine?dataset="+URLEncoder.encode(dataset, "UTF-8")+"&symp="+respostasStr, sb);
		if ( ret == 200 ) {
			List<String> strs = JSON.toList(sb.toString());
			String[] strArr = strs.get(0).split(";");
			List<String> retList = new ArrayList<>();
			for (String s : strArr) {
				retList.add(s);
			}
			return retList;
		} else {
			return null;
		}
	}

}
