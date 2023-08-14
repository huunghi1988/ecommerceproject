package coding.ecommerceproject.service;

import java.math.BigDecimal;
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

			ps = conn.prepareStatement(
					"SELECT * FROM sql6631093.Products join ProductImages on Products.productId = ProductImages.productId join ProductCategory on Products.productId = ProductCategory.productId join Categories on ProductCategory.categoryId= Categories.categoryId where ProductImages.isPrimary=1 and Categories.categoryId = ?");

			ps.setInt(1, categoryId);

			rs = ps.executeQuery();

			while (rs.next()) {
				int productId = rs.getInt("productId");
				String productName = rs.getString("productName");
				String description = rs.getString("description");
				String dimensions = rs.getString("dimensions");
				BigDecimal price = rs.getBigDecimal("price");
				BigDecimal discountPrice = rs.getBigDecimal("discountPrice");
				int stockQuantity = rs.getInt("stockQuantity");
				String weight = rs.getString("weight");
				Timestamp createdAt = rs.getTimestamp("createdAt");
				Timestamp updatedAt = rs.getTimestamp("updatedAt");
				String imageUrl = rs.getString("imageUrl");
				String categoryName = rs.getString("categoryName");

				product = new Product(productId, productName, description, dimensions, price, discountPrice,
						stockQuantity, weight, createdAt, updatedAt, imageUrl, categoryId, categoryName);
				list.add(product);
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

	public Product getProductsByProductId(int productId) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product product = null;
		List<Product> list = new ArrayList<Product>();
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement("SELECT * FROM sql6631093.Products \n"
					+ "join ProductImages on Products.productId = ProductImages.productId \n"
					+ "join ProductCategory on Products.productId = ProductCategory.productId \n"
					+ "join Categories on ProductCategory.categoryId= Categories.categoryId \n"
					+ "where ProductImages.isPrimary=1 and ProductCategory.productId = ?");

			ps.setInt(1, productId);

			rs = ps.executeQuery();

			while (rs.next()) {
				String productName = rs.getString("productName");
				String description = rs.getString("description");
				String dimensions = rs.getString("dimensions");
				BigDecimal price = rs.getBigDecimal("price");
				BigDecimal discountPrice = rs.getBigDecimal("discountPrice");
				int stockQuantity = rs.getInt("stockQuantity");
				String weight = rs.getString("weight");
				Timestamp createdAt = rs.getTimestamp("createdAt");
				Timestamp updatedAt = rs.getTimestamp("updatedAt");
				String imageUrl = rs.getString("imageUrl");
				int categoryId = rs.getInt("categoryId");
				String categoryName = rs.getString("categoryName");

				product = new Product(productId, productName, description, dimensions, price, discountPrice,
						stockQuantity, weight, createdAt, updatedAt, imageUrl, categoryId, categoryName);
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
		return product;
	}

	public List<Product> getAllProducts() throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product product = null;
		List<Product> list = new ArrayList<Product>();
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement(
					"SELECT * FROM sql6631093.Products join ProductImages on Products.productId = ProductImages.productId join ProductCategory on Products.productId = ProductCategory.productId join Categories on ProductCategory.categoryId= Categories.categoryId where ProductImages.isPrimary=1");

			rs = ps.executeQuery();

			while (rs.next()) {
				int productId = rs.getInt("productId");
				String productName = rs.getString("productName");
				String description = rs.getString("description");
				String dimensions = rs.getString("dimensions");
				BigDecimal price = rs.getBigDecimal("price");
				BigDecimal discountPrice = rs.getBigDecimal("discountPrice");
				int stockQuantity = rs.getInt("stockQuantity");
				String weight = rs.getString("weight");
				Timestamp createdAt = rs.getTimestamp("createdAt");
				Timestamp updatedAt = rs.getTimestamp("updatedAt");
				String imageUrl = rs.getString("imageUrl");
				int categoryId = rs.getInt("categoryId");
				String categoryName = rs.getString("categoryName");

				product = new Product(productId, productName, description, dimensions, price, discountPrice,
						stockQuantity, weight, createdAt, updatedAt, imageUrl, categoryId, categoryName);
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
	public List<Product> getDiscountProducts() throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product product = null;
		List<Product> list = new ArrayList<Product>();
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement(
					"SELECT * FROM sql6631093.Products join ProductImages on Products.productId = ProductImages.productId join ProductCategory on Products.productId = ProductCategory.productId join Categories on ProductCategory.categoryId= Categories.categoryId where ProductImages.isPrimary=1 and Products.discountPrice is not null");

			rs = ps.executeQuery();

			while (rs.next()) {
				int productId = rs.getInt("productId");
				String productName = rs.getString("productName");
				String description = rs.getString("description");
				String dimensions = rs.getString("dimensions");
				BigDecimal price = rs.getBigDecimal("price");
				BigDecimal discountPrice = rs.getBigDecimal("discountPrice");
				int stockQuantity = rs.getInt("stockQuantity");
				String weight = rs.getString("weight");
				Timestamp createdAt = rs.getTimestamp("createdAt");
				Timestamp updatedAt = rs.getTimestamp("updatedAt");
				String imageUrl = rs.getString("imageUrl");
				int categoryId = rs.getInt("categoryId");
				String categoryName = rs.getString("categoryName");

				product = new Product(productId, productName, description, dimensions, price, discountPrice,
						stockQuantity, weight, createdAt, updatedAt, imageUrl, categoryId, categoryName);
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

	public BigDecimal getMaxPrice() throws SQLException {

		BigDecimal maxPrice = null ;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement("SELECT MAX(price) as maxPrice FROM sql6631093.Products ");

			rs = ps.executeQuery();

			while (rs.next()) {
				maxPrice = rs.getBigDecimal("maxPrice");
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
		return maxPrice;
	}

	public BigDecimal getMinPrice() throws SQLException {

		BigDecimal minPrice = null ;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement("SELECT MIN(price) as minPrice FROM sql6631093.Products ");

			rs = ps.executeQuery();

			while (rs.next()) {
				minPrice = rs.getBigDecimal("minPrice");
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
		return minPrice;
	}

	public List<Product> getProductsBySearch(String keyword) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product product = null;
		List<Product> list = new ArrayList<Product>();
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement(
					"SELECT * FROM sql6631093.Products join ProductImages on Products.productId = ProductImages.productId join ProductCategory on Products.productId = ProductCategory.productId join Categories on ProductCategory.categoryId= Categories.categoryId  where ProductImages.isPrimary=1 and Products.productName like ?");

			ps.setString(1, "%" + keyword + "%");

			rs = ps.executeQuery();

			while (rs.next()) {
				int productId = rs.getInt("productId");
				String productName = rs.getString("productName");
				String description = rs.getString("description");
				String dimensions = rs.getString("dimensions");
				BigDecimal price = rs.getBigDecimal("price");
				BigDecimal discountPrice = rs.getBigDecimal("discountPrice");
				int stockQuantity = rs.getInt("stockQuantity");
				String weight = rs.getString("weight");
				Timestamp createdAt = rs.getTimestamp("createdAt");
				Timestamp updatedAt = rs.getTimestamp("updatedAt");
				String imageUrl = rs.getString("imageUrl");
				int categoryId = rs.getInt("categoryId");
				String categoryName = rs.getString("categoryName");

				product = new Product(productId, productName, description, dimensions, price, discountPrice,
						stockQuantity, weight, createdAt, updatedAt, imageUrl, categoryId, categoryName);
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
	public List<Product> getProductsByMaxMin(String maxValue,String minValue) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product product = null;
		List<Product> list = new ArrayList<Product>();
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement(
					"SELECT * FROM sql6631093.Products join ProductImages on Products.productId = ProductImages.productId join ProductCategory on Products.productId = ProductCategory.productId join Categories on ProductCategory.categoryId= Categories.categoryId  where ProductImages.isPrimary=1 and Products.price >= ? and Products.price <= ?");

			ps.setBigDecimal(1, getMinPrice());
			ps.setBigDecimal(1, getMaxPrice());

			rs = ps.executeQuery();

			while (rs.next()) {
				int productId = rs.getInt("productId");
				String productName = rs.getString("productName");
				String description = rs.getString("description");
				String dimensions = rs.getString("dimensions");
				BigDecimal price = rs.getBigDecimal("price");
				BigDecimal discountPrice = rs.getBigDecimal("discountPrice");
				int stockQuantity = rs.getInt("stockQuantity");
				String weight = rs.getString("weight");
				Timestamp createdAt = rs.getTimestamp("createdAt");
				Timestamp updatedAt = rs.getTimestamp("updatedAt");
				String imageUrl = rs.getString("imageUrl");
				int categoryId = rs.getInt("categoryId");
				String categoryName = rs.getString("categoryName");

				product = new Product(productId, productName, description, dimensions, price, discountPrice,
						stockQuantity, weight, createdAt, updatedAt, imageUrl, categoryId, categoryName);
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
