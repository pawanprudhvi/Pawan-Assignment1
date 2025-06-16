package Market;

import java.util.Scanner;

import Entity.Stocks;
import Entity.Trader;
import Exceptions.InsufficientSharesException;

public class StockMarket {
	public static void main(String args[]) {
		System.out.println("Enter your name");
		Scanner sc=new Scanner(System.in);
		String name=sc.nextLine();
		Trader pawan=new Trader(name);
		MarketOperations market=new MarketOperations();
		market.addStock(new Stocks(1,"Tech Mahindra",10.00,10));
		market.showStocks();
		
		System.out.println("Enter a stock Id to buy \n");
		market.showStocks();
		int stockId=sc.nextInt();
		System.out.println("Enter number of stocks to buy \n");
		int qty=sc.nextInt();
		try {
		market.buyStock(pawan, stockId, qty);		
		}
		catch(InsufficientSharesException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Enter the stock Id(Stock) you want to sell \n");
		System.out.println(pawan.getPortfolio());
		int sellingStockId=sc.nextInt();
		System.out.println("Enter the stock quantity you want to sell");
		int sellQty=sc.nextInt();
		try {
		market.sellStock(pawan, market.listOfStocks.get(sellingStockId), sellQty);
		}
		catch(InsufficientSharesException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
