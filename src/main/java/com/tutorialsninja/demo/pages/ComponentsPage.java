package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;

public class ComponentsPage extends Utility {

    By componentsPageText = By.xpath("//h2[contains(text(),'Components')]");


    public String getPageName(){
        return getTextFromElement(componentsPageText);
    }
}
