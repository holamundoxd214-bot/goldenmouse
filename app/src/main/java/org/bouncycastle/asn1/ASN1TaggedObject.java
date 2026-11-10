package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;

public abstract class ASN1TaggedObject extends ASN1Primitive implements ASN1TaggedObjectParser {
    private static final int DECLARED_EXPLICIT = 1;
    private static final int DECLARED_IMPLICIT = 2;
    private static final int PARSED_EXPLICIT = 3;
    private static final int PARSED_IMPLICIT = 4;
    final int explicitness;
    final ASN1Encodable obj;
    final int tagClass;
    final int tagNo;

    ASN1TaggedObject(int arg2, int arg3, int arg4, ASN1Encodable arg5) {
        super();
        if(arg5 != null) {
            if(arg3 != 0 && (arg3 & 0xC0) == arg3) {
                this.explicitness = 1;
                this.tagClass = arg3;
                this.tagNo = arg4;
                this.obj = arg5;
                return;
            }

            throw new IllegalArgumentException("invalid tag class: " + arg3);
        }

        throw new NullPointerException("\'obj\' cannot be null");
    }

    protected ASN1TaggedObject(boolean arg1, int arg2, int arg3, ASN1Encodable arg4) {
        int v1 = arg1 ? 1 : 2;
        this(v1, arg2, arg3, arg4);
    }

    protected ASN1TaggedObject(boolean arg2, int arg3, ASN1Encodable arg4) {
        this(arg2, 0x80, arg3, arg4);
    }

    final boolean asn1Equals(ASN1Primitive arg5) {
        if(!(arg5 instanceof ASN1TaggedObject)) {
            return 0;
        }

        if(this.tagNo == ((ASN1TaggedObject)arg5).tagNo) {
            if(this.tagClass != ((ASN1TaggedObject)arg5).tagClass) {
            }
            else {
                if(this.explicitness != ((ASN1TaggedObject)arg5).explicitness && this.isExplicit() != ((ASN1TaggedObject)arg5).isExplicit()) {
                    return 0;
                }

                ASN1Primitive v0 = this.obj.toASN1Primitive();
                ASN1Primitive v2 = ((ASN1TaggedObject)arg5).obj.toASN1Primitive();
                if(v0 == v2) {
                    return 1;
                }

                if(!this.isExplicit()) {
                    try {
                        return Arrays.areEqual(this.getEncoded(), ((ASN1TaggedObject)arg5).getEncoded());
                    }
                    catch(IOException ) {
                        return 0;
                    }
                }

                return v0.asn1Equals(v2);
            }
        }

        return 0;
    }

    private static ASN1TaggedObject checkInstance(Object arg1) {
        if(arg1 != null) {
            return ASN1TaggedObject.getInstance(arg1);
        }

        throw new NullPointerException("\'obj\' cannot be null");
    }

    private static ASN1TaggedObject checkInstance(ASN1TaggedObject arg0, boolean arg1) {
        if(arg1) {
            if(arg0 != null) {
                return arg0;
            }

            throw new NullPointerException("\'taggedObject\' cannot be null");
        }

        throw new IllegalArgumentException("this method not valid for implicitly tagged tagged objects");
    }

    private static ASN1TaggedObject checkedCast(ASN1Primitive arg3) {
        if((arg3 instanceof ASN1TaggedObject)) {
            return arg3;
        }

        throw new IllegalStateException("unexpected object: " + arg3.getClass().getName());
    }

    static ASN1Primitive createConstructedDL(int arg2, int arg3, ASN1EncodableVector arg4) {
        if(arg4.size() == 1) {
            return new DLTaggedObject(3, arg2, arg3, arg4.get(0));
        }

        return new DLTaggedObject(4, arg2, arg3, DLFactory.createSequence(arg4));
    }

    static ASN1Primitive createConstructedIL(int arg2, int arg3, ASN1EncodableVector arg4) {
        if(arg4.size() == 1) {
            return new BERTaggedObject(3, arg2, arg3, arg4.get(0));
        }

        return new BERTaggedObject(4, arg2, arg3, BERFactory.createSequence(arg4));
    }

    static ASN1Primitive createPrimitive(int arg2, int arg3, byte[] arg4) {
        return new DLTaggedObject(4, arg2, arg3, new DEROctetString(arg4));
    }

