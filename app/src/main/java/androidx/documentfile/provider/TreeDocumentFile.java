package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import androidx.activity.OnBackPressedCallback$$ExternalSyntheticThrowIAE2;
import java.util.ArrayList;

class TreeDocumentFile extends DocumentFile {
    private Context mContext;
    private Uri mUri;

    TreeDocumentFile(DocumentFile arg1, Context arg2, Uri arg3) {
        super(arg1);
        this.mContext = arg2;
        this.mUri = arg3;
    }

    public boolean canRead() {
        return DocumentsContractApi19.canRead(this.mContext, this.mUri);
    }

    public boolean canWrite() {
        return DocumentsContractApi19.canWrite(this.mContext, this.mUri);
    }

    private static void closeQuietly(AutoCloseable arg0) {
        if(arg0 != null) {
            try {
                OnBackPressedCallback$$ExternalSyntheticThrowIAE2.m(arg0);
                return;
            }
            catch(Exception ) {
                return;
            }
            catch(RuntimeException v0) {
                throw v0;
            }
        }
    }

    public DocumentFile createDirectory(String arg4) {
        Uri v4 = TreeDocumentFile.createFile(this.mContext, this.mUri, "vnd.android.document/directory", arg4);
        if(v4 != null) {
            return new TreeDocumentFile(((DocumentFile)this), this.mContext, v4);
        }

        return null;
    }

    private static Uri createFile(Context arg0, Uri arg1, String arg2, String arg3) {
        try {
            return DocumentsContract.createDocument(arg0.getContentResolver(), arg1, arg2, arg3);
        }
        catch(Exception ) {
            return null;
        }
    }

    public DocumentFile createFile(String arg3, String arg4) {
        Uri v3 = TreeDocumentFile.createFile(this.mContext, this.mUri, arg3, arg4);
        if(v3 != null) {
            return new TreeDocumentFile(((DocumentFile)this), this.mContext, v3);
        }

        return null;
    }

    public boolean delete() {
        try {
            return DocumentsContract.deleteDocument(this.mContext.getContentResolver(), this.mUri);
        }
        catch(Exception ) {
            return 0;
        }
    }

    public boolean exists() {
        return DocumentsContractApi19.exists(this.mContext, this.mUri);
    }

    public String getName() {
        return DocumentsContractApi19.getName(this.mContext, this.mUri);
    }

    public String getType() {
        return DocumentsContractApi19.getType(this.mContext, this.mUri);
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isDirectory() {
        return DocumentsContractApi19.isDirectory(this.mContext, this.mUri);
    }

    public boolean isFile() {
        return DocumentsContractApi19.isFile(this.mContext, this.mUri);
    }

    public boolean isVirtual() {
        return DocumentsContractApi19.isVirtual(this.mContext, this.mUri);
    }

    public long lastModified() {
        return DocumentsContractApi19.lastModified(this.mContext, this.mUri);
    }

    public long length() {
        return DocumentsContractApi19.length(this.mContext, this.mUri);
    }

    public DocumentFile[] listFiles() {
        Cursor v9;
        ContentResolver v1 = this.mContext.getContentResolver();
        Uri v2 = DocumentsContract.buildChildDocumentsUriUsingTree(this.mUri, DocumentsContract.getDocumentId(this.mUri));
        ArrayList v7 = new ArrayList();
        int v8 = 0;
        try {
            v9 = v1.query(v2, new String[]{"document_id"}, null, null, null);
            while(v9.moveToNext()) {
                v7.add(DocumentsContract.buildDocumentUriUsingTree(this.mUri, v9.getString(0)));
            }
        }
        catch(Throwable v0) {
        }
        catch(Exception v0_1) {
            try {
                Log.w("DocumentFile", "Failed query: " + v0_1);
            }
            catch(Throwable v0) {
                Throwable v10 = v0;
                TreeDocumentFile.closeQuietly(((AutoCloseable)v9));
                throw v10;
            }
        }

        TreeDocumentFile.closeQuietly(((AutoCloseable)v9));
        Object[] v0_2 = v7.toArray(new Uri[0]);
        DocumentFile[] v1_1 = new DocumentFile[v0_2.length];
        while(v8 < v0_2.length) {
            v1_1[v8] = new TreeDocumentFile(((DocumentFile)this), this.mContext, v0_2[v8]);
            ++v8;
        }

        return v1_1;
    }

    public boolean renameTo(String arg4) {
        try {
            Uri v4 = DocumentsContract.renameDocument(this.mContext.getContentResolver(), this.mUri, arg4);
            if(v4 == null) {
                return 0;
            }

            this.mUri = v4;
            return 1;
        }
        catch(Exception ) {
            return 0;
        }
    }
}

