package Solution;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import Solution.Dictionary;

public class DictionaryManagement {
	private Scanner scan = new Scanner(System.in, "UTF-8");
	public Dictionary dictionary;
	public DictionaryManagement() {
		dictionary = new Dictionary();
	}
	
	public void insertFromCommandline() throws Exception {
		do {
			System.out.print("Enter the number of words: ");
			int numberOfWord = scan.nextInt();
			scan.nextLine();
			for ( int i = 1; i <= numberOfWord; ++i ) {
				
				System.out.print("Enter word target: ");
				String word_target = scan.next();
				System.out.print("Enter word explain: ");
				scan.nextLine();
				String word_explain = scan.nextLine();
				dictionary.get_list_word().add(new Word(word_target, word_explain));
			}
			
			int choose;
			do {
				System.out.println("Do you want to add more words?");
				System.out.println("1. Yes\n2. No");
				choose = scan.nextInt();
				scan.nextLine();
				if ( choose != 1 && choose != 2 ) {
					System.out.println("Something went wrong :(");
					System.out.println("Please try again!");
				}
				else break;
			} while ( true );
			
			if ( choose == 2 ) break;
			
		} while ( true );
	}
	
	public void insertFromFile() {
        try {
            File input = new File(".\\data\\dictionaries.txt");
            Scanner sc = new Scanner(input, "UTF-8");

            while (sc.hasNext()) {
                String line = sc.nextLine();
                String word_target = "";
                String word_explain = "";
                int i = 0;
                while ( line.charAt(i) != '\t' ) {
                	word_target += line.charAt(i);
                	++i;
                }
                while ( line.charAt(i) == '\t' ) ++i;
                while ( i < line.length() ) {
                	word_explain += line.charAt(i);
                	++i;
                }

                Word newWord = new Word(word_target, word_explain);
                if ( !dictionary.get_list_word().contains(newWord) ) {
                	dictionary.get_list_word().add(newWord);
                }
            }
            sc.close();
            System.out.println("Add words from file successful!");
            dictionary.sortDictionary();
        }
        catch (IOException e) {
            System.out.println("File not found");
        }
    }
	
	public void dictionaryLookup() throws Exception {
		do {
			System.out.print("Search: ");
			String word = scan.nextLine();
			int count = 0;
			System.out.println("No        |English             |Vietnamese");
			for ( int i = 0; i < dictionary.get_list_word().size(); ++i ) {
				if ( dictionary.get_list_word().get(i).get_word_target().toLowerCase().indexOf(word.toLowerCase()) == 0 ) {
					++count;
					System.out.print(count);
					for ( int j = 1; j <= 10 - Integer.toString(count).length(); ++j ) System.out.print(' ');
					System.out.print('|');
					int length = dictionary.get_list_word().get(i).get_word_target().length();
					System.out.print(dictionary.get_list_word().get(i).get_word_target());
					for ( int j = 1; j <= 20 - length; ++j ) System.out.print(' ');
					System.out.print('|');
					System.out.println(dictionary.get_list_word().get(i).get_word_explain());
				}
			}
			
			int choose;
			do {
				System.out.println("Do you want to search?");
				System.out.println("1. Yes\n2. No");
				choose = scan.nextInt();
				scan.nextLine();
				if ( choose != 1 && choose != 2 ) {
					System.out.println("Something went wrong :(");
					System.out.println("Please try again!");
				}
				else break;
			} while( true );
			if ( choose == 2 ) break;
		} while(true);
	}
	
	public void editDictionary() throws Exception {
		System.out.print("Enter word to edit: ");
		String word = scan.nextLine().toLowerCase();
		int index = -1;
		for ( int i = 0; i < dictionary.get_list_word().size(); ++i ) {
			if ( dictionary.get_list_word().get(i).get_word_target().toLowerCase().equals(word) ) {
				index = i;
				break;
			}
		}
		if ( index == -1 ) {
			System.out.println("No word found");
		}
		else {
			int choose;
			do {
				System.out.println("1. Edit word target");
				System.out.println("2. Edit word explain");
				System.out.println("3. Add more words");
				System.out.println("4. Delete word");
				System.out.println("0. Back");
				System.out.print("Enter number to choose: ");
				choose = scan.nextInt();
				scan.nextLine();
				if ( choose != 1 && choose != 2 && choose != 3 && choose != 4 ) {
					System.out.println("Something went wrong :(");
					System.out.println("Please try again!");
				}
				else break;
				
			} while ( true );
			
			if ( choose == 1) {
				System.out.print("Enter new word target: ");
				word = scan.nextLine();
				dictionary.get_list_word().get(index).set_word_target(word);
			}
			
			else if ( choose == 2) {
				System.out.print("Enter new word explain");
				word = scan.nextLine();
				dictionary.get_list_word().get(index).set_word_explain(word);
			}
			
			else if ( choose == 3 ) {
				insertFromCommandline();
			}
			
			else if ( choose == 4 ) {
				dictionary.get_list_word().remove(index);
			}
			
			dictionary.sortDictionary();
			System.out.println("Edit dictionary successful!");
		}
	}
	
	public void dictionaryExportToFile() {
		try {
			FileWriter file = new FileWriter(".\\data\\output.txt");
			file.write("No        |English             |Vietnamese\n");
			
			for ( int i = 0; i < dictionary.get_list_word().size(); ++i ) {
				file.write(Integer.toString(i + 1));
				for ( int j = 1; j <= 10 - Integer.toString(i + 1).length(); ++j ) file.write(' ');
				file.write('|');
				int length = dictionary.get_list_word().get(i).get_word_target().length();
				file.write(dictionary.get_list_word().get(i).get_word_target());
				for ( int j = 1; j <= 20 - length; ++j ) file.write(' ');
				file.write('|');
				file.write(dictionary.get_list_word().get(i).get_word_explain());
				file.write('\n');
			}
			file.close();
			System.out.println("Export to file successful!");
		}
		catch(Exception e) {
			System.out.println("No path found");
		}
	}
	
}
