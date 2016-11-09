package entity;

import java.sql.Date;

//��Ʒ��
public class Product {

	private int product_id; // ��Ʒ���
	private String product_name; // ��Ʒ����
	private float product_price; // ��Ʒ�۸�
	private String product_color; // ��Ʒ��ɫ
	private String product_size; // ��Ʒ�ߴ�
	private String product_type; // ��Ʒ����
	private String product_level; // ��Ʒ�����߲��
	private int product_sale_count; // ��Ʒ����
	private String product_image; // ��ƷͼƬ
	private String product_introdution; // ��Ʒ����
	private String product_infomation; // ��Ʒ��Ϣ
	private boolean product_is_sale; // ��Ʒ�Ƿ��ϼ�
	private Date product_show_date; // �ϼ�����
	
	
	//�����˲��������Ĺ��췽��
	public Product()
	{
		
	}
	
	//�������Ĺ��췽��
	public Product(int product_id, String product_name, float product_price,
			String product_color, String product_size, String product_type,
			String product_level, int product_sale_count, String product_image,
			String product_introdution, String product_infomation,
			boolean product_is_sale, Date product_show_date) {

		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_color = product_color;
		this.product_size = product_size;
		this.product_type = product_type;
		this.product_level = product_level;
		this.product_sale_count = product_sale_count;
		this.product_image = product_image;
		this.product_introdution = product_introdution;
		this.product_infomation = product_infomation;
		this.product_is_sale = product_is_sale;
		this.product_show_date = product_show_date;
	}

	// setter&getter
	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}


	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public float getProduct_price() {
		return product_price;
	}

	public void setProduct_price(float product_price) {
		this.product_price = product_price;
	}


	public String getProduct_color() {
		return product_color;
	}

	public void setProduct_color(String product_color) {
		this.product_color = product_color;
	}


	public String getProduct_size() {
		return product_size;
	}

	public void setProduct_size(String product_size) {
		this.product_size = product_size;
	}


	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}


	public String getProduct_level() {
		return product_level;
	}

	public void setProduct_level(String product_level) {
		this.product_level = product_level;
	}


	public int getProduct_sale_count() {
		return product_sale_count;
	}

	public void setProduct_sale_count(int product_sale_count) {
		this.product_sale_count = product_sale_count;
	}


	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}


	public String getProduct_introdution() {
		return product_introdution;
	}

	public void setProduct_introdution(String product_introdution) {
		this.product_introdution = product_introdution;
	}


	public String getProduct_infomation() {
		return product_infomation;
	}

	public void setProduct_infomation(String product_infomation) {
		this.product_infomation = product_infomation;
	}


	public boolean isProduct_is_sale() {
		return product_is_sale;
	}

	public void setProduct_is_sale(boolean product_is_sale) {
		this.product_is_sale = product_is_sale;
	}


	public Date getProduct_show_date() {
		return product_show_date;
	}

	public void setProduct_show_date(Date product_show_date) {
		this.product_show_date = product_show_date;
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.getProduct_id()+this.getProduct_name().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this == obj)
		{
			return true;
		}
		if(obj instanceof Product)
		{
			Product i = (Product)obj;
			if(this.getProduct_id()==i.getProduct_id()&&this.getProduct_name().equals(i.getProduct_name()))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	public String toString()
	{
		return "��Ʒ��ţ�"+this.getProduct_id()+",��Ʒ���ƣ�"+this.getProduct_name();
	}

}
