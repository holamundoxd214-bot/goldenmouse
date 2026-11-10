package androidx.core.provider;

import android.util.Base64;
import androidx.activity.OnBackPressedCallback$$ExternalSyntheticThrowIAE2;
import androidx.core.util.Preconditions;
import java.util.List;

public final class FontRequest {
    private final List mCertificates;
    private final int mCertificatesArray;
    private final String mIdentifier;
    private final String mProviderAuthority;
    private final String mProviderPackage;
    private final String mQuery;
    private final String mSystemFont;
    private final String mVariationSettings;

    public FontRequest(String arg7, String arg8, String arg9, List arg10, String arg11, String arg12) {
        super();
        this.mProviderAuthority = Preconditions.checkNotNull(arg7);
        this.mProviderPackage = Preconditions.checkNotNull(arg8);
        this.mQuery = Preconditions.checkNotNull(arg9);
        this.mCertificates = Preconditions.checkNotNull(arg10);
        this.mCertificatesArray = 0;
        this.mSystemFont = arg11;
        this.mVariationSettings = arg12;
        this.mIdentifier = this.createIdentifier(arg7, arg8, arg9, arg11, arg12);
    }

    public FontRequest(String arg8, String arg9, String arg10, int arg11) {
        this(arg8, arg9, arg10, arg11, null, null);
    }

    private FontRequest(String arg2, String arg3, String arg4, int arg5, String arg6, String arg7) {
        super();
        this.mProviderAuthority = Preconditions.checkNotNull(arg2);
        this.mProviderPackage = Preconditions.checkNotNull(arg3);
        this.mQuery = Preconditions.checkNotNull(arg4);
        this.mCertificates = null;
        boolean v0 = arg5 != 0 ? true : false;
        Preconditions.checkArgument(v0);
        this.mCertificatesArray = arg5;
        this.mSystemFont = arg6;
        this.mVariationSettings = arg7;
        this.mIdentifier = this.createIdentifier(arg2, arg3, arg4, null, arg7);
    }

    public FontRequest(String arg8, String arg9, String arg10, int arg11, String arg12) {
        this(arg8, arg9, arg10, arg11, null, arg12);
    }

    public FontRequest(String arg8, String arg9, String arg10, List arg11) {
        this(arg8, arg9, arg10, arg11, null, null);
    }

    public FontRequest(String arg8, String arg9, String arg10, List arg11, String arg12) {
        this(arg8, arg9, arg10, arg11, null, arg12);
    }

    private String createIdentifier(String arg2, String arg3, String arg4, String arg5, String arg6) {
        StringBuilder v1 = new StringBuilder();
        v1.append(arg2).append("-").append(arg3).append("-").append(arg4).append("-").append(arg5);
        if(arg6 != null && !OnBackPressedCallback$$ExternalSyntheticThrowIAE2.m(arg6)) {
            v1.append("-VF");
        }

        return v1.toString();
    }

    public List getCertificates() {
        return this.mCertificates;
    }

    public int getCertificatesArrayResId() {
        return this.mCertificatesArray;
    }

    String getId() {
        return this.mIdentifier;
    }

    @Deprecated public String getIdentifier() {
        return this.mIdentifier;
    }

    public String getProviderAuthority() {
        return this.mProviderAuthority;
    }

    public String getProviderPackage() {
        return this.mProviderPackage;
    }

    public String getQuery() {
        return this.mQuery;
    }

    public String getSystemFont() {
        return this.mSystemFont;
    }

    public String getVariationSettings() {
        return this.mVariationSettings;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder();
        v0.append("FontRequest {mProviderAuthority: " + this.mProviderAuthority + ", mProviderPackage: " + this.mProviderPackage + ", mQuery: " + this.mQuery + ", mSystemFont: " + this.mSystemFont + ", mVariationSettings: " + this.mVariationSettings + ", mCertificates:");
        int v2;
        for(v2 = 0; v2 < this.mCertificates.size(); ++v2) {
            v0.append(" [");
            Object v3 = this.mCertificates.get(v2);
            int v4;
            for(v4 = 0; v4 < ((List)v3).size(); ++v4) {
                v0.append(" \"");
                v0.append(Base64.encodeToString(((List)v3).get(v4), 0));
                v0.append("\"");
            }

            v0.append(" ]");
        }

        v0.append("}");
        v0.append("mCertificatesArray: " + this.mCertificatesArray);
        return v0.toString();
    }
}

