package androidx.core.content.res;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\b\u0001\u0010\b\u001A\u00020\tH\u0007¨\u0006\n"}, d2={"Landroidx/core/content/res/TypedArrayApi26ImplKt;", "", "<init>", "()V", "getFont", "Landroid/graphics/Typeface;", "typedArray", "Landroid/content/res/TypedArray;", "index", "", "core"}, k=1, mv={2, 1, 0}, xi=0x30) final class TypedArrayApi26ImplKt {
    public static final TypedArrayApi26ImplKt INSTANCE;

    static {
        TypedArrayApi26ImplKt.INSTANCE = new TypedArrayApi26ImplKt();
    }

    private TypedArrayApi26ImplKt() {
        super();
    }

    @JvmStatic public static final Typeface getFont(TypedArray arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "typedArray");
        Typeface v1 = arg1.getFont(arg2);
        Intrinsics.checkNotNull(v1);
        return v1;
    }
}

