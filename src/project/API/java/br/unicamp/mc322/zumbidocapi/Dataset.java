package br.unicamp.mc322.zumbidocapi;

import java.io.File;
import java.util.List;

public class Dataset {

	public void upload(String filename) throws Exception {
		HttpServerConnection con = new HttpServerConnection();
		con.sendFile(new File(filename));
	}
	public List<String> list() throws Exception {
		HttpServerConnection con = new HttpServerConnection();
		StringBuilder sb = new StringBuilder();
		int ret = con.get("dataset/list",sb);		
		if ( ret == 200 ) {
			return JSON.toList(sb.toString());
		}
		return null;
	}
}
