package pageObject.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.Base;

public class SearchResultPageObject extends Base{
    public SearchResultPageObject(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath=".//a[contains(.,'Картинки')]")
    private WebElement imagesTab;
//Проверяем, что кнопка "Картинки" существует на странице
    public boolean isImagesTabButtonIsExist(){
        return waitVisibilityElement(imagesTab);

    }



}
