package entity;

import java.util.Date;

//��Ʒ��
public class Deal {

	private int deal_id; // ��������ID
	private String deal_state; // ����״̬
	private Date deal_create_date; // ����ʱ��
	private Date deal_send_date; // ����ʱ��
	private Date deal_recieve_date; // ȷ���ջ�ʱ��
	private short is_delete; // �Ƿ�ɾ��
	
	
	
	//�����˲��������Ĺ��췽��
	public Deal()
	{
		
	}
	
	public Deal(int deal_id, String dear_state, Date deal_create_date,
			Date deal_send_date, Date deal_recieve_date, short is_delete) {
		super();
		this.deal_id = deal_id;
		this.deal_state = dear_state;
		this.deal_create_date = deal_create_date;
		this.deal_send_date = deal_send_date;
		this.deal_recieve_date = deal_recieve_date;
		this.is_delete = is_delete;
	}



	public int getDeal_id() {
		return deal_id;
	}



	public void setDeal_id(int deal_id) {
		this.deal_id = deal_id;
	}



	public String getDeal_state() {
		return deal_state;
	}



	public void setDeal_state(String dear_state) {
		this.deal_state = dear_state;
	}



	public Date getDeal_create_date() {
		return deal_create_date;
	}



	public void setDeal_create_date(Date deal_create_date) {
		this.deal_create_date = deal_create_date;
	}



	public Date getDeal_send_date() {
		return deal_send_date;
	}



	public void setDeal_send_date(Date deal_send_date) {
		this.deal_send_date = deal_send_date;
	}



	public Date getDeal_recieve_date() {
		return deal_recieve_date;
	}



	public void setDeal_recieve_date(Date deal_recieve_date) {
		this.deal_recieve_date = deal_recieve_date;
	}



	public short getIs_delete() {
		return is_delete;
	}



	public void setIs_delete(short is_delete) {
		this.is_delete = is_delete;
	}



	
}
