package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private ItemListDAO itemListDAO = new ItemListDAO();
	private List<ItemInfoDTO> itemList = new ArrayList<ItemInfoDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException{
		if(!session.containsKey("login_user_id")) {
			return ERROR;
		}
		itemList = itemListDAO.getItemListInfo();

//		if(deleteFlg == null) {
//			String item_transaction_id = session.get("id").toString();
//			String user_master_id = session.get("login_user_id").toString();
//			itemList = itemListDAO.getItemListInfo();
//		}else if(deleteFlg.equals("1")) {
//			delete();
//		}
		String result = SUCCESS;
		return result;
	}

	public void delete() throws SQLException {
		String item_transaction_id = session.get("id").toString();
		String user_master_id = session.get("login_user_id").toString();

		int res = itemListDAO.ItemListDelete(item_transaction_id, user_master_id);
		if(res > 0) {
			itemList = null;
			setMessage("商品情報を正しく削除しました。");
		}else if(res == 0) {
			setMessage("商品情報の削除に失敗しました。");
		}
	}
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg=deleteFlg;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	public List<ItemInfoDTO> getItemList(){
		return this.itemList;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message=message;
	}
}
