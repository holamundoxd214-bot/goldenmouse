package androidx.compose.material3.internal;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u00128\b\u0002\u0010\b\u001A2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u000E\u0012\u0004\u0012\u00020\u000F0\t¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010&\u001A\u00020\'2\u0006\u0010\r\u001A\u00020\n2\u0006\u0010(\u001A\u00020)2\u0006\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020)H\u0016¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001A\u00020\u0003HÆ\u0003¢\u0006\u0004\b0\u0010\u0013J\t\u00101\u001A\u00020\u0005HÆ\u0003J\t\u00102\u001A\u00020\u0007HÆ\u0003J9\u00103\u001A2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u000E\u0012\u0004\u0012\u00020\u000F0\tHÆ\u0003Jh\u00104\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u000728\b\u0002\u0010\b\u001A2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u000E\u0012\u0004\u0012\u00020\u000F0\tHÆ\u0001¢\u0006\u0004\b5\u00106J\u0013\u00107\u001A\u0002082\b\u00109\u001A\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001A\u00020\u0007HÖ\u0001J\t\u0010<\u001A\u00020=HÖ\u0001R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0014\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018RA\u0010\b\u001A2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000B\u0012\b\b\f\u0012\u0004\b\b(\u000E\u0012\u0004\u0012\u00020\u000F0\t¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u000E\u0010\u001B\u001A\u00020\u001CX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u001CX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u001CX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\u001CX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2={"Landroidx/compose/material3/internal/DropdownMenuPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "contentOffset", "Landroidx/compose/ui/unit/DpOffset;", "density", "Landroidx/compose/ui/unit/Density;", "verticalMargin", "", "onPositionCalculated", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntRect;", "Lkotlin/ParameterName;", "name", "anchorBounds", "menuBounds", "", "<init>", "(JLandroidx/compose/ui/unit/Density;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContentOffset-RKDOV3M", "()J", "J", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getVerticalMargin", "()I", "getOnPositionCalculated", "()Lkotlin/jvm/functions/Function2;", "startToAnchorStart", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "endToAnchorEnd", "leftToWindowLeft", "rightToWindowRight", "topToAnchorBottom", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "bottomToAnchorTop", "centerToAnchorTop", "topToWindowTop", "bottomToWindowBottom", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "component1", "component1-RKDOV3M", "component2", "component3", "component4", "copy", "copy-uVxBXkw", "(JLandroidx/compose/ui/unit/Density;ILkotlin/jvm/functions/Function2;)Landroidx/compose/material3/internal/DropdownMenuPositionProvider;", "equals", "", "other", "", "hashCode", "toString", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DropdownMenuPositionProvider implements PopupPositionProvider {
    public static final int $stable;
    private final Vertical bottomToAnchorTop;
    private final Vertical bottomToWindowBottom;
    private final Vertical centerToAnchorTop;
    private final long contentOffset;
    private final Density density;
    private final Horizontal endToAnchorEnd;
    private final Horizontal leftToWindowLeft;
    private final Function2 onPositionCalculated;
    private final Horizontal rightToWindowRight;
    private final Horizontal startToAnchorStart;
    private final Vertical topToAnchorBottom;
    private final Vertical topToWindowTop;
    private final int verticalMargin;

    static {
    }

    public DropdownMenuPositionProvider(long arg8, Density arg10, int arg11, Function2 arg12, int arg13, DefaultConstructorMarker arg14) {
        DropdownMenuPositionProvider$$ExternalSyntheticLambda0 v12;
        if((arg13 & 4) != 0) {
            arg11 = arg10.roundToPx-0680j_4(MenuKt.getMenuVerticalMargin());
        }

        int v4 = arg11;
        if((arg13 & 8) != 0) {
            v12 = new DropdownMenuPositionProvider$$ExternalSyntheticLambda0();
        }

        this(arg8, arg10, v4, ((Function2)v12), null);
    }

    private DropdownMenuPositionProvider(long arg2, Density arg4, int arg5, Function2 arg6) {
        super();
        this.contentOffset = arg2;
        this.density = arg4;
        this.verticalMargin = arg5;
        this.onPositionCalculated = arg6;
        int v6 = arg4.roundToPx-0680j_4(DpOffset.getX-D9Ej5fM(arg2));
        this.startToAnchorStart = MenuPosition.INSTANCE.startToAnchorStart(v6);
        this.endToAnchorEnd = MenuPosition.INSTANCE.endToAnchorEnd(v6);
        this.leftToWindowLeft = MenuPosition.INSTANCE.leftToWindowLeft(0);
        this.rightToWindowRight = MenuPosition.INSTANCE.rightToWindowRight(0);
        int v2 = arg4.roundToPx-0680j_4(DpOffset.getY-D9Ej5fM(arg2));
        this.topToAnchorBottom = MenuPosition.INSTANCE.topToAnchorBottom(v2);
        this.bottomToAnchorTop = MenuPosition.INSTANCE.bottomToAnchorTop(v2);
        this.centerToAnchorTop = MenuPosition.INSTANCE.centerToAnchorTop(v2);
        this.topToWindowTop = MenuPosition.INSTANCE.topToWindowTop(arg5);
        this.bottomToWindowBottom = MenuPosition.INSTANCE.bottomToWindowBottom(arg5);
    }

    public DropdownMenuPositionProvider(long arg1, Density arg3, int arg4, Function2 arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg3, arg4, arg5);
    }

    static final Unit _init_$lambda$1(IntRect arg0, IntRect arg1) {
        return Unit.INSTANCE;
    }

    public long calculatePosition-llwVHH4(IntRect arg19, long arg20, LayoutDirection arg22, long arg23) {
        IntRect v2_2;
        long v3;
        int v17;
        int v16;
        DropdownMenuPositionProvider v0 = this;
        long v7 = arg23;
        int v9 = 3;
        Horizontal[] v1 = new Horizontal[v9];
        v1[0] = v0.startToAnchorStart;
        v1[1] = v0.endToAnchorEnd;
        int v12 = 0x20;
        int v13 = ((int)(arg20 >> v12));
        Horizontal v2 = IntOffset.getX-impl(arg19.getCenter-nOcc-ac()) < v13 / 2 ? v0.leftToWindowLeft : v0.rightToWindowRight;
        int v14 = 2;
        v1[v14] = v2;
        List v15 = CollectionsKt.listOf(((Object[])v1));
        int v1_1 = v15.size();
        int v2_1 = 0;
        while(true) {
            if(v2_1 < v1_1) {
                int v5 = ((int)(v7 >> v12));
                v16 = v1_1;
                Object v1_2 = v15.get(v2_1);
                v17 = v9;
                v3 = arg20;
                v9 = v2_1;
                v2_2 = arg19;
                v1_1 = ((Horizontal)v1_2).position-95KtPRI(v2_2, v3, v5, arg22);
                if(v9 != CollectionsKt.getLastIndex(v15)) {
                    if(v1_1 >= 0 && v5 + v1_1 <= v13) {
                        goto label_53;
                    }

                    v2_1 = v9 + 1;
                    v1_1 = v16;
                    v9 = v17;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_53;
        }

        v2_2 = arg19;
        v3 = arg20;
        v17 = v9;
        v1_1 = 0;
    label_53:
        Vertical[] v5_1 = new Vertical[4];
        v5_1[0] = v0.topToAnchorBottom;
        v5_1[1] = v0.bottomToAnchorTop;
        v5_1[v14] = v0.centerToAnchorTop;
        long v13_1 = 0xFFFFFFFFL;
        int v10 = ((int)(v3 & v13_1));
        Vertical v6 = IntOffset.getY-impl(v2_2.getCenter-nOcc-ac()) < v10 / 2 ? v0.topToWindowTop : v0.bottomToWindowBottom;
        v5_1[v17] = v6;
        List v5_2 = CollectionsKt.listOf(((Object[])v5_1));
        int v6_1 = v5_2.size();
        int v11 = 0;
        while(true) {
            if(v11 < v6_1) {
                v16 = v10;
                v9 = ((int)(v7 & v13_1));
                v10 = v5_2.get(v11).position-JVtK1S4(v2_2, v3, v9);
                if(v11 != CollectionsKt.getLastIndex(v5_2)) {
                    int v15_1 = v0.verticalMargin;
                    if(v10 >= v15_1 && v9 + v10 <= v16 - v15_1) {
                        goto label_94;
                    }

                    ++v11;
                    v10 = v16;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_94;
        }

        v10 = 0;
    label_94:
        v3 = IntOffset.constructor-impl((((long)v1_1)) << v12 | (((long)v10)) & v13_1);
        v0.onPositionCalculated.invoke(v2_2, IntRectKt.IntRect-VbeCjmY(v3, v7));
        return v3;
    }

    public final long component1-RKDOV3M() {
        return this.contentOffset;
    }

    public final Density component2() {
        return this.density;
    }

    public final int component3() {
        return this.verticalMargin;
    }

    public final Function2 component4() {
        return this.onPositionCalculated;
    }

    public final DropdownMenuPositionProvider copy-uVxBXkw(long arg8, Density arg10, int arg11, Function2 arg12) {
        return new DropdownMenuPositionProvider(arg8, arg10, arg11, arg12, null);
    }

    public static DropdownMenuPositionProvider copy-uVxBXkw$default(DropdownMenuPositionProvider arg6, long arg7, Density arg9, int arg10, Function2 arg11, int arg12, Object arg13) {
        if((arg12 & 1) != 0) {
            arg7 = arg6.contentOffset;
        }

        long v1 = arg7;
        if((arg12 & 2) != 0) {
            arg9 = arg6.density;
        }

        Density v3 = arg9;
        if((arg12 & 4) != 0) {
            arg10 = arg6.verticalMargin;
        }

        int v4 = arg10;
        if((arg12 & 8) != 0) {
            arg11 = arg6.onPositionCalculated;
        }

        return arg6.copy-uVxBXkw(v1, v3, v4, arg11);
    }

    public boolean equals(Object arg8) {
        if(this == (((DropdownMenuPositionProvider)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof DropdownMenuPositionProvider)) {
            return 0;
        }

        if(!DpOffset.equals-impl0(this.contentOffset, ((DropdownMenuPositionProvider)arg8).contentOffset)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.density, ((DropdownMenuPositionProvider)arg8).density)) {
            return 0;
        }

        if(this.verticalMargin != ((DropdownMenuPositionProvider)arg8).verticalMargin) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.onPositionCalculated, ((DropdownMenuPositionProvider)arg8).onPositionCalculated)) {
            return 0;
        }

        return 1;
    }

    public final long getContentOffset-RKDOV3M() {
        return this.contentOffset;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final Function2 getOnPositionCalculated() {
        return this.onPositionCalculated;
    }

    public final int getVerticalMargin() {
        return this.verticalMargin;
    }

    public int hashCode() {
        return ((DpOffset.hashCode-impl(this.contentOffset) * 0x1F + this.density.hashCode()) * 0x1F + Integer.hashCode(this.verticalMargin)) * 0x1F + this.onPositionCalculated.hashCode();
    }

    public String toString() {
        return "DropdownMenuPositionProvider(contentOffset=" + DpOffset.toString-impl(this.contentOffset) + ", density=" + this.density + ", verticalMargin=" + this.verticalMargin + ", onPositionCalculated=" + this.onPositionCalculated + ')';
    }
}

