package com.usda.controllers;

import java.io.IOException;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;

import com.usda.forms.EditForm;

@Controller
@RequestMapping("edit_defaults")
public class EditDefaultsController {

	@RequestMapping
	public ModelAndView renderView(RenderRequest request,RenderResponse response, @SuppressWarnings("rawtypes") Map Model,@ModelAttribute("editForm")EditForm editForm){
		
		if (editForm==null)editForm = new EditForm();
		
		editForm.setDirectory(request.getPreferences().getValue(ViewController.PREF_DIRECTORY, "EMPTY"));
		editForm.setWebserver_url(request.getPreferences().getValue(ViewController.PREF_WEBSERVER, "EMPTY"));
		
		
		return new ModelAndView("edit","editForm",editForm);
	}
	
	@ActionMapping("doSavePrefs")	
	public void savePrefs(ActionRequest request, ActionResponse response,@ModelAttribute("editForm")EditForm editForm){

		if (null!=editForm.getDirectory()){
			try {
				request.getPreferences().setValue(ViewController.PREF_DIRECTORY, editForm.getDirectory());
				request.getPreferences().setValue(ViewController.PREF_WEBSERVER, editForm.getWebserver_url());
				request.getPreferences().store();
			} catch (ValidatorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ReadOnlyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
