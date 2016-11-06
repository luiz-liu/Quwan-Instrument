package entity;

import java.util.Date;

//��Ʒ��
public class Comment {

	private int comment_id; // ����ID
	private int product_id; // ��ƷID
	private int user_id; // �û�ID
	private String comment_degree; // ���۵ȼ�
	private String comment_content; // ��������
	private Date comment_date; // ����ʱ��
	
	
	
	
	//�����˲��������Ĺ��췽��
	public Comment()
	{
		
	}

	public Comment(int comment_id, int product_id, int user_id,
			String comment_degree, String comment_content, Date comment_date) {
		super();
		this.comment_id = comment_id;
		this.product_id = product_id;
		this.user_id = user_id;
		this.comment_degree = comment_degree;
		this.comment_content = comment_content;
		this.comment_date = comment_date;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getComment_degree() {
		return comment_degree;
	}

	public void setComment_degree(String comment_degree) {
		this.comment_degree = comment_degree;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public Date getComment_date() {
		return comment_date;
	}

	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}

}
