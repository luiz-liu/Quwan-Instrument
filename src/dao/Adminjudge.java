package dao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import sun.misc.BASE64Encoder;
import entity.Admin;

public class Adminjudge {
	/**
	 * ����MD5���м���
	 * 
	 * @param str
	 *            �����ܵ��ַ���
	 * @return ���ܺ���ַ���
	 * @throws NoSuchAlgorithmException
	 *             û�����ֲ�����ϢժҪ���㷨
	 * @throws UnsupportedEncodingException
	 */
	public static String EncoderByMd5(String str)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// ȷ�����㷽��
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base64en = new BASE64Encoder();
		// ���ܺ���ַ���
		//String newstr = String.valueOf(md5.digest(str.getBytes("utf-8")));
		String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
		return newstr;
	}

	/**
	 * �ж��û������Ƿ���ȷ
	 * 
	 * @param newpasswd
	 *            �û����������
	 * @param oldpasswd
	 *            ���ݿ��д洢�����룭���û������ժҪ
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static boolean checkpassword(String newpasswd, String oldpasswd)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if (EncoderByMd5(newpasswd).equals(oldpasswd)) {
			return true;
		} else{
			return false;
		}
	}

	// �ж�admin�˺������Ƿ����
	public static boolean judge_accountpassword(String username, String password)
			throws SQLException, NoSuchAlgorithmException,
			UnsupportedEncodingException {

		Admin_Dao connect = new Admin_Dao();
		connect.findDepts();
		for (Admin dept : connect.findDepts()) {
			if (dept.getAdminUsername().equals(username)
					&& checkpassword(password, dept.getAdminPassword())) {
				return true;
			}
		}
		return false;
	}
}
