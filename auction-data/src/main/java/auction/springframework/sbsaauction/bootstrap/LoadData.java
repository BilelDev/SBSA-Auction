package auction.springframework.sbsaauction.bootstrap;

import auction.springframework.sbsaauction.model.Category;
import auction.springframework.sbsaauction.repository.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Log4j2
@Component
public class LoadData implements CommandLineRunner {
    private AuctionRepository auctionRepository;
    private AuctionBidsRepository auctionBidsRepository;
    private AuctionImageRepository auctionImageRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    private CompletedAuctionRepository completedAuctionRepository;
    private UserRepository userRepository;
/*
    public LoadData(AuctionRepository auctionRepository, AuctionBidsRepository auctionBidsRepository,
                    AuctionImageRepository auctionImageRepository, CategoryRepository categoryRepository,
                    CompletedAuctionRepository completedAuctionRepository,UserRepository userRepository) {
    this.auctionBidsRepository=auctionBidsRepository;
    this.auctionImageRepository=auctionImageRepository;
    this.auctionRepository=auctionRepository;
    this.userRepository=userRepository;
    this.categoryRepository=categoryRepository;
    this.completedAuctionRepository=completedAuctionRepository;
    }
*/
    @Override
    public void run(String... args) throws Exception {
        Category category=new Category();
        category.setCategoryName("category 1");
        category.setActive(1);
        categoryRepository.save(category);
    log.info("catagory added!");
    }
}
