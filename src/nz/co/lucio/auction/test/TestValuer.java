package nz.co.lucio.auction.test;

import nz.co.lucio.auction.dominio.Auction;
import nz.co.lucio.auction.dominio.Bid;
import nz.co.lucio.auction.dominio.User;
import nz.co.lucio.auction.servico.Valuer;

import org.junit.Assert;
import org.junit.Test;

public class TestValuer {

    @Test
    public void mustUnderstandBidInCrescentOrder() {
        // part 1: scenarios
        User lucio = new User("Lucio");
        User raf = new User("Raf");
        User suzana = new User("Suzana");
        User lucia = new User("Lucia");

        Auction auction = new Auction ("A new PS4");

        auction.offer(new Bid(lucio, 300.0));
        auction.offer(new Bid(raf, 455.0));
        auction.offer(new Bid(suzana, 400.0));
        auction.offer(new Bid(lucia, 600.0));

        // part 2: actions
        Valuer auctioneer = new Valuer();
        auctioneer.evaluates(auction);

        // part 3: validations
        double biggerWait = 600.0;
        double lesserWait = 300.0;

        Assert.assertEquals(biggerWait, auctioneer.getBiggerBid(),0.00001);
        Assert.assertEquals(lesserWait, auctioneer.getLesserBid(),0.00001);


    }

}
