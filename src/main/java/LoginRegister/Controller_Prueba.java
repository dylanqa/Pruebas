package LoginRegister;

import org.openqa.selenium.WebDriver;

public class Controller_Prueba {
	WebDriver driver;
	Page_Login page_Login;
	public Controller_Prueba(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		page_Login = new Page_Login(driver);
	}
	
	public void login () throws Exception {
		String msg = null;
		msg=page_Login.loginUser();
		if(msg!=null) {
			System.out.println("su prueba fallo por: "+msg);
		}
	}
	
	
}
