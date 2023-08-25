package coding.ecommerceproject.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import coding.ecommerceproject.db.util.DBUtil;
import coding.ecommerceproject.entity.Order;
import coding.ecommerceproject.entity.OrderDetail;
import coding.ecommerceproject.entity.OrderDetailInFull;
import coding.ecommerceproject.entity.OrderInFull;

public class OrderService {
	private final static String CREATE_ORDER = "INSERT INTO `sql6631093`.`order` ( `user_id`, `order_date`, `total_amount`, `shipping_address`, `shipping_suburb`, `shipping_state`, `shipping_postcode`, `email`) VALUES (?,?,?,?,?,?,?,?);";
	private final static String CREATE_ORDER_DETAIL = "INSERT INTO `sql6631093`.`order_item` (`order_id`, `product_id`,`product_name`, `quantity`, `price`) VALUES (?, ?, ?, ?,?)";

	public int createNewOrder(Order order) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement(CREATE_ORDER, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, order.getUserId());
			ps.setDate(2, new Date(System.currentTimeMillis()));
			ps.setDouble(3, order.getTotalAmount());
			ps.setString(4, order.getShippingAddress());
			ps.setString(5, order.getShippingSuburb());
			ps.setString(6, order.getShippingState());
			ps.setString(7, order.getShippingPostcode());
			ps.setString(8, order.getEmail());

			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int orderId = rs.getInt(1);
				return orderId;
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
		return 0;
	}

	public void createNewOrderDetail(OrderDetail orderDetail) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement(CREATE_ORDER_DETAIL);
			ps.setInt(1, orderDetail.getOrderId());
			ps.setInt(2, orderDetail.getProductId());
			ps.setString(3, orderDetail.getProductName());
			ps.setInt(4, orderDetail.getQuantity());
			ps.setDouble(5, orderDetail.getPrice());
			ps.executeUpdate();

			System.out.println(ps);
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

	public List<OrderInFull> getOrdersById(int userId) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		OrderInFull order = null;
		List<OrderInFull> list = new ArrayList<OrderInFull>();
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement("SELECT * FROM sql6631093.order where user_id= ?");
			ps.setInt(1, userId);

			rs = ps.executeQuery();
			while (rs.next()) {
				int orderId = rs.getInt("order_id");
				Date orderDate = rs.getDate("order_date");
				double totalAmount = rs.getInt("total_amount");
				String address = rs.getString("shipping_address");
				String suburb = rs.getString("shipping_suburb");
				String state = rs.getString("shipping_state");
				String postcode = rs.getString("shipping_postcode");
				String paymentMethod = rs.getString("payment_method");

				String email = rs.getString("email");
				boolean paymentStatus = rs.getBoolean("payment_status");
				boolean fullfillmentStatus = rs.getBoolean("fulfillment_status");

				order = new OrderInFull(orderId, userId, orderDate, totalAmount, address, suburb, state, postcode,
						paymentMethod, email, paymentStatus, fullfillmentStatus);
				list.add(order);
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

	public List<OrderDetailInFull> getOrderDetailById(int orderId) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		OrderDetailInFull order = null;
		List<OrderDetailInFull> list = new ArrayList<OrderDetailInFull>();
		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement("SELECT * FROM sql6631093.order_item where order_id= ?");
			ps.setInt(1, orderId);

			rs = ps.executeQuery();
			while (rs.next()) {
				int oderItemId = rs.getInt("order_item_id");
				int productId = rs.getInt("product_id");
				int quantity = rs.getInt("quantity");
				String productName = rs.getString("product_name");
				double price = rs.getDouble("price");

				order = new OrderDetailInFull(oderItemId, orderId, productId, productName, quantity, price);
				list.add(order);
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
