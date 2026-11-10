package androidx.compose.material3.carousel;

import androidx.compose.ui.util.MathHelpersKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A\b\u0010\u0000\u001A\u00020\u0001H\u0000\u001A@\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00072\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\t¢\u0006\u0002\b\fH\u0000¢\u0006\u0004\b\r\u0010\u000E\u001AA\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00042\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\t¢\u0006\u0002\b\fH\u0000\u001A \u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u0004H\u0000\u001A \u0010\u0012\u001A\u00020\u00012\u0006\u0010\u0017\u001A\u00020\u00012\u0006\u0010\u0018\u001A\u00020\u00012\u0006\u0010\u0016\u001A\u00020\u0004H\u0000¨\u0006\u0019"}, d2={"emptyKeylineList", "Landroidx/compose/material3/carousel/KeylineList;", "keylineListOf", "carouselMainAxisSize", "", "itemSpacing", "carouselAlignment", "Landroidx/compose/material3/carousel/CarouselAlignment;", "keylines", "Lkotlin/Function1;", "Landroidx/compose/material3/carousel/KeylineListScope;", "", "Lkotlin/ExtensionFunctionType;", "keylineListOf-WNYm7Xg", "(FFILkotlin/jvm/functions/Function1;)Landroidx/compose/material3/carousel/KeylineList;", "pivotIndex", "", "pivotOffset", "lerp", "Landroidx/compose/material3/carousel/Keyline;", "start", "end", "fraction", "from", "to", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class KeylineListKt {
    public static final KeylineList emptyKeylineList() {
        return KeylineList.Companion.getEmpty();
    }

    public static final KeylineList keylineListOf(float arg1, float arg2, int arg3, float arg4, Function1 arg5) {
        KeylineListScopeImpl v0 = new KeylineListScopeImpl();
        arg5.invoke(v0);
        return v0.createWithPivot(arg1, arg2, arg3, arg4);
    }

    public static final KeylineList keylineListOf-WNYm7Xg(float arg1, float arg2, int arg3, Function1 arg4) {
        KeylineListScopeImpl v0 = new KeylineListScopeImpl();
        arg4.invoke(v0);
        return v0.createWithAlignment-waks0t8(arg1, arg2, arg3);
    }

    public static final Keyline lerp(Keyline arg9, Keyline arg10, float arg11) {
        float v1 = MathHelpersKt.lerp(arg9.getSize(), arg10.getSize(), arg11);
        float v2 = MathHelpersKt.lerp(arg9.getOffset(), arg10.getOffset(), arg11);
        float v3 = MathHelpersKt.lerp(arg9.getUnadjustedOffset(), arg10.getUnadjustedOffset(), arg11);
        int v4 = Float.compare(arg11, 0.5f);
        boolean v5 = v4 < 0 ? arg9.isFocal() : arg10.isFocal();
        boolean v6 = v4 < 0 ? arg9.isAnchor() : arg10.isAnchor();
        boolean v4_1 = v4 < 0 ? arg9.isPivot() : arg10.isPivot();
        return new Keyline(v1, v2, v3, v5, v6, v4_1, MathHelpersKt.lerp(arg9.getCutoff(), arg10.getCutoff(), arg11));
    }

    public static final KeylineList lerp(KeylineList arg6, KeylineList arg7, float arg8) {
        ArrayList v0 = new ArrayList(((List)arg6).size());
        int v1 = arg6.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0.add(KeylineListKt.lerp(((List)arg6).get(v2), arg7.get(v2), arg8));
        }

        return new KeylineList(((List)v0));
    }
}

