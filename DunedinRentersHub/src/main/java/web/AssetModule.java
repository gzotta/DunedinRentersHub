package web;

import org.jooby.Jooby;
import org.jooby.Results;

/**
 *
 * @author zotta
 */
public class AssetModule extends Jooby {

    public AssetModule() {
        assets("/*.html");
        assets("/css/*.css");
        assets("/js/*.js");
        assets("/images/properties/photos/*.png");
        assets("/images/properties/photos/*.jpeg");
        assets("/images/properties/maps/*.png");
        assets("/images/properties/maps/*.jpeg");
        assets("/images/renters/*.png");
        assets("/images/renters/*.jpg");
        assets("/images/services/*.png");
        assets("/images/services/*.jpg");
// make index.html the default page
        assets("/", "index.html");
// prevent 404 errors due to browsers requesting favicons
        get("/favicon.ico", () -> Results.noContent());
    }
}
