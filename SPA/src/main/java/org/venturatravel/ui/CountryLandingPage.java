package org.venturatravel.ui;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CountryLandingPage extends PageObject {

    public static final Target DATES_AND_PRICES = Target.the("'Dates & Prices' in the tabs section of the trip")
            .located(By.id("tab-1"));

    public static final Target BTN_RESERVATION = Target.the("on the first available departure 'Reserve' button")
            .locatedBy("//tr[{0}]/td[{1}]/a");

    public static final Target TBL_RESERVE = Target.the("'Reserve Table")
            .located(By.xpath("//td[@class='Table__TableCell-NJxfm cQAZvs']"));

    public static final Target IMG_THANKS = Target.the("'Image Thanks")
            .located(By.xpath("//img[@class='Img-ifujty ikXxNB']"));


    @FindBy(xpath = "//table[contains(@class,'Table')]/tbody")
    private WebElementFacade tblDepartures;

    @FindBy(xpath = "//div[@id='select-rooms']//div[@class='Dropdown-title']")
    private WebElementFacade txtAccommodationPrice;

    private static String departureDate;
    private static String departurePrice;
    private static String rowDeparture;
    private static String columnDeparture;
    private static String discountLeft;

    private String accommodationPrice;

    private String currency = "EUR";


    public String getAccommodationPrice() {

        accommodationPrice = txtAccommodationPrice.getText().replace("(", "").replace(")", "");
        String[] arrPrices = accommodationPrice.split(" ", 0);
        int price = 0;
        for (String a : arrPrices) {
            try {
                price = Integer.parseInt(a.trim());
                break;
            } catch (Exception e) {
                continue;
            }
        }
        accommodationPrice = String.valueOf(price);
        return accommodationPrice;
    }

    private Boolean getDepartureInfo(String cellText, int column, int row) {

        int i = 0;
        int j = 0;

        if (cellText.equals("RESERVIEREN") || cellText.equals("RÉSERVER")) {

            String[] arrPrices = departurePrice.split(currency, 0);

            for (i = 0; i < arrPrices.length; i++) {

                for (j = 0; j < arrPrices[i].length(); j++) {
                    if (Character.isDigit(arrPrices[i].charAt(j))) {
                        break;
                    }
                }
                arrPrices[i] = arrPrices[i].substring(j);
            }

            if (discountLeft.equals("0")) {
                departurePrice = arrPrices[0];
            } else {
                if (arrPrices.length == 1) departurePrice = arrPrices[0];
                else departurePrice = arrPrices[1];
            }
            rowDeparture = Integer.toString(row + 1);
            columnDeparture = Integer.toString(column + 1);
            return true;
        }
        rowDeparture = null;
        columnDeparture = Integer.toString(column + 1);
        return false;
    }


    public boolean departuresTable() {

        int Option = 0;

        List<WebElement> tableList = getDriver().findElements(By.tagName("table"));

        if (tableList.size() == 0) {
            System.out.println(tableList.size());
            return false;
        }

        List<WebElement> rows_table = tblDepartures.findElements(By.tagName("tr"));

        int rows_count = rows_table.size();
        for (int row = 0; row < rows_count; row++) {

            List<WebElement> columns_row = rows_table.get(row).findElements(By.tagName("td"));
            int columns_count = columns_row.size();

            for (int column = 0; column < columns_count; column++) {

                String cellText = columns_row.get(column).getText();

                Option = (columns_count == 7) ? column : column + 1;
                if (column == 1) Option = column;

                switch (Option) {
                    case 1:
                        departureDate = cellText;
                        break;
                    case 3:
                        getDiscountLeft(cellText);
                        break;
                    case 5:
                        departurePrice = cellText;
                        break;
                    case 6:
                        if (getDepartureInfo(cellText, column, row)) {
                            return true;
                        }
                        break;
                }
            }
        }
        return false;
    }

    private void getDiscountLeft(String cellText) {

        if (cellText.indexOf("Frühbucherrabatt") == -1 && cellText.indexOf("réduction") == -1) {
            discountLeft = "0";
        } else {

            String regexp = "([\\-?0-9.]+)";

            if (cellText.length() == 0)
                cellText = "0";

            Pattern pattern = Pattern.compile(regexp);
            Matcher matcher = pattern.matcher(cellText);

            if (matcher.find()) {
                int i = Integer.parseInt(matcher.group());
                discountLeft = (i <= 0) ? "0" : String.valueOf(i);
            } else {
                discountLeft = "0";
            }
        }

    }

    public static String getDepartureDate() {
        return departureDate;
    }

    public static String getDeparturePrice() {
        return departurePrice;
    }

    public static String getRowDeparture() {
        return rowDeparture;
    }

    public static String getColumnDeparture() {
        return columnDeparture;
    }

}

