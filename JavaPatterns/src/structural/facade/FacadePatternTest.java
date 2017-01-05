package structural.facade;

import java.sql.Connection;

/**
 * Created by Marina on 02.01.2017.
 */
public class FacadePatternTest {
    public static void main(String[] args){
        String tableName = "Employee";

        Connection con = MySqlHelper.getMySqlConnection();
        MySqlHelper mySqlHelp = new MySqlHelper();
        mySqlHelp.generateMySqlHTMLReport(tableName,con);

        Connection con1 = OracleHelper.getOracleDBConnection();
        OracleHelper oracleHelper = new OracleHelper();
        oracleHelper.generateOraclePDFReport(tableName,con);

        HelperFacade.generateReport(HelperFacade.DBTypes.MYSQL, HelperFacade.ReportTypes.HTML,tableName);
        HelperFacade.generateReport(HelperFacade.DBTypes.ORACLE, HelperFacade.ReportTypes.PDF,tableName);
    }
}
