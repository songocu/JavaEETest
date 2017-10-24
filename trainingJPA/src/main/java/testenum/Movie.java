package testenum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Integer id;
    private String director;
    private String title;
    private int year;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    public Movie() {
    }

    public Movie(String director, String title, int year, Rating rating) {
        this.director = director;
        this.title = title;
        this.year = year;
        this.rating = rating;
    }
    
    public Integer getId(){
    	return id;
    }
    
	public void setId(Integer id) {
		this.id = id;
	}

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}