package Launchers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginRegister.Controller_Prueba;

public class Launcher_Test {
	public ChromeDriver driver;
	Controller_Prueba controller_Prueba;

	@BeforeTest
	public void chromedriver() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\drojassuarez\\OneDrive - DXC Production\\Desktop\\proyectos auto\\Proyecto_2\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.moderna.com.br/simulador-de-testes/en/Login/Login");
	}

	@Test
	public void prueba() throws Exception {

		String tipoprueba = "";
		tipoprueba = "Login";
		switch (tipoprueba) {
		case "Login":
			controller_Prueba = new Controller_Prueba(driver);
			controller_Prueba.login();
		case "2":

		case "3":

			break;
		}

	}
}
