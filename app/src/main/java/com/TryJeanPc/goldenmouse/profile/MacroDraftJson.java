package com.TryJeanPc.goldenmouse.profile;

import com.TryJeanPc.goldenmouse.macro.MacroValidationPolicy;
import com.TryJeanPc.goldenmouse.macro.editor.MacroActionType;
import com.TryJeanPc.goldenmouse.macro.editor.MacroDraft;
import com.TryJeanPc.goldenmouse.macro.editor.MacroEditAction;
import com.TryJeanPc.goldenmouse.macro.editor.MacroPoint;
import com.TryJeanPc.goldenmouse.macro.editor.MacroRunMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0006J\u0010\u0010\u0007\u001A\u00020\u00062\b\u0010\b\u001A\u0004\u0018\u00010\u0001J\u000E\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fJ\u000E\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\n¨\u0006\u000F"}, d2={"Lcom/TryJeanPc/goldenmouse/profile/MacroDraftJson;", "", "<init>", "()V", "encodeComponent", "component", "Lcom/TryJeanPc/goldenmouse/profile/MacroScriptComponent;", "decodeComponent", "settings", "encode", "Lorg/json/JSONObject;", "draft", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroDraft;", "decode", "json", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MacroDraftJson {
    public static final int $stable;
    public static final MacroDraftJson INSTANCE;

    static {
        MacroDraftJson.INSTANCE = new MacroDraftJson();
    }

    private MacroDraftJson() {
        super();
    }

    public final MacroDraft decode(JSONObject arg29) {
        JSONObject v0 = arg29;
        Intrinsics.checkNotNullParameter(v0, "json");
        if(v0.getInt("schemaVersion") == 1) {
            String v1 = v0.getString("mode");
            String v3 = "getString(...)";
            Intrinsics.checkNotNullExpressionValue(v1, v3);
            MacroRunMode v6 = MacroRunMode.valueOf(v1);
            JSONArray v1_1 = v0.getJSONArray("tracks");
            JSONArray v4 = v0.getJSONArray("actions");
            String v5 = v0.getString("name");
            Intrinsics.checkNotNullExpressionValue(v5, v3);
            int v7 = v6 == MacroRunMode.LOOP ? v0.getInt("repetitions") : 1;
            long v8 = v6 == MacroRunMode.LOOP ? v0.getLong("intervalMs") : 0;
            int v0_1 = v1_1.length();
            ArrayList v10 = new ArrayList(v0_1);
            int v12;
            for(v12 = 0; v12 < v0_1; ++v12) {
                v10.add(Integer.valueOf(v1_1.getInt(v12)));
            }

            v0_1 = v4.length();
            ArrayList v1_2 = new ArrayList(v0_1);
            for(v12 = 0; v12 < v0_1; ++v12) {
                JSONObject v13 = v4.getJSONObject(v12);
                String v14 = v13.getString("type");
                Intrinsics.checkNotNullExpressionValue(v14, v3);
                MacroActionType v14_1 = MacroActionType.valueOf(v14);
                String v15 = "track";
                Integer v15_1 = v13.isNull(v15) ? null : Integer.valueOf(v13.getInt(v15));
                Integer v23 = v15_1;
                if(v14_1 == MacroActionType.DELAY) {
                    v15 = v13.getString("scope");
                    String v16 = v23 == null ? "GLOBAL" : "FINGER";
                    if(Intrinsics.areEqual(v15, v16)) {
                        goto label_76;
                    }

                    throw new IllegalArgumentException("Alcance de Delay incompatible con su pista".toString());
                }

            label_76:
                JSONArray v11 = v13.getJSONArray("points");
                long v16_1 = v13.getLong("id");
                long v19 = v13.getLong("startMs");
                long v21 = v13.getLong("durationMs");
                int v13_1 = v11.length();
                ArrayList v15_2 = new ArrayList(v13_1);
                int v2 = 0;
                while(true) {
                    int v29 = v0_1;
                    if(v2 >= v13_1) {
                        break;
                    }

                    v0 = v11.getJSONObject(v2);
                    v15_2.add(new MacroPoint(((float)v0.getDouble("x")), ((float)v0.getDouble("y"))));
                    ++v2;
                    v0_1 = v29;
                    v3 = v3;
                    v4 = v4;
                    v5 = v5;
                }

                v1_2.add(new MacroEditAction(v16_1, v14_1, v19, v21, v23, v15_2));
            }

            MacroDraft v4_1 = new MacroDraft(v5, v6, v7, v8, ((List)v10), v1_2);
            MacroValidationPolicy.INSTANCE.requireValid(v4_1, true);
            return v4_1;
        }

        throw new IllegalArgumentException("Versión de macro no soportada".toString());
    }

    public final MacroScriptComponent decodeComponent(Object arg6) {
        MacroScriptComponent v5_3;
        Object v5_2;
        MacroDraft v5_1;
        String v0 = "macro";
        RejectedMacroPayload v1 = null;
        if(arg6 != null) {
            if(arg6 == JSONObject.NULL) {
            }
            else {
                try {
                    if((arg6 instanceof JSONObject)) {
                        if(arg6.isNull(v0)) {
                            v5_1 = ((MacroDraft)v1);
                        }
                        else {
                            JSONObject v0_1 = arg6.getJSONObject(v0);
                            Intrinsics.checkNotNullExpressionValue(v0_1, "getJSONObject(...)");
                            v5_1 = this.decode(v0_1);
                        }

                        v5_2 = Result.constructor-impl(new MacroScriptComponent(v5_1, v1, 2, ((DefaultConstructorMarker)v1)));
                        goto label_34;
                    }
                    else {
                        throw new IllegalArgumentException("Settings de Macro-Script no es un objeto".toString());
                    }

                    goto label_53;
                }
                catch(Throwable v5) {
                    v5_2 = Result.constructor-impl(ResultKt.createFailure(v5));
                }

            label_34:
                Throwable v0_2 = Result.exceptionOrNull-impl(v5_2);
                if(v0_2 == null) {
                }
                else {
                    String v6 = new JSONObject().put("settings", arg6).toString();
                    Intrinsics.checkNotNullExpressionValue(v6, "toString(...)");
                    v0 = v0_2.getMessage();
                    if(v0 == null) {
                        v0 = "Payload Macro inválido";
                    }

                    v5_3 = new MacroScriptComponent(((MacroDraft)v1), new RejectedMacroPayload(v6, v0), 1, ((DefaultConstructorMarker)v1));
                }

                return v5_3;
            }
        }

    label_53:
        return new MacroScriptComponent(((MacroDraft)v1), v1, 3, ((DefaultConstructorMarker)v1));
    }

    public final JSONObject encode(MacroDraft arg10) {
        Intrinsics.checkNotNullParameter(arg10, "draft");
        MacroValidationPolicy.INSTANCE.requireValid(arg10, true);
        JSONObject v9 = new JSONObject();
        v9.put("schemaVersion", 1);
        v9.put("name", arg10.getName());
        v9.put("mode", arg10.getMode().name());
        if(arg10.getMode() == MacroRunMode.LOOP) {
            v9.put("repetitions", arg10.getRepetitions());
            v9.put("intervalMs", arg10.getIntervalMs());
        }

        v9.put("tracks", new JSONArray(arg10.getTracks()));
        JSONArray v0 = new JSONArray();
        Iterator v10 = arg10.getActions().iterator();
        while(v10.hasNext()) {
            Object v1 = v10.next();
            JSONObject v2 = new JSONObject();
            v2.put("id", ((MacroEditAction)v1).getId());
            v2.put("type", ((MacroEditAction)v1).getType().name());
            v2.put("startMs", ((MacroEditAction)v1).getStartMs());
            v2.put("durationMs", ((MacroEditAction)v1).getDurationMs());
            Integer v3 = ((MacroEditAction)v1).getTrack();
            if(v3 == null) {
                Object v3_1 = JSONObject.NULL;
            }

            v2.put("track", v3);
            if(((MacroEditAction)v1).getType() == MacroActionType.DELAY) {
                String v3_2 = ((MacroEditAction)v1).getTrack() == null ? "GLOBAL" : "FINGER";
                v2.put("scope", v3_2);
            }

            JSONArray v3_3 = new JSONArray();
            Iterator v1_1 = ((MacroEditAction)v1).getPoints().iterator();
            while(v1_1.hasNext()) {
                Object v4 = v1_1.next();
                v3_3.put(new JSONObject().put("x", ((double)((MacroPoint)v4).getX())).put("y", ((double)((MacroPoint)v4).getY())));
            }

            v2.put("points", v3_3);
            v0.put(v2);
        }

        v9.put("actions", v0);
        return v9;
    }

    public final Object encodeComponent(MacroScriptComponent arg2) {
        Intrinsics.checkNotNullParameter(arg2, "component");
        RejectedMacroPayload v1 = arg2.getRejectedPayload();
        if(v1 != null) {
            Object v1_1 = new JSONObject(v1.getSettingsJson()).get("settings");
            Intrinsics.checkNotNullExpressionValue(v1_1, "get(...)");
            return v1_1;
        }

        JSONObject v1_2 = new JSONObject();
        MacroDraft v2 = arg2.getMacro();
        if(v2 != null) {
            v1_2.put("macro", MacroDraftJson.INSTANCE.encode(v2));
        }

        return v1_2;
    }
}

