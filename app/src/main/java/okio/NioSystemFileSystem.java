package okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0012\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\b\u001A\u00020\tH\u0004J\u0013\u0010\n\u001A\u0004\u0018\u00010\u000B*\u00020\fH\u0002¢\u0006\u0002\u0010\rJ\u0018\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u0007H\u0016J\u0018\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u0007H\u0016J\b\u0010\u0013\u001A\u00020\u0014H\u0016¨\u0006\u0015"}, d2={"Lokio/NioSystemFileSystem;", "Lokio/JvmSystemFileSystem;", "<init>", "()V", "metadataOrNull", "Lokio/FileMetadata;", "path", "Lokio/Path;", "nioPath", "Ljava/nio/file/Path;", "zeroToNull", "", "Ljava/nio/file/attribute/FileTime;", "(Ljava/nio/file/attribute/FileTime;)Ljava/lang/Long;", "atomicMove", "", "source", "target", "createSymlink", "toString", "", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public class NioSystemFileSystem extends JvmSystemFileSystem {
    public NioSystemFileSystem() {
        super();
    }

    public void atomicMove(Path arg3, Path arg4) {
        Intrinsics.checkNotNullParameter(arg3, "source");
        Intrinsics.checkNotNullParameter(arg4, "target");
        try {
            Files.move(arg3.toNioPath(), arg4.toNioPath(), new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING});
            return;
        }
        catch(UnsupportedOperationException ) {
            throw new IOException("atomic move not supported");
        }
        catch(NoSuchFileException v2) {
            throw new FileNotFoundException(v2.getMessage());
        }
    }

    public void createSymlink(Path arg1, Path arg2) {
        Intrinsics.checkNotNullParameter(arg1, "source");
        Intrinsics.checkNotNullParameter(arg2, "target");
        Files.createSymbolicLink(arg1.toNioPath(), arg2.toNioPath(), new FileAttribute[0]);
    }

    protected final FileMetadata metadataOrNull(java.nio.file.Path arg20) {
        BasicFileAttributes v3;
        NioSystemFileSystem v0 = this;
        java.nio.file.Path v1 = arg20;
        Intrinsics.checkNotNullParameter(v1, "nioPath");
        Object v2 = null;
        try {
            v3 = Files.readAttributes(v1, BasicFileAttributes.class, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
        }
        catch(FileSystemException ) {
            return ((FileMetadata)v2);
        }

        v1 = v3.isSymbolicLink() ? Files.readSymbolicLink(v1) : ((java.nio.file.Path)v2);
        boolean v9 = v3.isRegularFile();
        boolean v10 = v3.isDirectory();
        Path v11 = v1 != null ? Companion.get$default(Path.Companion, v1, false, 1, v2) : ((Path)v2);
        Long v12 = Long.valueOf(v3.size());
        FileTime v1_1 = v3.creationTime();
        Long v13 = v1_1 != null ? v0.zeroToNull(v1_1) : ((Long)v2);
        v1_1 = v3.lastModifiedTime();
        Long v14 = v1_1 != null ? v0.zeroToNull(v1_1) : ((Long)v2);
        v1_1 = v3.lastAccessTime();
        if(v1_1 != null) {
            Long v2_1 = v0.zeroToNull(v1_1);
        }

        return new FileMetadata(v9, v10, v11, v12, v13, v14, ((Long)v2), null, 0x80, null);
    }

    public FileMetadata metadataOrNull(Path arg2) {
        Intrinsics.checkNotNullParameter(arg2, "path");
        return this.metadataOrNull(arg2.toNioPath());
    }

    public String toString() {
        return "NioSystemFileSystem";
    }

    private final Long zeroToNull(FileTime arg5) {
        Long v4 = Long.valueOf(arg5.toMillis());
        if(v4.longValue() != 0) {
            return v4;
        }

        return null;
    }
}

