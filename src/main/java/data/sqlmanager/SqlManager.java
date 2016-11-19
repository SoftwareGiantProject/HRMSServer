package data.sqlmanager;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 数据库管理类
 * @author looh
 *
 */
public class SqlManager {
	
	/**
	 * 单例
	 */
	private static SqlManager sqlManager;
	
	/**
	 * 数据库信息
	 */
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static String URL = null;
	private static String IP = null;
	private static String USER = null;
	private static String PASSWORD = null;
	private static String DB = null;
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	private Statement statement;
	private ResultSet resultSet;

	static{
		Properties prop = new Properties();
		try{
			InputStream in = new BufferedInputStream(new FileInputStream("hrms.properties"));
			prop.load(in);
			IP = prop.getProperty("db_ip");
			USER = prop.getProperty("db_user");
			PASSWORD = prop.getProperty("db_password");
			DB = prop.getProperty("db");
			URL = "jdbc:mysql://" + IP + "/" + DB;
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	/**
	 * 构造函数 初始化
	 */
	private SqlManager(){
		try{
			Class.forName(DRIVER);
		}catch(Exception e){
			System.out.println("找不到驱动程序类，加载驱动失败");
			e.printStackTrace();
		}
	}
	
	/**
	 * 单例模式
	 * @return sqlmanager
	 */
	public static SqlManager getSqlManager(){
		if(sqlManager != null){
			return sqlManager;
		}
		return new SqlManager();
	}
	
	
	/**
	 * 获得数据库连接
	 * @return Connection
	 */
	public synchronized Connection getConnection(){
		try{
			connection = DriverManager.getConnection(URL,USER,PASSWORD);
			connection.setAutoCommit(false);
		}catch(SQLException e){
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * 提交更改
	 */
	public void commit(){
		try{
			connection.commit();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 释放Connection资源
	 */
	public void releaseConnection(){
		if(connection != null){
			try{
				connection.commit();
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 释放PreparedStatement资源
	 */
	public void releasePreparedStatement(){
		if(preparedStatement != null){
			try{
				preparedStatement.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 释放statement资源
	 */
	public void releaseStatement(){
		if(statement != null){
			try{
				statement.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 释放ResultSet资源
	 */
	public void releaseResultSet(){
		if(resultSet != null){
			try{
				resultSet.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 释放所有资源
	 */
	public void releaseAll(){
		releasePreparedStatement();
		releaseResultSet();
		releaseConnection();
	}
	
	
	
	public static void main(String[] args) throws SQLException{
		SqlManager.getSqlManager().getConnection();
	}
	
}
