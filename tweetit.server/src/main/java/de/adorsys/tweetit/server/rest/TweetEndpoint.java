package de.adorsys.tweetit.server.rest;

import de.adorsys.tweetit.server.model.MyUser;
import de.adorsys.tweetit.server.model.Tweet;
import de.adorsys.tweetit.server.model.TweetDTO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.Date;
import java.util.List;

@Stateless
@Path("/tweets")
public class TweetEndpoint {
    @PersistenceContext
    private EntityManager em;

    @POST
    @Consumes("application/json")
    public TweetDTO create(TweetDTO tweet) {

        MyUser myUser = em.find(MyUser.class, tweet.getUserId());
        Tweet tweetEntity = new Tweet();
        tweetEntity.setCdat(String.valueOf(new Date().getTime()));
        tweetEntity.setEmitter(myUser);
        tweetEntity.setMessage(tweetEntity.getMessage());
        em.persist(tweetEntity);
        tweet.setCdate(tweetEntity.getCdat());
        return tweet;
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Tweet findById(@PathParam("id") Long id) {
        return em.find(Tweet.class, id);
    }

    @GET
    @Produces("application/json")
    public List<Tweet> listAll() {
        @SuppressWarnings("unchecked")
        final List<Tweet> results = em.createQuery("SELECT x FROM Tweet x").getResultList();
        return results;
    }

}
