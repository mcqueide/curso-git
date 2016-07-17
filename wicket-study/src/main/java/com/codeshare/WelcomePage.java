package com.codeshare;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

public class WelcomePage extends WebPage {

	private static final long serialVersionUID = -8903220313226134259L;
	
	public WelcomePage() {
		add(new Label("lbl", 
			new Model<String>("This is my first Wicket App")));
	}

}
