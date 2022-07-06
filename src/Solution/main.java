package Solution;

import Solution.DictionaryCommandline;

public class main {
	public static void main(String[] args) {
		DictionaryCommandline dictionary = new DictionaryCommandline();
		try {
			dictionary.dictionaryAdvanced();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Something went wrong :(");
		}
	}
}
