package org.bouncycastle.asn1.nist;

import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.sec.SECNamedCurves;
import org.bouncycastle.asn1.sec.SECObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECParametersHolder;
import org.bouncycastle.util.Strings;

public class NISTNamedCurves {
    static final Hashtable names;
    static final Hashtable objIds;

    static {
        NISTNamedCurves.objIds = new Hashtable();
        NISTNamedCurves.names = new Hashtable();
        NISTNamedCurves.defineCurve("B-571", SECObjectIdentifiers.sect571r1);
        NISTNamedCurves.defineCurve("B-409", SECObjectIdentifiers.sect409r1);
        NISTNamedCurves.defineCurve("B-283", SECObjectIdentifiers.sect283r1);
        NISTNamedCurves.defineCurve("B-233", SECObjectIdentifiers.sect233r1);
        NISTNamedCurves.defineCurve("B-163", SECObjectIdentifiers.sect163r2);
        NISTNamedCurves.defineCurve("K-571", SECObjectIdentifiers.sect571k1);
        NISTNamedCurves.defineCurve("K-409", SECObjectIdentifiers.sect409k1);
        NISTNamedCurves.defineCurve("K-283", SECObjectIdentifiers.sect283k1);
        NISTNamedCurves.defineCurve("K-233", SECObjectIdentifiers.sect233k1);
        NISTNamedCurves.defineCurve("K-163", SECObjectIdentifiers.sect163k1);
        NISTNamedCurves.defineCurve("P-521", SECObjectIdentifiers.secp521r1);
        NISTNamedCurves.defineCurve("P-384", SECObjectIdentifiers.secp384r1);
        NISTNamedCurves.defineCurve("P-256", SECObjectIdentifiers.secp256r1);
        NISTNamedCurves.defineCurve("P-224", SECObjectIdentifiers.secp224r1);
        NISTNamedCurves.defineCurve("P-192", SECObjectIdentifiers.secp192r1);
    }

    public NISTNamedCurves() {
        super();
    }

    static void defineCurve(String arg1, ASN1ObjectIdentifier arg2) {
        NISTNamedCurves.objIds.put(arg1, arg2);
        NISTNamedCurves.names.put(arg2, arg1);
    }

    public static X9ECParameters getByName(String arg0) {
        ASN1ObjectIdentifier v0 = NISTNamedCurves.getOID(arg0);
        if(v0 != null) {
            return SECNamedCurves.getByOID(v0);
        }

        return null;
    }

    public static X9ECParametersHolder getByNameLazy(String arg0) {
        ASN1ObjectIdentifier v0 = NISTNamedCurves.getOID(arg0);
        if(v0 != null) {
            return SECNamedCurves.getByOIDLazy(v0);
        }

        return null;
    }

    public static X9ECParameters getByOID(ASN1ObjectIdentifier arg1) {
        if(NISTNamedCurves.names.containsKey(arg1)) {
            return SECNamedCurves.getByOID(arg1);
        }

        return null;
    }

    public static X9ECParametersHolder getByOIDLazy(ASN1ObjectIdentifier arg1) {
        if(NISTNamedCurves.names.containsKey(arg1)) {
            return SECNamedCurves.getByOIDLazy(arg1);
        }

        return null;
    }

    public static String getName(ASN1ObjectIdentifier arg1) {
        return NISTNamedCurves.names.get(arg1);
    }

    public static Enumeration getNames() {
        return NISTNamedCurves.objIds.keys();
    }

    public static ASN1ObjectIdentifier getOID(String arg1) {
        return NISTNamedCurves.objIds.get(Strings.toUpperCase(arg1));
    }
}

