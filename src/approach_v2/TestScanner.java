package approach_v2;

import javax.swing.JFileChooser;

public class TestScanner {
//private static final String EXAMPLES_DIR = "d:\\usr\\undervisning\\CMC\\IntLang\\examples";
private static final String EXAMPLES_DIR = "~/eclipse-workspace/intlang/";
	
	public static void main( String args[] )
	{
		JFileChooser fc = new JFileChooser( EXAMPLES_DIR );
		
		if( fc.showOpenDialog( null ) == JFileChooser.APPROVE_OPTION ) {
			SourceFile in = new SourceFile( fc.getSelectedFile().getAbsolutePath() );
			Scanner s = new Scanner( in );
		
			Token t = s.scan();
			while( t.kind != Token.EOT ) {
				System.out.println( t.kind + " " + t.spelling );
			
				t = s.scan();
			}
		}
	}
}
