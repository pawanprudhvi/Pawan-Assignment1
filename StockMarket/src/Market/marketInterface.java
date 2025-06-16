package Market;

import Entity.Stocks;
import Entity.Trader;
import Exceptions.InsufficientSharesException;

public interface marketInterface {
	public void buyStock(Trader trader,int stockId,int qty) throws InsufficientSharesException;
	public void sellStock(Trader trader,Stocks stock,int qty) throws InsufficientSharesException;
	public void addStock(Stocks stock);
}
