//package com.Hefsine.fit;
package comeHefsineFirst;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity@Getter@Setter@NoArgsConstructor@AllArgsConstructor@ToString
public class Request {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String fooditem;
	int status;//0-Reported  1-accepted  2-rejected
	String reject_Reason;


}