    public ASN1Object getBaseObject() {
        ASN1Encodable v1 = this.obj;
        if((v1 instanceof ASN1Object)) {
            return ((ASN1Object)v1);
        }

        return v1.toASN1Primitive();
    }

    ASN1Primitive getBaseUniversal(boolean arg3, ASN1UniversalType arg4) {
        if(arg3) {
            if(this.isExplicit()) {
                return arg4.checkedCast(this.obj.toASN1Primitive());
            }

            throw new IllegalStateException("object implicit - explicit expected.");
        }

        if(1 != this.explicitness) {
            ASN1Primitive v3 = this.obj.toASN1Primitive();
            int v0 = this.explicitness;
            if(v0 != 3) {
                if(v0 != 4) {
                    return arg4.checkedCast(v3);
                }

                if((v3 instanceof ASN1Sequence)) {
                    return arg4.fromImplicitConstructed(((ASN1Sequence)v3));
                }

                return arg4.fromImplicitPrimitive(((DEROctetString)v3));
            }

            return arg4.fromImplicitConstructed(this.rebuildConstructed(v3));
        }

        throw new IllegalStateException("object explicit - implicit expected.");
    }

    public ASN1Primitive getBaseUniversal(boolean arg2, int arg3) {
        ASN1UniversalType v0 = ASN1UniversalTypes.get(arg3);
        if(v0 != null) {
            return this.getBaseUniversal(arg2, v0);
        }

        throw new IllegalArgumentException("unsupported UNIVERSAL tag number: " + arg3);
    }

    public ASN1Object getExplicitBaseObject() {
        if(this.isExplicit()) {
            ASN1Encodable v1 = this.obj;
            if((v1 instanceof ASN1Object)) {
                return ((ASN1Object)v1);
            }

            return v1.toASN1Primitive();
        }

        throw new IllegalStateException("object implicit - explicit expected.");
    }

    public ASN1TaggedObject getExplicitBaseTagged() {
        if(this.isExplicit()) {
            return ASN1TaggedObject.checkedCast(this.obj.toASN1Primitive());
        }

        throw new IllegalStateException("object implicit - explicit expected.");
    }

    public ASN1TaggedObject getImplicitBaseTagged(int arg3, int arg4) {
        if(arg3 != 0 && (arg3 & 0xC0) == arg3) {
            int v0 = this.explicitness;
            if(v0 == 1) {
                throw new IllegalStateException("object explicit - implicit expected.");
            }
            else if(v0 != 2) {
                return this.replaceTag(arg3, arg4);
            }
            else {
                return ASN1Util.checkTag(ASN1TaggedObject.checkedCast(this.obj.toASN1Primitive()), arg3, arg4);
            }
        }

        throw new IllegalArgumentException("invalid base tag class: " + arg3);
    }

