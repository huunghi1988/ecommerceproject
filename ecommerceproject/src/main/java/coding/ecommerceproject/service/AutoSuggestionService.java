package coding.ecommerceproject.service;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coding.ecommerceproject.db.util.DBUtil;
import coding.ecommerceproject.entity.AutoSuggestion;

public class AutoSuggestionService {
	public List<AutoSuggestion> getkeywords(String keyword) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		AutoSuggestion autoSuggestion = null;
		List<AutoSuggestion> list = new ArrayList<AutoSuggestion>();
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement(
					"SELECT keyword,id FROM sql6631093.autosuggestion where keyword like ?");

			ps.setString(1, keyword);

			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				

				autoSuggestion = new AutoSuggestion(id,keyword);
				list.add(autoSuggestion);
			}
			System.out.println(list.size());

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return list;
	}

	

}
