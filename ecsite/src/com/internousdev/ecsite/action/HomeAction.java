package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;

	public String execute() { //executeメソッドを定義してる
		String result = "login"; //resultに"login"を代入している。
		if(session.containsKey("login_user_id")) {  //「もし、sessionの中に"login_user_id"というキーがあれば」というif文で、containsKeyメソッドを使い、キーの有無を調べている。
													//ここでログイン判定をしていて、1度ログインしている場合は認証画面に遷移させることなく、商品画面に遷移させる。
			BuyItemDAO buyItemDAO = new BuyItemDAO(); //BuyItemDAOクラスをインスタンス化
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo(); //buyItemDAOメソッドの"getBuyItemInfo"を値取得している。
			session.put("id", buyItemDTO.getId()); //Map型のため、この形式で、keyに"id",valueに"buyItemDTO.getId()"を設定している。
			session.put("buyItem_name", buyItemDTO.getItemName()); //keyに"buyItem_name",valueに" buyItemDTO.getItemName()"を設定している。
			session.put("buyItem_price", buyItemDTO.getItemPrice()); //keyに"buyItem_price",valueに" buyItemDTO.getItemPrice()"を設定している。
			result = SUCCESS; //resultにSUCCESSを代入
		}
		return result; //ログイン済の場合は"SUCCESS"を返し、未だの場合は"login"返す。
	}

	public Map<String, Object> getSession(){
		return this.session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
}
