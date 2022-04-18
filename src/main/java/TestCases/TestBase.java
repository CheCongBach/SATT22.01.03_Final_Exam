package TestCases;

import Common.Constant;
import Common.WebDriverCommon;
import com.opencsv.CSVReader;
import org.testng.annotations.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestBase {
    @BeforeSuite
    @Parameters("browser")
    public void chooseBrowser (String browserName) {
        Constant.BROWSER = browserName;
    }

    @BeforeMethod
    public void setUp () {
        WebDriverCommon.initDriver();
        WebDriverCommon.navigateToUrlRailway(Constant.RAILWAY_URL);
    }

    @AfterMethod
    public void clear () {
        WebDriverCommon.quitRailwaySystem();
    }

    @DataProvider
    public Iterator<Object[]> data () throws IOException {
        String path = "src\\main\\java\\DataObjects\\" + this.getClass().getSimpleName() + ".csv";
        Reader reader = new FileReader(path);
        CSVReader csvreader = new CSVReader(reader);
        List<Object[]> list = new ArrayList<>();
        String[] nextLine= csvreader.readNext();
        while (nextLine != null) {
            Object[] objLine = nextLine;
            list.add(objLine);
            nextLine= csvreader.readNext();
        }
        Iterator<Object[]> dataObjects = list.iterator();
        return dataObjects;
    }
}
