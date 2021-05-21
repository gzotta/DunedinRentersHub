/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.WishlistJdbcDAO;
import domain.Property;
import domain.Renter;
import domain.Wishlist;
import org.jooby.Jooby;
import org.jooby.Status;

/**
 *
 * @author maxer
 */
public class WishlistModule extends Jooby {

    public WishlistModule(WishlistJdbcDAO dao) {

        //Add (POST) property to wishlist.
        post("/api/wishlist", (req, rsp) -> {
            Wishlist wishlist = req.body().to(Wishlist.class);
            dao.addToWishList(wishlist);
            rsp.status(Status.CREATED);
        });

    }

}
