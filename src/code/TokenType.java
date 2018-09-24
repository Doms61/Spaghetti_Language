package code;

public enum TokenType {
		//END_OF_FILE("End of File"),
		//ERROR("error"),
		
		NUMBER,
		AK;
		
		public final String value;
		
		TokenType() {
			this(null);
		}

		TokenType(String value) {
			this.value = value;
		}

}
