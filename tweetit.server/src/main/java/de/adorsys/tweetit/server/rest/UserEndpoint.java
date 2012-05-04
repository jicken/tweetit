package de.adorsys.tweetit.server.rest;

import de.adorsys.tweetit.server.model.MyUser;
import de.adorsys.tweetit.server.model.Tweet;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.Collection;
import java.util.List;

@Stateless
@Path("/users")
public class UserEndpoint
{
   @PersistenceContext
   private EntityManager em;

   @POST
   @Consumes("application/json")
   public MyUser create(MyUser entity)
   {
      
      em.persist(entity);
      return entity;
   }

   @DELETE
   @Path("/{id}")
   @Produces("application/json")
   public MyUser deleteById(@PathParam("id") String id)
   {
      
      MyUser result = em.find(MyUser.class, id);
      em.remove(result);
      return result;
   }

   @GET
   @Path("/{id}")
   @Produces("application/json")
   public MyUser findById(@PathParam("id") String id)
   {
      return em.find(MyUser.class, id);
   }

   @GET
   @Produces("application/json")
   public List<MyUser> listAll()
   {
      @SuppressWarnings("unchecked")
      final List<MyUser> results = em.createQuery("SELECT x FROM MyUser x").getResultList();
      return results;
   }

   @PUT
   @Path("/{id}")
   @Consumes("application/json")
   public MyUser update(@PathParam("id") String id, MyUser entity)
   {
      entity.setUserId(id);
      entity = em.merge(entity);
      return entity;
   }
   
   @Path("/{userId}/followers/{followerId}")
   @PUT
   public void addFollow(@PathParam("userId") String userId, @PathParam("followerId") String followerId){
	   MyUser self = em.find(MyUser.class, userId);
	   MyUser newFollower = em.find(MyUser.class, followerId);
	   Collection<MyUser> followMyUsers = self.getFollowMyUsers();
	   followMyUsers.add(newFollower);
   }
   
   @GET
   @Path("/{userId}/tweets")
   @Produces("application/json")
   public Collection<Tweet> listFollowingTweets(@PathParam("userId") String userId) {
	   final List<Tweet> results = em.createQuery("SELECT t FROM Tweet t INNER JOIN t.emitter other WHERE other.userId IN (SELECT self.userId FROM MyUser self WHERE self.userId = ?)")
			   .setParameter(1, userId)
			   .getResultList();
	   return results;
   }
   
   @GET
   @Path("/{userId}/my-tweets")
   @Produces("application/json")
   public Collection<Tweet> listMyTweets(@PathParam("userId") String userId) {
	   final List<Tweet> results = em.createQuery("SELECT t FROM Tweet t INNER JOIN t.emitter self WHERE self.userId = ?").setParameter(1, userId).getResultList();
	   return results;
   }
}
