package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.BusinessExceptions;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe os dados da conta.");
		System.out.print("Número: ");
		int number = sc.nextInt();
		System.out.print("Titular: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Saldo inicial: ");
		double balace = sc.nextDouble();
		System.out.print("Limite de saque: ");
		double withdrawLimit = sc.nextDouble();
		
		Account account = new Account(number, holder, balace, withdrawLimit);
		
		System.out.println();
		System.out.print("Informe uma quantia para sacar: ");
		double amount = sc.nextDouble();
		
		try {
			account.withdraw(amount);
			System.out.printf("Novo saldo: %.2f%n", account.getBalace());
		}
		catch(BusinessExceptions e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
		
}
