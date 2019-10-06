package identity;

import java.util.Collections;
import java.util.List;

public class DataStore 
{
	/**
	 * Constructor
	 */
	public DataStore() 
	{
		
	}
    
	/**
	 * getIdentity  Gets the Identity that is searched for
	 * @param username The Username 
	 * @param password The Password
	 * @param searchString The String value to search by
	 * @param data The data to search
	 * @return Returning the searched Identity
	 * @throws ApplicationException
	 */
	 public ResultSet getIdentity(String username, String password, String searchString, List<ResultSet> data) throws ApplicationException
	 {
	   	// connect with valid credentials before access is allowed
	   	DataStore dataStore = DataStore.connect(username, password);
	    	
	    // retrieve the identity
	    ResultSet identity = dataStore.getIdentities(searchString, data);
	        
	    return identity;
	 }
	  
	 /**
	  * To Validate the user details
	  * @param username The Username
	  * @param password The Password
	  * @return Return the dataStore
	  * @throws ApplicationException
	  */
    private static DataStore connect(
    				String username, 
    				String password) throws ApplicationException
    {
    	// This class will validate the users username and password
    	// If it is valid the datastore will be returned
    	// if invalid it will raise an exception - just for my test case I will assume mercia/pwd is invalid
    	
    	if (username.equals("mercia") && (password.equals("pwd")))
    	{
    		// throw error, no DataStore returned
    		throw new ApplicationException("Invalid security details supplied", ErrorCodes.SECURITY_ERROR);
    	}
    	
        return new DataStore();
    }
    
    /**
     * getIdentities Gets the Identity that is searched for
     * @param searchString  The string value to find the Identity by
     * @param data The data to search
     * @return Returning the Identity
     * @throws ApplicationException
     */
    private ResultSet getIdentities(
    				String searchString, 
    				List<ResultSet> data) throws ApplicationException
    {
    	ResultSet resultSet = new ResultSet();
    	int index = -1;

    	try
    	{
	    	// Sort List before using binarySearch
	    	Collections.sort(data);
	    	
	    	// Search for given id
	    	index = Collections.binarySearch(data, new ResultSet(searchString));
	    	
    	}
    	catch (NullPointerException ex)
    	{
    		throw new ApplicationException("Identification list is empty", ex.getCause(), ErrorCodes.BUSINESS_ERROR);
    	}
    	catch (ClassCastException ex)
    	{
    		throw new ApplicationException(ex.getMessage(), ex.getCause(), ErrorCodes.BUSINESS_ERROR);
    	}
    	catch (UnsupportedOperationException ex)
    	{
    		throw new ApplicationException(ex.getMessage(), ex.getCause(), ErrorCodes.BUSINESS_ERROR);
    	}
    	
	   	
	   	if (index > -1)
	   	{
	   		resultSet = data.get(index);
	   	}
	   	else
		{
			throw new ApplicationException("Identification for "+searchString+" not found", ErrorCodes.NO_DATA_ERROR);
		}
    	
    	return resultSet;
    	
    }
    

}
