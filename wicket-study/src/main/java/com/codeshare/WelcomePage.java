package com.codeshare;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

import com.codeshare.model.UserModel;

public class WelcomePage extends WebPage {

	private static final long serialVersionUID = -8903220313226134259L;
	
	private List<String> genderChoices = new ArrayList<String>();
	
	public WelcomePage() {
		genderChoices.add("Male");
		genderChoices.add("Female");
		final UserModel userModel = new UserModel();
		
		Form<?> form = new Form("form");
		
		TextField<String> text = new TextField<String>("text",
			new PropertyModel<String>(userModel, "nome"));
		
		DropDownChoice<String> gender = 
			new DropDownChoice<String>("gender", 
				new PropertyModel<String>(userModel, "gender"), 
				genderChoices);
		
		Button button = new Button("submit"){
			@Override
			public void onSubmit() {
				super.onSubmit();
				
				String mensagem = String.format("Name: %s, \n Gender: %s", 
					userModel.getNome(), userModel.getGender());
				
				System.out.println(mensagem);
			}
		};
		
		add(form);
		form.add(text);
		form.add(gender);
		form.add(button);
	}

}
