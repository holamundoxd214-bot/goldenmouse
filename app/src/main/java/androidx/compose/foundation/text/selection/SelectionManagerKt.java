package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.text.CommonContextMenuAreaKt$TextItem$1;
import androidx.compose.foundation.text.CommonContextMenuAreaKt$TextItem$2;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\u001A\u001E\u0010\u0000\u001A\u0004\u0018\u00010\u00012\b\u0010\u0002\u001A\u0004\u0018\u00010\u00012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0001H\u0000\u001A%\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b*\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0000\u001A\u001E\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00100\u000F\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u000FH\u0002\u001A*\u0010\u0011\u001A\u00020\r2\u0018\u0010\u0012\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u00130\u000F2\u0006\u0010\u0015\u001A\u00020\u0016H\u0001\u001A\u001F\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\t2\u0006\u0010\u001A\u001A\u00020\u001BH\u0000¢\u0006\u0004\b\u001C\u0010\u001D\u001A\'\u0010\u001E\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\t2\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001F\u001A\u00020 H\u0002¢\u0006\u0004\b!\u0010\"\u001A\f\u0010#\u001A\u00020\r*\u00020\u0016H\u0000\u001A\u001B\u0010$\u001A\u00020%*\u00020\r2\u0006\u0010&\u001A\u00020\u0018H\u0000¢\u0006\u0004\b\'\u0010(\"\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2={"merge", "Landroidx/compose/foundation/text/selection/Selection;", "lhs", "rhs", "contextMenuBuilder", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/foundation/text/selection/SelectionManager;", "state", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "invertedInfiniteRect", "Landroidx/compose/ui/geometry/Rect;", "firstAndLast", "", "T", "getSelectedRegionRect", "selectableSubSelectionPairs", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/selection/Selectable;", "containerCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "manager", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-O0kMr_c", "(Landroidx/compose/foundation/text/selection/SelectionManager;J)J", "getMagnifierCenter", "anchor", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "getMagnifierCenter-JVtK1S4", "(Landroidx/compose/foundation/text/selection/SelectionManager;JLandroidx/compose/foundation/text/selection/Selection$AnchorInfo;)J", "visibleBounds", "containsInclusive", "", "offset", "containsInclusive-Uv8p0NA", "(Landroidx/compose/ui/geometry/Rect;J)Z", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SelectionManagerKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Handle.values().length];
            try {
                v0[Handle.SelectionStart.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[Handle.SelectionEnd.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[Handle.Cursor.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }
    }

    private static final Rect invertedInfiniteRect;

    public static Unit $r8$lambda$D9dP50ChNMff9SDFc86OTiXYFgk(SelectionManager arg0) {
        return SelectionManagerKt.contextMenuBuilder$lambda$0$1(arg0);
    }

    public static Unit $r8$lambda$sUkbeiMEC9UDFsJu1gU0zezWsfg(SelectionManager arg0) {
        return SelectionManagerKt.contextMenuBuilder$lambda$0$0(arg0);
    }

    static {
        SelectionManagerKt.invertedInfiniteRect = new Rect(Infinityf, Infinityf, -Infinityf, -Infinityf);
    }

    public static final List access$firstAndLast(List arg0) {
        return SelectionManagerKt.firstAndLast(arg0);
    }

    public static final Rect access$getInvertedInfiniteRect$p() {
        return SelectionManagerKt.invertedInfiniteRect;
    }

    public static final long calculateSelectionMagnifierCenterAndroid-O0kMr_c(SelectionManager arg4, long arg5) {
        Selection v0 = arg4.getSelection();
        if(v0 == null) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }

        Handle v1 = arg4.getDraggingHandle();
        int v2 = -1;
        int v1_1 = v1 == null ? v2 : WhenMappings.$EnumSwitchMapping$0[v1.ordinal()];
        if(v1_1 != v2) {
            if(v1_1 != 1) {
                if(v1_1 != 2) {
                    if(v1_1 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }

                    throw new IllegalStateException("SelectionContainer does not support cursor".toString());
                }

                return SelectionManagerKt.getMagnifierCenter-JVtK1S4(arg4, arg5, v0.getEnd());
            }

            return SelectionManagerKt.getMagnifierCenter-JVtK1S4(arg4, arg5, v0.getStart());
        }

        return Offset.Companion.getUnspecified-F1C5BW0();
    }

    public static final boolean containsInclusive-Uv8p0NA(Rect arg4, long arg5) {
        float v0 = arg4.getLeft();
        float v1 = arg4.getRight();
        float v2 = Float.intBitsToFloat(((int)(arg5 >> 0x20)));
        if(v0 <= v2 && v2 <= v1) {
            v0 = arg4.getTop();
            float v4 = arg4.getBottom();
            float v5 = Float.intBitsToFloat(((int)(arg5 & 0xFFFFFFFFL)));
            if(v0 <= v5 && v5 <= v4) {
                return 1;
            }
        }

        return 0;
    }

    public static final Function1 contextMenuBuilder(SelectionManager arg1, ContextMenuState arg2) {
        return new SelectionManagerKt$$ExternalSyntheticLambda0(arg1, arg2);
    }

    static final Unit contextMenuBuilder$lambda$0(SelectionManager arg5, ContextMenuState arg6, ContextMenuScope arg7) {
        Unit[] v0 = new Unit[2];
        SelectionManagerKt.contextMenuBuilder$lambda$0$selectionItem(arg7, arg6, TextContextMenuItems.Copy, arg5.isNonEmptySelection$foundation(), new SelectionManagerKt$$ExternalSyntheticLambda1(arg5));
        v0[0] = Unit.INSTANCE;
        SelectionManagerKt.contextMenuBuilder$lambda$0$selectionItem(arg7, arg6, TextContextMenuItems.SelectAll, arg5.isEntireContainerSelected$foundation() ^ 1, new SelectionManagerKt$$ExternalSyntheticLambda2(arg5));
        v0[1] = Unit.INSTANCE;
        CollectionsKt.listOf(((Object[])v0));
        return Unit.INSTANCE;
    }

    private static final Unit contextMenuBuilder$lambda$0$0(SelectionManager arg0) {
        arg0.copy$foundation();
        return Unit.INSTANCE;
    }

    private static final Unit contextMenuBuilder$lambda$0$1(SelectionManager arg0) {
        arg0.selectAll$foundation();
        return Unit.INSTANCE;
    }

    private static final void contextMenuBuilder$lambda$0$selectionItem(ContextMenuScope arg8, ContextMenuState arg9, TextContextMenuItems arg10, boolean arg11, Function0 arg12) {
        if(arg11) {
            ContextMenuScope.item$default(arg8, new CommonContextMenuAreaKt$TextItem$1(arg10), null, false, null, new CommonContextMenuAreaKt$TextItem$2(arg12, arg9), 14, null);
        }
    }

    private static final List firstAndLast(List arg2) {
        int v0 = arg2.size();
        if(v0 != 0 && v0 != 1) {
            arg2 = CollectionsKt.listOf(new Object[]{CollectionsKt.first(arg2), CollectionsKt.last(arg2)});
        }

        return arg2;
    }

    private static final long getMagnifierCenter-JVtK1S4(SelectionManager arg8, long arg9, AnchorInfo arg11) {
        float v4_1;
        Selectable v0 = arg8.getAnchorSelectable$foundation(arg11);
        if(v0 == null) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }

        LayoutCoordinates v1 = arg8.getContainerLayoutCoordinates();
        if(v1 == null) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }

        LayoutCoordinates v2 = v0.getLayoutCoordinates();
        if(v2 == null) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }

        int v11 = arg11.getOffset();
        if(v11 > v0.getLastVisibleOffset()) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }

        Offset v8 = arg8.getCurrentDragPosition-_m7T9-E();
        Intrinsics.checkNotNull(v8);
        long v3 = v2.localPositionOf-R5De75A(v1, v8.unbox-impl());
        int v8_1 = 0x20;
        float v3_1 = Float.intBitsToFloat(((int)(v3 >> v8_1)));
        long v4 = v0.getRangeOfLineContaining--jx7JFs(v11);
        if(TextRange.getCollapsed-impl(v4)) {
            v4_1 = v0.getLineLeft(v11);
        }
        else {
            float v6 = v0.getLineLeft(TextRange.getStart-impl(v4));
            v4_1 = v0.getLineRight(TextRange.getEnd-impl(v4) - 1);
            v4_1 = RangesKt.coerceIn(v3_1, Math.min(v6, v4_1), Math.max(v6, v4_1));
        }

        float v5 = -1f;
        if(v4_1 == v5) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }

        if(!IntSize.equals-impl0(arg9, IntSize.Companion.getZero-YbymL2g()) && Math.abs(v3_1 - v4_1) > (((float)((((int)(arg9 >> v8_1))) / 2)))) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }

        float v9 = v0.getCenterYForOffset(v11);
        if(v9 == v5) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }

        return v1.localPositionOf-R5De75A(v2, Offset.constructor-impl((((long)Float.floatToRawIntBits(v4_1))) << v8_1 | 0xFFFFFFFFL & (((long)Float.floatToRawIntBits(v9)))));
    }

    public static final Rect getSelectedRegionRect(List arg18, LayoutCoordinates arg19) {
        int[] v9_2;
        List v0 = arg18;
        if(v0.isEmpty()) {
            return SelectionManagerKt.invertedInfiniteRect;
        }

        Rect v2 = SelectionManagerKt.invertedInfiniteRect;
        float v3 = v2.component1();
        float v4 = v2.component2();
        float v5 = v2.component3();
        float v2_1 = v2.component4();
        int v6 = v0.size();
        int v7 = 0;
        int v8 = 0;
        while(v8 < v6) {
            Object v9 = v0.get(v8);
            Object v10 = ((Pair)v9).component1();
            v9 = ((Pair)v9).component2();
            int v11 = ((Selection)v9).getStart().getOffset();
            int v9_1 = ((Selection)v9).getEnd().getOffset();
            if(v11 != v9_1) {
                LayoutCoordinates v12 = ((Selectable)v10).getLayoutCoordinates();
                if(v12 == null) {
                }
                else {
                    int v13 = Math.min(v11, v9_1);
                    v9_1 = Math.max(v11, v9_1) - 1;
                    if(v13 == v9_1) {
                        v9_2 = new int[1];
                        v9_2[v7] = v13;
                    }
                    else {
                        int[] v14 = new int[2];
                        v14[v7] = v13;
                        v14[1] = v9_1;
                        v9_2 = v14;
                    }

                    Rect v11_1 = SelectionManagerKt.invertedInfiniteRect;
                    float v13_1 = v11_1.component1();
                    float v14_1 = v11_1.component2();
                    float v15 = v11_1.component3();
                    float v11_2 = v11_1.component4();
                    v7 = v9_2.length;
                    int v0_1;
                    for(v0_1 = 0; v0_1 < v7; ++v0_1) {
                        Rect v17 = ((Selectable)v10).getBoundingBox(v9_2[v0_1]);
                        v13_1 = Math.min(v13_1, v17.getLeft());
                        v14_1 = Math.min(v14_1, v17.getTop());
                        v15 = Math.max(v15, v17.getRight());
                        v11_2 = Math.max(v11_2, v17.getBottom());
                    }

                    long v9_3 = Offset.constructor-impl((((long)Float.floatToRawIntBits(v13_1))) << 0x20 | (((long)Float.floatToRawIntBits(v14_1))) & 0xFFFFFFFFL);
                    long v0_2 = Offset.constructor-impl((((long)Float.floatToRawIntBits(v11_2))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(v15))) << 0x20);
                    v9_3 = arg19.localPositionOf-R5De75A(v12, v9_3);
                    v0_2 = arg19.localPositionOf-R5De75A(v12, v0_2);
                    v3 = Math.min(v3, Float.intBitsToFloat(((int)(v9_3 >> 0x20))));
                    v4 = Math.min(v4, Float.intBitsToFloat(((int)(v9_3 & 0xFFFFFFFFL))));
                    v5 = Math.max(v5, Float.intBitsToFloat(((int)(v0_2 >> 0x20))));
                    v2_1 = Math.max(v2_1, Float.intBitsToFloat(((int)(v0_2 & 0xFFFFFFFFL))));
                }
            }

            ++v8;
            v0 = arg18;
            v7 = 0;
        }

        return new Rect(v3, v4, v5, v2_1);
    }

    public static final Selection merge(Selection arg0, Selection arg1) {
        if(arg0 != null) {
            arg0 = arg0.merge(arg1);
            if(arg0 == null) {
            }
            else {
                return arg0;
            }
        }

        return arg1;
    }

    public static final Rect visibleBounds(LayoutCoordinates arg5) {
        Rect v0 = LayoutCoordinatesKt.boundsInWindow$default(arg5, false, 1, null);
        return RectKt.Rect-0a9Yr6o(arg5.windowToLocal-MK-Hz9U(v0.getTopLeft-F1C5BW0()), arg5.windowToLocal-MK-Hz9U(v0.getBottomRight-F1C5BW0()));
    }
}

