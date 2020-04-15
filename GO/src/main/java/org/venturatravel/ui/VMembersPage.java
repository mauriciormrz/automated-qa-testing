package org.venturatravel.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class VMembersPage extends PageObject {

    public static final Target PROFILE_TITLE = Target.the("Subtitle of the page 'My Profile'")
            .located(By.xpath("//h1[@class='MuiTypography-root MuiTypography-h6 MuiTypography-colorTextPrimary']"));

    public static final Target PROFILE_USER = Target.the("User Name of the page My Profile")
            .located(By.xpath("//div[@class='text-lg font-bold text-vtext']"));

    public static final Target DROPDOWN_MENU = Target.the("dropdown menu")
            .located(By.xpath("//*[contains(@class,'MuiSvgIcon-root jss')]"));

    public static final Target MENU_SWITCH_USER = Target.the("Switch user option menu")
            .located(By.xpath("//span[contains(text(),'Switch User')]"));

    public static final Target MENU_LOGOUT = Target.the("Logout option menu")
            .located(By.xpath("//span[contains(text(),'Logout')]"));

    public static final Target MENU_SWITCH_USER_BACK = Target.the("Switch user back option menu")
            .located(By.xpath("//span[contains(text(),'Switch User Back')]"));

    public static final Target INPUT_SEARCH_SWITCH_USER = Target.the("Search a GO user")
            .located(By.xpath("//input[@class='MuiInputBase-input MuiInput-input']"));

    public static final Target SWITCH_USER_NAME = Target.the("Search a GO user")
            .locatedBy("//strong[contains(text(),'{0}')]");

    public static final Target BTN_SWITCH = Target.the("Switch button")
            .located(By.xpath("//span[contains(text(),'Switch')]"));
}

