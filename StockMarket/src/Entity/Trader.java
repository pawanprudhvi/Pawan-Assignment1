package Entity;

import java.util.HashMap;
import java.util.Map;

import Market.MarketOperations;
import Exceptions.InsufficientMarketSharesException;
import Exceptions.InsufficientSharesException;
import Exceptions.StockNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class Trader extends Thread {
    private static int idCounter = 1;
    private int traderId;
    private String traderName;
    private Map<String, Integer> portfolio = new HashMap<>();

    private MarketOperations market;
    private boolean isBuying;
    private int stockId;
    private String stockName;
    private int qty;
    public Trader(String traderName,MarketOperations market,boolean isBuying,int stockId,int qty, String stockName) {
        this.traderId = idCounter++;
        this.traderName = traderName;
        this.market = market;
        this.isBuying = isBuying;
        this.stockName = stockName;
        this.qty=qty;
        this.stockId=stockId;
    }

    @Override
    public void run()  {
        try {
            if(isBuying) {
            	try {
                market.buyStock(this,stockId,qty);
            	}
            	catch(InsufficientMarketSharesException e) {
            		System.out.println("No share to buy");
            	}
            	catch(StockNotFoundException e) {
            		System.out.println("Cannot find stock Stock ID: "+stockId);
            	}
            }
            else {
            	try {
                market.sellStock(this,stockName,qty);
            	}
            	catch(InsufficientSharesException e) {
            		System.out.println("Selling quantity is more than available quantity");
            	}
            }
        } catch (IllegalArgumentException e) {
            System.out.println(" ERROR: "+e.getMessage());
        }
    }

    public int getTraderId() {
        return traderId;
    }

    public String getTraderName() {
        return traderName;
    }

    public Map<String, Integer> getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Map<String,Integer> portfolio) {
        this.portfolio = portfolio;
    }
}