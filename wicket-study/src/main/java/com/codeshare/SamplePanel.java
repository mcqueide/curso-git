package com.codeshare;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

import com.codeshare.model.UserModel;

public class SamplePanel extends Panel {

	private static final long serialVersionUID = 1L;

	private List<String> genderChoices = new ArrayList<String>();
	
	public SamplePanel(String id) {
		super(id);
		
		genderChoices.add("Male");
		genderChoices.add("Female");
		final UserModel userModel = new UserModel();
		
		Form<?> form = new Form("form");

		final TextField<String> text = new TextField<String>("text", new PropertyModel<String>(userModel, "nome"));
		text.setOutputMarkupId(true);
		text.setOutputMarkupPlaceholderTag(true);
		form.add(text);

		AjaxButton ajaxButton = new AjaxButton("submit") {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);

				if(text.isVisible()){
					text.setVisible(false);
				}else{
					text.setVisible(true);
				}
				target.add(text);
			}
		};
		form.add(ajaxButton);

		add(form);
	}

}
