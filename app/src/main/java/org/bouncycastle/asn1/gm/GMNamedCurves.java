package org.bouncycastle.asn1.gm;

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

public class GMNamedCurves {
    class org.bouncycastle.asn1.gm.GMNamedCurves$1 extends X9ECParametersHolder {
        org.bouncycastle.asn1.gm.GMNamedCurves$1() {
            super();
        }

        protected ECCurve createCurve() {
            return GMNamedCurves.configureCurve(new Fp(GMNamedCurves.fromHex("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF"), GMNamedCurves.fromHex("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC"), GMNamedCurves.fromHex("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93"), GMNamedCurves.fromHex("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123"), BigInteger.valueOf(1), true));
        }

        protected X9ECParameters createParameters() {
            ECCurve v1 = this.getCurve();
            return new X9ECParameters(v1, GMNamedCurves.configureBasepoint(v1, "0432C4AE2C1F1981195F9904466A39C9948FE30BBFF2660BE1715A4589334C74C7BC3736A2F4F6779C59BDCEE36B692153D0A9877CC62A474002DF32E52139F0A0"), v1.getOrder(), v1.getCofactor(), null);
        }
    }

    class org.bouncycastle.asn1.gm.GMNamedCurves$2 extends X9ECParametersHolder {
        org.bouncycastle.asn1.gm.GMNamedCurves$2() {
            super();
        }

        protected ECCurve createCurve() {
            return GMNamedCurves.configureCurve(new Fp(GMNamedCurves.fromHex("BDB6F4FE3E8B1D9E0DA8C0D46F4C318CEFE4AFE3B6B8551F"), GMNamedCurves.fromHex("BB8E5E8FBC115E139FE6A814FE48AAA6F0ADA1AA5DF91985"), GMNamedCurves.fromHex("1854BEBDC31B21B7AEFC80AB0ECD10D5B1B3308E6DBF11C1"), GMNamedCurves.fromHex("BDB6F4FE3E8B1D9E0DA8C0D40FC962195DFAE76F56564677"), BigInteger.valueOf(1), true));
        }

        protected X9ECParameters createParameters() {
            ECCurve v1 = this.getCurve();
            return new X9ECParameters(v1, GMNamedCurves.configureBasepoint(v1, "044AD5F7048DE709AD51236DE65E4D4B482C836DC6E410664002BB3A02D4AAADACAE24817A4CA3A1B014B5270432DB27D2"), v1.getOrder(), v1.getCofactor(), null);
        }
    }

    static final Hashtable curves;
    static final Hashtable names;
    static final Hashtable objIds;
    static X9ECParametersHolder sm2p256v1;
    static X9ECParametersHolder wapip192v1;

    static {
        GMNamedCurves.sm2p256v1 = new org.bouncycastle.asn1.gm.GMNamedCurves$1();
        GMNamedCurves.wapip192v1 = new org.bouncycastle.asn1.gm.GMNamedCurves$2();
        GMNamedCurves.objIds = new Hashtable();
        GMNamedCurves.curves = new Hashtable();
        GMNamedCurves.names = new Hashtable();
        GMNamedCurves.defineCurve("wapip192v1", GMObjectIdentifiers.wapip192v1, GMNamedCurves.wapip192v1);
        GMNamedCurves.defineCurve("wapi192v1", GMObjectIdentifiers.wapi192v1, GMNamedCurves.wapip192v1);
        GMNamedCurves.defineCurve("sm2p256v1", GMObjectIdentifiers.sm2p256v1, GMNamedCurves.sm2p256v1);
    }

    public GMNamedCurves() {
        super();
    }

    static BigInteger access$000(String arg0) {
        return GMNamedCurves.fromHex(arg0);
    }

    static ECCurve access$100(ECCurve arg0) {
        return GMNamedCurves.configureCurve(arg0);
    }

    static X9ECPoint access$200(ECCurve arg0, String arg1) {
        return GMNamedCurves.configureBasepoint(arg0, arg1);
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
        GMNamedCurves.objIds.put(Strings.toLowerCase(arg2), arg3);
        GMNamedCurves.names.put(arg3, arg2);
        GMNamedCurves.curves.put(arg3, arg4);
    }

    private static BigInteger fromHex(String arg2) {
        return new BigInteger(1, Hex.decodeStrict(arg2));
    }

    public static X9ECParameters getByName(String arg0) {
        ASN1ObjectIdentifier v0 = GMNamedCurves.getOID(arg0);
        if(v0 == null) {
            return null;
        }

        return GMNamedCurves.getByOID(v0);
    }

    public static X9ECParametersHolder getByNameLazy(String arg0) {
        ASN1ObjectIdentifier v0 = GMNamedCurves.getOID(arg0);
        if(v0 == null) {
            return null;
        }

        return GMNamedCurves.getByOIDLazy(v0);
    }

    public static X9ECParameters getByOID(ASN1ObjectIdentifier arg0) {
        X9ECParametersHolder v0 = GMNamedCurves.getByOIDLazy(arg0);
        if(v0 == null) {
            return null;
        }

        return v0.getParameters();
    }

    public static X9ECParametersHolder getByOIDLazy(ASN1ObjectIdentifier arg1) {
        return GMNamedCurves.curves.get(arg1);
    }

    public static String getName(ASN1ObjectIdentifier arg1) {
        return GMNamedCurves.names.get(arg1);
    }

    public static Enumeration getNames() {
        return GMNamedCurves.names.elements();
    }

    public static ASN1ObjectIdentifier getOID(String arg1) {
        return GMNamedCurves.objIds.get(Strings.toLowerCase(arg1));
    }
}

