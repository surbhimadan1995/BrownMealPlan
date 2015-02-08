package in.tusharbhargava.mealscrape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StringFormatting {
	
	private List<String> _stringList = null;
	private List<String[]> _listOfStringArrays = new ArrayList<String[]>();
	private List<String[]> _soups = new ArrayList<String[]>();
	private List<String[]> _proteinList = new ArrayList<String[]>();
	private List<String> _hashProteinList = new ArrayList<String>();
	private HashMap<String, List<String>> categoryMap = new HashMap<String, List<String>>();
	
	public StringFormatting(List<String> stringsList) {
		_stringList = stringsList;
		stripCommas();
		for (String s: _stringList) {
			_listOfStringArrays.add(s.split(" "));
		}
		
		for (String[] array: _listOfStringArrays) {
			for (String str: array) {
//				System.out.println(str);
			}
		}
		findSoup();
	}
	
	public void stripCommas() {
		for (String str: _stringList) {
			str = str.replaceAll(",", "");
			str = str.replace("\"", "");
		
		}
	}
	
	public void findSoup() {
		for (String[] array: _listOfStringArrays) {
			for (String s: array) {
				if (s.equals("soup")) {
					_soups.add(array);
				}
				if(s.equals("chicken") || s.equals("cheese") || s.equals("pork")) {
					_proteinList.add(array);
				}
				
			}
		}
		String s = "";
		for(String[] array: _soups) {
			for(String soup: array) {
			    if (!soup.equals("")) {
			    	s+=(soup+" ");
//			    	System.out.println("SOUP: " + soup);
			    }
				
			}
		}
		
		String prt = "";
		for(String[] array: _proteinList) {
			for(String protein: array) {
				if(!protein.equals("")) {
					prt+=(protein+" ");
				}
			}
			_hashProteinList.add(prt);
			categoryMap.put("protein", _hashProteinList);
		}
		
		System.out.println(s);
		String new_string = "";
		boolean start = false;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ':') {
				start = true;
			}
			
			if(start) {
				new_string+=s.charAt(i);
			}
		}
		new_string = new_string.replace(":", "");
		new_string = new_string.replace("soup & bread station:", "");
		new_string = new_string.replace("\"", "");
		System.out.println(new_string);
		
		for(String str: categoryMap.get("protein")) {
			System.out.println("PROTEIN: " + str);
		}
	}
	
	
}