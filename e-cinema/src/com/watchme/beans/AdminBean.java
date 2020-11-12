package com.watchme.beans;



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


	public String validateUsernamePassword() {
		admin = new Administrateur(username,null, password);
		boolean valid = as.login(admin);
		System.out.println(valid);
		if (valid) {
			HttpSession session = SessionUtil.getSession();
			session.setAttribute("username", username);
			return "admin";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
			return "login";
		}
	}
	
	public String logout() {
		HttpSession session = SessionUtil.getSession();
		session.invalidate();
		return "login";
	}
	 public void isLoggedIn() {
	       
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
	       
	        Object loggedIn = session.getAttribute("username");
	        System.err.println(loggedIn);
	        if(loggedIn == null) {
	            ConfigurableNavigationHandler nav
	               = (ConfigurableNavigationHandler)
	                       facesContext.getApplication().getNavigationHandler();
	 System.out.println("user is null redirect to login");
	            nav.performNavigation("/login");
	        } else {
	            // Display dashboard.xhtml
	           
	        }
	    }
	
}
