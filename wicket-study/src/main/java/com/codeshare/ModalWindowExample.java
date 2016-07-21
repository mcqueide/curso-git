package com.codeshare;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.PageCreator;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.WindowClosedCallback;
import org.apache.wicket.markup.html.WebPage;

public class ModalWindowExample extends WebPage {

	private static final long serialVersionUID = 122510756872880940L;

	private ModalWindow modalWindow;
	private String action;
	public ModalWindowExample() {
		modalWindow = new ModalWindow("modalWindow");
		
		modalWindow.setPageCreator(new PageCreator(){
			
			private static final long serialVersionUID = 8422478388064273881L;

			public Page createPage() {
				return new WelcomePage(action);
			}

		});
		
		modalWindow.setTitle("ModalWindowExample");
		
		modalWindow.setWindowClosedCallback(new WindowClosedCallback(){
			
			private static final long serialVersionUID = 8602158476332465073L;

			public void onClose(AjaxRequestTarget target){
				
			}
		});
		
		add(new AjaxLink<String>("viewLink"){

			private static final long serialVersionUID = -288411372815781360L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				action= "view";
				modalWindow.show(target);
				
			}
			
		});
		
		add(new AjaxLink<String>("editLink"){

			private static final long serialVersionUID = -288411372815781360L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				action= "edit";
				modalWindow.show(target);
				
			}
			
		});
		
		add(modalWindow);
	}

}
