package Solution;

public class Word {
	private String word_target;
	private String word_explain;
	
	public Word() {
		
	}
	
	public Word(String word_target, String word_explain) {
		this.word_target = word_target;
		this.word_explain = word_explain;
	}
	
	public String get_word_target() {
		return word_target;
	}
	
	public void set_word_target(String word_target) {
		this.word_target = word_target;
	}
	
	public String get_word_explain() {
		return word_explain;
	}
	
	public void set_word_explain(String word_explain) {
		this.word_target = word_explain;
	}
}
