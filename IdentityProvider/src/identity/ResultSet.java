package identity;

public class ResultSet implements Comparable<ResultSet>
{

	// ID of the Identity
    private String id;
    
    // Name of the Identity
    private String name;
    
    // Department of the Identity
    private String department;
    
    // Sub Department of the Identity
    private String subDepartment;

	/**
	 * Constructor
	 */
	public ResultSet() {
		super();
	}

	/**
	 * Constructor
	 * @param id The ID of the identity
	 */
	public ResultSet(String id) {
		super();
		this.id = id;
		this.name = null;
		this.department = null;
		this.subDepartment = null;
		
	}

	
	/**
	 * Constructor
	 * @param id The ID of the identity
	 * @param name The Name of the identity
	 * @param department The Department the identity belongs to
	 */
	public ResultSet(String id, String name, String department) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.subDepartment = null;
		
	}
	
	/**
	 * Constructor
	 * @param id The ID of the identity
	 * @param name The Name of the identity
	 * @param department The Department the identity belongs to
	 * @param subDepartment The Sub Department belonging to the Department
	 */
	public ResultSet(String id, String name, String department, String subDepartment) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.subDepartment = subDepartment;
		
	}
	
	/**
	 * compare from Comparable
	 */
	@Override
	public int compareTo(ResultSet o) {
		return this.getId().compareTo(o.getId());
	}
	
    
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the subDepartment
	 */
	public String getSubDepartment() {
		return subDepartment;
	}

	/**
	 * @param subDepartment the subDepartment to set
	 */
	public void setSubDepartment(String subDepartment) {
		this.subDepartment = subDepartment;
	}

}
