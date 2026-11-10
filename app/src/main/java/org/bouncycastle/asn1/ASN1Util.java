package org.bouncycastle.asn1;

import java.io.IOException;

public abstract class ASN1Util {
    public ASN1Util() {
        super();
    }

    static ASN1TaggedObject checkContextTag(ASN1TaggedObject arg1, int arg2) {
        return ASN1Util.checkTag(arg1, 0x80, arg2);
    }

    static ASN1TaggedObjectParser checkContextTag(ASN1TaggedObjectParser arg1, int arg2) {
        return ASN1Util.checkTag(arg1, 0x80, arg2);
    }

    static ASN1TaggedObject checkContextTagClass(ASN1TaggedObject arg1) {
        return ASN1Util.checkTagClass(arg1, 0x80);
    }

    static ASN1TaggedObjectParser checkContextTagClass(ASN1TaggedObjectParser arg1) {
        return ASN1Util.checkTagClass(arg1, 0x80);
    }

    static ASN1TaggedObject checkTag(ASN1TaggedObject arg2, int arg3, int arg4) {
        if(arg2.hasTag(arg3, arg4)) {
            return arg2;
        }

        throw new IllegalStateException("Expected " + ASN1Util.getTagText(arg3, arg4) + " tag but found " + ASN1Util.getTagText(arg2));
    }

    static ASN1TaggedObjectParser checkTag(ASN1TaggedObjectParser arg2, int arg3, int arg4) {
        if(arg2.hasTag(arg3, arg4)) {
            return arg2;
        }

        throw new IllegalStateException("Expected " + ASN1Util.getTagText(arg3, arg4) + " tag but found " + ASN1Util.getTagText(arg2));
    }

    static ASN1TaggedObject checkTagClass(ASN1TaggedObject arg3, int arg4) {
        if(arg3.hasTagClass(arg4)) {
            return arg3;
        }

        throw new IllegalStateException("Expected " + ASN1Util.getTagClassText(arg4) + " tag but found " + ASN1Util.getTagClassText(arg3));
    }

    static ASN1TaggedObjectParser checkTagClass(ASN1TaggedObjectParser arg3, int arg4) {
        if(arg3.hasTagClass(arg4)) {
            return arg3;
        }

        throw new IllegalStateException("Expected " + ASN1Util.getTagClassText(arg4) + " tag but found " + ASN1Util.getTagClassText(arg3));
    }

    public static ASN1Primitive getBaseUniversal(ASN1TaggedObject arg0, int arg1, int arg2, boolean arg3, int arg4) {
        return ASN1Util.checkTag(arg0, arg1, arg2).getBaseUniversal(arg3, arg4);
    }

    public static ASN1Primitive getContextBaseUniversal(ASN1TaggedObject arg1, int arg2, boolean arg3, int arg4) {
        return ASN1Util.getBaseUniversal(arg1, 0x80, arg2, arg3, arg4);
    }

    public static ASN1Object getExplicitBaseObject(ASN1TaggedObject arg0, int arg1) {
        return ASN1Util.checkTagClass(arg0, arg1).getExplicitBaseObject();
    }

    public static ASN1Object getExplicitBaseObject(ASN1TaggedObject arg0, int arg1, int arg2) {
        return ASN1Util.checkTag(arg0, arg1, arg2).getExplicitBaseObject();
    }

    public static ASN1TaggedObject getExplicitBaseTagged(ASN1TaggedObject arg0, int arg1, int arg2) {
        return ASN1Util.checkTag(arg0, arg1, arg2).getExplicitBaseTagged();
    }

    public static ASN1TaggedObject getExplicitBaseTagged(ASN1TaggedObject arg0, int arg1) {
        return ASN1Util.checkTagClass(arg0, arg1).getExplicitBaseTagged();
    }

    public static ASN1Object getExplicitContextBaseObject(ASN1TaggedObject arg1) {
        return ASN1Util.getExplicitBaseObject(arg1, 0x80);
    }

    public static ASN1Object getExplicitContextBaseObject(ASN1TaggedObject arg1, int arg2) {
        return ASN1Util.getExplicitBaseObject(arg1, 0x80, arg2);
    }

