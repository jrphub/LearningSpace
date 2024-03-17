package com.java8.in28minutes.java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.min;

@Data
@AllArgsConstructor
class Movie {

	private String name;
	private double reviews;
	private int budgetInDollar;
	private float rating;
	private String genre;

}
public class FP04Comparator {

	public static void main(String[] args) {
		List<Movie> movies = List.of(
			new Movie("DDLJ", 800000d, 50000, 9.2f, "drama"),
			new Movie("Roza", 10000d, 10000, 9.1f, "action"),
			new Movie("Jab We Met", 50000d, 100000, 9.3f, "drama"),
			new Movie("Rang de basanti", 300000d, 200000, 9.2f, "patriotic"),
			new Movie("Bombay", 1000d, 50000, 9.4f, "romance"),
			new Movie("Andhadhun", 30000d, 3000, 9.5f, "thriller")
		);


		System.out.println("Movies : " + movies);

		List<Movie> sortedByRatingMovieList = movies.stream()
			.sorted(Comparator.comparing(Movie::getRating).reversed())
			.collect(Collectors.toList());
		System.out.println("Sorted by Rating : " + sortedByRatingMovieList);

		//select top 3 rating movies
		List<Movie> top3RatingMovies = movies.stream()
			.sorted(Comparator.comparing(Movie::getRating).reversed())
			.limit(3)
			.collect(Collectors.toList());
		System.out.println("Top 3 rating movies :" + top3RatingMovies);

		//2nd best movies by reviews
		List<Movie> SecondBestByReview = movies.stream()
			.sorted(Comparator.comparing(Movie::getReviews).reversed())
			.skip(1)
			.limit(1)
			.collect(Collectors.toList());
		System.out.println("2nd best movie by review : " + SecondBestByReview);

		// check till you get a 9.3 rating movie
		List<Movie> takeTill93 = movies.stream().takeWhile(x -> x.getRating() < 9.3f).collect(Collectors.toList());
		System.out.println("Taking movies till we get 9.3 rating :" + takeTill93);

		// drop till we get a 9.3 rating movie, then show the rest
		List<Movie> dropTill93 = movies.stream().dropWhile(x -> x.getRating() < 9.3f).collect(Collectors.toList());
		System.out.println("Dropping movies till we get a 9.3 rating movie :" + dropTill93);

		// max rating
		Optional<Movie> maxRatedMovieOptional = movies.stream()
			.max(Comparator.comparing(Movie::getRating));
		System.out.println("Max rated movie : " + maxRatedMovieOptional.get());

		// min rating
		Optional<Movie> minRatedMovieOptional = movies.stream()
			.min(Comparator.comparing(Movie::getRating));
		System.out.println("Min rated movie : " + minRatedMovieOptional.get());

		//find first movie which has 100000 budget in dollar
		Movie firstMovieToCross100000 = movies.stream().sorted(Comparator.comparing(Movie::getBudgetInDollar))
			.filter(x -> x.getBudgetInDollar() > 100000)
			.findFirst()
			.orElse(movies.get(0));

		System.out.println("First movie to cross 100000 dollar budget: " + firstMovieToCross100000);

		// find sum of budget of all movies rating > 9.3
		double sumBudgetMoviesRatingGt93 = movies.stream().filter(x -> x.getRating() > 9.3f)
			.mapToDouble(Movie::getBudgetInDollar)
			.sum(); //avg, count can also be used

		System.out.println("Sum of budget of all movies whose rating is greater than 9.3 :$" + sumBudgetMoviesRatingGt93);

		// group by genre
		System.out.println(movies.stream().collect(Collectors.groupingBy(Movie::getGenre)));

		// group by genre , show count
		System.out.println(movies.stream()
			.collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting())));
		//{patriotic=1, romance=1, drama=2, action=1, thriller=1}

		// group by genre, max reviews
		System.out.println(movies.stream()
			.collect(Collectors.groupingBy(Movie::getGenre,
				Collectors.maxBy(Comparator.comparing(Movie::getReviews)))
			)
		);

		// group by genre, show name only
		System.out.println(movies.stream()
			.collect(Collectors.groupingBy(Movie::getGenre,
				Collectors.mapping(Movie::getName, Collectors.toList())
				)
			)
		);
		//{patriotic=[Rang de basanti], romance=[Bombay], drama=[DDLJ, Jab We Met], action=[Roza], thriller=[Andhadhun]}

		//group by genre, show only names
		/*System.out.println(movies.stream()
			.collect(Collectors.groupingBy(Movie::getGenre)));*/

		List<Movie> selectedMovies = List.of(
			new Movie("DDLJ", 800000d, 50000, 9.2f, "drama"),
			new Movie("Rang de basanti", 300000d, 200000, 9.2f, "patriotic")
		);

		List<Movie> sortedByRatingThenBudgetThenReviewsList = selectedMovies.stream()
			.sorted(Comparator.comparing(Movie::getRating) // DDLJ comes first
				.thenComparing(Movie::getBudgetInDollar).reversed() // Rang De basanti comes first due to high budget
				.thenComparing(Movie::getReviews).reversed()) // DDLJ comes first due to high reviewes
			.collect(Collectors.toList());
		System.out.println("Sorted by Rating->Budget->Reviews : " + sortedByRatingThenBudgetThenReviewsList);


	}

}

