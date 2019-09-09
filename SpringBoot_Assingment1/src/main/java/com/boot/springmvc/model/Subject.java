package com.boot.springmvc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the subject database table.
 * 
 */
@Entity
@Table(name="subject")
@NamedQuery(name="Subject.findAll", query="SELECT s FROM Subject s")
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;
	private int subjectId;
	private int durationInHour;
	private String subTitle;
	//private List<Book> books;

	public Subject() {
	}


	@Id
	@GeneratedValue
	@Column(name="subject_id", unique=true, nullable=false)
	public int getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}


	@Column(name="duration_in_hour")
	public int getDurationInHour() {
		return this.durationInHour;
	}

	public void setDurationInHour(int durationInHour) {
		this.durationInHour = durationInHour;
	}


	@Column(name="sub_title", length=45)
	public String getSubTitle() {
		return this.subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}


	/*
	 * //bi-directional many-to-one association to Book
	 * 
	 * @OneToMany(mappedBy="subject") public List<Book> getBooks() { return
	 * this.books; }
	 * 
	 * public void setBooks(List<Book> books) { this.books = books; }
	 */
	/*
	 * public Book addBook(Book book) { getBooks().add(book); book.setSubject(this);
	 * 
	 * return book; }
	 * 
	 * public Book removeBook(Book book) { getBooks().remove(book);
	 * book.setSubject(null);
	 * 
	 * return book; }
	 */

}