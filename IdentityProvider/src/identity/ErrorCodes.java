package identity;


public enum ErrorCodes
{
	 BUSINESS_ERROR(100), NO_DATA_ERROR(200), SECURITY_ERROR(500), NETWORK_ERROR(1000);

    private int errorCode;
 
    private ErrorCodes(int errorCode) {
        this.errorCode = errorCode;
    }
 
    public int getErrorCode() {
        return errorCode;
    }
}