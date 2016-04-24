package com.rangaraj.sample.dbmodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user", schema = "public", uniqueConstraints = @UniqueConstraint(name = "uq_user_user_id", columnNames = {
		"user_id" }) , indexes = { @Index(name = "ix_user_id", columnList = "id") })
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String userId;
	private String welcomeMessage;

	@Id
	@SequenceGenerator(name = "user_id_seq_gen", sequenceName = "user_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq_gen")
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "user_id", length = 50, unique = true, nullable = false)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "welcome_message", length = 50)
	public String getWelcomeMessage() {
		return this.welcomeMessage;
	}

	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

}
