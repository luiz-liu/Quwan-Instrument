package entity;

public class Users {
	private int userId;//�û�Id
	private String userAccount;//�û��ʺ�
	private String userPassword;//�û�����
	private String userName;//�û�����
	private String userImage;//�û�ͷ��
	private String userPhone;//�û��ֻ�
	private String userEmail;//�û�����
	private String userAddress;//�û���ַ
	private int userPoint;//�û�����
	private boolean userVip;//�û��Ա�
	public Users(){
		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public int getUserPoint() {
		return userPoint;
	}
	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}
	public boolean isUserVip() {
		return userVip;
	}
	public void setUserVip(boolean userVip) {
		this.userVip = userVip;
	}
	
}
