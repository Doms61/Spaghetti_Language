package approach_v2;

public class Scanner {
	private SourceFile source;
	
	private char currentChar;
	private StringBuffer currentSpelling = new StringBuffer();
	
	public Scanner(SourceFile source) {
		this.source = source;
		currentChar = source.getSource();
	}
	
	private void takeIt() {
		currentSpelling.append(currentChar);
		currentChar = source.getSource();
	}
	
	private boolean isLetter(char c) {
		return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
	}
	
	private boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}
	
	private void scanSeparator()
	{
		switch( currentChar ) {
			case '#':
				takeIt();
				while( currentChar != SourceFile.EOL && currentChar != SourceFile.EOT )
					takeIt();
					
				if( currentChar == SourceFile.EOL )
					takeIt();
				break;
				
			case ' ': case '\n': case '\r': case '\t':
				takeIt();
				break;
		}
	}
	
	private byte scanToken() {
		if(isLetter(currentChar)) {
			takeIt();
			while(isLetter(currentChar) || isDigit(currentChar))
				takeIt();
			
			return Token.IDENTIFIER;
		}
		else if(isDigit(currentChar)) {
			takeIt();
			while(isDigit(currentChar))
				takeIt();
			
			return Token.INTEGERLITERAL;
		}
		else if(currentChar == SourceFile.EOT)
			return Token.EOT;
		
		else
			takeIt(); return Token.ERROR;
	}
	
	public Token scan() {
		while(currentChar == '#' || currentChar == '\n' ||
		       currentChar == '\r' || currentChar == '\t' ||
		       currentChar == ' ' )
			scanSeparator();
		
		currentSpelling = new StringBuffer("");
		byte kind = scanToken();
		
		return new Token(kind, new String(currentSpelling));
	}
}
