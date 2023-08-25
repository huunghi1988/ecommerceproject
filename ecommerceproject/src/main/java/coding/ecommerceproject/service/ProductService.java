package coding.ecommerceproject.service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coding.ecommerceproject.db.util.DBUtil;
import coding.ecommerceproject.entity.Product;

public class ProductService {

	private final String GET_PRODUCT_BY_CATEGORY_ID = "SELECT * FROM sql6631093.product join product_image on product.product_id=product_image.product_id join category on product.category_id=category.category_id where product_image.is_primary=1 and category.category_id = ?";
	private final String GET_PRODUCT_BY_PRODUCT_ID = "SELECT * FROM sql6631093.product join product_image on product.product_id=product_image.product_id join category on product.category_id=category.category_id where product_image.is_primary=1 and product.product_id = ?";
	private final String GET_ALL_PRODUCTS = "SELECT * FROM sql6631093.product join product_image on product.product_id=product_image.product_id join category on product.category_id=category.category_id where product_image.is_primary=1";
	private final String GET_DISCOUNT_PRODUCTS = "SELECT * FROM sql6631093.product join product_image on product.product_id=product_image.product_id join category on product.category_id=category.category_id where product_image.is_primary=1 and product.discount_price is not null";
	private final String GET_PRODUCTS_BY_SEARCH = "SELECT * FROM sql6631093.product join product_image on product.product_id=product_image.product_id join category on product.category_id=category.category_id where product_image.is_primary=1 and product.product_name like ?";
	private final String GET_MIN_PRICE = "SELECT MIN(price) as minPrice FROM sql6631093.product";
	private final String GET_MAX_PRICE = "SELECT MAX(price) as maxPrice FROM sql6631093.product";
	private final String GET_PRODUCTS_BY_MAXMIN = "SELECT * FROM sql6631093.product join product_image on product.product_id=product_image.product_id join category on product.category_id=category.category_id where product_image.is_primary=1 and product.price >= ? and product.price <= ?";
	private final String GET_LASTEST_10_PRODUCTS = "SELECT * FROM sql6631093.product join product_image on product.product_id=product_image.product_id join category on product.category_id=category.category_id where product_image.is_primary=1 ORDER BY created_at DESC LIMIT 10";

	public List<Product> getProductsByCategoryId(int categoryId) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product product = null;
		List<Product> list = new ArrayList<Product>();
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement(GET_PRODUCT_BY_CATEGORY_ID);

			ps.setInt(1, categoryId);

			rs = ps.executeQuery();

