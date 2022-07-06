package Solution;

import java.util.Scanner;
import Solution.DictionaryManagement;

public class DictionaryCommandline {
	private DictionaryManagement dictionaryManage;
	private Scanner scan = new Scanner(System.in);
	
	public DictionaryCommandline() {
		dictionaryManage = new DictionaryManagement();
	}
	
	public void showAllWords() throws Exception {
		
		System.out.println("No        |English             |Vietnamese");
		for ( int i = 0; i < dictionaryManage.dictionary.get_list_word().size(); ++i ) {
			System.out.print(i + 1);
			for ( int j = 1; j <= 10 - Integer.toString(i + 1).length(); ++j ) System.out.print(' ');
			System.out.print('|');
			int length = dictionaryManage.dictionary.get_list_word().get(i).get_word_target().length();
			System.out.print(dictionaryManage.dictionary.get_list_word().get(i).get_word_target());
			for ( int j = 1; j <= 20 - length; ++j ) System.out.print(' ');
			System.out.print('|');
			System.out.println(dictionaryManage.dictionary.get_list_word().get(i).get_word_explain());
		}
		System.out.println("Enter number 0 to back to the menu");
		int choose = scan.nextInt();
	}
	
	public void dictionaryBasic() throws Exception {
		int choose;
		do {
			System.out.println("Enter number to choose: ");
			System.out.println("1. Add more words to dictionary");
			System.out.println("2. Show all words in dictionary");
			System.out.println("0. Exit");
			choose = scan.nextInt();
			if (choose == 1) {
				dictionaryManage.insertFromCommandline();
			}
			else if ( choose == 2 ) {
				showAllWords();
			}
			else if ( choose == 0 ) break;
			else {
				System.out.println("Something went wrong :(");
				System.out.println("Please try again!");
			}
		} while ( true );
	}
	
	public void dictionaryAdvanced() throws Exception {
		dictionaryManage.insertFromFile();
		int choose;
		do {
			System.out.println("Enter number to choose: ");
			System.out.println("1. Show all words in dictionary");
			System.out.println("2. Lookup dictionary");
			System.out.println("3. Edit dictionary");
			System.out.println("4. Export dictionary to file");
			System.out.println("0. Exit");
			choose = scan.nextInt();
			scan.nextLine();
			if (choose == 1) {
				showAllWords();
			}
			else if ( choose == 2 ) {
				dictionaryManage.dictionaryLookup();
			}
			else if ( choose == 3 ) {
				dictionaryManage.editDictionary();
			}
			else if ( choose == 4 ) {
				dictionaryManage.dictionaryExportToFile();
			}
			else if ( choose == 0 ) break;
			else {
				System.out.println("Something went wrong :(");
				System.out.println("Please try again!");
			}
		} while ( true );
	}
	
	public void dictionarySearcher() throws Exception {
		do {
			String word = scan.nextLine();
			int count = 0;
			for ( int i = 0; i < dictionaryManage.dictionary.get_list_word().size(); ++i ) {
				if ( dictionaryManage.dictionary.get_list_word().get(i).get_word_target().toLowerCase().indexOf(word.toLowerCase()) == 0 ) {
					System.out.println((i + 1) + '.' + dictionaryManage.dictionary.get_list_word().get(i).get_word_target());
				}
			}
			System.out.println("Do you want to search?");
			System.out.println("1. Yes\n2. No");
			int choose;
			do {
				choose = scan.nextInt();
				if ( choose != 1 && choose != 2 ) {
					System.out.println("Something went wrong :(");
					System.out.println("Please try again!");
				}
				else break;
			} while ( true );
			if ( choose == 2 ) break;
		} while ( true );
	}
}
