package androidx.compose.animation;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001B\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\b\b\u0002\u0010\f\u001A\u00020\r\u0012\u0018\b\u0002\u0010\u000E\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\u00110\u000F¢\u0006\u0004\b\u0012\u0010\u0013J\u000B\u0010\"\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010#\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u000B\u0010$\u001A\u0004\u0018\u00010\u0007HÆ\u0003J\u000B\u0010%\u001A\u0004\u0018\u00010\tHÆ\u0003J\u000B\u0010&\u001A\u0004\u0018\u00010\u000BHÆ\u0003J\t\u0010\'\u001A\u00020\rHÆ\u0003J\u0019\u0010(\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\u00110\u000FHÆ\u0003Ji\u0010)\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\u0018\b\u0002\u0010\u000E\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\u00110\u000FHÆ\u0001J\u0013\u0010*\u001A\u00020\r2\b\u0010+\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001A\u00020-HÖ\u0001J\t\u0010.\u001A\u00020/HÖ\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0013\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u0013\u0010\n\u001A\u0004\u0018\u00010\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001DR\u0011\u0010\f\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001FR!\u0010\u000E\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\u00110\u000F¢\u0006\b\n\u0000\u001A\u0004\b \u0010!¨\u00060"}, d2={"Landroidx/compose/animation/TransitionData;", "", "fade", "Landroidx/compose/animation/Fade;", "slide", "Landroidx/compose/animation/Slide;", "changeSize", "Landroidx/compose/animation/ChangeSize;", "scale", "Landroidx/compose/animation/Scale;", "veil", "Landroidx/compose/animation/Veil;", "hold", "", "effectsMap", "", "Landroidx/compose/animation/TransitionEffectKey;", "Landroidx/compose/animation/TransitionEffect;", "<init>", "(Landroidx/compose/animation/Fade;Landroidx/compose/animation/Slide;Landroidx/compose/animation/ChangeSize;Landroidx/compose/animation/Scale;Landroidx/compose/animation/Veil;ZLjava/util/Map;)V", "getFade", "()Landroidx/compose/animation/Fade;", "getSlide", "()Landroidx/compose/animation/Slide;", "getChangeSize", "()Landroidx/compose/animation/ChangeSize;", "getScale", "()Landroidx/compose/animation/Scale;", "getVeil", "()Landroidx/compose/animation/Veil;", "getHold", "()Z", "getEffectsMap", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TransitionData {
    public static final int $stable;
    private final ChangeSize changeSize;
    private final Map effectsMap;
    private final Fade fade;
    private final boolean hold;
    private final Scale scale;
    private final Slide slide;
    private final Veil veil;

    static {
    }

    public TransitionData(Fade arg2, Slide arg3, ChangeSize arg4, Scale arg5, Veil arg6, boolean arg7, Map arg8, int arg9, DefaultConstructorMarker arg10) {
        Fade v0 = null;
        if((arg9 & 1) != 0) {
            arg2 = v0;
        }

        if((arg9 & 2) != 0) {
            arg3 = ((Slide)v0);
        }

        if((arg9 & 4) != 0) {
            arg4 = ((ChangeSize)v0);
        }

        if((arg9 & 8) != 0) {
            arg5 = ((Scale)v0);
        }

        if((arg9 & 16) != 0) {
            arg6 = ((Veil)v0);
        }

        if((arg9 & 0x40) != 0) {
            arg8 = MapsKt.emptyMap();
        }

        this(arg2, arg3, arg4, arg5, arg6, false, arg8);
    }

    public TransitionData(Fade arg1, Slide arg2, ChangeSize arg3, Scale arg4, Veil arg5, boolean arg6, Map arg7) {
        super();
        this.fade = arg1;
        this.slide = arg2;
        this.changeSize = arg3;
        this.scale = arg4;
        this.veil = arg5;
        this.hold = arg6;
        this.effectsMap = arg7;
    }

    public TransitionData() {
        this(null, null, null, null, null, false, null, 0x7F, null);
    }

    public final Fade component1() {
        return this.fade;
    }

    public final Slide component2() {
        return this.slide;
    }

    public final ChangeSize component3() {
        return this.changeSize;
    }

    public final Scale component4() {
        return this.scale;
    }

    public final Veil component5() {
        return this.veil;
    }

    public final boolean component6() {
        return this.hold;
    }

    public final Map component7() {
        return this.effectsMap;
    }

    public final TransitionData copy(Fade arg1, Slide arg2, ChangeSize arg3, Scale arg4, Veil arg5, boolean arg6, Map arg7) {
        return new TransitionData(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static TransitionData copy$default(TransitionData arg0, Fade arg1, Slide arg2, ChangeSize arg3, Scale arg4, Veil arg5, boolean arg6, Map arg7, int arg8, Object arg9) {
        if((arg8 & 1) != 0) {
            arg1 = arg0.fade;
        }

        if((arg8 & 2) != 0) {
            arg2 = arg0.slide;
        }

        if((arg8 & 4) != 0) {
            arg3 = arg0.changeSize;
        }

        if((arg8 & 8) != 0) {
            arg4 = arg0.scale;
        }

        if((arg8 & 16) != 0) {
            arg5 = arg0.veil;
        }

        if((arg8 & 0x20) != 0) {
            arg6 = arg0.hold;
        }

        if((arg8 & 0x40) != 0) {
            arg7 = arg0.effectsMap;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public boolean equals(Object arg5) {
        if(this == (((TransitionData)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof TransitionData)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.fade, ((TransitionData)arg5).fade)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.slide, ((TransitionData)arg5).slide)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.changeSize, ((TransitionData)arg5).changeSize)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.scale, ((TransitionData)arg5).scale)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.veil, ((TransitionData)arg5).veil)) {
            return 0;
        }

        if(this.hold != ((TransitionData)arg5).hold) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.effectsMap, ((TransitionData)arg5).effectsMap)) {
            return 0;
        }

        return 1;
    }

    public final ChangeSize getChangeSize() {
        return this.changeSize;
    }

    public final Map getEffectsMap() {
        return this.effectsMap;
    }

    public final Fade getFade() {
        return this.fade;
    }

    public final boolean getHold() {
        return this.hold;
    }

    public final Scale getScale() {
        return this.scale;
    }

    public final Slide getSlide() {
        return this.slide;
    }

    public final Veil getVeil() {
        return this.veil;
    }

    public int hashCode() {
        Fade v0 = this.fade;
        int v1 = 0;
        int v0_1 = v0 == null ? 0 : v0.hashCode();
        v0_1 *= 0x1F;
        Slide v2 = this.slide;
        int v2_1 = v2 == null ? 0 : v2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        ChangeSize v2_2 = this.changeSize;
        v2_1 = v2_2 == null ? 0 : v2_2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        Scale v2_3 = this.scale;
        v2_1 = v2_3 == null ? 0 : v2_3.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        Veil v2_4 = this.veil;
        if(v2_4 == null) {
        }
        else {
            v1 = v2_4.hashCode();
        }

        return ((v0_1 + v1) * 0x1F + Boolean.hashCode(this.hold)) * 0x1F + this.effectsMap.hashCode();
    }

    public String toString() {
        return "TransitionData(fade=" + this.fade + ", slide=" + this.slide + ", changeSize=" + this.changeSize + ", scale=" + this.scale + ", veil=" + this.veil + ", hold=" + this.hold + ", effectsMap=" + this.effectsMap + ')';
    }
}

