package Bill.bean;

public class addBillBean {
	
	private String userId;
	private String billId;
	private String date;
	private float arrears;
	private float amount;
	private float totalPayble;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getArrears() {
		return arrears;
	}
	public void setArrears(float arrears) {
		this.arrears = arrears;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getTotalPayble() {
		return totalPayble;
	}
	public void setTotalPayble(float totalPayble) {
		this.totalPayble = totalPayble;
	}
	
}
