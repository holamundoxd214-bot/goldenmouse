package androidx.compose.foundation.text.contextmenu.internal;

import android.content.Context;
import android.os.Build$VERSION;
import androidx.compose.foundation.contextmenu.ContextMenuPopupPositionProvider;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuSpec;
import androidx.compose.foundation.contextmenu.ContextMenuUiKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuComponent;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuItem;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSeparator;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuTextClassificationItem;
import androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider;
import androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProviderKt;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProviderKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.ColorFilter$Companion;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A \u0010\u0000\u001A\u00020\u00012\u0011\u0010\u0002\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0001¢\u0006\u0002\u0010\u0005\u001A(\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u00072\u0011\u0010\u0002\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0001¢\u0006\u0002\u0010\b\u001A\r\u0010\t\u001A\u00020\nH\u0001¢\u0006\u0002\u0010\u000B\u001A+\u0010\u000E\u001A\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00140\u0003H\u0003¢\u0006\u0002\u0010\u0015\u001A\u001D\u0010\u0016\u001A\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0017\u001A\u00020\u0018H\u0003¢\u0006\u0002\u0010\u0019\u001A!\u0010\u001A\u001A\u00020\u00012\b\b\u0001\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001EH\u0003¢\u0006\u0004\b\u001F\u0010 \"\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!²\u0006\n\u0010\u0017\u001A\u00020\u0018X\u008A\u0084\u0002"}, d2={"ProvideDefaultTextContextMenuDropdown", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "defaultTextContextMenuDropdown", "Landroidx/compose/foundation/text/contextmenu/provider/BasicTextContextMenuProvider;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/contextmenu/provider/BasicTextContextMenuProvider;", "DefaultPopupProperties", "Landroidx/compose/ui/window/PopupProperties;", "OpenContextMenu", "session", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;", "dataProvider", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;", "anchorLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "DefaultTextContextMenuDropdown", "data", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "(Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;Landroidx/compose/runtime/Composer;I)V", "IconBox", "resId", "", "tint", "Landroidx/compose/ui/graphics/Color;", "IconBox-RPmYEkk", "(IJLandroidx/compose/runtime/Composer;I)V", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DefaultTextContextMenuDropdownProvider_androidKt {
    private static final PopupProperties DefaultPopupProperties;

    public static String $r8$lambda$JhNMmkcFebL4F8RFVyRITua8CsM(TextContextMenuComponent arg0, Composer arg1, int arg2) {
        return DefaultTextContextMenuDropdownProvider_androidKt.DefaultTextContextMenuDropdown$lambda$0$0$0$0(arg0, arg1, arg2);
    }

    public static IntOffset $r8$lambda$TOC9x0jwKyNP4BIdeszXfBwv2GU(TextContextMenuDataProvider arg0, Function0 arg1) {
        return DefaultTextContextMenuDropdownProvider_androidKt.OpenContextMenu$lambda$0$0(arg0, arg1);
    }

    public static Unit $r8$lambda$Y9RHtm8EFKhIlq3Tf3-c6rLn6Dk(TextContextMenuSession arg0) {
        return DefaultTextContextMenuDropdownProvider_androidKt.OpenContextMenu$lambda$1$0(arg0);
    }

    public static Unit $r8$lambda$ww830TBVrFKXVjb-4uOeIOSMedo(TextContextMenuData arg0, Context arg1, TextContextMenuSession arg2, ContextMenuScope arg3) {
        return DefaultTextContextMenuDropdownProvider_androidKt.DefaultTextContextMenuDropdown$lambda$0$0(arg0, arg1, arg2, arg3);
    }

    public static Unit $r8$lambda$yTfaDh9hAXw-J9f2TWpXQAtFhW0(TextContextMenuComponent arg0, TextContextMenuSession arg1) {
        return DefaultTextContextMenuDropdownProvider_androidKt.DefaultTextContextMenuDropdown$lambda$0$0$0$1(arg0, arg1);
    }

    static {
        DefaultTextContextMenuDropdownProvider_androidKt.DefaultPopupProperties = new PopupProperties(true, false, false, false, 14, null);
    }

    private static final void DefaultTextContextMenuDropdown(TextContextMenuSession arg7, TextContextMenuData arg8, Composer arg9, int arg10) {
        Object v0_2;
        int v9_1;
        int v0 = 1904307118;
        Composer v4 = arg9.startRestartGroup(v0);
        ComposerKt.sourceInformation(v4, "C(DefaultTextContextMenuDropdown)N(session,data)140@5937L900,140@5912L925:DefaultTextContextMenuDropdownProvider.android.kt#18dpbw");
        int v1 = 4;
        if((arg10 & 6) == 0) {
            boolean v9 = (arg10 & 8) == 0 ? v4.changed(arg7) : v4.changedInstance(arg7);
            v9_1 = v9 ? v1 : 2;
            v9_1 |= arg10;
        }
        else {
            v9_1 = arg10;
        }

        if((arg10 & 0x30) == 0) {
            int v2 = v4.changedInstance(arg8) ? 0x20 : 16;
            v9_1 |= v2;
        }

        int v5 = 0;
        boolean v2_1 = (v9_1 & 19) != 18 ? true : false;
        if(v4.shouldExecute(v2_1, v9_1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v9_1, -1, "androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdown (DefaultTextContextMenuDropdownProvider.android.kt:133)");
            }

            if(Build$VERSION.SDK_INT >= 28) {
                v4.startReplaceGroup(-1009482584);
                ComposerKt.sourceInformation(v4, "136@5856L7");
                ProvidableCompositionLocal v0_1 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                v0_2 = v4.consume(((CompositionLocal)v0_1));
                ComposerKt.sourceInformationMarkerEnd(v4);
                v4.endReplaceGroup();
            }
            else {
                v4.startReplaceGroup(-1009433480);
                v4.endReplaceGroup();
                v0_2 = null;
            }

            ComposerKt.sourceInformationMarkerStart(v4, 0x16D55F72, "CC(remember):DefaultTextContextMenuDropdownProvider.android.kt#9igjgp");
            v2_1 = v4.changedInstance(arg8);
            if((v9_1 & 14) == v1 || (v9_1 & 8) != 0 && (v4.changedInstance(arg7))) {
                v5 = 1;
            }

            v9_1 = (((int)v2_1)) | v5 | v4.changedInstance(v0_2);
            Object v1_1 = v4.rememberedValue();
            if(v9_1 != 0 || v1_1 == Composer.Companion.getEmpty()) {
                DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda3 v1_2 = new DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda3(arg8, ((Context)v0_2), arg7);
                v4.updateRememberedValue(v1_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            ContextMenuUiKt.ContextMenuColumnBuilder(null, null, v1_1, v4, 0, 3);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_96;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v4.skipToGroupEnd();
        }

    label_96:
        ScopeUpdateScope v9_2 = v4.endRestartGroup();
        if(v9_2 != null) {
            v9_2.updateScope(new DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda4(arg7, arg8, arg10));
        }
    }

    private static final Unit DefaultTextContextMenuDropdown$lambda$0$0(TextContextMenuData arg12, Context arg13, TextContextMenuSession arg14, ContextMenuScope arg15) {
        ContextMenuScope v4;
        List v12 = arg12.getComponents();
        int v0 = v12.size();
        int v1 = 0;
        while(v1 < v0) {
            Object v2 = v12.get(v1);
            if((v2 instanceof TextContextMenuItem)) {
                DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda6 v5 = new DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda6(((TextContextMenuComponent)v2));
                ComposableLambda v3 = v2.getLeadingIcon() == 0 ? null : ComposableLambdaKt.composableLambdaInstance(-1930700965, true, new DefaultTextContextMenuDropdownProvider_androidKt$DefaultTextContextMenuDropdown$1$1$1$2(((TextContextMenuComponent)v2)));
                v4 = arg15;
                ContextMenuScope.item$default(v4, ((Function2)v5), null, false, v3, new DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda7(((TextContextMenuComponent)v2), arg14), 6, null);
            }
            else {
                v4 = arg15;
                if((v2 instanceof TextContextMenuTextClassificationItem)) {
                    if(Build$VERSION.SDK_INT < 28) {
                        goto label_42;
                    }

                    TextContextMenuHelperApi28.INSTANCE.textClassificationItem(v4, arg13, ((TextContextMenuTextClassificationItem)v2));
                    goto label_42;
                }

                if(!(v2 instanceof TextContextMenuSeparator)) {
                    goto label_42;
                }

                v4.separator();
            }

        label_42:
            ++v1;
            arg15 = v4;
        }

        return Unit.INSTANCE;
    }

    private static final String DefaultTextContextMenuDropdown$lambda$0$0$0$0(TextContextMenuComponent arg3, Composer arg4, int arg5) {
        int v0 = 666084174;
        arg4.startReplaceGroup(v0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg5, -1, "androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdown.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DefaultTextContextMenuDropdownProvider.android.kt:145)");
        }

        String v3 = ((TextContextMenuItem)arg3).getLabel();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg4.endReplaceGroup();
        return v3;
    }

    private static final Unit DefaultTextContextMenuDropdown$lambda$0$0$0$1(TextContextMenuComponent arg0, TextContextMenuSession arg1) {
        ((TextContextMenuItem)arg0).getOnClick().invoke(arg1);
        return Unit.INSTANCE;
    }

    static final Unit DefaultTextContextMenuDropdown$lambda$1(TextContextMenuSession arg0, TextContextMenuData arg1, int arg2, Composer arg3, int arg4) {
        DefaultTextContextMenuDropdownProvider_androidKt.DefaultTextContextMenuDropdown(arg0, arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    private static final void IconBox-RPmYEkk(int arg22, long arg23, Composer arg25, int arg26) {
        ScopeUpdateScope v1_3;
        Integer v6_3;
        int v4;
        int v0 = arg22;
        long v2 = arg23;
        int v7 = arg26;
        int v1 = 0xB6135FF3;
        Composer v8 = arg25.startRestartGroup(v1);
        ComposerKt.sourceInformation(v8, "C(IconBox)N(resId,tint:c#ui.graphics.Color)167@6979L7,169@7024L182,176@7267L35,177@7325L75,178@7405L146:DefaultTextContextMenuDropdownProvider.android.kt#18dpbw");
        int v5 = 4;
        if((v7 & 6) == 0) {
            v4 = v8.changed(v0) ? v5 : 2;
            v4 |= v7;
        }
        else {
            v4 = v7;
        }

        int v9 = 0x20;
        if((v7 & 0x30) == 0) {
            int v6 = v8.changed(v2) ? v9 : 16;
            v4 |= v6;
        }

        int v11 = 1;
        boolean v6_1 = (v4 & 19) != 18 ? true : false;
        if(v8.shouldExecute(v6_1, v4 & 1)) {
            int v10 = -1;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v1, v4, v10, "androidx.compose.foundation.text.contextmenu.internal.IconBox (DefaultTextContextMenuDropdownProvider.android.kt:166)");
            }

            ProvidableCompositionLocal v1_1 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(v8, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v1_2 = v8.consume(((CompositionLocal)v1_1));
            ComposerKt.sourceInformationMarkerEnd(v8);
            String v13 = "CC(remember):DefaultTextContextMenuDropdownProvider.android.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v8, 2126200809, v13);
            v6_1 = v8.changed(v1_2);
            v5 = (v4 & 14) == v5 ? 1 : 0;
            v5 |= ((int)v6_1);
            Object v6_2 = v8.rememberedValue();
            if(v5 != 0 || v6_2 == Composer.Companion.getEmpty()) {
                v6_3 = Integer.valueOf(((Context)v1_2).obtainStyledAttributes(new int[]{v0}).getResourceId(0, v10));
                v8.updateRememberedValue(v6_3);
            }

            v1 = ((Number)v6_3).intValue();
            ComposerKt.sourceInformationMarkerEnd(v8);
            if(v1 == v10) {
                if(ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }

                v1_3 = v8.endRestartGroup();
                if(v1_3 == null) {
                    return;
                }

                DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda8 v4_1 = new DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda8(v0, v2, v7);
                goto label_80;
            }

            Painter v14 = PainterResources_androidKt.painterResource(v1, v8, 0);
            ComposerKt.sourceInformationMarkerStart(v8, 2126210334, v13);
            if((v4 & 0x70) == v9) {
            }
            else {
                v11 = 0;
            }

            v1_2 = v8.rememberedValue();
            if(v11 != 0 || v1_2 == Composer.Companion.getEmpty()) {
                if(v2 == 16) {
                    v1_2 = null;
                }
                else {
                    ColorFilter v1_4 = Companion.tint-xETnrds$default(ColorFilter.Companion, v2, 0, 2, null);
                }

                v8.updateRememberedValue(v1_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            BoxKt.Box(PainterModifierKt.paint$default(SizeKt.size-3ABfNKs(Modifier.Companion, ContextMenuSpec.INSTANCE.getIconSize-D9Ej5fM()), v14, false, null, ContentScale.Companion.getFit(), 0f, v1_2, 22, null), v8, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_124;
            }

            ComposerKt.traceEventEnd();
            goto label_124;
        }
        else {
            v8.skipToGroupEnd();
        label_124:
            v1_3 = v8.endRestartGroup();
            if(v1_3 == null) {
                return;
            }

            DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda9 v4_2 = new DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda9(v0, v2, v7);
        label_80:
            v1_3.updateScope(((Function2)v4_2));
            return;
        }
    }

    static final Unit IconBox_RPmYEkk$lambda$1(int arg0, long arg1, int arg3, Composer arg4, int arg5) {
        DefaultTextContextMenuDropdownProvider_androidKt.IconBox-RPmYEkk(arg0, arg1, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    static final Unit IconBox_RPmYEkk$lambda$3(int arg0, long arg1, int arg3, Composer arg4, int arg5) {
        DefaultTextContextMenuDropdownProvider_androidKt.IconBox-RPmYEkk(arg0, arg1, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    private static final void OpenContextMenu(TextContextMenuSession arg10, TextContextMenuDataProvider arg11, Function0 arg12, Composer arg13, int arg14) {
        DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda11 v13_3;
        MaintainWindowPositionPopupPositionProvider v4_2;
        int v3_1;
        boolean v3;
        int v13_1;
        int v0 = -2040393164;
        Composer v5 = arg13.startRestartGroup(v0);
        ComposerKt.sourceInformation(v5, "C(OpenContextMenu)N(session,dataProvider,anchorLayoutCoordinates)111@5065L252,121@5412L19,123@5484L143,119@5323L304:DefaultTextContextMenuDropdownProvider.android.kt#18dpbw");
        int v1 = 4;
        int v2 = 2;
        if((arg14 & 6) == 0) {
            boolean v13 = (arg14 & 8) == 0 ? v5.changed(arg10) : v5.changedInstance(arg10);
            v13_1 = v13 ? v1 : v2;
            v13_1 |= arg14;
        }
        else {
            v13_1 = arg14;
        }

        int v4 = 0x20;
        if((arg14 & 0x30) == 0) {
            v3 = (arg14 & 0x40) == 0 ? v5.changed(arg11) : v5.changedInstance(arg11);
            v3_1 = v3 ? v4 : 16;
            v13_1 |= v3_1;
        }

        if((arg14 & 0x180) == 0) {
            v3_1 = v5.changedInstance(arg12) ? 0x100 : 0x80;
            v13_1 |= v3_1;
        }

        int v7 = 0;
        v3 = (v13_1 & 0x93) != 0x92 ? true : false;
        if(v5.shouldExecute(v3, v13_1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v13_1, -1, "androidx.compose.foundation.text.contextmenu.internal.OpenContextMenu (DefaultTextContextMenuDropdownProvider.android.kt:109)");
            }

            String v3_2 = "CC(remember):DefaultTextContextMenuDropdownProvider.android.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v5, 0x76266F90, v3_2);
            if((v13_1 & 0x70) != v4) {
                if((v13_1 & 0x40) != 0 && (v5.changed(arg11))) {
                    goto label_69;
                }

                v0 = 0;
            }
            else {
            label_69:
                v0 = 1;
            }

            Object v4_1 = v5.rememberedValue();
            if(v0 != 0 || v4_1 == Composer.Companion.getEmpty()) {
                v4_2 = new MaintainWindowPositionPopupPositionProvider(new ContextMenuPopupPositionProvider(new DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda10(arg11, arg12), null, v2, null));
                v5.updateRememberedValue(v4_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerStart(v5, 0x76269A07, v3_2);
            if((v13_1 & 14) == v1 || (v13_1 & 8) != 0 && (v5.changedInstance(arg10))) {
                v7 = 1;
            }

            Object v13_2 = v5.rememberedValue();
            if(v7 != 0 || v13_2 == Composer.Companion.getEmpty()) {
                v13_3 = new DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda11(arg10);
                v5.updateRememberedValue(v13_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            AndroidPopup_androidKt.Popup(v4_2, v13_3, DefaultTextContextMenuDropdownProvider_androidKt.DefaultPopupProperties, ComposableLambdaKt.rememberComposableLambda(0x4E63ADD6, true, new DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda1(arg11, arg10), v5, 54), v5, 0xD80, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_119;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v5.skipToGroupEnd();
        }

    label_119:
        ScopeUpdateScope v13_4 = v5.endRestartGroup();
        if(v13_4 != null) {
            v13_4.updateScope(new DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda2(arg10, arg11, arg12, arg14));
        }
    }

    private static final IntOffset OpenContextMenu$lambda$0$0(TextContextMenuDataProvider arg0, Function0 arg1) {
        return IntOffset.box-impl(IntOffsetKt.round-k-4lQ0M(arg0.position-tuRUvjQ(arg1.invoke())));
    }

    private static final Unit OpenContextMenu$lambda$1$0(TextContextMenuSession arg0) {
        arg0.close();
        return Unit.INSTANCE;
    }

    static final Unit OpenContextMenu$lambda$2(TextContextMenuDataProvider arg4, TextContextMenuSession arg5, Composer arg6, int arg7) {
        State v0_2;
        ComposerKt.sourceInformation(arg6, "C124@5506L61,125@5576L45:DefaultTextContextMenuDropdownProvider.android.kt#18dpbw");
        boolean v0 = (arg7 & 3) != 2 ? true : false;
        if(arg6.shouldExecute(v0, arg7 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x4E63ADD6, arg7, -1, "androidx.compose.foundation.text.contextmenu.internal.OpenContextMenu.<anonymous> (DefaultTextContextMenuDropdownProvider.android.kt:124)");
            }

            ComposerKt.sourceInformationMarkerStart(arg6, 0x442F9353, "CC(remember):DefaultTextContextMenuDropdownProvider.android.kt#9igjgp");
            boolean v7 = arg6.changed(arg4);
            Object v0_1 = arg6.rememberedValue();
            if((v7) || v0_1 == Composer.Companion.getEmpty()) {
                v0_2 = SnapshotStateKt.derivedStateOf(new DefaultTextContextMenuDropdownProvider_androidKt$OpenContextMenu$2$data$2$1(arg4));
                arg6.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg6);
            DefaultTextContextMenuDropdownProvider_androidKt.DefaultTextContextMenuDropdown(arg5, DefaultTextContextMenuDropdownProvider_androidKt.OpenContextMenu$lambda$2$1(v0_2), arg6, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_39;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_39:
        return Unit.INSTANCE;
    }

    private static final TextContextMenuData OpenContextMenu$lambda$2$1(State arg0) {
        return arg0.getValue();
    }

    static final Unit OpenContextMenu$lambda$3(TextContextMenuSession arg0, TextContextMenuDataProvider arg1, Function0 arg2, int arg3, Composer arg4, int arg5) {
        DefaultTextContextMenuDropdownProvider_androidKt.OpenContextMenu(arg0, arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    public static final void ProvideDefaultTextContextMenuDropdown(Modifier arg7, Function2 arg8, Composer arg9, int arg10) {
        Function2 v4;
        Modifier v1_2;
        int v9;
        int v0 = 0x52F9D6EB;
        Composer v5 = arg9.startRestartGroup(v0);
        ComposerKt.sourceInformation(v5, "C(ProvideDefaultTextContextMenuDropdown)N(modifier,content)86@4186L326:DefaultTextContextMenuDropdownProvider.android.kt#18dpbw");
        if((arg10 & 6) == 0) {
            v9 = v5.changed(arg7) ? 4 : 2;
            v9 |= arg10;
        }
        else {
            v9 = arg10;
        }

        if((arg10 & 0x30) == 0) {
            int v1 = v5.changedInstance(arg8) ? 0x20 : 16;
            v9 |= v1;
        }

        boolean v1_1 = (v9 & 19) != 18 ? true : false;
        if(v5.shouldExecute(v1_1, v9 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v9, -1, "androidx.compose.foundation.text.contextmenu.internal.ProvideDefaultTextContextMenuDropdown (DefaultTextContextMenuDropdownProvider.android.kt:85)");
            }

            v1_2 = arg7;
            v4 = arg8;
            BasicTextContextMenuProviderKt.ProvideBasicTextContextMenu(v1_2, TextContextMenuProviderKt.getLocalTextContextMenuDropdownProvider(), ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt.INSTANCE.getLambda$636288403$foundation(), v4, v5, v9 & 14 | 0x1B0 | v9 << 6 & 0x1C00);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_54;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1_2 = arg7;
            v4 = arg8;
            v5.skipToGroupEnd();
        }

    label_54:
        ScopeUpdateScope v7 = v5.endRestartGroup();
        if(v7 != null) {
            v7.updateScope(new DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda5(v1_2, v4, arg10));
        }
    }

    public static final void ProvideDefaultTextContextMenuDropdown(Function2 arg4, Composer arg5, int arg6) {
        int v1;
        int v0 = 422095256;
        arg5 = arg5.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg5, "C(ProvideDefaultTextContextMenuDropdown)N(content)72@3752L297:DefaultTextContextMenuDropdownProvider.android.kt#18dpbw");
        int v2 = 2;
        if((arg6 & 6) == 0) {
            v1 = arg5.changedInstance(arg4) ? 4 : v2;
            v1 |= arg6;
        }
        else {
            v1 = arg6;
        }

        boolean v2_1 = (v1 & 3) != v2 ? true : false;
        if(arg5.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.text.contextmenu.internal.ProvideDefaultTextContextMenuDropdown (DefaultTextContextMenuDropdownProvider.android.kt:71)");
            }

            BasicTextContextMenuProviderKt.ProvideBasicTextContextMenu(TextContextMenuProviderKt.getLocalTextContextMenuDropdownProvider(), ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt.INSTANCE.getLambda$129995601$foundation(), arg4, arg5, v1 << 6 & 0x380 | 54);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_40;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg5.skipToGroupEnd();
        }

    label_40:
        ScopeUpdateScope v5 = arg5.endRestartGroup();
        if(v5 != null) {
            v5.updateScope(new DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda0(arg4, arg6));
        }
    }

    static final Unit ProvideDefaultTextContextMenuDropdown$lambda$0(Function2 arg0, int arg1, Composer arg2, int arg3) {
        DefaultTextContextMenuDropdownProvider_androidKt.ProvideDefaultTextContextMenuDropdown(arg0, arg2, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1));
        return Unit.INSTANCE;
    }

    static final Unit ProvideDefaultTextContextMenuDropdown$lambda$1(Modifier arg0, Function2 arg1, int arg2, Composer arg3, int arg4) {
        DefaultTextContextMenuDropdownProvider_androidKt.ProvideDefaultTextContextMenuDropdown(arg0, arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    public static final void access$IconBox-RPmYEkk(int arg0, long arg1, Composer arg3, int arg4) {
        DefaultTextContextMenuDropdownProvider_androidKt.IconBox-RPmYEkk(arg0, arg1, arg3, arg4);
    }

    public static final void access$OpenContextMenu(TextContextMenuSession arg0, TextContextMenuDataProvider arg1, Function0 arg2, Composer arg3, int arg4) {
        DefaultTextContextMenuDropdownProvider_androidKt.OpenContextMenu(arg0, arg1, arg2, arg3, arg4);
    }

    public static final BasicTextContextMenuProvider defaultTextContextMenuDropdown(Composer arg3, int arg4) {
        int v1 = 1197778906;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(defaultTextContextMenuDropdown)98@4610L158:DefaultTextContextMenuDropdownProvider.android.kt#18dpbw");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.foundation.text.contextmenu.internal.defaultTextContextMenuDropdown (DefaultTextContextMenuDropdownProvider.android.kt:98)");
        }

        BasicTextContextMenuProvider v4 = BasicTextContextMenuProviderKt.basicTextContextMenuProvider(ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt.INSTANCE.getLambda$-1357803046$foundation(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v4;
    }
}

