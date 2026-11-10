package androidx.compose.foundation;

import android.content.Context;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\b\u0010\r\u001A\u00020\u000EH\u0016J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001A\u00020\u0014H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollFactory;", "Landroidx/compose/foundation/OverscrollFactory;", "context", "Landroid/content/Context;", "density", "Landroidx/compose/ui/unit/Density;", "glowColor", "Landroidx/compose/ui/graphics/Color;", "glowDrawPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(Landroid/content/Context;Landroidx/compose/ui/unit/Density;JLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "createOverscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "equals", "", "other", "", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class AndroidEdgeEffectOverscrollFactory implements OverscrollFactory {
    private final Context context;
    private final Density density;
    private final long glowColor;
    private final PaddingValues glowDrawPadding;

    private AndroidEdgeEffectOverscrollFactory(Context arg1, Density arg2, long arg3, PaddingValues arg5) {
        super();
        this.context = arg1;
        this.density = arg2;
        this.glowColor = arg3;
        this.glowDrawPadding = arg5;
    }

    public AndroidEdgeEffectOverscrollFactory(Context arg8, Density arg9, long arg10, PaddingValues arg12, int arg13, DefaultConstructorMarker arg14) {
        if((arg13 & 4) != 0) {
            arg10 = AndroidOverscroll_androidKt.access$getDefaultGlowColor$p();
        }

        long v3 = arg10;
        if((arg13 & 8) != 0) {
            arg12 = AndroidOverscroll_androidKt.access$getDefaultGlowPaddingValues$p();
        }

        this(arg8, arg9, v3, arg12, null);
    }

    public AndroidEdgeEffectOverscrollFactory(Context arg1, Density arg2, long arg3, PaddingValues arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg5);
    }

    public OverscrollEffect createOverscrollEffect() {
        return new AndroidEdgeEffectOverscrollEffect(this.context, this.density, this.glowColor, this.glowDrawPadding, null);
    }

    public boolean equals(Object arg8) {
        if(this == (((AndroidEdgeEffectOverscrollFactory)arg8))) {
            return 1;
        }

        Class v1 = this.getClass();
        if(arg8 != null) {
            Class v2 = arg8.getClass();
        }
        else {
            Object v2_1 = null;
        }

        if(!Intrinsics.areEqual(v1, v2_1)) {
            return 0;
        }

        Intrinsics.checkNotNull(arg8, "null cannot be cast to non-null type androidx.compose.foundation.AndroidEdgeEffectOverscrollFactory");
        if(!Intrinsics.areEqual(this.context, ((AndroidEdgeEffectOverscrollFactory)arg8).context)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.density, ((AndroidEdgeEffectOverscrollFactory)arg8).density)) {
            return 0;
        }

        if(!Color.equals-impl0(this.glowColor, ((AndroidEdgeEffectOverscrollFactory)arg8).glowColor)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.glowDrawPadding, ((AndroidEdgeEffectOverscrollFactory)arg8).glowDrawPadding)) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return ((this.context.hashCode() * 0x1F + this.density.hashCode()) * 0x1F + Color.hashCode-impl(this.glowColor)) * 0x1F + this.glowDrawPadding.hashCode();
    }
}

