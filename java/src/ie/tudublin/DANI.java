package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class DANI extends PApplet {

	private ArrayList<Text> model;
	private PApplet parent;

	public DANI(PApplet parent) {
		model = new ArrayList<Text>();
		this.parent = parent;
	}

	public void fileLoading(String DANI) {
		String[] lines = parent.loadStrings(DANI);
		for (int i = 0; i < lines.length; i++) {
			String[] texts = parent.split(lines[i], ' ');
			for (int j = 0; j < texts.length; j++) {
				String w = texts[j].toLowerCase().replaceAll("[^\\w\\s]","");
				if (!findText(w)) {
				  Text newText = new Text(w);
				  model.add(newText);
				}
				if (j < texts.length - 1) {
				  String f = texts[j + 1].toLowerCase().replaceAll("[^\\w\\s]","");
				  Text text = getText(w);
				  text.addFollow(f);
				}
			  }
			}
		  }
		
		  public void printoutModel() {
			for (Text w : model) {
			  parent.print(w.getText() + ": ");
			  for (Follow f : w.getFollows()) {
				parent.print(f.getText() + "(" + f.getCount() + ") ");
			  }
			  parent.println();
			}
		  }
		
		  private boolean findText(String text) {
			for (Text w : model) {
			  if (w.getText().equals(text)) {
				return true;
			  }
			}
			return false;
		  }
		
		  private Text getText(String text) {
			for (Text w : model) {
			  if (w.getText().equals(text)) {
				return w;
			  }
			}
			return null;
		  }
		
	

	public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}

    String[] sonnet;

    public String[] writeSonnet()
    {
        return null;
    }

	public void setup() {
		colorMode(HSB);

       
	}

	public void keyPressed() {

	}

	float off = 0;

	public void draw() 
    {
		background(0);
		fill(255);
		noStroke();
		textSize(20);
        textAlign(CENTER, CENTER);
        
	}
}
