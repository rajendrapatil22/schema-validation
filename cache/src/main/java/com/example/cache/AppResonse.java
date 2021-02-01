package com.example.cache;

public class AppResonse {
private String status;
private String statusCode;
private String statusDescription;
public AppResonse(String status, String statusCode, String statusDescription) {
	super();
	this.status = status;
	this.statusCode = statusCode;
	this.statusDescription = statusDescription;
}
@Override
public String toString() {
	return "AppResonse [status=" + status + ", statusCode=" + statusCode + ", statusDescription=" + statusDescription
			+ "]";
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getStatusCode() {
	return statusCode;
}
public void setStatusCode(String statusCode) {
	this.statusCode = statusCode;
}
public String getStatusDescription() {
	return statusDescription;
}
public void setStatusDescription(String statusDescription) {
	this.statusDescription = statusDescription;
}

}
