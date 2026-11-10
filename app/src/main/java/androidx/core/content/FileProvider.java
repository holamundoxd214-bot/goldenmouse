package androidx.core.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri$Builder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.core.util.ObjectsCompat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map$Entry;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider extends ContentProvider {
    interface PathStrategy {
        File getFileForUri(Uri arg1);

        Uri getUriForFile(File arg1);
    }

    class SimplePathStrategy implements PathStrategy {
        private final String mAuthority;
        private final HashMap mRoots;

        SimplePathStrategy(String arg2) {
            super();
            this.mRoots = new HashMap();
            this.mAuthority = arg2;
        }

        void addRoot(String arg3, File arg4) {
            if(!TextUtils.isEmpty(((CharSequence)arg3))) {
                try {
                    arg4 = arg4.getCanonicalFile();
                }
                catch(IOException v2) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + arg4, ((Throwable)v2));
                }

                this.mRoots.put(arg3, arg4);
                return;
            }

            throw new IllegalArgumentException("Name must not be empty");
        }

        private boolean belongsToRoot(String arg1, String arg2) {
            return FileProvider.-$$Nest$smremoveTrailingSlash(arg1).startsWith(FileProvider.-$$Nest$smremoveTrailingSlash(arg2) + '/');
        }

        public File getFileForUri(Uri arg5) {
            String v0 = arg5.getEncodedPath();
            int v1 = v0.indexOf(0x2F, 1);
            if(v1 != -1) {
                String v3 = Uri.decode(v0.substring(1, v1));
                v0 = Uri.decode(v0.substring(v1 + 1));
                Object v1_1 = this.mRoots.get(v3);
                if(v1_1 != null) {
                    File v5 = new File(((File)v1_1), v0);
                    try {
                        v5 = v5.getCanonicalFile();
                    }
                    catch(IOException ) {
                        throw new IllegalArgumentException("Failed to resolve canonical path for " + v5);
                    }

                    if(this.belongsToRoot(v5.getPath(), ((File)v1_1).getPath())) {
                        return v5;
                    }

                    throw new SecurityException("Resolved path jumped beyond configured root");
                }

                throw new IllegalArgumentException("Unable to find configured root for " + arg5);
            }

            throw new IllegalArgumentException("Unable to find path from root: " + arg5);
        }

        public Uri getUriForFile(File arg6) {
            String v6;
            try {
                v6 = arg6.getCanonicalPath();
            }
            catch(IOException ) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + v6);
            }

            Iterator v0 = this.mRoots.entrySet().iterator();
            Object v1;
            for(v1 = null; v0.hasNext(); v1 = v2) {
                Object v2 = v0.next();
                String v3 = ((Map$Entry)v2).getValue().getPath();
                if(!this.belongsToRoot(v6, v3)) {
                    continue;
                }

                if(v1 != null && v3.length() <= ((Map$Entry)v1).getValue().getPath().length()) {
                    continue;
                }
            }

            if(v1 != null) {
                String v0_1 = ((Map$Entry)v1).getValue().getPath();
                String v2_1 = "/";
                v6 = v0_1.endsWith(v2_1) ? v6.substring(v0_1.length()) : v6.substring(v0_1.length() + 1);
                return new Uri$Builder().scheme("content").authority(this.mAuthority).encodedPath(Uri.encode(((Map$Entry)v1).getKey()) + '/' + Uri.encode(v6, v2_1)).build();
            }

            throw new IllegalArgumentException("Failed to find configured root that contains " + v6);
        }
    }

    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String[] COLUMNS = null;
    private static final File DEVICE_ROOT = null;
    private static final String DISPLAYNAME_FIELD = "displayName";
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private String mAuthority;
    private PathStrategy mLocalPathStrategy;
    private final Object mLock;
    private final int mResourceId;
    private static final HashMap sCache;

    static String -$$Nest$smremoveTrailingSlash(String arg0) {
        return FileProvider.removeTrailingSlash(arg0);
    }

    static {
        FileProvider.COLUMNS = new String[]{"_display_name", "_size"};
        FileProvider.DEVICE_ROOT = new File("/");
        FileProvider.sCache = new HashMap();
    }

    public FileProvider() {
        this(0);
    }

    protected FileProvider(int arg2) {
        super();
        this.mLock = new Object();
        this.mResourceId = arg2;
    }

    public void attachInfo(Context arg1, ProviderInfo arg2) {
        super.attachInfo(arg1, arg2);
        if(!arg2.exported) {
            if(arg2.grantUriPermissions) {
                if(arg2.authority != null && !arg2.authority.trim().isEmpty()) {
                    String v1 = arg2.authority.split(";")[0];
                    Object v2 = this.mLock;
                    __monitor_enter(v2);
                    try {
                        this.mAuthority = v1;
                        __monitor_exit(v2);
                    }
                    catch(Throwable v0) {
                        try {
                        label_29:
                            __monitor_exit(v2);
                        }
                        catch(Throwable v0) {
                            goto label_29;
                        }

                        throw v0;
                    }

                    HashMap v0_1 = FileProvider.sCache;
                    __monitor_enter(v0_1);
                    try {
                        v0_1.remove(v1);
                        __monitor_exit(v0_1);
                        return;
                    label_26:
                        __monitor_exit(v0_1);
                    }
                    catch(Throwable v1_1) {
                        goto label_26;
                    }

                    throw v1_1;
                }

                throw new SecurityException("Provider must have a non-empty authority");
            }

            throw new SecurityException("Provider must grant uri permissions");
        }

        throw new SecurityException("Provider must not be exported");
    }

    private static File buildPath(File arg4, String[] arg5) {
        int v0 = arg5.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            String v2 = arg5[v1];
            if(v2 != null) {
                arg4 = new File(arg4, v2);
            }
        }

        return arg4;
    }

    private static Object[] copyOf(Object[] arg2, int arg3) {
        Object[] v0 = new Object[arg3];
        System.arraycopy(arg2, 0, v0, 0, arg3);
        return v0;
    }

    private static String[] copyOf(String[] arg2, int arg3) {
        String[] v0 = new String[arg3];
        System.arraycopy(arg2, 0, v0, 0, arg3);
        return v0;
    }

    public int delete(Uri arg1, String arg2, String[] arg3) {
        return this.getLocalPathStrategy().getFileForUri(arg1).delete();
    }

    static XmlResourceParser getFileProviderPathsMetaData(Context arg2, String arg3, ProviderInfo arg4, int arg5) {
        if(arg4 != null) {
            String v0 = "android.support.FILE_PROVIDER_PATHS";
            if(arg4.metaData == null && arg5 != 0) {
                arg4.metaData = new Bundle(1);
                arg4.metaData.putInt(v0, arg5);
            }

            XmlResourceParser v2 = arg4.loadXmlMetaData(arg2.getPackageManager(), v0);
            if(v2 != null) {
                return v2;
            }

            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }

        throw new IllegalArgumentException("Couldn\'t find meta-data for provider with authority " + arg3);
    }

    private PathStrategy getLocalPathStrategy() {
        Object v0 = this.mLock;
        __monitor_enter(v0);
        try {
            ObjectsCompat.requireNonNull(this.mAuthority, "mAuthority is null. Did you override attachInfo and did not call super.attachInfo()?");
            PathStrategy v1 = this.mLocalPathStrategy;
            if(v1 == null) {
                v1 = FileProvider.getPathStrategy(this.getContext(), this.mAuthority, this.mResourceId);
                this.mLocalPathStrategy = v1;
            }

            __monitor_exit(v0);
            return v1;
        label_15:
            __monitor_exit(v0);
        }
        catch(Throwable v4) {
            goto label_15;
        }

        throw v4;
    }

    private static PathStrategy getPathStrategy(Context arg2, String arg3, int arg4) {
        PathStrategy v1_1;
        HashMap v0 = FileProvider.sCache;
        __monitor_enter(v0);
        try {
            Object v1 = v0.get(arg3);
            if(v1 == null) {
                try {
                    v1_1 = FileProvider.parsePathStrategy(arg2, arg3, arg4);
                }
                catch(XmlPullParserException v2_1) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", ((Throwable)v2_1));
                }
                catch(IOException v2_2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", ((Throwable)v2_2));
                }

                v0.put(arg3, v1_1);
            }

            __monitor_exit(v0);
            return ((PathStrategy)v1);
        label_20:
            __monitor_exit(v0);
        }
        catch(Throwable v2) {
            goto label_20;
        }

        throw v2;
    }

    public String getType(Uri arg2) {
        File v1 = this.getLocalPathStrategy().getFileForUri(arg2);
        int v2 = v1.getName().lastIndexOf(46);
        if(v2 >= 0) {
            String v1_1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(v1.getName().substring(v2 + 1));
            if(v1_1 != null) {
                return v1_1;
            }
        }

        return "application/octet-stream";
    }

    public String getTypeAnonymous(Uri arg1) {
        return "application/octet-stream";
    }

    public static Uri getUriForFile(Context arg1, String arg2, File arg3) {
        return FileProvider.getPathStrategy(arg1, arg2, 0).getUriForFile(arg3);
    }

    public static Uri getUriForFile(Context arg0, String arg1, File arg2, String arg3) {
        return FileProvider.getUriForFile(arg0, arg1, arg2).buildUpon().appendQueryParameter("displayName", arg3).build();
    }

    public Uri insert(Uri arg1, ContentValues arg2) {
        throw new UnsupportedOperationException("No external inserts");
    }

    private static int modeToMode(String arg3) {
        if("r".equals(arg3)) {
            return 0x10000000;
        }

        if(!"w".equals(arg3)) {
            if("wt".equals(arg3)) {
            }
            else if("wa".equals(arg3)) {
                return 0x2A000000;
            }
            else if("rw".equals(arg3)) {
                return 0x38000000;
            }
            else if("rwt".equals(arg3)) {
                return 0x3C000000;
            }
            else {
                throw new IllegalArgumentException("Invalid mode: " + arg3);
            }
        }

        return 0x2C000000;
    }

    public boolean onCreate() {
        return 1;
    }

    public ParcelFileDescriptor openFile(Uri arg1, String arg2) throws FileNotFoundException {
        return ParcelFileDescriptor.open(this.getLocalPathStrategy().getFileForUri(arg1), FileProvider.modeToMode(arg2));
    }

    private static PathStrategy parsePathStrategy(Context arg7, String arg8, int arg9) throws IOException, XmlPullParserException {
        File[] v9_1;
        File v3_1;
        SimplePathStrategy v0 = new SimplePathStrategy(arg8);
        XmlResourceParser v8 = FileProvider.getFileProviderPathsMetaData(arg7, arg8, arg7.getPackageManager().resolveContentProvider(arg8, 0x80), arg9);
        while(true) {
            arg9 = v8.next();
            if(arg9 == 1) {
                break;
            }

            if(arg9 != 2) {
                continue;
            }

            String v9 = v8.getName();
            String v3 = null;
            String v2 = v8.getAttributeValue(v3, "name");
            String v4 = v8.getAttributeValue(v3, "path");
            if("root-path".equals(v9)) {
                v3_1 = FileProvider.DEVICE_ROOT;
            }
            else if("files-path".equals(v9)) {
                v3_1 = arg7.getFilesDir();
            }
            else if("cache-path".equals(v9)) {
                v3_1 = arg7.getCacheDir();
            }
            else if("external-path".equals(v9)) {
                v3_1 = Environment.getExternalStorageDirectory();
            }
            else if("external-files-path".equals(v9)) {
                v9_1 = ContextCompat.getExternalFilesDirs(arg7, v3);
                if(v9_1.length > 0) {
                    v3_1 = v9_1[0];
                }
            }
            else if("external-cache-path".equals(v9)) {
                v9_1 = ContextCompat.getExternalCacheDirs(arg7);
                if(v9_1.length > 0) {
                    v3_1 = v9_1[0];
                }
            }
            else if("external-media-path".equals(v9)) {
                v9_1 = arg7.getExternalMediaDirs();
                if(v9_1.length > 0) {
                    v3_1 = v9_1[0];
                }
            }

            if(v3_1 == null) {
                continue;
            }

            v0.addRoot(v2, FileProvider.buildPath(v3_1, new String[]{v4}));
        }

        return ((PathStrategy)v0);
    }

    public Cursor query(Uri arg6, String[] arg7, String arg8, String[] arg9, String arg10) {
        int v2_1;
        File v5 = this.getLocalPathStrategy().getFileForUri(arg6);
        String v6 = arg6.getQueryParameter("displayName");
        if(arg7 == null) {
            arg7 = FileProvider.COLUMNS;
        }

        String[] v8 = new String[arg7.length];
        Object[] v9 = new Object[arg7.length];
        int v10 = arg7.length;
        int v0 = 0;
        int v1 = 0;
        while(v0 < v10) {
            String v2 = arg7[v0];
            String v3 = "_display_name";
            if(v3.equals(v2)) {
                v8[v1] = v3;
                v2_1 = v1 + 1;
                v3 = v6 == null ? v5.getName() : v6;
                v9[v1] = v3;
                goto label_34;
            }
            else {
                v3 = "_size";
                if(!v3.equals(v2)) {
                    goto label_35;
                }

                v8[v1] = v3;
                v2_1 = v1 + 1;
                v9[v1] = Long.valueOf(v5.length());
            label_34:
                v1 = v2_1;
            }

        label_35:
            ++v0;
        }

        String[] v5_1 = FileProvider.copyOf(v8, v1);
        Object[] v6_1 = FileProvider.copyOf(v9, v1);
        MatrixCursor v7 = new MatrixCursor(v5_1, 1);
        v7.addRow(v6_1);
        return ((Cursor)v7);
    }

    private static String removeTrailingSlash(String arg2) {
        if(arg2.length() > 0 && arg2.charAt(arg2.length() - 1) == 0x2F) {
            arg2 = arg2.substring(0, arg2.length() - 1);
        }

        return arg2;
    }

    public int update(Uri arg1, ContentValues arg2, String arg3, String[] arg4) {
        throw new UnsupportedOperationException("No external updates");
    }
}

