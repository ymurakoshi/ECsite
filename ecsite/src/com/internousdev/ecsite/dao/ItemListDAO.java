package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection con = dbConnector.getConnection();

	public List<ItemInfoDTO> getItemListInfo() throws SQLException{
		List<ItemInfoDTO> itemInfoDTO = new ArrayList<ItemInfoDTO>();
		String sql = "SELECT * FROM item_info_transaction";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, item_transaction_id);
//			ps.setString(2, user_master_id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				ItemInfoDTO dto = new ItemInfoDTO();
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemStock(rs.getString("item_stock"));
				dto.setInsert_date(rs.getString("insert_date"));
				itemInfoDTO.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return itemInfoDTO;
	}

	public int ItemListDelete(String item_transaction_id, String user_master_id) throws SQLException{
		String sql = "DELETE FROM item_info_transaction";

		PreparedStatement ps;
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return result;

	}

}
