package androidx.compose.ui.semantics;

import android.os.Trace;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A\"\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0005\u001A\u001A\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0007\u001A,\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\b*\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0005H\u0000\u001A\f\u0010\u000B\u001A\u00020\u0005*\u00020\u0002H\u0000\u001A.\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00140\u0013*\u00020\u00032\u0006\u0010\u0015\u001A\u00020\t2\u0012\u0010\u0016\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0017H\u0000\"\u001E\u0010\f\u001A\u00020\u0005*\u00020\u00028@X\u0080\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000E\u001A\u0004\b\f\u0010\u000F\"\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"getAllSemanticsNodes", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "Landroidx/compose/ui/semantics/SemanticsOwner;", "mergingEnabled", "", "skipDeactivatedNodes", "getAllSemanticsNodesToMap", "", "", "useUnmergedTree", "isImportantForAccessibility", "isHidden", "isHidden$annotations", "(Landroidx/compose/ui/semantics/SemanticsNode;)V", "(Landroidx/compose/ui/semantics/SemanticsNode;)Z", "DefaultFakeNodeBounds", "Landroidx/compose/ui/geometry/Rect;", "getAllUncoveredSemanticsNodesToIntObjectMap", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/semantics/SemanticsNodeWithAdjustedBounds;", "customRootNodeId", "shouldIgnoreNode", "Lkotlin/Function1;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SemanticsOwnerKt {
    private static final Rect DefaultFakeNodeBounds;

    static {
        SemanticsOwnerKt.DefaultFakeNodeBounds = new Rect(0f, 0f, 10f, 10f);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use a new overload instead") public static final List getAllSemanticsNodes(SemanticsOwner arg1, boolean arg2) {
        return SemanticsOwnerKt.getAllSemanticsNodes(arg1, arg2, true);
    }

    public static final List getAllSemanticsNodes(SemanticsOwner arg0, boolean arg1, boolean arg2) {
        return CollectionsKt.toList(SemanticsOwnerKt.getAllSemanticsNodesToMap(arg0, (((int)arg1)) ^ 1, arg2).values());
    }

    public static List getAllSemanticsNodes$default(SemanticsOwner arg0, boolean arg1, boolean arg2, int arg3, Object arg4) {
        return SemanticsOwnerKt.getAllSemanticsNodes(arg0, arg1, true);
    }

    public static final Map getAllSemanticsNodesToMap(SemanticsOwner arg1, boolean arg2, boolean arg3) {
        LinkedHashMap v0 = new LinkedHashMap();
        SemanticsNode v1 = arg2 ? arg1.getUnmergedRootSemanticsNode() : arg1.getRootSemanticsNode();
        if(arg3) {
            if(!v1.getLayoutNode$ui().isDeactivated()) {
            }
            else {
                return ((Map)v0);
            }
        }

        SemanticsOwnerKt.getAllSemanticsNodesToMap$findAllSemanticNodesRecursive(((Map)v0), arg3, v1);
        return ((Map)v0);
    }

    public static Map getAllSemanticsNodesToMap$default(SemanticsOwner arg0, boolean arg1, boolean arg2, int arg3, Object arg4) {
        return SemanticsOwnerKt.getAllSemanticsNodesToMap(arg0, false, true);
    }

    private static final void getAllSemanticsNodesToMap$findAllSemanticNodesRecursive(Map arg7, boolean arg8, SemanticsNode arg9) {
        arg7.put(Integer.valueOf(arg9.getId()), arg9);
        List v9 = SemanticsNode.getChildren$ui$default(arg9, false, false, (((int)arg8)) ^ 1, 3, null);
        int v0 = v9.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            SemanticsOwnerKt.getAllSemanticsNodesToMap$findAllSemanticNodesRecursive(arg7, arg8, v9.get(v1));
        }
    }

    public static final IntObjectMap getAllUncoveredSemanticsNodesToIntObjectMap(SemanticsOwner arg8, int arg9, Function1 arg10) {
        IntObjectMap v8;
        Trace.beginSection("getAllUncoveredSemanticsNodesToIntObjectMap");
        try {
            SemanticsNode v2 = arg8.getUnmergedRootSemanticsNode();
            if(v2.getLayoutNode$ui().isPlaced()) {
                if(!v2.getLayoutNode$ui().isAttached()) {
                }
                else {
                    MutableIntObjectMap v4 = new MutableIntObjectMap(0x30);
                    SemanticsRegion v1 = SemanticsRegion_androidKt.SemanticsRegion();
                    v1.set(IntRectKt.roundToIntRect(v2.getBoundsInRoot()));
                    SemanticsOwnerKt.getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$findAllSemanticNodesRecursive(v1, v2, arg9, v4, arg10, v2, SemanticsRegion_androidKt.SemanticsRegion());
                    Trace.endSection();
                    return ((IntObjectMap)v4);
                }
            }

            v8 = IntObjectMapKt.emptyIntObjectMap();
        }
        catch(Throwable v0) {
            Trace.endSection();
            throw v0;
        }

        Trace.endSection();
        return v8;
    }

    private static final void getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$findAllSemanticNodesRecursive(SemanticsRegion arg11, SemanticsNode arg12, int arg13, MutableIntObjectMap arg14, Function1 arg15, SemanticsNode arg16, SemanticsRegion arg17) {
        Rect v11_1;
        SemanticsNode v0 = arg16;
        SemanticsRegion v7 = arg17;
        int v1 = !v0.getLayoutNode$ui().isPlaced() || !v0.getLayoutNode$ui().isAttached() ? 1 : 0;
        if((!arg11.isEmpty() || v0.getId() == arg12.getId()) && (v1 == 0 || (v0.isFake$ui()))) {
            IntRect v8 = IntRectKt.roundToIntRect(v0.getTouchBoundsInRoot());
            v7.set(v8);
            v1 = v0.getId() == arg12.getId() ? arg13 : v0.getId();
            if(v7.intersect(arg11)) {
                arg14.set(v1, new SemanticsNodeWithAdjustedBounds(v0, v7.getBounds()));
                List v9 = v0.getReplacedChildren$ui();
                int v10 = v9.size() - 1;
                while(-1 < v10) {
                    if(arg15.invoke(v9.get(v10)).booleanValue()) {
                    }
                    else {
                        SemanticsOwnerKt.getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$findAllSemanticNodesRecursive(arg11, arg12, arg13, arg14, arg15, v9.get(v10), v7);
                    }

                    --v10;
                    v7 = arg17;
                }

                if(!SemanticsOwnerKt.isImportantForAccessibility(v0)) {
                    return;
                }

                arg11.difference(v8);
                return;
            }

            if(v0.isFake$ui()) {
                SemanticsNode v11 = v0.getParent();
                if(v11 != null) {
                    LayoutInfo v12 = v11.getLayoutInfo();
                    if(v12 == null) {
                        goto label_73;
                    }
                    else if(v12.isPlaced()) {
                        v11_1 = v11.getBoundsInRoot();
                    }
                    else {
                        goto label_73;
                    }
                }
                else {
                label_73:
                    v11_1 = SemanticsOwnerKt.DefaultFakeNodeBounds;
                }

                arg14.set(v1, new SemanticsNodeWithAdjustedBounds(v0, IntRectKt.roundToIntRect(v11_1)));
                return;
            }

            if(v1 != arg13) {
                return;
            }

            arg14.set(v1, new SemanticsNodeWithAdjustedBounds(v0, arg17.getBounds()));
        }
    }

    public static final boolean isHidden(SemanticsNode arg2) {
        if(!arg2.isTransparent$ui() && !arg2.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getHideFromAccessibility())) {
            if(arg2.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getInvisibleToUser())) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public static void isHidden$annotations(SemanticsNode arg0) {
    }

    public static final boolean isImportantForAccessibility(SemanticsNode arg1) {
        if(!SemanticsOwnerKt.isHidden(arg1) && ((arg1.getUnmergedConfig$ui().isMergingSemanticsOfDescendants()) || (arg1.getUnmergedConfig$ui().containsImportantForAccessibility$ui()))) {
            return 1;
        }

        return 0;
    }
}

