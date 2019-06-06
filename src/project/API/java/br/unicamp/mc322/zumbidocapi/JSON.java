package br.unicamp.mc322.zumbidocapi;

import java.util.ArrayList;
import java.util.List;

public class JSON {

	
	public static List<String> toList(String value) {
		int size = value.length();
		int i = 0;
		int estado = 0;
		List<String> ret = new ArrayList<>();
		String str = "";
		boolean end = false;
		while (i < size && !end) {			
			switch (estado) {
			case 0: //aguarda [
				if ( value.charAt(i) == '[') {
					estado = 1;
				}
				break;
			case 1: //aguarda inicio string "
				if ( value.charAt(i) == '"') {
					estado = 2;
				}
				break;				
			case 2: // string
				if ( value.charAt(i) == '"') {
					estado = 3;
					ret.add(str);
					str = "";
				} else {
					str += value.charAt(i);
				}
				break;				
			case 3: // espera , ou ]
				switch (value.charAt(i)) {
				case ',':
					estado = 1;
					break;
				case ']':
					end = true;
					break;
				}
			} 
			i++;
		}
		return ret;
	}
	
	/**
	 * ["symp;disease","symp2;disease2"]
	 * @param value
	 * @return
	 */
	public static List<SintomaDoenca> toSintomaDoencaList(String value) {
		List<SintomaDoenca> ret = new ArrayList<>();
		List<String> listStr = toList(value);
		for (String tokens : listStr) {
			String [] t = tokens.split(";");
			SintomaDoenca sd = new SintomaDoenca();
			sd.setSintoma(t[0]);
			sd.setDoenca(t[1]);
			ret.add(sd);
		}
		return ret;
	}
	
	public static void main(String[] args) {
		List<String> list = JSON.toList("[\"dfafdafa\",\"aaaaaaa\"]");
		for (String string : list) {
			System.out.println(string);
		}
	}
}
