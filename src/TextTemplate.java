/**
 * 
 * @author James
 *Used as form of data storage to store template name, and two strings to be 
 *inserted into the document.
 */
public class TextTemplate {
String texttemplatename;
String firsttext;
String secondtext;
/**
 * 
 * @param texttemplatename
 * @param firsttext
 * @param secondtext
 * Constructs the text template by setting all variables.
 */
public TextTemplate(String texttemplatename, String firsttext, String secondtext) {
this.texttemplatename = texttemplatename;	
this.firsttext = firsttext;
this.secondtext = secondtext;
}
public String getName() {
	return this.texttemplatename;
}
public String getfirsttext() {
	return this.firsttext;
}
public String getsecondtext() {
	return this.secondtext;
}
}
