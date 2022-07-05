import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.io.FileWriter;
public class TextFile {
private String filename;
private String text;
private int words;
private int characters;
public TextFile() {
	this.filename = "undefined";
	words = 0;
	characters = 0;
	text = "";
}
public void countCharacters() {
	int count = 0;
	for(int i = 0;i < text.length();i++) {
		if(text.charAt(i)!= ' ') {
			count ++;
		}
	}
	characters = count;
}
public void countWords() {
	String[] words = text.split("\\s+");
	this.words = words.length;
}
public void saveTextFile(String name){
	this.filename = name;
	try {
		FileWriter savefile = new FileWriter(System.getProperty("user.home") + "\\" + name + ".txt");
		savefile.write(text);
		savefile.close();
	}
	catch (IOException e) {
	}
		//File NewSave
}

public void setText(String text) {
	this.text = text;
}
public int getWords() {
	return this.words;
}
public int getCharacters() {
	return this.characters;
}
public void setFileName(String filename) {
	this.filename = filename;
}
public String getFileName() {
	return this.filename;
}
public boolean checkSave() {
	if(this.filename == "undefined") {
		return false;
	}
	else {
		return true;
	}
}
}
