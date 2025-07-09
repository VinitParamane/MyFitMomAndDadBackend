package comeHefsineFirst;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

	int countByUsername(String string);

	User findByUsername(String string);

}
