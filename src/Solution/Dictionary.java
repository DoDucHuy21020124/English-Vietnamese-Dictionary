package Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Solution.Word;

public class Dictionary {
	private ArrayList<Word> list_word;
	
	public Dictionary() {
		list_word = new ArrayList<Word>();
	}
	
	public ArrayList<Word> get_list_word() {
		return list_word;
	}
	
	public void sortDictionary() {
        Collections.sort(list_word, new compareWord());
    }
	
}

class compareWord implements Comparator<Word> {
    public int compare(Word w1, Word w2) {
        return w1.get_word_target().compareTo(w2.get_word_target());
    }
}