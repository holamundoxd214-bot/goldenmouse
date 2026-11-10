package com.TryJeanPc.goldenmouse.graphics;

import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001B\u009D\u0001\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\u0003\u0012\b\b\u0002\u0010\t\u001A\u00020\u0003\u0012\b\b\u0002\u0010\n\u001A\u00020\u0007\u0012\b\b\u0002\u0010\u000B\u001A\u00020\u0007\u0012\b\b\u0002\u0010\f\u001A\u00020\u0007\u0012\b\b\u0002\u0010\r\u001A\u00020\u0007\u0012\b\b\u0002\u0010\u000E\u001A\u00020\u0007\u0012\b\b\u0002\u0010\u000F\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001A\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001A\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000E\u0010\u0004\u001A\u00020\u00002\u0006\u0010(\u001A\u00020\u0005J\u0006\u0010)\u001A\u00020\u0000J\f\u0010,\u001A\b\u0012\u0004\u0012\u00020.0-J\t\u0010/\u001A\u00020\u0003HÆ\u0003J\t\u00100\u001A\u00020\u0005HÆ\u0003J\t\u00101\u001A\u00020\u0007HÆ\u0003J\t\u00102\u001A\u00020\u0003HÆ\u0003J\t\u00103\u001A\u00020\u0003HÆ\u0003J\t\u00104\u001A\u00020\u0007HÆ\u0003J\t\u00105\u001A\u00020\u0007HÆ\u0003J\t\u00106\u001A\u00020\u0007HÆ\u0003J\t\u00107\u001A\u00020\u0007HÆ\u0003J\t\u00108\u001A\u00020\u0007HÆ\u0003J\t\u00109\u001A\u00020\u0003HÆ\u0003J\t\u0010:\u001A\u00020\u0007HÆ\u0003J\t\u0010;\u001A\u00020\u0007HÆ\u0003J\t\u0010<\u001A\u00020\u0003HÆ\u0003J\t\u0010=\u001A\u00020\u0007HÆ\u0003J\u009F\u0001\u0010>\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00072\b\b\u0002\u0010\u000B\u001A\u00020\u00072\b\b\u0002\u0010\f\u001A\u00020\u00072\b\b\u0002\u0010\r\u001A\u00020\u00072\b\b\u0002\u0010\u000E\u001A\u00020\u00072\b\b\u0002\u0010\u000F\u001A\u00020\u00032\b\b\u0002\u0010\u0010\u001A\u00020\u00072\b\b\u0002\u0010\u0011\u001A\u00020\u00072\b\b\u0002\u0010\u0012\u001A\u00020\u00032\b\b\u0002\u0010\u0013\u001A\u00020\u0007HÆ\u0001J\u0013\u0010?\u001A\u00020\u00032\b\u0010@\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001A\u00020\u0007HÖ\u0001J\t\u0010B\u001A\u00020.HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u0011\u0010\b\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0017R\u0011\u0010\t\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0017R\u0011\u0010\n\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001BR\u0011\u0010\u000B\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010\u001BR\u0011\u0010\f\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b \u0010\u001BR\u0011\u0010\r\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\u001BR\u0011\u0010\u000E\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010\u001BR\u0011\u0010\u000F\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b#\u0010\u0017R\u0011\u0010\u0010\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b$\u0010\u001BR\u0011\u0010\u0011\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b%\u0010\u001BR\u0011\u0010\u0012\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\u0017R\u0011\u0010\u0013\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\'\u0010\u001BR\u0011\u0010*\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b+\u0010\u0017¨\u0006C"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsProfile;", "", "texture", "", "preset", "Lcom/TryJeanPc/goldenmouse/graphics/TexturePreset;", "level", "", "nearest", "mipNearest", "hz", "saturation", "color", "resolution", "fps", "msaa", "driver", "mode", "fixed", "animations", "<init>", "(ZLcom/TryJeanPc/goldenmouse/graphics/TexturePreset;IZZIIIIIZIIZI)V", "getTexture", "()Z", "getPreset", "()Lcom/TryJeanPc/goldenmouse/graphics/TexturePreset;", "getLevel", "()I", "getNearest", "getMipNearest", "getHz", "getSaturation", "getColor", "getResolution", "getFps", "getMsaa", "getDriver", "getMode", "getFixed", "getAnimations", "value", "original", "textureRequested", "getTextureRequested", "features", "", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsProfile {
    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[TexturePreset.values().length];
            try {
                v0[TexturePreset.SOFT.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[TexturePreset.RETRO.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[TexturePreset.BLOCKS.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[TexturePreset.CUSTOM.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static final int $stable;
    private final int animations;
    private final int color;
    private final int driver;
    private final boolean fixed;
    private final int fps;
    private final int hz;
    private final int level;
    private final boolean mipNearest;
    private final int mode;
    private final boolean msaa;
    private final boolean nearest;
    private final TexturePreset preset;
    private final int resolution;
    private final int saturation;
    private final boolean texture;

    static {
    }

    public GraphicsProfile() {
        this(false, null, 0, false, false, 0, 0, 0, 0, 0, false, 0, 0, false, 0, 0x7FFF, null);
    }

    public GraphicsProfile(boolean arg17, TexturePreset arg18, int arg19, boolean arg20, boolean arg21, int arg22, int arg23, int arg24, int arg25, int arg26, boolean arg27, int arg28, int arg29, boolean arg30, int arg31, int arg32, DefaultConstructorMarker arg33) {
        int v0 = arg32;
        boolean v1 = (v0 & 1) != 0 ? false : arg17;
        TexturePreset v3 = (v0 & 2) != 0 ? TexturePreset.SOFT : arg18;
        int v4 = (v0 & 4) != 0 ? 1 : arg19;
        boolean v5 = (v0 & 8) != 0 ? false : arg20;
        boolean v6 = (v0 & 16) != 0 ? false : arg21;
        int v7 = (v0 & 0x20) != 0 ? 0 : arg22;
        int v8 = (v0 & 0x40) != 0 ? 10 : arg23;
        int v9 = (v0 & 0x80) != 0 ? -1 : arg24;
        int v10 = (v0 & 0x100) != 0 ? 100 : arg25;
        int v11 = (v0 & 0x200) != 0 ? 0 : arg26;
        boolean v12 = (v0 & 0x400) != 0 ? false : arg27;
        int v13 = (v0 & 0x800) != 0 ? 0 : arg28;
        int v14 = (v0 & 0x1000) != 0 ? 0 : arg29;
        boolean v15 = (v0 & 0x2000) != 0 ? false : arg30;
        arg32 = (v0 & 0x4000) != 0 ? 0 : arg31;
        this(v1, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, arg32);
    }

    public GraphicsProfile(boolean arg20, TexturePreset arg21, int arg22, boolean arg23, boolean arg24, int arg25, int arg26, int arg27, int arg28, int arg29, boolean arg30, int arg31, int arg32, boolean arg33, int arg34) {
        int v2 = arg22;
        int v3 = arg26;
        int v4 = arg27;
        int v5 = arg28;
        int v6 = arg31;
        int v7 = arg32;
        int v8 = arg34;
        Intrinsics.checkNotNullParameter(arg21, "preset");
        super();
        this.texture = arg20;
        this.preset = arg21;
        this.level = v2;
        this.nearest = arg23;
        this.mipNearest = arg24;
        int v1 = arg25;
        this.hz = v1;
        this.saturation = v3;
        this.color = v4;
        this.resolution = v5;
        int v9 = arg29;
        this.fps = v9;
        this.msaa = arg30;
        this.driver = v6;
        this.mode = v7;
        this.fixed = arg33;
        this.animations = v8;
        String v0 = "Failed requirement.";
        if(v2 >= 0) {
            int v10 = 5;
            if(v2 < v10) {
                Integer[] v2_1 = new Integer[v10];
                v2_1[0] = Integer.valueOf(0);
                int v12 = 60;
                v2_1[1] = Integer.valueOf(v12);
                int v13 = 90;
                int v16 = 2;
                v2_1[v16] = Integer.valueOf(v13);
                int v15 = 120;
                int v11 = 3;
                v2_1[v11] = Integer.valueOf(v15);
                int v18 = 4;
                v2_1[v18] = Integer.valueOf(0x90);
                if(SetsKt.setOf(((Object[])v2_1)).contains(Integer.valueOf(v1))) {
                    if(8 <= v3 && v3 < 21 && -1 <= v4 && v4 < v11 && 50 <= v5 && v5 < 101 && v5 % 5 == 0) {
                        Integer[] v1_1 = new Integer[v10];
                        v1_1[0] = Integer.valueOf(0);
                        v1_1[1] = Integer.valueOf(30);
                        v1_1[v16] = Integer.valueOf(v12);
                        v1_1[v11] = Integer.valueOf(v13);
                        v1_1[v18] = Integer.valueOf(v15);
                        if((SetsKt.setOf(((Object[])v1_1)).contains(Integer.valueOf(v9))) && v6 >= 0 && v6 < v11 && v7 >= 0 && v7 < v11 && v8 >= 0 && v8 < v11) {
                            return;
                        }

                        throw new IllegalArgumentException(v0.toString());
                    }

                    throw new IllegalArgumentException(v0.toString());
                }
            }
        }

        throw new IllegalArgumentException(v0.toString());
    }

    public final boolean component1() {
        return this.texture;
    }

    public final int component10() {
        return this.fps;
    }

    public final boolean component11() {
        return this.msaa;
    }

    public final int component12() {
        return this.driver;
    }

    public final int component13() {
        return this.mode;
    }

    public final boolean component14() {
        return this.fixed;
    }

    public final int component15() {
        return this.animations;
    }

    public final TexturePreset component2() {
        return this.preset;
    }

    public final int component3() {
        return this.level;
    }

    public final boolean component4() {
        return this.nearest;
    }

    public final boolean component5() {
        return this.mipNearest;
    }

    public final int component6() {
        return this.hz;
    }

    public final int component7() {
        return this.saturation;
    }

    public final int component8() {
        return this.color;
    }

    public final int component9() {
        return this.resolution;
    }

    public final GraphicsProfile copy(boolean arg18, TexturePreset arg19, int arg20, boolean arg21, boolean arg22, int arg23, int arg24, int arg25, int arg26, int arg27, boolean arg28, int arg29, int arg30, boolean arg31, int arg32) {
        Intrinsics.checkNotNullParameter(arg19, "preset");
        return new GraphicsProfile(arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32);
    }

    public static GraphicsProfile copy$default(GraphicsProfile arg16, boolean arg17, TexturePreset arg18, int arg19, boolean arg20, boolean arg21, int arg22, int arg23, int arg24, int arg25, int arg26, boolean arg27, int arg28, int arg29, boolean arg30, int arg31, int arg32, Object arg33) {
        GraphicsProfile v0 = arg16;
        int v1 = arg32;
        boolean v2 = (v1 & 1) != 0 ? v0.texture : arg17;
        TexturePreset v3 = (v1 & 2) != 0 ? v0.preset : arg18;
        int v4 = (v1 & 4) != 0 ? v0.level : arg19;
        boolean v5 = (v1 & 8) != 0 ? v0.nearest : arg20;
        boolean v6 = (v1 & 16) != 0 ? v0.mipNearest : arg21;
        int v7 = (v1 & 0x20) != 0 ? v0.hz : arg22;
        int v8 = (v1 & 0x40) != 0 ? v0.saturation : arg23;
        int v9 = (v1 & 0x80) != 0 ? v0.color : arg24;
        int v10 = (v1 & 0x100) != 0 ? v0.resolution : arg25;
        int v11 = (v1 & 0x200) != 0 ? v0.fps : arg26;
        boolean v12 = (v1 & 0x400) != 0 ? v0.msaa : arg27;
        int v13 = (v1 & 0x800) != 0 ? v0.driver : arg28;
        int v14 = (v1 & 0x1000) != 0 ? v0.mode : arg29;
        boolean v15 = (v1 & 0x2000) != 0 ? v0.fixed : arg30;
        arg32 = (v1 & 0x4000) != 0 ? v0.animations : arg31;
        return v0.copy(v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, arg32);
    }

    public boolean equals(Object arg5) {
        if(this == (((GraphicsProfile)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof GraphicsProfile)) {
            return 0;
        }

        if(this.texture != ((GraphicsProfile)arg5).texture) {
            return 0;
        }

        if(this.preset != ((GraphicsProfile)arg5).preset) {
            return 0;
        }

        if(this.level != ((GraphicsProfile)arg5).level) {
            return 0;
        }

        if(this.nearest != ((GraphicsProfile)arg5).nearest) {
            return 0;
        }

        if(this.mipNearest != ((GraphicsProfile)arg5).mipNearest) {
            return 0;
        }

        if(this.hz != ((GraphicsProfile)arg5).hz) {
            return 0;
        }

        if(this.saturation != ((GraphicsProfile)arg5).saturation) {
            return 0;
        }

        if(this.color != ((GraphicsProfile)arg5).color) {
            return 0;
        }

        if(this.resolution != ((GraphicsProfile)arg5).resolution) {
            return 0;
        }

        if(this.fps != ((GraphicsProfile)arg5).fps) {
            return 0;
        }

        if(this.msaa != ((GraphicsProfile)arg5).msaa) {
            return 0;
        }

        if(this.driver != ((GraphicsProfile)arg5).driver) {
            return 0;
        }

        if(this.mode != ((GraphicsProfile)arg5).mode) {
            return 0;
        }

        if(this.fixed != ((GraphicsProfile)arg5).fixed) {
            return 0;
        }

        if(this.animations != ((GraphicsProfile)arg5).animations) {
            return 0;
        }

        return 1;
    }

    public final List features() {
        List v0 = CollectionsKt.createListBuilder();
        if(this.nearest) {
            v0.add("forceNearestFiltering");
        }

        if(this.mipNearest) {
            v0.add("forceNearestMipFiltering");
        }

        int v3 = this.level;
        if(v3 > 0) {
            v0.add("forceTextureLodOffset" + v3);
        }

        return CollectionsKt.build(v0);
    }

    public final int getAnimations() {
        return this.animations;
    }

    public final int getColor() {
        return this.color;
    }

    public final int getDriver() {
        return this.driver;
    }

    public final boolean getFixed() {
        return this.fixed;
    }

    public final int getFps() {
        return this.fps;
    }

    public final int getHz() {
        return this.hz;
    }

    public final int getLevel() {
        return this.level;
    }

    public final boolean getMipNearest() {
        return this.mipNearest;
    }

    public final int getMode() {
        return this.mode;
    }

    public final boolean getMsaa() {
        return this.msaa;
    }

    public final boolean getNearest() {
        return this.nearest;
    }

    public final TexturePreset getPreset() {
        return this.preset;
    }

    public final int getResolution() {
        return this.resolution;
    }

    public final int getSaturation() {
        return this.saturation;
    }

    public final boolean getTexture() {
        return this.texture;
    }

    public final boolean getTextureRequested() {
        if((this.texture) && (this.level > 0 || (this.nearest) || (this.mipNearest))) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return (((((((((((((Boolean.hashCode(this.texture) * 0x1F + this.preset.hashCode()) * 0x1F + Integer.hashCode(this.level)) * 0x1F + Boolean.hashCode(this.nearest)) * 0x1F + Boolean.hashCode(this.mipNearest)) * 0x1F + Integer.hashCode(this.hz)) * 0x1F + Integer.hashCode(this.saturation)) * 0x1F + Integer.hashCode(this.color)) * 0x1F + Integer.hashCode(this.resolution)) * 0x1F + Integer.hashCode(this.fps)) * 0x1F + Boolean.hashCode(this.msaa)) * 0x1F + Integer.hashCode(this.driver)) * 0x1F + Integer.hashCode(this.mode)) * 0x1F + Boolean.hashCode(this.fixed)) * 0x1F + Integer.hashCode(this.animations);
    }

    public final GraphicsProfile original() {
        return GraphicsProfile.copy$default(this, false, TexturePreset.CUSTOM, 0, false, false, 0, 0, 0, 0, 0, false, 0, 0, false, 0, 0x7FE1, null);
    }

    public final GraphicsProfile preset(TexturePreset arg20) {
        TexturePreset v3 = arg20;
        Intrinsics.checkNotNullParameter(v3, "value");
        int v0 = WhenMappings.$EnumSwitchMapping$0[v3.ordinal()];
        if(v0 != 1) {
            if(v0 != 2) {
                if(v0 != 3) {
                    if(v0 == 4) {
                        return GraphicsProfile.copy$default(this, false, v3, 0, false, false, 0, 0, 0, 0, 0, false, 0, 0, false, 0, 0x7FFD, null);
                    }

                    throw new NoWhenBranchMatchedException();
                }

                return GraphicsProfile.copy$default(this, false, arg20, 3, true, true, 0, 0, 0, 0, 0, false, 0, 0, false, 0, 0x7FE1, null);
            }

            return GraphicsProfile.copy$default(this, false, arg20, 2, true, false, 0, 0, 0, 0, 0, false, 0, 0, false, 0, 0x7FE1, null);
        }

        return GraphicsProfile.copy$default(this, false, arg20, 1, false, false, 0, 0, 0, 0, 0, false, 0, 0, false, 0, 0x7FE1, null);
    }

    public String toString() {
        return "GraphicsProfile(texture=" + this.texture + ", preset=" + this.preset + ", level=" + this.level + ", nearest=" + this.nearest + ", mipNearest=" + this.mipNearest + ", hz=" + this.hz + ", saturation=" + this.saturation + ", color=" + this.color + ", resolution=" + this.resolution + ", fps=" + this.fps + ", msaa=" + this.msaa + ", driver=" + this.driver + ", mode=" + this.mode + ", fixed=" + this.fixed + ", animations=" + this.animations + ")";
    }
}

