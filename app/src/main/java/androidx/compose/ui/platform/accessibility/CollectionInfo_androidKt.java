package androidx.compose.ui.platform.accessibility;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.CollectionItemInfo;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0000\u001A\u0018\u0010\u0006\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0000\u001A\f\u0010\u0007\u001A\u00020\b*\u00020\u0003H\u0000\u001A\u0016\u0010\t\u001A\u00020\b2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u000BH\u0002\u001A\u0014\u0010\u000F\u001A\n \u0011*\u0004\u0018\u00010\u00100\u0010*\u00020\rH\u0002\u001A\u001C\u0010\u0012\u001A\n \u0011*\u0004\u0018\u00010\u00130\u0013*\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0003H\u0002\"\u0018\u0010\f\u001A\u00020\b*\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\u000E¨\u0006\u0016"}, d2={"setCollectionInfo", "", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "setCollectionItemInfo", "hasCollectionInfo", "", "calculateIfHorizontallyStacked", "items", "", "isLazyCollection", "Landroidx/compose/ui/semantics/CollectionInfo;", "(Landroidx/compose/ui/semantics/CollectionInfo;)Z", "toAccessibilityCollectionInfo", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat$CollectionInfoCompat;", "kotlin.jvm.PlatformType", "toAccessibilityCollectionItemInfo", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat$CollectionItemInfoCompat;", "Landroidx/compose/ui/semantics/CollectionItemInfo;", "itemNode", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class CollectionInfo_androidKt {
    private static final boolean calculateIfHorizontallyStacked(List arg14) {
        long v6_1;
        int v7;
        if(arg14.size() < 2) {
            return 1;
        }

        long v3 = 0xFFFFFFFFL;
        int v5 = 0x20;
        if(arg14.size() <= 1) {
            arg14 = CollectionsKt.emptyList();
        }
        else {
            ArrayList v0 = new ArrayList();
            Object v6 = arg14.get(0);
            v7 = CollectionsKt.getLastIndex(arg14);
            int v8 = 0;
            while(v8 < v7) {
                ++v8;
                Object v9 = arg14.get(v8);
                ((List)v0).add(Offset.box-impl(Offset.constructor-impl((((long)Float.floatToRawIntBits(Math.abs(Float.intBitsToFloat(((int)(((SemanticsNode)v6).getBoundsInRoot().getCenter-F1C5BW0() >> v5))) - Float.intBitsToFloat(((int)(v9.getBoundsInRoot().getCenter-F1C5BW0() >> v5))))))) << v5 | (((long)Float.floatToRawIntBits(Math.abs(Float.intBitsToFloat(((int)(((SemanticsNode)v6).getBoundsInRoot().getCenter-F1C5BW0() & v3))) - Float.intBitsToFloat(((int)(v9.getBoundsInRoot().getCenter-F1C5BW0() & v3))))))) & v3)));
                v6 = v9;
            }

            ArrayList v14 = v0;
        }

        if(arg14.size() == 1) {
            v6_1 = CollectionsKt.first(arg14).unbox-impl();
        }
        else {
            if(arg14.isEmpty()) {
                ListUtilsKt.throwUnsupportedOperationException("Empty collection can\'t be reduced.");
            }

            Object v0_1 = CollectionsKt.first(arg14);
            int v6_2 = CollectionsKt.getLastIndex(arg14);
            if(1 <= v6_2) {
                v7 = 1;
                while(true) {
                    Offset v0_2 = Offset.box-impl(Offset.plus-MK-Hz9U(((Offset)v0_1).unbox-impl(), arg14.get(v7).unbox-impl()));
                    if(v7 != v6_2) {
                        ++v7;
                        continue;
                    }

                    break;
                }
            }

            v6_1 = ((Offset)v0_1).unbox-impl();
        }

        if(Float.intBitsToFloat(((int)(v3 & v6_1))) < Float.intBitsToFloat(((int)(v6_1 >> v5)))) {
            return 1;
        }

        return 0;
    }

    public static final boolean hasCollectionInfo(SemanticsNode arg2) {
        if(SemanticsConfigurationKt.getOrNull(arg2.getConfig(), SemanticsProperties.INSTANCE.getCollectionInfo()) == null) {
            if(SemanticsConfigurationKt.getOrNull(arg2.getConfig(), SemanticsProperties.INSTANCE.getSelectableGroup()) != null) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private static final boolean isLazyCollection(CollectionInfo arg1) {
        if(arg1.getRowCount() >= 0) {
            if(arg1.getColumnCount() < 0) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public static final void setCollectionInfo(SemanticsNode arg7, AccessibilityNodeInfoCompat arg8) {
        int v1;
        Object v0 = SemanticsConfigurationKt.getOrNull(arg7.getConfig(), SemanticsProperties.INSTANCE.getCollectionInfo());
        if(v0 != null) {
            arg8.setCollectionInfo(CollectionInfo_androidKt.toAccessibilityCollectionInfo(((CollectionInfo)v0)));
            return;
        }

        ArrayList v0_1 = new ArrayList();
        if(SemanticsConfigurationKt.getOrNull(arg7.getConfig(), SemanticsProperties.INSTANCE.getSelectableGroup()) != null) {
            List v7 = arg7.getReplacedChildren$ui();
            v1 = v7.size();
            int v3;
            for(v3 = 0; v3 < v1; ++v3) {
                Object v4 = v7.get(v3);
                if(((SemanticsNode)v4).getConfig().contains(SemanticsProperties.INSTANCE.getSelected())) {
                    ((List)v0_1).add(v4);
                }
            }
        }

        ArrayList v7_1 = v0_1;
        if(!((Collection)v7_1).isEmpty()) {
            boolean v0_2 = CollectionInfo_androidKt.calculateIfHorizontallyStacked(((List)v0_1));
            v1 = 1;
            v3 = v0_2 ? 1 : ((Collection)v7_1).size();
            if(v0_2) {
                v1 = ((Collection)v7_1).size();
            }

            arg8.setCollectionInfo(CollectionInfoCompat.obtain(v3, v1, false, 0));
        }
    }

    public static final void setCollectionItemInfo(SemanticsNode arg12, AccessibilityNodeInfoCompat arg13) {
        Object v0 = SemanticsConfigurationKt.getOrNull(arg12.getConfig(), SemanticsProperties.INSTANCE.getCollectionItemInfo());
        if(v0 != null) {
            arg13.setCollectionItemInfo(CollectionInfo_androidKt.toAccessibilityCollectionItemInfo(((CollectionItemInfo)v0), arg12));
        }

        SemanticsNode v0_1 = arg12.getParent();
        if(v0_1 == null) {
        }
        else if(SemanticsConfigurationKt.getOrNull(v0_1.getConfig(), SemanticsProperties.INSTANCE.getSelectableGroup()) != null) {
            Object v1 = SemanticsConfigurationKt.getOrNull(v0_1.getConfig(), SemanticsProperties.INSTANCE.getCollectionInfo());
            if(v1 != null && (CollectionInfo_androidKt.isLazyCollection(((CollectionInfo)v1)))) {
                return;
            }

            if(!arg12.getConfig().contains(SemanticsProperties.INSTANCE.getSelected())) {
                return;
            }

            ArrayList v1_1 = new ArrayList();
            List v0_2 = v0_1.getReplacedChildren$ui();
            int v2 = v0_2.size();
            int v4 = 0;
            int v5 = 0;
            while(v4 < v2) {
                Object v6 = v0_2.get(v4);
                if(((SemanticsNode)v6).getConfig().contains(SemanticsProperties.INSTANCE.getSelected())) {
                    ((List)v1_1).add(v6);
                    if(((SemanticsNode)v6).getLayoutNode$ui().getPlaceOrder$ui() < arg12.getLayoutNode$ui().getPlaceOrder$ui()) {
                        ++v5;
                    }
                }

                ++v4;
            }

            if(v1_1.isEmpty()) {
                return;
            }

            boolean v0_3 = CollectionInfo_androidKt.calculateIfHorizontallyStacked(((List)v1_1));
            int v6_1 = v0_3 ? 0 : v5;
            int v8 = v0_3 ? v5 : 0;
            CollectionItemInfoCompat v12 = CollectionItemInfoCompat.obtain(v6_1, 1, v8, 1, false, arg12.getConfig().getOrElse(SemanticsProperties.INSTANCE.getSelected(), CollectionInfo_androidKt$setCollectionItemInfo$itemInfo$1.INSTANCE).booleanValue());
            if(v12 == null) {
                return;
            }

            arg13.setCollectionItemInfo(v12);
        }
    }

    private static final CollectionInfoCompat toAccessibilityCollectionInfo(CollectionInfo arg2) {
        return CollectionInfoCompat.obtain(arg2.getRowCount(), arg2.getColumnCount(), false, 0);
    }

    private static final CollectionItemInfoCompat toAccessibilityCollectionItemInfo(CollectionItemInfo arg6, SemanticsNode arg7) {
        return CollectionItemInfoCompat.obtain(arg6.getRowIndex(), arg6.getRowSpan(), arg6.getColumnIndex(), arg6.getColumnSpan(), false, arg7.getConfig().getOrElse(SemanticsProperties.INSTANCE.getSelected(), CollectionInfo_androidKt$toAccessibilityCollectionItemInfo$1.INSTANCE).booleanValue());
    }
}

