package androidx.window.core;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001D2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001DB)\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0016\u001A\u00020\u0007H\u0016J\u0011\u0010\u0017\u001A\u00020\u00032\u0006\u0010\u0018\u001A\u00020\u0000H\u0096\u0002J\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u0018\u001A\u0004\u0018\u00010\u001BH\u0096\u0002J\b\u0010\u001C\u001A\u00020\u0003H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000BR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000BR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u001B\u0010\u0010\u001A\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u001E"}, d2={"Landroidx/window/core/Version;", "", "major", "", "minor", "patch", "description", "", "<init>", "(IIILjava/lang/String;)V", "getMajor", "()I", "getMinor", "getPatch", "getDescription", "()Ljava/lang/String;", "bigInteger", "Ljava/math/BigInteger;", "getBigInteger", "()Ljava/math/BigInteger;", "bigInteger$delegate", "Lkotlin/Lazy;", "toString", "compareTo", "other", "equals", "", "", "hashCode", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Version implements Comparable {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0010\u001A\u0004\u0018\u00010\u00052\b\u0010\u0011\u001A\u0004\u0018\u00010\u000FH\u0007R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0007R\u0011\u0010\f\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u0007R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Landroidx/window/core/Version$Companion;", "", "<init>", "()V", "UNKNOWN", "Landroidx/window/core/Version;", "getUNKNOWN", "()Landroidx/window/core/Version;", "VERSION_0_1", "getVERSION_0_1", "VERSION_1_0", "getVERSION_1_0", "CURRENT", "getCURRENT", "VERSION_PATTERN_STRING", "", "parse", "versionString", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Version getCURRENT() {
            return Version.CURRENT;
        }

        public final Version getUNKNOWN() {
            return Version.UNKNOWN;
        }

        public final Version getVERSION_0_1() {
            return Version.VERSION_0_1;
        }

        public final Version getVERSION_1_0() {
            return Version.VERSION_1_0;
        }

        @JvmStatic public final Version parse(String arg8) {
            Version v7 = null;
            if(arg8 != null) {
                if(StringsKt.isBlank(((CharSequence)arg8))) {
                }
                else {
                    Matcher v8 = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(((CharSequence)arg8));
                    if(!v8.matches()) {
                        return v7;
                    }
                    else {
                        String v0 = v8.group(1);
                        if(v0 != null) {
                            int v2 = Integer.parseInt(v0);
                            v0 = v8.group(2);
                            if(v0 != null) {
                                int v3 = Integer.parseInt(v0);
                                v0 = v8.group(3);
                                if(v0 != null) {
                                    int v4 = Integer.parseInt(v0);
                                    int v7_1 = 4;
                                    String v7_2 = v8.group(v7_1) != null ? v8.group(v7_1) : "";
                                    Intrinsics.checkNotNull(v7_2);
                                    return new Version(v2, v3, v4, v7_2, null);
                                }
                            }
                        }
                    }
                }
            }

            return v7;
        }
    }

    private static final Version CURRENT = null;
    public static final Companion Companion = null;
    private static final Version UNKNOWN = null;
    private static final Version VERSION_0_1 = null;
    private static final Version VERSION_1_0 = null;
    private static final String VERSION_PATTERN_STRING = "(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?";
    private final Lazy bigInteger$delegate;
    private final String description;
    private final int major;
    private final int minor;
    private final int patch;

    static {
        Version.Companion = new Companion(null);
        Version.UNKNOWN = new Version(0, 0, 0, "");
        Version.VERSION_0_1 = new Version(0, 1, 0, "");
        Version v0 = new Version(1, 0, 0, "");
        Version.VERSION_1_0 = v0;
        Version.CURRENT = v0;
    }

    private Version(int arg1, int arg2, int arg3, String arg4) {
        super();
        this.major = arg1;
        this.minor = arg2;
        this.patch = arg3;
        this.description = arg4;
        this.bigInteger$delegate = LazyKt.lazy(new Version$$ExternalSyntheticLambda0(this));
    }

    public Version(int arg1, int arg2, int arg3, String arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    public static final Version access$getCURRENT$cp() {
        return Version.CURRENT;
    }

    public static final Version access$getUNKNOWN$cp() {
        return Version.UNKNOWN;
    }

    public static final Version access$getVERSION_0_1$cp() {
        return Version.VERSION_0_1;
    }

    public static final Version access$getVERSION_1_0$cp() {
        return Version.VERSION_1_0;
    }

    static final BigInteger bigInteger_delegate$lambda$0(Version arg4) {
        return BigInteger.valueOf(((long)arg4.major)).shiftLeft(0x20).or(BigInteger.valueOf(((long)arg4.minor))).shiftLeft(0x20).or(BigInteger.valueOf(((long)arg4.patch)));
    }

    public int compareTo(Version arg2) {
        Intrinsics.checkNotNullParameter(arg2, "other");
        return this.getBigInteger().compareTo(arg2.getBigInteger());
    }

    public int compareTo(Object arg1) {
        return this.compareTo(((Version)arg1));
    }

    public boolean equals(Object arg4) {
        if(!(arg4 instanceof Version)) {
            return 0;
        }

        if(this.major == ((Version)arg4).major && this.minor == ((Version)arg4).minor && this.patch == ((Version)arg4).patch) {
            return 1;
        }

        return 0;
    }

    private final BigInteger getBigInteger() {
        Object v1 = this.bigInteger$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(v1, "getValue(...)");
        return ((BigInteger)v1);
    }

    public final String getDescription() {
        return this.description;
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
        return ((0x20F + this.major) * 0x1F + this.minor) * 0x1F + this.patch;
    }

    @JvmStatic public static final Version parse(String arg1) {
        return Version.Companion.parse(arg1);
    }

    public String toString() {
        String v0 = !StringsKt.isBlank(this.description) ? "-" + this.description : "";
        return this.major + '.' + this.minor + '.' + this.patch + v0;
    }
}

