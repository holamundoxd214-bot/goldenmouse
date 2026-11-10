package androidx.core.os;

import android.os.Parcel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A<\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0012\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00010\u0004H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0006"}, d2={"use", "T", "Landroid/os/Parcel;", "block", "Lkotlin/Function1;", "(Landroid/os/Parcel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ParcelKt {
    public static final Object use(Parcel arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "block");
        Object v2 = arg2.invoke(arg1);
        arg1.recycle();
        return v2;
    }
}

