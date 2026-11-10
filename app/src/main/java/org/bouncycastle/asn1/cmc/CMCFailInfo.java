package org.bouncycastle.asn1.cmc;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;

public class CMCFailInfo extends ASN1Object {
    public static final CMCFailInfo authDataFail;
    public static final CMCFailInfo badAlg;
    public static final CMCFailInfo badCertId;
    public static final CMCFailInfo badIdentity;
    public static final CMCFailInfo badMessageCheck;
    public static final CMCFailInfo badRequest;
    public static final CMCFailInfo badTime;
    public static final CMCFailInfo internalCAError;
    public static final CMCFailInfo mustArchiveKeys;
    public static final CMCFailInfo noKeyReuse;
    public static final CMCFailInfo popFailed;
    public static final CMCFailInfo popRequired;
    private static Map range;
    public static final CMCFailInfo tryLater;
    public static final CMCFailInfo unsupportedExt;
    private final ASN1Integer value;

    static {
        CMCFailInfo v0 = new CMCFailInfo(new ASN1Integer(0));
        CMCFailInfo.badAlg = v0;
        CMCFailInfo v1 = new CMCFailInfo(new ASN1Integer(1));
        CMCFailInfo.badMessageCheck = v1;
        CMCFailInfo v2 = new CMCFailInfo(new ASN1Integer(2));
        CMCFailInfo.badRequest = v2;
        CMCFailInfo v3 = new CMCFailInfo(new ASN1Integer(3));
        CMCFailInfo.badTime = v3;
        CMCFailInfo v4 = new CMCFailInfo(new ASN1Integer(4));
        CMCFailInfo.badCertId = v4;
        CMCFailInfo v5 = new CMCFailInfo(new ASN1Integer(5));
        CMCFailInfo.unsupportedExt = v5;
        CMCFailInfo v6 = new CMCFailInfo(new ASN1Integer(6));
        CMCFailInfo.mustArchiveKeys = v6;
        CMCFailInfo v7 = new CMCFailInfo(new ASN1Integer(7));
        CMCFailInfo.badIdentity = v7;
        CMCFailInfo v8 = new CMCFailInfo(new ASN1Integer(8));
        CMCFailInfo.popRequired = v8;
        CMCFailInfo v9 = new CMCFailInfo(new ASN1Integer(9));
        CMCFailInfo.popFailed = v9;
        CMCFailInfo v10 = new CMCFailInfo(new ASN1Integer(10));
        CMCFailInfo.noKeyReuse = v10;
        CMCFailInfo v11 = new CMCFailInfo(new ASN1Integer(11));
        CMCFailInfo.internalCAError = v11;
        CMCFailInfo v12 = new CMCFailInfo(new ASN1Integer(12));
        CMCFailInfo.tryLater = v12;
        CMCFailInfo v15 = v11;
        CMCFailInfo v13 = new CMCFailInfo(new ASN1Integer(13));
        CMCFailInfo.authDataFail = v13;
        HashMap v11_1 = new HashMap();
        CMCFailInfo.range = ((Map)v11_1);
        ((Map)v11_1).put(v0.value, v0);
        CMCFailInfo.range.put(v1.value, v1);
        CMCFailInfo.range.put(v2.value, v2);
        CMCFailInfo.range.put(v3.value, v3);
        CMCFailInfo.range.put(v4.value, v4);
        CMCFailInfo.range.put(v8.value, v8);
        CMCFailInfo.range.put(v5.value, v5);
        CMCFailInfo.range.put(v6.value, v6);
        CMCFailInfo.range.put(v7.value, v7);
        CMCFailInfo.range.put(v8.value, v8);
        CMCFailInfo.range.put(v9.value, v9);
        CMCFailInfo.range.put(v4.value, v4);
        CMCFailInfo.range.put(v8.value, v8);
        CMCFailInfo.range.put(v10.value, v10);
        CMCFailInfo.range.put(v15.value, v15);
        CMCFailInfo.range.put(v12.value, v12);
        CMCFailInfo.range.put(v13.value, v13);
    }

    private CMCFailInfo(ASN1Integer arg1) {
        super();
        this.value = arg1;
    }

    public static CMCFailInfo getInstance(Object arg3) {
        if((arg3 instanceof CMCFailInfo)) {
            return arg3;
        }

        if(arg3 != null) {
            Object v0 = CMCFailInfo.range.get(ASN1Integer.getInstance(arg3));
            if(v0 != null) {
                return ((CMCFailInfo)v0);
            }

            throw new IllegalArgumentException("unknown object in getInstance(): " + arg3.getClass().getName());
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.value;
    }
}

