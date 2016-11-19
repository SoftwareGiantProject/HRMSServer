package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;

import data.sqlmanager.SqlManager;

import org.junit.Test;

public class SqlManagerTest {

	
	private SqlManager sqlManager = SqlManager.getSqlManager();
	
	
	@Before
	public void setUp(){
		sqlManager.getConnection();
		
	}
	
	
	@Test
	public void test() throws SQLException {
	}

}
