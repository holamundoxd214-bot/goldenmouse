package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\"\u0014\u0010\u0000\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"ANDROID_DETECTED", "", "getANDROID_DETECTED", "()Z", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class FastServiceLoaderKt {
    private static final boolean ANDROID_DETECTED;

    static {
        Object v0_1;
        try {
            v0_1 = Result.constructor-impl(Class.forName("android.os.Build"));
        }
        catch(Throwable v0) {
            v0_1 = Result.constructor-impl(ResultKt.createFailure(v0));
        }

        FastServiceLoaderKt.ANDROID_DETECTED = Result.isSuccess-impl(v0_1);
    }

    public static final boolean getANDROID_DETECTED() {
        return FastServiceLoaderKt.ANDROID_DETECTED;
    }
}

