package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.internal.PlatformUtils_androidKt;
import androidx.compose.foundation.text.CommonContextMenuAreaKt$TextItem$1;
import androidx.compose.foundation.text.CommonContextMenuAreaKt$TextItem$2;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.MenuItemsAvailability;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A%\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001A\u0014\u0010\t\u001A\u00020\u0003*\u00020\u00072\u0006\u0010\u0002\u001A\u00020\u0003H\u0000\u001A\u001F\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\rH\u0000¢\u0006\u0004\b\u000E\u0010\u000F\u001A3\u0010\u0010\u001A\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013*\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u00152\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0000¨\u0006\u0019"}, d2={"TextFieldSelectionHandle", "", "isStartHandle", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "(ZLandroidx/compose/ui/text/style/ResolvedTextDirection;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "isSelectionHandleInVisibleBoundDefault", "calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-O0kMr_c", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;J)J", "contextMenuBuilder", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "Lkotlin/ExtensionFunctionType;", "contextMenuState", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "itemsAvailability", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/text/MenuItemsAvailability;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextFieldSelectionManagerKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Handle.values().length];
            try {
                v0[Handle.Cursor.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[Handle.SelectionStart.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[Handle.SelectionEnd.ordinal()] = 3;
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

    public static Unit $r8$lambda$7TgNYnqXAshciBc4excdDEpwVWE(TextFieldSelectionManager arg0) {
        return TextFieldSelectionManagerKt.contextMenuBuilder$lambda$0$1(arg0);
    }

    public static Unit $r8$lambda$UiksigVL3SzuH7AlWA5Y_SyQnfg(TextFieldSelectionManager arg0) {
        return TextFieldSelectionManagerKt.contextMenuBuilder$lambda$0$4(arg0);
    }

    public static Unit $r8$lambda$j3epNIIXttQDRCcQfI3V86-R_jg(TextFieldSelectionManager arg0) {
        return TextFieldSelectionManagerKt.contextMenuBuilder$lambda$0$3(arg0);
    }

    public static Unit $r8$lambda$p34YjtOTpkMbxOzGpUm2lk2FLYo(TextFieldSelectionManager arg0) {
        return TextFieldSelectionManagerKt.contextMenuBuilder$lambda$0$2(arg0);
    }

    public static Unit $r8$lambda$tVTge5KO0kG_vO6HhRA7d9nYztY(TextFieldSelectionManager arg0) {
        return TextFieldSelectionManagerKt.contextMenuBuilder$lambda$0$0(arg0);
    }

    public static final void TextFieldSelectionHandle(boolean arg12, ResolvedTextDirection arg13, TextFieldSelectionManager arg14, Composer arg15, int arg16) {
        TextFieldSelectionManagerKt$TextFieldSelectionHandle$2$1 v7_1;
        int v4;
        int v2;
        int v11 = arg16;
        int v0 = 0xAFDBA8B8;
        Composer v8 = arg15.startRestartGroup(v0);
        ComposerKt.sourceInformation(v8, "C(TextFieldSelectionHandle)N(isStartHandle,direction,manager)1357@57485L78,1360@57611L44,1366@57914L51,1359@57569L403:TextFieldSelectionManager.kt#eksfi3");
        int v3 = 4;
        if((v11 & 6) == 0) {
            v2 = v8.changed(arg12) ? v3 : 2;
            v2 |= v11;
        }
        else {
            v2 = v11;
        }

        if((v11 & 0x30) == 0) {
            v4 = v8.changed(arg13.ordinal()) ? 0x20 : 16;
            v2 |= v4;
        }

        if((v11 & 0x180) == 0) {
            v4 = v8.changedInstance(arg14) ? 0x100 : 0x80;
            v2 |= v4;
        }

        int v6 = 0;
        boolean v4_1 = (v2 & 0x93) != 0x92 ? true : false;
        if(v8.shouldExecute(v4_1, v2 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.foundation.text.selection.TextFieldSelectionHandle (TextFieldSelectionManager.kt:1356)");
            }

            String v4_2 = "CC(remember):TextFieldSelectionManager.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v8, 664039142, v4_2);
            v0 = v2 & 14;
            int v5 = v0 == v3 ? 1 : 0;
            v5 |= v8.changed(arg14);
            Object v9 = v8.rememberedValue();
            if(v5 != 0 || v9 == Composer.Companion.getEmpty()) {
                TextDragObserver v9_1 = arg14.handleDragObserver$foundation(arg12);
                v8.updateRememberedValue(v9_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerStart(v8, 664043140, v4_2);
            boolean v5_1 = v8.changedInstance(arg14);
            if(v0 == v3) {
                v6 = 1;
            }

            Object v3_1 = v8.rememberedValue();
            if(((((int)v5_1)) | v6) != 0 || v3_1 == Composer.Companion.getEmpty()) {
                TextFieldSelectionManagerKt$TextFieldSelectionHandle$1$1 v3_2 = new TextFieldSelectionManagerKt$TextFieldSelectionHandle$1$1(arg14, arg12);
                v8.updateRememberedValue(v3_2);
            }

            Object v0_1 = v3_1;
            ComposerKt.sourceInformationMarkerEnd(v8);
            boolean v3_3 = TextRange.getReversed-impl(arg14.getValue$foundation().getSelection-d9O1mEE());
            float v6_1 = arg14.getHandleLineHeight$foundation(arg12);
            Companion v5_2 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(v8, 664052843, v4_2);
            v4_1 = v8.changedInstance(v9);
            Object v7 = v8.rememberedValue();
            if((v4_1) || v7 == Composer.Companion.getEmpty()) {
                v7_1 = new TextFieldSelectionManagerKt$TextFieldSelectionHandle$2$1(((TextDragObserver)v9));
                v8.updateRememberedValue(v7_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            AndroidSelectionHandles_androidKt.SelectionHandle-wLIcFTc(((OffsetProvider)v0_1), arg12, arg13, v3_3, 0, v6_1, SuspendingPointerInputFilterKt.pointerInput(((Modifier)v5_2), v9, ((PointerInputEventHandler)v7_1)), v8, v2 << 3 & 0x3F0, 16);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_117;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v8.skipToGroupEnd();
        }

    label_117:
        ScopeUpdateScope v0_2 = v8.endRestartGroup();
        if(v0_2 != null) {
            v0_2.updateScope(new TextFieldSelectionManagerKt$$ExternalSyntheticLambda1(arg12, arg13, arg14, v11));
        }
    }

    static final Unit TextFieldSelectionHandle$lambda$3(boolean arg0, ResolvedTextDirection arg1, TextFieldSelectionManager arg2, int arg3, Composer arg4, int arg5) {
        TextFieldSelectionManagerKt.TextFieldSelectionHandle(arg0, arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    public static final long calculateSelectionMagnifierCenterAndroid-O0kMr_c(TextFieldSelectionManager arg7, long arg8) {
        Offset v0 = arg7.getCurrentDragPosition-_m7T9-E();
        if(v0 != null) {
            long v0_1 = v0.unbox-impl();
            AnnotatedString v2 = arg7.getTransformedText$foundation();
            if(v2 != null) {
                if(((CharSequence)v2).length() == 0) {
                }
                else {
                    Handle v2_1 = arg7.getDraggingHandle();
                    int v3 = -1;
                    int v2_2 = v2_1 == null ? v3 : WhenMappings.$EnumSwitchMapping$0[v2_1.ordinal()];
                    if(v2_2 != v3) {
                        int v4 = 2;
                        if(v2_2 == 1 || v2_2 == v4) {
                            v2_2 = TextRange.getStart-impl(arg7.getValue$foundation().getSelection-d9O1mEE());
                        }
                        else if(v2_2 == 3) {
                            v2_2 = TextRange.getEnd-impl(arg7.getValue$foundation().getSelection-d9O1mEE());
                        }
                        else {
                            throw new NoWhenBranchMatchedException();
                        }

                        LegacyTextFieldState v3_1 = arg7.getState$foundation();
                        if(v3_1 != null) {
                            TextLayoutResultProxy v3_2 = v3_1.getLayoutResult();
                            if(v3_2 == null) {
                            }
                            else {
                                LegacyTextFieldState v5 = arg7.getState$foundation();
                                if(v5 != null) {
                                    TextDelegate v5_1 = v5.getTextDelegate();
                                    if(v5_1 != null) {
                                        AnnotatedString v5_2 = v5_1.getText();
                                        if(v5_2 == null) {
                                        }
                                        else {
                                            int v7 = RangesKt.coerceIn(arg7.getOffsetMapping$foundation().originalToTransformed(v2_2), 0, v5_2.length());
                                            v2_2 = 0x20;
                                            float v0_2 = Float.intBitsToFloat(((int)(v3_2.translateDecorationToInnerCoordinates-MK-Hz9U$foundation(v0_1) >> v2_2)));
                                            TextLayoutResult v1 = v3_2.getValue();
                                            v7 = v1.getLineForOffset(v7);
                                            float v3_3 = v1.getLineLeft(v7);
                                            float v5_3 = v1.getLineRight(v7);
                                            v3_3 = RangesKt.coerceIn(v0_2, Math.min(v3_3, v5_3), Math.max(v3_3, v5_3));
                                            if(!IntSize.equals-impl0(arg8, IntSize.Companion.getZero-YbymL2g()) && Math.abs(v0_2 - v3_3) > (((float)((((int)(arg8 >> v2_2))) / v4)))) {
                                                return Offset.Companion.getUnspecified-F1C5BW0();
                                            }

                                            float v8 = v1.getLineTop(v7);
                                            return Offset.constructor-impl((((long)Float.floatToRawIntBits(v3_3))) << v2_2 | (((long)Float.floatToRawIntBits((v1.getLineBottom(v7) - v8) / 2f + v8))) & 0xFFFFFFFFL);
                                        }
                                    }
                                }

                                return Offset.Companion.getUnspecified-F1C5BW0();
                            }
                        }

                        return Offset.Companion.getUnspecified-F1C5BW0();
                    }

                    return Offset.Companion.getUnspecified-F1C5BW0();
                }
            }

            return Offset.Companion.getUnspecified-F1C5BW0();
        }

        return Offset.Companion.getUnspecified-F1C5BW0();
    }

    public static final Function1 contextMenuBuilder(TextFieldSelectionManager arg1, ContextMenuState arg2, State arg3) {
        return new TextFieldSelectionManagerKt$$ExternalSyntheticLambda0(arg3, arg1, arg2);
    }

    static final Unit contextMenuBuilder$lambda$0(State arg3, TextFieldSelectionManager arg4, ContextMenuState arg5, ContextMenuScope arg6) {
        int v3 = arg3.getValue().unbox-impl();
        TextFieldSelectionManagerKt.contextMenuBuilder$lambda$0$textFieldItem(arg6, arg5, TextContextMenuItems.Cut, MenuItemsAvailability.getCanCut-impl(v3), new TextFieldSelectionManagerKt$$ExternalSyntheticLambda2(arg4));
        TextFieldSelectionManagerKt.contextMenuBuilder$lambda$0$textFieldItem(arg6, arg5, TextContextMenuItems.Copy, MenuItemsAvailability.getCanCopy-impl(v3), new TextFieldSelectionManagerKt$$ExternalSyntheticLambda3(arg4));
        TextFieldSelectionManagerKt.contextMenuBuilder$lambda$0$textFieldItem(arg6, arg5, TextContextMenuItems.Paste, MenuItemsAvailability.getCanPaste-impl(v3), new TextFieldSelectionManagerKt$$ExternalSyntheticLambda4(arg4));
        TextFieldSelectionManagerKt.contextMenuBuilder$lambda$0$textFieldItem(arg6, arg5, TextContextMenuItems.SelectAll, MenuItemsAvailability.getCanSelectAll-impl(v3), new TextFieldSelectionManagerKt$$ExternalSyntheticLambda5(arg4));
        if(PlatformUtils_androidKt.isAutofillAvailable()) {
            TextFieldSelectionManagerKt.contextMenuBuilder$lambda$0$textFieldItem(arg6, arg5, TextContextMenuItems.Autofill, MenuItemsAvailability.getCanAutofill-impl(v3), new TextFieldSelectionManagerKt$$ExternalSyntheticLambda6(arg4));
        }

        return Unit.INSTANCE;
    }

    private static final Unit contextMenuBuilder$lambda$0$0(TextFieldSelectionManager arg0) {
        arg0.cut$foundation();
        return Unit.INSTANCE;
    }

    private static final Unit contextMenuBuilder$lambda$0$1(TextFieldSelectionManager arg1) {
        arg1.copy$foundation(false);
        return Unit.INSTANCE;
    }

    private static final Unit contextMenuBuilder$lambda$0$2(TextFieldSelectionManager arg0) {
        arg0.paste$foundation();
        return Unit.INSTANCE;
    }

    private static final Unit contextMenuBuilder$lambda$0$3(TextFieldSelectionManager arg0) {
        arg0.selectAll$foundation();
        return Unit.INSTANCE;
    }

    private static final Unit contextMenuBuilder$lambda$0$4(TextFieldSelectionManager arg0) {
        arg0.autofill$foundation();
        return Unit.INSTANCE;
    }

    private static final void contextMenuBuilder$lambda$0$textFieldItem(ContextMenuScope arg8, ContextMenuState arg9, TextContextMenuItems arg10, boolean arg11, Function0 arg12) {
        if(arg11) {
            ContextMenuScope.item$default(arg8, new CommonContextMenuAreaKt$TextItem$1(arg10), null, false, null, new CommonContextMenuAreaKt$TextItem$2(arg12, arg9), 14, null);
        }
    }

    public static final boolean isSelectionHandleInVisibleBoundDefault(TextFieldSelectionManager arg1, boolean arg2) {
        LegacyTextFieldState v0 = arg1.getState$foundation();
        if(v0 != null) {
            LayoutCoordinates v0_1 = v0.getLayoutCoordinates();
            if(v0_1 != null) {
                Rect v0_2 = SelectionManagerKt.visibleBounds(v0_1);
                if(v0_2 != null) {
                    return SelectionManagerKt.containsInclusive-Uv8p0NA(v0_2, arg1.getHandlePosition-tuRUvjQ$foundation(arg2));
                }
            }
        }

        return 0;
    }
}

