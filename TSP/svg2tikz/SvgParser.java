
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;


/**
 * Very simple parser of svg files to tikz.
 * This parser only deals with path and circle objects.
 *
 * @author Marie Pelleau
 */
public class SvgParser {
    
    private static String parseCircle(Element elem) {
        String x = elem.getAttribute("cx");
        String y = elem.getAttribute("cy");
        String id = elem.getAttribute("id");
        return "\\node[ville] (" + id + ") at (" +
                x + ", " + y + ") {};";
    }
    
    private static String parsePath(Element elem) {
        String toParse = elem.getAttribute("d");
        String id = elem.getAttribute("id");
        String before = "";
        StringBuilder sb = new StringBuilder();
        sb.append("%%%%% ").append(id).append("%%%%%\n\\draw[join = round, thick] (");
        String[] list = toParse.split(" ");
        for (int i = 0; i < list.length; i++) {
            String s = list[i];
            switch (s) {
                case "c":
                    // incremental bezier curve
                    String[] pt2 = list[i+2].split(",");
                    String[] pt3 = list[i+3].split(",");
                    double x = Double.parseDouble(pt3[0]) - Double.parseDouble(pt2[0]);
                    double y = Double.parseDouble(pt3[1]) - Double.parseDouble(pt2[1]);
                    sb.append(") .. controls ++ (").append(list[i+1]).append(") and ++ (")
                            .append(x).append(",").append(y).append(") .. ++ (")
                            .append(list[i+3]);
                    i += 3;
                    break;
                case "C":
                    // bezier curve
                    sb.append(" .. controls (").append(list[i+1]).append(") and (")
                            .append(list[i+2]).append(") .. (").append(list[i+3]).append(")");
                    i += 3;
                    break;
                case "l":
                case "m":
                    before = ") -- ++ (";
                    break;
                case "L":
                case "M":
                    before = ") -- (";
                    break;
                case "z": 
                    sb.append(") -- cycle");
                    break;
                default:
                    if (i > 1) sb.append(before);
                    sb.append(s);
                    break;
            }
        }
        sb.append(";\n");
        return sb.toString();
    }
    
    private static void parseG(Element elem) {
        final NodeList nodes = elem.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            if(nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                final Element child = (Element) nodes.item(i);
                if (child.getNodeName().equals("path")) {
                    String p = parsePath(child);
                    System.out.println(p);
                } else if (child.getNodeName().equals("circle")) {
                    String c = parseCircle(child);
                    System.out.println(c);
                }
            }
        }
    }
    
    public static void parse(String filename) {
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            	
        try {
            final DocumentBuilder builder = factory.newDocumentBuilder();
            
	    final Document document = builder.parse(new File(filename));
            
	    final Element racine = document.getDocumentElement();
            assert(racine.getNodeName().equals("svg"));
            
	    final NodeList racineNoeuds = racine.getChildNodes();
	    final int nbRacineNoeuds = racineNoeuds.getLength();
			
	    for (int i = 0; i < nbRacineNoeuds; i++) {
	        if(racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
	            final Element elem = (Element) racineNoeuds.item(i);
                    if (elem.getNodeName().equals("g")) {
                        parseG(elem);
                    }
	        }				
	    }			
        }
        catch (final ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }		
    }
}