package entity;

//������ǰ������
public class SaleBefore {
	private int salebefore_id; //��ǰ����id
	private int user_id;		//�û�id
	private int product_id;		//��Ʒid
	private String service_before; //��ǰ��������
	
	public SaleBefore(){
		
	}
	
	public SaleBefore(int salebefore_id,int user_id,int product_id,String service_before){
		
		this.salebefore_id=salebefore_id;
		this.user_id=user_id;
		this.product_id=product_id;
		this.service_before =service_before;
	}
	
	public int getSalebefore_id() {
		return salebefore_id;
	}
	public void setSalebefore_id(int salebefore_id) {
		this.salebefore_id = salebefore_id;
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
	public String getService_before() {
		return service_before;
	}
	public void setService_before(String service_before) {
		this.service_before = service_before;
	}
	
}
