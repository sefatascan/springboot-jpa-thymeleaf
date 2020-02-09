package com.sefa.anket.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class FansOfTeam {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String surname;
	private int gender;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private String chosenTeam;
	private String explanation;
	
	private String pollsterName;
	private String pollsterSurname;

}
