package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u001AI\u0010\u0000\u001A\u0002H\u0001\"\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00010\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00010\u00062\u0012\u0010\u0007\u001A\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0000¢\u0006\u0002\u0010\n\u001A6\u0010\u000E\u001A\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00010\u00042\u0010\u0010\u000F\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\fH\u0000\"\u0018\u0010\u000B\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\r\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"newInstance", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "constructor", "Ljava/lang/reflect/Constructor;", "params", "", "", "(Ljava/lang/Class;Ljava/lang/reflect/Constructor;[Ljava/lang/Object;)Landroidx/lifecycle/ViewModel;", "ANDROID_VIEWMODEL_SIGNATURE", "", "VIEWMODEL_SIGNATURE", "findMatchingConstructor", "signature", "lifecycle-viewmodel-savedstate"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SavedStateViewModelFactory_androidKt {
    private static final List ANDROID_VIEWMODEL_SIGNATURE;
    private static final List VIEWMODEL_SIGNATURE;

    static {
        Class[] v0 = new Class[2];
        v0[0] = Application.class;
        Class v1 = SavedStateHandle.class;
        v0[1] = v1;
        SavedStateViewModelFactory_androidKt.ANDROID_VIEWMODEL_SIGNATURE = CollectionsKt.listOf(((Object[])v0));
        SavedStateViewModelFactory_androidKt.VIEWMODEL_SIGNATURE = CollectionsKt.listOf(v1);
    }

    public static final List access$getANDROID_VIEWMODEL_SIGNATURE$p() {
        return SavedStateViewModelFactory_androidKt.ANDROID_VIEWMODEL_SIGNATURE;
    }

    public static final List access$getVIEWMODEL_SIGNATURE$p() {
        return SavedStateViewModelFactory_androidKt.VIEWMODEL_SIGNATURE;
    }

    public static final Constructor findMatchingConstructor(Class arg6, List arg7) {
        Intrinsics.checkNotNullParameter(arg6, "modelClass");
        Intrinsics.checkNotNullParameter(arg7, "signature");
        Constructor[] v0 = arg6.getConstructors();
        Intrinsics.checkNotNullExpressionValue(v0, "getConstructors(...)");
        int v1 = v0.length;
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            Constructor v3 = v0[v2];
            Class[] v4 = v3.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(v4, "getParameterTypes(...)");
            List v4_1 = ArraysKt.toList(((Object[])v4));
            if(Intrinsics.areEqual(arg7, v4_1)) {
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactory_androidKt.findMatchingConstructor>");
                return v3;
            }

            if(arg7.size() == v4_1.size()) {
                if(!v4_1.containsAll(arg7)) {
                }
                else {
                    throw new UnsupportedOperationException("Class " + arg6.getSimpleName() + " must have parameters in the proper order: " + arg7);
                }
            }
        }

        return null;
    }

    public static final ViewModel newInstance(Class arg2, Constructor arg3, Object[] arg4) {
        Intrinsics.checkNotNullParameter(arg2, "modelClass");
        Intrinsics.checkNotNullParameter(arg3, "constructor");
        Intrinsics.checkNotNullParameter(arg4, "params");
        try {
            return arg3.newInstance(Arrays.copyOf(arg4, arg4.length));
        }
        catch(InvocationTargetException v3) {
            throw new RuntimeException("An exception happened in constructor of " + arg2, v3.getCause());
        }
        catch(InstantiationException v3_1) {
            throw new RuntimeException("A " + arg2 + " cannot be instantiated.", ((Throwable)v3_1));
        }
        catch(IllegalAccessException v3_2) {
            throw new RuntimeException("Failed to access " + arg2, ((Throwable)v3_2));
        }
    }
}

