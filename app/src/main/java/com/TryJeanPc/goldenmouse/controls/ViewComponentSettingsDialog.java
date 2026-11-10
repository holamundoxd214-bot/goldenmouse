package com.TryJeanPc.goldenmouse.controls;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.TryJeanPc.goldenmouse.R$id;
import com.TryJeanPc.goldenmouse.R$layout;
import com.TryJeanPc.goldenmouse.R$style;
import com.TryJeanPc.goldenmouse.cursor.CursorOverlayOrderKt;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import com.TryJeanPc.goldenmouse.profile.GameProfileKt;
import com.TryJeanPc.goldenmouse.profile.ViewComponent;
import com.TryJeanPc.goldenmouse.service.SessionOverlayWindowsKt;
import com.TryJeanPc.goldenmouse.ui.AdaptiveWindowSizing$Binding;
import com.TryJeanPc.goldenmouse.ui.AdaptiveWindowSizing;
import com.TryJeanPc.goldenmouse.ui.WindowSizingConfig;
import com.TryJeanPc.goldenmouse.ui.WindowType;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jº\u0001\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\u0016\b\u0002\u0010\u000E\u001A\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000F2(\b\u0002\u0010\u0012\u001A\"\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\u000F\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0013\u0018\u00010\u000F2\u0016\b\u0002\u0010\u0014\u001A\u0010\u0012\u0004\u0012\u00020\u000B\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000F2\u001C\b\u0002\u0010\u0015\u001A\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00162\u0018\u0010\u0017\u001A\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00050\u0016J\u0093\u0001\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00050\u00132\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0018\u0010\u0017\u001A\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00050\u00162\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00050\u00132\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\u0016\b\u0002\u0010\u0014\u001A\u0010\u0012\u0004\u0012\u00020\u000B\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000F2\u001C\b\u0002\u0010\u0015\u001A\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0016H\u0000¢\u0006\u0002\b\u001E¨\u0006\u001F"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/ViewComponentSettingsDialog;", "", "<init>", "()V", "show", "", "context", "Landroid/content/Context;", "placement", "Lcom/TryJeanPc/goldenmouse/controls/ComponentPlacement;", "settings", "Lcom/TryJeanPc/goldenmouse/profile/ViewComponent;", "currentKey", "", "onRebindKey", "Lkotlin/Function1;", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "", "onCaptureBinding", "Lkotlin/Function0;", "onValidate", "onSave", "Lkotlin/Function2;", "onApply", "bindContent", "root", "Landroid/view/View;", "onClose", "inlineCapture", "Lcom/TryJeanPc/goldenmouse/controls/VistaInlineBindingCapture;", "bindContent$app", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class ViewComponentSettingsDialog {
    public static final int $stable;
    public static final ViewComponentSettingsDialog INSTANCE;

    static {
        ViewComponentSettingsDialog.INSTANCE = new ViewComponentSettingsDialog();
    }

    private ViewComponentSettingsDialog() {
        super();
    }

    public final Function0 bindContent$app(View arg31, ComponentPlacement arg32, ViewComponent arg33, Function2 arg34, Function0 arg35, VistaInlineBindingCapture arg36, Function1 arg37, Function2 arg38) {
        String v0_5;
        Intrinsics.checkNotNullParameter(arg31, "root");
        Intrinsics.checkNotNullParameter(arg32, "placement");
        Intrinsics.checkNotNullParameter(arg33, "settings");
        Intrinsics.checkNotNullParameter(arg34, "onApply");
        Intrinsics.checkNotNullParameter(arg35, "onClose");
        Intrinsics.checkNotNullParameter(arg36, "inlineCapture");
        Intrinsics.checkNotNullParameter(arg37, "onValidate");
        View v12 = arg31.findViewById(id.editPosicionX);
        View v13 = arg31.findViewById(id.editPosicionY);
        View v14 = arg31.findViewById(id.editSensibilidadX);
        View v2 = arg31.findViewById(id.editSensibilidadY);
        View v3 = arg31.findViewById(id.switchGoldenPrecisionPlus);
        View v8 = arg31.findViewById(id.switchSensibilidadSniper);
        View v5 = arg31.findViewById(id.groupSniper);
        View v9 = arg31.findViewById(id.btnTeclaSniper);
        View v10 = arg31.findViewById(id.editMultiplicadorSniper);
        View v6 = arg31.findViewById(id.btnTeclaCambioRapido);
        View v7 = arg31.findViewById(id.editTiempoCambioCursor);
        View v11 = arg31.findViewById(id.seekTiempoCambioCursor);
        ObjectRef v15 = new ObjectRef();
        v15.element = arg33.getQuickChangeBinding();
        ObjectRef v1 = new ObjectRef();
        v1.element = InputBinding.Companion.fromDisplayName(arg33.getSniperKey());
        BooleanRef v0 = new BooleanRef();
        String v16 = String.valueOf(MathKt.roundToInt(arg32.getX()));
        String v17 = String.valueOf(MathKt.roundToInt(arg32.getY()));
        ((EditText)v12).setText(v16);
        ((EditText)v13).setText(v17);
        ((EditText)v14).setText(String.valueOf(GameProfileKt.normalizeViewSensitivity(arg33.getSensitivityX())));
        ((EditText)v2).setText(String.valueOf(GameProfileKt.normalizeViewSensitivity(arg33.getSensitivityY())));
        ((Switch)v3).setChecked(arg33.getGoldenPrecisionPlus());
        BooleanRef v30 = v0;
        EditText[] v0_1 = new EditText[6];
        int v18 = 6;
        v0_1[0] = v12;
        v0_1[1] = v13;
        int v20 = 2;
        v0_1[v20] = v14;
        int v21 = 3;
        v0_1[v21] = v2;
        int v22 = 4;
        v0_1[v22] = v10;
        int v23 = 5;
        v0_1[v23] = v7;
        Iterator v0_2;
        for(v0_2 = CollectionsKt.listOf(((Object[])v0_1)).iterator(); v0_2.hasNext(); v0_2 = v0_2) {
            v0_2.next().setShowSoftInputOnFocus(false);
        }

        ((Switch)v8).setChecked(arg33.getSniperEnabled());
        int v0_3 = arg33.getSniperEnabled() ? 0 : 8;
        v5.setVisibility(v0_3);
        Object v0_4 = v1.element;
        String v4 = "SIN ASIGNAR";
        if(v0_4 != null) {
            v0_5 = ((InputBinding)v0_4).displayName();
            if(v0_5 != null) {
            }
            else {
                goto label_123;
            }
        }
        else {
        label_123:
            v0_5 = v4;
        }

        ((TextView)v9).setText(((CharSequence)v0_5));
        ((EditText)v10).setText(String.valueOf(arg33.getSniperMultiplier()));
        v0_4 = v15.element;
        if(v0_4 != null) {
            v0_5 = ((InputBinding)v0_4).displayName();
            if(v0_5 != null) {
            }
            else {
                goto label_133;
            }
        }
        else {
        label_133:
            v0_5 = v4;
        }

        ((TextView)v6).setText(((CharSequence)v0_5));
        ObjectRef v24 = v1;
        View v4_1 = v2;
        v0_5 = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf((((double)arg33.getQuickChangeDelayMs())) / 1000)}, 1));
        Intrinsics.checkNotNullExpressionValue(v0_5, "format(...)");
        ((EditText)v7).setText(((CharSequence)v0_5));
        ((SeekBar)v11).setProgress(RangesKt.coerceIn(((int)((arg33.getQuickChangeDelayMs() + 50) / 100)), 0, 50));
        View[] v0_6 = new View[7];
        v0_6[0] = v8;
        v0_6[1] = v5;
        v0_6[v20] = v9;
        v0_6[v21] = v10;
        v0_6[v22] = v6;
        v0_6[v23] = v7;
        v0_6[v18] = v11;
        v0_2 = CollectionsKt.listOf(((Object[])v0_6)).iterator();
        while(v0_2.hasNext()) {
            v0_2.next().setEnabled(true);
        }

        ((Switch)v8).setOnCheckedChangeListener(new ViewComponentSettingsDialog$$ExternalSyntheticLambda9(arg36, v5));
        v9.setOnClickListener(new ViewComponentSettingsDialog$$ExternalSyntheticLambda10(v30, arg36, v9, arg37, arg33, ((Switch)v8), v15, v24));
        v6.setOnClickListener(new ViewComponentSettingsDialog$$ExternalSyntheticLambda11(v30, arg36, v6, arg37, arg33, ((Switch)v8), v24, v15));
        v6.setContentDescription("Asignar tecla de Cambio rápido. Mantén pulsado para quitarla.");
        v6.setOnLongClickListener(new ViewComponentSettingsDialog$$ExternalSyntheticLambda12(v30, arg36, v15, v6));
        BooleanRef v2_1 = new BooleanRef();
        v7.addTextChangedListener(new ViewComponentSettingsDialog$bindContent$8(v2_1, v30, v7, ((SeekBar)v11)));
        ((SeekBar)v11).setOnSeekBarChangeListener(new ViewComponentSettingsDialog$bindContent$9(v2_1, v30, v7));
        arg31.findViewById(id.btnCancelarVista).setOnClickListener(new ViewComponentSettingsDialog$$ExternalSyntheticLambda1(v30, arg36, arg35));
        arg31.findViewById(id.btnAplicarVista).setOnClickListener(new ViewComponentSettingsDialog$$ExternalSyntheticLambda2(v30, v12, v13, v14, v4_1, v10, v7, arg33, v8, v24, v15, v3, arg37, v16, arg32, v17, arg38, arg34, arg31, arg36, arg35));
        return new ViewComponentSettingsDialog$$ExternalSyntheticLambda3(v30, arg36);
    }

    public static Function0 bindContent$app$default(ViewComponentSettingsDialog arg13, View arg14, ComponentPlacement arg15, ViewComponent arg16, Function2 arg17, Function0 arg18, VistaInlineBindingCapture arg19, Function1 arg20, Function2 arg21, int arg22, Object arg23) {
        Function1 v11_1;
        int v0 = arg22;
        Function1 v2 = null;
        VistaInlineBindingCapture v10 = (v0 & 0x20) != 0 ? new VistaInlineBindingCapture(v2, 1, ((DefaultConstructorMarker)v2)) : arg19;
        if((v0 & 0x40) != 0) {
            ViewComponentSettingsDialog$bindContent$1 v11 = ViewComponentSettingsDialog$bindContent$1.INSTANCE;
        }
        else {
            v11_1 = arg20;
        }

        Function2 v12 = (v0 & 0x80) != 0 ? ((Function2)v2) : arg21;
        return arg13.bindContent$app(arg14, arg15, arg16, arg17, arg18, v10, v11_1, v12);
    }

    private static final void bindContent$closeOnce(BooleanRef arg1, VistaInlineBindingCapture arg2, Function0 arg3) {
        if(arg1.element) {
            return;
        }

        arg1.element = true;
        arg2.close();
        arg3.invoke();
    }

    static final void bindContent$lambda$10(BooleanRef arg0, VistaInlineBindingCapture arg1, TextView arg2, Function1 arg3, ViewComponent arg4, Switch arg5, ObjectRef arg6, ObjectRef arg7, View arg8) {
        if(!arg0.element) {
            Intrinsics.checkNotNull(arg2);
            arg1.start(arg2, new ViewComponentSettingsDialog$$ExternalSyntheticLambda0(arg3, arg4, arg5, arg6), new ViewComponentSettingsDialog$$ExternalSyntheticLambda4(arg7, arg2));
        }
    }

    static final String bindContent$lambda$10$lambda$8(Function1 arg24, ViewComponent arg25, Switch arg26, ObjectRef arg27, InputBinding arg28) {
        String v0_1;
        InputBinding v1 = arg28;
        Intrinsics.checkNotNullParameter(v1, "selected");
        boolean v12 = arg26.isChecked();
        Object v0 = arg27.element;
        if(v0 != null) {
            v0_1 = ((InputBinding)v0).displayName();
            if(v0_1 == null) {
                goto label_9;
            }
        }
        else {
        label_9:
            v0_1 = arg25.getSniperKey();
        }

        return arg24.invoke(ViewComponent.copy$default(arg25, false, 0f, 0f, false, false, 0f, 0f, 0f, 0f, null, v12, v0_1, 0f, null, null, false, v1, 0, false, 0x6F3FF, null));
    }

    static final Unit bindContent$lambda$10$lambda$9(ObjectRef arg1, TextView arg2, InputBinding arg3) {
        Intrinsics.checkNotNullParameter(arg3, "selected");
        arg1.element = arg3;
        arg2.setText(arg3.displayName());
        return Unit.INSTANCE;
    }

    static final boolean bindContent$lambda$11(BooleanRef arg0, VistaInlineBindingCapture arg1, ObjectRef arg2, TextView arg3, View arg4) {
        if(!arg0.element) {
            arg1.cancel();
            arg2.element = null;
            arg3.setText("SIN ASIGNAR");
        }

        return 1;
    }

    static final void bindContent$lambda$13(BooleanRef arg0, VistaInlineBindingCapture arg1, Function0 arg2, View arg3) {
        ViewComponentSettingsDialog.bindContent$closeOnce(arg0, arg1, arg2);
    }

    static final void bindContent$lambda$15(BooleanRef arg31, EditText arg32, EditText arg33, EditText arg34, EditText arg35, EditText arg36, EditText arg37, ViewComponent arg38, Switch arg39, ObjectRef arg40, ObjectRef arg41, Switch arg42, Function1 arg43, String arg44, ComponentPlacement arg45, String arg46, Function2 arg47, Function2 arg48, View arg49, VistaInlineBindingCapture arg50, Function0 arg51, View arg52) {
        String v4_3;
        BooleanRef v0 = arg31;
        Function2 v1 = arg47;
        if(v0.element) {
        }
        else {
            Intrinsics.checkNotNull(arg32);
            Float v2 = ViewComponentSettingsDialog.bindContent$readNumber(arg32);
            if(v2 != null) {
                float v2_1 = v2.floatValue();
                Intrinsics.checkNotNull(arg33);
                Float v3 = ViewComponentSettingsDialog.bindContent$readNumber(arg33);
                if(v3 != null) {
                    float v3_1 = v3.floatValue();
                    float v5 = 3.402823E+38f;
                    if(Math.abs(v2_1) <= v5 && Math.abs(v3_1) <= v5) {
                        Intrinsics.checkNotNull(arg34);
                        Float v4 = ViewComponentSettingsDialog.bindContent$readNumber(arg34);
                        if(v4 != null) {
                            float v4_1 = v4.floatValue();
                            Intrinsics.checkNotNull(arg35);
                            Float v6 = ViewComponentSettingsDialog.bindContent$readNumber(arg35);
                            if(v6 != null) {
                                float v6_1 = v6.floatValue();
                                Intrinsics.checkNotNull(arg36);
                                Float v7 = ViewComponentSettingsDialog.bindContent$readNumber(arg36);
                                if(v7 != null) {
                                    float v21 = v7.floatValue();
                                    if(Math.abs(v21) <= v5) {
                                        if(v21 <= 0f) {
                                        }
                                        else {
                                            Long v5_1 = GameProfileKt.parseVistaQuickChangeSeconds(arg37.getText().toString());
                                            if(v5_1 == null) {
                                                arg37.setError("Usa de 0 a 5 segundos, con hasta dos decimales");
                                                return;
                                            }
                                            else {
                                                float v10 = GameProfileKt.normalizeViewSensitivity(v4_1);
                                                float v11 = GameProfileKt.normalizeViewSensitivity(v6_1);
                                                boolean v19 = arg39.isChecked();
                                                Object v4_2 = arg40.element;
                                                if(v4_2 != null) {
                                                    v4_3 = ((InputBinding)v4_2).displayName();
                                                    if(v4_3 == null) {
                                                        goto label_51;
                                                    }
                                                }
                                                else {
                                                label_51:
                                                    v4_3 = arg38.getSniperKey();
                                                }

                                                ViewComponent v4_4 = ViewComponent.copy$default(arg38, false, v10, v11, false, false, 0f, 0f, 0f, 0f, null, v19, v4_3, v21, null, null, false, arg41.element, v5_1.longValue(), arg42.isChecked(), 0xE3F9, null);
                                                Object v5_2 = arg43.invoke(v4_4);
                                                if(v5_2 != null) {
                                                    Toast.makeText(arg49.getContext(), ((CharSequence)v5_2), 1).show();
                                                    return;
                                                }

                                                ComponentPlacement v5_3 = null;
                                                v2_1 = Intrinsics.areEqual(arg32.getText().toString(), arg44) ? arg45.getX() : ((float)MathKt.roundToInt(v2_1));
                                                v3_1 = Intrinsics.areEqual(arg33.getText().toString(), arg46) ? arg45.getY() : ((float)MathKt.roundToInt(v3_1));
                                                super(v2_1, v3_1, null, 4, null);
                                                Object v2_2 = v5_3;
                                                if(v1 == null) {
                                                    arg48.invoke(v2_2, v4_4);
                                                }
                                                else if(!v1.invoke(v2_2, v4_4).booleanValue()) {
                                                    return;
                                                }

                                                ViewComponentSettingsDialog.bindContent$closeOnce(v0, arg50, arg51);
                                                return;
                                            }
                                        }
                                    }

                                    arg36.setError("El multiplicador debe ser positivo y finito");
                                    return;
                                }
                                else {
                                    return;
                                }
                            }
                            else {
                                return;
                            }
                        }
                        else {
                            return;
                        }
                    }

                    String v1_1 = "Introduce una coordenada finita";
                    if(Float.compare(Math.abs(v2_1), v5) <= 0) {
                    }
                    else {
                        arg32.setError(v1_1);
                    }

                    if(Math.abs(v3_1) <= v5) {
                        return;
                    }

                    arg33.setError(((CharSequence)v1_1));
                }
            }
        }
    }

    static final Unit bindContent$lambda$16(BooleanRef arg1, VistaInlineBindingCapture arg2) {
        arg1.element = true;
        arg2.close();
        return Unit.INSTANCE;
    }

    static final void bindContent$lambda$4(VistaInlineBindingCapture arg1, View arg2, CompoundButton arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<unused var>");
        arg1.cancel();
        int v1 = arg4 ? 0 : 8;
        arg2.setVisibility(v1);
    }

    static final void bindContent$lambda$7(BooleanRef arg0, VistaInlineBindingCapture arg1, TextView arg2, Function1 arg3, ViewComponent arg4, Switch arg5, ObjectRef arg6, ObjectRef arg7, View arg8) {
        if(!arg0.element) {
            Intrinsics.checkNotNull(arg2);
            arg1.start(arg2, new ViewComponentSettingsDialog$$ExternalSyntheticLambda5(arg3, arg4, arg5, arg6), new ViewComponentSettingsDialog$$ExternalSyntheticLambda6(arg7, arg2));
        }
    }

    static final String bindContent$lambda$7$lambda$5(Function1 arg24, ViewComponent arg25, Switch arg26, ObjectRef arg27, InputBinding arg28) {
        Intrinsics.checkNotNullParameter(arg28, "selected");
        return arg24.invoke(ViewComponent.copy$default(arg25, false, 0f, 0f, false, false, 0f, 0f, 0f, 0f, null, arg26.isChecked(), arg28.displayName(), 0f, null, null, false, arg27.element, 0, false, 0x6F3FF, null));
    }

    static final Unit bindContent$lambda$7$lambda$6(ObjectRef arg1, TextView arg2, InputBinding arg3) {
        Intrinsics.checkNotNullParameter(arg3, "selected");
        arg1.element = arg3;
        arg2.setText(arg3.displayName());
        return Unit.INSTANCE;
    }

    private static final Float bindContent$readNumber(EditText arg2) {
        arg2.setError(null);
        Float v0 = StringsKt.toFloatOrNull(arg2.getText().toString());
        if(v0 == null) {
            arg2.setError("Introduce un número válido");
        }

        return v0;
    }

    public final void show(Context arg24, ComponentPlacement arg25, ViewComponent arg26, String arg27, Function1 arg28, Function1 arg29, Function1 arg30, Function2 arg31, Function2 arg32) {
        Context v0 = arg24;
        Intrinsics.checkNotNullParameter(v0, "context");
        ComponentPlacement v4 = arg25;
        Intrinsics.checkNotNullParameter(v4, "placement");
        ViewComponent v5 = arg26;
        Intrinsics.checkNotNullParameter(v5, "settings");
        Intrinsics.checkNotNullParameter(arg27, "currentKey");
        Function1 v9 = arg30;
        Intrinsics.checkNotNullParameter(v9, "onValidate");
        Function2 v6 = arg32;
        Intrinsics.checkNotNullParameter(v6, "onApply");
        VistaInlineBindingCapture v8 = new VistaInlineBindingCapture(arg29);
        ViewComponentSettingsDialog$show$dialog$1 v1 = new ViewComponentSettingsDialog$show$dialog$1(v0, v8);
        v1.requestWindowFeature(1);
        Window v2 = v1.getWindow();
        if(v2 != null) {
            v2.setWindowAnimations(style.VistaJoystickWindowAnimations);
        }

        View v3 = LayoutInflater.from(v0).inflate(layout.configurar_vista, null);
        Intrinsics.checkNotNull(v3);
        v1.setOnDismissListener(new ViewComponentSettingsDialog$$ExternalSyntheticLambda8(this.bindContent$app(v3, v4, v5, v6, new ViewComponentSettingsDialog$$ExternalSyntheticLambda7(v1), v8, v9, arg31)));
        v1.setContentView(v3);
        Window v0_1 = v1.getWindow();
        if(v0_1 != null) {
            v0_1.setBackgroundDrawable(new ColorDrawable(0));
        }

        v0_1 = v1.getWindow();
        if(v0_1 != null) {
            v0_1.setType(0x7F6);
        }

        v0_1 = v1.getWindow();
        if(v0_1 != null) {
            v0_1.setGravity(17);
        }

        Binding v0_2 = AdaptiveWindowSizing.INSTANCE.bind(v1, WindowType.LARGE_FORM, new WindowSizingConfig(null, null, 0, 0, Integer.valueOf(840), null, null, Float.valueOf(0.94f), 0x6F, null), true);
        SessionOverlayWindowsKt.showSessionDialog(v1);
        v0_2.refresh();
        v0 = v1.getContext();
        Intrinsics.checkNotNullExpressionValue(v0, "getContext(...)");
        CursorOverlayOrderKt.bringCursorAboveWindow(v0);
    }

    public static void show$default(ViewComponentSettingsDialog arg12, Context arg13, ComponentPlacement arg14, ViewComponent arg15, String arg16, Function1 arg17, Function1 arg18, Function1 arg19, Function2 arg20, Function2 arg21, int arg22, Object arg23) {
        ViewComponentSettingsDialog v2_1;
        Function2 v11;
        ViewComponent v5;
        ComponentPlacement v4;
        Context v3;
        Function2 v10;
        Function1 v9_1;
        int v0 = arg22;
        String v6 = (v0 & 8) != 0 ? arg15.getToggleCursorKey() : arg16;
        Function1 v2 = null;
        Function1 v7 = (v0 & 16) != 0 ? v2 : arg17;
        Function1 v8 = (v0 & 0x20) != 0 ? v2 : arg18;
        if((v0 & 0x40) != 0) {
            ViewComponentSettingsDialog$show$1 v9 = ViewComponentSettingsDialog$show$1.INSTANCE;
        }
        else {
            v9_1 = arg19;
        }

        if((v0 & 0x80) != 0) {
            v10 = ((Function2)v2);
            v3 = arg13;
            v4 = arg14;
            v5 = arg15;
            v11 = arg21;
            v2_1 = arg12;
        }
        else {
            v10 = arg20;
            v2_1 = arg12;
            v3 = arg13;
            v4 = arg14;
            v5 = arg15;
            v11 = arg21;
        }

        v2_1.show(v3, v4, v5, v6, v7, v8, v9_1, v10, v11);
    }

    static final Unit show$lambda$0(ViewComponentSettingsDialog$show$dialog$1 arg0) {
        arg0.dismiss();
        return Unit.INSTANCE;
    }

    static final void show$lambda$1(Function0 arg0, DialogInterface arg1) {
        arg0.invoke();
    }
}

