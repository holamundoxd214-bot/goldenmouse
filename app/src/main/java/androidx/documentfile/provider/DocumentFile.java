package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import androidx.core.provider.DocumentsContractCompat;
import java.io.File;

public abstract class DocumentFile {
    static final String TAG = "DocumentFile";
    private final DocumentFile mParent;

    DocumentFile(DocumentFile arg1) {
        super();
        this.mParent = arg1;
    }

    public abstract boolean canRead();

    public abstract boolean canWrite();

    public abstract DocumentFile createDirectory(String arg1);

    public abstract DocumentFile createFile(String arg1, String arg2);

    public abstract boolean delete();

    public abstract boolean exists();

    public DocumentFile findFile(String arg5) {
        DocumentFile[] v4 = this.listFiles();
        int v0 = v4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            DocumentFile v2 = v4[v1];
            if(arg5.equals(v2.getName())) {
                return v2;
            }
        }

        return null;
    }

    public static DocumentFile fromFile(File arg2) {
        return new RawDocumentFile(null, arg2);
    }

    public static DocumentFile fromSingleUri(Context arg2, Uri arg3) {
        return new SingleDocumentFile(null, arg2, arg3);
    }

    public static DocumentFile fromTreeUri(Context arg2, Uri arg3) {
        String v0 = DocumentsContractCompat.getTreeDocumentId(arg3);
        if(DocumentsContractCompat.isDocumentUri(arg2, arg3)) {
            v0 = DocumentsContractCompat.getDocumentId(arg3);
        }

        if(v0 != null) {
            Uri v0_1 = DocumentsContractCompat.buildDocumentUriUsingTree(arg3, v0);
            if(v0_1 != null) {
                return new TreeDocumentFile(null, arg2, v0_1);
            }

            throw new NullPointerException("Failed to build documentUri from a tree: " + arg3);
        }

        throw new IllegalArgumentException("Could not get document ID from Uri: " + arg3);
    }

    public abstract String getName();

    public DocumentFile getParentFile() {
        return this.mParent;
    }

    public abstract String getType();

    public abstract Uri getUri();

    public abstract boolean isDirectory();

    public static boolean isDocumentUri(Context arg0, Uri arg1) {
        return DocumentsContractCompat.isDocumentUri(arg0, arg1);
    }

    public abstract boolean isFile();

    public abstract boolean isVirtual();

    public abstract long lastModified();

    public abstract long length();

    public abstract DocumentFile[] listFiles();

    public abstract boolean renameTo(String arg1);
}

