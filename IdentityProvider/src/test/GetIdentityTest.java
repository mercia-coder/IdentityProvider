/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import identity.ApplicationException;
import identity.DataStore;
import identity.ResultSet;

/**
 * @author Mercia Zaayman
 *
 */

public class GetIdentityTest {

	// Testing DataStore
	DataStore dataStore = new DataStore();
	
	// Username and password
	private static String username;
	private static String password;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		username = "validUserName";
		password = "validPassword";
	}


	/**
	 * Test method for {@link identity.DataStore#getIdentities(java.lang.String, java.util.List)}.
	 * @throws ApplicationException 
	 */
	@Test
	public void testGetIdentities_1RowList_NoSubDept_Success() throws ApplicationException {
		
		// Data  to DataStore for testing
		List<ResultSet> resultSetList = new ArrayList<ResultSet>();

        ResultSet resultSet = new ResultSet();
        resultSet = new ResultSet();
        resultSet.setId("abc12");
        resultSet.setName("I1");
        resultSet.setDepartment("D1");
        resultSetList.add(resultSet);
        
        String searchString = "abc12";
        
        ResultSet expectedOutput = new ResultSet("abc12","I1","D1",null);
        
        assertTrue(ObjectsAreEqual(expectedOutput, dataStore.getIdentity(username,  password, searchString, resultSetList)));
        
	}
	
	/**
	 * Test method for {@link identity.DataStore#getIdentities(java.lang.String, java.util.List)}.
	 * @throws ApplicationException 
	 */
	@Test(expected = ApplicationException.class)
	public void testGetIdentities_1RowList_NoSubDept_NotFound() throws ApplicationException {
		// Data  to DataStore for testing
		List<ResultSet> resultSetList = new ArrayList<ResultSet>();

        ResultSet resultSet = new ResultSet();
        resultSet = new ResultSet();
        resultSet.setId("cde890");
        resultSet.setName("I1");
        resultSet.setDepartment("D1");
        resultSetList.add(resultSet);
        
        String searchString = "abc123";
        
       	dataStore.getIdentity(username, password, searchString, resultSetList);
	}
	
	/**
	 * Test method for {@link identity.DataStore#getIdentities(java.lang.String, java.util.List)}.
	 * @throws ApplicationException 
	 */
	@Test
	public void testGetIdentities_MultyRowList_NoSubDept_Success() throws ApplicationException {
		
		// Data  to DataStore for testing
		List<ResultSet> resultSetList = new ArrayList<ResultSet>();

		ResultSet resultSet = new ResultSet();
		resultSet.setId("efg12");
        resultSet.setName("I1");
        resultSet.setDepartment("D1");
        resultSetList.add(resultSet);
        
        resultSet = new ResultSet();
        resultSet.setId("abc12");
        resultSet.setName("I1");
        resultSet.setDepartment("D1");
        resultSetList.add(resultSet);
        
        String searchString = "abc12";
        
        ResultSet expectedOutput = new ResultSet("abc12","I1","D1",null);
        
        assertTrue(ObjectsAreEqual(expectedOutput, dataStore.getIdentity(username, password, searchString, resultSetList)));
        

	}
	
	/**
	 * Test method for {@link identity.DataStore#getIdentities(java.lang.String, java.util.List)}.
	 * @throws ApplicationException 
	 */
	@Test(expected = ApplicationException.class)
	public void testGetIdentities_MultyRowList_NoSubDept_NotFound() throws ApplicationException {
		// Data  to DataStore for testing
		List<ResultSet> resultSetList = new ArrayList<ResultSet>();

		ResultSet resultSet = new ResultSet();
		resultSet.setId("efg12");
        resultSet.setName("I1");
        resultSet.setDepartment("D1");
        resultSetList.add(resultSet);
        
        resultSet = new ResultSet();
        resultSet.setId("abc12");
        resultSet.setName("I1");
        resultSet.setDepartment("D1");
        resultSetList.add(resultSet);
        
        String searchString = "hjk345";
        
        dataStore.getIdentity(username, password, searchString, resultSetList);

	}
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void testGetIdentities_MultyRowList_NoSubDept_NotFoundMesage() throws ApplicationException {
		// Data  to DataStore for testing
		List<ResultSet> resultSetList = new ArrayList<ResultSet>();

		ResultSet resultSet = new ResultSet();
		resultSet.setId("efg12");
        resultSet.setName("I1");
        resultSet.setDepartment("D1");
        resultSetList.add(resultSet);
        
        resultSet = new ResultSet();
        resultSet.setId("abc12");
        resultSet.setName("I1");
        resultSet.setDepartment("D1");
        resultSetList.add(resultSet);
        
        String searchString = "hjk345";
        String errorString = "Identification for "+searchString+" not found";

        expectedException.expect(ApplicationException.class);
        expectedException.expectMessage(errorString);

        resultSet = new ResultSet();
        resultSet =  dataStore.getIdentity(username, password, searchString, resultSetList);
        
        
	}
	
	/**
	 * Test method for {@link identity.DataStore#getIdentities(java.lang.String, java.util.List)}.
	 * @throws ApplicationException 
	 */
	@Test
	public void testGetIdentities_1RowList_SubDept_Success() throws ApplicationException {
		// Data  to DataStore for testing
		List<ResultSet> resultSetList = new ArrayList<ResultSet>();

        ResultSet resultSet = new ResultSet();
        resultSet = new ResultSet();
        resultSet.setId("abc12");
        resultSet.setName("I1");
        resultSet.setDepartment("D1");
        resultSet.setSubDepartment("SD1");
        resultSetList.add(resultSet);
        
        String searchString = "abc12";
        
        ResultSet expectedOutput = new ResultSet("abc12","I1","D1","SD1");
        
        assertTrue(ObjectsAreEqual(expectedOutput, dataStore.getIdentity(username, password, searchString, resultSetList)));
	}
	
	/**
	 * Test method for {@link identity.DataStore#getIdentities(java.lang.String, java.util.List)}.
	 * @throws ApplicationException 
	 */
	@Test (expected = ApplicationException.class)
	public void testGetIdentities_1RowList_SubDept_NotFound() throws ApplicationException {
		// Data  to DataStore for testing
		List<ResultSet> resultSetList = new ArrayList<ResultSet>();

        ResultSet resultSet = new ResultSet();
        resultSet = new ResultSet();
        resultSet.setId("cde890");
        resultSet.setName("I1");
        resultSet.setDepartment("D1");
        resultSet.setSubDepartment("SD1");
        resultSetList.add(resultSet);
        
        String searchString = "abc123";
        
       	dataStore.getIdentity(username, password, searchString, resultSetList);
	}

	/**
	 * Test method for {@link identity.DataStore#getIdentities(java.lang.String, java.util.List)}.
	 * @throws ApplicationException 
	 */
	@Test
	public void testGetIdentities_MultyRowList_SubDept_Success() throws ApplicationException {
			// Data  to DataStore for testing
			List<ResultSet> resultSetList = new ArrayList<ResultSet>();

			ResultSet resultSet = new ResultSet();
			resultSet.setId("efg12");
	        resultSet.setName("I1");
	        resultSet.setDepartment("D1");
	        resultSet.setSubDepartment("SD1");
	        resultSetList.add(resultSet);
	        
	        resultSet = new ResultSet();
	        resultSet.setId("abc12");
	        resultSet.setName("I1");
	        resultSet.setDepartment("D5");
	        resultSet.setSubDepartment("SD5");
	        resultSetList.add(resultSet);
	        
	        resultSet = new ResultSet();
	        resultSet.setId("xyz876");
	        resultSet.setName("M2");
	        resultSet.setDepartment("D6");
	        resultSet.setSubDepartment("SD6");
	        resultSetList.add(resultSet);
	        
	        String searchString = "abc12";
	        
	        ResultSet expectedOutput = new ResultSet("abc12","I1","D5","SD5");
	        
	        assertTrue(ObjectsAreEqual(expectedOutput, dataStore.getIdentity(username, password, searchString, resultSetList)));
	}

	/**
	 * Test method for {@link identity.DataStore#getIdentities(java.lang.String, java.util.List)}.
	 * @throws ApplicationException 
	 */
	@Test (expected = ApplicationException.class)
	public void testGetIdentities_MultyRowList_SubDept_NotFound() throws ApplicationException {
		// Data  to DataStore for testing
		List<ResultSet> resultSetList = new ArrayList<ResultSet>();

		ResultSet resultSet = new ResultSet();
		resultSet.setId("efg12");
        resultSet.setName("I1");
        resultSet.setDepartment("D1");
        resultSet.setSubDepartment("SD1");
        resultSetList.add(resultSet);
        
        resultSet = new ResultSet();
        resultSet.setId("abc12");
        resultSet.setName("I1");
        resultSet.setDepartment("D5");
        resultSet.setSubDepartment("SD5");
        resultSetList.add(resultSet);
        
        resultSet = new ResultSet();
        resultSet.setId("xyz876");
        resultSet.setName("M2");
        resultSet.setDepartment("D6");
        resultSet.setSubDepartment("SD6");
        resultSetList.add(resultSet);
        
        String searchString = "wyw432";
        
        dataStore.getIdentity(username, password, searchString, resultSetList);
	}


	@Test
	public void testGetIdentities_EmptyInputList() throws ApplicationException {
		// Data  to DataStore for testing
		List<ResultSet> resultSetList = null;


        expectedException.expect(ApplicationException.class);
        expectedException.expectMessage("Identification list is empty");
        
        String searchString = "hjk345";
        
        dataStore.getIdentity(username, password, searchString, resultSetList);
        
      
	}
	
	
	/**
	 * Test method for {@link identity.DataStore#connect(java.lang.String, java.lang.String)}.
	 * @throws ApplicationException 
	 */
	@Test
	public void testConnect_FailureMessage() throws ApplicationException {
		
		// Data  to DataStore for testing
		List<ResultSet> resultSetList = new ArrayList<ResultSet>();

		ResultSet resultSet = new ResultSet();
		resultSet.setId("efg12");
        resultSet.setName("I1");
        resultSet.setDepartment("D1");
        resultSet.setSubDepartment("SD1");
        resultSetList.add(resultSet);
        
       
        String searchString = "wyw432";
        
        String errorString = "Invalid security details supplied";

        expectedException.expect(ApplicationException.class);
        expectedException.expectMessage(errorString);

		// give invalid username and password
        dataStore.getIdentity("mercia", "pwd", searchString, resultSetList);
	
	}



	protected boolean ObjectsAreEqual(ResultSet result1, ResultSet result2)
	{
		boolean ast = false;
		
		if( (result1.getId() == result2.getId())
			&& (result1.getName() == result2.getName())
			&& (result1.getDepartment() == result2.getDepartment())
			&& (result1.getSubDepartment() == result2.getSubDepartment()))
		ast = true;
	
		return ast;
	}

}

