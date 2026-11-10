package org.bouncycastle.asn1.anssi;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECParametersHolder;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.math.ec.ECCurve$Fp;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.WNafUtil;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public class ANSSINamedCurves {
    class org.bouncycastle.asn1.anssi.ANSSINamedCurves$1 extends X9ECParametersHolder {
        org.bouncycastle.asn1.anssi.ANSSINamedCurves$1() {
            super();
        }

        protected ECCurve createCurve() {
            return ANSSINamedCurves.configureCurve(new Fp(ANSSINamedCurves.fromHex("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C03"), ANSSINamedCurves.fromHex("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C00"), ANSSINamedCurves.fromHex("EE353FCA5428A9300D4ABA754A44C00FDFEC0C9AE4B1A1803075ED967B7BB73F"), ANSSINamedCurves.fromHex("F1FD178C0B3AD58F10126DE8CE42435B53DC67E140D2BF941FFDD459C6D655E1"), BigInteger.valueOf(1), true));
        }

        protected X9ECParameters createParameters() {
            ECCurve v1 = this.createCurve();
            return new X9ECParameters(v1, ANSSINamedCurves.configureBasepoint(v1, "04B6B3D4C356C139EB31183D4749D423958C27D2DCAF98B70164C97A2DD98F5CFF6142E0F7C8B204911F9271F0F3ECEF8C2701C307E8E4C9E183115A1554062CFB"), v1.getOrder(), v1.getCofactor(), null);
        }
    }

    static X9ECParametersHolder FRP256v1;
    static final Hashtable curves;
    static final Hashtable names;
    static final Hashtable objIds;

    static {
        ANSSINamedCurves.FRP256v1 = new org.bouncycastle.asn1.anssi.ANSSINamedCurves$1();
        ANSSINamedCurves.objIds = new Hashtable();
        ANSSINamedCurves.curves = new Hashtable();
        ANSSINamedCurves.names = new Hashtable();
        ANSSINamedCurves.defineCurve("FRP256v1", ANSSIObjectIdentifiers.FRP256v1, ANSSINamedCurves.FRP256v1);
    }

    public ANSSINamedCurves() {
        super();
    }

    static BigInteger access$000(String arg0) {
        return ANSSINamedCurves.fromHex(arg0);
    }

    static ECCurve access$100(ECCurve arg0) {
        return ANSSINamedCurves.configureCurve(arg0);
    }

    static X9ECPoint access$200(ECCurve arg0, String arg1) {
        return ANSSINamedCurves.configureBasepoint(arg0, arg1);
    }

    private static X9ECPoint configureBasepoint(ECCurve arg1, String arg2) {
        X9ECPoint v0 = new X9ECPoint(arg1, Hex.decodeStrict(arg2));
        WNafUtil.configureBasepoint(v0.getPoint());
        return v0;
    }

    private static ECCurve configureCurve(ECCurve arg0) {
        return arg0;
    }

    static void defineCurve(String arg2, ASN1ObjectIdentifier arg3, X9ECParametersHolder arg4) {
        ANSSINamedCurves.objIds.put(Strings.toLowerCase(arg2), arg3);
        ANSSINamedCurves.names.put(arg3, arg2);
        ANSSINamedCurves.curves.put(arg3, arg4);
    }

    private static BigInteger fromHex(String arg2) {
        return new BigInteger(1, Hex.decodeStrict(arg2));
    }

    public static X9ECParameters getByName(String arg0) {
        ASN1ObjectIdentifier v0 = ANSSINamedCurves.getOID(arg0);
        if(v0 == null) {
            return null;
        }

        return ANSSINamedCurves.getByOID(v0);
    }

    public static X9ECParametersHolder getByNameLazy(String arg0) {
        ASN1ObjectIdentifier v0 = ANSSINamedCurves.getOID(arg0);
        if(v0 == null) {
            return null;
        }

        return ANSSINamedCurves.getByOIDLazy(v0);
    }

    public static X9ECParameters getByOID(ASN1ObjectIdentifier arg0) {
        X9ECParametersHolder v0 = ANSSINamedCurves.getByOIDLazy(arg0);
        if(v0 == null) {
            return null;
        }

        return v0.getParameters();
    }

    public static X9ECParametersHolder getByOIDLazy(ASN1ObjectIdentifier arg1) {
        return ANSSINamedCurves.curves.get(arg1);
    }

    public static String getName(ASN1ObjectIdentifier arg1) {
        return ANSSINamedCurves.names.get(arg1);
    }

    public static Enumeration getNames() {
        return ANSSINamedCurves.names.elements();
    }

    public static ASN1ObjectIdentifier getOID(String arg1) {
        return ANSSINamedCurves.objIds.get(Strings.toLowerCase(arg1));
    }
}

