package dataDrivenSetup;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class APIDataProvider {

    @DataProvider(name = "apidataprovider")
    public Object[][] getEmpData() throws IOException {

        String path=System.getProperty("user.dir")+"/TestResources/TestData.xlsx";
        int row=ExcelUtils.getRowCount(path,"Sheet1");
        int col=ExcelUtils.getCellCount(path,"Sheet1",1);

        String empdata[][]=new String[row][col];

        for (int i = 1; i <= row; i++) {
            for (int j = 0; j < col; j++) {
                empdata[i - 1][j] = ExcelUtils.getCellData(path, "Sheet1", i, j);
            }
        }
      return (empdata);
    }
}
