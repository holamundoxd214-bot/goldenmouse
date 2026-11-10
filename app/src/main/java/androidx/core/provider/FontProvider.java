package androidx.core.provider;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri$Builder;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import androidx.activity.OnBackPressedCallback$$ExternalSyntheticThrowIAE2;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.tracing.Trace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

class FontProvider {
    interface ContentQueryWrapper {
        void close();

        static ContentQueryWrapper make(Context arg1, Uri arg2) {
            return new ContentQueryWrapperApi24Impl(arg1, arg2);
        }

        Cursor query(Uri arg1, String[] arg2, String arg3, String[] arg4, String arg5, CancellationSignal arg6);
    }

    class ContentQueryWrapperApi16Impl implements ContentQueryWrapper {
        private final ContentProviderClient mClient;

        ContentQueryWrapperApi16Impl(Context arg1, Uri arg2) {
            super();
            this.mClient = arg1.getContentResolver().acquireUnstableContentProviderClient(arg2);
        }

        public void close() {
            ContentProviderClient v0 = this.mClient;
            if(v0 != null) {
                v0.release();
            }
        }

        public Cursor query(Uri arg3, String[] arg4, String arg5, String[] arg6, String arg7, CancellationSignal arg8) {
            ContentProviderClient v2 = this.mClient;
            Cursor v1 = null;
            if(v2 == null) {
                return v1;
            }

            try {
                return v2.query(arg3, arg4, arg5, arg6, arg7, arg8);
            }
            catch(RemoteException v0) {
                Log.w("FontsProvider", "Unable to query the content provider", v0);
                return v1;
            }
        }
    }

    class ContentQueryWrapperApi24Impl implements ContentQueryWrapper {
        private final ContentProviderClient mClient;

        ContentQueryWrapperApi24Impl(Context arg1, Uri arg2) {
            super();
            this.mClient = arg1.getContentResolver().acquireUnstableContentProviderClient(arg2);
        }

        public void close() {
            ContentProviderClient v0 = this.mClient;
            if(v0 != null) {
                v0.close();
            }
        }

        public Cursor query(Uri arg3, String[] arg4, String arg5, String[] arg6, String arg7, CancellationSignal arg8) {
            ContentProviderClient v2 = this.mClient;
            Cursor v1 = null;
            if(v2 == null) {
                return v1;
            }

            try {
                return v2.query(arg3, arg4, arg5, arg6, arg7, arg8);
            }
            catch(RemoteException v0) {
                Log.w("FontsProvider", "Unable to query the content provider", v0);
                return v1;
            }
        }
    }

    class ProviderCacheKey {
        String mAuthority;
        List mCertificates;
        String mPackageName;

        ProviderCacheKey(String arg1, String arg2, List arg3) {
            super();
            this.mAuthority = arg1;
            this.mPackageName = arg2;
            this.mCertificates = arg3;
        }

