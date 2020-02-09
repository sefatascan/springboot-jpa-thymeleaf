package com.sefa.anket.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class LifeQuality {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String surname;
	private int gender;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private int lifeQuality;
	private String happiness;
	private String unhappiness;
	private String explanation;
	
	private String pollsterName;
	private String pollsterSurname;

}