    public static ASN1TaggedObject getExplicitContextBaseTagged(ASN1TaggedObject arg1) {
        return ASN1Util.getExplicitBaseTagged(arg1, 0x80);
    }

    public static ASN1TaggedObject getExplicitContextBaseTagged(ASN1TaggedObject arg1, int arg2) {
        return ASN1Util.getExplicitBaseTagged(arg1, 0x80, arg2);
    }

    public static ASN1TaggedObject getImplicitBaseTagged(ASN1TaggedObject arg0, int arg1, int arg2, int arg3, int arg4) {
        return ASN1Util.checkTag(arg0, arg1, arg2).getImplicitBaseTagged(arg3, arg4);
    }

    public static ASN1TaggedObject getImplicitContextBaseTagged(ASN1TaggedObject arg1, int arg2, int arg3, int arg4) {
        return ASN1Util.getImplicitBaseTagged(arg1, 0x80, arg2, arg3, arg4);
    }

    public static Object getInstanceChoiceBaseObject(ASN1TaggedObject arg0, boolean arg1, String arg2) {
        if(arg1) {
            if(arg0 != null) {
                return ASN1Util.getExplicitContextBaseObject(arg0);
            }

            throw new NullPointerException("\'taggedObject\' cannot be null");
        }

        throw new IllegalArgumentException("Implicit tagging cannot be used with untagged choice type " + arg2 + " (X.680 30.6, 30.8).");
    }

    public static String getTagClassText(int arg1) {
        if(arg1 != 0x40) {
            if(arg1 != 0x80) {
                if(arg1 != 0xC0) {
                    return "UNIVERSAL";
                }

                return "PRIVATE";
            }

            return "CONTEXT";
        }

        return "APPLICATION";
    }

    public static String getTagClassText(ASN1TaggedObject arg0) {
        return ASN1Util.getTagClassText(arg0.getTagClass());
    }

    public static String getTagClassText(ASN1TaggedObjectParser arg0) {
        return ASN1Util.getTagClassText(arg0.getTagClass());
    }

    static String getTagClassText(ASN1Tag arg0) {
        return ASN1Util.getTagClassText(arg0.getTagClass());
    }

    public static String getTagText(ASN1TaggedObject arg1) {
        return ASN1Util.getTagText(arg1.getTagClass(), arg1.getTagNo());
    }

    public static String getTagText(int arg2, int arg3) {
        StringBuilder v2;
        String v1 = "]";
        if(arg2 == 0x40) {
            v2 = new StringBuilder("[APPLICATION ");
        }
        else if(arg2 == 0x80) {
            v2 = new StringBuilder("[CONTEXT ");
        }
        else if(arg2 != 0xC0) {
            v2 = new StringBuilder("[UNIVERSAL ");
        }
        else {
            v2 = new StringBuilder("[PRIVATE ");
        }

        return v2.append(arg3).append(v1).toString();
    }

    public static String getTagText(ASN1TaggedObjectParser arg1) {
        return ASN1Util.getTagText(arg1.getTagClass(), arg1.getTagNo());
    }

    static String getTagText(ASN1Tag arg1) {
        return ASN1Util.getTagText(arg1.getTagClass(), arg1.getTagNumber());
    }

    public static Object getTaggedChoiceBaseObject(ASN1TaggedObject arg0, boolean arg1, String arg2) {
        if(arg1) {
            if(arg0 != null) {
                return arg0.getExplicitBaseObject();
            }

            throw new NullPointerException("\'taggedObject\' cannot be null");
        }

        throw new IllegalArgumentException("Implicit tagging cannot be used with untagged choice type " + arg2 + " (X.680 30.6, 30.8).");
    }

    public static ASN1Encodable parseBaseUniversal(ASN1TaggedObjectParser arg0, int arg1, int arg2, boolean arg3, int arg4) throws IOException {
        return ASN1Util.checkTag(arg0, arg1, arg2).parseBaseUniversal(arg3, arg4);
    }

