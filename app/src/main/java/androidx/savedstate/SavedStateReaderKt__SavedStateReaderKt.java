package androidx.savedstate;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000E\n\u0000\u001A\u0010\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0001¨\u0006\u0004"}, d2={"keyOrValueNotFoundError", "", "key", "", "savedstate"}, k=5, mv={2, 0, 0}, xi=0x30, xs="androidx/savedstate/SavedStateReaderKt") final class SavedStateReaderKt__SavedStateReaderKt {
    public static final Void keyOrValueNotFoundError(String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        throw new IllegalArgumentException("No valid saved state was found for the key \'" + arg3 + "\'. It may be missing, null, or not of the expected type. This can occur if the value was saved with a different type or if the saved state was modified unexpectedly.");
    }
}

