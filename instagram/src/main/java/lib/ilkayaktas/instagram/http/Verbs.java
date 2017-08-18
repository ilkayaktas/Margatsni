package lib.ilkayaktas.instagram.http;

/**
 * An enumeration containing the most common HTTP Verbs.
 */
public enum Verbs {
    GET,
    POST,
    PUT,
    DELETE;

    private String str;

    public String value(){
        return super.toString().toUpperCase();
    }

    @Override
    public String toString() {
        return super.toString().toUpperCase();
    }
}
