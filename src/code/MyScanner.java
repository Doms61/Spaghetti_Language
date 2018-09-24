package code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyScanner {
	private File file;
	private BufferedReader br;
	private Scanner sc;
	private char token;
	//private final ArrayList<Token> currentTokens = new ArrayList<>();
	private ArrayList<String> words = new ArrayList<>();
	private ArrayList<Character> c = new ArrayList<>();
	
	public MyScanner(File file) {
		try {
			this.file = file;
			br = null;
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void scan() {
		
		while(sc.hasNextLine()) {
			String str = sc.next();
			//if(isLineTerminator(sc.next().charAt(0)));
			char[] myChar = str.toCharArray();
			for(int i = 0; i < myChar.length; i++)
			{
				if(!isWhitespace(myChar[i])) {
					c.add(myChar[i]);
				}
			}
			words.add(stringRepre(c));
		}
	}
	
	public String stringRepre(ArrayList<Character> list) {
		StringBuilder builder = new StringBuilder(list.size());
		for(Character ch: list) {
			builder.append(ch);
		}
		return builder.toString();
	}
	
	private static boolean isWhitespace(char ch) {
		switch (ch) {
		case '\u0009':  // Tab
	    case '\u000B':  // Vertical Tab
	    case '\u000C':  // Form Feed
	    case '\u0020':  // Space
	    case '\u00A0':  // No-break space
	    case '\uFEFF':  // Byte Order Mark
	    case '\n':      // Line Feed
	    case '\r':      // Carriage Return
	    case '\u2028':  // Line Separator
	    case '\u2029':  // Paragraph Separator
	        // TODO: there are other Unicode Category 'Zs' chars that should go here.
	      return true;
	    default:
	      return false;
		}
	}
	
	 private static boolean isLineTerminator(char ch) {
		    switch (ch) {
		      case '\n': // Line Feed
		      case '\r':  // Carriage Return
		      case '\u2028':  // Line Separator
		      case '\u2029':  // Paragraph Separator
		        return true;
		      default:
		        return false;
		    }
		  }
	 
	 private void skipComents() {
		 while(skipComment())
		 {}
	 }
	 
	 private boolean skipComment() {
		 // Check if there is // or /*
		 
		 return false;
	 }
}
