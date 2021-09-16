package auction.springframework.sbsaauction.repository;

import auction.springframework.sbsaauction.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AuctionRepository extends JpaRepository<Auction, Integer> {
	
	List<Auction> findByActive(int active);
}
