package com.TryJeanPc.goldenmouse.controls;

import com.TryJeanPc.goldenmouse.profile.ControlComponent;
import com.TryJeanPc.goldenmouse.profile.GameProfile;
import com.TryJeanPc.goldenmouse.profile.ProfileControl;
import com.TryJeanPc.goldenmouse.profile.TapComponent;
import com.TryJeanPc.goldenmouse.profile.TapMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0081\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r¢\u0006\u0004\b\u000E\u0010\u000FJ\u000E\u0010\"\u001A\u00020#2\u0006\u0010$\u001A\u00020#JE\u0010%\u001A\b\u0012\u0004\u0012\u00020\'0&2\u0006\u0010(\u001A\u00020\'2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020*2\u0018\u0010,\u001A\u0014\u0012\u0004\u0012\u00020\'\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0&0-¢\u0006\u0004\b/\u00100J\u0010\u00101\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u00102\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000B\u00103\u001A\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u00104\u001A\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u00105\u001A\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u00106\u001A\u0004\u0018\u00010\u000BHÆ\u0003¢\u0006\u0002\u0010\u001BJ\u0010\u00107\u001A\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001EJb\u00108\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001A\u00020\r2\b\u0010;\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001A\u00020\u000BHÖ\u0001J\t\u0010=\u001A\u00020*HÖ\u0001R\u0015\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001A\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001A\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0018\u001A\u0004\b\u0016\u0010\u0017R\u0015\u0010\t\u001A\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0018\u001A\u0004\b\u0019\u0010\u0017R\u0015\u0010\n\u001A\u0004\u0018\u00010\u000B¢\u0006\n\n\u0002\u0010\u001C\u001A\u0004\b\u001A\u0010\u001BR\u0015\u0010\f\u001A\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001F\u001A\u0004\b\u001D\u0010\u001ER\u0011\u0010 \u001A\u00020\r8F¢\u0006\u0006\u001A\u0004\b \u0010!¨\u0006>"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/TapSettingsEdit;", "", "x", "", "y", "action", "Lcom/TryJeanPc/goldenmouse/controls/TapSettingsAction;", "touchDurationMs", "", "intervalMs", "repeatCount", "", "advancedTimingEnabled", "", "<init>", "(Ljava/lang/Float;Ljava/lang/Float;Lcom/TryJeanPc/goldenmouse/controls/TapSettingsAction;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getX", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getY", "getAction", "()Lcom/TryJeanPc/goldenmouse/controls/TapSettingsAction;", "getTouchDurationMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getIntervalMs", "getRepeatCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAdvancedTimingEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "isEmpty", "()Z", "applyTo", "Lcom/TryJeanPc/goldenmouse/profile/ProfileControl;", "control", "save", "Lkotlin/Result;", "Lcom/TryJeanPc/goldenmouse/profile/GameProfile;", "profile", "controlId", "", "expectedPackage", "write", "Lkotlin/Function1;", "", "save-BWLJW6A", "(Lcom/TryJeanPc/goldenmouse/profile/GameProfile;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Lcom/TryJeanPc/goldenmouse/controls/TapSettingsAction;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/TryJeanPc/goldenmouse/controls/TapSettingsEdit;", "equals", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class TapSettingsEdit {
    public static final int $stable;
    private final TapSettingsAction action;
    private final Boolean advancedTimingEnabled;
    private final Long intervalMs;
    private final Integer repeatCount;
    private final Long touchDurationMs;
    private final Float x;
    private final Float y;

    static {
    }

    public TapSettingsEdit(Float arg1, Float arg2, TapSettingsAction arg3, Long arg4, Long arg5, Integer arg6, Boolean arg7) {
        super();
        this.x = arg1;
        this.y = arg2;
        this.action = arg3;
        this.touchDurationMs = arg4;
        this.intervalMs = arg5;
        this.repeatCount = arg6;
        this.advancedTimingEnabled = arg7;
    }

    public TapSettingsEdit() {
        this(null, null, null, null, null, null, null, 0x7F, null);
    }

    public TapSettingsEdit(Float arg2, Float arg3, TapSettingsAction arg4, Long arg5, Long arg6, Integer arg7, Boolean arg8, int arg9, DefaultConstructorMarker arg10) {
        Float v0 = null;
        if((arg9 & 1) != 0) {
            arg2 = v0;
        }

        if((arg9 & 2) != 0) {
            arg3 = v0;
        }

        if((arg9 & 4) != 0) {
            arg4 = ((TapSettingsAction)v0);
        }

        if((arg9 & 8) != 0) {
            arg5 = ((Long)v0);
        }

        if((arg9 & 16) != 0) {
            arg6 = ((Long)v0);
        }

        if((arg9 & 0x20) != 0) {
            arg7 = ((Integer)v0);
        }

        if((arg9 & 0x40) != 0) {
            arg8 = ((Boolean)v0);
        }

        this(arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public final ProfileControl applyTo(ProfileControl arg15) {
        TapMode v2_4;
        Intrinsics.checkNotNullParameter(arg15, "control");
        ControlComponent v0 = arg15.getComponent();
        if((v0 instanceof TapComponent)) {
        }
        else {
            v0 = null;
        }

        ControlComponent v1 = v0;
        if(v1 != null) {
            Float v0_1 = this.x;
            float v2 = 3.402823E+38f;
            if(v0_1 != null) {
                if(Math.abs(v0_1.floatValue()) <= v2) {
                }
                else {
                    throw new IllegalArgumentException("Coordenada X inválida".toString());
                }
            }

            v0_1 = this.y;
            if(v0_1 != null) {
                if(Math.abs(v0_1.floatValue()) <= v2) {
                }
                else {
                    throw new IllegalArgumentException("Coordenada Y inválida".toString());
                }
            }

            long v2_1 = 1;
            if(this.touchDurationMs != null) {
                if(new LongRange(v2_1, 5000).contains(this.touchDurationMs.longValue())) {
                }
                else {
                    throw new IllegalArgumentException("Duración de TOQUE inválida".toString());
                }
            }

            if(this.intervalMs != null) {
                if(new LongRange(v2_1, 60000).contains(this.intervalMs.longValue())) {
                }
                else {
                    throw new IllegalArgumentException("Intervalo de TOQUE inválido".toString());
                }
            }

            if(this.repeatCount != null) {
                if(new IntRange(1, 999).contains(this.repeatCount.intValue())) {
                }
                else {
                    throw new IllegalArgumentException("Cantidad de toques inválida".toString());
                }
            }

            v0_1 = this.x;
            float v0_2 = v0_1 != null ? v0_1.floatValue() : arg15.getX();
            Float v2_2 = this.y;
            v2 = v2_2 != null ? v2_2.floatValue() : arg15.getY();
            float v13 = v2;
            TapSettingsAction v2_3 = this.action;
            if(v2_3 != null) {
                v2_4 = v2_3.getMode();
                if(v2_4 == null) {
                    goto label_94;
                }
            }
            else {
            label_94:
                v2_4 = ((TapComponent)v1).getMode();
            }

            TapSettingsAction v3 = this.action;
            boolean v3_1 = v3 != null ? v3.getRepeatEnabled() : ((TapComponent)v1).getRepeatEnabled();
            boolean v7 = v3_1;
            Long v3_2 = this.touchDurationMs;
            long v3_3 = v3_2 != null ? v3_2.longValue() : ((TapComponent)v1).getTouchDurationMs();
            Long v5 = this.intervalMs;
            long v5_1 = v5 != null ? v5.longValue() : ((TapComponent)v1).getIntervalMs();
            Integer v8 = this.repeatCount;
            int v8_1 = v8 != null ? v8.intValue() : ((TapComponent)v1).getRepeatCount();
            Boolean v14 = this.advancedTimingEnabled;
            boolean v14_1 = v14 != null ? v14.booleanValue() : ((TapComponent)v1).getAdvancedTimingEnabled();
            return ProfileControl.copy$default(arg15, null, null, v0_2, v13, 0, 0, null, TapComponent.copy$default(((TapComponent)v1), v2_4, v3_3, v5_1, v7, v8_1, 0f, v14_1, 0x20, null), 0x73, null);
        }

        throw new IllegalStateException("El control ya no es TOQUE".toString());
    }

    public final Float component1() {
        return this.x;
    }

    public final Float component2() {
        return this.y;
    }

    public final TapSettingsAction component3() {
        return this.action;
    }

    public final Long component4() {
        return this.touchDurationMs;
    }

    public final Long component5() {
        return this.intervalMs;
    }

    public final Integer component6() {
        return this.repeatCount;
    }

    public final Boolean component7() {
        return this.advancedTimingEnabled;
    }

    public final TapSettingsEdit copy(Float arg1, Float arg2, TapSettingsAction arg3, Long arg4, Long arg5, Integer arg6, Boolean arg7) {
        return new TapSettingsEdit(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static TapSettingsEdit copy$default(TapSettingsEdit arg0, Float arg1, Float arg2, TapSettingsAction arg3, Long arg4, Long arg5, Integer arg6, Boolean arg7, int arg8, Object arg9) {
        if((arg8 & 1) != 0) {
            arg1 = arg0.x;
        }

        if((arg8 & 2) != 0) {
            arg2 = arg0.y;
        }

        if((arg8 & 4) != 0) {
            arg3 = arg0.action;
        }

        if((arg8 & 8) != 0) {
            arg4 = arg0.touchDurationMs;
        }

        if((arg8 & 16) != 0) {
            arg5 = arg0.intervalMs;
        }

        if((arg8 & 0x20) != 0) {
            arg6 = arg0.repeatCount;
        }

        if((arg8 & 0x40) != 0) {
            arg7 = arg0.advancedTimingEnabled;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public boolean equals(Object arg5) {
        if(this == (((TapSettingsEdit)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof TapSettingsEdit)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.x, ((TapSettingsEdit)arg5).x)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.y, ((TapSettingsEdit)arg5).y)) {
            return 0;
        }

        if(this.action != ((TapSettingsEdit)arg5).action) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.touchDurationMs, ((TapSettingsEdit)arg5).touchDurationMs)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.intervalMs, ((TapSettingsEdit)arg5).intervalMs)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.repeatCount, ((TapSettingsEdit)arg5).repeatCount)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.advancedTimingEnabled, ((TapSettingsEdit)arg5).advancedTimingEnabled)) {
            return 0;
        }

        return 1;
    }

    public final TapSettingsAction getAction() {
        return this.action;
    }

    public final Boolean getAdvancedTimingEnabled() {
        return this.advancedTimingEnabled;
    }

    public final Long getIntervalMs() {
        return this.intervalMs;
    }

    public final Integer getRepeatCount() {
        return this.repeatCount;
    }

    public final Long getTouchDurationMs() {
        return this.touchDurationMs;
    }

    public final Float getX() {
        return this.x;
    }

    public final Float getY() {
        return this.y;
    }

    public int hashCode() {
        Float v0 = this.x;
        int v1 = 0;
        int v0_1 = v0 == null ? 0 : v0.hashCode();
        v0_1 *= 0x1F;
        Float v2 = this.y;
        int v2_1 = v2 == null ? 0 : v2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        TapSettingsAction v2_2 = this.action;
        v2_1 = v2_2 == null ? 0 : v2_2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        Long v2_3 = this.touchDurationMs;
        v2_1 = v2_3 == null ? 0 : v2_3.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        v2_3 = this.intervalMs;
        v2_1 = v2_3 == null ? 0 : v2_3.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        Integer v2_4 = this.repeatCount;
        v2_1 = v2_4 == null ? 0 : v2_4.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        Boolean v3 = this.advancedTimingEnabled;
        if(v3 == null) {
        }
        else {
            v1 = v3.hashCode();
        }

        return v0_1 + v1;
    }

    public final boolean isEmpty() {
        return Intrinsics.areEqual(this, new TapSettingsEdit(null, null, null, null, null, null, null, 0x7F, null));
    }

    public final Object save-BWLJW6A(GameProfile arg8, String arg9, String arg10, Function1 arg11) {
        ProfileControl v1_2;
        Intrinsics.checkNotNullParameter(arg8, "profile");
        Intrinsics.checkNotNullParameter(arg9, "controlId");
        Intrinsics.checkNotNullParameter(arg10, "expectedPackage");
        Intrinsics.checkNotNullParameter(arg11, "write");
        try {
            if(Intrinsics.areEqual(arg8.getTargetPackage(), arg10)) {
                Iterator v10 = arg8.getControls().iterator();
                Object v0_1 = null;
                int v1 = 0;
                Object v2 = v0_1;
                while(true) {
                    if(v10.hasNext()) {
                        Object v3 = v10.next();
                        if(!Intrinsics.areEqual(v3.getId(), arg9)) {
                            continue;
                        }

                        if(v1 != 0) {
                        }
                        else {
                            v1 = 1;
                            v2 = v3;
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_33;
                }

                if(v1 == 0) {
                }
                else {
                    v0_1 = v2;
                }

            label_33:
                if(v0_1 == null) {
                    goto label_64;
                }

                ProfileControl v7 = this.applyTo(((ProfileControl)v0_1));
                if(Intrinsics.areEqual(v7, v0_1)) {
                }
                else {
                    List v9 = arg8.getControls();
                    ArrayList v10_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v9), 10));
                    Iterator v9_1 = ((Iterable)v9).iterator();
                    goto label_44;
                label_64:
                    throw new IllegalStateException("No hay un único TOQUE vigente".toString());
                label_44:
                    while(v9_1.hasNext()) {
                        Object v1_1 = v9_1.next();
                        if(v1_1 == v0_1) {
                            v1_2 = v7;
                        }

                        ((Collection)v10_1).add(v1_2);
                    }

                    arg8 = GameProfile.copy$default(arg8, null, null, v10_1, null, 11, null);
                    ResultKt.throwOnFailure(arg11.invoke(arg8).unbox-impl());
                }

                return Result.constructor-impl(arg8);
            }

            throw new IllegalArgumentException("El perfil de TOQUE cambió durante la edición".toString());
        }
        catch(Throwable v0) {
            return Result.constructor-impl(ResultKt.createFailure(v0));
        }
    }

    public String toString() {
        return "TapSettingsEdit(x=" + this.x + ", y=" + this.y + ", action=" + this.action + ", touchDurationMs=" + this.touchDurationMs + ", intervalMs=" + this.intervalMs + ", repeatCount=" + this.repeatCount + ", advancedTimingEnabled=" + this.advancedTimingEnabled + ")";
    }
}

