package com.TryJeanPc.goldenmouse.profile;

import com.TryJeanPc.goldenmouse.controls.VistaActivationCapture$Companion$$ExternalSyntheticBackportWithForwarding0;
import com.TryJeanPc.goldenmouse.macro.editor.MacroDraft;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import java.math.BigDecimal;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A\u000E\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003\u001A\u0015\u0010\u0005\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001A\u00020\u0001¢\u0006\u0002\u0010\b\u001A\u000E\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0001\u001A\f\u0010\f\u001A\u0004\u0018\u00010\r*\u00020\u000E\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000F\u001A\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0010\u001A\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0011\u001A\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0012\u001A\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0013\u001A\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"TYPE_VISTA_LIBRE_VISUAL", "", "normalizeViewSensitivity", "", "value", "parseVistaQuickChangeSeconds", "", "text", "(Ljava/lang/String;)Ljava/lang/Long;", "defaultComponent", "Lcom/TryJeanPc/goldenmouse/profile/ControlComponent;", "type", "primaryBinding", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "Lcom/TryJeanPc/goldenmouse/profile/ProfileControl;", "TYPE_TAP", "TYPE_MACRO_SCRIPT", "TYPE_JOYSTICK", "TYPE_VIEW", "TYPE_FIRE", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class GameProfileKt {
    public static final String TYPE_FIRE = "DISPARO";
    public static final String TYPE_JOYSTICK = "JOYSTICK";
    public static final String TYPE_MACRO_SCRIPT = "MACRO_SCRIPT";
    public static final String TYPE_TAP = "TAP";
    public static final String TYPE_VIEW = "CAMARA";
    public static final String TYPE_VISTA_LIBRE_VISUAL = "VISTA_LIBRE_VISUAL";

    public static final ControlComponent defaultComponent(String arg24) {
        Intrinsics.checkNotNullParameter(arg24, "type");
        String v0 = StringsKt.trim(arg24).toString().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(v0, "toUpperCase(...)");
        MacroDraft v2 = null;
        switch(v0.hashCode()) {
            case -1905230500: {
                if(!v0.equals("DISPARO")) {
                    goto label_86;
                }

                return new FireComponent(false, 1, ((DefaultConstructorMarker)v2));
            }
            case -854989634: {
                if(!v0.equals("MACRO_SCRIPT")) {
                    goto label_86;
                }

                return new MacroScriptComponent(v2, ((RejectedMacroPayload)v2), 3, ((DefaultConstructorMarker)v2));
            }
            case -155485892: {
                if(!v0.equals("JOYSTICK")) {
                    goto label_86;
                }

                return new JoystickComponent(0f, 0f, 0f, 0f, 0f, 0f, 0, 0f, false, 0f, 0, false, null, 0f, false, 0x7FFF, null);
            }
            case 81679981: {
                if(v0.equals("VISTA")) {
                    goto label_21;
                }

                break;
            }
            case 1980540961: {
                if(v0.equals("CAMARA")) {
                    goto label_21;
                }

                break;
            }
            default: {
                break;
            }
        }

    label_86:
        return new TapComponent(null, 0, 0, false, 0, 0f, false, 0x7F, null);
    label_21:
        return new ViewComponent(false, 0f, 0f, false, false, 0f, 0f, 0f, 0f, null, false, null, 0f, null, null, false, null, 0, false, 0x7FFFF, null);
    }

    public static final float normalizeViewSensitivity(float arg2) {
        Float v2 = Float.valueOf(arg2);
        if(Math.abs(v2.floatValue()) <= 3.402823E+38f) {
        }
        else {
            v2 = null;
        }

        arg2 = v2 != null ? v2.floatValue() : 2f;
        return RangesKt.coerceAtLeast(arg2, 0f);
    }

    public static final Long parseVistaQuickChangeSeconds(String arg7) {
        Long v7_2;
        Object v7_1;
        BigDecimal v0_1;
        Intrinsics.checkNotNullParameter(arg7, "text");
        try {
            v0_1 = new BigDecimal(StringsKt.replace$default(StringsKt.trim(((CharSequence)arg7)).toString(), ',', '.', false, 4, null));
            int v7 = v0_1.compareTo(BigDecimal.ZERO);
        }
        catch(Throwable v0) {
            goto label_44;
        }

        String v1 = "Failed requirement.";
        if(v7 >= 0) {
            try {
                if(v0_1.compareTo(new BigDecimal("5")) <= 0) {
                    if(VistaActivationCapture$Companion$$ExternalSyntheticBackportWithForwarding0.m(v0_1).scale() <= 2) {
                        v7_1 = Result.constructor-impl(Long.valueOf(v0_1.movePointRight(3).longValueExact()));
                        goto label_45;
                    }
                    else {
                        throw new IllegalArgumentException(v1.toString());
                    }
                }

            label_36:
                throw new IllegalArgumentException(v1.toString());
            }
            catch(Throwable v0) {
            label_44:
                v7_1 = Result.constructor-impl(ResultKt.createFailure(v0));
                goto label_45;
            }
        }

        goto label_36;
    label_45:
        if(Result.isFailure-impl(v7_1)) {
            v7_2 = null;
        }

        return v7_2;
    }

    public static final InputBinding primaryBinding(ProfileControl arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getBindings().get("PRIMARY");
    }
}

