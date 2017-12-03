package com.ayo.zbd.app.action;

import com.ayo.zbd.base.RouterHandler;
import com.ayo.zbd.model.DBColumnModel;
import com.ayo.zbd.model.DBDatabaseModel;
import com.ayo.zbd.model.DBMysqlModel;
import com.ayo.zbd.model.DBTableModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbRouter extends RouterHandler {

    public static final List<String> SYSTEM_DATABASE = new ArrayList<>();
    static {
        SYSTEM_DATABASE.add("information_schema");
        SYSTEM_DATABASE.add("imwx");
        SYSTEM_DATABASE.add("mysql");
        SYSTEM_DATABASE.add("performance_scheme");
        SYSTEM_DATABASE.add("sys");
    }

    @Override
    public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        ResultSet rs = null;
        DBMysqlModel mysql = new DBMysqlModel();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://rm-bp16ad3ce8188drq6o.mysql.rds.aliyuncs.com/mysql?characterEncoding=utf-8&useSSL=false",
                    "root",
                    "cowthan_777");

            ///列出所有数据库
            System.out.println("------------所有数据库--------");
            DatabaseMetaData dmd = (DatabaseMetaData) conn.getMetaData();
            mysql.properies.put("DatabaseProductName", dmd.getDatabaseProductName());
            mysql.properies.put("CatalogSeparator", dmd.getCatalogSeparator());
            mysql.properies.put("CatalogTerm", dmd.getCatalogTerm());
            mysql.properies.put("DatabaseProductVersion", dmd.getDatabaseProductVersion());
            mysql.properies.put("DriverName", dmd.getDriverName());
            mysql.properies.put("DriverVersion", dmd.getDriverVersion());
            mysql.properies.put("ExtraNameCharacters", dmd.getExtraNameCharacters());
            mysql.properies.put("IdentifierQuoteString", dmd.getIdentifierQuoteString());
            mysql.properies.put("NumericFunctions", dmd.getNumericFunctions());
            mysql.properies.put("ProcedureTerm", dmd.getProcedureTerm());
            mysql.properies.put("SchemaTerm", dmd.getSchemaTerm());
            mysql.properies.put("SearchStringEscape", dmd.getSearchStringEscape());
            mysql.properies.put("SQLKeywords", dmd.getSQLKeywords());
            mysql.properies.put("StringFunctions", dmd.getStringFunctions());
            mysql.properies.put("SystemFunctions", dmd.getSystemFunctions());
//            mysql.properies.put("", dmd.getSchemas());
            mysql.properies.put("MaxSchemaNameLength", dmd.getMaxSchemaNameLength() + "");
            mysql.properies.put("MaxBinaryLiteralLength", dmd.getMaxBinaryLiteralLength() + "");
            mysql.properies.put("MaxCatalogNameLength", dmd.getMaxCatalogNameLength() + "");
            mysql.properies.put("MaxCharLiteralLength", dmd.getMaxCharLiteralLength() + "");
            mysql.properies.put("MaxColumnNameLength", dmd.getMaxColumnNameLength() + "");
            mysql.properies.put("MaxColumnsInGroupBy", dmd.getMaxColumnsInGroupBy() + "");
            mysql.properies.put("MaxColumnsInIndex", dmd.getMaxColumnsInIndex() + "");
            mysql.properies.put("MaxColumnsInSelect", dmd.getMaxColumnsInSelect() + "");
            mysql.properies.put("MaxColumnsInTable", dmd.getMaxColumnsInTable() + "");
            mysql.properies.put("MaxConnections", dmd.getMaxConnections() + "");
            mysql.properies.put("MaxCursorNameLength", dmd.getMaxCursorNameLength() + "");
            mysql.properies.put("MaxColumnsInOrderBy", dmd.getMaxColumnsInOrderBy() + "");
            mysql.properies.put("MaxIndexLength", dmd.getMaxIndexLength() + "");
            mysql.properies.put("MaxLogicalLobSize", dmd.getMaxLogicalLobSize() + "");
            mysql.properies.put("MaxProcedureNameLength", dmd.getMaxProcedureNameLength() + "");
            mysql.properies.put("MaxRowSize", dmd.getMaxRowSize() + "");
            mysql.properies.put("MaxStatementLength", dmd.getMaxStatementLength() + "");
            mysql.properies.put("MaxStatements", dmd.getMaxStatements() + "");
            mysql.properies.put("MaxTableNameLength", dmd.getMaxTableNameLength() + "");
            mysql.properies.put("MaxTablesInSelect", dmd.getMaxTablesInSelect() + "");
            mysql.properies.put("MaxUserNameLength", dmd.getMaxUserNameLength() + "");
            mysql.properies.put("JDBCMajorVersion", dmd.getJDBCMajorVersion() + "");
            mysql.properies.put("JDBCMinorVersion", dmd.getJDBCMinorVersion() + "");
            mysql.properies.put("DriverMinorVersion", dmd.getDriverMinorVersion() + "");

            ResultSet rs1 = dmd.getCatalogs();
            while(rs1.next()){
                String dbName = rs1.getString("TABLE_CAT");
                if(SYSTEM_DATABASE.contains(dbName)) continue;
                DBDatabaseModel db = new DBDatabaseModel();
                db.name = dbName;
                mysql.databases.add(db);
            }
            rs1.close();


            for(DBDatabaseModel db: mysql.databases){

                //列出所有表
                conn.close();
                conn = DriverManager.getConnection(
                        "jdbc:mysql://rm-bp16ad3ce8188drq6o.mysql.rds.aliyuncs.com/" + db.name + "?characterEncoding=utf-8&useSSL=false",
                        "root",
                        "cowthan_777");

                dmd = (DatabaseMetaData) conn.getMetaData();
                ResultSet rs2 = dmd.getTables(null, null, "%", null);
                while(rs2.next()){
                    DBTableModel table = new DBTableModel();
                    table.name = rs2.getString("TABLE_NAME");
                    db.tables.add(table);

                    ///列出表中所有字段
                    ResultSet rs3 = dmd.getColumns( null, "%", table.name, "%");
                    while(rs3.next())
                    {
                        DBColumnModel column = new DBColumnModel();
                        column.name = rs3.getString( 4 );
                        column.properties = rs3.getString( 5 );
                        table.columns.add(column);
                    }
                    rs3.close();
                }
            }

//
//                    String sql = "SELECT `SCHEMA_NAME` FROM `information_schema`.`SCHEMATA`";
//                    PreparedStatement statement = conn.prepareStatement(sql);
//                    rs = statement.executeQuery();
//                    while(rs.next()){
//                        System.out.println(rs.getString("TABLE_CAT"));
//                    }
            responseJson(resp, mysql);
//            req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            responseHtml(resp, "<p>" + e.getLocalizedMessage() + "</p>");
        } catch (SQLException e) {
            e.printStackTrace();
            responseHtml(resp, "<p>" + e.getLocalizedMessage() + "</p>");
        } finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
