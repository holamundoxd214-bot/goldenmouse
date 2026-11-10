package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;

@Metadata(d1={"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u001A\u0010\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0007\u001A\u0010\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0006H\u0007\u001A\b\u0010\u0007\u001A\u00020\u0001H\u0007\u001A\u001E\u0010\b\u001A\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u000Bj\u0002`\f\u0012\u0004\u0012\u00020\r0\n0\tH\u0007\u001A\u001A\u0010\u000E\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\r0\n0\tH\u0007\u001A\b\u0010\u0010\u001A\u00020\u0001H\u0007¨\u0006\u0011"}, d2={"simulateHotReload", "", "context", "", "invalidateGroupsWithKey", "key", "", "disableHotReloadMode", "currentCompositionErrors", "", "Lkotlin/Pair;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "getCurrentCompositionErrors", "", "clearCompositionErrors", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class HotReloaderKt {
    public static final void clearCompositionErrors() {
        HotReloader.Companion.clearErrors();
    }

    @Deprecated(message="currentCompositionErrors only reports errors that extend from Exception. This method is unsupported outside of Compose runtime tests. Internally, getCurrentCompositionErrors should be used instead.") public static final List currentCompositionErrors() {
        List v0 = HotReloaderKt.getCurrentCompositionErrors();
        ArrayList v1 = new ArrayList();
        Iterator v0_1 = ((Iterable)v0).iterator();
        while(v0_1.hasNext()) {
            Object v2 = v0_1.next();
            Object v3 = ((Pair)v2).component1();
            boolean v2_1 = ((Pair)v2).component2().booleanValue();
            Pair v5 = null;
            if((v3 instanceof Exception)) {
            }
            else {
                v3 = v5;
            }

            if(v3 == null) {
            }
            else {
                v5 = TuplesKt.to(v3, Boolean.valueOf(v2_1));
            }

            if(v5 == null) {
                continue;
            }

            ((Collection)v1).add(v5);
        }

        return ((List)v1);
    }

    public static final void disableHotReloadMode() {
        Recomposer.Companion.setHotReloadEnabled$runtime(false);
    }

    public static final List getCurrentCompositionErrors() {
        List v0 = HotReloader.Companion.getRecomposerErrors();
        ArrayList v1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v0), 10));
        Iterator v0_1 = ((Iterable)v0).iterator();
        while(v0_1.hasNext()) {
            Object v2 = v0_1.next();
            ((Collection)v1).add(TuplesKt.to(((RecomposerErrorInformation)v2).getCause(), Boolean.valueOf(((RecomposerErrorInformation)v2).isRecoverable())));
        }

        return ((List)v1);
    }

    public static final void invalidateGroupsWithKey(int arg1) {
        HotReloader.Companion.invalidateGroupsWithKey(arg1);
    }

    public static final void simulateHotReload(Object arg1) {
        HotReloader.Companion.simulateHotReload$runtime(arg1);
    }
}