			while (rs.next()) {
				int productId = rs.getInt("product_id");
				String productName = rs.getString("product_name");
				String description = rs.getString("description");
				String dimensions = rs.getString("dimensions");
				double price = rs.getDouble("price");
				double discountPrice = rs.getDouble("discount_price");
				int stockQuantity = rs.getInt("stock_quantity");
				String weight = rs.getString("weight");
				String imageUrl = rs.getString("image_url");
				String categoryName = rs.getString("category_name");

				product = new Product(productId, productName, description, dimensions, price, discountPrice,
						stockQuantity, weight, imageUrl, categoryId, categoryName);
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

			ps = conn.prepareStatement(GET_PRODUCT_BY_PRODUCT_ID);

			ps.setInt(1, productId);

			rs = ps.executeQuery();

			while (rs.next()) {
				String productName = rs.getString("product_name");
				String description = rs.getString("description");
				String dimensions = rs.getString("dimensions");
				double price = rs.getDouble("price");
				double discountPrice = rs.getDouble("discount_price");
				int stockQuantity = rs.getInt("stock_quantity");
				String weight = rs.getString("weight");

				String imageUrl = rs.getString("image_url");
				int categoryId = rs.getInt("category_id");
				String categoryName = rs.getString("category_name");

				product = new Product(productId, productName, description, dimensions, price, discountPrice,
						stockQuantity, weight, imageUrl, categoryId, categoryName);
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

			ps = conn.prepareStatement(GET_ALL_PRODUCTS);

			rs = ps.executeQuery();

			while (rs.next()) {
				int productId = rs.getInt("product_id");
				String productName = rs.getString("product_name");
				String description = rs.getString("description");
				String dimensions = rs.getString("dimensions");
				double price = rs.getDouble("price");
				double discountPrice = rs.getDouble("discount_price");
				int stockQuantity = rs.getInt("stock_quantity");
				String weight = rs.getString("weight");

				String imageUrl = rs.getString("image_url");
				int categoryId = rs.getInt("category_id");
				String categoryName = rs.getString("category_name");

				product = new Product(productId, productName, description, dimensions, price, discountPrice,
						stockQuantity, weight, imageUrl, categoryId, categoryName);
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

			ps = conn.prepareStatement(GET_DISCOUNT_PRODUCTS);

			rs = ps.executeQuery();

			while (rs.next()) {
				int productId = rs.getInt("product_id");
				String productName = rs.getString("product_name");
				String description = rs.getString("description");
				String dimensions = rs.getString("dimensions");
				double price = rs.getDouble("price");
				double discountPrice = rs.getDouble("discount_price");
				int stockQuantity = rs.getInt("stock_quantity");
				String weight = rs.getString("weight");

				String imageUrl = rs.getString("image_url");
				int categoryId = rs.getInt("category_id");
				String categoryName = rs.getString("category_name");

				product = new Product(productId, productName, description, dimensions, price, discountPrice,
						stockQuantity, weight, imageUrl, categoryId, categoryName);
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

	public double getMaxPrice() throws SQLException {

		double maxPrice = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement(GET_MAX_PRICE);

			rs = ps.executeQuery();

			while (rs.next()) {
				maxPrice = rs.getDouble("maxPrice");
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

	public double getMinPrice() throws SQLException {

		double minPrice = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement(GET_MIN_PRICE);

			rs = ps.executeQuery();

			while (rs.next()) {
				minPrice = rs.getDouble("minPrice");
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
	
	public void updateStockQuanity(int productId ,int quantity) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement("UPDATE `sql6631093`.`product` SET `stock_quantity` = ? WHERE `product_id` = ?");
			ps.setInt(1, quantity);

			ps.setInt(2, productId);

			ps.executeUpdate();
			
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
	}

	public List<Product> getProductsBySearch(String keyword) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product product = null;
		List<Product> list = new ArrayList<Product>();
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement(GET_PRODUCTS_BY_SEARCH);

			ps.setString(1, "%" + keyword + "%");

			rs = ps.executeQuery();

			while (rs.next()) {
				int productId = rs.getInt("product_id");
				String productName = rs.getString("product_name");
				String description = rs.getString("description");
				String dimensions = rs.getString("dimensions");
				double price = rs.getDouble("price");
				double discountPrice = rs.getDouble("discount_price");
				int stockQuantity = rs.getInt("stock_quantity");
				String weight = rs.getString("weight");

				String imageUrl = rs.getString("image_url");
				int categoryId = rs.getInt("category_id");
				String categoryName = rs.getString("category_name");

				product = new Product(productId, productName, description, dimensions, price, discountPrice,
						stockQuantity, weight, imageUrl, categoryId, categoryName);
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

	public List<Product> getProductsByMaxMin(String maxValue, String minValue) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product product = null;
		List<Product> list = new ArrayList<Product>();
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement(GET_PRODUCTS_BY_MAXMIN);

			ps.setDouble(1, getMinPrice());
			ps.setDouble(2, getMaxPrice());

			rs = ps.executeQuery();

			while (rs.next()) {
				int productId = rs.getInt("product_id");
				String productName = rs.getString("product_name");
				String description = rs.getString("description");
				String dimensions = rs.getString("dimensions");
				double price = rs.getDouble("price");
				double discountPrice = rs.getDouble("discount_price");
				int stockQuantity = rs.getInt("stock_quantity");
				String weight = rs.getString("weight");

				String imageUrl = rs.getString("image_url");
				int categoryId = rs.getInt("category_id");
				String categoryName = rs.getString("category_name");

				product = new Product(productId, productName, description, dimensions, price, discountPrice,
						stockQuantity, weight, imageUrl, categoryId, categoryName);
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
	
	public List<Product> getLastestProduct() throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product product = null;
		List<Product> list = new ArrayList<Product>();
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement(GET_LASTEST_10_PRODUCTS);

			rs = ps.executeQuery();

			while (rs.next()) {
				int productId = rs.getInt("product_id");
				String productName = rs.getString("product_name");
				String description = rs.getString("description");
				String dimensions = rs.getString("dimensions");
				double price = rs.getDouble("price");
				double discountPrice = rs.getDouble("discount_price");
				int stockQuantity = rs.getInt("stock_quantity");
				String weight = rs.getString("weight");

				String imageUrl = rs.getString("image_url");
				int categoryId = rs.getInt("category_id");
				String categoryName = rs.getString("category_name");

				product = new Product(productId, productName, description, dimensions, price, discountPrice,
						stockQuantity, weight, imageUrl, categoryId, categoryName);
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
