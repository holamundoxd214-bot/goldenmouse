package org.bouncycastle.asn1.isismtt.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1IA5String;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.isismtt.ISISMTTObjectIdentifiers;
import org.bouncycastle.asn1.x500.DirectoryString;

public class NamingAuthority extends ASN1Object {
    public static final ASN1ObjectIdentifier id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern;
    private ASN1ObjectIdentifier namingAuthorityId;
    private DirectoryString namingAuthorityText;
    private String namingAuthorityUrl;

    static {
        NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern = new ASN1ObjectIdentifier(ISISMTTObjectIdentifiers.id_isismtt_at_namingAuthorities + ".1");
    }

    public NamingAuthority(ASN1ObjectIdentifier arg1, String arg2, DirectoryString arg3) {
        super();
        this.namingAuthorityId = arg1;
        this.namingAuthorityUrl = arg2;
        this.namingAuthorityText = arg3;
    }

    private NamingAuthority(ASN1Sequence arg4) {
        Object v0;
        super();
        if(arg4.size() <= 3) {
            Enumeration v4 = arg4.getObjects();
            String v1 = "Bad object encountered: ";
            if(v4.hasMoreElements()) {
                v0 = v4.nextElement();
                if((v0 instanceof ASN1ObjectIdentifier)) {
                    this.namingAuthorityId = ((ASN1ObjectIdentifier)v0);
                }
                else if((v0 instanceof ASN1IA5String)) {
                    this.namingAuthorityUrl = ASN1IA5String.getInstance(v0).getString();
                }
                else if((v0 instanceof ASN1String)) {
                    this.namingAuthorityText = DirectoryString.getInstance(v0);
                }
                else {
                    throw new IllegalArgumentException(v1 + v0.getClass());
                }
            }

            if(v4.hasMoreElements()) {
                v0 = v4.nextElement();
                if((v0 instanceof ASN1IA5String)) {
                    this.namingAuthorityUrl = ASN1IA5String.getInstance(v0).getString();
                }
                else if((v0 instanceof ASN1String)) {
                    this.namingAuthorityText = DirectoryString.getInstance(v0);
                }
                else {
                    throw new IllegalArgumentException(v1 + v0.getClass());
                }
            }

            if(v4.hasMoreElements()) {
                Object v4_1 = v4.nextElement();
                if((v4_1 instanceof ASN1String)) {
                    this.namingAuthorityText = DirectoryString.getInstance(v4_1);
                    return;
                }

                throw new IllegalArgumentException(v1 + v4_1.getClass());
            }

            return;
        }

        throw new IllegalArgumentException("Bad sequence size: " + arg4.size());
    }

    public static NamingAuthority getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return NamingAuthority.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public static NamingAuthority getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof NamingAuthority)) {
            }
            else if((arg3 instanceof ASN1Sequence)) {
                return new NamingAuthority(((ASN1Sequence)arg3));
            }
            else {
                throw new IllegalArgumentException("illegal object in getInstance: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public ASN1ObjectIdentifier getNamingAuthorityId() {
        return this.namingAuthorityId;
    }

    public DirectoryString getNamingAuthorityText() {
        return this.namingAuthorityText;
    }

    public String getNamingAuthorityUrl() {
        return this.namingAuthorityUrl;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        ASN1ObjectIdentifier v1 = this.namingAuthorityId;
        if(v1 != null) {
            v0.add(((ASN1Encodable)v1));
        }

        if(this.namingAuthorityUrl != null) {
            v0.add(new DERIA5String(this.namingAuthorityUrl, true));
        }

        DirectoryString v4 = this.namingAuthorityText;
        if(v4 != null) {
            v0.add(((ASN1Encodable)v4));
        }

        return new DERSequence(v0);
    }
}

