package entity;

//�����ۺ������
public class SaleLater {
	private int salelater_id;	//�ۺ����id
	private int user_id;		//�ۺ�����û�id
	private int product_id;		//�ۺ������Ʒid
	private int deal;			//�ۺ���񶩵�ip
	private String service_type;	//�ۺ��������
	private String servive_later;	//�ۺ��������
	private boolean salelater_is_handle;//�ۺ�����Ƿ���
	
	public SaleLater(){}
	
	
	
	public SaleLater(int salelater_id, int user_id, int product_id, int deal,
			String service_type, String servive_later,
			boolean salelater_is_handle) {
		this.salelater_id = salelater_id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.deal = deal;
		this.service_type = service_type;
		this.servive_later = servive_later;
		this.salelater_is_handle = salelater_is_handle;
	}



	public int getSalelater_id() {
		return salelater_id;
	}
	public void setSalelater_id(int salelater_id) {
		this.salelater_id = salelater_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getDeal() {
		return deal;
	}
	public void setDeal(int deal) {
		this.deal = deal;
	}
	public String getService_type() {
		return service_type;
	}
	public void setService_type(String service_type) {
		this.service_type = service_type;
	}
	public String getServive_later() {
		return servive_later;
	}
	public void setServive_later(String servive_later) {
		this.servive_later = servive_later;
	}
	public boolean isSalelater_is_handle() {
		return salelater_is_handle;
	}
	public void setSalelater_is_handle(boolean salelater_is_handle) {
		this.salelater_is_handle = salelater_is_handle;
	}
}
