package androidx.core.os;

public interface OutcomeReceiverCompat {
    default void onError(Throwable arg1) {
    }

    void onResult(Object arg1);
}

