package de.adorsys.tweetitgui.model;

/**
 * Created with IntelliJ IDEA.
 * FollowingUser: torben
 * Date: 04.05.12
 * Time: 19:39
 * To change this template use File | Settings | File Templates.
 */
public class FollowingUser {
    private String id;
    private String name;
    private Boolean following;

    public FollowingUser(String id, String name, Boolean following) {
        this.id = id;
        this.name = name;
        this.following = following;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFollowing() {
        return following;
    }

    public void setFollowing(Boolean following) {
        this.following = following;
    }
}
