package Sservices.Bean;

public class InsertServices {

	private int packageID;
	private String packageType, PackageInstruction,services;
	private float packageUnitPrice;
	private int empId;
	
	// Creating getters and setters
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getPackageID() {
		return packageID;
	}
	public void setPackageID(int packageID) {
		this.packageID = packageID;
	}
	public String getPackageType() {
		return packageType;
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	public String getPackageInstruction() {
		return PackageInstruction;
	}
	public void setPackageInstruction(String packageInstruction) {
		PackageInstruction = packageInstruction;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public float getPackageUnitPrice() {
		return packageUnitPrice;
	}
	public void setPackageUnitPrice(float packageUnitPrice) {
		this.packageUnitPrice = packageUnitPrice;
	}
	
	
	
}
