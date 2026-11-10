package androidx.startup;

public final class StartupException extends RuntimeException {
    public StartupException(Throwable arg1) {
        super(arg1);
    }

    public StartupException(String arg1) {
        super(arg1);
    }

    public StartupException(String arg1, Throwable arg2) {
        super(arg1, arg2);
    }
}

