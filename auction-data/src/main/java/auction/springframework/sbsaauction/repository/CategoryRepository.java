package auction.springframework.sbsaauction.repository;


import auction.springframework.sbsaauction.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	public Category findByCategoryId(int categoryId);
}
