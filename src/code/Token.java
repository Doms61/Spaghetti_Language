package code;

public class Token {
	public final SourceRange location;
	public final TokenType type;
	
	public Token(TokenType type, SourceRange location) {
		this.type = type;
		this.location = location;
	}
	
	public SourcePosition getStart() {
		return location.start();
	}
	
	@Override
	public String toString() {
		return type.toString();
	}
	
	public IdentifierToken asIdentifier() { return (IdentifierToken) this; }
	public LiteralToken asLiteral() { return (LiteralToken) this; }
}
