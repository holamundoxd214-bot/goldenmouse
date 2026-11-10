package com.TryJeanPc.goldenmouse.stretch.agent;

import com.TryJeanPc.goldenmouse.stretch.StretchFullProjection;
import com.TryJeanPc.goldenmouse.stretch.StretchRect;
import com.TryJeanPc.goldenmouse.stretch.StretchSize;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u000B\u0010\fJ\t\u0010\u0016\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001A\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001A\u00020\tHÆ\u0003J\t\u0010\u001A\u001A\u00020\tHÆ\u0003J;\u0010\u001B\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\tHÆ\u0001J\u0013\u0010\u001C\u001A\u00020\u001D2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001F\u001A\u00020\tHÖ\u0001J\t\u0010 \u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0014¨\u0006!"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCompositorState;", "", "physicalIdentity", "", "projection", "Lcom/TryJeanPc/goldenmouse/stretch/StretchFullProjection;", "displaySize", "Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;", "effectiveOrientation", "", "installOrientation", "<init>", "(Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/stretch/StretchFullProjection;Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;II)V", "getPhysicalIdentity", "()Ljava/lang/String;", "getProjection", "()Lcom/TryJeanPc/goldenmouse/stretch/StretchFullProjection;", "getDisplaySize", "()Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;", "getEffectiveOrientation", "()I", "getInstallOrientation", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchCompositorState {
    public static final int $stable;
    private final StretchSize displaySize;
    private final int effectiveOrientation;
    private final int installOrientation;
    private final String physicalIdentity;
    private final StretchFullProjection projection;

    static {
    }

    public StretchCompositorState(String arg8, StretchFullProjection arg9, StretchSize arg10, int arg11, int arg12) {
        Intrinsics.checkNotNullParameter(arg8, "physicalIdentity");
        Intrinsics.checkNotNullParameter(arg9, "projection");
        Intrinsics.checkNotNullParameter(arg10, "displaySize");
        super();
        this.physicalIdentity = arg8;
        this.projection = arg9;
        this.displaySize = arg10;
        this.effectiveOrientation = arg11;
        this.installOrientation = arg12;
        String v1 = "aosp-physical:";
        int v3 = 2;
        String v4 = "Failed requirement.";
        if((StringsKt.startsWith$default(arg8, v1, false, v3, null)) && (StretchAgentProtocolKt.validAgentText(arg8))) {
            if(Intrinsics.areEqual(v1 + Long.toUnsignedString(Long.parseUnsignedLong(StringsKt.removePrefix(arg8, v1))), arg8)) {
                if(arg11 >= 0) {
                    int v8 = 4;
                    if(arg11 < v8 && arg12 >= 0 && arg12 < v8 && arg9.getRotation() == (arg11 - arg12 + v8) % v8) {
                        v8 = arg10.getWidth();
                        if(1 <= v8) {
                            arg12 = 0x8001;
                            if(v8 < arg12) {
                                v8 = arg10.getHeight();
                                if(1 <= v8 && v8 < arg12) {
                                    StretchRect[] v8_1 = new StretchRect[v3];
                                    v8_1[0] = arg9.getSource();
                                    v8_1[1] = arg9.getDestination();
                                    Iterator v8_2 = CollectionsKt.listOf(((Object[])v8_1)).iterator();
                                    while(true) {
                                        if(v8_2.hasNext()) {
                                            Object v9 = v8_2.next();
                                            if(((StretchRect)v9).getLeft() >= 0 && ((StretchRect)v9).getTop() >= 0 && ((StretchRect)v9).getRight() > ((StretchRect)v9).getLeft() && ((StretchRect)v9).getBottom() > ((StretchRect)v9).getTop()) {
                                                arg11 = 0x8000;
                                                if(((StretchRect)v9).getRight() <= arg11 && ((StretchRect)v9).getBottom() <= arg11) {
                                                    continue;
                                                }
                                            }

                                            break;
                                        }
                                        else {
                                            goto label_79;
                                        }
                                    }

                                    throw new IllegalArgumentException(v4.toString());
                                label_79:
                                    v8 = this.effectiveOrientation % v3;
                                    StretchSize v9_1 = this.displaySize;
                                    v8 = v8 == 0 ? v9_1.getWidth() : v9_1.getHeight();
                                    int v9_2 = this.effectiveOrientation % v3;
                                    arg10 = this.displaySize;
                                    v9_2 = v9_2 == 0 ? arg10.getHeight() : arg10.getWidth();
                                    if(this.projection.getDestination().getRight() <= v8 && this.projection.getDestination().getBottom() <= v9_2) {
                                        return;
                                    }

                                    throw new IllegalArgumentException(v4.toString());
                                }
                            }
                        }

                        throw new IllegalArgumentException(v4.toString());
                    }
                }

                throw new IllegalArgumentException(v4.toString());
            }
            else {
                throw new IllegalArgumentException(v4.toString());
            }
        }

        throw new IllegalArgumentException(v4.toString());
    }

    public final String component1() {
        return this.physicalIdentity;
    }

    public final StretchFullProjection component2() {
        return this.projection;
    }

    public final StretchSize component3() {
        return this.displaySize;
    }

    public final int component4() {
        return this.effectiveOrientation;
    }

    public final int component5() {
        return this.installOrientation;
    }

    public final StretchCompositorState copy(String arg7, StretchFullProjection arg8, StretchSize arg9, int arg10, int arg11) {
        Intrinsics.checkNotNullParameter(arg7, "physicalIdentity");
        Intrinsics.checkNotNullParameter(arg8, "projection");
        Intrinsics.checkNotNullParameter(arg9, "displaySize");
        return new StretchCompositorState(arg7, arg8, arg9, arg10, arg11);
    }

    public static StretchCompositorState copy$default(StretchCompositorState arg0, String arg1, StretchFullProjection arg2, StretchSize arg3, int arg4, int arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg1 = arg0.physicalIdentity;
        }

        if((arg6 & 2) != 0) {
            arg2 = arg0.projection;
        }

        if((arg6 & 4) != 0) {
            arg3 = arg0.displaySize;
        }

        if((arg6 & 8) != 0) {
            arg4 = arg0.effectiveOrientation;
        }

        if((arg6 & 16) != 0) {
            arg5 = arg0.installOrientation;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchCompositorState)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchCompositorState)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.physicalIdentity, ((StretchCompositorState)arg5).physicalIdentity)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.projection, ((StretchCompositorState)arg5).projection)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.displaySize, ((StretchCompositorState)arg5).displaySize)) {
            return 0;
        }

        if(this.effectiveOrientation != ((StretchCompositorState)arg5).effectiveOrientation) {
            return 0;
        }

        if(this.installOrientation != ((StretchCompositorState)arg5).installOrientation) {
            return 0;
        }

        return 1;
    }

    public final StretchSize getDisplaySize() {
        return this.displaySize;
    }

    public final int getEffectiveOrientation() {
        return this.effectiveOrientation;
    }

    public final int getInstallOrientation() {
        return this.installOrientation;
    }

    public final String getPhysicalIdentity() {
        return this.physicalIdentity;
    }

    public final StretchFullProjection getProjection() {
        return this.projection;
    }

    public int hashCode() {
        return (((this.physicalIdentity.hashCode() * 0x1F + this.projection.hashCode()) * 0x1F + this.displaySize.hashCode()) * 0x1F + Integer.hashCode(this.effectiveOrientation)) * 0x1F + Integer.hashCode(this.installOrientation);
    }

    public String toString() {
        return "StretchCompositorState(physicalIdentity=" + this.physicalIdentity + ", projection=" + this.projection + ", displaySize=" + this.displaySize + ", effectiveOrientation=" + this.effectiveOrientation + ", installOrientation=" + this.installOrientation + ")";
    }
}

