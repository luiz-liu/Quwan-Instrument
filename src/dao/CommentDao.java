package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.DBHelper;
import entity.Comment;


public class CommentDao {
	public static void main(String[] args) {
		CommentDao dao = new CommentDao();
//		String productName = "YAMAHA ����� ��ҥ���� F310";
//		ArrayList<Comment> list = dao.getCommentsByProductname(productName);
		ArrayList<Comment> list = dao.getCommentsByProductid(1);
		if (list != null && list.size() > 0) {
			System.out.println(list.size());
			for (Comment c : list) {
				System.out.println(c.getComment_content());
			}
		}
	}


	// ͨ����Ʒ����ѯ��Ʒ������
	public ArrayList<Comment> getCommentsByProductname(String productName) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Comment> list = new ArrayList<Comment>(); // ���ۼ���
		int product_id;
		try {
			conn = DBHelper.getConnection();
			String sql = "select product_id from product where product_name=?;"; // SQL���
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, productName);
			rs = stmt.executeQuery();
			if (rs.next()) {
				PreparedStatement stmt2 = null;
				ResultSet rs2 = null;
				product_id = rs.getInt("product_id");
				String sql2 = "select * from comment where product_id=?;"; // SQL���
				stmt2 = conn.prepareStatement(sql2);
				stmt2.setInt(1, product_id);
				rs2 = stmt2.executeQuery();
				while (rs2.next()) {
					Comment comment = new Comment();
					comment.setComment_id(rs2.getInt("comment_id"));
					comment.setUser_id(rs2.getInt("user_id"));
					comment.setComment_degree(rs2.getString("comment_degree"));
					comment.setComment_date(rs2.getDate("comment_date"));
					comment.setProduct_id(rs2.getInt("product_id"));
					comment.setComment_content(rs2.getString("comment_content"));
					list.add(comment);// ���붩������
				}
				return list; // ����ȫ���������ϡ�
			} else {
				return null;
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
	}
	// ͨ����Ʒid��ѯ��Ʒ������
	public ArrayList<Comment> getCommentsByProductid(int productId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Comment> list = new ArrayList<Comment>(); // ���ۼ���
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from comment where product_id=?;"; // SQL���
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, productId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setComment_id(rs.getInt("comment_id"));
				comment.setUser_id(rs.getInt("user_id"));
				comment.setComment_degree(rs.getString("comment_degree"));
				comment.setComment_date(rs.getDate("comment_date"));
				comment.setProduct_id(rs.getInt("product_id"));
				comment.setComment_content(rs.getString("comment_content"));
				list.add(comment);// ���붩������
			}
			return list; // ����ȫ���������ϡ�
			
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
}