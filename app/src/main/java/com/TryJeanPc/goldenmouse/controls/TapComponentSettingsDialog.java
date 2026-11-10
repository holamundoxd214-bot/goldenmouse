package com.TryJeanPc.goldenmouse.controls;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.TryJeanPc.goldenmouse.R$drawable;
import com.TryJeanPc.goldenmouse.R$id;
import com.TryJeanPc.goldenmouse.R$layout;
import com.TryJeanPc.goldenmouse.R$style;
import com.TryJeanPc.goldenmouse.cursor.CursorOverlayOrderKt;
import com.TryJeanPc.goldenmouse.profile.TapComponent;
import com.TryJeanPc.goldenmouse.profile.TapMode;
import com.TryJeanPc.goldenmouse.service.SessionOverlayWindowsKt;
import com.TryJeanPc.goldenmouse.ui.AdaptiveWindowSizing$Binding;
import com.TryJeanPc.goldenmouse.ui.AdaptiveWindowSizing;
import com.TryJeanPc.goldenmouse.ui.WindowSizingConfig;
import com.TryJeanPc.goldenmouse.ui.WindowType;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.math.MathKt;
import kotlin.ranges.LongRange;
import kotlin.text.StringsKt;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F0\rH\u0000¢\u0006\u0002\b\u0010¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/TapComponentSettingsDialog;", "", "<init>", "()V", "show", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "placement", "Lcom/TryJeanPc/goldenmouse/controls/ComponentPlacement;", "settings", "Lcom/TryJeanPc/goldenmouse/profile/TapComponent;", "onSave", "Lkotlin/Function1;", "Lcom/TryJeanPc/goldenmouse/controls/TapSettingsEdit;", "", "show$app", "Form", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class TapComponentSettingsDialog {
    @Metadata(d1={"\u0000\u008A\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0012\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\t\u0012\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000E0\r¢\u0006\u0004\b\u000F\u0010\u0010J\b\u00106\u001A\u00020\u000EH\u0002J\n\u00107\u001A\u0004\u0018\u00010\u0016H\u0002J\u0010\u00108\u001A\u00020\u001D2\u0006\u0010\u0011\u001A\u000209H\u0002J\u0010\u0010:\u001A\u00020\u000B2\u0006\u0010;\u001A\u00020$H\u0002J\u001F\u0010<\u001A\u0004\u0018\u0001092\u0006\u0010;\u001A\u00020$2\u0006\u0010=\u001A\u000209H\u0002¢\u0006\u0002\u0010>J/\u0010?\u001A\u0004\u0018\u00010@2\u0006\u0010;\u001A\u00020$2\u0006\u0010=\u001A\u00020@2\u0006\u0010A\u001A\u00020@2\u0006\u0010B\u001A\u00020@H\u0002¢\u0006\u0002\u0010CJ\b\u00105\u001A\u00020\u000EH\u0002J\u0006\u0010D\u001A\u00020\u000ER\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000E0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\u0012\u001A\u00020\u000B2\u0006\u0010\u0011\u001A\u00020\u000B@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u000E\u0010\u0014\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001A\u0004\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u001A\u001A\u000E\u0012\u0004\u0012\u00020\u001C\u0012\u0004\u0012\u00020\u001D0\u001BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001E\u001A\n  *\u0004\u0018\u00010\u001F0\u001FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001A\n  *\u0004\u0018\u00010\"0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001A\n  *\u0004\u0018\u00010$0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001A\n  *\u0004\u0018\u00010$0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010&\u001A\n  *\u0004\u0018\u00010\'0\'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010(\u001A\n  *\u0004\u0018\u00010\'0\'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010)\u001A\n  *\u0004\u0018\u00010\u001F0\u001FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010*\u001A\n  *\u0004\u0018\u00010\u001F0\u001FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010+\u001A\n  *\u0004\u0018\u00010,0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010-\u001A\n  *\u0004\u0018\u00010$0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010.\u001A\n  *\u0004\u0018\u00010/0/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00100\u001A\n  *\u0004\u0018\u00010\u001F0\u001FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00101\u001A\n  *\u0004\u0018\u00010$0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00102\u001A\n  *\u0004\u0018\u00010/0/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00103\u001A\n  *\u0004\u0018\u00010$0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00104\u001A\n  *\u0004\u0018\u00010\'0\'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00105\u001A\n  *\u0004\u0018\u00010\'0\'X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/TapComponentSettingsDialog$Form;", "", "root", "Landroid/view/View;", "placement", "Lcom/TryJeanPc/goldenmouse/controls/ComponentPlacement;", "settings", "Lcom/TryJeanPc/goldenmouse/profile/TapComponent;", "onSave", "Lkotlin/Function1;", "Lcom/TryJeanPc/goldenmouse/controls/TapSettingsEdit;", "", "onClose", "Lkotlin/Function0;", "", "<init>", "(Landroid/view/View;Lcom/TryJeanPc/goldenmouse/controls/ComponentPlacement;Lcom/TryJeanPc/goldenmouse/profile/TapComponent;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "value", "isClosed", "()Z", "saving", "selectedAction", "Lcom/TryJeanPc/goldenmouse/controls/TapSettingsAction;", "initialAction", "advanced", "velocityEdited", "initialTexts", "", "", "", "panel", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "scroll", "Landroid/widget/ScrollView;", "x", "Landroid/widget/EditText;", "y", "mode", "Landroid/widget/TextView;", "advancedMode", "advancedGroup", "durationGroup", "selectionGroup", "Landroid/widget/RadioGroup;", "duration", "burst", "Landroid/widget/RadioButton;", "burstGroup", "count", "turbo", "velocity", "cancel", "apply", "renderMode", "activeAdvancedAction", "number", "", "changed", "field", "readCoordinate", "original", "(Landroid/widget/EditText;F)Ljava/lang/Float;", "readInteger", "", "minimum", "maximum", "(Landroid/widget/EditText;JJJ)Ljava/lang/Long;", "close", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Form {
        @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
            static {
                int[] v0 = new int[TapSettingsAction.values().length];
                try {
                    v0[TapSettingsAction.BURST.ordinal()] = 1;
                    goto label_7;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_7:
                        v0[TapSettingsAction.TURBO.ordinal()] = 2;
                        goto label_11;
                    }
                    catch(NoSuchFieldError ) {
                    label_11:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }

        public static final int $stable = 8;
        private boolean advanced;
        private final LinearLayout advancedGroup;
        private final TextView advancedMode;
        private final TextView apply;
        private final RadioButton burst;
        private final LinearLayout burstGroup;
        private final TextView cancel;
        private final EditText count;
        private final EditText duration;
        private final LinearLayout durationGroup;
        private final TapSettingsAction initialAction;
        private final Map initialTexts;
        private boolean isClosed;
        private final TextView mode;
        private final Function0 onClose;
        private final Function1 onSave;
        private final LinearLayout panel;
        private final ComponentPlacement placement;
        private boolean saving;
        private final ScrollView scroll;
        private TapSettingsAction selectedAction;
        private final RadioGroup selectionGroup;
        private final TapComponent settings;
        private final RadioButton turbo;
        private final EditText velocity;
        private boolean velocityEdited;
        private final EditText x;
        private final EditText y;

        static {
        }

        public Form(View arg3, ComponentPlacement arg4, TapComponent arg5, Function1 arg6, Function0 arg7) {
            TapSettingsAction v4;
            Intrinsics.checkNotNullParameter(arg3, "root");
            Intrinsics.checkNotNullParameter(arg4, "placement");
            Intrinsics.checkNotNullParameter(arg5, "settings");
            Intrinsics.checkNotNullParameter(arg6, "onSave");
            Intrinsics.checkNotNullParameter(arg7, "onClose");
            super();
            this.placement = arg4;
            this.settings = arg5;
            this.onSave = arg6;
            this.onClose = arg7;
            if(arg5.getMode() == TapMode.HOLD) {
                v4 = null;
            }
            else if(arg5.getRepeatEnabled()) {
                v4 = TapSettingsAction.BURST;
            }
            else if(arg5.getMode() == TapMode.REPEATING) {
                v4 = TapSettingsAction.TURBO;
            }
            else {
                v4 = TapSettingsAction.SINGLE;
            }

            this.initialAction = v4;
            boolean v4_1 = v4 == TapSettingsAction.BURST || v4 == TapSettingsAction.TURBO ? true : false;
            this.advanced = v4_1;
            this.initialTexts = new LinkedHashMap();
            this.panel = arg3.findViewById(id.panelConfigurarToque);
            this.scroll = arg3.findViewById(id.scrollConfigurarToque);
            View v4_2 = arg3.findViewById(id.editPosicionToqueX);
            this.x = ((EditText)v4_2);
            View v5 = arg3.findViewById(id.editPosicionToqueY);
            this.y = ((EditText)v5);
            this.mode = arg3.findViewById(id.btnModoToque);
            this.advancedMode = arg3.findViewById(id.btnModoAvanzadoToque);
            this.advancedGroup = arg3.findViewById(id.groupToqueAvanzado);
            this.durationGroup = arg3.findViewById(id.groupTiempoUnicoToque);
            this.selectionGroup = arg3.findViewById(id.grupoSeleccionToqueAvanzado);
            this.duration = arg3.findViewById(id.editDuracionToque);
            this.burst = arg3.findViewById(id.switchRafagaToque);
            this.burstGroup = arg3.findViewById(id.groupRafagaToque);
            this.count = arg3.findViewById(id.editCantidadToques);
            this.turbo = arg3.findViewById(id.switchTurboToque);
            this.velocity = arg3.findViewById(id.editVelocidadToque);
            this.cancel = arg3.findViewById(id.btnCancelarToque);
            this.apply = arg3.findViewById(id.btnAplicarToque);
            int v3 = 2;
            EditText[] v0 = new EditText[v3];
            v0[0] = v4_2;
            v0[1] = v5;
            Iterator v4_3 = CollectionsKt.listOf(((Object[])v0)).iterator();
            while(v4_3.hasNext()) {
                v4_3.next().setInputType(0x3002);
            }

            Pair[] v4_4 = new Pair[5];
            v4_4[0] = TuplesKt.to(this.x, this.number(this.placement.getX()));
            v4_4[1] = TuplesKt.to(this.y, this.number(this.placement.getY()));
            v4_4[v3] = TuplesKt.to(this.duration, String.valueOf(this.settings.getTouchDurationMs()));
            v4_4[3] = TuplesKt.to(this.count, String.valueOf(this.settings.getRepeatCount()));
            v4_4[4] = TuplesKt.to(this.velocity, String.valueOf(this.settings.getIntervalMs()));
            v4_3 = CollectionsKt.listOf(((Object[])v4_4)).iterator();
            while(v4_3.hasNext()) {
                Object v5_1 = v4_3.next();
                Object v0_1 = ((Pair)v5_1).component1();
                ((EditText)v0_1).setText(((Pair)v5_1).component2());
                ((EditText)v0_1).setShowSoftInputOnFocus(false);
                this.initialTexts.put(Integer.valueOf(((EditText)v0_1).getId()), ((EditText)v0_1).getText().toString());
            }

            this.selectionGroup.clearCheck();
            v4 = this.initialAction;
            int v4_5 = v4 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[v4.ordinal()];
            if(v4_5 == 1) {
                this.selectionGroup.check(this.burst.getId());
            }
            else if(v4_5 != v3) {
            }
            else {
                this.selectionGroup.check(this.turbo.getId());
            }

            this.velocity.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable arg1) {
                    if(!Form.this.isClosed() && !Form.access$getSaving$p(Form.this) && Form.access$activeAdvancedAction(Form.this) != null) {
                        Form.access$setVelocityEdited$p(Form.this, true);
                    }
                }

                public void beforeTextChanged(CharSequence arg1, int arg2, int arg3, int arg4) {
                }

                public void onTextChanged(CharSequence arg1, int arg2, int arg3, int arg4) {
                }
            });
            this.mode.setOnClickListener(new TapComponentSettingsDialog$Form$$ExternalSyntheticLambda0(this));
            this.advancedMode.setOnClickListener(new TapComponentSettingsDialog$Form$$ExternalSyntheticLambda1(this));
            Pair[] v3_1 = new Pair[v3];
            v3_1[0] = TuplesKt.to(this.burst, TapSettingsAction.BURST);
            v3_1[1] = TuplesKt.to(this.turbo, TapSettingsAction.TURBO);
            Iterator v3_2 = CollectionsKt.listOf(((Object[])v3_1)).iterator();
            while(v3_2.hasNext()) {
                Object v4_6 = v3_2.next();
                ((Pair)v4_6).component1().setOnClickListener(new TapComponentSettingsDialog$Form$$ExternalSyntheticLambda2(this, ((Pair)v4_6).component2()));
            }

            this.cancel.setOnClickListener(new TapComponentSettingsDialog$Form$$ExternalSyntheticLambda3(this));
            this.apply.setOnClickListener(new TapComponentSettingsDialog$Form$$ExternalSyntheticLambda4(this));
            this.renderMode();
            this.scroll.scrollTo(0, 0);
            this.panel.requestFocus();
        }

        static final void _init_$lambda$2(Form arg0, View arg1) {
            if(!arg0.isClosed && !arg0.saving) {
                arg0.advanced = false;
                arg0.selectedAction = TapSettingsAction.SINGLE;
                arg0.selectionGroup.clearCheck();
                arg0.renderMode();
            }
        }

        static final void _init_$lambda$3(Form arg0, View arg1) {
            if(!arg0.isClosed && !arg0.saving) {
                arg0.advanced = true;
                arg0.renderMode();
            }
        }

        static final void _init_$lambda$4(Form arg0, TapSettingsAction arg1, View arg2) {
            if(!arg0.isClosed && !arg0.saving) {
                arg0.advanced = true;
                arg0.selectedAction = arg1;
                arg0.renderMode();
            }
        }

        static final void _init_$lambda$5(Form arg0, View arg1) {
            arg0.close();
        }

        static final void _init_$lambda$6(Form arg0, View arg1) {
            arg0.apply();
        }

        public static final TapSettingsAction access$activeAdvancedAction(Form arg0) {
            return arg0.activeAdvancedAction();
        }

        public static final boolean access$getSaving$p(Form arg0) {
            return arg0.saving;
        }

        public static final void access$setVelocityEdited$p(Form arg0, boolean arg1) {
            arg0.velocityEdited = arg1;
        }

        private final TapSettingsAction activeAdvancedAction() {
            TapSettingsAction v1 = null;
            if(!this.advanced) {
                return v1;
            }

            TapSettingsAction v0 = this.selectedAction;
            if(v0 == null) {
                v0 = this.initialAction;
            }

            int v2 = v0 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[v0.ordinal()];
            if(v2 == 1) {
                if(this.burst.isChecked()) {
                    return v0;
                }

                return v1;
            }
            else if(v2 != 2) {
                return v1;
            }
            else if(this.turbo.isChecked()) {
            }
            else {
                return v1;
            }

            return v0;
        }

        private final void apply() {
            Boolean v24;
            Float v19;
            Float v18;
            int v6;
            int v2_4;
            long v2_3;
            Long v2_2;
            Form v1 = this;
            if(!v1.isClosed) {
                if(v1.saving) {
                }
                else {
                    EditText v0 = v1.x;
                    String v9 = "x";
                    Intrinsics.checkNotNullExpressionValue(v0, v9);
                    Float v0_1 = v1.readCoordinate(v0, v1.placement.getX());
                    if(v0_1 != null) {
                        float v0_2 = v0_1.floatValue();
                        EditText v2 = v1.y;
                        String v10 = "y";
                        Intrinsics.checkNotNullExpressionValue(v2, v10);
                        Float v2_1 = v1.readCoordinate(v2, v1.placement.getY());
                        if(v2_1 != null) {
                            float v11 = v2_1.floatValue();
                            if(!v1.advanced) {
                                v2 = v1.duration;
                                Intrinsics.checkNotNullExpressionValue(v2, "duration");
                                v2_2 = v1.readInteger(v2, v1.settings.getTouchDurationMs(), 1, 5000);
                                if(v2_2 != null) {
                                    v2_3 = v2_2.longValue();
                                }
                                else {
                                    return;
                                }
                            }
                            else {
                                v2_3 = v1.settings.getTouchDurationMs();
                            }

                            long v12 = v2_3;
                            TapSettingsAction v14 = v1.activeAdvancedAction();
                            if(v14 != null) {
                                v2 = v1.velocity;
                                Intrinsics.checkNotNullExpressionValue(v2, "velocity");
                                v2_2 = v1.readInteger(v2, v1.settings.getIntervalMs(), 1, 60000);
                                if(v2_2 != null) {
                                    v2_3 = v2_2.longValue();
                                }
                                else {
                                    return;
                                }
                            }
                            else {
                                v2_3 = v1.settings.getIntervalMs();
                            }

                            long v15 = v2_3;
                            if(v14 == TapSettingsAction.BURST) {
                                v2 = v1.count;
                                Intrinsics.checkNotNullExpressionValue(v2, "count");
                                v2_2 = v1.readInteger(v2, ((long)v1.settings.getRepeatCount()), 1, 999);
                                if(v2_2 != null) {
                                    v2_4 = ((int)v2_2.longValue());
                                }
                                else {
                                    return;
                                }
                            }
                            else {
                                v2_4 = v1.settings.getRepeatCount();
                            }

                            v0_1 = Float.valueOf(v0_2);
                            float v3 = v0_1.floatValue();
                            EditText v4 = v1.x;
                            Intrinsics.checkNotNullExpressionValue(v4, v9);
                            Float v5 = null;
                            if(!v1.changed(v4) || v3 == v1.placement.getX()) {
                                v0_1 = v5;
                            }

                            if(v0_1 != null) {
                                v0_1 = Float.valueOf(((float)MathKt.roundToInt(v0_1.floatValue())));
                                v6 = v0_1.floatValue() == v1.placement.getX() ? 1 : 0;
                                if(v6 != 0) {
                                    goto label_101;
                                }

                                v18 = v0_1;
                            }
                            else {
                            label_101:
                                v18 = v5;
                            }

                            v0_1 = Float.valueOf(v11);
                            float v6_1 = v0_1.floatValue();
                            EditText v7 = v1.y;
                            Intrinsics.checkNotNullExpressionValue(v7, v10);
                            if(!v1.changed(v7) || v6_1 == v1.placement.getY()) {
                                v0_1 = v5;
                            }

                            if(v0_1 != null) {
                                v0_1 = Float.valueOf(((float)MathKt.roundToInt(v0_1.floatValue())));
                                v6 = v0_1.floatValue() == v1.placement.getY() ? 1 : 0;
                                if(v6 != 0) {
                                    goto label_129;
                                }

                                v19 = v0_1;
                            }
                            else {
                            label_129:
                                v19 = v5;
                            }

                            TapSettingsAction v0_3 = v1.selectedAction;
                            Long v6_2 = Long.valueOf(v12);
                            Long v21 = v6_2.longValue() != v1.settings.getTouchDurationMs() ? v6_2 : ((Long)v5);
                            v6_2 = Long.valueOf(v15);
                            Long v22 = v6_2.longValue() != v1.settings.getIntervalMs() ? v6_2 : ((Long)v5);
                            Integer v2_5 = Integer.valueOf(v2_4);
                            Integer v23 = v2_5.intValue() != v1.settings.getRepeatCount() ? v2_5 : ((Integer)v5);
                            Boolean v2_6 = Boolean.valueOf(true);
                            v2_6.booleanValue();
                            if(v14 != null) {
                                if(v1.selectedAction != v14 && !v1.velocityEdited) {
                                    goto label_167;
                                }

                                v24 = v2_6;
                            }
                            else {
                            label_167:
                                v24 = ((Boolean)v5);
                            }

                            TapSettingsEdit v0_4 = new TapSettingsEdit(v18, v19, v0_3, v21, v22, v23, v24);
                            if(v0_4.isEmpty()) {
                                v1.close();
                                return;
                            }

                            v1.saving = true;
                            v1.apply.setEnabled(false);
                            try {
                                if((v1.onSave.invoke(v0_4).booleanValue()) && !v1.isClosed) {
                                    v1.close();
                                }
                            }
                            catch(Throwable v0_5) {
                                v1.saving = false;
                                if(!v1.isClosed) {
                                    v1.apply.setEnabled(true);
                                }

                                throw v0_5;
                            }

                            v1.saving = false;
                            if(v1.isClosed) {
                                return;
                            }

                            v1.apply.setEnabled(true);
                            return;
                        }
                    }
                }
            }
        }

        private final boolean changed(EditText arg2) {
            return Intrinsics.areEqual(arg2.getText().toString(), MapsKt.getValue(this.initialTexts, Integer.valueOf(arg2.getId()))) ^ 1;
        }

        public final void close() {
            if(this.isClosed) {
                return;
            }

            this.isClosed = true;
            this.onClose.invoke();
        }

        public final boolean isClosed() {
            return this.isClosed;
        }

        private final String number(float arg2) {
            if(Math.abs(arg2) <= 3.402823E+38f) {
                String v1 = VistaActivationCapture$Companion$$ExternalSyntheticBackportWithForwarding0.m(new BigDecimal(String.valueOf(arg2))).toPlainString();
                Intrinsics.checkNotNull(v1);
                return v1;
            }

            return String.valueOf(arg2);
        }

        private final Float readCoordinate(EditText arg3, float arg4) {
            CharSequence v0 = null;
            arg3.setError(v0);
            if(!this.changed(arg3)) {
                return Float.valueOf(arg4);
            }

            Float v2 = StringsKt.toFloatOrNull(arg3.getText().toString());
            if(v2 != null && Math.abs(v2.floatValue()) <= 3.402823E+38f) {
                return v2;
            }

            arg3.setError("Introduce una coordenada finita");
            return ((Float)v0);
        }

        private final Long readInteger(EditText arg4, long arg5, long arg7, long arg9) {
            CharSequence v0 = null;
            arg4.setError(v0);
            if(!this.changed(arg4)) {
                return Long.valueOf(arg5);
            }

            Long v3 = StringsKt.toLongOrNull(arg4.getText().toString());
            if(v3 != null) {
                if(!new LongRange(arg7, arg9).contains(v3.longValue())) {
                }
                else {
                    return v3;
                }
            }

            arg4.setError("Usa un entero de " + arg7 + " a " + arg9);
            return ((Long)v0);
        }

        private final void renderMode() {
            int v4;
            Pair[] v0 = new Pair[2];
            int v2 = 0;
            v0[0] = TuplesKt.to(this.mode, Boolean.valueOf(this.advanced ^ 1));
            v0[1] = TuplesKt.to(this.advancedMode, Boolean.valueOf(this.advanced));
            Iterator v0_1 = CollectionsKt.listOf(((Object[])v0)).iterator();
            while(v0_1.hasNext()) {
                Object v1 = v0_1.next();
                Object v3 = ((Pair)v1).component1();
                boolean v1_1 = ((Pair)v1).component2().booleanValue();
                ((TextView)v3).setSelected(v1_1);
                v4 = v1_1 ? drawable.bg_view_button_gold : drawable.bg_vista_premium_field;
                ((TextView)v3).setBackgroundResource(v4);
                String v1_2 = v1_1 ? "#101010" : "#ECECEC";
                ((TextView)v3).setTextColor(Color.parseColor(v1_2));
            }

            LinearLayout v0_2 = this.advancedGroup;
            int v3_1 = 8;
            int v1_3 = this.advanced ? 0 : v3_1;
            v0_2.setVisibility(v1_3);
            v0_2 = this.durationGroup;
            v1_3 = this.advanced ? v3_1 : 0;
            v0_2.setVisibility(v1_3);
            TapSettingsAction v0_3 = this.activeAdvancedAction();
            LinearLayout v1_4 = this.burstGroup;
            v4 = v0_3 == TapSettingsAction.BURST ? 0 : v3_1;
            v1_4.setVisibility(v4);
            ViewParent v5 = this.velocity.getParent();
            Intrinsics.checkNotNull(v5, "null cannot be cast to non-null type android.view.View");
            if(v0_3 != null) {
            }
            else {
                v2 = v3_1;
            }

            ((View)v5).setVisibility(v2);
        }
    }

    public static final int $stable;
    public static final TapComponentSettingsDialog INSTANCE;

    static {
        TapComponentSettingsDialog.INSTANCE = new TapComponentSettingsDialog();
    }

    private TapComponentSettingsDialog() {
        super();
    }

    public final Dialog show$app(Context arg22, ComponentPlacement arg23, TapComponent arg24, Function1 arg25) {
        Context v0 = arg22;
        Intrinsics.checkNotNullParameter(v0, "context");
        ComponentPlacement v4 = arg23;
        Intrinsics.checkNotNullParameter(v4, "placement");
        TapComponent v5 = arg24;
        Intrinsics.checkNotNullParameter(v5, "settings");
        Function1 v6 = arg25;
        Intrinsics.checkNotNullParameter(v6, "onSave");
        ObjectRef v1 = new ObjectRef();
        TapComponentSettingsDialog$show$dialog$1 v8 = new TapComponentSettingsDialog$show$dialog$1(v0, v1);
        v8.requestWindowFeature(1);
        Window v2 = v8.getWindow();
        if(v2 != null) {
            v2.setWindowAnimations(style.VistaJoystickWindowAnimations);
        }

        View v3 = LayoutInflater.from(v0).inflate(layout.configurar_toque, null);
        Intrinsics.checkNotNull(v3);
        v1.element = new Form(v3, v4, v5, v6, new TapComponentSettingsDialog$$ExternalSyntheticLambda0(v8));
        v8.setOnDismissListener(new TapComponentSettingsDialog$$ExternalSyntheticLambda1(v1));
        v8.setContentView(v3);
        Window v0_1 = v8.getWindow();
        if(v0_1 != null) {
            v0_1.setBackgroundDrawable(new ColorDrawable(0));
        }

        v0_1 = v8.getWindow();
        if(v0_1 != null) {
            v0_1.setType(0x7F6);
        }

        v0_1 = v8.getWindow();
        if(v0_1 != null) {
            v0_1.setGravity(17);
        }

        Binding v0_2 = AdaptiveWindowSizing.INSTANCE.bind(v8, WindowType.LARGE_FORM, new WindowSizingConfig(null, null, 0, 0, Integer.valueOf(840), null, null, Float.valueOf(0.94f), 0x6F, null), true);
        SessionOverlayWindowsKt.showSessionDialog(v8);
        v0_2.refresh();
        v0 = v8.getContext();
        Intrinsics.checkNotNullExpressionValue(v0, "getContext(...)");
        CursorOverlayOrderKt.bringCursorAboveWindow(v0);
        return v8;
    }

    static final Unit show$lambda$0(TapComponentSettingsDialog$show$dialog$1 arg0) {
        arg0.dismiss();
        return Unit.INSTANCE;
    }

    static final void show$lambda$1(ObjectRef arg0, DialogInterface arg1) {
        Object v0 = arg0.element;
        if(v0 != null) {
            ((Form)v0).close();
        }
    }
}

