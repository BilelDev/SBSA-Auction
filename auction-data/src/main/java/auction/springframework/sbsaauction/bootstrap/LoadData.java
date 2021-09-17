package auction.springframework.sbsaauction.bootstrap;

import auction.springframework.sbsaauction.model.*;
import auction.springframework.sbsaauction.repository.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Log4j2
@Component
public class LoadData implements CommandLineRunner {
    @Autowired
    private AuctionRepository auctionRepository;
    @Autowired
    private AuctionBidsRepository auctionBidsRepository;
    @Autowired
    private AuctionImageRepository auctionImageRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CompletedAuctionRepository completedAuctionRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        for (int i=0;i<3 ;i++) {
           Category category= createCategory( i);
           User user=createUser(i);
           Auction auction= createAuctions(i,category,user);
            AuctionBids auctionBids=createAuctionBids(i,auction,user);
            AuctionImage auctionImage=createAuctionImage(i,auction);
            CompletedAuction completedAuction=createCompletedAuction(i,auction);
        }

    }

    private CompletedAuction createCompletedAuction(int i,Auction auction) {
    CompletedAuction completedAuction=new CompletedAuction();
    completedAuction.setAuction(auction);
    completedAuction.setAuctionCompletedOn(LocalDateTime.now().plusDays(30));
    completedAuction.setActive(0);
    completedAuction.setWinningBidPrice(100.0);
        log.info("completedAuction "+i+" added!");
        return completedAuctionRepository.save( completedAuction);
    }

    private AuctionImage createAuctionImage(int i,Auction auction) {
        AuctionImage auctionImage=new AuctionImage();
        auctionImage.setImageId(1);
        auctionImage.setPath("path"+i);
        auctionImage.setProject(auction);
        log.info("auctionImage "+i+" added!");
        return auctionImageRepository.save(auctionImage);
    }

    private AuctionBids createAuctionBids(int i,Auction auction,User costumer) {
        AuctionBids auctionBids=new AuctionBids();
        auctionBids.setAuction(auction);
        auctionBids.setBidOn(LocalDateTime.now().plusDays(10));
        auctionBids.setBidPrice(10);
        auctionBids.setCustomer(costumer);
        log.info("auctionBids "+i+" added!");
        return  auctionBidsRepository.save(auctionBids);
    }

    private User createUser(int i) {
        User user=new User();
        user.setActive(1);
        user.setAddress("address "+i);
        user.setUsername("username"+i);
        user.setPhoneNumber("phone "+i);
        user.setPassword("pwd");
        user.setQuestion(1);

        user.setAnswer("answer");
        log.info("user "+i+" added!");
        return userRepository.save(user);
    }

    private Auction createAuctions(int i,Category category, User user) {
        Auction auction=new Auction();
        auction.setAuctionBy(user);
        auction.setAuctionCategory(category);
        auction.setAuctionTitle("title "+i);
        auction.setActive(1);
        auction.setAuctionEndingDate(LocalDateTime.now().plusDays(10));
        auction.setAuctionPostedDate(LocalDateTime.now());
        auction.setAuctionStartingPrice(1);
        auction.setAuctionDescription("description "+i);
        log.info("auction "+i+" added!");

        return auctionRepository.save(auction);
    }

    private Category createCategory(int i) {
        Category category=new Category();
        category.setCategoryName("category "+i);
       // if(i%2==0)
        category.setActive(1);
        log.info("catagory "+i+" added!");
       return categoryRepository.save(category);

    }
}
