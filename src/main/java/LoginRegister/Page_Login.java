package LoginRegister;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_Login extends Base_Page {
	
	//locators
	
	@FindBy(xpath = "//*[@id='Login']")
	public WebElement txUser;
	@FindBy(xpath  = "//*[@id='Senha']")
	public WebElement txContraseña;
	
	@FindBy (xpath ="//*[@id='conteudo']/form/div/div/div[3]/button[1]")
	public WebElement btnContinuar;

	public Page_Login(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public String loginUser() throws Exception {
		String msg= null; 
		String username = "Dylan2602";
		String contraseña = "dylan3066769";
		this.wait(1);
		this.write(username, txUser);
		this.write(contraseña, txContraseña);
		this.wait(1);
		this.click(btnContinuar);
		this.wait(2);
		msg= this.getMsgAlertIfExist("error-0");
		return msg;
	}

}
