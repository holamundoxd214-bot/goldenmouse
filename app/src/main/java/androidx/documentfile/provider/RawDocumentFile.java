package androidx.documentfile.provider;

import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class RawDocumentFile extends DocumentFile {
    private File mFile;

    RawDocumentFile(DocumentFile arg1, File arg2) {
        super(arg1);
        this.mFile = arg2;
    }

    public boolean canRead() {
        return this.mFile.canRead();
    }

    public boolean canWrite() {
        return this.mFile.canWrite();
    }

    public DocumentFile createDirectory(String arg3) {
        File v0 = new File(this.mFile, arg3);
        if(!v0.isDirectory()) {
            if(v0.mkdir()) {
            }
            else {
                return null;
            }
        }

        return new RawDocumentFile(((DocumentFile)this), v0);
    }

    public DocumentFile createFile(String arg2, String arg3) {
        arg2 = MimeTypeMap.getSingleton().getExtensionFromMimeType(arg2);
        if(arg2 != null) {
            arg3 = arg3 + "." + arg2;
        }

        File v2 = new File(this.mFile, arg3);
        DocumentFile v3 = null;
        try {
            if(!v2.createNewFile()) {
                return v3;
            }

            return new RawDocumentFile(((DocumentFile)this), v2);
        }
        catch(IOException v1) {
            Log.w("DocumentFile", "Failed to createFile: " + v1);
            return v3;
        }

        return v3;
    }

    public boolean delete() {
        RawDocumentFile.deleteContents(this.mFile);
        return this.mFile.delete();
    }

    private static boolean deleteContents(File arg6) {
        File[] v6 = arg6.listFiles();
        int v0 = 1;
        if(v6 != null) {
            int v1 = v6.length;
            int v3;
            for(v3 = 0; v3 < v1; ++v3) {
                File v4 = v6[v3];
                if(v4.isDirectory()) {
                    v0 &= RawDocumentFile.deleteContents(v4);
                }

                if(!v4.delete()) {
                    Log.w("DocumentFile", "Failed to delete " + v4);
                    v0 = 0;
                }
            }
        }

        return ((boolean)v0);
    }

    public boolean exists() {
        return this.mFile.exists();
    }

    public String getName() {
        return this.mFile.getName();
    }

    public String getType() {
        if(this.mFile.isDirectory()) {
            return null;
        }

        return RawDocumentFile.getTypeForName(this.mFile.getName());
    }

    private static String getTypeForName(String arg1) {
        int v0 = arg1.lastIndexOf(46);
        if(v0 >= 0) {
            arg1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(arg1.substring(v0 + 1).toLowerCase());
            if(arg1 != null) {
                return arg1;
            }
        }

        return "application/octet-stream";
    }

    public Uri getUri() {
        return Uri.fromFile(this.mFile);
    }

    public boolean isDirectory() {
        return this.mFile.isDirectory();
    }

    public boolean isFile() {
        return this.mFile.isFile();
    }

    public boolean isVirtual() {
        return 0;
    }

    public long lastModified() {
        return this.mFile.lastModified();
    }

    public long length() {
        return this.mFile.length();
    }

    public DocumentFile[] listFiles() {
        ArrayList v0 = new ArrayList();
        File[] v1 = this.mFile.listFiles();
        if(v1 != null) {
            int v3 = v1.length;
            int v4;
            for(v4 = 0; v4 < v3; ++v4) {
                v0.add(new RawDocumentFile(((DocumentFile)this), v1[v4]));
            }
        }

        return v0.toArray(new DocumentFile[0]);
    }

    public boolean renameTo(String arg3) {
        File v0 = new File(this.mFile.getParentFile(), arg3);
        if(this.mFile.renameTo(v0)) {
            this.mFile = v0;
            return 1;
        }

        return 0;
    }
}

