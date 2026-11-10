package org.bouncycastle.asn1.eac;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import org.bouncycastle.util.Arrays;

public class PackedDate {
    private byte[] time;

    PackedDate(byte[] arg1) {
        super();
        this.time = arg1;
    }

    public PackedDate(String arg1) {
        super();
        this.time = this.convert(arg1);
    }

    public PackedDate(Date arg5) {
        super();
        SimpleDateFormat v0 = new SimpleDateFormat("yyMMdd\'Z\'");
        v0.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = this.convert(v0.format(arg5));
    }

    public PackedDate(Date arg4, Locale arg5) {
        super();
        SimpleDateFormat v0 = new SimpleDateFormat("yyMMdd\'Z\'", arg5);
        v0.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = this.convert(v0.format(arg4));
    }

    private byte[] convert(String arg4) {
        char[] v3 = arg4.toCharArray();
        int v4 = 6;
        byte[] v0 = new byte[v4];
        int v1;
        for(v1 = 0; v1 != v4; ++v1) {
            v0[v1] = ((byte)(v3[v1] - 0x30));
        }

        return v0;
    }

    public boolean equals(Object arg2) {
        if(!(arg2 instanceof PackedDate)) {
            return 0;
        }

        return Arrays.areEqual(this.time, ((PackedDate)arg2).time);
    }

    public Date getDate() throws ParseException {
        return new SimpleDateFormat("yyyyMMdd").parse("20" + this.toString());
    }

    public byte[] getEncoding() {
        return Arrays.clone(this.time);
    }

    public int hashCode() {
        return Arrays.hashCode(this.time);
    }

    public String toString() {
        int v0 = this.time.length;
        char[] v1 = new char[v0];
        int v2;
        for(v2 = 0; v2 != v0; ++v2) {
            v1[v2] = ((char)((this.time[v2] & 0xFF) + 0x30));
        }

        return new String(v1);
    }
}