    public static ASN1Encodable parseContextBaseUniversal(ASN1TaggedObjectParser arg1, int arg2, boolean arg3, int arg4) throws IOException {
        return ASN1Util.parseBaseUniversal(arg1, 0x80, arg2, arg3, arg4);
    }

    public static ASN1Encodable parseExplicitBaseObject(ASN1TaggedObjectParser arg0, int arg1, int arg2) throws IOException {
        return ASN1Util.checkTag(arg0, arg1, arg2).parseExplicitBaseObject();
    }

    public static ASN1TaggedObjectParser parseExplicitBaseTagged(ASN1TaggedObjectParser arg0, int arg1) throws IOException {
        return ASN1Util.checkTagClass(arg0, arg1).parseExplicitBaseTagged();
    }

    public static ASN1TaggedObjectParser parseExplicitBaseTagged(ASN1TaggedObjectParser arg0, int arg1, int arg2) throws IOException {
        return ASN1Util.checkTag(arg0, arg1, arg2).parseExplicitBaseTagged();
    }

    public static ASN1Encodable parseExplicitContextBaseObject(ASN1TaggedObjectParser arg1, int arg2) throws IOException {
        return ASN1Util.parseExplicitBaseObject(arg1, 0x80, arg2);
    }

    public static ASN1TaggedObjectParser parseExplicitContextBaseTagged(ASN1TaggedObjectParser arg1) throws IOException {
        return ASN1Util.parseExplicitBaseTagged(arg1, 0x80);
    }

    public static ASN1TaggedObjectParser parseExplicitContextBaseTagged(ASN1TaggedObjectParser arg1, int arg2) throws IOException {
        return ASN1Util.parseExplicitBaseTagged(arg1, 0x80, arg2);
    }

    public static ASN1TaggedObjectParser parseImplicitBaseTagged(ASN1TaggedObjectParser arg0, int arg1, int arg2, int arg3, int arg4) throws IOException {
        return ASN1Util.checkTag(arg0, arg1, arg2).parseImplicitBaseTagged(arg3, arg4);
    }

    public static ASN1TaggedObjectParser parseImplicitContextBaseTagged(ASN1TaggedObjectParser arg1, int arg2, int arg3, int arg4) throws IOException {
        return ASN1Util.parseImplicitBaseTagged(arg1, 0x80, arg2, arg3, arg4);
    }

    public static ASN1Primitive tryGetBaseUniversal(ASN1TaggedObject arg0, int arg1, int arg2, boolean arg3, int arg4) {
        if(!arg0.hasTag(arg1, arg2)) {
            return null;
        }

        return arg0.getBaseUniversal(arg3, arg4);
    }

    public static ASN1Primitive tryGetContextBaseUniversal(ASN1TaggedObject arg1, int arg2, boolean arg3, int arg4) {
        return ASN1Util.tryGetBaseUniversal(arg1, 0x80, arg2, arg3, arg4);
    }

    public static ASN1Object tryGetExplicitBaseObject(ASN1TaggedObject arg0, int arg1) {
        if(!arg0.hasTagClass(arg1)) {
            return null;
        }

        return arg0.getExplicitBaseObject();
    }

    public static ASN1Object tryGetExplicitBaseObject(ASN1TaggedObject arg0, int arg1, int arg2) {
        if(!arg0.hasTag(arg1, arg2)) {
            return null;
        }

        return arg0.getExplicitBaseObject();
    }

    public static ASN1TaggedObject tryGetExplicitBaseTagged(ASN1TaggedObject arg0, int arg1) {
        if(!arg0.hasTagClass(arg1)) {
            return null;
        }

        return arg0.getExplicitBaseTagged();
    }

    public static ASN1TaggedObject tryGetExplicitBaseTagged(ASN1TaggedObject arg0, int arg1, int arg2) {
        if(!arg0.hasTag(arg1, arg2)) {
            return null;
        }

        return arg0.getExplicitBaseTagged();
    }

    public static ASN1Object tryGetExplicitContextBaseObject(ASN1TaggedObject arg1) {
        return ASN1Util.tryGetExplicitBaseObject(arg1, 0x80);
    }

