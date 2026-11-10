package androidx.core.net;

public class ParseException extends RuntimeException {
    public final String response;

    ParseException(String arg1) {
        super(arg1);
        this.response = arg1;
    }
}

