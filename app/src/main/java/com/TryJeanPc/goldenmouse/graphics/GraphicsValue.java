package com.TryJeanPc.goldenmouse.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00032\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0015"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsValue;", "", "present", "", "text", "", "<init>", "(ZLjava/lang/String;)V", "getPresent", "()Z", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsValue {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsValue$Companion;", "", "<init>", "()V", "ABSENT", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsValue;", "getABSENT", "()Lcom/TryJeanPc/goldenmouse/graphics/GraphicsValue;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final GraphicsValue getABSENT() {
            return GraphicsValue.ABSENT;
        }
    }

    public static final int $stable;
    private static final GraphicsValue ABSENT;
    public static final Companion Companion;
    private final boolean present;
    private final String text;

    static {
        GraphicsValue.Companion = new Companion(null);
        GraphicsValue.ABSENT = new GraphicsValue(false, "");
    }

    public GraphicsValue(boolean arg4, String arg5) {
        Intrinsics.checkNotNullParameter(arg5, "text");
        super();
        this.present = arg4;
        this.text = arg5;
        String v1 = "Failed requirement.";
        if(arg5.length() <= 0x1000) {
            int v4 = 0;
            while(true) {
                if(v4 < ((CharSequence)arg5).length()) {
                    int v0 = ((CharSequence)arg5).charAt(v4);
                    if(v0 != 0 && v0 != 10 && v0 != 13) {
                        ++v4;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_31;
            }

            if(!this.present) {
                if(this.text.length() == 0) {
                }
                else {
                    throw new IllegalArgumentException(v1.toString());
                }
            }

            return;
        }

    label_31:
        throw new IllegalArgumentException(v1.toString());
    }

    public static final GraphicsValue access$getABSENT$cp() {
        return GraphicsValue.ABSENT;
    }

    public final boolean component1() {
        return this.present;
    }

    public final String component2() {
        return this.text;
    }

    public final GraphicsValue copy(boolean arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "text");
        return new GraphicsValue(arg1, arg2);
    }

    public static GraphicsValue copy$default(GraphicsValue arg0, boolean arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.present;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.text;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((GraphicsValue)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof GraphicsValue)) {
            return 0;
        }

        if(this.present != ((GraphicsValue)arg5).present) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.text, ((GraphicsValue)arg5).text)) {
            return 0;
        }

        return 1;
    }

    public final boolean getPresent() {
        return this.present;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return Boolean.hashCode(this.present) * 0x1F + this.text.hashCode();
    }

    public String toString() {
        return "GraphicsValue(present=" + this.present + ", text=" + this.text + ")";
    }
}

