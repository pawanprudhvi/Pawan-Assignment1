package Market;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Entity.Stocks;
import Entity.Trader;
import Exceptions.InsufficientSharesException;

public class StockMarket {
	public static void main(String args[]) throws InterruptedException {
		Scanner sc=new Scanner(System.in);
		List<Trader> traders = new ArrayList<>();
		MarketOperations market=new MarketOperations();
		market.addStock(new Stocks(1,"Tech Mahindra",10.00,10));
		market.addStock(new Stocks(2,"TCS",13.00,13));
		
		String stockName="";
		int stockId=0;
		int qty=0;
		String name="";
		
		for(int i=0;i<3;i++) {
		  System.out.println("Enter your name");
		  name=sc.nextLine();
		  System.out.println("Do you want to buy stocks(Yes/No)");
		  String buy=sc.nextLine();
		  market.showStocks();
		  boolean buyingOrNot=buy.equals("Yes");
		  if(buyingOrNot) {
			market.showStocks();
			System.out.println("Enter a stock Id to buy");
			stockId=sc.nextInt();
			System.out.println("Enter name of stocks to buy");
			sc.nextLine();
			stockName=sc.nextLine();
			System.out.println("Enter number of stocks to buy");
			qty=sc.nextInt();
			}
		  else {
			System.out.println("Enter the stock ID you want to sell");
			stockName = sc.nextLine();
			System.out.println("Enter the stock name you want to sell");
			stockName = sc.nextLine();
			System.out.println("Enter the quantity you want to sell");
			qty = sc.nextInt();               
			}
			Trader trader=new Trader(name,market,buyingOrNot,stockId,qty,stockName);
			traders.add(trader);
			sc.nextLine();
            if(!buyingOrNot) {
               trader.getPortfolio().put(stockName,qty);
            }
	     }
        for(Trader trader:traders) {
            trader.start();
        }
		for(Trader trader:traders) {
			trader.join();
		}
   }
}
