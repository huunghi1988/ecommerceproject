package coding.ecommerceproject.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import coding.ecommerceproject.db.util.DBUtil;
import coding.ecommerceproject.entity.Category;

public class CategoryService {
	private final String GET_ALL_CATEGORY = "Select * from `category`";

	public List<Category> getAllCategories() throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Category category = null;
		List<Category> list = new ArrayList<Category>();
		try {
			conn = DBUtil.makeConnection();
			ps = conn.prepareStatement(GET_ALL_CATEGORY);
			rs = ps.executeQuery();

			while (rs.next()) {
				int categoryId = rs.getInt("category_id");
				String categoryName = rs.getString("category_name");
				String imageUrl = rs.getString("image_url");

				category = new Category(categoryId, categoryName,imageUrl);
				
				list.add(category);
			}
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
