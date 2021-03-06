package projeto.lsi.logica;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaEmail {	
	

	    public static boolean isEmailValid(String email) {
	        if ((email == null) || (email.trim().length() == 0))
	            return false;

	        String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
	        Pattern pattern = Pattern.compile(emailPattern);
	        Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	    }
	}

