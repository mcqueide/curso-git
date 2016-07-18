package com.codeshare;

import org.apache.wicket.markup.html.WebPage;

public class WelcomePage extends WebPage {

	private static final long serialVersionUID = -8903220313226134259L;
	
	public WelcomePage() {
		add(new SamplePanel("panel"));
	}

}
