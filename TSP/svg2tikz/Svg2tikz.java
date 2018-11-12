
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * USAGE: `java -jar "svg2tikz.jar" filename [output]`
 * with `filename` the name of the svg file and `output` the output filename
 * if no output is specified, the output will be written in `filename.tex`
 * 
 * @author Marie Pelleau
 */
public class Svg2tikz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        if (args.length == 0) {
            System.out.println("USAGE: java -jar \"svg2tikz.jar\" filename.svg [output.tex]");
        } else {
            if (args.length > 1) {
                try {
                    System.setOut(new PrintStream(new FileOutputStream(new File(args[1]))));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Svg2tikz.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    System.setOut(new PrintStream(new FileOutputStream(new File(args[0] + ".tex"))));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Svg2tikz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            SvgParser.parse(args[0]);
        }
    }
    
}
