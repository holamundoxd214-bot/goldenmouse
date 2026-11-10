package kotlin.io.path;

import java.io.Closeable;
import java.io.IOException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.IgnorableReturnValue;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000Ì\u0001\n\u0000\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u001C\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u000E\u0010\u0016\u001A\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\u0017\u001A\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004\u001A\u0016\u0010\u0018\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0019\u001A\u00020\u0002H\u0087\u0080\u0004\u001A\u0016\u0010\u001A\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0019\u001A\u00020\u0002H\u0087\u0080\u0004\u001A\u0018\u0010\u001B\u001A\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u0019\u001A\u00020\u0002H\u0087\u0080\u0004\u001A \u0010\u001C\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u001D\u001A\u00020\u00022\b\b\u0002\u0010\u001E\u001A\u00020\u001FH\u0087\u0088\b\u001A/\u0010\u001C\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u001D\u001A\u00020\u00022\u0012\u0010 \u001A\n\u0012\u0006\b\u0001\u0012\u00020\"0!\"\u00020\"H\u0087\u0088\b¢\u0006\u0002\u0010#\u001A\'\u0010$\u001A\u00020\u001F*\u00020\u00022\u0012\u0010 \u001A\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\u0088\u0004¢\u0006\u0002\u0010&\u001A\'\u0010\'\u001A\u00020\u001F*\u00020\u00022\u0012\u0010 \u001A\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\u0088\u0004¢\u0006\u0002\u0010&\u001A\'\u0010(\u001A\u00020\u001F*\u00020\u00022\u0012\u0010 \u001A\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\u0088\u0004¢\u0006\u0002\u0010&\u001A\'\u0010)\u001A\u00020\u001F*\u00020\u00022\u0012\u0010 \u001A\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\u0088\u0004¢\u0006\u0002\u0010&\u001A\u000E\u0010*\u001A\u00020\u001F*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010+\u001A\u00020\u001F*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010,\u001A\u00020\u001F*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010-\u001A\u00020\u001F*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010.\u001A\u00020\u001F*\u00020\u0002H\u0087\u0088\u0004\u001A\u0016\u0010/\u001A\u00020\u001F*\u00020\u00022\u0006\u00100\u001A\u00020\u0002H\u0087\u0088\u0004\u001A\u001E\u00101\u001A\b\u0012\u0004\u0012\u00020\u000202*\u00020\u00022\b\b\u0002\u00103\u001A\u00020\u0001H\u0087\u0080\u0004\u001A@\u00104\u001A\u0002H5\"\u0004\b\u0000\u00105*\u00020\u00022\b\b\u0002\u00103\u001A\u00020\u00012\u0018\u00106\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000208\u0012\u0004\u0012\u0002H507H\u0087\u0088\bø\u0001\u0000¢\u0006\u0002\u00109\u001A/\u0010:\u001A\u00020;*\u00020\u00022\b\b\u0002\u00103\u001A\u00020\u00012\u0012\u0010<\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020;07H\u0087\u0088\u0004ø\u0001\u0000\u001A\u000E\u0010=\u001A\u00020>*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010?\u001A\u00020;*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010@\u001A\u00020\u001F*\u00020\u0002H\u0087\u0088\b\u001A/\u0010A\u001A\u00020\u0002*\u00020\u00022\u001A\u0010B\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030C0!\"\u0006\u0012\u0002\b\u00030CH\u0087\u0088\b¢\u0006\u0002\u0010D\u001A/\u0010E\u001A\u00020\u0002*\u00020\u00022\u001A\u0010B\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030C0!\"\u0006\u0012\u0002\b\u00030CH\u0087\u0088\b¢\u0006\u0002\u0010D\u001A/\u0010F\u001A\u00020\u0002*\u00020\u00022\u001A\u0010B\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030C0!\"\u0006\u0012\u0002\b\u00030CH\u0087\u0080\b¢\u0006\u0002\u0010D\u001A/\u0010G\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u001D\u001A\u00020\u00022\u0012\u0010 \u001A\n\u0012\u0006\b\u0001\u0012\u00020\"0!\"\u00020\"H\u0087\u0088\b¢\u0006\u0002\u0010#\u001A \u0010G\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u001D\u001A\u00020\u00022\b\b\u0002\u0010\u001E\u001A\u00020\u001FH\u0087\u0088\b\u001A\u000E\u0010H\u001A\u00020I*\u00020\u0002H\u0087\u0088\u0004\u001A1\u0010J\u001A\u0004\u0018\u00010K*\u00020\u00022\u0006\u0010L\u001A\u00020\u00012\u0012\u0010 \u001A\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\u0088\u0004¢\u0006\u0002\u0010M\u001A9\u0010N\u001A\u00020\u0002*\u00020\u00022\u0006\u0010L\u001A\u00020\u00012\b\u0010O\u001A\u0004\u0018\u00010K2\u0012\u0010 \u001A\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\u0088\b¢\u0006\u0002\u0010P\u001A5\u0010Q\u001A\u0004\u0018\u0001HR\"\n\b\u0000\u0010R\u0018\u0001*\u00020S*\u00020\u00022\u0012\u0010 \u001A\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\u0088\u0004¢\u0006\u0002\u0010T\u001A3\u0010U\u001A\u0002HR\"\n\b\u0000\u0010R\u0018\u0001*\u00020S*\u00020\u00022\u0012\u0010 \u001A\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\u0088\u0004¢\u0006\u0002\u0010T\u001A\u001E\u0010V\u001A\u00020W2\u0006\u0010X\u001A\u00020\u00022\n\u0010Y\u001A\u0006\u0012\u0002\b\u00030ZH\u0081\u0080\u0004\u001A3\u0010[\u001A\u0002H\\\"\n\b\u0000\u0010\\\u0018\u0001*\u00020]*\u00020\u00022\u0012\u0010 \u001A\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\u0088\u0004¢\u0006\u0002\u0010^\u001A=\u0010[\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010K0_*\u00020\u00022\u0006\u0010B\u001A\u00020\u00012\u0012\u0010 \u001A\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\u0088\u0004¢\u0006\u0002\u0010`\u001A\'\u0010a\u001A\u00020b*\u00020\u00022\u0012\u0010 \u001A\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\u0088\u0004¢\u0006\u0002\u0010c\u001A\u0016\u0010d\u001A\u00020\u0002*\u00020\u00022\u0006\u0010O\u001A\u00020bH\u0087\u0088\u0004\u001A)\u0010e\u001A\u0004\u0018\u00010f*\u00020\u00022\u0012\u0010 \u001A\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\u0088\u0004¢\u0006\u0002\u0010g\u001A\u0016\u0010h\u001A\u00020\u0002*\u00020\u00022\u0006\u0010O\u001A\u00020fH\u0087\u0088\b\u001A-\u0010i\u001A\b\u0012\u0004\u0012\u00020k0j*\u00020\u00022\u0012\u0010 \u001A\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%H\u0087\u0088\u0004¢\u0006\u0002\u0010l\u001A\u001C\u0010m\u001A\u00020\u0002*\u00020\u00022\f\u0010O\u001A\b\u0012\u0004\u0012\u00020k0jH\u0087\u0088\u0004\u001A\u0016\u0010n\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u001D\u001A\u00020\u0002H\u0087\u0088\b\u001A7\u0010o\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u001D\u001A\u00020\u00022\u001A\u0010B\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030C0!\"\u0006\u0012\u0002\b\u00030CH\u0087\u0088\b¢\u0006\u0002\u0010p\u001A\u000E\u0010q\u001A\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004\u001A/\u0010r\u001A\u00020\u0002*\u00020\u00022\u001A\u0010B\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030C0!\"\u0006\u0012\u0002\b\u00030CH\u0087\u0088\b¢\u0006\u0002\u0010D\u001AC\u0010s\u001A\u00020\u00022\n\b\u0002\u0010t\u001A\u0004\u0018\u00010\u00012\n\b\u0002\u0010u\u001A\u0004\u0018\u00010\u00012\u001A\u0010B\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030C0!\"\u0006\u0012\u0002\b\u00030CH\u0087\u0088\u0004¢\u0006\u0002\u0010v\u001AM\u0010s\u001A\u00020\u00022\b\u0010w\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010t\u001A\u0004\u0018\u00010\u00012\n\b\u0002\u0010u\u001A\u0004\u0018\u00010\u00012\u001A\u0010B\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030C0!\"\u0006\u0012\u0002\b\u00030CH\u0087\u0080\u0004¢\u0006\u0002\u0010x\u001A7\u0010y\u001A\u00020\u00022\n\b\u0002\u0010t\u001A\u0004\u0018\u00010\u00012\u001A\u0010B\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030C0!\"\u0006\u0012\u0002\b\u00030CH\u0087\u0088\u0004¢\u0006\u0002\u0010z\u001AA\u0010y\u001A\u00020\u00022\b\u0010w\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010t\u001A\u0004\u0018\u00010\u00012\u001A\u0010B\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030C0!\"\u0006\u0012\u0002\b\u00030CH\u0087\u0080\u0004¢\u0006\u0002\u0010{\u001A\u0016\u0010|\u001A\u00020\u0002*\u00020\u00022\u0006\u00100\u001A\u00020\u0002H\u0087\u008A\u0004\u001A\u0016\u0010|\u001A\u00020\u0002*\u00020\u00022\u0006\u00100\u001A\u00020\u0001H\u0087\u008A\u0004\u001A\u0012\u0010}\u001A\u00020\u00022\u0006\u0010X\u001A\u00020\u0001H\u0087\u0088\u0004\u001A+\u0010}\u001A\u00020\u00022\u0006\u0010\u0019\u001A\u00020\u00012\u0012\u0010~\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00010!\"\u00020\u0001H\u0087\u0088\u0004¢\u0006\u0002\u0010\u007F\u001A\u0010\u0010\u0080\u0001\u001A\u00020\u0002*\u00030\u0081\u0001H\u0087\u0088\u0004\u001A1\u0010\u0082\u0001\u001A\b\u0012\u0004\u0012\u00020\u000208*\u00020\u00022\u0014\u0010 \u001A\u000B\u0012\u0007\b\u0001\u0012\u00030\u0083\u00010!\"\u00030\u0083\u0001H\u0087\u0080\u0004¢\u0006\u0003\u0010\u0084\u0001\u001A6\u0010\u0085\u0001\u001A\u00020;*\u00020\u00022\u000E\u0010\u0086\u0001\u001A\t\u0012\u0004\u0012\u00020\u00020\u0087\u00012\n\b\u0002\u0010\u0088\u0001\u001A\u00030\u0089\u00012\t\b\u0002\u0010\u008A\u0001\u001A\u00020\u001FH\u0087\u0080\u0004\u001AO\u0010\u0085\u0001\u001A\u00020;*\u00020\u00022\n\b\u0002\u0010\u0088\u0001\u001A\u00030\u0089\u00012\t\b\u0002\u0010\u008A\u0001\u001A\u00020\u001F2\u001A\u0010\u008B\u0001\u001A\u0015\u0012\u0005\u0012\u00030\u008C\u0001\u0012\u0004\u0012\u00020;07¢\u0006\u0003\b\u008D\u0001H\u0087\u0080\u0004\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001\u001A;\u0010\u008E\u0001\u001A\t\u0012\u0004\u0012\u00020\u00020\u0087\u00012\u001A\u0010\u008B\u0001\u001A\u0015\u0012\u0005\u0012\u00030\u008C\u0001\u0012\u0004\u0012\u00020;07¢\u0006\u0003\b\u008D\u0001H\u0087\u0080\u0004\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\"\u001F\u0010\u0000\u001A\u00020\u0001*\u00020\u00028FX\u0087\u0084\b¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006\"\u001F\u0010\u0007\u001A\u00020\u0001*\u00020\u00028FX\u0087\u0084\b¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001A\u0004\b\t\u0010\u0006\"\u001F\u0010\n\u001A\u00020\u0001*\u00020\u00028FX\u0087\u0084\b¢\u0006\f\u0012\u0004\b\u000B\u0010\u0004\u001A\u0004\b\f\u0010\u0006\" \u0010\r\u001A\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b\u000E\u0010\u0004\u001A\u0004\b\u000F\u0010\u0006\"\u001F\u0010\u0010\u001A\u00020\u0001*\u00020\u00028FX\u0087\u0084\b¢\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001A\u0004\b\u0012\u0010\u0006\" \u0010\u0013\u001A\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b\u0014\u0010\u0004\u001A\u0004\b\u0015\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u008F\u0001"}, d2={"name", "", "Ljava/nio/file/Path;", "getName$annotations", "(Ljava/nio/file/Path;)V", "getName", "(Ljava/nio/file/Path;)Ljava/lang/String;", "nameWithoutExtension", "getNameWithoutExtension$annotations", "getNameWithoutExtension", "extension", "getExtension$annotations", "getExtension", "pathString", "getPathString$annotations", "getPathString", "invariantSeparatorsPathString", "getInvariantSeparatorsPathString$annotations", "getInvariantSeparatorsPathString", "invariantSeparatorsPath", "getInvariantSeparatorsPath$annotations", "getInvariantSeparatorsPath", "absolute", "absolutePathString", "relativeTo", "base", "relativeToOrSelf", "relativeToOrNull", "copyTo", "target", "overwrite", "", "options", "", "Ljava/nio/file/CopyOption;", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;", "exists", "Ljava/nio/file/LinkOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "notExists", "isRegularFile", "isDirectory", "isSymbolicLink", "isExecutable", "isHidden", "isReadable", "isWritable", "isSameFileAs", "other", "listDirectoryEntries", "", "glob", "useDirectoryEntries", "T", "block", "Lkotlin/Function1;", "Lkotlin/sequences/Sequence;", "(Ljava/nio/file/Path;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "forEachDirectoryEntry", "", "action", "fileSize", "", "deleteExisting", "deleteIfExists", "createDirectory", "attributes", "Ljava/nio/file/attribute/FileAttribute;", "(Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createDirectories", "createParentDirectories", "moveTo", "fileStore", "Ljava/nio/file/FileStore;", "getAttribute", "", "attribute", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "setAttribute", "value", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/Object;[Ljava/nio/file/LinkOption;)Ljava/nio/file/Path;", "fileAttributesViewOrNull", "V", "Ljava/nio/file/attribute/FileAttributeView;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileAttributeView;", "fileAttributesView", "fileAttributeViewNotAvailable", "", "path", "attributeViewClass", "Ljava/lang/Class;", "readAttributes", "A", "Ljava/nio/file/attribute/BasicFileAttributes;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/BasicFileAttributes;", "", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/util/Map;", "getLastModifiedTime", "Ljava/nio/file/attribute/FileTime;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileTime;", "setLastModifiedTime", "getOwner", "Ljava/nio/file/attribute/UserPrincipal;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/UserPrincipal;", "setOwner", "getPosixFilePermissions", "", "Ljava/nio/file/attribute/PosixFilePermission;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/util/Set;", "setPosixFilePermissions", "createLinkPointingTo", "createSymbolicLinkPointingTo", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "readSymbolicLink", "createFile", "createTempFile", "prefix", "suffix", "(Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "directory", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createTempDirectory", "(Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "div", "Path", "subpaths", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;", "toPath", "Ljava/net/URI;", "walk", "Lkotlin/io/path/PathWalkOption;", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)Lkotlin/sequences/Sequence;", "visitFileTree", "visitor", "Ljava/nio/file/FileVisitor;", "maxDepth", "", "followLinks", "builderAction", "Lkotlin/io/path/FileVisitorBuilder;", "Lkotlin/ExtensionFunctionType;", "fileVisitor", "kotlin-stdlib-jdk7"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/io/path/PathsKt") class PathsKt__PathUtilsKt extends PathsKt__PathRecursiveFunctionsKt {
    public PathsKt__PathUtilsKt() {
        super();
    }

    private static final Path Path(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "path");
        Path v1 = Paths.get(arg1, new String[0]);
        Intrinsics.checkNotNullExpressionValue(v1, "get(...)");
        return v1;
    }

    private static final Path Path(String arg1, String[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "base");
        Intrinsics.checkNotNullParameter(arg2, "subpaths");
        Path v1 = Paths.get(arg1, Arrays.copyOf(((Object[])arg2), arg2.length));
        Intrinsics.checkNotNullExpressionValue(v1, "get(...)");
        return v1;
    }

    private static final Path absolute(Path arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.toAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(arg1, "toAbsolutePath(...)");
        return arg1;
    }

    private static final String absolutePathString(Path arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.toAbsolutePath().toString();
    }

    @IgnorableReturnValue private static final Path copyTo(Path arg2, Path arg3, boolean arg4) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "target");
        CopyOption[] v4 = arg4 ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        arg2 = Files.copy(arg2, arg3, Arrays.copyOf(((Object[])v4), v4.length));
        Intrinsics.checkNotNullExpressionValue(arg2, "copy(...)");
        return arg2;
    }

    @IgnorableReturnValue private static final Path copyTo(Path arg1, Path arg2, CopyOption[] arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "target");
        Intrinsics.checkNotNullParameter(arg3, "options");
        arg1 = Files.copy(arg1, arg2, Arrays.copyOf(((Object[])arg3), arg3.length));
        Intrinsics.checkNotNullExpressionValue(arg1, "copy(...)");
        return arg1;
    }

    static Path copyTo$default(Path arg0, Path arg1, boolean arg2, int arg3, Object arg4) throws IOException {
        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "target");
        CopyOption[] v2 = 0 != 0 ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        arg0 = Files.copy(arg0, arg1, Arrays.copyOf(((Object[])v2), v2.length));
        Intrinsics.checkNotNullExpressionValue(arg0, "copy(...)");
        return arg0;
    }

    @IgnorableReturnValue private static final Path createDirectories(Path arg1, FileAttribute[] arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "attributes");
        arg1 = Files.createDirectories(arg1, Arrays.copyOf(((Object[])arg2), arg2.length));
        Intrinsics.checkNotNullExpressionValue(arg1, "createDirectories(...)");
        return arg1;
    }

    @IgnorableReturnValue private static final Path createDirectory(Path arg1, FileAttribute[] arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "attributes");
        arg1 = Files.createDirectory(arg1, Arrays.copyOf(((Object[])arg2), arg2.length));
        Intrinsics.checkNotNullExpressionValue(arg1, "createDirectory(...)");
        return arg1;
    }

    @IgnorableReturnValue private static final Path createFile(Path arg1, FileAttribute[] arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "attributes");
        arg1 = Files.createFile(arg1, Arrays.copyOf(((Object[])arg2), arg2.length));
        Intrinsics.checkNotNullExpressionValue(arg1, "createFile(...)");
        return arg1;
    }

    @IgnorableReturnValue private static final Path createLinkPointingTo(Path arg1, Path arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "target");
        arg1 = Files.createLink(arg1, arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "createLink(...)");
        return arg1;
    }

    @IgnorableReturnValue public static final Path createParentDirectories(Path arg3, FileAttribute[] arg4) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "attributes");
        Path v0 = arg3.getParent();
        if(v0 != null && !Files.isDirectory(v0, Arrays.copyOf(new LinkOption[0], 0))) {
            try {
                Object[] v4_1 = Arrays.copyOf(((Object[])arg4), arg4.length);
                Intrinsics.checkNotNullExpressionValue(Files.createDirectories(v0, Arrays.copyOf(v4_1, v4_1.length)), "createDirectories(...)");
                return arg3;
            }
            catch(FileAlreadyExistsException v4) {
                if(Files.isDirectory(v0, Arrays.copyOf(new LinkOption[0], 0))) {
                    return arg3;
                }

                throw v4;
            }
        }

        return arg3;
    }

    @IgnorableReturnValue private static final Path createSymbolicLinkPointingTo(Path arg1, Path arg2, FileAttribute[] arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "target");
        Intrinsics.checkNotNullParameter(arg3, "attributes");
        arg1 = Files.createSymbolicLink(arg1, arg2, Arrays.copyOf(((Object[])arg3), arg3.length));
        Intrinsics.checkNotNullExpressionValue(arg1, "createSymbolicLink(...)");
        return arg1;
    }

    private static final Path createTempDirectory(String arg1, FileAttribute[] arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "attributes");
        Path v1 = Files.createTempDirectory(arg1, Arrays.copyOf(((Object[])arg2), arg2.length));
        Intrinsics.checkNotNullExpressionValue(v1, "createTempDirectory(...)");
        return v1;
    }

    public static final Path createTempDirectory(Path arg2, String arg3, FileAttribute[] arg4) throws IOException {
        Intrinsics.checkNotNullParameter(arg4, "attributes");
        String v0 = "createTempDirectory(...)";
        if(arg2 != null) {
            arg2 = Files.createTempDirectory(arg2, arg3, Arrays.copyOf(((Object[])arg4), arg4.length));
            Intrinsics.checkNotNullExpressionValue(arg2, v0);
            return arg2;
        }

        arg2 = Files.createTempDirectory(arg3, Arrays.copyOf(((Object[])arg4), arg4.length));
        Intrinsics.checkNotNullExpressionValue(arg2, v0);
        return arg2;
    }

    static Path createTempDirectory$default(String arg0, FileAttribute[] arg1, int arg2, Object arg3) throws IOException {
        if((arg2 & 1) != 0) {
            arg0 = null;
        }

        Intrinsics.checkNotNullParameter(arg1, "attributes");
        Path v0 = Files.createTempDirectory(arg0, Arrays.copyOf(((Object[])arg1), arg1.length));
        Intrinsics.checkNotNullExpressionValue(v0, "createTempDirectory(...)");
        return v0;
    }

    public static Path createTempDirectory$default(Path arg0, String arg1, FileAttribute[] arg2, int arg3, Object arg4) throws IOException {
        if((arg3 & 2) != 0) {
            arg1 = null;
        }

        return PathsKt.createTempDirectory(arg0, arg1, arg2);
    }

    private static final Path createTempFile(String arg1, String arg2, FileAttribute[] arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "attributes");
        Path v1 = Files.createTempFile(arg1, arg2, Arrays.copyOf(((Object[])arg3), arg3.length));
        Intrinsics.checkNotNullExpressionValue(v1, "createTempFile(...)");
        return v1;
    }

    public static final Path createTempFile(Path arg2, String arg3, String arg4, FileAttribute[] arg5) throws IOException {
        Intrinsics.checkNotNullParameter(arg5, "attributes");
        String v0 = "createTempFile(...)";
        if(arg2 != null) {
            arg2 = Files.createTempFile(arg2, arg3, arg4, Arrays.copyOf(((Object[])arg5), arg5.length));
            Intrinsics.checkNotNullExpressionValue(arg2, v0);
            return arg2;
        }

        arg2 = Files.createTempFile(arg3, arg4, Arrays.copyOf(((Object[])arg5), arg5.length));
        Intrinsics.checkNotNullExpressionValue(arg2, v0);
        return arg2;
    }

    static Path createTempFile$default(String arg1, String arg2, FileAttribute[] arg3, int arg4, Object arg5) throws IOException {
        String v0 = null;
        if((arg4 & 1) != 0) {
            arg1 = v0;
        }

        if((arg4 & 2) != 0) {
            arg2 = v0;
        }

        Intrinsics.checkNotNullParameter(arg3, "attributes");
        Path v1 = Files.createTempFile(arg1, arg2, Arrays.copyOf(((Object[])arg3), arg3.length));
        Intrinsics.checkNotNullExpressionValue(v1, "createTempFile(...)");
        return v1;
    }

    public static Path createTempFile$default(Path arg1, String arg2, String arg3, FileAttribute[] arg4, int arg5, Object arg6) throws IOException {
        String v0 = null;
        if((arg5 & 2) != 0) {
            arg2 = v0;
        }

        if((arg5 & 4) != 0) {
            arg3 = v0;
        }

        return PathsKt.createTempFile(arg1, arg2, arg3, arg4);
    }

    private static final void deleteExisting(Path arg1) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Files.delete(arg1);
    }

    @IgnorableReturnValue private static final boolean deleteIfExists(Path arg1) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Files.deleteIfExists(arg1);
    }

    private static final Path div(Path arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        arg1 = arg1.resolve(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "resolve(...)");
        return arg1;
    }

    private static final Path div(Path arg1, Path arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        arg1 = arg1.resolve(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "resolve(...)");
        return arg1;
    }

    private static final boolean exists(Path arg1, LinkOption[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "options");
        return Files.exists(arg1, Arrays.copyOf(((Object[])arg2), arg2.length));
    }

    public static final Void fileAttributeViewNotAvailable(Path arg3, Class arg4) {
        Intrinsics.checkNotNullParameter(arg3, "path");
        Intrinsics.checkNotNullParameter(arg4, "attributeViewClass");
        throw new UnsupportedOperationException("The desired attribute view type " + arg4 + " is not available for the file " + arg3 + '.');
    }

    private static final FileAttributeView fileAttributesView(Path arg4, LinkOption[] arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "options");
        int v0 = 4;
        String v1 = "V";
        Intrinsics.reifiedOperationMarker(v0, v1);
        Class v2 = FileAttributeView.class;
        FileAttributeView v5 = Files.getFileAttributeView(arg4, v2, Arrays.copyOf(((Object[])arg5), arg5.length));
        if(v5 != null) {
            return v5;
        }

        Intrinsics.reifiedOperationMarker(v0, v1);
        PathsKt.fileAttributeViewNotAvailable(arg4, v2);
        throw new KotlinNothingValueException();
    }

    private static final FileAttributeView fileAttributesViewOrNull(Path arg2, LinkOption[] arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "options");
        Intrinsics.reifiedOperationMarker(4, "V");
        return Files.getFileAttributeView(arg2, FileAttributeView.class, Arrays.copyOf(((Object[])arg3), arg3.length));
    }

    private static final long fileSize(Path arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return Files.size(arg2);
    }

    private static final FileStore fileStore(Path arg1) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        FileStore v1 = Files.getFileStore(arg1);
        Intrinsics.checkNotNullExpressionValue(v1, "getFileStore(...)");
        return v1;
    }

    public static final FileVisitor fileVisitor(Function1 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "builderAction");
        FileVisitorBuilderImpl v0 = new FileVisitorBuilderImpl();
        arg1.invoke(v0);
        return v0.build();
    }

    private static final void forEachDirectoryEntry(Path arg1, String arg2, Function1 arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "glob");
        Intrinsics.checkNotNullParameter(arg3, "action");
        DirectoryStream v1 = Files.newDirectoryStream(arg1, arg2);
        try {
            Intrinsics.checkNotNull(v1);
            Iterator v2_1 = v1.iterator();
            while(v2_1.hasNext()) {
                arg3.invoke(v2_1.next());
            }
        }
        catch(Throwable v2) {
            goto label_20;
        }

        CloseableKt.closeFinally(((Closeable)v1), null);
        return;
        try {
        label_20:
            throw v2;
        }
        catch(Throwable v3) {
            CloseableKt.closeFinally(((Closeable)v1), v2);
            throw v3;
        }
    }

    static void forEachDirectoryEntry$default(Path arg0, String arg1, Function1 arg2, int arg3, Object arg4) throws IOException {
        if((arg3 & 1) != 0) {
            arg1 = "*";
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "glob");
        Intrinsics.checkNotNullParameter(arg2, "action");
        DirectoryStream v0 = Files.newDirectoryStream(arg0, arg1);
        try {
            Intrinsics.checkNotNull(v0);
            Iterator v1_1 = v0.iterator();
            while(v1_1.hasNext()) {
                arg2.invoke(v1_1.next());
            }
        }
        catch(Throwable v1) {
            goto label_23;
        }

        CloseableKt.closeFinally(((Closeable)v0), null);
        return;
        try {
        label_23:
            throw v1;
        }
        catch(Throwable v2) {
            CloseableKt.closeFinally(((Closeable)v0), v1);
            throw v2;
        }
    }

    private static final Object getAttribute(Path arg1, String arg2, LinkOption[] arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "attribute");
        Intrinsics.checkNotNullParameter(arg3, "options");
        return Files.getAttribute(arg1, arg2, Arrays.copyOf(((Object[])arg3), arg3.length));
    }

    public static final String getExtension(Path arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        arg2 = arg2.getFileName();
        String v0 = "";
        if(arg2 != null) {
            String v2 = arg2.toString();
            if(v2 != null) {
                v2 = StringsKt.substringAfterLast(v2, '.', v0);
                if(v2 == null) {
                }
                else {
                    return v2;
                }
            }
        }

        return v0;
    }

    public static void getExtension$annotations(Path arg0) {
    }

    private static final String getInvariantSeparatorsPath(Path arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return PathsKt.getInvariantSeparatorsPathString(arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Use invariantSeparatorsPathString property instead.", replaceWith="<_subannotation>") public static void getInvariantSeparatorsPath$annotations(Path arg0) {
    }

    public static final String getInvariantSeparatorsPathString(Path arg7) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        String v2 = arg7.getFileSystem().getSeparator();
        if(!Intrinsics.areEqual(v2, "/")) {
            String v1 = arg7.toString();
            Intrinsics.checkNotNull(v2);
            return StringsKt.replace$default(v1, v2, "/", false, 4, null);
        }

        return arg7.toString();
    }

    public static void getInvariantSeparatorsPathString$annotations(Path arg0) {
    }

    private static final FileTime getLastModifiedTime(Path arg1, LinkOption[] arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "options");
        FileTime v1 = Files.getLastModifiedTime(arg1, Arrays.copyOf(((Object[])arg2), arg2.length));
        Intrinsics.checkNotNullExpressionValue(v1, "getLastModifiedTime(...)");
        return v1;
    }

    public static final String getName(Path arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.getFileName();
        String v1 = arg1 != null ? arg1.toString() : null;
        if(v1 == null) {
            v1 = "";
        }

        return v1;
    }

    public static void getName$annotations(Path arg0) {
    }

    public static final String getNameWithoutExtension(Path arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        arg3 = arg3.getFileName();
        if(arg3 != null) {
            String v3 = arg3.toString();
            if(v3 != null) {
                v3 = StringsKt.substringBeforeLast$default(v3, ".", null, 2, null);
                if(v3 == null) {
                }
                else {
                    return v3;
                }
            }
        }

        return "";
    }

    public static void getNameWithoutExtension$annotations(Path arg0) {
    }

    private static final UserPrincipal getOwner(Path arg1, LinkOption[] arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "options");
        return Files.getOwner(arg1, Arrays.copyOf(((Object[])arg2), arg2.length));
    }

    private static final String getPathString(Path arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.toString();
    }

    public static void getPathString$annotations(Path arg0) {
    }

    private static final Set getPosixFilePermissions(Path arg1, LinkOption[] arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "options");
        Set v1 = Files.getPosixFilePermissions(arg1, Arrays.copyOf(((Object[])arg2), arg2.length));
        Intrinsics.checkNotNullExpressionValue(v1, "getPosixFilePermissions(...)");
        return v1;
    }

    private static final boolean isDirectory(Path arg1, LinkOption[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "options");
        return Files.isDirectory(arg1, Arrays.copyOf(((Object[])arg2), arg2.length));
    }

    private static final boolean isExecutable(Path arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Files.isExecutable(arg1);
    }

    private static final boolean isHidden(Path arg1) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Files.isHidden(arg1);
    }

    private static final boolean isReadable(Path arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Files.isReadable(arg1);
    }

    private static final boolean isRegularFile(Path arg1, LinkOption[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "options");
        return Files.isRegularFile(arg1, Arrays.copyOf(((Object[])arg2), arg2.length));
    }

    private static final boolean isSameFileAs(Path arg1, Path arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        return Files.isSameFile(arg1, arg2);
    }

    private static final boolean isSymbolicLink(Path arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Files.isSymbolicLink(arg1);
    }

    private static final boolean isWritable(Path arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Files.isWritable(arg1);
    }

    public static final List listDirectoryEntries(Path arg1, String arg2) throws IOException {
        List v2_1;
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "glob");
        DirectoryStream v1 = Files.newDirectoryStream(arg1, arg2);
        try {
            Intrinsics.checkNotNull(v1);
            v2_1 = CollectionsKt.toList(v1);
        }
        catch(Throwable v2) {
            try {
                throw v2;
            }
            catch(Throwable v0) {
                CloseableKt.closeFinally(((Closeable)v1), v2);
                throw v0;
            }
        }

        CloseableKt.closeFinally(((Closeable)v1), null);
        return v2_1;
    }

    public static List listDirectoryEntries$default(Path arg0, String arg1, int arg2, Object arg3) throws IOException {
        if((arg2 & 1) != 0) {
            arg1 = "*";
        }

        return PathsKt.listDirectoryEntries(arg0, arg1);
    }

    @IgnorableReturnValue private static final Path moveTo(Path arg2, Path arg3, boolean arg4) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "target");
        CopyOption[] v4 = arg4 ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        arg2 = Files.move(arg2, arg3, Arrays.copyOf(((Object[])v4), v4.length));
        Intrinsics.checkNotNullExpressionValue(arg2, "move(...)");
        return arg2;
    }

    @IgnorableReturnValue private static final Path moveTo(Path arg1, Path arg2, CopyOption[] arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "target");
        Intrinsics.checkNotNullParameter(arg3, "options");
        arg1 = Files.move(arg1, arg2, Arrays.copyOf(((Object[])arg3), arg3.length));
        Intrinsics.checkNotNullExpressionValue(arg1, "move(...)");
        return arg1;
    }

    static Path moveTo$default(Path arg0, Path arg1, boolean arg2, int arg3, Object arg4) throws IOException {
        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "target");
        CopyOption[] v2 = 0 != 0 ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        arg0 = Files.move(arg0, arg1, Arrays.copyOf(((Object[])v2), v2.length));
        Intrinsics.checkNotNullExpressionValue(arg0, "move(...)");
        return arg0;
    }

    private static final boolean notExists(Path arg1, LinkOption[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "options");
        return Files.notExists(arg1, Arrays.copyOf(((Object[])arg2), arg2.length));
    }

    private static final BasicFileAttributes readAttributes(Path arg2, LinkOption[] arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "options");
        Intrinsics.reifiedOperationMarker(4, "A");
        BasicFileAttributes v2 = Files.readAttributes(arg2, BasicFileAttributes.class, Arrays.copyOf(((Object[])arg3), arg3.length));
        Intrinsics.checkNotNullExpressionValue(v2, "readAttributes(...)");
        return v2;
    }

    private static final Map readAttributes(Path arg1, String arg2, LinkOption[] arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "attributes");
        Intrinsics.checkNotNullParameter(arg3, "options");
        Map v1 = Files.readAttributes(arg1, arg2, Arrays.copyOf(((Object[])arg3), arg3.length));
        Intrinsics.checkNotNullExpressionValue(v1, "readAttributes(...)");
        return v1;
    }

    private static final Path readSymbolicLink(Path arg1) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = Files.readSymbolicLink(arg1);
        Intrinsics.checkNotNullExpressionValue(arg1, "readSymbolicLink(...)");
        return arg1;
    }

    public static final Path relativeTo(Path arg4, Path arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "base");
        try {
            return PathRelativizer.INSTANCE.tryRelativeTo(arg4, arg5);
        }
        catch(IllegalArgumentException v0) {
            throw new IllegalArgumentException(v0.getMessage() + "\nthis path: " + arg4 + "\nbase path: " + arg5, ((Throwable)v0));
        }
    }

    public static final Path relativeToOrNull(Path arg1, Path arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "base");
        try {
            return PathRelativizer.INSTANCE.tryRelativeTo(arg1, arg2);
        }
        catch(IllegalArgumentException ) {
            return null;
        }
    }

    public static final Path relativeToOrSelf(Path arg1, Path arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "base");
        arg2 = PathsKt.relativeToOrNull(arg1, arg2);
        if(arg2 == null) {
            return arg1;
        }

        return arg2;
    }

    @IgnorableReturnValue private static final Path setAttribute(Path arg1, String arg2, Object arg3, LinkOption[] arg4) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "attribute");
        Intrinsics.checkNotNullParameter(arg4, "options");
        arg1 = Files.setAttribute(arg1, arg2, arg3, Arrays.copyOf(((Object[])arg4), arg4.length));
        Intrinsics.checkNotNullExpressionValue(arg1, "setAttribute(...)");
        return arg1;
    }

    private static final Path setLastModifiedTime(Path arg1, FileTime arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "value");
        arg1 = Files.setLastModifiedTime(arg1, arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "setLastModifiedTime(...)");
        return arg1;
    }

    @IgnorableReturnValue private static final Path setOwner(Path arg1, UserPrincipal arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "value");
        arg1 = Files.setOwner(arg1, arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "setOwner(...)");
        return arg1;
    }

    private static final Path setPosixFilePermissions(Path arg1, Set arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "value");
        arg1 = Files.setPosixFilePermissions(arg1, arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "setPosixFilePermissions(...)");
        return arg1;
    }

    private static final Path toPath(URI arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Path v1 = Paths.get(arg1);
        Intrinsics.checkNotNullExpressionValue(v1, "get(...)");
        return v1;
    }

    @IgnorableReturnValue private static final Object useDirectoryEntries(Path arg1, String arg2, Function1 arg3) throws IOException {
        Object v2_1;
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "glob");
        Intrinsics.checkNotNullParameter(arg3, "block");
        DirectoryStream v1 = Files.newDirectoryStream(arg1, arg2);
        try {
            Intrinsics.checkNotNull(v1);
            v2_1 = arg3.invoke(CollectionsKt.asSequence(v1));
        }
        catch(Throwable v2) {
            try {
                throw v2;
            }
            catch(Throwable v3) {
                CloseableKt.closeFinally(((Closeable)v1), v2);
                throw v3;
            }
        }

        CloseableKt.closeFinally(((Closeable)v1), null);
        return v2_1;
    }

    static Object useDirectoryEntries$default(Path arg0, String arg1, Function1 arg2, int arg3, Object arg4) throws IOException {
        Object v1_1;
        if((arg3 & 1) != 0) {
            arg1 = "*";
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "glob");
        Intrinsics.checkNotNullParameter(arg2, "block");
        DirectoryStream v0 = Files.newDirectoryStream(arg0, arg1);
        try {
            Intrinsics.checkNotNull(v0);
            v1_1 = arg2.invoke(CollectionsKt.asSequence(v0));
        }
        catch(Throwable v1) {
            try {
                throw v1;
            }
            catch(Throwable v2) {
                CloseableKt.closeFinally(((Closeable)v0), v1);
                throw v2;
            }
        }

        CloseableKt.closeFinally(((Closeable)v0), null);
        return v1_1;
    }

    public static final void visitFileTree(Path arg1, int arg2, boolean arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "builderAction");
        PathsKt.visitFileTree(arg1, PathsKt.fileVisitor(arg4), arg2, arg3);
    }

    public static final void visitFileTree(Path arg1, FileVisitor arg2, int arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "visitor");
        Set v4 = arg4 ? SetsKt.setOf(FileVisitOption.FOLLOW_LINKS) : SetsKt.emptySet();
        Files.walkFileTree(arg1, v4, arg3, arg2);
    }

    public static void visitFileTree$default(Path arg0, int arg1, boolean arg2, Function1 arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = 0x7FFFFFFF;
        }

        PathsKt.visitFileTree(arg0, arg1, false, arg3);
    }

    public static void visitFileTree$default(Path arg0, FileVisitor arg1, int arg2, boolean arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = 0x7FFFFFFF;
        }

        PathsKt.visitFileTree(arg0, arg1, arg2, false);
    }

    public static final Sequence walk(Path arg1, PathWalkOption[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "options");
        return new PathTreeWalk(arg1, arg2);
    }
}

