/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.RenterJdbcDAO;
import domain.Landlord;
import domain.Renter;
import org.jooby.Jooby;
import org.jooby.Result;
import org.jooby.Status;

/**
 *
 * @author zotta
 */
public class RenterModule extends Jooby {

    public RenterModule(RenterJdbcDAO renterDao) {

        //Save (POST) a Landlord.
        post("/api/register", (req, rsp) -> {
            Renter renter = req.body().to(Renter.class);
            renterDao.saveRenter(renter);
            rsp.status(Status.CREATED);
        }
        );

        //GET a renter by username.
        get("/api/renters/:username", (req) -> {
            String username = req.param("username").value();
            if (renterDao.getRenter(username) == null) {
                return new Result().status(Status.NOT_FOUND);
            } else {
                return renterDao.getRenter(username);
            }
        });

        //GET a renter wishlist.
        get("/api/renters/:username", (req) -> {
            String username = req.param("username").value();
            Renter r = renterDao.getRenter(username);
            return renterDao.getRenterWishlist(r);

        });

    }

}
