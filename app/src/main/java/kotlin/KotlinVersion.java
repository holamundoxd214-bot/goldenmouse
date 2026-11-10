package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B!\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\bV\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bJ\"\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u0003H\u0082\u0080\u0004J\n\u0010\u000F\u001A\u00020\u0010H\u0096\u0080\u0004J\u0014\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014H\u0096\u0082\u0004J\n\u0010\u0015\u001A\u00020\u0003H\u0096\u0080\u0004J\u0012\u0010\u0016\u001A\u00020\u00032\u0006\u0010\u0013\u001A\u00020\u0000H\u0096\u0082\u0004J\u001A\u0010\u0017\u001A\u00020\u00122\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H\u0086\u0080\u0004J\"\u0010\u0017\u001A\u00020\u00122\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u0003H\u0086\u0080\u0004R\u0015\u0010\u0002\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0015\u0010\u0005\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\nR\u000F\u0010\r\u001A\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"Lkotlin/KotlinVersion;", "", "major", "", "minor", "patch", "<init>", "(III)V", "(II)V", "getMajor", "()I", "getMinor", "getPatch", "version", "versionOf", "toString", "", "equals", "", "other", "", "hashCode", "compareTo", "isAtLeast", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class KotlinVersion implements Comparable {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000F\u0010\u0004\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u00078\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Lkotlin/KotlinVersion$Companion;", "", "<init>", "()V", "MAX_COMPONENT_VALUE", "", "CURRENT", "Lkotlin/KotlinVersion;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final KotlinVersion CURRENT = null;
    public static final Companion Companion = null;
    public static final int MAX_COMPONENT_VALUE = 0xFF;
    private final int major;
    private final int minor;
    private final int patch;
    private final int version;

    static {
        KotlinVersion.Companion = new Companion(null);
        KotlinVersion.CURRENT = KotlinVersionCurrentValue.get();
    }

    public KotlinVersion(int arg2, int arg3) {
        this(arg2, arg3, 0);
    }

    public KotlinVersion(int arg1, int arg2, int arg3) {
        super();
        this.major = arg1;
        this.minor = arg2;
        this.patch = arg3;
        this.version = this.versionOf(arg1, arg2, arg3);
    }

    public int compareTo(Object arg1) {
        return this.compareTo(((KotlinVersion)arg1));
    }

    public int compareTo(KotlinVersion arg2) {
        Intrinsics.checkNotNullParameter(arg2, "other");
        return this.version - arg2.version;
    }

    public boolean equals(Object arg3) {
        if(this == (((KotlinVersion)arg3))) {
            return 1;
        }

        if((arg3 instanceof KotlinVersion)) {
        }
        else {
            KotlinVersion v3 = null;
        }

        if(0 == 0) {
            return 0;
        }

        if(this.version == v3.version) {
            return 1;
        }

        return 0;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getPatch() {
        return this.patch;
    }

    public int hashCode() {
        return this.version;
    }

    public final boolean isAtLeast(int arg2, int arg3) {
        int v0 = this.major;
        if(v0 <= arg2 && (v0 != arg2 || this.minor < arg3)) {
            return 0;
        }

        return 1;
    }

    public final boolean isAtLeast(int arg2, int arg3, int arg4) {
        int v0 = this.major;
        if(v0 <= arg2) {
            if(v0 == arg2) {
                arg2 = this.minor;
                if(arg2 > arg3) {
                    return 1;
                }
                else if(arg2 == arg3 && this.patch >= arg4) {
                    return 1;
                }
            }

            return 0;
        }

        return 1;
    }

    public String toString() {
        return this.major + '.' + this.minor + '.' + this.patch;
    }

    private final int versionOf(int arg2, int arg3, int arg4) {
        if(arg2 >= 0) {
            int v1 = 0x100;
            if(arg2 < v1 && arg3 >= 0 && arg3 < v1 && arg4 >= 0 && arg4 < v1) {
                return (arg2 << 16) + (arg3 << 8) + arg4;
            }
        }

        throw new IllegalArgumentException("Version components are out of range: " + arg2 + '.' + arg3 + '.' + arg4.toString());
    }
}

