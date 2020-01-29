package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private String loginUserId; //アクセス修飾子をprivateにして、"loginUserId"というString型の変数を定義している
	private String loginPassword; //同様に、"loginPassword"というString型の変数を定義している
	private Map<String, Object> session; //同様に、Map型の"session"を定義している
	private LoginDAO loginDAO = new LoginDAO(); //LoginDAO()をインスタンス化して、loginDAOに代入
	private LoginDTO loginDTO = new LoginDTO(); //LoginDTO()をインスタンス化して、loginDTOに代入
	private BuyItemDAO buyItemDAO = new BuyItemDAO(); //BuyItemDAO()をインスタンス化して、buyItemDAOに代入

	public String execute() {
		String result = ERROR; //メソッドの戻り値「result」を定義し、初期値として、ERRORを代入
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword); //loginDAOクラスのgetLoginUserInfoメソッドに引数(loginUserId, loginPassword)を渡し呼び出している
		session.put("loginUser", loginDTO); //keyに"loginUser"を、valueに"loginDTO"を、sessionに格納
		if(((LoginDTO) session.get("loginUser")).getLoginFlg()) { //「もし、loginDAOで入力された物がDBと参照して合っていたら」というif文！
			result = SUCCESS;
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();

			session.put("login_user_id", loginDTO.getLoginId());
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());

			return result;
		}
		return result;
	}
	public String getLoginUserId(){
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId=loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword=loginPassword;
	}

	public Map<String, Object> getSession(){
		return this.session;
	}

	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
}
