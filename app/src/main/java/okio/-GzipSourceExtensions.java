package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0010\u000B\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\u0015\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0002H\u0082\b\u001A\r\u0010\r\u001A\u00020\u000E*\u00020\u000FH\u0086\b\"\u000E\u0010\u0004\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0005\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0006\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0007\u001A\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\b\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\n\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000B\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\f\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"getBit", "", "", "bit", "FHCRC", "FEXTRA", "FNAME", "FCOMMENT", "SECTION_HEADER", "", "SECTION_BODY", "SECTION_TRAILER", "SECTION_DONE", "gzip", "Lokio/GzipSource;", "Lokio/Source;", "okio"}, k=2, mv={2, 1, 0}, xi=0x30) public final class -GzipSourceExtensions {
    private static final int FCOMMENT = 4;
    private static final int FEXTRA = 2;
    private static final int FHCRC = 1;
    private static final int FNAME = 3;
    private static final byte SECTION_BODY = 1;
    private static final byte SECTION_DONE = 3;
    private static final byte SECTION_HEADER = 0;
    private static final byte SECTION_TRAILER = 2;

    private static final boolean getBit(int arg0, int arg1) {
        if((arg0 >> arg1 & 1) == 1) {
            return 1;
        }

        return 0;
    }

    public static final GzipSource gzip(Source arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new GzipSource(arg1);
    }
}

