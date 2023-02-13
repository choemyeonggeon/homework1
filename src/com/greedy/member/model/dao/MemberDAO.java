package com.greedy.member.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;
import static com.greedy.common.JDBCTemplate.close;

import com.greedy.member.model.dto.MemberDTO;

public class MemberDAO {
	
	private Properties prop;
	
	public MemberDAO() {
		this.prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/member-query.xml"));
			
		} catch (InvalidPropertiesFormatException e) {
				e.printStackTrace();
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertNewMember(Connection con, MemberDTO member) {
		
		String query = prop.getProperty("insertMember");
		
		System.out.println(query);
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,member.getId());
			pstmt.setString(2,member.getPwd());
			pstmt.setString(3,member.getName());
			pstmt.setString(4,member.getGender());
			pstmt.setString(5,member.getEmeil());
			pstmt.setString(6,member.getPhone());
			pstmt.setString(7,member.getAddress());
			pstmt.setInt(8, member.getAge());
		
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			
		}
		return result;
	}
	public List<MemberDTO> selectAllMembers(Connection con){
		
		Statement stmt = null;
		ResultSet rset = null;
		List<MemberDTO> memberList = null;
		
		String query = prop.getProperty("selectMemberList");
		
		try {
			stmt= con.createStatement();
			rset = stmt.executeQuery(query);
			
			memberList = new ArrayList<>();	
			
			while(rset.next()) {
				
				MemberDTO row = new MemberDTO();
				
				
				row.setId(rset.getString("MEMBER_ID"));
				row.setPwd(rset.getString("MEMBER_PWD"));
				row.setName(rset.getString("MEMBER_NAME"));
				row.setGender(rset.getString("GENDER"));
				row.setEmeil(rset.getString("EMAIL"));
				row.setPhone(rset.getString("PHONE"));
				row.setAddress(rset.getString("ADDRESS"));
				row.setAge(rset.getInt("AGE"));
			
				
				memberList.add(row);
				}
			
		} catch (SQLException e) {	
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return memberList;
	}
}
