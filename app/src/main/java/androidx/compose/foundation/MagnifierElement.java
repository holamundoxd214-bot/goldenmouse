package androidx.compose.foundation;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0099\u0001\u0012\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007\u0012\u001B\b\u0002\u0010\b\u001A\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\b\u0007\u0012\u0016\b\u0002\u0010\t\u001A\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\u0004\u0012\b\b\u0002\u0010\f\u001A\u00020\r\u0012\b\b\u0002\u0010\u000E\u001A\u00020\u000F\u0012\b\b\u0002\u0010\u0010\u001A\u00020\n\u0012\b\b\u0002\u0010\u0011\u001A\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001A\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001A\u00020\u000F\u0012\u0006\u0010\u0015\u001A\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u001B\u001A\u00020\u0002H\u0016J\u0010\u0010\u001C\u001A\u00020\u000B2\u0006\u0010\u001D\u001A\u00020\u0002H\u0016J\u0013\u0010\u001E\u001A\u00020\u000F2\b\u0010\u001F\u001A\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001A\u00020\"H\u0016J\f\u0010#\u001A\u00020\u000B*\u00020$H\u0016R\u001F\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\b\u001A\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\t\u001A\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0010\u0010\u0011\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001AR\u0010\u0010\u0013\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001AR\u000E\u0010\u0014\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2={"Landroidx/compose/foundation/MagnifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/MagnifierNode;", "sourceCenter", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ExtensionFunctionType;", "magnifierCenter", "onSizeChanged", "Landroidx/compose/ui/unit/DpSize;", "", "zoom", "", "useTextDefault", "", "size", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clippingEnabled", "platformMagnifierFactory", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "F", "create", "update", "node", "equals", "other", "", "hashCode", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MagnifierElement extends ModifierNodeElement {
    public static final int $stable;
    private final boolean clippingEnabled;
    private final float cornerRadius;
    private final float elevation;
    private final Function1 magnifierCenter;
    private final Function1 onSizeChanged;
    private final PlatformMagnifierFactory platformMagnifierFactory;
    private final long size;
    private final Function1 sourceCenter;
    private final boolean useTextDefault;
    private final float zoom;

    static {
    }

    private MagnifierElement(Function1 arg1, Function1 arg2, Function1 arg3, float arg4, boolean arg5, long arg6, float arg8, float arg9, boolean arg10, PlatformMagnifierFactory arg11) {
        super();
        this.sourceCenter = arg1;
        this.magnifierCenter = arg2;
        this.onSizeChanged = arg3;
        this.zoom = arg4;
        this.useTextDefault = arg5;
        this.size = arg6;
        this.cornerRadius = arg8;
        this.elevation = arg9;
        this.clippingEnabled = arg10;
        this.platformMagnifierFactory = arg11;
    }

    public MagnifierElement(Function1 arg2, Function1 arg3, Function1 arg4, float arg5, boolean arg6, long arg7, float arg9, float arg10, boolean arg11, PlatformMagnifierFactory arg12, int arg13, DefaultConstructorMarker arg14) {
        Function1 v0 = null;
        if((arg13 & 2) != 0) {
            arg3 = v0;
        }

        if((arg13 & 4) != 0) {
            arg4 = v0;
        }

        if((arg13 & 8) != 0) {
            arg5 = NaNf;
        }

        if((arg13 & 0x20) != 0) {
            arg7 = DpSize.Companion.getUnspecified-MYxV2XQ();
        }

        if((arg13 & 0x40) != 0) {
            arg9 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        if((arg13 & 0x80) != 0) {
            arg10 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        this(arg2, arg3, arg4, arg5, false, arg7, arg9, arg10, true, arg12, null);
    }

    public MagnifierElement(Function1 arg1, Function1 arg2, Function1 arg3, float arg4, boolean arg5, long arg6, float arg8, float arg9, boolean arg10, PlatformMagnifierFactory arg11, DefaultConstructorMarker arg12) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg8, arg9, arg10, arg11);
    }

    public MagnifierNode create() {
        return new MagnifierNode(this.sourceCenter, this.magnifierCenter, this.onSizeChanged, this.zoom, this.useTextDefault, this.size, this.cornerRadius, this.elevation, this.clippingEnabled, this.platformMagnifierFactory, null);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg8) {
        if(this == (((MagnifierElement)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof MagnifierElement)) {
            return 0;
        }

        if(this.sourceCenter != ((MagnifierElement)arg8).sourceCenter) {
            return 0;
        }

        if(this.magnifierCenter != ((MagnifierElement)arg8).magnifierCenter) {
            return 0;
        }

        if(this.zoom == ((MagnifierElement)arg8).zoom) {
            if(this.useTextDefault != ((MagnifierElement)arg8).useTextDefault) {
                return 0;
            }

            if(!DpSize.equals-impl0(this.size, ((MagnifierElement)arg8).size)) {
                return 0;
            }

            if(!Dp.equals-impl0(this.cornerRadius, ((MagnifierElement)arg8).cornerRadius)) {
                return 0;
            }

            if(!Dp.equals-impl0(this.elevation, ((MagnifierElement)arg8).elevation)) {
                return 0;
            }

            if(this.clippingEnabled != ((MagnifierElement)arg8).clippingEnabled) {
                return 0;
            }

            if(this.onSizeChanged != ((MagnifierElement)arg8).onSizeChanged) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.platformMagnifierFactory, ((MagnifierElement)arg8).platformMagnifierFactory)) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    public int hashCode() {
        int v0 = this.sourceCenter.hashCode() * 0x1F;
        Function1 v1 = this.magnifierCenter;
        int v2 = 0;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        v0 = (((((((v0 + v1_1) * 0x1F + Float.hashCode(this.zoom)) * 0x1F + Boolean.hashCode(this.useTextDefault)) * 0x1F + DpSize.hashCode-impl(this.size)) * 0x1F + Dp.hashCode-impl(this.cornerRadius)) * 0x1F + Dp.hashCode-impl(this.elevation)) * 0x1F + Boolean.hashCode(this.clippingEnabled)) * 0x1F;
        v1 = this.onSizeChanged;
        if(v1 != null) {
            v2 = v1.hashCode();
        }

        return (v0 + v2) * 0x1F + this.platformMagnifierFactory.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("magnifier");
        arg4.getProperties().set("sourceCenter", this.sourceCenter);
        arg4.getProperties().set("magnifierCenter", this.magnifierCenter);
        arg4.getProperties().set("zoom", Float.valueOf(this.zoom));
        arg4.getProperties().set("size", DpSize.box-impl(this.size));
        arg4.getProperties().set("cornerRadius", Dp.box-impl(this.cornerRadius));
        arg4.getProperties().set("elevation", Dp.box-impl(this.elevation));
        arg4.getProperties().set("clippingEnabled", Boolean.valueOf(this.clippingEnabled));
    }

    public void update(MagnifierNode arg13) {
        arg13.update-5F03MCQ(this.sourceCenter, this.magnifierCenter, this.zoom, this.useTextDefault, this.size, this.cornerRadius, this.elevation, this.clippingEnabled, this.onSizeChanged, this.platformMagnifierFactory);
    }

    public void update(Node arg1) {
        this.update(((MagnifierNode)arg1));
    }
}

