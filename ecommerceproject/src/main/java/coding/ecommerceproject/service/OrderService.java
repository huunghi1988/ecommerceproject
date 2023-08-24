package coding.ecommerceproject.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import coding.ecommerceproject.db.util.DBUtil;
import coding.ecommerceproject.entity.Order;
import coding.ecommerceproject.entity.OrderDetail;

public class OrderService {
	private final static String CREATE_ORDER = "INSERT INTO `sql6631093`.`order` ( `user_id`, `order_date`, `total_amount`, `shipping_address`, `shipping_suburb`, `shipping_state`, `shipping_postcode`, `email`) VALUES (?,?,?,?,?,?,?,?);";
	private final static String CREATE_ORDER_DETAIL = "INSERT INTO `sql6631093`.`order_item` (`order_id`, `product_id`, `quantity`, `price`) VALUES (?, ?, ?, ?)";

	public int createNewOrder(Order order) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.makeConnection();

			ps = conn.prepareStatement(CREATE_ORDER, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, order.getUserId());
			ps.setDate(2,  new Date(System.currentTimeMillis()));
			ps.setDouble(3, order.getTotalAmount());
			ps.setString(4, order.getShippingAddress());
			ps.setString(5, order.getShippingSuburb());
			ps.setString(6, order.getShippingState());
			ps.setString(7, order.getShippingPostcode());
			ps.setString(8, order.getEmail());

			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int orderId=rs.getInt(1);
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
	
	public void createNewOrderDetail( OrderDetail orderDetail) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.makeConnection();

		
				ps = conn.prepareStatement(CREATE_ORDER_DETAIL);
				ps.setInt(1, orderDetail.getOrderId());
				ps.setInt(2, orderDetail.getProductId());
				ps.setInt(3, orderDetail.getQuantity());
				ps.setDouble(4, orderDetail.getPrice());
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

}
