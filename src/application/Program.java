package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exeption.DomainExeption;

public class Program {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try{
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy):");
			Date checkout = sdf.parse(sc.next());
		
			Reservation resservation = new Reservation(number, checkin, checkout);
			System.out.println("Reservation: " + resservation);
			
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy):");
			checkout = sdf.parse(sc.next());
			
	
			resservation.updateDates(checkin, checkout);
			System.out.println("Reservation: " + resservation);
		}
		catch(ParseException e){
			System.out.println("Ivalid date format:");
		}
		
		catch(DomainExeption e){
			System.out.println("Error in reservation: " + e.getMessage());
		}
		
		catch(RuntimeException e){
			System.out.println("unexpacted error!");
		}
		
		sc.close();
	}
}