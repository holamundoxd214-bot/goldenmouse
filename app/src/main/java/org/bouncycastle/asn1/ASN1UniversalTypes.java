package org.bouncycastle.asn1;

final class ASN1UniversalTypes {
    private ASN1UniversalTypes() {
        super();
    }

    static ASN1UniversalType get(int arg0) {
        switch(arg0) {
            case 1: {
                goto label_51;
            }
            case 2: {
                goto label_49;
            }
            case 3: {
                goto label_47;
            }
            case 4: {
                goto label_45;
            }
            case 5: {
                goto label_43;
            }
            case 6: {
                goto label_41;
            }
            case 7: {
                goto label_39;
            }
            case 8: {
                goto label_37;
            }
            case 10: {
                goto label_35;
            }
            case 12: {
                goto label_33;
            }
            case 13: {
                goto label_31;
            }
            case 16: {
                goto label_29;
            }
            case 17: {
                goto label_27;
            }
            case 18: {
                goto label_25;
            }
            case 19: {
                goto label_23;
            }
            case 20: {
                goto label_21;
            }
            case 21: {
                goto label_19;
            }
            case 22: {
                goto label_17;
            }
            case 23: {
                goto label_15;
            }
            case 24: {
                goto label_13;
            }
            case 25: {
                goto label_11;
            }
            case 26: {
                goto label_9;
            }
            case 27: {
                goto label_7;
            }
            case 28: {
                goto label_5;
            }
            case 30: {
                goto label_3;
            }
        }

        return null;
    label_33:
        return ASN1UTF8String.TYPE;
    label_35:
        return ASN1Enumerated.TYPE;
    label_37:
        return ASN1External.TYPE;
    label_39:
        return ASN1ObjectDescriptor.TYPE;
    label_41:
        return ASN1ObjectIdentifier.TYPE;
    label_43:
        return ASN1Null.TYPE;
    label_45:
        return ASN1OctetString.TYPE;
    label_47:
        return ASN1BitString.TYPE;
    label_49:
        return ASN1Integer.TYPE;
    label_51:
        return ASN1Boolean.TYPE;
    label_3:
        return ASN1BMPString.TYPE;
    label_5:
        return ASN1UniversalString.TYPE;
    label_7:
        return ASN1GeneralString.TYPE;
    label_9:
        return ASN1VisibleString.TYPE;
    label_11:
        return ASN1GraphicString.TYPE;
    label_13:
        return ASN1GeneralizedTime.TYPE;
    label_15:
        return ASN1UTCTime.TYPE;
    label_17:
        return ASN1IA5String.TYPE;
    label_19:
        return ASN1VideotexString.TYPE;
    label_21:
        return ASN1T61String.TYPE;
    label_23:
        return ASN1PrintableString.TYPE;
    label_25:
        return ASN1NumericString.TYPE;
    label_27:
        return ASN1Set.TYPE;
    label_29:
        return ASN1Sequence.TYPE;
    label_31:
        return ASN1RelativeOID.TYPE;
    }
}

