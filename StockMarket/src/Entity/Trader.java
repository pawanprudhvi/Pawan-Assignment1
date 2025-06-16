package Entity;

import java.util.HashMap;
import java.util.Map;

public class Trader {
	private static int traderId;
	private String traderName;
	private Map<String,Integer> portfolio=new HashMap<>();
	public Trader(int traderId, String traderName, Map<String, Integer> portfolio) {
		super();
		this.traderId = traderId;
		this.traderName = traderName;
		this.portfolio = portfolio;
	}
	public Trader(String traderName) {
		this.traderName=traderName;
		this.traderId=traderId++;
	}
	public int getTraderId() {
		return traderId;
	}
	public void setTraderId(int traderId) {
		this.traderId = traderId;
	}
	public String getTraderName() {
		return traderName;
	}
	public void setTraderName(String traderName) {
		this.traderName = traderName;
	}
	public Map<String, Integer> getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(Map<String, Integer> portfolio) {
		this.portfolio = portfolio;
	}
	public Trader(int traderId, String traderName) {
		super();
		this.traderId = traderId;
		this.traderName = traderName;
	}
}
