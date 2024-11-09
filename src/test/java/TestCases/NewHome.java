package TestCases;

import BaseClass.BaseClass;
import DriverActions.DriverActions;
import Utilities.Utils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class NewHome extends BaseClass {

    @BeforeMethod
    public void setUp() throws Exception{
        LaunchBrowser();
    }

    @Test
    public void toggleBetweenWindows() throws Exception{
        getDriver().get(utils.getConfigURLTestPage());

        DriverActions.waitForSeconds(05);
        String parent = getDriver().getWindowHandle();

        Set<String> s = getDriver().getWindowHandles();

        Iterator<String> iterator = s.iterator();
        while (iterator.hasNext()){
            String childwinDow = iterator.next();

            System.out.println( getDriver().switchTo().window(childwinDow).getTitle());
        }

        getDriver().switchTo().window(parent);

    }

}