    public static ASN1Object tryGetExplicitContextBaseObject(ASN1TaggedObject arg1, int arg2) {
        return ASN1Util.tryGetExplicitBaseObject(arg1, 0x80, arg2);
    }

    public static ASN1TaggedObject tryGetExplicitContextBaseTagged(ASN1TaggedObject arg1) {
        return ASN1Util.tryGetExplicitBaseTagged(arg1, 0x80);
    }

    public static ASN1TaggedObject tryGetExplicitContextBaseTagged(ASN1TaggedObject arg1, int arg2) {
        return ASN1Util.tryGetExplicitBaseTagged(arg1, 0x80, arg2);
    }

    public static ASN1TaggedObject tryGetImplicitBaseTagged(ASN1TaggedObject arg0, int arg1, int arg2, int arg3, int arg4) {
        if(!arg0.hasTag(arg1, arg2)) {
            return null;
        }

        return arg0.getImplicitBaseTagged(arg3, arg4);
    }

    public static ASN1TaggedObject tryGetImplicitContextBaseTagged(ASN1TaggedObject arg1, int arg2, int arg3, int arg4) {
        return ASN1Util.tryGetImplicitBaseTagged(arg1, 0x80, arg2, arg3, arg4);
    }

    public static ASN1Encodable tryParseBaseUniversal(ASN1TaggedObjectParser arg0, int arg1, int arg2, boolean arg3, int arg4) throws IOException {
        if(!arg0.hasTag(arg1, arg2)) {
            return null;
        }

        return arg0.parseBaseUniversal(arg3, arg4);
    }

    public static ASN1Encodable tryParseContextBaseUniversal(ASN1TaggedObjectParser arg1, int arg2, boolean arg3, int arg4) throws IOException {
        return ASN1Util.tryParseBaseUniversal(arg1, 0x80, arg2, arg3, arg4);
    }

    public static ASN1Encodable tryParseExplicitBaseObject(ASN1TaggedObjectParser arg0, int arg1, int arg2) throws IOException {
        if(!arg0.hasTag(arg1, arg2)) {
            return null;
        }

        return arg0.parseExplicitBaseObject();
    }

    public static ASN1TaggedObjectParser tryParseExplicitBaseTagged(ASN1TaggedObjectParser arg0, int arg1) throws IOException {
        if(!arg0.hasTagClass(arg1)) {
            return null;
        }

        return arg0.parseExplicitBaseTagged();
    }

    public static ASN1TaggedObjectParser tryParseExplicitBaseTagged(ASN1TaggedObjectParser arg0, int arg1, int arg2) throws IOException {
        if(!arg0.hasTag(arg1, arg2)) {
            return null;
        }

        return arg0.parseExplicitBaseTagged();
    }

    public static ASN1Encodable tryParseExplicitContextBaseObject(ASN1TaggedObjectParser arg1, int arg2) throws IOException {
        return ASN1Util.tryParseExplicitBaseObject(arg1, 0x80, arg2);
    }

    public static ASN1TaggedObjectParser tryParseExplicitContextBaseTagged(ASN1TaggedObjectParser arg1) throws IOException {
        return ASN1Util.tryParseExplicitBaseTagged(arg1, 0x80);
    }

    public static ASN1TaggedObjectParser tryParseExplicitContextBaseTagged(ASN1TaggedObjectParser arg1, int arg2) throws IOException {
        return ASN1Util.tryParseExplicitBaseTagged(arg1, 0x80, arg2);
    }

    public static ASN1TaggedObjectParser tryParseImplicitBaseTagged(ASN1TaggedObjectParser arg0, int arg1, int arg2, int arg3, int arg4) throws IOException {
        if(!arg0.hasTag(arg1, arg2)) {
            return null;
        }

        return arg0.parseImplicitBaseTagged(arg3, arg4);
    }

    public static ASN1TaggedObjectParser tryParseImplicitContextBaseTagged(ASN1TaggedObjectParser arg1, int arg2, int arg3, int arg4) throws IOException {
        return ASN1Util.tryParseImplicitBaseTagged(arg1, 0x80, arg2, arg3, arg4);
    }
}

