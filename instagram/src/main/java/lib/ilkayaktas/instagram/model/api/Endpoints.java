package lib.ilkayaktas.instagram.model.api;

public final class Endpoints {


    /**
     * Get basic information about a user (self).
     */
    public static final String USERS_SELF = "/users/self";

    /**
     * Get basic information about a user.
     */
    public static final String USERS_WITH_ID = "/users/%s";

    /*
     * Get the most recent media published by the owner of the access_token.
     */
    public static final String USERS_SELF_RECENT_MEDIA = "/users/self/media/recent";

    /**
     * Get the most recent media published by a user.
     */
    public static final String USERS_RECENT_MEDIA = "/users/%s/media/recent";

    /**
     * See the authenticated user's list of media they've liked. Note that this
     * list is ordered by the order in which the user liked the media. Private
     * media is returned as long as the authenticated user has permission to
     * view that media. Liked media lists are only available for the currently
     * authenticated user.
     */
    public static final String USERS_SELF_LIKED_MEDIA = "/users/self/media/liked";

    /**
     * Search for a user by name.
     */
    public static final String USERS_SEARCH = "/users/search";

    /**
     * Get the list of users this user follows.
     * <p>
     * Required scope: follower_list
     */
    public static final String USERS_SELF_FOLLOWS = "/users/self/follows";

    /**
     * Get the list of users this user is followed by.
     * <p>
     * Required scope: follower_list
     */
    public static final String USERS_SELF_FOLLOWED_BY = "/users/self/followed-by";

    /**
     * List the users who have requested this user's permission to follow
     * <p>
     * Required scope: relationships
     */
    public static final String USERS_SELF_REQUESTED_BY = "/users/self/requested-by";

    /**
     * Get information about the current user's relationship
     * (follow/following/etc) to another user.
     * Modify the relationship between the current user and the target user.
     * Required scope: relationships
     */
    public static final String USERS_ID_RELATIONSHIP = "/users/%s/relationship";

    /**
     * Get information about a media object.
     */
    public static final String MEDIA_BY_ID = "/media/%s";

    /**
     * Get information about a media object.
     */
    public static final String MEDIA_BY_SHORTCODE = "/media/shortcode/%s";

    /**
     * Search for media in a given area.
     */
    public static final String MEDIA_SEARCH = "/media/search";

    /**
     * Get a full list of comments on a media.
     * <p>
     * Create a comment on a media object with the following rules:
     * The total length of the comment cannot exceed 300 characters.
     * The comment cannot contain more than 4 hashtags.
     * The comment cannot contain more than 1 URL.
     * The comment cannot consist of all capital letters.
     * Required scope: public_content, comments
     */
    public static final String MEDIA_COMMENTS = "/media/%s/comments";

    /**
     * Remove a comment either on the authenticated user's media or authored by
     * the authenticated user.
     * <p>
     * Required scope: comments
     * <p>
     * DELETE /media/{id}/comments/{id}
     */
    public static final String DELETE_MEDIA_COMMENTS = "/media/%s/comments/%s";

    /**
     * Get a list of users who have liked this media.
     * Set a like on this media by the currently authenticated user.
     * Remove a like on this media by the currently authenticated user.
     * Required scope : public_content, likes
     */
    public static final String LIKES_BY_MEDIA_ID = "/media/%s/likes";

    /**
     * Get information about a tag object.
     */
    public static final String TAGS_BY_NAME = "/tags/%s";

    /**
     * Get a list of recently tagged media.
     */
    public static final String TAGS_RECENT_MEDIA = "/tags/%s/media/recent";

    /**
     * Search for tags by name - results are ordered first as an exact match,
     * then by popularity.
     */
    public static final String TAGS_SEARCH = "/tags/search";

    /**
     * Get information about a location.
     */
    public static final String LOCATIONS_BY_ID = "/locations/%s";

    /**
     * Get a list of recent media objects from a given location.
     */
    public static final String LOCATIONS_RECENT_MEDIA_BY_ID = "/locations/%s/media/recent";

    /**
     * Search for a location by geographic coordinate.
     */
    public static final String LOCATIONS_SEARCH = "/locations/search";

    /**
     * Given a short link, returns information about the media associated with
     * that link.
     */
    public static final String OEMBED_INFORMATION = "/oembed?url=%s";

    /**
     * CRUD Real-time  subscriptions
     */
    public static final String SUBSCRIPTIONS = "/subscriptions";

}
