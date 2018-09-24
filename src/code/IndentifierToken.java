package code;

public class IdentifierToken extends Token {
	public final String value;
	
	public IdentifierToken(SourceRange location, String value) {
		super(TokenType.IDENTIFIER, location);
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
