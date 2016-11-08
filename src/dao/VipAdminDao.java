package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBHelper;
import entity.Vip_apply;

public class VipAdminDao {
	
	//ͬ���Ϊ��Ա
	public boolean VipAgree(int user_id){
	
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DBHelper.getConnection();
		try {
				conn = DBHelper.getConnection();
				String sql = "update user set user_vip = 1 where user_id=?" ; // SQL���
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, user_id);
				//rs = stmt.executeQuery();
				stmt.executeUpdate();
				sql = "update vipapply set ishandle = 0 where user_id=?" ; // SQL���
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, user_id);
				//rs = stmt.executeQuery();
				stmt.executeUpdate();
			} catch (Exception ex) {
				ex.printStackTrace();
				
			} finally {
				// �ͷ����ݼ�����
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// �ͷ�������
				if (stmt != null) {
					try {
						stmt.close();
						stmt = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}	
			return true;
	}
	
	//��Ա����ܾ�
	public boolean VipRefuse(int user_id){
	
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DBHelper.getConnection();
		try {
				conn = DBHelper.getConnection();
				String sql = "update vipapply set ishandle = 0 where user_id=?" ; // SQL���
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, user_id);
				//rs = stmt.executeQuery();
				stmt.executeUpdate();
			} catch (Exception ex) {
				ex.printStackTrace();
				
			} finally {
				// �ͷ����ݼ�����
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// �ͷ�������
				if (stmt != null) {
					try {
						stmt.close();
						stmt = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}	
		return true;	
	}
	
	//��ȡ���л�Ա����
	public List<Vip_apply> findAllVip_Apply(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Vip_apply> list = new ArrayList<Vip_apply>(); // ��Ա���뼯��
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from vipapply;"; // SQL���
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Vip_apply vip_apply = new Vip_apply();
				
				vip_apply.setUser_id(rs.getInt("user_id"));
				vip_apply.setIshandle(rs.getBoolean("ishandle"));
				vip_apply.setDate(rs.getDate("date"));

				list.add(vip_apply);//������vip_apply���뼯��
			}
			return list; // ���ؼ��ϡ�
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			// �ͷ����ݼ�����
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// �ͷ�������
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	
	}
	
	//ɾ����Ա����
	public boolean VipDelete(int user_id){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "delete from vipapply where user_id=?"; // SQL���
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, user_id);
			rs = stmt.executeQuery();
			} catch (Exception ex) {
				ex.printStackTrace();
				
			} finally {
				// �ͷ����ݼ�����
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// �ͷ�������
				if (stmt != null) {
					try {
						stmt.close();
						stmt = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}	
		return true;	
	}

	/*public static void main(String[] args) {
	UserVipJudge vipjudge =new UserVipJudge();
	UsersDao usersdao =new UsersDao();
	Users users =new Users();
	users =usersdao.getItemsByUsersAccount("shaoguoji");
	vipjudge.User_pointJudge(users.getUserAccount());
	}*/
}