        public boolean equals(Object arg5) {
            if(this == (((ProviderCacheKey)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof ProviderCacheKey)) {
                return 0;
            }

            if((Objects.equals(this.mAuthority, ((ProviderCacheKey)arg5).mAuthority)) && (Objects.equals(this.mPackageName, ((ProviderCacheKey)arg5).mPackageName)) && (Objects.equals(this.mCertificates, ((ProviderCacheKey)arg5).mCertificates))) {
                return 1;
            }

            return 0;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.mAuthority, this.mPackageName, this.mCertificates});
        }
    }

    private static final String VARIABLE_FONT_QUERY_PARAM = "VF";
    private static final Comparator sByteArrayComparator;
    private static final LruCache sProviderCache;

    static {
        FontProvider.sProviderCache = new LruCache(2);
        FontProvider.sByteArrayComparator = new FontProvider$$ExternalSyntheticLambda0();
    }

    private FontProvider() {
        super();
    }

    static void clearProviderCache() {
        FontProvider.sProviderCache.evictAll();
    }

    private static List convertToByteArrayList(Signature[] arg4) {
        ArrayList v0 = new ArrayList();
        int v1 = arg4.length;
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            ((List)v0).add(arg4[v2].toByteArray());
        }

        return ((List)v0);
    }

    private static boolean equalsByteArrayList(List arg4, List arg5) {
        if(arg4.size() != arg5.size()) {
            return 0;
        }

        int v0;
        for(v0 = 0; v0 < arg4.size(); ++v0) {
            if(!Arrays.equals(arg4.get(v0), arg5.get(v0))) {
                return 0;
            }
        }

        return 1;
    }

    private static List getCertificates(FontRequest arg1, Resources arg2) {
        if(arg1.getCertificates() != null) {
            return arg1.getCertificates();
        }

        return FontResourcesParserCompat.readCerts(arg2, arg1.getCertificatesArrayResId());
    }

    static FontFamilyResult getFontFamilyResult(Context arg7, List arg8, CancellationSignal arg9) throws PackageManager$NameNotFoundException {
        FontFamilyResult v7_1;
        ProviderInfo v4_1;
        Object v3;
        int v2;
        ArrayList v0;
        Trace.beginSection("FontProvider.getFontFamilyResult");
        try {
            v0 = new ArrayList();
            v2 = 0;
            while(true) {
            label_6:
                if(v2 >= arg8.size()) {
                    goto label_39;
                }

                v3 = arg8.get(v2);
                if(Build$VERSION.SDK_INT >= 0x1F) {
                    String v4 = ((FontRequest)v3).getSystemFont();
                    Typeface v5 = TypefaceCompat.getSystemFontFamily(v4);
                    if(v5 == null) {
                        goto label_25;
                    }
                    else if(TypefaceCompat.guessPrimaryFont(v5) != null) {
                        v0.add(new FontInfo[]{new FontInfo(v4, ((FontRequest)v3).getVariationSettings())});
                    }
                    else {
                        goto label_25;
                    }
                }
                else {
                label_25:
                    v4_1 = FontProvider.getProvider(arg7.getPackageManager(), ((FontRequest)v3), arg7.getResources());
                    if(v4_1 == null) {
                        v7_1 = FontFamilyResult.create(1, null);
                        break;
                    }
                    else {
                        goto label_34;
                    }
                }

                goto label_37;
            }
        }
        catch(Throwable v7) {
            goto label_43;
        }

        Trace.endSection();
        return v7_1;
        try {
        label_34:
            v0.add(FontProvider.query(arg7, ((FontRequest)v3), v4_1.authority, arg9));
        label_37:
            ++v2;
            goto label_6;
        label_39:
            v7_1 = FontFamilyResult.create(0, ((List)v0));
        }
        catch(Throwable v7) {
            goto label_43;
        }

        Trace.endSection();
        return v7_1;
    label_43:
        Trace.endSection();
        throw v7;
    }

    static ProviderInfo getProvider(PackageManager arg7, FontRequest arg8, Resources arg9) throws PackageManager$NameNotFoundException {
        ProviderInfo v5;
        int v4;
        String v3_1;
        Object v3;
        ProviderCacheKey v2;
        List v9;
        String v0 = "Found content provider ";
        String v1 = "No package found for authority: ";
        Trace.beginSection("FontProvider.getProvider");
        try {
            v9 = FontProvider.getCertificates(arg8, arg9);
            v2 = new ProviderCacheKey(arg8.getProviderAuthority(), arg8.getProviderPackage(), v9);
            v3 = FontProvider.sProviderCache.get(v2);
            if(v3 == null) {
                goto label_14;
            }
        }
        catch(Throwable v7) {
            goto label_66;
        }

        Trace.endSection();
        return ((ProviderInfo)v3);
        try {
        label_14:
            v3_1 = arg8.getProviderAuthority();
            v4 = 0;
            v5 = arg7.resolveContentProvider(v3_1, 0);
            if(v5 == null) {
                goto label_58;
            }

            if(!v5.packageName.equals(arg8.getProviderPackage())) {
                goto label_47;
            }

            List v7_1 = FontProvider.convertToByteArrayList(arg7.getPackageInfo(v5.packageName, 0x40).signatures);
            Collections.sort(v7_1, FontProvider.sByteArrayComparator);
            while(true) {
            label_29:
                if(v4 >= v9.size()) {
                    goto label_44;
                }

                ArrayList v8 = new ArrayList(v9.get(v4));
                Collections.sort(((List)v8), FontProvider.sByteArrayComparator);
                if(!FontProvider.equalsByteArrayList(v7_1, ((List)v8))) {
                    goto label_42;
                }

                FontProvider.sProviderCache.put(v2, v5);
                break;
            }
        }
        catch(Throwable v7) {
            goto label_66;
        }

        Trace.endSection();
        return v5;
    label_42:
        ++v4;
        goto label_29;
    label_44:
        Trace.endSection();
        return null;
        try {
        label_47:
            throw new PackageManager$NameNotFoundException(v0 + v3_1 + ", but package was not " + arg8.getProviderPackage());
        label_58:
            throw new PackageManager$NameNotFoundException(v1 + v3_1);
        }
        catch(Throwable v7) {
        label_66:
            Trace.endSection();
            throw v7;
        }
    }

    protected static String[] getSelectionArgs(FontRequest arg3) {
        String v0 = arg3.getVariationSettings();
        if(v0 != null && !OnBackPressedCallback$$ExternalSyntheticThrowIAE2.m(v0)) {
            return new String[]{arg3.getQuery(), "VF"};
        }

        return new String[]{arg3.getQuery()};
    }

    static int lambda$static$0(byte[] arg4, byte[] arg5) {
        if(arg4.length != arg5.length) {
            return arg4.length - arg5.length;
        }

        int v1;
        for(v1 = 0; v1 < arg4.length; ++v1) {
            int v2 = arg4[v1];
            int v3 = arg5[v1];
            if(v2 != v3) {
                return v2 - v3;
            }
        }

        return 0;
    }

    static FontInfo[] query(Context arg20, FontRequest arg21, String arg22, CancellationSignal arg23) {
        Uri v7_2;
        ArrayList v20;
        Cursor v9;
        Cursor v12_1;
        String[] v12;
        int v7_1;
        ContentQueryWrapper v10;
        Uri v0_2;
        Uri v11;
        ArrayList v8;
        String v0 = arg22;
        String v1 = "result_code";
        String v2 = "font_italic";
        String v3 = "font_weight";
        String v4 = "font_ttc_index";
        String v5 = "file_id";
        String v6 = "_id";
        String v7 = "content";
        Trace.beginSection("FontProvider.query");
        try {
            v8 = new ArrayList();
            v11 = new Uri$Builder().scheme(v7).authority(v0).build();
            v0_2 = new Uri$Builder().scheme(v7).authority(v0).appendPath("file").build();
            v10 = ContentQueryWrapper.make(arg20, v11);
            v7_1 = 7;
        }
        catch(Throwable v0_1) {
            goto label_129;
        }

        try {
            v12 = new String[v7_1];
            v7_1 = 0;
            v12[0] = v6;
            v12[1] = v5;
            v12[2] = v4;
            v12[3] = "font_variation_settings";
            v12[4] = v3;
            v12[5] = v2;
            v12[6] = v1;
            Trace.beginSection("ContentQueryWrapper.query");
        }
        catch(Throwable v0_1) {
            goto label_123;
        }

        try {
            v12_1 = v10.query(v11, v12, "query = ?", FontProvider.getSelectionArgs(arg21), null, arg23);
        }
        catch(Throwable v0_1) {
            try {
                Trace.endSection();
                throw v0_1;
            }
            catch(Throwable v0_1) {
            label_123:
                v9 = null;
                goto label_124;
            }
        }

        try {
            Trace.endSection();
            if(v12_1 != null && v12_1.getCount() > 0) {
                int v1_1 = v12_1.getColumnIndex(v1);
                v8 = new ArrayList();
                int v6_1 = v12_1.getColumnIndex(v6);
                int v5_1 = v12_1.getColumnIndex(v5);
                int v4_1 = v12_1.getColumnIndex(v4);
                int v3_1 = v12_1.getColumnIndex(v3);
                int v2_1 = v12_1.getColumnIndex(v2);
                while(true) {
                    if(v12_1.moveToNext()) {
                        int v13 = -1;
                        int v19 = v1_1 != v13 ? v12_1.getInt(v1_1) : v7_1;
                        int v15 = v4_1 != v13 ? v12_1.getInt(v4_1) : v7_1;
                        if(v5_1 == v13) {
                            v20 = v8;
                            v7_2 = ContentUris.withAppendedId(v11, v12_1.getLong(v6_1));
                        }
                        else {
                            v20 = v8;
                            v7_2 = ContentUris.withAppendedId(v0_2, v12_1.getLong(v5_1));
                        }

                        Uri v14 = v7_2;
                        v7_1 = v3_1 != v13 ? v12_1.getInt(v3_1) : 400;
                        int v16 = v7_1;
                        boolean v17 = v2_1 == v13 || v12_1.getInt(v2_1) != 1 ? false : true;
                        v20.add(new FontInfo(v14, v15, v16, v17, arg21.getVariationSettings(), v19));
                        v8 = v20;
                        v7_1 = 0;
                        continue;
                    }

                    goto label_108;
                }
            }

            goto label_108;
        }
        catch(Throwable v0_1) {
            v9 = v12_1;
        }

    label_124:
        if(v9 != null) {
            try {
                v9.close();
            label_126:
                v10.close();
                throw v0_1;
            }
            catch(Throwable v0_1) {
                goto label_129;
            }
        }

        goto label_126;
    label_108:
        if(v12_1 != null) {
            try {
                v12_1.close();
            label_110:
                v10.close();
                Object[] v0_3 = v8.toArray(new FontInfo[0]);
                Trace.endSection();
                return ((FontInfo[])v0_3);
            }
            catch(Throwable v0_1) {
            label_129:
                Trace.endSection();
                throw v0_1;
            }
        }

        goto label_110;
    }
}

