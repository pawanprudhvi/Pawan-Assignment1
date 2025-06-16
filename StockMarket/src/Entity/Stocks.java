package Entity;

public class Stocks {
	
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public double getPricePerShare() {
		return pricePerShare;
	}
	public void setPricePerShare(double pricePerShare) {
		this.pricePerShare = pricePerShare;
	}
	public int getAvailableShares() {
		return availableShares;
	}
	public void setAvailableShares(int availableShares) {
		this.availableShares = availableShares;
	}
	
	private int stockId;
	private String stockName;
	private double pricePerShare;
	private int availableShares;
	
	
	public Stocks(int stockId, String stockName, double pricePerShare, int availableShares) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.pricePerShare = pricePerShare;
		this.availableShares = availableShares;
	}
}
