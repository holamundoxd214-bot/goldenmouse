package com.TryJeanPc.goldenmouse.graphics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EJ\u000E\u0010\u000F\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\u000EJ\u0016\u0010\u0011\u001A\u00020\u00122\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0013\u001A\u00020\fR\u0016\u0010\u0006\u001A\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsProfileStore;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "user", "", "load", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsProfile;", "pkg", "", "saved", "", "save", "", "p", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsProfileStore {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007J\u000E\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\u0005¨\u0006\n"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsProfileStore$Companion;", "", "<init>", "()V", "decode", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsProfile;", "raw", "", "encode", "p", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final GraphicsProfile decode(String arg20) {
            Intrinsics.checkNotNullParameter(arg20, "raw");
            JSONObject v1 = new JSONObject(arg20);
            if(v1.getInt("schema") == 1) {
                boolean v4 = v1.getBoolean("texture");
                String v0 = v1.getString("preset");
                Intrinsics.checkNotNullExpressionValue(v0, "getString(...)");
                return new GraphicsProfile(v4, TexturePreset.valueOf(v0), v1.getInt("level"), v1.getBoolean("nearest"), v1.getBoolean("mipNearest"), v1.getInt("hz"), v1.getInt("saturation"), v1.getInt("color"), v1.getInt("resolution"), v1.getInt("fps"), v1.getBoolean("msaa"), v1.getInt("driver"), v1.getInt("mode"), v1.getBoolean("fixed"), v1.getInt("animations"));
            }

            throw new IllegalStateException("Check failed.");
        }

        public final String encode(GraphicsProfile arg3) {
            Intrinsics.checkNotNullParameter(arg3, "p");
            String v2 = new JSONObject().put("schema", 1).put("texture", arg3.getTexture()).put("preset", arg3.getPreset().name()).put("level", arg3.getLevel()).put("nearest", arg3.getNearest()).put("mipNearest", arg3.getMipNearest()).put("hz", arg3.getHz()).put("saturation", arg3.getSaturation()).put("color", arg3.getColor()).put("resolution", arg3.getResolution()).put("fps", arg3.getFps()).put("msaa", arg3.getMsaa()).put("driver", arg3.getDriver()).put("mode", arg3.getMode()).put("fixed", arg3.getFixed()).put("animations", arg3.getAnimations()).toString();
            Intrinsics.checkNotNullExpressionValue(v2, "toString(...)");
            return v2;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final SharedPreferences prefs;
    private final int user;

    static {
        GraphicsProfileStore.Companion = new Companion(null);
        GraphicsProfileStore.$stable = 8;
    }

    public GraphicsProfileStore(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        super();
        this.prefs = arg3.getSharedPreferences("golden_graphics_profiles_v1", 0);
        this.user = Process.myUid() / 100000;
    }

    public final GraphicsProfile load(String arg20) {
        GraphicsProfileStore v0 = this;
        String v1 = arg20;
        Intrinsics.checkNotNullParameter(v1, "pkg");
        if(GraphicsProfileKt.validGraphicsPackage(v1)) {
            String v0_1 = v0.prefs.getString(v0.user + ":" + v1, null);
            if(v0_1 == null) {
                return new GraphicsProfile(false, null, 0, false, false, 0, 0, 0, 0, 0, false, 0, 0, false, 0, 0x7FFF, null);
            }

            return GraphicsProfileStore.Companion.decode(v0_1);
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final void save(String arg3, GraphicsProfile arg4) {
        Intrinsics.checkNotNullParameter(arg3, "pkg");
        Intrinsics.checkNotNullParameter(arg4, "p");
        if(GraphicsProfileKt.validGraphicsPackage(arg3)) {
            if(this.prefs.edit().putString(this.user + ":" + arg3, GraphicsProfileStore.Companion.encode(arg4)).commit()) {
                return;
            }

            throw new IllegalStateException("No se pudo guardar el perfil gráfico".toString());
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final boolean saved(String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "pkg");
        return this.prefs.contains(this.user + ":" + arg3);
    }
}

