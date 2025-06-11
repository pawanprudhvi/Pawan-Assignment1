package BankEntity;

import java.util.ArrayList;
import java.util.List;

import Branch.Branch;

public class Bank {
	String bankName;
	List<Branch> branches;
	
	public Bank(String bankName)
	{
		this.bankName=bankName;
		branches=new ArrayList<>();
	}
	
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void addNewBranch(Branch branch)
	{
		branches.add(branch);
	}
	
	public void showAllBranches()
	{
		for(Branch branch:branches) {
			System.out.println(branch.getBranchName()+" \n");
		}
	}
}
