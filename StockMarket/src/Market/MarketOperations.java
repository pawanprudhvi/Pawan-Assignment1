package Market;

import java.util.HashMap;

import Entity.Stocks;
import Entity.Trader;
import Exceptions.InsufficientMarketSharesException;
import Exceptions.InsufficientSharesException;
import Exceptions.StockNotFoundException;

public class MarketOperations implements marketInterface {
	HashMap<Integer,Stocks> listOfStocks=new HashMap<>();

	public MarketOperations() {
		super();
	}

	@Override
	public synchronized void buyStock(Trader trader,int stockId,int qty) throws InsufficientMarketSharesException,StockNotFoundException {
		Stocks buyingStock=listOfStocks.get(stockId);
		if(buyingStock==null) {
			throw new StockNotFoundException("No Stock found for this Stock ID");
		}
		System.out.println(buyingStock);
		if(buyingStock.getAvailableShares()>=qty) {
			trader.getPortfolio().put(buyingStock.getStockName(),trader.getPortfolio().getOrDefault(buyingStock.getStockName(),0)+qty);
			buyingStock.setAvailableShares(buyingStock.getAvailableShares()-qty);
			System.out.println("Congrats "+trader.getTraderName()+"!stock successfully bought");
		}
		else {
			throw new InsufficientMarketSharesException("No shares to buy");
		}
	}

	@Override
	public synchronized void sellStock(Trader trader,String stockName,int qty) throws InsufficientSharesException {
		int availableStocks = trader.getPortfolio().getOrDefault(stockName,0);
		System.out.println(availableStocks);
		if(availableStocks>=qty) {
			trader.getPortfolio().put(stockName,trader.getPortfolio().get(stockName)-qty);
			System.out.println("Stocks successfully sold");
		}
		else {
			throw new InsufficientSharesException("Selling quantity is more than available Quantity.");
		}
	}
	
	@Override
	public void addStock(Stocks stock) {
		listOfStocks.put(stock.getStockId(),stock);	
	}
	
	public void showStocks() {
		System.out.println("Available stocks \n");
		for(Stocks stock : listOfStocks.values()) {
			System.out.println("Stock Id:         "+stock.getStockId()+" \n"+
		                       "Stock Name:       "+stock.getStockName()+" \n"+
					           "Price Per Stock:  "+stock.getPricePerShare()+" \n"+
		                       "Available Shares: "+stock.getAvailableShares()+" \n");
		}
	}
}
