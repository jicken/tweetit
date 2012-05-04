package de.adorsys.tweetitgui.service;

import de.adorsys.tweetitgui.model.MyUser;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * FollowingUser: torben
 * Date: 04.05.12
 * Time: 20:44
 * To change this template use File | Settings | File Templates.
 */

@Path("/tweetit.server/rest/users")
public interface UserService extends RestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    void listAll(MethodCallback<List<MyUser>> users);
}