    public static ASN1TaggedObject getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ASN1TaggedObject)) {
            }
            else {
                if((arg3 instanceof ASN1Encodable)) {
                    ASN1Primitive v0 = arg3.toASN1Primitive();
                    if((v0 instanceof ASN1TaggedObject)) {
                        return ((ASN1TaggedObject)v0);
                    }
                }
                else if((arg3 instanceof byte[])) {
                    try {
                        return ASN1TaggedObject.checkedCast(ASN1TaggedObject.fromByteArray(((byte[])arg3)));
                    }
                    catch(IOException v3) {
                        throw new IllegalArgumentException("failed to construct tagged object from byte[]: " + v3.getMessage());
                    }
                }

                throw new IllegalArgumentException("unknown object in getInstance: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public static ASN1TaggedObject getInstance(Object arg0, int arg1) {
        return ASN1Util.checkTagClass(ASN1TaggedObject.checkInstance(arg0), arg1);
    }

    public static ASN1TaggedObject getInstance(Object arg0, int arg1, int arg2) {
        return ASN1Util.checkTag(ASN1TaggedObject.checkInstance(arg0), arg1, arg2);
    }

    public static ASN1TaggedObject getInstance(ASN1TaggedObject arg0, int arg1, int arg2, boolean arg3) {
        return ASN1Util.getExplicitBaseTagged(ASN1TaggedObject.checkInstance(arg0, arg3), arg1, arg2);
    }

    public static ASN1TaggedObject getInstance(ASN1TaggedObject arg0, int arg1, boolean arg2) {
        return ASN1Util.getExplicitBaseTagged(ASN1TaggedObject.checkInstance(arg0, arg2), arg1);
    }

    public static ASN1TaggedObject getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return ASN1Util.getExplicitContextBaseTagged(ASN1TaggedObject.checkInstance(arg0, arg1));
    }

    public final ASN1Primitive getLoadedObject() {
        return this;
    }

    public static ASN1TaggedObject getOptional(ASN1Encodable arg1) {
        if(arg1 != null) {
            if((arg1 instanceof ASN1TaggedObject)) {
                return arg1;
            }

            return null;
        }

        throw new NullPointerException("\'element\' cannot be null");
    }

    public static ASN1TaggedObject getOptional(ASN1Encodable arg0, int arg1) {
        ASN1TaggedObject v0 = ASN1TaggedObject.getOptional(arg0);
        if(v0 != null && (v0.hasTagClass(arg1))) {
            return v0;
        }

        return null;
    }

    public static ASN1TaggedObject getOptional(ASN1Encodable arg0, int arg1, int arg2) {
        ASN1TaggedObject v0 = ASN1TaggedObject.getOptional(arg0);
        if(v0 != null && (v0.hasTag(arg1, arg2))) {
            return v0;
        }

        return null;
    }

    public int getTagClass() {
        return this.tagClass;
    }

    public int getTagNo() {
        return this.tagNo;
    }

    public boolean hasContextTag() {
        if(this.tagClass == 0x80) {
            return 1;
        }

        return 0;
    }

    public boolean hasContextTag(int arg3) {
        if(this.tagClass == 0x80 && this.tagNo == arg3) {
            return 1;
        }

        return 0;
    }

    public boolean hasTag(int arg2, int arg3) {
        if(this.tagClass == arg2 && this.tagNo == arg3) {
            return 1;
        }

        return 0;
    }

    public boolean hasTagClass(int arg1) {
        if(this.tagClass == arg1) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        int v0 = this.tagClass * 0x1EEF ^ this.tagNo;
        int v1 = this.isExplicit() ? 15 : 0xF0;
        return this.obj.toASN1Primitive().hashCode() ^ (v0 ^ v1);
    }

    public boolean isExplicit() {
        int v2 = this.explicitness;
        if(v2 != 1 && v2 != 3) {
            return 0;
        }

        return 1;
    }

    boolean isParsed() {
        int v1 = this.explicitness;
        if(v1 != 3 && v1 != 4) {
            return 0;
        }

        return 1;
    }

    public ASN1Encodable parseBaseUniversal(boolean arg1, int arg2) throws IOException {
        ASN1Primitive v0 = this.getBaseUniversal(arg1, arg2);
        if(arg2 != 3) {
            if(arg2 != 4) {
                if(arg2 != 16) {
                    if(arg2 != 17) {
                        return ((ASN1Encodable)v0);
                    }

                    return ((ASN1Set)v0).parser();
                }

                return ((ASN1Sequence)v0).parser();
            }

            return ((ASN1OctetString)v0).parser();
        }

        return ((ASN1BitString)v0).parser();
    }

    public ASN1Encodable parseExplicitBaseObject() throws IOException {
        return this.getExplicitBaseObject();
    }

    public ASN1TaggedObjectParser parseExplicitBaseTagged() throws IOException {
        return this.getExplicitBaseTagged();
    }

    public ASN1TaggedObjectParser parseImplicitBaseTagged(int arg1, int arg2) throws IOException {
        return this.getImplicitBaseTagged(arg1, arg2);
    }

    abstract ASN1Sequence rebuildConstructed(ASN1Primitive arg1);

    abstract ASN1TaggedObject replaceTag(int arg1, int arg2);

    ASN1Primitive toDERObject() {
        return new DERTaggedObject(this.explicitness, this.tagClass, this.tagNo, this.obj);
    }

    ASN1Primitive toDLObject() {
        return new DLTaggedObject(this.explicitness, this.tagClass, this.tagNo, this.obj);
    }

    public String toString() {
        return ASN1Util.getTagText(this.tagClass, this.tagNo) + this.obj;
    }
}

