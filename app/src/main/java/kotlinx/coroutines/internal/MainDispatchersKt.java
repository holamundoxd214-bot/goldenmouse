package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\u001A\u001A\u0010\u0002\u001A\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007\u001A\f\u0010\u0007\u001A\u00020\b*\u00020\u0003H\u0007\u001A \u0010\f\u001A\u00020\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0001H\u0002\u001A\b\u0010\u0011\u001A\u00020\u0012H\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\t\u001A\u00020\bX\u0082D¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000B¨\u0006\u0013"}, d2={"FAST_SERVICE_LOADER_PROPERTY_NAME", "", "tryCreateDispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "factories", "", "isMissing", "", "SUPPORT_MISSING", "getSUPPORT_MISSING$annotations", "()V", "createMissingDispatcher", "Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "cause", "", "errorHint", "throwMissingMainDispatcherException", "", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class MainDispatchersKt {
    private static final String FAST_SERVICE_LOADER_PROPERTY_NAME = "kotlinx.coroutines.fast.service.loader";
    private static final boolean SUPPORT_MISSING = true;

    static {
    }

    private static final MissingMainCoroutineDispatcher createMissingDispatcher(Throwable arg1, String arg2) {
        if(MainDispatchersKt.SUPPORT_MISSING) {
            return new MissingMainCoroutineDispatcher(arg1, arg2);
        }

        if(arg1 != null) {
            throw arg1;
        }

        MainDispatchersKt.throwMissingMainDispatcherException();
        throw new KotlinNothingValueException();
    }

    static MissingMainCoroutineDispatcher createMissingDispatcher$default(Throwable arg1, String arg2, int arg3, Object arg4) {
        Throwable v0 = null;
        if((arg3 & 1) != 0) {
            arg1 = v0;
        }

        if((arg3 & 2) != 0) {
            arg2 = ((String)v0);
        }

        return MainDispatchersKt.createMissingDispatcher(arg1, arg2);
    }

    private static void getSUPPORT_MISSING$annotations() {
    }

    public static final boolean isMissing(MainCoroutineDispatcher arg0) {
        return arg0.getImmediate() instanceof MissingMainCoroutineDispatcher;
    }

    public static final Void throwMissingMainDispatcherException() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. \'kotlinx-coroutines-android\' and ensure it has the same version as \'kotlinx-coroutines-core\'");
    }

    public static final MainCoroutineDispatcher tryCreateDispatcher(MainDispatcherFactory arg0, List arg1) {
        MainCoroutineDispatcher v0;
        try {
            v0 = arg0.createDispatcher(arg1);
            return v0;
        }
        catch(Throwable v1) {
            return MainDispatchersKt.createMissingDispatcher(v1, ((MainDispatcherFactory)v0).hintOnError());
        }
    }
}

