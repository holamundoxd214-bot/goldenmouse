package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public abstract class ASN1PrintableString extends ASN1Primitive implements ASN1String {
    class org.bouncycastle.asn1.ASN1PrintableString$1 extends ASN1UniversalType {
        org.bouncycastle.asn1.ASN1PrintableString$1(Class arg1, int arg2) {
            super(arg1, arg2);
        }

        ASN1Primitive fromImplicitPrimitive(DEROctetString arg1) {
            return ASN1PrintableString.createPrimitive(arg1.getOctets());
        }
    }

    static final ASN1UniversalType TYPE;
    final byte[] contents;

    static {
        ASN1PrintableString.TYPE = new org.bouncycastle.asn1.ASN1PrintableString$1(ASN1PrintableString.class, 19);
    }

    ASN1PrintableString(String arg1, boolean arg2) {
        super();
        if(arg2) {
            if(ASN1PrintableString.isPrintableString(arg1)) {
            }
            else {
                throw new IllegalArgumentException("string contains illegal characters");
            }
        }

        this.contents = Strings.toByteArray(arg1);
    }

    ASN1PrintableString(byte[] arg1, boolean arg2) {
        super();
        if(arg2) {
            arg1 = Arrays.clone(arg1);
        }

        this.contents = arg1;
    }

    final boolean asn1Equals(ASN1Primitive arg2) {
        if(!(arg2 instanceof ASN1PrintableString)) {
            return 0;
        }

        return Arrays.areEqual(this.contents, ((ASN1PrintableString)arg2).contents);
    }

    static ASN1PrintableString createPrimitive(byte[] arg2) {
        return new DERPrintableString(arg2, false);
    }

    final void encode(ASN1OutputStream arg2, boolean arg3) throws IOException {
        arg2.writeEncodingDL(arg3, 19, this.contents);
    }

    final boolean encodeConstructed() {
        return 0;
    }

    final int encodedLength(boolean arg1) {
        return ASN1OutputStream.getLengthOfEncodingDL(arg1, this.contents.length);
    }

    public static ASN1PrintableString getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ASN1PrintableString)) {
            }
            else {
                if((arg3 instanceof ASN1Encodable)) {
                    ASN1Primitive v0 = arg3.toASN1Primitive();
                    if((v0 instanceof ASN1PrintableString)) {
                        return ((ASN1PrintableString)v0);
                    }
                }

                if((arg3 instanceof byte[])) {
                    try {
                        return ASN1PrintableString.TYPE.fromByteArray(((byte[])arg3));
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

    public static ASN1PrintableString getInstance(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1PrintableString.TYPE.getContextTagged(arg1, arg2);
    }

    public final byte[] getOctets() {
        return Arrays.clone(this.contents);
    }

    public final String getString() {
        return Strings.fromByteArray(this.contents);
    }

    public static ASN1PrintableString getTagged(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1PrintableString.TYPE.getTagged(arg1, arg2);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    public static boolean isPrintableString(String arg5) {
        int v0;
        for(v0 = arg5.length() - 1; v0 >= 0; --v0) {
            int v2 = arg5.charAt(v0);
            if(v2 > 0x7F) {
                return 0;
            }

            if(97 > v2 || v2 > 0x7A) {
                if(65 <= v2 && v2 <= 90) {
                    goto label_35;
                }

                if(0x30 <= v2 && v2 <= 57) {
                    goto label_35;
                }

                if(v2 == 0x20) {
                    goto label_35;
                }

                if(v2 == 58) {
                    goto label_35;
                }

                if(v2 == 61) {
                    goto label_35;
                }

                if(v2 == 0x3F) {
                    goto label_35;
                }

                switch(v2) {
                    case 39: 
                    case 40: 
                    case 41: {
                        goto label_35;
                    }
                }

                switch(v2) {
                    case 43: 
                    case 44: 
                    case 45: 
                    case 46: 
                    case 47: {
                        goto label_35;
                    }
                }

                return 0;
            }
            else {
            }

        label_35:
        }

        return 1;
    }

    public String toString() {
        return this.getString();
    }
}

