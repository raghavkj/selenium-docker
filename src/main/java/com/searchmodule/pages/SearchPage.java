package com.searchmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@id='search_form_input_homepage']")
    private WebElement searchTextBox;

    @FindBy(xpath = "//input[@id='search_button_homepage']")
    private WebElement searchBtn;

    @FindBy(linkText = "Videos")
    private WebElement videosLink;

    @FindBy(xpath = "//div[contains(@class,'tile--vid')]")
    private List<WebElement> allVideos;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("https://duckduckgo.com/");
    }

    public void doSearch(String keyword) {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchTextBox));
        this.searchTextBox.sendKeys(keyword);
        this.searchBtn.click();
    }

    public void goToVideos() {
        this.wait.until(ExpectedConditions.visibilityOf(this.videosLink));
        this.videosLink.click();
    }

    public int getResult() {
        By by = By.xpath("//div[contains(@class,'tile--vid')]");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
        System.out.println("Number of videos in the list : " + this.allVideos.size());
        return this.allVideos.size();
    }
}
