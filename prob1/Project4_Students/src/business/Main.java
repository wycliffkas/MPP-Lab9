package prob1.Project4_Students.src.business;

import java.util.*;
import java.util.stream.Collectors;

import business.Book;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public class Main {

	public static void main(String[] args) {
		System.out.println(allWhoseZipContains3());
		System.out.println(allHavingOverdueBook());
		System.out.println(allHavingMultipleAuthors());

	}
	//Returns a list of all ids of LibraryMembers whose zipcode contains the digit 3
	public static List<String> allWhoseZipContains3() {
		DataAccess da = (DataAccess) new DataAccessFacade();
		return da.readMemberMap().values().stream()
				.filter(member -> member.getAddress().getZip().contains("3"))
				.collect(Collectors.toList());
		
	}
	//Returns a list of all ids of  LibraryMembers that have an overdue book
	public static List<String> allHavingOverdueBook() {
		DataAccess da = (DataAccess) new DataAccessFacade();
		return da.readMemberMap().values().stream()
				.filter(member -> member.getCheckoutRecord().getCheckoutEntries().stream()
						.anyMatch(entry -> entry.isOverdue()))
				.collect(Collectors.toList());


	}
	
	//Returns a list of all isbns of  Books that have multiple authors
	public static List<Book> allHavingMultipleAuthors() {
		DataAccess da = (DataAccess) new DataAccessFacade();
		return da.readBooksMap().values().stream()
				.filter(book -> book.getAuthors().size() > 1)
				.collect(Collectors.toList());
		
		}

}
