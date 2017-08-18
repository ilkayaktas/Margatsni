package lib.ilkayaktas.instagram.exceptions;

import java.io.IOException;
import java.util.Map;

/**
 * Created by iaktas on 18.08.2017.
 */

public class InstagramException extends IOException  {
    private static final long serialVersionUID = 942488788539151888L;

    private final Map<String, String> headers;

    private final String errorType;

    /**
     * No-exception constructor. Used when there is no original exception
     *
     * @param message message explaining what went wrong
     */
    public InstagramException(String message) {
        super(message, null);
        this.headers = null;
        this.errorType = null;
    }

    /**
     * No-exception constructor with response headers.
     * Used when there is no original exception
     *
     * @param message message explaining what went wrong
     * @param responseHeaders the headers obtained from Instagram http response
     */
    public InstagramException(String message, Map<String, String> responseHeaders) {
        super(message, null);
        this.headers = responseHeaders;
        this.errorType = null;
    }

    /**
     * No-exception constructor with response headers.
     * Used when there is no original exception
     *
     * @param message message explaining what went wrong
     * @param responseHeaders the headers obtained from Instagram http response
     */
    public InstagramException(String exceptionType, String message, Map<String, String> responseHeaders) {
        super(message, null);
        this.headers = responseHeaders;
        this.errorType = exceptionType;
    }

    /**
     * Default constructor
     *
     * @param message message explaining what went wrong
     * @param e original exception
     */
    public InstagramException(String message, Exception e) {
        super(message, e);
        this.headers = null;
        this.errorType = null;

    }

    /**
     * Constructor with response headers
     * @param message message explaining what went wrong
     * @param e original exception
     * @param responseHeaders the headers obtained from Instagram http response
     */
    public InstagramException(String message, Exception e, Map<String, String> responseHeaders) {
        super(message, e);
        this.headers = responseHeaders;
        this.errorType = null;
    }

    public String getErrorType() {
        return errorType;
    }


}