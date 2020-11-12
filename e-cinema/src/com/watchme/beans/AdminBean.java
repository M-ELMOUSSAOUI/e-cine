package com.watchme.beans;



import java.io.IOException;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.watchme.beans.SessionUtil;

import com.watchme.models.Administrateur;
import com.watchme.service.AdministrateurService;

@ManagedBean
@SessionScoped
public class AdminBean {
	private Administrateur admin;
	private AdministrateurService as= new AdministrateurService();

	private String username,email,password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Administrateur getAdmin() {
		return admin;
	}

	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}

	public AdministrateurService getAs() {
		return as;
	}

	public void setAs(AdministrateurService as) {
		this.as = as;
	}


	public void validateUsernamePassword() {
		admin = new Administrateur(username,null, password);
		boolean valid = as.login(admin);
		System.out.println(valid);
		if (valid) {
			HttpSession session = SessionUtil.getSession();
			session.setAttribute("username", username);
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/e-cinema/views/admin/dashBoard.jsf");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			System.err.println("error in login");
			this.showMessage();
		}
	}
	
	public void logout() {
		HttpSession session = SessionUtil.getSession();
		session.invalidate();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			facesContext.getExternalContext().redirect("/e-cinema/login.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 /**
	 	            ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) facesContext.getApplication().getNavigationHandler();
	            System.out.println("user is null redirect to login");
	            nav.performNavigation("/login");
	
	 */
	public void isLoggedIn() throws IOException {
	       
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
	       
	        Object loggedIn = session.getAttribute("username");
	        if(loggedIn == null) {
	        	facesContext.getExternalContext().redirect("/e-cinema/login.jsf");
	        } else {
	            // Display dashboard.xhtml
	           
	        }
	    }
	
	public void showMessage() {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error",
						"username or password incorrect"));
	}
}
