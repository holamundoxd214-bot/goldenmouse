package org.bouncycastle.asn1.cmc;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;

public class CMCStatus extends ASN1Object {
    public static final CMCStatus confirmRequired;
    public static final CMCStatus failed;
    public static final CMCStatus noSupport;
    public static final CMCStatus partial;
    public static final CMCStatus pending;
    public static final CMCStatus popRequired;
    private static Map range;
    public static final CMCStatus success;
    private final ASN1Integer value;

    static {
        CMCStatus v0 = new CMCStatus(new ASN1Integer(0));
        CMCStatus.success = v0;
        CMCStatus v1 = new CMCStatus(new ASN1Integer(2));
        CMCStatus.failed = v1;
        CMCStatus v2 = new CMCStatus(new ASN1Integer(3));
        CMCStatus.pending = v2;
        CMCStatus v3 = new CMCStatus(new ASN1Integer(4));
        CMCStatus.noSupport = v3;
        CMCStatus v4 = new CMCStatus(new ASN1Integer(5));
        CMCStatus.confirmRequired = v4;
        CMCStatus v5 = new CMCStatus(new ASN1Integer(6));
        CMCStatus.popRequired = v5;
        CMCStatus v6 = new CMCStatus(new ASN1Integer(7));
        CMCStatus.partial = v6;
        HashMap v7 = new HashMap();
        CMCStatus.range = ((Map)v7);
        ((Map)v7).put(v0.value, v0);
        CMCStatus.range.put(v1.value, v1);
        CMCStatus.range.put(v2.value, v2);
        CMCStatus.range.put(v3.value, v3);
        CMCStatus.range.put(v4.value, v4);
        CMCStatus.range.put(v5.value, v5);
        CMCStatus.range.put(v6.value, v6);
    }

    private CMCStatus(ASN1Integer arg1) {
        super();
        this.value = arg1;
    }

    public static CMCStatus getInstance(Object arg3) {
        if((arg3 instanceof CMCStatus)) {
            return arg3;
        }

        if(arg3 != null) {
            Object v0 = CMCStatus.range.get(ASN1Integer.getInstance(arg3));
            if(v0 != null) {
                return ((CMCStatus)v0);
            }

            throw new IllegalArgumentException("unknown object in getInstance(): " + arg3.getClass().getName());
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.value;
    }
}

