package approach_v2;

public class Token {
	public byte kind;
	public String spelling;
	
	public Token(byte kind, String spelling)
	{
		this.kind = kind;
		this.spelling = spelling;
		
		if(kind == IDENTIFIER)
			for(byte i = 0; i < SPELLINGS.length; ++i)
				if(spelling.equals(SPELLINGS[i])) {
					this.kind = i;
					break;
				}
	}
	
	public boolean isAssignOperator() {
		if(kind == OPERATOR)
			return containsOperator(spelling, ASSIGNOPS);
		else
			return false;
	}
	
	public boolean isAddOperator() {
		if(kind == OPERATOR)
			return containsOperator(spelling, ADDOPS);
		else
			return false;
	}
	
	public boolean isMulOperator() {
		if(kind == OPERATOR)
			return containsOperator(spelling, MULOPS);
		else
			return false;
	}
	
	private boolean containsOperator(String spelling, String OPS[]) {
		for(int i = 0; i < OPS.length; ++i)
			if(spelling.equals(OPS[i]))
				return true;
		
		return false;
	}
	
	public static final byte IDENTIFIER = 0;
	public static final byte INTEGERLITERAL = 1;
	public static final byte OPERATOR = 2;
	
	public static final byte DECLARE = 3;
	public static final byte DO = 4;
	//public static final byte ELSE = 5;
	public static final byte AKNIE = 5;
	//public static final byte FI = 6;
	public static final byte KA = 6;
	public static final byte FUNC = 7;
	//public static final byte IF = 8;
	public static final byte AK = 8;
	public static final byte OD = 9;
	//public static final byte RETURN = 10;
	public static final byte HABIBI = 10;
	public static final byte SAY = 11;
	public static final byte THEN = 12;
	public static final byte VAR = 13;
	//public static final byte WHILE = 14;
	public static final byte LOOP = 14;
	public static final byte POOL = 15;
	
	public static final byte COMMA = 16;
	public static final byte SEMICOLON = 17;
	public static final byte LETPARAN = 18;
	public static final byte RIGHTPARAN = 19;
	
	public static final byte EOT = 20;
	
	public static final byte ERROR = 21;
	
	private static final String SPELLINGS[] =
		{
				"<identifier>",
				"<integerletiral>",
				"<operator>",
				
				"declare",
				"do",
				"else",
				"aknie",
				"fi",
				"ka",
				"func",
				"if",
				"ak",
				"od",
				"return",
				"habibi",
				"say",
				"then",
				"var",
				"while",
				"loop",
				"pool",
				"boolean",
				"suka",
				
				",",
				";",
				"end",
				"(",
				")",
				"*",
				"<eot>",
				"<error>",
		};
	
		private static final String ASSIGNOPS[] =
		{
			":=",
		};
		
		private static final String ADDOPS[] =
		{
			"+",
			"-",
			"up",
			"down",
		};
		
		private static final String MULOPS[] =
		{
			"*",
			"/",
			"%",
			"multiply",
			"divide",
		};
}
