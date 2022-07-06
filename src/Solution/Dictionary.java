package Solution;

import java.util.ArrayList;
import Solution.Word;

public class Dictionary {
	private ArrayList<Word> list_word;
	
	public Dictionary() {
		list_word = new ArrayList<Word>();
	}
	
	public ArrayList<Word> get_list_word() {
		return list_word;
	}
}
