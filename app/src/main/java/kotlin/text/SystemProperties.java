package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lkotlin/text/SystemProperties;", "", "<init>", "()V", "LINE_SEPARATOR", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class SystemProperties {
    public static final SystemProperties INSTANCE;
    public static final String LINE_SEPARATOR;

    static {
        SystemProperties.INSTANCE = new SystemProperties();
        String v0 = System.getProperty("line.separator");
        Intrinsics.checkNotNull(v0);
        SystemProperties.LINE_SEPARATOR = v0;
    }

    private SystemProperties() {
        super();
    }
}

