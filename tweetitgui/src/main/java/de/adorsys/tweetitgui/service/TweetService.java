package de.adorsys.tweetitgui.service;

import de.adorsys.tweetitgui.model.TweetDTO;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: torben
 * Date: 04.05.12
 * Time: 22:42
 * To change this template use File | Settings | File Templates.
 */
@Path("/tweetit.server/rest/tweets")
public interface TweetService extends RestService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    void create(TweetDTO dto, MethodCallback<TweetDTO> callback);
}
