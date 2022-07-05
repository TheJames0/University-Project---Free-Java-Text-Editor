public class TextFile {
private String filename;
private String text;
private int words;
private int characters;
private String filepath;
private boolean dochaschanged;
/**
 * constructor method sets variables to 'null' types
 */
public TextFile() {
	dochaschanged = false;
	filepath = "";
	filename = "undefined";
	words = 0;
	characters = 0;
	text = "";
}
/**
 * Counts characters in string type to be used in main gui.
 * ignores spaces and newline characters.
 */
private void countCharacters() {
	int count = 0;
	for(int i = 0;i < text.length();i++) {
		if(text.charAt(i)!= ' ' && text.charAt(i) != '\n' && text.charAt(i) != '\r') {
			count ++;
		}
	}
	characters = count;
}
/**
 * Splits text by spaces  and counts how many splits.
 */
private void countWords() {
	String[] words = text.split("\\s+");
	this.words = words.length;
}

public void setFilePath(String path) {
	this.filepath = path;
}
public String getFilePath() {
	return this.filepath;
}
public void setText(String text) {
	this.text = text;
}
public int getWords() {
	countWords();
	return this.words;
}
public int getCharacters() {
	countCharacters();
	return this.characters;
}
public String getFileName() {
	return this.filename;
}
public void setFilename(String name) {
	this.filename = name;
}
public void setDochaschanged(boolean bool) {
	this.dochaschanged = bool;
}
public boolean getDochaschanged(){
	return dochaschanged;
}
/**
 * checks if has been already saved by checking against default constructor filename
 * @return
 */
public boolean isAlreadySaved() {
	if(this.filename == "undefined") {
		return false;
	}
	else {
		return true;
	}
}

}
