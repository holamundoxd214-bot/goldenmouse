package com.TryJeanPc.goldenmouse.aim;

import com.TryJeanPc.goldenmouse.profile.GameProfile;
import com.TryJeanPc.goldenmouse.profile.ProfileControl;
import com.TryJeanPc.goldenmouse.profile.ViewComponent;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001D2\u00020\u0001:\u0001\u001DB9\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0016\b\u0002\u0010\u0005\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000E\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0010H\u0000¢\u0006\u0002\b\u0012J\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\u0017\u0010\u0015\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÂ\u0003J\t\u0010\u0016\u001A\u00020\bHÂ\u0003J?\u0010\u0017\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\u0016\b\u0002\u0010\u0005\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001A\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001A\u00020\b2\b\u0010\u0019\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001A\u001A\u00020\u0010HÖ\u0001J\t\u0010\u001B\u001A\u00020\u001CHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u001C\u0010\u0005\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/CameraTouchAnchor;", "", "relativeX", "", "relativeY", "savedCenter", "Lkotlin/Pair;", "validControlSize", "", "<init>", "(FFLkotlin/Pair;Z)V", "getRelativeX", "()F", "getRelativeY", "resolve", "width", "", "height", "resolve$app", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class CameraTouchAnchor {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tR\u0011\u0010\u000B\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u000E"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/CameraTouchAnchor$Companion;", "", "<init>", "()V", "fromProfile", "Lcom/TryJeanPc/goldenmouse/aim/CameraTouchAnchor;", "profile", "Lcom/TryJeanPc/goldenmouse/profile/GameProfile;", "width", "", "height", "DEFAULT", "getDEFAULT", "()Lcom/TryJeanPc/goldenmouse/aim/CameraTouchAnchor;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final CameraTouchAnchor fromProfile(GameProfile arg3, int arg4, int arg5) {
            Object v4;
            Intrinsics.checkNotNullParameter(arg3, "profile");
            Iterator v3 = arg3.getControls().iterator();
            do {
                if(v3.hasNext()) {
                    v4 = v3.next();
                    if(!(v4.getComponent() instanceof ViewComponent)) {
                        continue;
                    }

                    break;
                }
                else {
                    goto label_12;
                }
            }
            while(true);

            goto label_13;
        label_12:
            v4 = null;
        label_13:
            if(v4 == null) {
                return this.getDEFAULT();
            }

            Pair v3_1 = TuplesKt.to(Float.valueOf(((ProfileControl)v4).getX() + (((float)((ProfileControl)v4).getWidth())) / 2f), Float.valueOf(((ProfileControl)v4).getY() + (((float)((ProfileControl)v4).getHeight())) / 2f));
            boolean v4_1 = ((ProfileControl)v4).getWidth() <= 0 || ((ProfileControl)v4).getHeight() <= 0 ? false : true;
            return new CameraTouchAnchor(0f, 0f, v3_1, v4_1);
        }

        public final CameraTouchAnchor getDEFAULT() {
            return CameraTouchAnchor.DEFAULT;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final CameraTouchAnchor DEFAULT;
    private final float relativeX;
    private final float relativeY;
    private final Pair savedCenter;
    private final boolean validControlSize;

    static {
        CameraTouchAnchor.Companion = new Companion(null);
        CameraTouchAnchor.DEFAULT = new CameraTouchAnchor(0.75f, 0.5f, null, false, 12, null);
    }

    public CameraTouchAnchor(float arg1, float arg2, Pair arg3, boolean arg4, int arg5, DefaultConstructorMarker arg6) {
        if((arg5 & 4) != 0) {
            arg3 = null;
        }

        this(arg1, arg2, arg3, true);
    }

    public CameraTouchAnchor(float arg1, float arg2, Pair arg3, boolean arg4) {
        super();
        this.relativeX = arg1;
        this.relativeY = arg2;
        this.savedCenter = arg3;
        this.validControlSize = arg4;
    }

    public static final CameraTouchAnchor access$getDEFAULT$cp() {
        return CameraTouchAnchor.DEFAULT;
    }

    public final float component1() {
        return this.relativeX;
    }

    public final float component2() {
        return this.relativeY;
    }

    private final Pair component3() {
        return this.savedCenter;
    }

    private final boolean component4() {
        return this.validControlSize;
    }

    public final CameraTouchAnchor copy(float arg1, float arg2, Pair arg3, boolean arg4) {
        return new CameraTouchAnchor(arg1, arg2, arg3, arg4);
    }

    public static CameraTouchAnchor copy$default(CameraTouchAnchor arg0, float arg1, float arg2, Pair arg3, boolean arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.relativeX;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.relativeY;
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.savedCenter;
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.validControlSize;
        }

        return arg0.copy(arg1, arg2, arg3, arg4);
    }

    public boolean equals(Object arg5) {
        if(this == (((CameraTouchAnchor)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof CameraTouchAnchor)) {
            return 0;
        }

        if(Float.compare(this.relativeX, ((CameraTouchAnchor)arg5).relativeX) != 0) {
            return 0;
        }

        if(Float.compare(this.relativeY, ((CameraTouchAnchor)arg5).relativeY) != 0) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.savedCenter, ((CameraTouchAnchor)arg5).savedCenter)) {
            return 0;
        }

        if(this.validControlSize != ((CameraTouchAnchor)arg5).validControlSize) {
            return 0;
        }

        return 1;
    }

    public final float getRelativeX() {
        return this.relativeX;
    }

    public final float getRelativeY() {
        return this.relativeY;
    }

    public int hashCode() {
        int v0 = (Float.hashCode(this.relativeX) * 0x1F + Float.hashCode(this.relativeY)) * 0x1F;
        Pair v1 = this.savedCenter;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        return (v0 + v1_1) * 0x1F + Boolean.hashCode(this.validControlSize);
    }

    public final Pair resolve$app(int arg7, int arg8) {
        Pair v1 = null;
        if((this.validControlSize) && arg7 > 1) {
            if(arg8 <= 1) {
            }
            else {
                Pair v2 = this.savedCenter;
                if(v2 == null) {
                    v2 = TuplesKt.to(Float.valueOf((((float)(arg7 - 1))) * this.relativeX), Float.valueOf((((float)(arg8 - 1))) * this.relativeY));
                }

                float v6 = v2.component1().floatValue();
                float v3 = v2.component2().floatValue();
                float v5 = 3.402823E+38f;
                if(Math.abs(v6) > v5) {
                    return v1;
                }

                if(Math.abs(v3) > v5) {
                    return v1;
                }

                if(0f > v6) {
                    return v1;
                }

                if(v6 > (((float)(arg7 - 1)))) {
                    return v1;
                }

                if(0f > v3) {
                    return v1;
                }

                if(v3 > (((float)(arg8 - 1)))) {
                    return v1;
                }

                return v2;
            }
        }

        return v1;
    }

    public String toString() {
        return "CameraTouchAnchor(relativeX=" + this.relativeX + ", relativeY=" + this.relativeY + ", savedCenter=" + this.savedCenter + ", validControlSize=" + this.validControlSize + ")";
    }
}

