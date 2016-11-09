package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBHelper;
import entity.SaleBefore;
import entity.SaleLater;
import entity.Users;

public class SaleLaterDao {
	/*public static void main(String[] args) {
		SaleLaterDao dao = new SaleLaterDao();
		List<SaleLater> find =dao.findSaleLater();
	}*/
	// ���������ۺ��������
	public List<SaleLater> findSaleLater() {
		List<SaleLater> salelaters = new ArrayList<SaleLater>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from salelater";
			stmt = conn.prepareStatement(sql.toString());
			rs = stmt.executeQuery();
			while (rs.next()) {
				SaleLater salelater = new SaleLater();
				salelater.setSalelater_id(rs.getInt("salelater_id"));
				salelater.setUser_id(rs.getInt("user_id"));
				salelater.setProduct_id(rs.getInt("product_id"));
				salelater.setDeal_id(rs.getInt("deal_id"));
				salelater.setService_type(rs.getString("service_type"));
				salelater.setService_later(rs.getString("service_later"));
				salelater.setSalelater_is_handle(rs.getBoolean("salelater_is_handle"));
				
				salelaters.add(salelater);
			}
			return salelaters;

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

	// ɾ���ۺ������Ϣ
	public Boolean deleteSaleLater(int salelater_id) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			System.out.println("cao");
			try {
					conn = DBHelper.getConnection();
					String sql = "delete from salelater where salelater_id=?"; // SQL���
					stmt = conn.prepareStatement(sql);
					stmt.setInt(1, salelater_id);
					stmt.execute();
	

				} catch (Exception ex) {
					ex.printStackTrace();
					return null;
				} finally {
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

	//�޸��ۺ��������bit(������ϣ�
	public Boolean changeSalerLaterBit(int salelater_id){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "update salebefore set salelater_is_handle = 1 where salelater_id=?" ;; // SQL���
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, salelater_id);
			stmt.executeUpdate();
			
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
			return true;
	}

	//�����ۺ��������
	public List<SaleLater> getSaleLaterByService(String select) {
		List<SaleLater> salelaters = new ArrayList<SaleLater>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();

			StringBuilder sql = new StringBuilder("select * from salelater ");

			sql.append(" where service_later like '%");
			sql.append(select);
			sql.append("%'" );
			System.out.println("sql==>" + sql);
			stmt = conn.prepareStatement(sql.toString());
			rs = stmt.executeQuery();
			while (rs.next()) {
				SaleLater salelater = new SaleLater();
				salelater.setSalelater_id(rs.getInt("salelater_id"));
				salelater.setUser_id(rs.getInt("user_id"));
				salelater.setProduct_id(rs.getInt("product_id"));
				salelater.setDeal_id(rs.getInt("deal_id"));
				salelater.setService_type(rs.getString("service_type"));
				salelater.setService_later(rs.getString("service_later"));
				salelater.setSalelater_is_handle(rs.getBoolean("salelater_is_handle"));
				salelaters.add(salelater);
			}

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

		return salelaters;
	}


}

