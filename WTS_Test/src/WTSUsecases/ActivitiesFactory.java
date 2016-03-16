package WTSUsecases;

import org.testng.annotations.Factory;
import WTSUsecases.ActivitiesProperties;
import WTSUsecases.ActivitiesTest;
import WTSUsecases.XlsReader;

public class ActivitiesFactory {
	
	 public Object[] Activities_Array;
     //Login related variables
     public String SheetName = "Activity";
     public String companyColName = "Company";
     public String userIdColName = "UserName";
     public String passWordColName = "Password";
     public String nameColName = "Name";
     public String codeColName = "Code";
     public String descColName = "Description";
     public String runModeColName = "RunMode";
     public String URLColName = "ApplicationURL";
     
     public int FetchTotalRowsToExecute() {
         //XlsReader xls = new XlsReader(System.getProperty("user.dir") + "\\testdata\\VZTime-EnterOthersTime_Multi_Emp_Time.xlsx");
         
         XlsReader xls = new XlsReader(System.getProperty("user.dir") + System.getProperty("file.separator")+ "data"+ System.getProperty("file.separator") +"TestData.xlsx"); 
         
         int totalexe = 0;
         for (int rows = 2; rows <= xls.getRowCount(this.SheetName); rows++) {
                if (xls.getCellData(this.SheetName, "RunMode", rows).trim()
                             .equals("y")) {
                      totalexe++;
                }
         }
         return totalexe;
  }
     @Factory
     public Object[] factoryMethod() {
    	 
    	 int rowstoexecute = FetchTotalRowsToExecute();
    	 Activities_Array = new ActivitiesTest[rowstoexecute];
    	 XlsReader xls = new XlsReader(System.getProperty("user.dir") + System.getProperty("file.separator") + "data"+ System.getProperty("file.separator") +"TestData.xlsx");
    	 int arrayCnt = 0;
    	 for (int rows = 2; rows <= xls.getRowCount(this.SheetName); rows++) 
         {
                if (xls.getCellData(this.SheetName, this.runModeColName, rows).equals("y"))
                {
                	ActivitiesProperties newProp = new ActivitiesProperties();
                      String appUrl = xls.getCellData(this.SheetName,URLColName, rows);
                      String Company = xls.getCellData(this.SheetName,this.companyColName, rows);
                      String UserName = xls.getCellData(this.SheetName,this.userIdColName, rows);
                      String Password = xls.getCellData(this.SheetName,this.passWordColName, rows);
                      String name = xls.getCellData(this.SheetName,this.nameColName, rows);
                      String code = xls.getCellData(this.SheetName,this.codeColName, rows);
                      String desc = xls.getCellData(this.SheetName,this.descColName, rows);
                                                          
                      newProp.APPURL = appUrl;
                      newProp.COMPANY = Company;
                      newProp.USERNAME = UserName;
                      newProp.PASSWORD = Password;
                      newProp.NAME = name;
                      newProp.CODE = code;
                      newProp.DESCRIPTION = desc;
                                           
                      Activities_Array[arrayCnt] = new ActivitiesTest(newProp);
                      arrayCnt++; 
                }
         }
		return Activities_Array;
    	 
     }

}
