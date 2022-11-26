package entities;

import exceptions.BusinessExceptions;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balace;
	private Double withdrawLimit;
	
	public Account() {
	}

	public Account(Integer number, String holder, Double balace, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balace = balace;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalace() {
		return balace;
	}

	public void setBalace(Double balace) {
		this.balace = balace;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(double amount) {
		balace += amount;
	}
	
	public void withdraw(double amount) {
		validateWithdraw(amount);
		balace -= amount;
	}
	
	private void validateWithdraw(double amount) {
		if(amount > getWithdrawLimit()) {
			throw new BusinessExceptions("Erro de saque: A quantia excede o limite de saque");
		}
		if(amount > getBalace()) {
			throw new BusinessExceptions("Error de saque: Saldo insuficiente");
		}
		
		
	}

}
