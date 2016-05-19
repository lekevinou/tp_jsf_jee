package subscription;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Named
@RequestScoped
public class SubsciptionController implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	private static final String FORM_VIEW = "/WEB-INF/jsp/subscription.jsp";
	private static final String SUCCESS_VIEW = "/WEB-INF/jsp/subscription_success.jsp";
	private static final String ERROR_VIEW = FORM_VIEW;
       
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(FORM_VIEW).forward(request, response);
	}*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view;
		try {
			SubscriptionRepository subscriptionRepository = new SubscriptionRepository();
			Subscription subscription = subscriptionRepository.create(request.getParameter("email"), 
										request.getParameter("password"), 
										request.getParameter("passwordConfirmation"), 
										request.getParameter("website"), 
										Boolean.valueOf(request.getParameter("accepted")));
			request.setAttribute("subscription", subscription);
			view = SUCCESS_VIEW;
		} catch (InvalidSubscriptionException e) {
			request.setAttribute("errors", e.getErrors());
			view = ERROR_VIEW;
		}
		
		//getServletContext().getRequestDispatcher(view).forward(request, response);
	}


}
