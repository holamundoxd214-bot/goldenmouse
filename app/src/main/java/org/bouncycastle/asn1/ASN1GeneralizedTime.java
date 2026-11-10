package org.bouncycastle.asn1;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class ASN1GeneralizedTime extends ASN1Primitive {
    class org.bouncycastle.asn1.ASN1GeneralizedTime$1 extends ASN1UniversalType {
        org.bouncycastle.asn1.ASN1GeneralizedTime$1(Class arg1, int arg2) {
            super(arg1, arg2);
        }

        ASN1Primitive fromImplicitPrimitive(DEROctetString arg1) {
            return ASN1GeneralizedTime.createPrimitive(arg1.getOctets());
        }
    }

    static final ASN1UniversalType TYPE;
    final byte[] contents;

    static {
        ASN1GeneralizedTime.TYPE = new org.bouncycastle.asn1.ASN1GeneralizedTime$1(ASN1GeneralizedTime.class, 24);
    }

    public ASN1GeneralizedTime(String arg3) {
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

    public ASN1GeneralizedTime(Date arg5) {
        super();
        SimpleDateFormat v0 = new SimpleDateFormat("yyyyMMddHHmmss\'Z\'", LocaleUtil.EN_Locale);
        v0.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.contents = Strings.toByteArray(v0.format(arg5));
    }

    public ASN1GeneralizedTime(Date arg4, Locale arg5) {
        super();
        SimpleDateFormat v0 = new SimpleDateFormat("yyyyMMddHHmmss\'Z\'", arg5);
        v0.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.contents = Strings.toByteArray(v0.format(arg4));
    }

    ASN1GeneralizedTime(byte[] arg3) {
        super();
        if(arg3.length >= 4) {
            this.contents = arg3;
            if((this.isDigit(0)) && (this.isDigit(1)) && (this.isDigit(2)) && (this.isDigit(3))) {
                return;
            }

            throw new IllegalArgumentException("illegal characters in GeneralizedTime string");
        }

        throw new IllegalArgumentException("GeneralizedTime string too short");
    }

    boolean asn1Equals(ASN1Primitive arg2) {
        if(!(arg2 instanceof ASN1GeneralizedTime)) {
            return 0;
        }

        return Arrays.areEqual(this.contents, ((ASN1GeneralizedTime)arg2).contents);
    }

    private SimpleDateFormat calculateGMTDateFormat() {
        SimpleDateFormat v3;
        if(this.hasFractionalSeconds()) {
            v3 = new SimpleDateFormat("yyyyMMddHHmmss.SSSz");
        }
        else if(this.hasSeconds()) {
            v3 = new SimpleDateFormat("yyyyMMddHHmmssz");
        }
        else if(this.hasMinutes()) {
            v3 = new SimpleDateFormat("yyyyMMddHHmmz");
        }
        else {
            v3 = new SimpleDateFormat("yyyyMMddHHz");
        }

        v3.setTimeZone(new SimpleTimeZone(0, "Z"));
        return v3;
    }

    private String calculateGMTOffset(String arg10) {
        String v5;
        String v0 = ":";
        String v1 = "GMT";
        TimeZone v2 = TimeZone.getDefault();
        int v3 = v2.getRawOffset();
        String v4 = "+";
        if(v3 < 0) {
            v3 = -v3;
            v5 = "-";
        }
        else {
            v5 = v4;
        }

        int v7 = v3 / 3600000;
        v3 = (v3 - 3600000 * v7) / 60000;
        try {
            if(v2.useDaylightTime()) {
                if(this.hasFractionalSeconds()) {
                    arg10 = this.pruneFractionalSeconds(arg10);
                }

                if(!v2.inDaylightTime(this.calculateGMTDateFormat().parse(arg10 + v1 + v5 + this.convert(v7) + v0 + this.convert(v3)))) {
                    goto label_42;
                }

                if(v5.equals(v4)) {
                    goto label_38;
                }
                else {
                    goto label_40;
                }
            }
        }
        catch(ParseException ) {
        }

        goto label_42;
    label_38:
        int v10 = 1;
        goto label_41;
    label_40:
        v10 = -1;
    label_41:
        v7 += v10;
    label_42:
        return v1 + v5 + this.convert(v7) + v0 + this.convert(v3);
    }

    private String convert(int arg2) {
        if(arg2 < 10) {
            return "0" + arg2;
        }

        return Integer.toString(arg2);
    }

    static ASN1GeneralizedTime createPrimitive(byte[] arg1) {
        return new ASN1GeneralizedTime(arg1);
    }

    void encode(ASN1OutputStream arg2, boolean arg3) throws IOException {
        arg2.writeEncodingDL(arg3, 24, this.contents);
    }

    final boolean encodeConstructed() {
        return 0;
    }

    int encodedLength(boolean arg1) {
        return ASN1OutputStream.getLengthOfEncodingDL(arg1, this.contents.length);
    }

    public Date getDate() throws ParseException {
        SimpleDateFormat v1_1;
        SimpleDateFormat v2;
        String v0 = Strings.fromByteArray(this.contents);
        String v1 = "Z";
        if(v0.endsWith(v1)) {
            if(this.hasFractionalSeconds()) {
                v2 = new SimpleDateFormat("yyyyMMddHHmmss.SSS\'Z\'", LocaleUtil.EN_Locale);
            }
            else if(this.hasSeconds()) {
                v2 = new SimpleDateFormat("yyyyMMddHHmmss\'Z\'", LocaleUtil.EN_Locale);
            }
            else if(this.hasMinutes()) {
                v2 = new SimpleDateFormat("yyyyMMddHHmm\'Z\'", LocaleUtil.EN_Locale);
            }
            else {
                v2 = new SimpleDateFormat("yyyyMMddHH\'Z\'", LocaleUtil.EN_Locale);
            }

            v2.setTimeZone(new SimpleTimeZone(0, v1));
        }
        else {
            if(v0.indexOf(45) <= 0) {
                if(v0.indexOf(43) > 0) {
                }
                else {
                    if(this.hasFractionalSeconds()) {
                        v1_1 = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
                    }
                    else if(this.hasSeconds()) {
                        v1_1 = new SimpleDateFormat("yyyyMMddHHmmss");
                    }
                    else if(this.hasMinutes()) {
                        v1_1 = new SimpleDateFormat("yyyyMMddHHmm");
                    }
                    else {
                        v1_1 = new SimpleDateFormat("yyyyMMddHH");
                    }

                    v2 = v1_1;
                    v2.setTimeZone(new SimpleTimeZone(0, TimeZone.getDefault().getID()));
                    goto label_73;
                }
            }

            v0 = this.getTime();
            v2 = this.calculateGMTDateFormat();
        }

    label_73:
        if(this.hasFractionalSeconds()) {
            v0 = this.pruneFractionalSeconds(v0);
        }

        return v2.parse(v0);
    }

    public static ASN1GeneralizedTime getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ASN1GeneralizedTime)) {
            }
            else {
                if((arg3 instanceof ASN1Encodable)) {
                    ASN1Primitive v0 = arg3.toASN1Primitive();
                    if((v0 instanceof ASN1GeneralizedTime)) {
                        return ((ASN1GeneralizedTime)v0);
                    }
                }

                if((arg3 instanceof byte[])) {
                    try {
                        return ASN1GeneralizedTime.TYPE.fromByteArray(((byte[])arg3));
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

    public static ASN1GeneralizedTime getInstance(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1GeneralizedTime.TYPE.getContextTagged(arg1, arg2);
    }

    public static ASN1GeneralizedTime getTagged(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1GeneralizedTime.TYPE.getTagged(arg1, arg2);
    }

    public String getTime() {
        StringBuilder v8;
        String v0 = Strings.fromByteArray(this.contents);
        if(v0.charAt(v0.length() - 1) == 90) {
            v8 = new StringBuilder().append(v0.substring(0, v0.length() - 1));
            v0 = "GMT+00:00";
            goto label_15;
        }
        else {
            int v1 = v0.length();
            int v2 = v0.charAt(v1 - 6);
            int v4 = 43;
            String v5 = "GMT";
            int v6 = 45;
            if((v2 == v6 || v2 == v4) && v0.indexOf(v5) == v1 - 9) {
                return v0;
            }

            v1 = v0.length();
            v2 = v1 - 5;
            int v7 = v0.charAt(v2);
            if(v7 != v6) {
                if(v7 == v4) {
                }
                else {
                    v1 = v0.length() - 3;
                    v2 = v0.charAt(v1);
                    if(v2 != v6) {
                        if(v2 == v4) {
                        }
                        else {
                            v8 = new StringBuilder().append(v0).append(this.calculateGMTOffset(v0));
                            goto label_16;
                        }
                    }

                    v8 = new StringBuilder().append(v0.substring(0, v1)).append(v5).append(v0.substring(v1));
                    v0 = ":00";
                    goto label_15;
                }
            }

            v1 += -2;
            v8 = new StringBuilder().append(v0.substring(0, v2)).append(v5).append(v0.substring(v2, v1)).append(":");
            v0 = v0.substring(v1);
        label_15:
            v8 = v8.append(v0);
        }

    label_16:
        return v8.toString();
    }

    public String getTimeString() {
        return Strings.fromByteArray(this.contents);
    }

    protected boolean hasFractionalSeconds() {
        int v1;
        for(v1 = 0; true; ++v1) {
            byte[] v2 = this.contents;
            if(v1 == v2.length) {
                return 0;
            }

            if(v2[v1] == 46 && v1 == 14) {
                return 1;
            }
        }

        return 0;
    }

    protected boolean hasMinutes() {
        if((this.isDigit(10)) && (this.isDigit(11))) {
            return 1;
        }

        return 0;
    }

    protected boolean hasSeconds() {
        if((this.isDigit(12)) && (this.isDigit(13))) {
            return 1;
        }

        return 0;
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

    private String pruneFractionalSeconds(String arg7) {
        StringBuilder v1;
        int v3;
        int v6 = 14;
        String v0 = arg7.substring(v6);
        int v2 = 1;
        while(v2 < v0.length()) {
            v3 = v0.charAt(v2);
            if(0x30 > v3) {
                break;
            }

            if(v3 > 57) {
            }
            else {
                ++v2;
                continue;
            }

            break;
        }

        v3 = v2 - 1;
        if(v3 > 3) {
            v0 = v0.substring(0, 4) + v0.substring(v2);
            v1 = new StringBuilder();
        }
        else if(v3 == 1) {
            v0 = v0.substring(0, v2) + "00" + v0.substring(v2);
            v1 = new StringBuilder();
        }
        else if(v3 == 2) {
            v0 = v0.substring(0, v2) + "0" + v0.substring(v2);
            v1 = new StringBuilder();
        }
        else {
            return arg7;
        }

        return v1.append(arg7.substring(0, v6)).append(v0).toString();
    }

    ASN1Primitive toDERObject() {
        return new DERGeneralizedTime(this.contents);
    }
}

