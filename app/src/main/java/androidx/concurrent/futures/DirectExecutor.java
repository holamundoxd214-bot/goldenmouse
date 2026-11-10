package androidx.concurrent.futures;

import java.util.concurrent.Executor;

public enum DirectExecutor implements Executor {
    public static final enum DirectExecutor INSTANCE;

    static {
        DirectExecutor v0 = new DirectExecutor("INSTANCE", 0);
        DirectExecutor.INSTANCE = v0;
        DirectExecutor.$VALUES = new DirectExecutor[]{v0};
    }

    private DirectExecutor(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public void execute(Runnable arg1) {
        arg1.run();
    }

    public String toString() {
        return "DirectExecutor";
    }

    public static DirectExecutor valueOf(String arg1) {
        return Enum.valueOf(DirectExecutor.class, arg1);
    }

    public static DirectExecutor[] values() {
        return DirectExecutor.$VALUES.clone();
    }
}

