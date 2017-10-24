package testDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class DatesPojo {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",updatable=false,nullable=false)
	private Integer Id;
	private LocalDate date;
	private LocalTime time;
	private LocalDateTime dateTime;
	private OffsetTime offsetTime;
	private OffsetDateTime offsetDateTime;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public OffsetTime getOffsetTime() {
		return offsetTime;
	}
	public void setOffsetTime(OffsetTime offsetTime) {
		this.offsetTime = offsetTime;
	}
	public OffsetDateTime getOffsetDateTime() {
		return offsetDateTime;
	}
	public void setOffsetDateTime(OffsetDateTime offsetDateTime) {
		this.offsetDateTime = offsetDateTime;
	}
	

	
	
}
