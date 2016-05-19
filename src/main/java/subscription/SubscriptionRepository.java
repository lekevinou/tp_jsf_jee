//package subscription;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.Date;
//import java.util.Objects;
//
//import javax.enterprise.context.RequestScoped;
//import javax.inject.Named;
//
//@Named
//@RequestScoped
//public class SubscriptionRepository implements java.io.Serializable{
//
//	public Subscription create(String email, String password, String confirmedPassword, String webSite, boolean accepted) throws InvalidSubscriptionException {
//		Subscription s = new Subscription();
//		s.setEmail(email);
//		s.setPassword(password);
//		s.setCreationDate(new Date());
//		
//		validate(s, confirmedPassword, webSite, accepted);
//		
//		return s;
//	}
//
//	private void validate(Subscription s, String confirmedPassword, String webSite, boolean accepted) throws InvalidSubscriptionException {
//		InvalidSubscriptionException exception = new InvalidSubscriptionException();
//		if (! s.checkEmail()) {
//			exception.addError("email.invalid");
//		}
//
//		if (! s.checkPassword()) {
//			exception.addError("password.invalid");
//		}
//		else if (! s.checkPassword(confirmedPassword)) {
//			exception.addError("password.not_confirmed");
//		}
//
//		if (Objects.toString(webSite, "").length() > 0) {
//			try {
//				s.setWebsite(new URL(webSite));
//				if (! s.isWebsiteAvailable()) {
//					exception.addError("website.unreachable");
//				}
//			} catch (MalformedURLException e) {
//				exception.addError("website.invalid");
//			}
//		}
//		
//		if (! accepted) {
//			exception.addError("subscription.not_accepted");
//		}
//
//		if (! exception.getErrors().isEmpty()) {
//			throw exception;
//		}
//	}
//}
