package androidx.savedstate.compose;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"LocalSavedStateRegistryOwner", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/savedstate/SavedStateRegistryOwner;", "getLocalSavedStateRegistryOwner", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "savedstate-compose"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LocalSavedStateRegistryOwnerKt {
    private static final ProvidableCompositionLocal LocalSavedStateRegistryOwner;

    static {
        Object v1_3;
        Object v0 = null;
        try {
            ClassLoader v1_1 = SavedStateRegistryOwner.class.getClassLoader();
            Intrinsics.checkNotNull(v1_1);
            Method v1_2 = v1_1.loadClass("androidx.compose.ui.platform.AndroidCompositionLocals_androidKt").getMethod("getLocalSavedStateRegistryOwner");
            Annotation[] v3 = v1_2.getAnnotations();
            Intrinsics.checkNotNullExpressionValue(v3, "getAnnotations(...)");
            int v4 = v3.length;
            int v5 = 0;
            while(true) {
                if(v5 >= v4) {
                    break;
                }
                else if(!(v3[v5] instanceof Deprecated)) {
                    ++v5;
                    continue;
                }
                else {
                    goto label_20;
                }
            }

            v1_3 = v1_2.invoke(v0);
            if(!(v1_3 instanceof ProvidableCompositionLocal)) {
            label_20:
                v1_3 = v0;
            }

            v1_3 = Result.constructor-impl(v1_3);
        }
        catch(Throwable v1) {
            v1_3 = Result.constructor-impl(ResultKt.createFailure(v1));
        }

        if(Result.isFailure-impl(v1_3)) {
        }
        else {
            v0 = v1_3;
        }

        if(v0 == null) {
            ProvidableCompositionLocal v0_1 = CompositionLocalKt.staticCompositionLocalOf(new LocalSavedStateRegistryOwnerKt$$ExternalSyntheticLambda0());
        }

        LocalSavedStateRegistryOwnerKt.LocalSavedStateRegistryOwner = ((ProvidableCompositionLocal)v0);
    }

    static final SavedStateRegistryOwner LocalSavedStateRegistryOwner$lambda$3$lambda$2() {
        throw new IllegalStateException("CompositionLocal LocalSavedStateRegistryOwner not present".toString());
    }

    public static final ProvidableCompositionLocal getLocalSavedStateRegistryOwner() {
        return LocalSavedStateRegistryOwnerKt.LocalSavedStateRegistryOwner;
    }
}

