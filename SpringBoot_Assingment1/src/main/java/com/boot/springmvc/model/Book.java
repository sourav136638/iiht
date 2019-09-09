package com.boot.springmvc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;




/**
 * The persistent class for the book database table.
 * 
 */
@Entity
@Table(name="book")
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	private long bookId;
	private String price;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date publishDate;
	private String title;
	private int volume;
	//private Subject subject;
	private int subjectId;

	public Book() {
	}


	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="book_id", unique=true, nullable=false)
	public long getBookId() {
		return this.bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}


	@Column(length=45)
	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


	//@Temporal(TemporalType.DATE)
	@Column(name="publish_date")
	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}


	@Column(length=45)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public int getVolume() {
		return this.volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}


	public int getSubjectId() {
		return subjectId;
	}


	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*
	 * //bi-directional many-to-one association to Subject
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="subject_id") public Subject getSubject() { return
	 * this.subject; }
	 * 
	 * public void setSubject(Subject subject) { this.subject = subject; }
	 */

	
}