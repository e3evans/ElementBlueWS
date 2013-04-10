package com.alpine.filemanager.servlets;

import java.io.File;

import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileBrowseServlet
 */
public class FileBrowseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType(request.getContentType());
		PrintWriter out = response.getWriter();
		
		try {
			
			String dir = request.getParameter("dir");
		    
			if (dir == null) {
		    	return;
		    }
			
		    if (dir.charAt(dir.length()-1) == '\\') {
		    	dir = dir.substring(0, dir.length()-1) + "/";
			} else if (dir.charAt(dir.length()-1) != '/') {
			    dir += "/";
			}
			
			dir = java.net.URLDecoder.decode(dir, "UTF-8");	
			//System.out.println(" ----- " + dir + " ----- ");
			
			 if (new File(dir).exists()) {
				String[] files = new File(dir).list(new FilenameFilter() {
					
					@Override
					public boolean accept(File dir, String name) {
						boolean theNameOK =  name.charAt(0) != '.';
						return theNameOK;
				    }
				});
				
				//System.out.println(" ----- Creating UL -----");
				Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
				out.print("<ul class=\"jqueryFileTree\" style=\"display: none;\">");
				// All dirs
				for (String file : files) {
				    if (new File(dir, file).isDirectory()) {
				       //System.out.println(" ----- Creating LI for Directory -----");
						out.print("<li class=\"directory collapsed\"><a href=\"#\" rel=\"" + dir + file + "/\">"
							+ file + "</a></li>");
				    }
				}
				// All files
				for (String file : files) {
					File f = new File (dir, file);
				    if (!f.isDirectory()) {
				       //System.out.println(" ----- Creating LI for File -----");
				    	if (f.canRead()) {
				    		int dotIndex = file.lastIndexOf('.');
				    		String ext = dotIndex > 0 ? file.substring(dotIndex + 1) : "";
				    		out.print("<li class=\"file ext_" + ext.toLowerCase() + "\"><a href=\"#\" rel=\"" + dir + file + "\">"
				    				+ file + "</a></li>");
				    	}
				    }
				}
				//System.out.println(" ----- Closing UL ----- ");
				out.println("</ul>");
		    } else {
		      System.out.println("Directory does not exist: " + dir);
		    }
		} catch ( Exception e ) {
		  System.out.println(e.getMessage());
		}
		finally {
			out.close();
		}
	}
}
