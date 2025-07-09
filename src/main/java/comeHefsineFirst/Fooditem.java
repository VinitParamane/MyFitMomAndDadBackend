package comeHefsineFirst;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity@Getter@Setter@ToString@AllArgsConstructor@NoArgsConstructor
public class Fooditem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String fooditem_english;
	String fooditem_hindi;
	String fooditem_marathi;
	float calories;
	float carbohydrates;
	float protein;
	float goodfat;
	float badfat;
	
	

}
