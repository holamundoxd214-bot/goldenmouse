package androidx.core.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import java.io.FileNotFoundException;

public final class DocumentsContractCompat {
    public final class DocumentCompat {
        public static final int FLAG_VIRTUAL_DOCUMENT = 0x200;

        private DocumentCompat() {
            super();
        }
    }

    class DocumentsContractApi24Impl {
        private DocumentsContractApi24Impl() {
            super();
        }

        static boolean isTreeUri(Uri arg0) {
            return DocumentsContract.isTreeUri(arg0);
        }

        static boolean removeDocument(ContentResolver arg0, Uri arg1, Uri arg2) throws FileNotFoundException {
            return DocumentsContract.removeDocument(arg0, arg1, arg2);
        }
    }

    private static final String PATH_TREE = "tree";

    private DocumentsContractCompat() {
        super();
    }

    public static Uri buildChildDocumentsUri(String arg0, String arg1) {
        return DocumentsContract.buildChildDocumentsUri(arg0, arg1);
    }

    public static Uri buildChildDocumentsUriUsingTree(Uri arg0, String arg1) {
        return DocumentsContract.buildChildDocumentsUriUsingTree(arg0, arg1);
    }

    public static Uri buildDocumentUri(String arg0, String arg1) {
        return DocumentsContract.buildDocumentUri(arg0, arg1);
    }

    public static Uri buildDocumentUriUsingTree(Uri arg0, String arg1) {
        return DocumentsContract.buildDocumentUriUsingTree(arg0, arg1);
    }

    public static Uri buildTreeDocumentUri(String arg0, String arg1) {
        return DocumentsContract.buildTreeDocumentUri(arg0, arg1);
    }

    public static Uri createDocument(ContentResolver arg0, Uri arg1, String arg2, String arg3) throws FileNotFoundException {
        return DocumentsContract.createDocument(arg0, arg1, arg2, arg3);
    }

    public static String getDocumentId(Uri arg0) {
        return DocumentsContract.getDocumentId(arg0);
    }

    public static String getTreeDocumentId(Uri arg0) {
        return DocumentsContract.getTreeDocumentId(arg0);
    }

    public static boolean isDocumentUri(Context arg0, Uri arg1) {
        return DocumentsContract.isDocumentUri(arg0, arg1);
    }

    public static boolean isTreeUri(Uri arg0) {
        return DocumentsContractApi24Impl.isTreeUri(arg0);
    }

    public static boolean removeDocument(ContentResolver arg0, Uri arg1, Uri arg2) throws FileNotFoundException {
        return DocumentsContractApi24Impl.removeDocument(arg0, arg1, arg2);
    }

    public static Uri renameDocument(ContentResolver arg0, Uri arg1, String arg2) throws FileNotFoundException {
        return DocumentsContract.renameDocument(arg0, arg1, arg2);
    }
}

