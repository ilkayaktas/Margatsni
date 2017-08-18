package lib.ilkayaktas.instagram.model.api;

public enum Scope {

    /**
     * A field to denote the scope 'basic'
     * <p>
     * basic - to read a user’s profile info and media
     */
    BASIC("basic"),

    /**
     * A field to denote the scope 'public_content'
     * <p>
     *
     * public_content - to read any public profile info and media on a user’s behalf
     */
    PUBLIC_CONTENT("public_content"),

    /**
     * A field to denote the scope 'follower_list'
     *
     * follower_list - to read the list of followers and followed-by users
     * <p>
     */
    FOLLOWER_LIST("follower_list"),
    /**
     * A field to denote the scope 'comments'
     * <p>
     * comments - to post and delete comments on a user’s behalf
     */
    COMMENTS("comments"),

    /**
     * A field to denote the scope 'relationships'
     * <p>
     * relationships - to follow and unfollow accounts on a user’s behalf
     */
    RELATIONSHIPS("relationships"),

    /**
     * A field to denote the scope 'likes'
     * <p>
     * likes - to like and unlike media on a user’s behalf
     */
    LIKES("likes"),

    /**
     * A field to denote all scopes (basic, public_content, follower_list, comments, relationships, likes)
     * <p>
     * basic - to read a user’s profile info and media
     * public_content - to read any public profile info and media on a user’s behalf
     * follower_list - to read the list of followers and followed-by users
     * comments - to post and delete comments on a user’s behalf
     * relationships - to follow and unfollow accounts on a user’s behalf
     * likes - to like and unlike media on a user’s behalf
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
