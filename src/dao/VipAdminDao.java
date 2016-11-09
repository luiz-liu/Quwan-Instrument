package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBHelper;
import entity.Users;

public class VipAdminDao {
	
	//�жϻ����㹻��Ϊ��Ա��
	public int change_vip_status(String user_account){
	
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int isSuccess=0;
			try {
				conn = DBHelper.getConnection();
				String sql = "update user set user_vip = 1 where user_account=?" ; // SQL���
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, user_account);
				//rs = stmt.executeQuery();
				isSuccess= stmt.executeUpdate();
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
			return isSuccess;
	}
	/*public static void main(String[] args) {
		UserVipJudge vipjudge =new UserVipJudge();
		UsersDao usersdao =new UsersDao();
		Users users =new Users();
		users =usersdao.getItemsByUsersAccount("shaoguoji");
		vipjudge.User_pointJudge(users.getUserAccount());
	}*/
}