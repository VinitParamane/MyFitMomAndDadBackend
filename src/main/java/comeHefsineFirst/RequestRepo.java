package comeHefsineFirst;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RequestRepo extends JpaRepository<Request, Integer>{
	@Query(value = "SELECT * FROM request where status=0 limit 15", nativeQuery = true)
    ArrayList<Request> findReportedRequests();
	
	Request findById(int a);
    int countByFooditem(String s);
}
