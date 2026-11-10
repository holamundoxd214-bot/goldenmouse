package androidx.compose.ui.platform;

import android.content.res.Resources;
import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntIntMap;
import androidx.compose.ui.R$string;
import androidx.compose.ui.contentcapture.ContentCaptureManager;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeWithAdjustedBounds;
import androidx.compose.ui.semantics.SemanticsOwnerKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsSortKt;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\u001A\"\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u00012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0002\u001A.\u0010\u0005\u001A\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000EH\u0002\u001A\u0018\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\r\u001A\u00020\u000EH\u0002\u001A\u0012\u0010\u0012\u001A\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001A\u00020\u0011H\u0002\u001A\u001A\u0010\u0014\u001A\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\r\u001A\u00020\u000EH\u0002\u001A\u001A\u0010\u0016\u001A\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\r\u001A\u00020\u000EH\u0002\u001A\u0010\u0010\u0017\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u0011H\u0002\u001A\f\u0010\u0018\u001A\u00020\u0004*\u00020\u0011H\u0002\u001A\u0014\u0010\u0019\u001A\u00020\u0004*\u00020\u00112\u0006\u0010\u001A\u001A\u00020\u001BH\u0002\u001A\f\u0010\u001E\u001A\u00020\u0004*\u00020\u0011H\u0002\u001A\u001A\u0010\u001F\u001A\u00020\u0004*\u0006\u0012\u0002\b\u00030 2\b\u0010!\u001A\u0004\u0018\u00010\"H\u0002\"\u0018\u0010\u001C\u001A\u00020\u0004*\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001D\"*\u0010$\u001A\u00020\u00042\u0006\u0010#\u001A\u00020\u00048F@FX\u0087\u000E¢\u0006\u0012\u0012\u0004\b%\u0010&\u001A\u0004\b\'\u0010(\"\u0004\b)\u0010*¨\u0006+"}, d2={"findClosestParentNode", "Landroidx/compose/ui/node/LayoutNode;", "selector", "Lkotlin/Function1;", "", "setTraversalValues", "", "currentSemanticsNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/semantics/SemanticsNodeWithAdjustedBounds;", "outputBeforeMap", "Landroidx/collection/MutableIntIntMap;", "outputAfterMap", "resources", "Landroid/content/res/Resources;", "isScreenReaderFocusable", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "getInfoText", "Landroidx/compose/ui/text/AnnotatedString;", "getInfoStateDescriptionOrNull", "", "createStateDescriptionForTextField", "getInfoIsCheckable", "enabled", "propertiesDeleted", "oldConfig", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "isRtl", "(Landroidx/compose/ui/semantics/SemanticsNode;)Z", "excludeLineAndPageGranularities", "accessibilityEquals", "Landroidx/compose/ui/semantics/AccessibilityAction;", "other", "", "value", "DisableContentCapture", "getDisableContentCapture$annotations", "()V", "getDisableContentCapture", "()Z", "setDisableContentCapture", "(Z)V", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidComposeViewAccessibilityDelegateCompat_androidKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[ToggleableState.values().length];
            try {
                v0[ToggleableState.On.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[ToggleableState.Off.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[ToggleableState.Indeterminate.ordinal()] = 3;
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

    public static final boolean access$accessibilityEquals(AccessibilityAction arg0, Object arg1) {
        return AndroidComposeViewAccessibilityDelegateCompat_androidKt.accessibilityEquals(arg0, arg1);
    }

    public static final boolean access$enabled(SemanticsNode arg0) {
        return AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(arg0);
    }

    public static final boolean access$excludeLineAndPageGranularities(SemanticsNode arg0) {
        return AndroidComposeViewAccessibilityDelegateCompat_androidKt.excludeLineAndPageGranularities(arg0);
    }

    public static final LayoutNode access$findClosestParentNode(LayoutNode arg0, Function1 arg1) {
        return AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(arg0, arg1);
    }

    public static final boolean access$getInfoIsCheckable(SemanticsNode arg0) {
        return AndroidComposeViewAccessibilityDelegateCompat_androidKt.getInfoIsCheckable(arg0);
    }

    public static final String access$getInfoStateDescriptionOrNull(SemanticsNode arg0, Resources arg1) {
        return AndroidComposeViewAccessibilityDelegateCompat_androidKt.getInfoStateDescriptionOrNull(arg0, arg1);
    }

    public static final AnnotatedString access$getInfoText(SemanticsNode arg0) {
        return AndroidComposeViewAccessibilityDelegateCompat_androidKt.getInfoText(arg0);
    }

    public static final boolean access$isRtl(SemanticsNode arg0) {
        return AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(arg0);
    }

    public static final boolean access$isScreenReaderFocusable(SemanticsNode arg0, Resources arg1) {
        return AndroidComposeViewAccessibilityDelegateCompat_androidKt.isScreenReaderFocusable(arg0, arg1);
    }

    public static final boolean access$propertiesDeleted(SemanticsNode arg0, SemanticsConfiguration arg1) {
        return AndroidComposeViewAccessibilityDelegateCompat_androidKt.propertiesDeleted(arg0, arg1);
    }

    public static final void access$setTraversalValues(IntObjectMap arg0, MutableIntIntMap arg1, MutableIntIntMap arg2, Resources arg3) {
        AndroidComposeViewAccessibilityDelegateCompat_androidKt.setTraversalValues(arg0, arg1, arg2, arg3);
    }

    private static final boolean accessibilityEquals(AccessibilityAction arg4, Object arg5) {
        if(arg4 == (((AccessibilityAction)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof AccessibilityAction)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg4.getLabel(), ((AccessibilityAction)arg5).getLabel())) {
            return 0;
        }

        if(arg4.getAction() == null && ((AccessibilityAction)arg5).getAction() != null) {
            return 0;
        }

        if(arg4.getAction() != null && ((AccessibilityAction)arg5).getAction() == null) {
            return 0;
        }

        return 1;
    }

    private static final String createStateDescriptionForTextField(SemanticsNode arg1, Resources arg2) {
        SemanticsConfiguration v1 = arg1.copyWithMergingEnabled$ui().getConfig();
        Object v0 = SemanticsConfigurationKt.getOrNull(v1, SemanticsProperties.INSTANCE.getContentDescription());
        if(v0 == null || (((Collection)v0).isEmpty())) {
            v0 = SemanticsConfigurationKt.getOrNull(v1, SemanticsProperties.INSTANCE.getText());
            if(v0 != null && !((Collection)v0).isEmpty()) {
                return null;
            }

            Object v1_1 = SemanticsConfigurationKt.getOrNull(v1, SemanticsProperties.INSTANCE.getEditableText());
            if(v1_1 != null) {
                if(((CharSequence)v1_1).length() == 0) {
                }
                else {
                    return null;
                }
            }
        }
        else {
            return null;
        }

        return arg2.getString(string.state_empty);
    }

    private static final boolean enabled(SemanticsNode arg1) {
        return arg1.getConfig().contains(SemanticsProperties.INSTANCE.getDisabled()) ^ 1;
    }

    private static final boolean excludeLineAndPageGranularities(SemanticsNode arg4) {
        boolean v0 = arg4.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getEditableText());
        Boolean v2 = Boolean.valueOf(true);
        if((v0) && !Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(arg4.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getFocused()), v2)) {
            return 1;
        }

        LayoutNode v4 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(arg4.getLayoutNode$ui(), AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1.INSTANCE);
        if(v4 != null) {
            SemanticsConfiguration v4_1 = v4.getSemanticsConfiguration();
            boolean v4_2 = v4_1 != null ? Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(v4_1, SemanticsProperties.INSTANCE.getFocused()), v2) : false;
            if(v4_2) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    private static final LayoutNode findClosestParentNode(LayoutNode arg1, Function1 arg2) {
        for(arg1 = arg1.getParent$ui(); arg1 != null; arg1 = arg1.getParent$ui()) {
            if(arg2.invoke(arg1).booleanValue()) {
                return arg1;
            }
        }

        return null;
    }

    public static final boolean getDisableContentCapture() {
        return ContentCaptureManager.Companion.isEnabled();
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Use ContentCapture.isEnabled instead", replaceWith="<_subannotation>") public static void getDisableContentCapture$annotations() {
    }

    private static final boolean getInfoIsCheckable(SemanticsNode arg5) {
        Object v0 = SemanticsConfigurationKt.getOrNull(arg5.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getToggleableState());
        Object v1 = SemanticsConfigurationKt.getOrNull(arg5.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getRole());
        boolean v3 = false;
        boolean v0_1 = v0 != null ? true : false;
        Object v5 = SemanticsConfigurationKt.getOrNull(arg5.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getSelected());
        if(v5 != null) {
            ((Boolean)v5).booleanValue();
            int v5_1 = Role.Companion.getTab-o7Vup1c();
            if(v1 == null) {
            }
            else {
                v3 = Role.equals-impl0(((Role)v1).unbox-impl(), v5_1);
            }

            if(v3) {
                return v0_1;
            }

            return 1;
        }

        return v0_1;
    }

    private static final String getInfoStateDescriptionOrNull(SemanticsNode arg6, Resources arg7) {
        String v0_1;
        boolean v1_2;
        Object v0 = SemanticsConfigurationKt.getOrNull(arg6.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getStateDescription());
        Object v1 = SemanticsConfigurationKt.getOrNull(arg6.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getToggleableState());
        Object v2 = SemanticsConfigurationKt.getOrNull(arg6.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getRole());
        int v4 = 0;
        if(v1 != null) {
            int v1_1 = WhenMappings.$EnumSwitchMapping$0[((ToggleableState)v1).ordinal()];
            if(v1_1 == 1) {
                v1_1 = Role.Companion.getSwitch-o7Vup1c();
                v1_2 = v2 == null ? false : Role.equals-impl0(((Role)v2).unbox-impl(), v1_1);
                if(!v1_2) {
                    goto label_53;
                }

                if(v0 != null) {
                    goto label_53;
                }

                v0_1 = arg7.getString(string.state_on);
            }
            else if(v1_1 == 2) {
                v1_1 = Role.Companion.getSwitch-o7Vup1c();
                v1_2 = v2 == null ? false : Role.equals-impl0(((Role)v2).unbox-impl(), v1_1);
                if(!v1_2) {
                    goto label_53;
                }

                if(v0 != null) {
                    goto label_53;
                }

                v0_1 = arg7.getString(string.state_off);
            }
            else if(v1_1 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            else if(v0 == null) {
                v0_1 = arg7.getString(string.indeterminate);
            }
        }

    label_53:
        v1 = SemanticsConfigurationKt.getOrNull(arg6.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getSelected());
        if(v1 != null) {
            v1_2 = ((Boolean)v1).booleanValue();
            int v5 = Role.Companion.getTab-o7Vup1c();
            boolean v2_1 = v2 == null ? false : Role.equals-impl0(((Role)v2).unbox-impl(), v5);
            if(v2_1) {
                goto label_74;
            }

            if(v0 != null) {
                goto label_74;
            }

            if(v1_2) {
                v0_1 = arg7.getString(string.selected);
                goto label_74;
            }

            v0_1 = arg7.getString(string.not_selected);
        }

    label_74:
        v1 = SemanticsConfigurationKt.getOrNull(arg6.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
        if(v1 != null) {
            if(v1 == ProgressBarRangeInfo.Companion.getIndeterminate()) {
                if(v0 != null) {
                    goto label_126;
                }

                v0_1 = arg7.getString(string.in_progress);
            }
            else if(v0 == null) {
                ClosedFloatingPointRange v0_2 = ((ProgressBarRangeInfo)v1).getRange();
                float v1_3 = v0_2.getEndInclusive().floatValue() - v0_2.getStart().floatValue() == 0f ? 0f : (((ProgressBarRangeInfo)v1).getCurrent() - v0_2.getStart().floatValue()) / (v0_2.getEndInclusive().floatValue() - v0_2.getStart().floatValue());
                if(v1_3 < 0f) {
                    v1_3 = 0f;
                }

                float v0_3 = 1f;
                if(v1_3 > v0_3) {
                    v1_3 = v0_3;
                }

                if(v1_3 == 0f) {
                }
                else if(v1_3 == v0_3) {
                    v4 = 100;
                }
                else {
                    v4 = RangesKt.coerceIn(Math.round(v1_3 * 100f), 1, 99);
                }

                v0_1 = arg7.getString(string.template_percent, new Object[]{Integer.valueOf(v4)});
            }
        }

    label_126:
        if(arg6.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getEditableText())) {
            v0_1 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.createStateDescriptionForTextField(arg6, arg7);
        }

        return ((String)v0);
    }

    private static final AnnotatedString getInfoText(SemanticsNode arg2) {
        Object v0 = SemanticsConfigurationKt.getOrNull(arg2.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getEditableText());
        Object v2 = SemanticsConfigurationKt.getOrNull(arg2.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getText());
        if(v2 != null) {
            v2 = CollectionsKt.firstOrNull(((List)v2));
        }
        else {
            AnnotatedString v2_1 = null;
        }

        if(v0 == null) {
            return ((AnnotatedString)v2);
        }

        return ((AnnotatedString)v0);
    }

    private static final boolean isRtl(SemanticsNode arg1) {
        if(arg1.getLayoutInfo().getLayoutDirection() == LayoutDirection.Rtl) {
            return 1;
        }

        return 0;
    }

    private static final boolean isScreenReaderFocusable(SemanticsNode arg3, Resources arg4) {
        Object v0 = SemanticsConfigurationKt.getOrNull(arg3.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getContentDescription());
        v0 = v0 != null ? CollectionsKt.firstOrNull(((List)v0)) : null;
        int v4 = v0 != null || AndroidComposeViewAccessibilityDelegateCompat_androidKt.getInfoText(arg3) != null || AndroidComposeViewAccessibilityDelegateCompat_androidKt.getInfoStateDescriptionOrNull(arg3, arg4) != null || (AndroidComposeViewAccessibilityDelegateCompat_androidKt.getInfoIsCheckable(arg3)) ? 1 : 0;
        if(!SemanticsOwnerKt.isHidden(arg3)) {
            if(!arg3.getUnmergedConfig$ui().isMergingSemanticsOfDescendants()) {
                if(!arg3.isUnmergedLeafNode$ui()) {
                }
                else if(v4 != 0) {
                    return 1;
                }

                return 0;
            }

            return 1;
        }

        return 0;
    }

    private static final boolean propertiesDeleted(SemanticsNode arg2, SemanticsConfiguration arg3) {
        Iterator v3 = arg3.iterator();
        do {
            if(!v3.hasNext()) {
                return 0;
            }
        }
        while(arg2.getConfig().contains(v3.next().getKey()));

        return 1;
    }

    public static final void setDisableContentCapture(boolean arg1) {
        ContentCaptureManager.Companion.setEnabled(arg1);
    }

    private static final void setTraversalValues(IntObjectMap arg3, MutableIntIntMap arg4, MutableIntIntMap arg5, Resources arg6) {
        arg4.clear();
        arg5.clear();
        Object v0 = arg3.get(-1);
        if(v0 != null) {
            SemanticsNode v0_1 = ((SemanticsNodeWithAdjustedBounds)v0).getSemanticsNode();
        }
        else {
            v0 = null;
        }

        Intrinsics.checkNotNull(v0);
        List v3 = SemanticsSortKt.subtreeSortedByGeometryGrouping(((SemanticsNode)v0), new AndroidComposeViewAccessibilityDelegateCompat_androidKt$setTraversalValues$semanticsOrderList$1(arg3), new AndroidComposeViewAccessibilityDelegateCompat_androidKt$setTraversalValues$semanticsOrderList$2(arg6), CollectionsKt.listOf(v0));
        int v6 = CollectionsKt.getLastIndex(v3);
        int v0_2 = 1;
        if(1 <= v6) {
            while(true) {
                int v1 = v3.get(v0_2 - 1).getId();
                int v2 = v3.get(v0_2).getId();
                arg4.set(v1, v2);
                arg5.set(v2, v1);
                if(v0_2 != v6) {
                    ++v0_2;
                    continue;
                }

                return;
            }
        }
    }
}

