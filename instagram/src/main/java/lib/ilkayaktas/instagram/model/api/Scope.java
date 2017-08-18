package lib.ilkayaktas.instagram.model.api;

public enum Scope {

    /**
     * A field to denote the scope 'basic'
     * <p>
     * basic - Be able to read all data related to a user: Following/Followed-By
     * Lists, Photos, etc. (granted by default)
     */
    BASIC("basic"),

    /**
     * A field to denote the scope 'comments'
     * <p>
     * comments - Be able to create or delete comments on a user's behalf
     */
    COMMENTS("comments"),

    /**
     * A field to denote the scope 'likes'
     * <p>
     * likes - Be able to like and unlike items on a user's behalf
     */
    LIKES("likes"),

    /**
     * A field to denote the scope 'relationships'
     * <p>
     * relationships - Be able to follow and unfollow users on a user's behalf
     */
    RELATIONSHIPS("relationships"),

    /**
     * A field to denote all scopes
     * <p>
     * all - you can do everything, info, like, comment etc.
     */
    ALL("basic+public_content+comments+relationships+likes+follower_list");

    private String str;

    Scope(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }
}
