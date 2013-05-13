package com.ibm.jsfportlet;

import java.io.IOException;
import javax.portlet.*;
import javax.faces.context.FacesContext;


public class JSFPortlet extends com.ibm.faces20.portlet.FacesPortlet {
	
	
		

	
	
	public void destroy() {
		super.destroy();
	}
	
	
	public void doEdit(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		super.doEdit(request, response);
	}
	
	public void doHelp(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		super.doHelp(request, response);
	}
	
	public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		
		
		super.doView(request, response);
	}
	
	public void init() throws PortletException {
		super.init();
	}
	
		
	
	
	public void processAction(ActionRequest request, ActionResponse response) throws PortletException {
		
		super.processAction(request, response);
	}
		
	
	
	
	private static final PortletMode CUSTOM_EDIT_DEFAULTS_MODE = new PortletMode("edit_defaults");
	private static final PortletMode CUSTOM_CONFIG_MODE = new PortletMode("config");

	/**
	 * Override doDispatch method for handling custom portlet modes.
	 * 
	 */
	protected void doDispatch(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		if (!WindowState.MINIMIZED.equals(request.getWindowState())){
			PortletMode mode = request.getPortletMode();
			if (CUSTOM_CONFIG_MODE.equals(mode)) {
				doCustomConfigure(request, response);
				return;
			}
			else if (CUSTOM_EDIT_DEFAULTS_MODE.equals(mode)) {
				doCustomEditDefaults(request, response);
				return;
			}
		}
		super.doDispatch(request, response);
	}
	
	protected void doCustomEditDefaults(RenderRequest request, RenderResponse response) throws PortletException, IOException {
			super.doDispatch(request, response);
	}
	
	protected void doCustomConfigure(RenderRequest request, RenderResponse response) throws PortletException, IOException {
			super.doDispatch(request, response);
	}
	
	
}