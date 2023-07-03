package coding.ecommerceproject.service;


import java.sql.Connection;
import java.util.Date;
import java.sql.Timestamp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coding.ecommerceproject.db.util.DBUtil;
import coding.ecommerceproject.entity.Category;
import coding.ecommerceproject.entity.Product;

public class ProductService {
		public List<Product> getProductsByCategoryId(int categoryId) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product product = null;
		List<Product> list = new ArrayList<Product>();
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement("SELECT * FROM be4_project.Products join Product_Images on Products.product_id = Product_Images.product_id join Product_Category on Products.product_id = Product_Category.product_id where Product_Images.is_primary=1 and category_id = ?");
			//SELECT * FROM be4_project.Products join Product_Images on Products.product_id = Product_Images.product_id where Product_Images.is_primary=1
			ps.setInt(1, categoryId);
			
			rs = ps.executeQuery();

			while (rs.next()) {
				int product_id = rs.getInt("product_id");
				String product_name = rs.getString("product_name");
				String description= rs.getString("description");
				String dimensions= rs.getString("dimensions");
				int price=rs.getInt("price");
				int discount_price=rs.getInt("discount_price");
				int stock_quantity=rs.getInt("stock_quantity");
				String weight= rs.getString("product_name");
				Timestamp created_at=rs.getTimestamp("created_at");
				Timestamp updated_at=rs.getTimestamp("updated_at");
				String image_url= rs.getString("image_url");
				int category_id = rs.getInt("category_id");

				product = new Product( product_id,  product_name,  description,  dimensions,  price,
						 discount_price,  stock_quantity,  weight,  created_at,  updated_at,image_url,category_id);
				list.add(product);
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
		public List<Product> getProductsByProductId(int productId) throws SQLException {

		//public List<Product> getProductsByName() throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product product = null;
		List<Product> list = new ArrayList<Product>();
		try {
			conn = DBUtil.makeConnection();

			//ps = conn.prepareStatement("Select * from `Products`");
			ps = conn.prepareStatement("SELECT * FROM be4_project.Products join Product_Images on Products.product_id = Product_Images.product_id join Product_Category on Products.product_id = Product_Category.product_id where where Product_Images.is_primary=1 and product_id = ?");

			ps.setInt(1, productId);
			
			rs = ps.executeQuery();

			while (rs.next()) {
				int product_id = rs.getInt("product_id");
				String product_name = rs.getString("product_name");
				String description= rs.getString("description");
				String dimensions= rs.getString("dimensions");
				int price=rs.getInt("price");
				int discount_price=rs.getInt("discount_price");
				int stock_quantity=rs.getInt("stock_quantity");
				String weight= rs.getString("product_name");
				Timestamp created_at=rs.getTimestamp("created_at");
				Timestamp updated_at=rs.getTimestamp("updated_at");
				String image_url= rs.getString("image_url");
				int category_id = rs.getInt("category_id");

				product = new Product( product_id,  product_name,  description,  dimensions,  price,
						 discount_price,  stock_quantity,  weight,  created_at,  updated_at,image_url,category_id);
				list.add(product);
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
		public List<Product> getAllProducts() throws SQLException {

		//public List<Product> getProductsByName() throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product product = null;
		List<Product> list = new ArrayList<Product>();
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement("SELECT * FROM be4_project.Products join Product_Images on Products.product_id = Product_Images.product_id join Product_Category on Products.product_id = Product_Category.product_id where Product_Images.is_primary=1");
			
			
			rs = ps.executeQuery();

			while (rs.next()) {
				int product_id = rs.getInt("product_id");
				String product_name = rs.getString("product_name");
				String description= rs.getString("description");
				String dimensions= rs.getString("dimensions");
				int price=rs.getInt("price");
				int discount_price=rs.getInt("discount_price");
				int stock_quantity=rs.getInt("stock_quantity");
				String weight= rs.getString("product_name");
				Timestamp created_at=rs.getTimestamp("created_at");
				Timestamp updated_at=rs.getTimestamp("updated_at");
				String image_url= rs.getString("image_url");
				int category_id = rs.getInt("category_id");

				product = new Product( product_id,  product_name,  description,  dimensions,  price,
						 discount_price,  stock_quantity,  weight,  created_at,  updated_at,image_url,category_id);
				list.add(product);
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
		public List<Product> getProductsBySearch(String keyword) throws SQLException {

			//public List<Product> getProductsByName() throws SQLException {

			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Product product = null;
			List<Product> list = new ArrayList<Product>();
			try {
				conn = DBUtil.makeConnection();

				ps = conn.prepareStatement("SELECT * FROM be4_project.Products join Product_Images on Products.product_id = Product_Images.product_id join Product_Category on Products.product_id = Product_Category.product_id  where where Product_Images.is_primary=1 and Product_name like ?");

				ps.setString(1,"%"+ keyword+"%");
				
				
				rs = ps.executeQuery();

				while (rs.next()) {
					int product_id = rs.getInt("product_id");
					String product_name = rs.getString("product_name");
					String description= rs.getString("description");
					String dimensions= rs.getString("dimensions");
					int price=rs.getInt("price");
					int discount_price=rs.getInt("discount_price");
					int stock_quantity=rs.getInt("stock_quantity");
					String weight= rs.getString("product_name");
					Timestamp created_at=rs.getTimestamp("created_at");
					Timestamp updated_at=rs.getTimestamp("updated_at");
					String image_url= rs.getString("image_url");

					int category_id = rs.getInt("category_id");

					product = new Product( product_id,  product_name,  description,  dimensions,  price,
							 discount_price,  stock_quantity,  weight,  created_at,  updated_at,image_url,category_id);
					list.add(product);
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
