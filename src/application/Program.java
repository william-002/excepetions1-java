package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number:");
			int n = scan.nextInt();

			System.out.println("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(scan.next());

			System.out.println("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(scan.next());

			Reservation reservation = new Reservation(n, checkIn, checkOut);

			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation:");

			System.out.println("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(scan.next());

			System.out.println("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(scan.next());

			reservation.updateDates(checkIn, checkOut);
		} 
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		scan.close();

	}

}
