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

@Entity@Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String username;
	String password;

}
