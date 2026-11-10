package androidx.lifecycle.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001A\u0012\u0010\u0000\u001A\u00020\u00012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003H\u0000\"\u001C\u0010\u0004\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"isAcceptableType", "", "value", "", "ACCEPTABLE_CLASSES", "", "Ljava/lang/Class;", "lifecycle-viewmodel-savedstate"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SavedStateHandleImpl_androidKt {
    private static final List ACCEPTABLE_CLASSES;

    static {
        SavedStateHandleImpl_androidKt.ACCEPTABLE_CLASSES = ArraysKt.filterNotNull(new Class[]{Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class});
    }

    public static final boolean isAcceptableType(Object arg2) {
        if(arg2 != null) {
            List v0 = SavedStateHandleImpl_androidKt.ACCEPTABLE_CLASSES;
            if(!(v0 instanceof Collection) || !v0.isEmpty()) {
                Iterator v0_1 = ((Iterable)v0).iterator();
                do {
                    if(v0_1.hasNext()) {
                        if(!v0_1.next().isInstance(arg2)) {
                            continue;
                        }

                        return 1;
                    }

                    return 0;
                }
                while(true);

                return 1;
            }
            else {
            }

            return 0;
        }

        return 1;
    }
}

