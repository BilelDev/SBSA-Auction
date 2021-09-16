package auction.springframework.sbsaauction.repository;

import auction.springframework.sbsaauction.model.Auction;
import auction.springframework.sbsaauction.model.AuctionImage;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AuctionImageRepository extends JpaRepository<AuctionImage, Integer> {
	
//	@Query(value = "select * from auction_images where auction_id = :auctionId LIMIT 0,1", nativeQuery = true)
	List<AuctionImage> findByProject(Auction project, Pageable pageable);
}
 