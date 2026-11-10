package okio.internal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Sink;
import okio.Source;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 02\u00020\u0001:\u00010B#\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\fH\u0016J\u0010\u0010\u0013\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\fH\u0002J\u0016\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u0015\u001A\u00020\fH\u0016J\u0018\u0010\u0016\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\n2\u0006\u0010\u0015\u001A\u00020\fH\u0016J\u0010\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\fH\u0016J \u0010\u001A\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\f2\u0006\u0010\u001B\u001A\u00020\u00052\u0006\u0010\u001C\u001A\u00020\u0005H\u0016J\u0012\u0010\u001D\u001A\u0004\u0018\u00010\u001E2\u0006\u0010\u0012\u001A\u00020\fH\u0016J\u0010\u0010\u001F\u001A\u00020 2\u0006\u0010\u0019\u001A\u00020\fH\u0016J\u0018\u0010!\u001A\u00020\"2\u0006\u0010\u0019\u001A\u00020\f2\u0006\u0010\u001B\u001A\u00020\u0005H\u0016J\u0018\u0010#\u001A\u00020\"2\u0006\u0010\u0019\u001A\u00020\f2\u0006\u0010\u001C\u001A\u00020\u0005H\u0016J\u0018\u0010$\u001A\u00020%2\u0006\u0010\u0015\u001A\u00020\f2\u0006\u0010\u001B\u001A\u00020\u0005H\u0016J\u0018\u0010&\u001A\u00020%2\u0006\u0010\u001F\u001A\u00020\f2\u0006\u0010\'\u001A\u00020\fH\u0016J\u0018\u0010(\u001A\u00020%2\u0006\u0010\u0012\u001A\u00020\f2\u0006\u0010\u001C\u001A\u00020\u0005H\u0016J\u0018\u0010)\u001A\u00020%2\u0006\u0010\u001F\u001A\u00020\f2\u0006\u0010\'\u001A\u00020\fH\u0016J\f\u0010*\u001A\u00020+*\u00020\fH\u0002J\u001E\u0010,\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000B0\n*\u00020\u0003H\u0002J\u001A\u0010-\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B*\u00020.H\u0002J\u001A\u0010/\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B*\u00020.H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\t\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000B0\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\r\u0010\u000E¨\u00061"}, d2={"Lokio/internal/ResourceFileSystem;", "Lokio/FileSystem;", "classLoader", "Ljava/lang/ClassLoader;", "indexEagerly", "", "systemFileSystem", "<init>", "(Ljava/lang/ClassLoader;ZLokio/FileSystem;)V", "roots", "", "Lkotlin/Pair;", "Lokio/Path;", "getRoots", "()Ljava/util/List;", "roots$delegate", "Lkotlin/Lazy;", "canonicalize", "path", "canonicalizeInternal", "list", "dir", "listOrNull", "openReadOnly", "Lokio/FileHandle;", "file", "openReadWrite", "mustCreate", "mustExist", "metadataOrNull", "Lokio/FileMetadata;", "source", "Lokio/Source;", "sink", "Lokio/Sink;", "appendingSink", "createDirectory", "", "atomicMove", "target", "delete", "createSymlink", "toRelativePath", "", "toClasspathRoots", "toFileRoot", "Ljava/net/URL;", "toJarRoot", "Companion", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ResourceFileSystem extends FileSystem {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001A\u00020\u0005J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0005H\u0002R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2={"Lokio/internal/ResourceFileSystem$Companion;", "", "<init>", "()V", "ROOT", "Lokio/Path;", "getROOT", "()Lokio/Path;", "removeBase", "base", "keepPath", "", "path", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final boolean access$keepPath(Companion arg0, Path arg1) {
            return arg0.keepPath(arg1);
        }

        public final Path getROOT() {
            return ResourceFileSystem.ROOT;
        }

        private final boolean keepPath(Path arg2) {
            return StringsKt.endsWith(arg2.name(), ".class", true) ^ 1;
        }

        public final Path removeBase(Path arg7, Path arg8) {
            Intrinsics.checkNotNullParameter(arg7, "<this>");
            Intrinsics.checkNotNullParameter(arg8, "base");
            return this.getROOT().resolve(StringsKt.replace$default(StringsKt.removePrefix(arg7.toString(), arg8.toString()), '\\', '/', false, 4, null));
        }
    }

    private static final Companion Companion;
    private static final Path ROOT;
    private final ClassLoader classLoader;
    private final Lazy roots$delegate;
    private final FileSystem systemFileSystem;

    static {
        ResourceFileSystem.Companion = new Companion(null);
        ResourceFileSystem.ROOT = okio.Path$Companion.get$default(Path.Companion, "/", false, 1, null);
    }

    public ResourceFileSystem(ClassLoader arg1, boolean arg2, FileSystem arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 4) != 0) {
            arg3 = FileSystem.SYSTEM;
        }

        this(arg1, arg2, arg3);
    }

    public ResourceFileSystem(ClassLoader arg2, boolean arg3, FileSystem arg4) {
        Intrinsics.checkNotNullParameter(arg2, "classLoader");
        Intrinsics.checkNotNullParameter(arg4, "systemFileSystem");
        super();
        this.classLoader = arg2;
        this.systemFileSystem = arg4;
        this.roots$delegate = LazyKt.lazy(new ResourceFileSystem$$ExternalSyntheticLambda1(this));
        if(arg3) {
            this.getRoots().size();
        }
    }

    public static final Path access$getROOT$cp() {
        return ResourceFileSystem.ROOT;
    }

    public Sink appendingSink(Path arg1, boolean arg2) {
        Intrinsics.checkNotNullParameter(arg1, "file");
        throw new IOException(this + " is read-only");
    }

    public void atomicMove(Path arg2, Path arg3) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        Intrinsics.checkNotNullParameter(arg3, "target");
        throw new IOException(this + " is read-only");
    }

    public Path canonicalize(Path arg2) {
        Intrinsics.checkNotNullParameter(arg2, "path");
        return this.canonicalizeInternal(arg2);
    }

    private final Path canonicalizeInternal(Path arg2) {
        return ResourceFileSystem.ROOT.resolve(arg2, true);
    }

    public void createDirectory(Path arg1, boolean arg2) {
        Intrinsics.checkNotNullParameter(arg1, "dir");
        throw new IOException(this + " is read-only");
    }

    public void createSymlink(Path arg2, Path arg3) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        Intrinsics.checkNotNullParameter(arg3, "target");
        throw new IOException(this + " is read-only");
    }

    public void delete(Path arg1, boolean arg2) {
        Intrinsics.checkNotNullParameter(arg1, "path");
        throw new IOException(this + " is read-only");
    }

    private final List getRoots() {
        return this.roots$delegate.getValue();
    }

    public List list(Path arg11) {
        Iterator v4_2;
        ArrayList v6;
        LinkedHashSet v5;
        Object v3;
        Intrinsics.checkNotNullParameter(arg11, "dir");
        String v0 = this.toRelativePath(arg11);
        LinkedHashSet v1 = new LinkedHashSet();
        Iterator v10 = this.getRoots().iterator();
        int v2 = 0;
        while(true) {
            if(v10.hasNext()) {
                v3 = v10.next();
                Object v4 = ((Pair)v3).component1();
                v3 = ((Pair)v3).component2();
                try {
                    v5 = v1;
                    List v4_1 = ((FileSystem)v4).list(((Path)v3).resolve(v0));
                    v6 = new ArrayList();
                    v4_2 = ((Iterable)v4_1).iterator();
                    goto label_19;
                }
                catch(IOException ) {
                    continue;
                }
            }

            if(v2 != 0) {
                return CollectionsKt.toList(((Iterable)v1));
            }

            throw new FileNotFoundException("file not found: " + arg11);
            try {
            label_19:
                while(v4_2.hasNext()) {
                    Object v7 = v4_2.next();
                    if(!Companion.access$keepPath(ResourceFileSystem.Companion, v7)) {
                        continue;
                    }

                    ((Collection)v6).add(v7);
                }

                ArrayList v4_3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v6), 10));
                Iterator v6_1 = ((Iterable)v6).iterator();
                while(v6_1.hasNext()) {
                    ((Collection)v4_3).add(ResourceFileSystem.Companion.removeBase(v6_1.next(), ((Path)v3)));
                }

                CollectionsKt.addAll(((Collection)v5), ((Iterable)v4_3));
                v2 = 1;
            }
            catch(IOException ) {
            }
        }
    }

    public List listOrNull(Path arg9) {
        ArrayList v3;
        Intrinsics.checkNotNullParameter(arg9, "dir");
        String v9 = this.toRelativePath(arg9);
        LinkedHashSet v0 = new LinkedHashSet();
        Iterator v8 = this.getRoots().iterator();
        int v1;
        for(v1 = 0; true; v1 = 1) {
        label_8:
            v3 = null;
            if(!v8.hasNext()) {
                break;
            }

            Object v2 = v8.next();
            Object v4 = ((Pair)v2).component1();
            v2 = ((Pair)v2).component2();
            List v4_1 = ((FileSystem)v4).listOrNull(((Path)v2).resolve(v9));
            if(v4_1 != null) {
                v3 = new ArrayList();
                Iterator v4_2 = ((Iterable)v4_1).iterator();
                while(v4_2.hasNext()) {
                    Object v5 = v4_2.next();
                    if(!Companion.access$keepPath(ResourceFileSystem.Companion, v5)) {
                        continue;
                    }

                    ((Collection)v3).add(v5);
                }

                ArrayList v4_3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v3), 10));
                Iterator v3_1 = ((Iterable)v3).iterator();
                while(v3_1.hasNext()) {
                    ((Collection)v4_3).add(ResourceFileSystem.Companion.removeBase(v3_1.next(), ((Path)v2)));
                }

                v3 = v4_3;
            }

            if(v3 == null) {
                goto label_8;
            }

            CollectionsKt.addAll(v0, ((Iterable)v3));
        }

        if(v1 != 0) {
            return CollectionsKt.toList(((Iterable)v0));
        }

        return ((List)v3);
    }

    public FileMetadata metadataOrNull(Path arg4) {
        FileMetadata v0_1;
        Intrinsics.checkNotNullParameter(arg4, "path");
        FileMetadata v1 = null;
        if(!Companion.access$keepPath(ResourceFileSystem.Companion, arg4)) {
            return v1;
        }

        String v4 = this.toRelativePath(arg4);
        Iterator v3 = this.getRoots().iterator();
        while(true) {
            if(!v3.hasNext()) {
                return v1;
            }

            Object v0 = v3.next();
            v0_1 = ((Pair)v0).component1().metadataOrNull(((Pair)v0).component2().resolve(v4));
            if(v0_1 != null) {
                return v0_1;
            }
        }

        return v0_1;
    }

    public FileHandle openReadOnly(Path arg5) {
        Intrinsics.checkNotNullParameter(arg5, "file");
        String v1 = "file not found: ";
        if(Companion.access$keepPath(ResourceFileSystem.Companion, arg5)) {
            String v0 = this.toRelativePath(arg5);
            Iterator v4 = this.getRoots().iterator();
        label_9:
            if(v4.hasNext()) {
                Object v2 = v4.next();
                Object v3 = ((Pair)v2).component1();
                v2 = ((Pair)v2).component2();
                try {
                    FileHandle v4_1 = ((FileSystem)v3).openReadOnly(((Path)v2).resolve(v0));
                    return v4_1;
                }
                catch(FileNotFoundException ) {
                    goto label_9;
                }
            }

            throw new FileNotFoundException(v1 + arg5);
        }

        throw new FileNotFoundException(v1 + arg5);
    }

    public FileHandle openReadWrite(Path arg1, boolean arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg1, "file");
        throw new IOException("resources are not writable");
    }

    static final List roots_delegate$lambda$0(ResourceFileSystem arg1) {
        return arg1.toClasspathRoots(arg1.classLoader);
    }

    public Sink sink(Path arg1, boolean arg2) {
        Intrinsics.checkNotNullParameter(arg1, "file");
        throw new IOException(this + " is read-only");
    }

    public Source source(Path arg6) {
        Intrinsics.checkNotNullParameter(arg6, "file");
        String v1 = "file not found: ";
        if(Companion.access$keepPath(ResourceFileSystem.Companion, arg6)) {
            URL v5 = this.classLoader.getResource(Path.resolve$default(ResourceFileSystem.ROOT, arg6, false, 2, null).relativeTo(ResourceFileSystem.ROOT).toString());
            if(v5 != null) {
                URLConnection v5_1 = v5.openConnection();
                if((v5_1 instanceof JarURLConnection)) {
                    v5_1.setUseCaches(false);
                }

                InputStream v5_2 = v5_1.getInputStream();
                Intrinsics.checkNotNullExpressionValue(v5_2, "getInputStream(...)");
                return Okio.source(v5_2);
            }

            throw new FileNotFoundException(v1 + arg6);
        }

        throw new FileNotFoundException(v1 + arg6);
    }

    private final List toClasspathRoots(ClassLoader arg6) {
        Enumeration v0 = arg6.getResources("");
        String v1 = "getResources(...)";
        Intrinsics.checkNotNullExpressionValue(v0, v1);
        ArrayList v0_1 = Collections.list(v0);
        String v2 = "list(...)";
        Intrinsics.checkNotNullExpressionValue(v0_1, v2);
        ArrayList v3 = new ArrayList();
        Iterator v0_2 = ((Iterable)v0_1).iterator();
        while(v0_2.hasNext()) {
            Object v4 = v0_2.next();
            Intrinsics.checkNotNull(v4);
            Pair v4_1 = this.toFileRoot(((URL)v4));
            if(v4_1 == null) {
                continue;
            }

            ((Collection)v3).add(v4_1);
        }

        Enumeration v6 = arg6.getResources("META-INF/MANIFEST.MF");
        Intrinsics.checkNotNullExpressionValue(v6, v1);
        ArrayList v6_1 = Collections.list(v6);
        Intrinsics.checkNotNullExpressionValue(v6_1, v2);
        v0_1 = new ArrayList();
        Iterator v6_2 = ((Iterable)v6_1).iterator();
        while(v6_2.hasNext()) {
            Object v1_1 = v6_2.next();
            Intrinsics.checkNotNull(v1_1);
            Pair v1_2 = this.toJarRoot(((URL)v1_1));
            if(v1_2 == null) {
                continue;
            }

            ((Collection)v0_1).add(v1_2);
        }

        return CollectionsKt.plus(((Collection)v3), ((Iterable)v0_1));
    }

    private final Pair toFileRoot(URL arg5) {
        Pair v1 = null;
        if(!Intrinsics.areEqual(arg5.getProtocol(), "file")) {
            return v1;
        }

        return TuplesKt.to(this.systemFileSystem, okio.Path$Companion.get$default(Path.Companion, new File(arg5.toURI()), false, 1, v1));
    }

    private final Pair toJarRoot(URL arg11) {
        String v11 = arg11.toString();
        Intrinsics.checkNotNullExpressionValue(v11, "toString(...)");
        Object v3 = null;
        if(!StringsKt.startsWith$default(v11, "jar:file:", false, 2, v3)) {
            return ((Pair)v3);
        }

        int v0 = StringsKt.lastIndexOf$default(v11, "!", 0, false, 6, null);
        if(v0 == -1) {
            return ((Pair)v3);
        }

        okio.Path$Companion v2 = Path.Companion;
        v11 = v11.substring(4, v0);
        Intrinsics.checkNotNullExpressionValue(v11, "substring(...)");
        return TuplesKt.to(ZipFilesKt.openZip(okio.Path$Companion.get$default(v2, new File(URI.create(v11)), false, 1, v3), this.systemFileSystem, new ResourceFileSystem$$ExternalSyntheticLambda0()), ResourceFileSystem.ROOT);
    }

    static final boolean toJarRoot$lambda$0(ZipEntry arg1) {
        Intrinsics.checkNotNullParameter(arg1, "entry");
        return Companion.access$keepPath(ResourceFileSystem.Companion, arg1.getCanonicalPath());
    }

    private final String toRelativePath(Path arg1) {
        return this.canonicalizeInternal(arg1).relativeTo(ResourceFileSystem.ROOT).toString();
    }
}

