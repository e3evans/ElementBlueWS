package com.alpine.filemanager;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.ProcessAction;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * A sample portlet
 */
public class FileManagerPortlet extends GenericPortlet {
	
	private static final String PREF_ROOT_URL = "rootUrl";
	private static final String PREF_MAX_HEIGHT = "maxHeight";
	private static final String PREF_FOLDER_URL = "folderUrl";
	//private static final PortletMode CUSTOM_EDIT_DEFAULTS_MODE = new PortletMode("edit_defaults");
	
	@RenderMode(name="edit_defaults")
    public void configureFileManager(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		response.setContentType(request.getResponseContentType());

		request.setAttribute("rootUrl", request.getPreferences().getValue(PREF_ROOT_URL, ""));
		request.setAttribute("maxHeight", request.getPreferences().getValue(PREF_MAX_HEIGHT, ""));
		request.setAttribute("folderUrl",request.getPreferences().getValue(PREF_FOLDER_URL, ""));
		
		System.out.println("THIS IS A TEST.");
		System.out.println("This is for Ian.");
		
		getPortletContext().getRequestDispatcher("/WEB-INF/jsp/configure-filemanager.jsp").include(request,response);
	}

	@RenderMode(name="view")
    public void viewFileManager(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		response.setContentType(request.getResponseContentType());
		/*
		 * Check for a folder path in the URL
		 */
		HttpServletRequest hsreq = com.ibm.ws.portletcontainer.portlet.PortletUtils.getHttpServletRequest(request);
		String qParm = hsreq.getParameter(PREF_ROOT_URL);
		String sParm = null;
		String finalPath="";
		if (request.getPortletSession().getAttribute(PREF_ROOT_URL)!=null) sParm = (String) request.getPortletSession().getAttribute(PREF_ROOT_URL);
		if (!request.getPreferences().getValue(PREF_FOLDER_URL, "").equals("")){
			if (qParm!=null){
				finalPath = request.getPreferences().getValue(PREF_FOLDER_URL, "")+qParm;
				request.getPortletSession().setAttribute(PREF_ROOT_URL, qParm);
			}else if (sParm!=null){
				finalPath=request.getPreferences().getValue(PREF_FOLDER_URL, "")+sParm;
			}else{
				finalPath = request.getPreferences().getValue(PREF_FOLDER_URL, "")+request.getPreferences().getValue(PREF_ROOT_URL, "");
			}
		}
		
		request.setAttribute("rootUrl", finalPath);
		String inlineStyle = "";
		if(request.getPreferences().getValue(PREF_MAX_HEIGHT, "")!=null && !request.getPreferences().getValue(PREF_MAX_HEIGHT, "").equals("")) {
			inlineStyle = "style=max-height:" + request.getPreferences().getValue(PREF_MAX_HEIGHT, "") + "px;";
		}

		request.setAttribute("inlineStyle", inlineStyle);
		
		getPortletContext().getRequestDispatcher("/WEB-INF/jsp/view-filemanager.jsp").include(request,response);
	}
	
	@ProcessAction(name="saveConfiguration")
	public void saveConfiguration(ActionRequest request, ActionResponse response) {
		
		PortletContext context = getPortletContext();

		try {
			PortletPreferences prefs = request.getPreferences();
			prefs.setValue(PREF_ROOT_URL, request.getParameter("rootUrl"));
			prefs.setValue(PREF_MAX_HEIGHT, request.getParameter("maxHeight"));
			prefs.setValue(PREF_FOLDER_URL, request.getParameter("folderUrl"));
			prefs.store();
			
			response.setPortletMode(PortletMode.VIEW);
		} catch ( IOException ioe ){
		   context.log("An IO error occurred when trying to save the configuration.\n" + ioe.getMessage());    
		} catch ( PortletException pe ) {
		   context.log("A portlet exception was thrown when trying to save the configuration.\n" + pe.getMessage());    
		}
	}
}
