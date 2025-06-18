package Market;

import Entity.Stocks;
import Entity.Trader;
import Exceptions.InsufficientMarketSharesException;
import Exceptions.InsufficientSharesException;
import Exceptions.StockNotFoundException;

public interface marketInterface {
	public void buyStock(Trader trader,int stockId,int qty) throws InsufficientMarketSharesException,StockNotFoundException;
	public void sellStock(Trader trader,String stockName,int qty) throws InsufficientSharesException;
	public void addStock(Stocks stock);
}
