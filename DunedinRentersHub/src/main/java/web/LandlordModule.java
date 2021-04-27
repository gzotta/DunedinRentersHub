/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.LandlordJdbcDAO;
import domain.Landlord;
import org.jooby.Jooby;
import org.jooby.Result;
import org.jooby.Status;

/**
 *
 * @author zotta
 */
public class LandlordModule extends Jooby {

    public LandlordModule(LandlordJdbcDAO landlordDao) {

        //GET a Landlord by username.
        get("/api/landlords/:username", (req) -> {
            String username = req.param("username").value();
            if (landlordDao.getLandlord(username) == null) {
                return new Result().status(Status.NOT_FOUND);
            } else {
                return landlordDao.getLandlord(username);
            }
        });

        //Save (POST) a Landlord.
        post("/api/register", (req, rsp) -> {
            Landlord landlord = req.body().to(Landlord.class);
            landlordDao.saveLandlord(landlord);
            rsp.status(Status.CREATED);
        });

    }

}
