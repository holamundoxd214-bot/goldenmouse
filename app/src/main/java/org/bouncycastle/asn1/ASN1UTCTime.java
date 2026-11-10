package org.bouncycastle.asn1;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class ASN1UTCTime extends ASN1Primitive {
    class org.bouncycastle.asn1.ASN1UTCTime$1 extends ASN1UniversalType {
        org.bouncycastle.asn1.ASN1UTCTime$1(Class arg1, int arg2) {
            super(arg1, arg2);
        }

        ASN1Primitive fromImplicitPrimitive(DEROctetString arg1) {
            return ASN1UTCTime.createPrimitive(arg1.getOctets());
        }
    }

    static final ASN1UniversalType TYPE;
    final byte[] contents;

    static {
        ASN1UTCTime.TYPE = new org.bouncycastle.asn1.ASN1UTCTime$1(ASN1UTCTime.class, 23);
    }

    public ASN1UTCTime(String arg3) {
        super();
        this.contents = Strings.toByteArray(arg3);
        try {
            this.getDate();
            return;
        }
        catch(ParseException v2) {
            throw new IllegalArgumentException("invalid date string: " + v2.getMessage());
        }
    }

    public ASN1UTCTime(Date arg5) {
        super();
        SimpleDateFormat v0 = new SimpleDateFormat("yyMMddHHmmss\'Z\'", LocaleUtil.EN_Locale);
        v0.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.contents = Strings.toByteArray(v0.format(arg5));
    }

    public ASN1UTCTime(Date arg4, Locale arg5) {
        super();
        SimpleDateFormat v0 = new SimpleDateFormat("yyMMddHHmmss\'Z\'", arg5);
        v0.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.contents = Strings.toByteArray(v0.format(arg4));
    }

    ASN1UTCTime(byte[] arg3) {
        super();
        if(arg3.length >= 2) {
            this.contents = arg3;
            if((this.isDigit(0)) && (this.isDigit(1))) {
                return;
            }

            throw new IllegalArgumentException("illegal characters in UTCTime string");
        }

        throw new IllegalArgumentException("UTCTime string too short");
    }

    boolean asn1Equals(ASN1Primitive arg2) {
        if(!(arg2 instanceof ASN1UTCTime)) {
            return 0;
        }

        return Arrays.areEqual(this.contents, ((ASN1UTCTime)arg2).contents);
    }

    static ASN1UTCTime createPrimitive(byte[] arg1) {
        return new ASN1UTCTime(arg1);
    }

    void encode(ASN1OutputStream arg2, boolean arg3) throws IOException {
        arg2.writeEncodingDL(arg3, 23, this.contents);
    }

    final boolean encodeConstructed() {
        return 0;
    }

    int encodedLength(boolean arg1) {
        return ASN1OutputStream.getLengthOfEncodingDL(arg1, this.contents.length);
    }

    public Date getAdjustedDate() throws ParseException {
        SimpleDateFormat v0 = new SimpleDateFormat("yyyyMMddHHmmssz", LocaleUtil.EN_Locale);
        v0.setTimeZone(new SimpleTimeZone(0, "Z"));
        return v0.parse(this.getAdjustedTime());
    }

    public String getAdjustedTime() {
        String v2 = this.getTime();
        StringBuilder v0 = v2.charAt(0) < 53 ? new StringBuilder("20") : new StringBuilder("19");
        return v0.append(v2).toString();
    }

    public Date getDate() throws ParseException {
        return new SimpleDateFormat("yyMMddHHmmssz", LocaleUtil.EN_Locale).parse(this.getTime());
    }

    public static ASN1UTCTime getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ASN1UTCTime)) {
            }
            else {
                if((arg3 instanceof ASN1Encodable)) {
                    ASN1Primitive v0 = arg3.toASN1Primitive();
                    if((v0 instanceof ASN1UTCTime)) {
                        return ((ASN1UTCTime)v0);
                    }
                }

                if((arg3 instanceof byte[])) {
                    try {
                        return ASN1UTCTime.TYPE.fromByteArray(((byte[])arg3));
                    }
                    catch(Exception v3) {
                        throw new IllegalArgumentException("encoding error in getInstance: " + v3.toString());
                    }
                }

                throw new IllegalArgumentException("illegal object in getInstance: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public static ASN1UTCTime getInstance(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1UTCTime.TYPE.getContextTagged(arg1, arg2);
    }

    public static ASN1UTCTime getTagged(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1UTCTime.TYPE.getTagged(arg1, arg2);
    }

    public String getTime() {
        String v0_1;
        StringBuilder v6_1;
        StringBuilder v0_2;
        String v6 = Strings.fromByteArray(this.contents);
        int v0 = 45;
        int v2 = 43;
        int v3 = 12;
        int v5 = 10;
        if(v6.indexOf(v0) >= 0 || v6.indexOf(v2) >= 0) {
            v0 = v6.indexOf(v0);
            if(v0 < 0) {
                v0 = v6.indexOf(v2);
            }

            if(v0 == v6.length() - 3) {
                v6 = v6 + "00";
            }

            String v1 = ":";
            v2 = 15;
            if(v0 == v5) {
                v0_2 = new StringBuilder().append(v6.substring(0, v5)).append("00GMT").append(v6.substring(v5, 13)).append(v1);
                v6 = v6.substring(13, v2);
            }
            else {
                v0_2 = new StringBuilder().append(v6.substring(0, v3)).append("GMT").append(v6.substring(v3, v2)).append(v1);
                v6 = v6.substring(v2, 17);
            }

            v6_1 = v0_2.append(v6);
        }
        else {
            if(v6.length() == 11) {
                v6_1 = new StringBuilder().append(v6.substring(0, v5));
                v0_1 = "00GMT+00:00";
            }
            else {
                v6_1 = new StringBuilder().append(v6.substring(0, v3));
                v0_1 = "GMT+00:00";
            }

            v6_1 = v6_1.append(v0_1);
        }

        return v6_1.toString();
    }

    public int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    private boolean isDigit(int arg2) {
        byte[] v1 = this.contents;
        if(v1.length > arg2) {
            int v1_1 = v1[arg2];
            if(v1_1 >= 0x30 && v1_1 <= 57) {
                return 1;
            }
        }

        return 0;
    }

    public String toString() {
        return Strings.fromByteArray(this.contents);
    }
}

