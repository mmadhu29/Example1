package WTSUsecases;

import org.testng.annotations.Factory;
import WTSUsecases.XlsReader;
import WTSUsecases.NewUserProperties;
import WTSUsecases.NewUserTest;

public class NewUserFactory {
	
	public Object[] Newuser_Array;
    //Login related variables
    public String SheetName = "Activity";
    public String companyColName = "Company";
    public String userIdColName = "UserName";
    public String passWordColName = "Password";
    public String firstnameColName = "Firstname";
    public String lastnameColName = "Lastname";
    public String startdateColName = "StartDate";
    public String runModeColName = "RunMode";
    public String loginnameColName = "Loginname";
    public String userpasswordColName = "UserPassword";
    public String userroleColName= "UserRole";
    public String timesheettemplateColName = "TimesheetTemplate";
    public String URLColName = "ApplicationURL";
    
    
    public int FetchTotalRowsToExecute() {
        //XlsReader xls = new XlsReader(System.getProperty("user.dir") + "\\testdata\\VZTime-EnterOthersTime_Multi_Emp_Time.xlsx");
        
        XlsReader xls = new XlsReader(System.getProperty("user.dir") + System.getProperty("file.separator")+ "data"+ System.getProperty("file.separator") +"TestData.xls"); 
        
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
   	 Newuser_Array = new NewUserTest[rowstoexecute];
   	 XlsReader xls = new XlsReader(System.getProperty("user.dir") + System.getProperty("file.separator") + "data"+ System.getProperty("file.separator") +"TestData.xls");
   	 int arrayCnt = 0;
   	 for (int rows = 2; rows <= xls.getRowCount(this.SheetName); rows++) 
        {
               if (xls.getCellData(this.SheetName, this.runModeColName, rows).equals("y"))
               {
               	NewUserProperties newProp = new NewUserProperties();
                     String appUrl = xls.getCellData(this.SheetName,URLColName, rows);
                     String Company = xls.getCellData(this.SheetName,this.companyColName, rows);
                     String UserName = xls.getCellData(this.SheetName,this.userIdColName, rows);
                     String Password = xls.getCellData(this.SheetName,this.passWordColName, rows);
                     String Firstname = xls.getCellData(this.SheetName,this.firstnameColName, rows);
                     String Lastname = xls.getCellData(this.SheetName,this.lastnameColName, rows);
                     String Startdate = xls.getCellData(this.SheetName,this.startdateColName, rows);
                     String Loginname = xls.getCellData(this.SheetName, this.loginnameColName, rows);
                     String UserPassword = xls.getCellData(this.SheetName, this.userpasswordColName, rows);
                     String UserRole = xls.getCellData(this.SheetName, this.userroleColName, rows);
                     String TimesheetTemplate = xls.getCellData(this.SheetName, this.timesheettemplateColName, rows);
                     
                     
                     newProp.APPURL = appUrl;
                     newProp.COMPANY = Company;
                     newProp.USERNAME = UserName;
                     newProp.PASSWORD = Password;
                     newProp.FIRSTNAME = Firstname;
                     newProp.LASTNAME = Lastname;
                     newProp.STARTDATE = Startdate;
                     newProp.LOGINNAME = Loginname;
                     newProp.USERPASSWORD = UserPassword;
                     newProp.USERROLE = UserRole;
                     newProp.TIMESHEETTEMPLATE = TimesheetTemplate;
                     
                                          
                     Newuser_Array[arrayCnt] = new NewUserTest(newProp);
                     arrayCnt++; 
               }
        }
		return Newuser_Array;
   	 
    }

	

}
