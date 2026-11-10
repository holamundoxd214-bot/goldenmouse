package androidx.compose.foundation;

import android.content.Context;
import android.widget.EdgeEffect;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001D\u0010\u0014\u001A\u00020\u00152\u0012\u0010\u0016\u001A\u000E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\bJ\u0006\u0010\u0018\u001A\u00020\u0015J\u0006\u0010\u0019\u001A\u00020\u001AJ\u0006\u0010\u001B\u001A\u00020\u001AJ\u0006\u0010\u001C\u001A\u00020\u001AJ\u0006\u0010\u001D\u001A\u00020\u001AJ\u0006\u0010\u001E\u001A\u00020\u001AJ\u0006\u0010\u001F\u001A\u00020\u001AJ\u0006\u0010 \u001A\u00020\u001AJ\u0006\u0010!\u001A\u00020\u001AJ\u0006\u0010$\u001A\u00020\u001AJ\u0006\u0010%\u001A\u00020\u001AJ\u0006\u0010&\u001A\u00020\u001AJ\u0006\u0010\'\u001A\u00020\u001AJ\u0006\u0010)\u001A\u00020\fJ\u0006\u0010*\u001A\u00020\fJ\u0006\u0010+\u001A\u00020\fJ\u0006\u0010,\u001A\u00020\fJ\u0006\u0010-\u001A\u00020\fJ\u0006\u0010.\u001A\u00020\fJ\u0006\u0010/\u001A\u00020\fJ\u0006\u00100\u001A\u00020\fJ\u0010\u00101\u001A\u00020\f2\u0006\u00102\u001A\u000203H\u0002J\u0015\u00104\u001A\u00020\u00152\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b5\u00106R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000F\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\"\u001A\u00020\u001A*\u0004\u0018\u00010\f8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010#R\u001A\u0010(\u001A\u00020\u001A*\u0004\u0018\u00010\f8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b(\u0010#¨\u00067"}, d2={"Landroidx/compose/foundation/EdgeEffectWrapper;", "", "context", "Landroid/content/Context;", "glowColor", "", "<init>", "(Landroid/content/Context;I)V", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "topEffect", "Landroid/widget/EdgeEffect;", "bottomEffect", "leftEffect", "rightEffect", "topEffectNegation", "bottomEffectNegation", "leftEffectNegation", "rightEffectNegation", "forEachEffect", "", "action", "Lkotlin/Function1;", "finishAll", "isTopStretched", "", "isBottomStretched", "isLeftStretched", "isRightStretched", "isTopNegationStretched", "isBottomNegationStretched", "isLeftNegationStretched", "isRightNegationStretched", "isStretched", "(Landroid/widget/EdgeEffect;)Z", "isTopAnimating", "isBottomAnimating", "isLeftAnimating", "isRightAnimating", "isAnimating", "getOrCreateTopEffect", "getOrCreateBottomEffect", "getOrCreateLeftEffect", "getOrCreateRightEffect", "getOrCreateTopEffectNegation", "getOrCreateBottomEffectNegation", "getOrCreateLeftEffectNegation", "getOrCreateRightEffectNegation", "createEdgeEffect", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "updateSize", "updateSize-ozmzZPI", "(J)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class EdgeEffectWrapper {
    private EdgeEffect bottomEffect;
    private EdgeEffect bottomEffectNegation;
    private final Context context;
    private final int glowColor;
    private EdgeEffect leftEffect;
    private EdgeEffect leftEffectNegation;
    private EdgeEffect rightEffect;
    private EdgeEffect rightEffectNegation;
    private long size;
    private EdgeEffect topEffect;
    private EdgeEffect topEffectNegation;

    public EdgeEffectWrapper(Context arg1, int arg2) {
        super();
        this.context = arg1;
        this.glowColor = arg2;
        this.size = IntSize.Companion.getZero-YbymL2g();
    }

    public static final EdgeEffect access$getBottomEffect$p(EdgeEffectWrapper arg0) {
        return arg0.bottomEffect;
    }

    public static final EdgeEffect access$getLeftEffect$p(EdgeEffectWrapper arg0) {
        return arg0.leftEffect;
    }

    public static final EdgeEffect access$getRightEffect$p(EdgeEffectWrapper arg0) {
        return arg0.rightEffect;
    }

    public static final EdgeEffect access$getTopEffect$p(EdgeEffectWrapper arg0) {
        return arg0.topEffect;
    }

    private final EdgeEffect createEdgeEffect(Orientation arg7) {
        EdgeEffect v0 = EdgeEffectCompat.INSTANCE.create(this.context);
        v0.setColor(this.glowColor);
        if(!IntSize.equals-impl0(this.size, IntSize.Companion.getZero-YbymL2g())) {
            Orientation v1 = Orientation.Vertical;
            long v2 = this.size;
            int v6 = 0x20;
            long v4 = 0xFFFFFFFFL;
            if(arg7 == v1) {
                v0.setSize(((int)(v2 >> v6)), ((int)(v2 & v4)));
                return v0;
            }
            else {
                v0.setSize(((int)(v4 & v2)), ((int)(v2 >> v6)));
            }
        }

        return v0;
    }

    public final void finishAll() {
        EdgeEffect v0 = this.topEffect;
        if(v0 != null) {
            v0.finish();
        }

        v0 = this.bottomEffect;
        if(v0 != null) {
            v0.finish();
        }

        v0 = this.leftEffect;
        if(v0 != null) {
            v0.finish();
        }

        v0 = this.rightEffect;
        if(v0 != null) {
            v0.finish();
        }

        v0 = this.topEffectNegation;
        if(v0 != null) {
            v0.finish();
        }

        v0 = this.bottomEffectNegation;
        if(v0 != null) {
            v0.finish();
        }

        v0 = this.leftEffectNegation;
        if(v0 != null) {
            v0.finish();
        }

        EdgeEffect v1 = this.rightEffectNegation;
        if(v1 != null) {
            v1.finish();
        }
    }

    public final void forEachEffect(Function1 arg2) {
        EdgeEffect v0 = this.topEffect;
        if(v0 != null) {
            arg2.invoke(v0);
        }

        v0 = this.bottomEffect;
        if(v0 != null) {
            arg2.invoke(v0);
        }

        v0 = this.leftEffect;
        if(v0 != null) {
            arg2.invoke(v0);
        }

        EdgeEffect v1 = this.rightEffect;
        if(v1 != null) {
            arg2.invoke(v1);
        }
    }

    public final EdgeEffect getOrCreateBottomEffect() {
        EdgeEffect v0 = this.bottomEffect;
        if(v0 == null) {
            v0 = this.createEdgeEffect(Orientation.Vertical);
            this.bottomEffect = v0;
        }

        return v0;
    }

    public final EdgeEffect getOrCreateBottomEffectNegation() {
        EdgeEffect v0 = this.bottomEffectNegation;
        if(v0 == null) {
            v0 = this.createEdgeEffect(Orientation.Vertical);
            this.bottomEffectNegation = v0;
        }

        return v0;
    }

    public final EdgeEffect getOrCreateLeftEffect() {
        EdgeEffect v0 = this.leftEffect;
        if(v0 == null) {
            v0 = this.createEdgeEffect(Orientation.Horizontal);
            this.leftEffect = v0;
        }

        return v0;
    }

    public final EdgeEffect getOrCreateLeftEffectNegation() {
        EdgeEffect v0 = this.leftEffectNegation;
        if(v0 == null) {
            v0 = this.createEdgeEffect(Orientation.Horizontal);
            this.leftEffectNegation = v0;
        }

        return v0;
    }

    public final EdgeEffect getOrCreateRightEffect() {
        EdgeEffect v0 = this.rightEffect;
        if(v0 == null) {
            v0 = this.createEdgeEffect(Orientation.Horizontal);
            this.rightEffect = v0;
        }

        return v0;
    }

    public final EdgeEffect getOrCreateRightEffectNegation() {
        EdgeEffect v0 = this.rightEffectNegation;
        if(v0 == null) {
            v0 = this.createEdgeEffect(Orientation.Horizontal);
            this.rightEffectNegation = v0;
        }

        return v0;
    }

    public final EdgeEffect getOrCreateTopEffect() {
        EdgeEffect v0 = this.topEffect;
        if(v0 == null) {
            v0 = this.createEdgeEffect(Orientation.Vertical);
            this.topEffect = v0;
        }

        return v0;
    }

    public final EdgeEffect getOrCreateTopEffectNegation() {
        EdgeEffect v0 = this.topEffectNegation;
        if(v0 == null) {
            v0 = this.createEdgeEffect(Orientation.Vertical);
            this.topEffectNegation = v0;
        }

        return v0;
    }

    private final boolean isAnimating(EdgeEffect arg1) {
        if(arg1 == null) {
            return 0;
        }

        return arg1.isFinished() ^ 1;
    }

    public final boolean isBottomAnimating() {
        return this.isAnimating(this.bottomEffect);
    }

    public final boolean isBottomNegationStretched() {
        return this.isStretched(this.bottomEffectNegation);
    }

    public final boolean isBottomStretched() {
        return this.isStretched(this.bottomEffect);
    }

    public final boolean isLeftAnimating() {
        return this.isAnimating(this.leftEffect);
    }

    public final boolean isLeftNegationStretched() {
        return this.isStretched(this.leftEffectNegation);
    }

    public final boolean isLeftStretched() {
        return this.isStretched(this.leftEffect);
    }

    public final boolean isRightAnimating() {
        return this.isAnimating(this.rightEffect);
    }

    public final boolean isRightNegationStretched() {
        return this.isStretched(this.rightEffectNegation);
    }

    public final boolean isRightStretched() {
        return this.isStretched(this.rightEffect);
    }

    private final boolean isStretched(EdgeEffect arg2) {
        int v1 = 0;
        if(arg2 == null) {
            return 0;
        }

        if(Float.compare(EdgeEffectCompat.INSTANCE.getDistanceCompat(arg2), 0f) == 0) {
            v1 = 1;
        }

        return v1 ^ 1;
    }

    public final boolean isTopAnimating() {
        return this.isAnimating(this.topEffect);
    }

    public final boolean isTopNegationStretched() {
        return this.isStretched(this.topEffectNegation);
    }

    public final boolean isTopStretched() {
        return this.isStretched(this.topEffect);
    }

    public final void updateSize-ozmzZPI(long arg8) {
        this.size = arg8;
        EdgeEffect v0 = this.topEffect;
        long v1 = 0xFFFFFFFFL;
        int v3 = 0x20;
        if(v0 != null) {
            v0.setSize(((int)(arg8 >> v3)), ((int)(arg8 & v1)));
        }

        v0 = this.bottomEffect;
        if(v0 != null) {
            v0.setSize(((int)(arg8 >> v3)), ((int)(arg8 & v1)));
        }

        v0 = this.leftEffect;
        if(v0 != null) {
            v0.setSize(((int)(arg8 & v1)), ((int)(arg8 >> v3)));
        }

        v0 = this.rightEffect;
        if(v0 != null) {
            v0.setSize(((int)(arg8 & v1)), ((int)(arg8 >> v3)));
        }

        v0 = this.topEffectNegation;
        if(v0 != null) {
            v0.setSize(((int)(arg8 >> v3)), ((int)(arg8 & v1)));
        }

        v0 = this.bottomEffectNegation;
        if(v0 != null) {
            v0.setSize(((int)(arg8 >> v3)), ((int)(arg8 & v1)));
        }

        v0 = this.leftEffectNegation;
        if(v0 != null) {
            v0.setSize(((int)(arg8 & v1)), ((int)(arg8 >> v3)));
        }

        EdgeEffect v7 = this.rightEffectNegation;
        if(v7 != null) {
            v7.setSize(((int)(arg8 & v1)), ((int)(arg8 >> v3)));
        }
    }
}

