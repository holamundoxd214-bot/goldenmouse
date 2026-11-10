package org.bouncycastle.asn1.cms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1UTCTime;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERUTCTime;
import org.bouncycastle.asn1.LocaleUtil;

public class Time extends ASN1Object implements ASN1Choice {
    ASN1Primitive time;

    public Time(Date arg7) {
        DERGeneralizedTime v0_3;
        super();
        SimpleTimeZone v0 = new SimpleTimeZone(0, "Z");
        SimpleDateFormat v3 = new SimpleDateFormat("yyyyMMddHHmmss", LocaleUtil.EN_Locale);
        v3.setTimeZone(((TimeZone)v0));
        String v7 = v3.format(arg7) + "Z";
        int v0_1 = Integer.parseInt(v7.substring(0, 4));
        if(v0_1 < 1950 || v0_1 > 0x801) {
            v0_3 = new DERGeneralizedTime(v7);
        }
        else {
            DERUTCTime v0_2 = new DERUTCTime(v7.substring(2));
        }

        this.time = ((ASN1Primitive)v0_3);
    }

    public Time(Date arg6, Locale arg7) {
        DERGeneralizedTime v7_2;
        super();
        SimpleTimeZone v0 = new SimpleTimeZone(0, "Z");
        SimpleDateFormat v3 = new SimpleDateFormat("yyyyMMddHHmmss", arg7);
        v3.setTimeZone(((TimeZone)v0));
        String v6 = v3.format(arg6) + "Z";
        int v7 = Integer.parseInt(v6.substring(0, 4));
        if(v7 < 1950 || v7 > 0x801) {
            v7_2 = new DERGeneralizedTime(v6);
        }
        else {
            DERUTCTime v7_1 = new DERUTCTime(v6.substring(2));
        }

        this.time = ((ASN1Primitive)v7_2);
    }

    private Time(ASN1Primitive arg2) {
        super();
        if(!(arg2 instanceof ASN1UTCTime)) {
            if((arg2 instanceof ASN1GeneralizedTime)) {
            }
            else {
                throw new IllegalArgumentException("unknown object passed to Time");
            }
        }

        this.time = arg2;
    }

    public Date getDate() {
        try {
            ASN1Primitive v3_1 = this.time;
            if((v3_1 instanceof ASN1UTCTime)) {
                return ((ASN1UTCTime)v3_1).getAdjustedDate();
            }

            return ((ASN1GeneralizedTime)v3_1).getDate();
        }
        catch(ParseException v3) {
            throw new IllegalStateException("invalid date string: " + v3.getMessage());
        }
    }

    public static Time getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof Time)) {
            }
            else if((arg3 instanceof ASN1UTCTime)) {
                return new Time(((ASN1Primitive)arg3));
            }
            else if((arg3 instanceof ASN1GeneralizedTime)) {
                return new Time(((ASN1Primitive)arg3));
            }
            else {
                throw new IllegalArgumentException("unknown object in factory: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public static Time getInstance(ASN1TaggedObject arg0, boolean arg1) {
        if(arg1) {
            return Time.getInstance(arg0.getExplicitBaseObject());
        }

        throw new IllegalArgumentException("choice item must be explicitly tagged");
    }

    public String getTime() {
        ASN1Primitive v1 = this.time;
        if((v1 instanceof ASN1UTCTime)) {
            return ((ASN1UTCTime)v1).getAdjustedTime();
        }

        return ((ASN1GeneralizedTime)v1).getTime();
    }

    public ASN1Primitive toASN1Primitive() {
        return this.time;
    }
}

