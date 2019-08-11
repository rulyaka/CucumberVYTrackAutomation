package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class NavigationBar {

    @FindBy(css = "#user-menu>a")
    public WebElement userFullName;

    @FindBy(linkText = "Logout")
    public WebElement logOutLink;

    public NavigationBar(){
        PageFactory.initElements(Driver.get(), this);
    }

    public WebElement getTab(String tab) {
        String tabXpath = "//span[@class='title title-level-1' and contains(text(), '" + tab + "')]";
        return Driver.get().findElement(By.xpath(tabXpath));
    }

    public WebElement getModule(String module) {
        String moduleXpath = "//span[@class='title title-level-2' and contains(text(), '" + module + "')]";
        return Driver.get().findElement(By.xpath(moduleXpath));
    }

    public void selectMenuOption(String tab, String module) {
        WebElement tabEl = getTab(tab);
        BrowserUtils.hover(tabEl);

        WebElement moduleEl = getModule(module);
        BrowserUtils.waitForClickability(moduleEl, 5).click();

        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
        if (module.equals("Vehicles")) {
            module = "Car";
        }
        wait.until(ExpectedConditions.titleContains(module));

    }

    public static void waitForUIOverlay(){
        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loader-mask.shown")));

    }

    public void logOut(){
        waitForUIOverlay();
        BrowserUtils.waitForClickability(userFullName, 5).click();
        BrowserUtils.waitForClickability(logOutLink, 5).click();
    }

}
