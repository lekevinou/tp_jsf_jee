package subscription;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class InvalidSubscriptionException extends Exception{
	
	private static final long serialVersionUID = 1L;

	private final List<String> errors = new ArrayList<>();
	
	public InvalidSubscriptionException() {
	}
	
	public void addError(String message) {
		errors.add(message);
	}
	
	public List<String> getErrors() {
		return errors;
	}
}
