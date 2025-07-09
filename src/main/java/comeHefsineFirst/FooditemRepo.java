package comeHefsineFirst;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public interface FooditemRepo extends JpaRepository<Fooditem, Integer>{
	
	Fooditem findById(int a);
	
	@Query(value = "SELECT count(*) FROM Fooditem where (fooditem_english=concat(?1,'') "+ "or fooditem_marathi=concat(?1,'') "+ "or fooditem_hindi='concat(?1,'')' or\r\n"
			+ " fooditem_hindi like concat(?1,'%') ) ", nativeQuery = true)
    int find_available(String name);
	
	
	@Query(value = "SELECT * FROM Fooditem where (fooditem_english=concat(?1,'') or  fooditem_english like concat(?1,'%') or fooditem_english like concat('%',?1) or fooditem_english like concat('%',?1,'%')\r\n"
			+ "or fooditem_marathi=concat(?1,'') or fooditem_marathi like concat(?1,'%') or fooditem_marathi like concat('%',?1) or fooditem_marathi like concat('%',?1,'%')"
			+ "or fooditem_hindi='concat(?1,'')' or\r\n"
			+ " fooditem_hindi like concat(?1,'%') or fooditem_hindi like concat('%',?1) or fooditem_hindi like concat('%',?1,'%') ) limit  25", nativeQuery = true)
    List<Fooditem> Search(String name);
	
	@Query(value = "SELECT * FROM fooditem ORDER BY protein DESC", nativeQuery = true)
    List<Fooditem> findAllOrderByProteinDesc();
	
	@Query(value = "SELECT * FROM fooditem ORDER BY protein ASC", nativeQuery = true)
	List<Fooditem> findAllOrderByProteinAsc();
	
	@Query(value = "SELECT * FROM fooditem ORDER BY goodfat DESC", nativeQuery = true)
    List<Fooditem> findAllOrderByGoodfatDesc();
	
	@Query(value = "SELECT * FROM fooditem ORDER BY goodfat ASC", nativeQuery = true)
	List<Fooditem> findAllOrderByGoodfatAsc();
	
	@Query(value = "SELECT * FROM fooditem ORDER BY badfat DESC", nativeQuery = true)
    List<Fooditem> findAllOrderByBadfatDesc();
	
	@Query(value = "SELECT * FROM fooditem ORDER BY badfat ASC", nativeQuery = true)
	List<Fooditem> findAllOrderByBadfatAsc();
	
	@Query(value = "SELECT * FROM fooditem ORDER BY carbohydrates DESC", nativeQuery = true)
    List<Fooditem> findAllOrderByCarbohydratesDesc();
	
	@Query(value = "SELECT * FROM fooditem ORDER BY carbohydrates ASC", nativeQuery = true)
	List<Fooditem> findAllOrderByCarbohydratesAsc();

			
	

}
