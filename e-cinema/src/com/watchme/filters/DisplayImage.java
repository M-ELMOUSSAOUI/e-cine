package com.watchme.filters;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchme.models.Film;
import com.watchme.service.FilmService;



@WebServlet("/image/*")
public class DisplayImage extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7061776166407288791L;
	FilmService fs = new FilmService(); ;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		
			Long id = Long.parseLong(req.getPathInfo().substring(1)); 
			System.out.println("inside servlet�>" + id);
			
			Film f = fs.findById(id);
			if (f!=null) {
				resp.setContentType(getServletContext().getMimeType(f.getTitre()));
		        resp.setContentLength(f.getFiche().length);
		        resp.getOutputStream().write(f.getFiche());
			}
        
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		doGet(req, resp);
	}
	
	

}
