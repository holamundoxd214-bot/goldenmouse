package okio.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Path$Companion;
import okio.Path;

@Metadata(d1={"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0002\u001A\u000F\u0010\u0006\u001A\u0004\u0018\u00010\u0007*\u00020\u0007H\u0080\b\u001A\u0013\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u0007H\u0080\b\u001A\u0013\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00010\t*\u00020\u0007H\u0080\b\u001A\f\u0010\f\u001A\u00020\r*\u00020\u0007H\u0002\u001A\r\u0010\u000E\u001A\u00020\u000F*\u00020\u0007H\u0080\b\u001A\r\u0010\u0010\u001A\u00020\u000F*\u00020\u0007H\u0080\b\u001A\u0014\u0010\u0011\u001A\u0004\u0018\u00010\u0012*\u00020\u0007H\u0080\b¢\u0006\u0002\u0010\u0013\u001A\r\u0010\u0017\u001A\u00020\u0001*\u00020\u0007H\u0080\b\u001A\r\u0010\u0018\u001A\u00020\n*\u00020\u0007H\u0080\b\u001A\u000F\u0010\u0019\u001A\u0004\u0018\u00010\u0007*\u00020\u0007H\u0080\b\u001A\f\u0010\u001A\u001A\u00020\u000F*\u00020\u0007H\u0002\u001A\r\u0010\u001B\u001A\u00020\u000F*\u00020\u0007H\u0080\b\u001A\u001D\u0010\u001C\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u001D\u001A\u00020\n2\u0006\u0010\u001E\u001A\u00020\u000FH\u0080\b\u001A\u001D\u0010\u001C\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u001D\u001A\u00020\u00012\u0006\u0010\u001E\u001A\u00020\u000FH\u0080\b\u001A\u001D\u0010\u001C\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u001D\u001A\u00020\u001F2\u0006\u0010\u001E\u001A\u00020\u000FH\u0080\b\u001A\u001C\u0010\u001C\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u001D\u001A\u00020\u00072\u0006\u0010\u001E\u001A\u00020\u000FH\u0000\u001A\u0015\u0010 \u001A\u00020\u0007*\u00020\u00072\u0006\u0010!\u001A\u00020\u0007H\u0080\b\u001A\r\u0010\"\u001A\u00020\u0007*\u00020\u0007H\u0080\b\u001A\u0015\u0010&\u001A\u00020\r*\u00020\u00072\u0006\u0010!\u001A\u00020\u0007H\u0080\b\u001A\u0017\u0010\'\u001A\u00020\u000F*\u00020\u00072\b\u0010!\u001A\u0004\u0018\u00010(H\u0080\b\u001A\r\u0010)\u001A\u00020\r*\u00020\u0007H\u0080\b\u001A\r\u0010*\u001A\u00020\n*\u00020\u0007H\u0080\b\u001A\u0014\u0010+\u001A\u00020\u0007*\u00020\n2\u0006\u0010\u001E\u001A\u00020\u000FH\u0000\u001A\u0014\u0010,\u001A\u00020\u0007*\u00020\u001F2\u0006\u0010\u001E\u001A\u00020\u000FH\u0000\u001A\f\u0010-\u001A\u00020\u0001*\u00020\nH\u0002\u001A\f\u0010-\u001A\u00020\u0001*\u00020.H\u0002\u001A\u0014\u0010/\u001A\u00020\u000F*\u00020\u001F2\u0006\u0010#\u001A\u00020\u0001H\u0002\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0004\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0005\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0014\u001A\u00020\r*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016\"\u001A\u0010#\u001A\u0004\u0018\u00010\u0001*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b$\u0010%¨\u00060"}, d2={"SLASH", "Lokio/ByteString;", "BACKSLASH", "ANY_SLASH", "DOT", "DOT_DOT", "commonRoot", "Lokio/Path;", "commonSegments", "", "", "commonSegmentsBytes", "rootLength", "", "commonIsAbsolute", "", "commonIsRelative", "commonVolumeLetter", "", "(Lokio/Path;)Ljava/lang/Character;", "indexOfLastSlash", "getIndexOfLastSlash", "(Lokio/Path;)I", "commonNameBytes", "commonName", "commonParent", "lastSegmentIsDotDot", "commonIsRoot", "commonResolve", "child", "normalize", "Lokio/Buffer;", "commonRelativeTo", "other", "commonNormalized", "slash", "getSlash", "(Lokio/Path;)Lokio/ByteString;", "commonCompareTo", "commonEquals", "", "commonHashCode", "commonToString", "commonToPath", "toPath", "toSlash", "", "startsWithVolumeLetterAndColon", "okio"}, k=2, mv={2, 1, 0}, xi=0x30) public final class -Path {
    private static final ByteString ANY_SLASH;
    private static final ByteString BACKSLASH;
    private static final ByteString DOT;
    private static final ByteString DOT_DOT;
    private static final ByteString SLASH;

    static {
        -Path.SLASH = ByteString.Companion.encodeUtf8("/");
        -Path.BACKSLASH = ByteString.Companion.encodeUtf8("\\");
        -Path.ANY_SLASH = ByteString.Companion.encodeUtf8("/\\");
        -Path.DOT = ByteString.Companion.encodeUtf8(".");
        -Path.DOT_DOT = ByteString.Companion.encodeUtf8("..");
    }

    public static final ByteString access$getBACKSLASH$p() {
        return -Path.BACKSLASH;
    }

    public static final ByteString access$getDOT$p() {
        return -Path.DOT;
    }

    public static final ByteString access$getDOT_DOT$p() {
        return -Path.DOT_DOT;
    }

    public static final int access$getIndexOfLastSlash(Path arg0) {
        return -Path.getIndexOfLastSlash(arg0);
    }

    public static final ByteString access$getSLASH$p() {
        return -Path.SLASH;
    }

    public static final ByteString access$getSlash(Path arg0) {
        return -Path.getSlash(arg0);
    }

    public static final boolean access$lastSegmentIsDotDot(Path arg0) {
        return -Path.lastSegmentIsDotDot(arg0);
    }

    public static final int access$rootLength(Path arg0) {
        return -Path.rootLength(arg0);
    }

    public static final ByteString access$toSlash(String arg0) {
        return -Path.toSlash(arg0);
    }

    public static final int commonCompareTo(Path arg1, Path arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        return arg1.getBytes$okio().compareTo(arg2.getBytes$okio());
    }

    public static final boolean commonEquals(Path arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(((arg2 instanceof Path)) && (Intrinsics.areEqual(((Path)arg2).getBytes$okio(), arg1.getBytes$okio()))) {
            return 1;
        }

        return 0;
    }

    public static final int commonHashCode(Path arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getBytes$okio().hashCode();
    }

    public static final boolean commonIsAbsolute(Path arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(-Path.rootLength(arg1) != -1) {
            return 1;
        }

        return 0;
    }

    public static final boolean commonIsRelative(Path arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(-Path.rootLength(arg1) == -1) {
            return 1;
        }

        return 0;
    }

    public static final boolean commonIsRoot(Path arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(-Path.rootLength(arg1) == arg1.getBytes$okio().size()) {
            return 1;
        }

        return 0;
    }

    public static final String commonName(Path arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.nameBytes().utf8();
    }

    public static final ByteString commonNameBytes(Path arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        int v0 = -Path.getIndexOfLastSlash(arg4);
        int v2 = 2;
        if(v0 != -1) {
            return ByteString.substring$default(arg4.getBytes$okio(), v0 + 1, 0, v2, null);
        }

        if(arg4.volumeLetter() != null && arg4.getBytes$okio().size() == v2) {
            return ByteString.EMPTY;
        }

        return arg4.getBytes$okio();
    }

    public static final Path commonNormalized(Path arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return Path.Companion.get(arg2.toString(), true);
    }

    public static final Path commonParent(Path arg7) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Path v1 = null;
        if(!Intrinsics.areEqual(arg7.getBytes$okio(), -Path.DOT) && !Intrinsics.areEqual(arg7.getBytes$okio(), -Path.SLASH) && !Intrinsics.areEqual(arg7.getBytes$okio(), -Path.BACKSLASH)) {
            if(-Path.lastSegmentIsDotDot(arg7)) {
            }
            else {
                int v0 = -Path.getIndexOfLastSlash(arg7);
                int v2 = 2;
                if(v0 == v2 && arg7.volumeLetter() != null) {
                    v2 = 3;
                    if(arg7.getBytes$okio().size() == v2) {
                        return v1;
                    }
                    else {
                        return new Path(ByteString.substring$default(arg7.getBytes$okio(), 0, v2, 1, v1));
                    }
                }

                if(v0 == 1 && (arg7.getBytes$okio().startsWith(-Path.BACKSLASH))) {
                    return v1;
                }

                int v5 = -1;
                if(v0 == v5 && arg7.volumeLetter() != null) {
                    if(arg7.getBytes$okio().size() == v2) {
                        return v1;
                    }
                    else {
                        return new Path(ByteString.substring$default(arg7.getBytes$okio(), 0, v2, 1, v1));
                    }
                }

                if(v0 == v5) {
                    return new Path(-Path.DOT);
                }

                if(v0 == 0) {
                    return new Path(ByteString.substring$default(arg7.getBytes$okio(), 0, 1, 1, v1));
                }

                return new Path(ByteString.substring$default(arg7.getBytes$okio(), 0, v0, 1, v1));
            }
        }

        return v1;
    }

    public static final Path commonRelativeTo(Path arg8, Path arg9) {
        int v2_1;
        int v8;
        ByteString v9;
        Buffer v1_1;
        Intrinsics.checkNotNullParameter(arg8, "<this>");
        Intrinsics.checkNotNullParameter(arg9, "other");
        String v1 = " and ";
        if(Intrinsics.areEqual(arg8.getRoot(), arg9.getRoot())) {
            List v0 = arg8.getSegmentsBytes();
            List v2 = arg9.getSegmentsBytes();
            int v3 = Math.min(v0.size(), v2.size());
            int v5;
            for(v5 = 0; v5 < v3; ++v5) {
                if(!Intrinsics.areEqual(v0.get(v5), v2.get(v5))) {
                    break;
                }
            }

            if(v5 == v3 && arg8.getBytes$okio().size() == arg9.getBytes$okio().size()) {
                return Companion.get$default(Path.Companion, ".", false, 1, null);
            }

            if(v2.subList(v5, v2.size()).indexOf(-Path.DOT_DOT) == -1) {
                if(Intrinsics.areEqual(arg9.getBytes$okio(), -Path.DOT)) {
                    return arg8;
                }

                v1_1 = new Buffer();
                v9 = -Path.getSlash(arg9);
                if(v9 == null) {
                    v9 = -Path.getSlash(arg8);
                    if(v9 == null) {
                        v9 = -Path.toSlash(Path.DIRECTORY_SEPARATOR);
                    }
                }

                v8 = v2.size();
                v2_1 = v5;
            }
            else {
                throw new IllegalArgumentException("Impossible relative path to resolve: " + arg8 + v1 + arg9.toString());
            }

            while(v2_1 < v8) {
                v1_1.write(-Path.DOT_DOT);
                v1_1.write(v9);
                ++v2_1;
            }

            v8 = v0.size();
            while(v5 < v8) {
                v1_1.write(v0.get(v5));
                v1_1.write(v9);
                ++v5;
            }

            return -Path.toPath(v1_1, false);
        }

        throw new IllegalArgumentException("Paths of different roots cannot be relative to each other: " + arg8 + v1 + arg9.toString());
    }

    public static final Path commonResolve(Path arg6, Path arg7, boolean arg8) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Intrinsics.checkNotNullParameter(arg7, "child");
        if(!arg7.isAbsolute()) {
            if(arg7.volumeLetter() != null) {
            }
            else {
                ByteString v0 = -Path.getSlash(arg6);
                if(v0 == null) {
                    v0 = -Path.getSlash(arg7);
                    if(v0 == null) {
                        v0 = -Path.toSlash(Path.DIRECTORY_SEPARATOR);
                    }
                }

                Buffer v1 = new Buffer();
                v1.write(arg6.getBytes$okio());
                if(v1.size() > 0) {
                    v1.write(v0);
                }

                v1.write(arg7.getBytes$okio());
                return -Path.toPath(v1, arg8);
            }
        }

        return arg7;
    }

    public static final Path commonResolve(Path arg1, String arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "child");
        return -Path.commonResolve(arg1, -Path.toPath(new Buffer().writeUtf8(arg2), false), arg3);
    }

    public static final Path commonResolve(Path arg1, Buffer arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "child");
        return -Path.commonResolve(arg1, -Path.toPath(arg2, false), arg3);
    }

    public static final Path commonResolve(Path arg1, ByteString arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "child");
        return -Path.commonResolve(arg1, -Path.toPath(new Buffer().write(arg2), false), arg3);
    }

    public static final Path commonRoot(Path arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        int v0 = -Path.rootLength(arg3);
        if(v0 == -1) {
            return null;
        }

        return new Path(arg3.getBytes$okio().substring(0, v0));
    }

    public static final List commonSegments(Path arg7) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        ArrayList v0 = new ArrayList();
        int v1 = -Path.rootLength(arg7);
        int v3 = 92;
        if(v1 == -1) {
            v1 = 0;
        }
        else if(v1 < arg7.getBytes$okio().size() && arg7.getBytes$okio().getByte(v1) == v3) {
            ++v1;
        }

        int v2 = arg7.getBytes$okio().size();
        int v4 = v1;
        while(v1 < v2) {
            if(arg7.getBytes$okio().getByte(v1) == 0x2F || arg7.getBytes$okio().getByte(v1) == v3) {
                v0.add(arg7.getBytes$okio().substring(v4, v1));
                v4 = v1 + 1;
            }

            ++v1;
        }

        if(v4 < arg7.getBytes$okio().size()) {
            v0.add(arg7.getBytes$okio().substring(v4, arg7.getBytes$okio().size()));
        }

        ArrayList v7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v0), 10));
        Iterator v0_1 = ((Iterable)v0).iterator();
        while(v0_1.hasNext()) {
            ((Collection)v7).add(v0_1.next().utf8());
        }

        return ((List)v7);
    }

    public static final List commonSegmentsBytes(Path arg7) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        ArrayList v0 = new ArrayList();
        int v1 = -Path.rootLength(arg7);
        int v3 = 92;
        if(v1 == -1) {
            v1 = 0;
        }
        else if(v1 < arg7.getBytes$okio().size() && arg7.getBytes$okio().getByte(v1) == v3) {
            ++v1;
        }

        int v2 = arg7.getBytes$okio().size();
        int v4 = v1;
        while(v1 < v2) {
            if(arg7.getBytes$okio().getByte(v1) == 0x2F || arg7.getBytes$okio().getByte(v1) == v3) {
                v0.add(arg7.getBytes$okio().substring(v4, v1));
                v4 = v1 + 1;
            }

            ++v1;
        }

        if(v4 < arg7.getBytes$okio().size()) {
            v0.add(arg7.getBytes$okio().substring(v4, arg7.getBytes$okio().size()));
        }

        return ((List)v0);
    }

    public static final Path commonToPath(String arg1, boolean arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return -Path.toPath(new Buffer().writeUtf8(arg1), arg2);
    }

    public static final String commonToString(Path arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getBytes$okio().utf8();
    }

    public static final Character commonVolumeLetter(Path arg5) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        int v3 = 2;
        Object v4 = null;
        if(ByteString.indexOf$default(arg5.getBytes$okio(), -Path.SLASH, 0, v3, v4) != -1) {
            return ((Character)v4);
        }

        if(arg5.getBytes$okio().size() < v3) {
            return ((Character)v4);
        }

        if(arg5.getBytes$okio().getByte(1) != 58) {
            return ((Character)v4);
        }

        char v5 = ((char)arg5.getBytes$okio().getByte(0));
        if(97 > v5 || v5 >= 0x7B) {
            if(65 <= v5 && v5 < 91) {
                goto label_33;
            }

            goto label_35;
        }
        else {
        }

    label_33:
        return Character.valueOf(v5);
    label_35:
        return ((Character)v4);
    }

    private static final int getIndexOfLastSlash(Path arg5) {
        int v3 = 2;
        Object v4 = null;
        int v0 = ByteString.lastIndexOf$default(arg5.getBytes$okio(), -Path.SLASH, 0, v3, v4);
        if(v0 != -1) {
            return v0;
        }

        return ByteString.lastIndexOf$default(arg5.getBytes$okio(), -Path.BACKSLASH, 0, v3, v4);
    }

    private static final ByteString getSlash(Path arg6) {
        ByteString v0 = arg6.getBytes$okio();
        ByteString v1 = -Path.SLASH;
        int v3 = 2;
        Object v4 = null;
        int v5 = -1;
        if(ByteString.indexOf$default(v0, v1, 0, v3, v4) != v5) {
            return v1;
        }

        ByteString v6 = arg6.getBytes$okio();
        v0 = -Path.BACKSLASH;
        if(ByteString.indexOf$default(v6, v0, 0, v3, v4) != v5) {
            return v0;
        }

        return ((ByteString)v4);
    }

    private static final boolean lastSegmentIsDotDot(Path arg5) {
        if(arg5.getBytes$okio().endsWith(-Path.DOT_DOT)) {
            if(arg5.getBytes$okio().size() == 2) {
                return 1;
            }
            else if(arg5.getBytes$okio().rangeEquals(arg5.getBytes$okio().size() - 3, -Path.SLASH, 0, 1)) {
                return 1;
            }
            else if(arg5.getBytes$okio().rangeEquals(arg5.getBytes$okio().size() - 3, -Path.BACKSLASH, 0, 1)) {
                return 1;
            }
        }

        return 0;
    }

    private static final int rootLength(Path arg6) {
        int v1 = -1;
        if(arg6.getBytes$okio().size() == 0) {
            return v1;
        }

        if(arg6.getBytes$okio().getByte(0) == 0x2F) {
            return 1;
        }

        int v3 = 92;
        int v5 = 2;
        if(arg6.getBytes$okio().getByte(0) == v3) {
            if(arg6.getBytes$okio().size() > v5 && arg6.getBytes$okio().getByte(1) == v3) {
                int v0 = arg6.getBytes$okio().indexOf(-Path.BACKSLASH, v5);
                if(v0 == v1) {
                    return arg6.getBytes$okio().size();
                }
                else {
                    return v0;
                }
            }

            return 1;
        }

        if(arg6.getBytes$okio().size() > v5 && arg6.getBytes$okio().getByte(1) == 58 && arg6.getBytes$okio().getByte(v5) == v3) {
            char v6 = ((char)arg6.getBytes$okio().getByte(0));
            if(97 > v6 || v6 >= 0x7B) {
                if(65 > v6) {
                }
                else if(v6 < 91) {
                    return 3;
                }

                return v1;
            }
            else {
            }

            return 3;
        }

        return v1;
    }

    private static final boolean startsWithVolumeLetterAndColon(Buffer arg5, ByteString arg6) {
        if(!Intrinsics.areEqual(arg6, -Path.BACKSLASH)) {
            return 0;
        }

        if(arg5.size() < 2) {
            return 0;
        }

        if(arg5.getByte(1) != 58) {
            return 0;
        }

        char v5 = ((char)arg5.getByte(0));
        if(97 > v5 || v5 >= 0x7B) {
            if(65 <= v5 && v5 < 91) {
                return 1;
            }

            return 0;
        }
        else {
        }

        return 1;
    }

    public static final Path toPath(Buffer arg16, boolean arg17) {
        ByteString v12_1;
        ArrayList v8;
        ByteString v2_1;
        long v12;
        Buffer v0 = arg16;
        Intrinsics.checkNotNullParameter(v0, "<this>");
        Buffer v1 = new Buffer();
        Object v2 = null;
        int v3 = 0;
        int v4;
        for(v4 = 0; true; ++v4) {
            long v6 = 0;
            if(!v0.rangeEquals(v6, -Path.SLASH)) {
                ByteString v5 = -Path.BACKSLASH;
                if(v0.rangeEquals(v6, v5)) {
                }
                else {
                    int v5_1 = v4 < 2 || !Intrinsics.areEqual(v2, v5) ? 0 : 1;
                    long v10 = -1;
                    if(v5_1 != 0) {
                        Intrinsics.checkNotNull(v2);
                        v1.write(((ByteString)v2));
                        v1.write(((ByteString)v2));
                    }
                    else if(v4 > 0) {
                        Intrinsics.checkNotNull(v2);
                        v1.write(((ByteString)v2));
                    }
                    else {
                        v12 = v0.indexOfElement(-Path.ANY_SLASH);
                        if((((ByteString)v2)) == null) {
                            v2_1 = v12 == v10 ? -Path.toSlash(Path.DIRECTORY_SEPARATOR) : -Path.toSlash(v0.getByte(v12));
                        }

                        if(!-Path.startsWithVolumeLetterAndColon(v0, ((ByteString)v2))) {
                            goto label_52;
                        }

                        long v14 = 2;
                        if(v12 == v14) {
                            v1.write(v0, 3);
                            goto label_52;
                        }

                        v1.write(v0, v14);
                    }

                label_52:
                    v4 = v1.size() > v6 ? 1 : 0;
                    v8 = new ArrayList();
                    break;
                }
            }

            byte v5_2 = v0.readByte();
            if((((ByteString)v2)) == null) {
                v2_1 = -Path.toSlash(v5_2);
            }
        }

        while(!v0.exhausted()) {
            v12 = v0.indexOfElement(-Path.ANY_SLASH);
            if(v12 == v10) {
                v12_1 = v0.readByteString();
            }
            else {
                v12_1 = v0.readByteString(v12);
                v0.readByte();
            }

            ByteString v13 = -Path.DOT_DOT;
            if(Intrinsics.areEqual(v12_1, v13)) {
                if(v4 != 0 && (((List)v8).isEmpty())) {
                    continue;
                }

                if(arg17) {
                    if(v4 == 0) {
                        if(((List)v8).isEmpty()) {
                            goto label_87;
                        }
                        else if(Intrinsics.areEqual(CollectionsKt.last(((List)v8)), v13)) {
                            goto label_87;
                        }
                    }

                    if(v5_1 != 0 && ((List)v8).size() == 1) {
                        continue;
                    }

                    CollectionsKt.removeLastOrNull(((List)v8));
                    continue;
                }

            label_87:
                ((List)v8).add(v12_1);
                continue;
            }

            if(Intrinsics.areEqual(v12_1, -Path.DOT)) {
                continue;
            }

            if(Intrinsics.areEqual(v12_1, ByteString.EMPTY)) {
                continue;
            }

            ((List)v8).add(v12_1);
        }

        int v0_1 = ((List)v8).size();
        while(v3 < v0_1) {
            if(v3 > 0) {
                v1.write(((ByteString)v2));
            }

            v1.write(((List)v8).get(v3));
            ++v3;
        }

        if(v1.size() == v6) {
            v1.write(-Path.DOT);
        }

        return new Path(v1.readByteString());
    }

    private static final ByteString toSlash(String arg3) {
        if(Intrinsics.areEqual(arg3, "/")) {
            return -Path.SLASH;
        }

        if(Intrinsics.areEqual(arg3, "\\")) {
            return -Path.BACKSLASH;
        }

        throw new IllegalArgumentException("not a directory separator: " + arg3);
    }

    private static final ByteString toSlash(byte arg3) {
        if(arg3 != 0x2F) {
            if(arg3 == 92) {
                return -Path.BACKSLASH;
            }

            throw new IllegalArgumentException("not a directory separator: " + arg3);
        }

        return -Path.SLASH;
    }
}

