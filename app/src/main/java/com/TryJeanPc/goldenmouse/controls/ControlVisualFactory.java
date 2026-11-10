package com.TryJeanPc.goldenmouse.controls;

import android.content.Context;
import android.util.Log;
import android.view.View;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tJ\u000E\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\tR\u000E\u0010\f\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/ControlVisualFactory;", "", "<init>", "()V", "crear", "Landroid/view/View;", "context", "Landroid/content/Context;", "tipoGuardado", "", "normalizarTipo", "tipo", "TAG", "TIPO_TOCAR_ANTIGUO", "TIPO_VISTA_ANTIGUO", "TIPO_TAP", "TIPO_JOYSTICK", "TIPO_DISPARO", "TIPO_CAMARA", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class ControlVisualFactory {
    public static final int $stable = 0;
    public static final ControlVisualFactory INSTANCE = null;
    private static final String TAG = "GOLDEN_UI";
    private static final String TIPO_CAMARA = "CAMARA";
    private static final String TIPO_DISPARO = "DISPARO";
    private static final String TIPO_JOYSTICK = "JOYSTICK";
    private static final String TIPO_TAP = "TAP";
    private static final String TIPO_TOCAR_ANTIGUO = "TOCAR";
    private static final String TIPO_VISTA_ANTIGUO = "VISTA";

    static {
        ControlVisualFactory.INSTANCE = new ControlVisualFactory();
    }

    private ControlVisualFactory() {
        super();
    }

    public final View crear(Context arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        Intrinsics.checkNotNullParameter(arg3, "tipoGuardado");
        String v1 = this.normalizarTipo(arg3);
        switch(v1.hashCode()) {
            case -1905230500: {
                if(!v1.equals("DISPARO")) {
                    return null;
                }

                return new BotonDisparoBlueStacks(arg2);
            }
            case -854989634: {
                if(!v1.equals("MACRO_SCRIPT")) {
                    return null;
                }

                return new BotonMacroScript(arg2);
            }
            case -155485892: {
                if(!v1.equals("JOYSTICK")) {
                    return null;
                }

                return new JoystickBlueStacks(arg2);
            }
            case 82819: {
                if(v1.equals("TAP")) {
                    goto label_19;
                }

                break;
            }
            case 1980540961: {
                if(!v1.equals("CAMARA")) {
                    return null;
                }

                return new BotonVistaBlueStacks(arg2);
            }
            default: {
                break;
            }
        }

        return null;
    label_19:
        return new BotonTapBlueStacks(arg2);
    }

    public final String normalizarTipo(String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "tipo");
        String v2 = StringsKt.trim(((CharSequence)arg3)).toString().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(v2, "toUpperCase(...)");
        if(Intrinsics.areEqual(v2, "TOCAR")) {
            arg3 = "TAP";
        }
        else if(Intrinsics.areEqual(v2, "VISTA")) {
            arg3 = "CAMARA";
        }
        else {
            arg3 = v2;
        }

        if(!Intrinsics.areEqual(v2, arg3)) {
            Log.d("GOLDEN_UI", "Tipo normalizado " + v2 + " -> " + arg3);
        }

        return arg3;
    }
}

