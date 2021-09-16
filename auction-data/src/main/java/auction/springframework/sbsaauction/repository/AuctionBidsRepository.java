package auction.springframework.sbsaauction.repository;

import auction.springframework.sbsaauction.model.Auction;
import auction.springframework.sbsaauction.model.AuctionBids;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface AuctionBidsRepository extends JpaRepository<AuctionBids, Integer> {
	
	List<AuctionBids> findByAuction(Auction auction);
	List<AuctionBids> findByAuctionOrderByBidOnDesc(Auction auction);
	List<AuctionBids> findByAuctionOrderByBidPriceDesc(Auction auction);
	List<AuctionBids> findByAuctionOrderByBidPriceAsc(Auction auction);
	
}
