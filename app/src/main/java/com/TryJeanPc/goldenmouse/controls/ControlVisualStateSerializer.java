package com.TryJeanPc.goldenmouse.controls;

import android.util.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\n\u001A\u00020\u0005J\u0012\u0010\u000B\u001A\u0004\u0018\u00010\b2\u0006\u0010\n\u001A\u00020\fH\u0002J\u0017\u0010\r\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0002¢\u0006\u0002\u0010\u0011R\u000E\u0010\u0012\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/ControlVisualStateSerializer;", "", "<init>", "()V", "serialize", "", "controls", "", "Lcom/TryJeanPc/goldenmouse/controls/ControlVisualState;", "deserialize", "json", "deserializeControl", "Lorg/json/JSONObject;", "normalizeCoordinate", "", "value", "", "(D)Ljava/lang/Float;", "TAG", "VERSION", "", "KEY_VERSION", "KEY_CONTROLS", "KEY_TIPO", "KEY_X", "KEY_Y", "KEY_WIDTH", "KEY_HEIGHT", "KEY_TECLA", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class ControlVisualStateSerializer {
    public static final int $stable = 0;
    public static final ControlVisualStateSerializer INSTANCE = null;
    private static final String KEY_CONTROLS = "controls";
    private static final String KEY_HEIGHT = "height";
    private static final String KEY_TECLA = "tecla";
    private static final String KEY_TIPO = "tipo";
    private static final String KEY_VERSION = "version";
    private static final String KEY_WIDTH = "width";
    private static final String KEY_X = "x";
    private static final String KEY_Y = "y";
    private static final String TAG = "GOLDEN_CONFIG";
    private static final int VERSION = 2;

    static {
        ControlVisualStateSerializer.INSTANCE = new ControlVisualStateSerializer();
    }

    private ControlVisualStateSerializer() {
        super();
    }

    public final List deserialize(String arg6) {
        String v5 = "Version de configuracion no soportada: ";
        Intrinsics.checkNotNullParameter(arg6, "json");
        String v1 = "GOLDEN_CONFIG";
        if(StringsKt.isBlank(arg6)) {
            Log.d(v1, "JSON cargado controles=0");
            return CollectionsKt.emptyList();
        }

        try {
            JSONObject v0 = new JSONObject(arg6);
            int v6 = v0.optInt("version", -1);
            if(v6 != 2) {
                Log.e(v1, v5 + v6);
                return CollectionsKt.emptyList();
            }

            JSONArray v5_2 = v0.optJSONArray("controls");
            if(v5_2 == null) {
                v5_2 = new JSONArray();
            }

            List v6_1 = CollectionsKt.createListBuilder();
            int v0_1 = v5_2.length();
            int v2;
            for(v2 = 0; v2 < v0_1; ++v2) {
                JSONObject v3 = v5_2.optJSONObject(v2);
                if(v3 == null) {
                }
                else {
                    ControlVisualState v3_1 = ControlVisualStateSerializer.INSTANCE.deserializeControl(v3);
                    if(v3_1 != null) {
                        v6_1.add(v3_1);
                    }
                }
            }

            List v5_3 = CollectionsKt.build(v6_1);
            Log.d(v1, "JSON cargado controles=" + v5_3.size());
            return v5_3;
        }
        catch(Exception v5_1) {
            Log.e(v1, "No se pudo cargar JSON de controles", ((Throwable)v5_1));
            return CollectionsKt.emptyList();
        }
    }

    private final ControlVisualState deserializeControl(JSONObject arg11) {
        String v9;
        ControlVisualFactory v0 = ControlVisualFactory.INSTANCE;
        String v1 = arg11.optString("tipo");
        String v2 = "optString(...)";
        Intrinsics.checkNotNullExpressionValue(v1, v2);
        String v4 = StringsKt.trim(v0.normalizarTipo(v1)).toString();
        ControlVisualState v1_1 = null;
        if(v4.length() == 0) {
            return v1_1;
        }

        double v5 = NaN;
        Float v0_1 = this.normalizeCoordinate(arg11.optDouble("x", v5));
        if(v0_1 != null) {
            float v0_2 = v0_1.floatValue();
            Float v10 = this.normalizeCoordinate(arg11.optDouble("y", v5));
            if(v10 != null) {
                float v6 = v10.floatValue();
                int v7 = RangesKt.coerceAtLeast(arg11.optInt("width", 0), 0);
                int v8 = RangesKt.coerceAtLeast(arg11.optInt("height", 0), 0);
                String v10_1 = "tecla";
                if(!arg11.isNull(v10_1)) {
                    v10_1 = arg11.optString(v10_1);
                    Intrinsics.checkNotNullExpressionValue(v10_1, v2);
                    v10_1 = StringsKt.trim(((CharSequence)v10_1)).toString();
                    if(v10_1.length() > 0) {
                        v9 = v10_1;
                    }
                    else {
                        goto label_34;
                    }
                }
                else {
                label_34:
                    v9 = ((String)v1_1);
                }

                return new ControlVisualState(v4, v0_2, v6, v7, v8, v9);
            }
        }

        return v1_1;
    }

    private final Float normalizeCoordinate(double arg5) {
        Float v0 = null;
        if(Double.compare(Math.abs(arg5), 1.797693E+308) <= 0) {
            Float v4 = Float.valueOf(((float)arg5));
            if(Math.abs(v4.floatValue()) <= 3.402823E+38f) {
                return v4;
            }
        }

        return v0;
    }

    public final String serialize(List arg8) {
        Object v4_2;
        String v7 = "controls";
        Intrinsics.checkNotNullParameter(arg8, v7);
        JSONArray v0 = new JSONArray();
        Iterator v8 = ((Iterable)arg8).iterator();
        while(v8.hasNext()) {
            Object v1 = v8.next();
            String v2 = StringsKt.trim(ControlVisualFactory.INSTANCE.normalizarTipo(((ControlVisualState)v1).getTipo())).toString();
            if(v2.length() == 0) {
                continue;
            }

            float v4 = 3.402823E+38f;
            if(Math.abs(((ControlVisualState)v1).getX()) > v4) {
                continue;
            }

            if(Math.abs(((ControlVisualState)v1).getY()) > v4) {
                continue;
            }

            String v3 = ((ControlVisualState)v1).getTecla();
            String v4_1 = null;
            if(v3 != null) {
                v3 = StringsKt.trim(((CharSequence)v3)).toString();
                if(v3 != null && v3.length() > 0) {
                    v4_1 = v3;
                }
            }

            JSONObject v3_1 = new JSONObject();
            v3_1.put("tipo", v2);
            v3_1.put("x", ((double)((ControlVisualState)v1).getX()));
            v3_1.put("y", ((double)((ControlVisualState)v1).getY()));
            v3_1.put("width", RangesKt.coerceAtLeast(((ControlVisualState)v1).getWidth(), 0));
            v3_1.put("height", RangesKt.coerceAtLeast(((ControlVisualState)v1).getHeight(), 0));
            if(v4_1 == null) {
                v4_2 = JSONObject.NULL;
            }

            v3_1.put("tecla", v4_2);
            v0.put(v3_1);
        }

        JSONObject v8_1 = new JSONObject();
        v8_1.put("version", 2);
        v8_1.put(v7, v0);
        v7 = v8_1.toString();
        Intrinsics.checkNotNullExpressionValue(v7, "toString(...)");
        Log.d("GOLDEN_CONFIG", "Controles serializados=" + v0.length());
        return v7;
    }
}

