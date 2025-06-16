package Market;

import java.util.HashMap;

import Entity.Stocks;
import Entity.Trader;
import Exceptions.InsufficientSharesException;

public class MarketOperations implements marketInterface {
	HashMap<Integer,Stocks> listOfStocks=new HashMap<>();

	public MarketOperations() {
		super();
	}

	@Override
	public synchronized void buyStock(Trader trader,int stockId,int qty) throws InsufficientSharesException {
		Stocks buyingStock=listOfStocks.get(stockId);
		if(buyingStock.getAvailableShares()>=qty) {
			trader.getPortfolio().put(buyingStock.getStockName(),trader.getPortfolio().getOrDefault(buyingStock.getStockName(),0)+qty);
			System.out.println("Stocks successfully bought");
		}
		else {
			throw new InsufficientSharesException("Selling quantity is more than available Quantity.");
		}
	}

	@Override
	public synchronized void sellStock(Trader trader,Stocks stock,int qty) throws InsufficientSharesException {
		int availableStocks = trader.getPortfolio().getOrDefault(stock.getStockName(), 0);
		Stocks sellingStock=listOfStocks.get(stock.getStockId());
		if(availableStocks>=qty&&sellingStock.getAvailableShares()>=qty) {
			trader.getPortfolio().put(stock.getStockName(),trader.getPortfolio().get(stock.getStockName())-qty);
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
