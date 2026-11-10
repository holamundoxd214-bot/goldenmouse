package androidx.core.os;

import androidx.core.util.ObjectsCompat;

public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException() {
        this(null);
    }

    public OperationCanceledException(String arg2) {
        super(ObjectsCompat.toString(arg2, "The operation has been canceled."));
    }
}

