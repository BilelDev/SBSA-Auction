package auction.springframework.sbsaauction.repository;


import auction.springframework.sbsaauction.model.Auction;
import auction.springframework.sbsaauction.model.CompletedAuction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompletedAuctionRepository extends JpaRepository<CompletedAuction, Integer> {
	
	boolean existsByAuction(Auction auction);
	CompletedAuction findByAuction(Auction auction);
}
