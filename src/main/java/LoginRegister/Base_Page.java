package LoginRegister;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base_Page {

	private WebDriver driver;

	public Base_Page(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement element (By locator) {
		WebElement elementRet = null;
		try {
			elementRet = this.driver.findElement(locator);
		} catch (NoSuchElementException e) {
			elementRet = null;
		}
		return elementRet;
	}
	

//	public List<WebElement> findElements(WebElement elementWebTable,) {
//		return driver.findElements(locator);
//	}

	public String getText(WebElement element) {
		return element.getText();
	}

	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	public void write(String text, By locator) {
		driver.findElement(locator).sendKeys(text);
	}

	public void write(String text, WebElement element) {
		element.sendKeys(text);
	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}

	public void click(WebElement element) {
		element.click();
	}

	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	public Boolean isDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public void wait(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String left(String value, int lenght) {
		String valRetorno = value;
		if (value.length() > lenght)
			valRetorno = value.substring(0, lenght);
		return valRetorno;
	}
	
	public static String right(String texto, int lenght) {
		String valRetorno = texto;
		if (texto.length() > lenght)
			valRetorno = texto.substring(texto.length() - lenght);
		return valRetorno;
	}
	public List<WebElement> findElements(WebElement element, By locator) {
		return element.findElements(locator);
	}
	
	public int getRowCount(WebElement elementWebTable) {
		return this.findElements(elementWebTable, By.tagName("tr")).size();
	}
	
	public String selectListItemExacto(By locator, String item) {
		return this.selectListItemExacto(this.element(locator), item);
	}
	
	public String selectListItemExacto(WebElement element, String item) {
		Select selectList = new Select(element);
		String valActual = this.getText(selectList.getFirstSelectedOption());
		
		String msgRetorno = ""; // VALOR POR DEFECTO, ASUME QUE SE ENCUENTRA
		if (valActual.equals(item)) // YA EST� SELECCIONADO
			return msgRetorno;

		try {
			selectList.selectByVisibleText(item);
		} catch (NoSuchElementException e) {
			msgRetorno = "Elemento [" + item + "] NO presentado.";
		}
		return msgRetorno;
	}

	public void acceptDialog() {
		this.driver.switchTo().alert().accept();
	}
	
	public String getMsgAlertIfExist(String... idsAlerta) {
		String msgAlert = null;
		for (String id : idsAlerta) {
			By locMessage = By.id(id);
			if (this.isDisplayed(locMessage)) {
				this.wait(1);
				msgAlert = this.getText(locMessage).trim();
				if (msgAlert.equals("")) // NO HAY MENSAJE
					msgAlert = null;
				else
					break; // PARA TERMINAR EL CICLO
			}
		}
		return msgAlert;
	}
	
	public void scroll (WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		// Desplazar hacia abajo 300 píxeles

	}
	
}
