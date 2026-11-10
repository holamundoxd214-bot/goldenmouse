package org.bouncycastle.asn1.isismtt.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1PrintableString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.DirectoryString;

public class ProfessionInfo extends ASN1Object {
    public static final ASN1ObjectIdentifier Notar;
    public static final ASN1ObjectIdentifier Notariatsverwalter;
    public static final ASN1ObjectIdentifier Notariatsverwalterin;
    public static final ASN1ObjectIdentifier Notarin;
    public static final ASN1ObjectIdentifier Notarvertreter;
    public static final ASN1ObjectIdentifier Notarvertreterin;
    public static final ASN1ObjectIdentifier Patentanwalt;
    public static final ASN1ObjectIdentifier Patentanwltin;
    public static final ASN1ObjectIdentifier Rechtsanwalt;
    public static final ASN1ObjectIdentifier Rechtsanwltin;
    public static final ASN1ObjectIdentifier Rechtsbeistand;
    public static final ASN1ObjectIdentifier Steuerberater;
    public static final ASN1ObjectIdentifier Steuerberaterin;
    public static final ASN1ObjectIdentifier Steuerbevollmchtigte;
    public static final ASN1ObjectIdentifier Steuerbevollmchtigter;
    public static final ASN1ObjectIdentifier VereidigteBuchprferin;
    public static final ASN1ObjectIdentifier VereidigterBuchprfer;
    public static final ASN1ObjectIdentifier Wirtschaftsprfer;
    public static final ASN1ObjectIdentifier Wirtschaftsprferin;
    private ASN1OctetString addProfessionInfo;
    private NamingAuthority namingAuthority;
    private ASN1Sequence professionItems;
    private ASN1Sequence professionOIDs;
    private String registrationNumber;

    static {
        ProfessionInfo.Rechtsanwltin = new ASN1ObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".1");
        ProfessionInfo.Rechtsanwalt = new ASN1ObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".2");
        ProfessionInfo.Rechtsbeistand = new ASN1ObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".3");
        ProfessionInfo.Steuerberaterin = new ASN1ObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".4");
        ProfessionInfo.Steuerberater = new ASN1ObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".5");
        ProfessionInfo.Steuerbevollmchtigte = new ASN1ObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".6");
        ProfessionInfo.Steuerbevollmchtigter = new ASN1ObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".7");
        ProfessionInfo.Notarin = new ASN1ObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".8");
        ProfessionInfo.Notar = new ASN1ObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".9");
        ProfessionInfo.Notarvertreterin = new ASN1ObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".10");
        ProfessionInfo.Notarvertreter = new ASN1ObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".11");
        ProfessionInfo.Notariatsverwalterin = new ASN1ObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".12");
        ProfessionInfo.Notariatsverwalter = new ASN1ObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".13");
        ProfessionInfo.Wirtschaftsprferin = new ASN1ObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".14");
        ProfessionInfo.Wirtschaftsprfer = new ASN1ObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".15");
        ProfessionInfo.VereidigteBuchprferin = new ASN1ObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".16");
        ProfessionInfo.VereidigterBuchprfer = new ASN1ObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".17");
        ProfessionInfo.Patentanwltin = new ASN1ObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".18");
        ProfessionInfo.Patentanwalt = new ASN1ObjectIdentifier(NamingAuthority.id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern + ".19");
    }

    private ProfessionInfo(ASN1Sequence arg4) {
        super();
        if(arg4.size() <= 5) {
            Enumeration v4 = arg4.getObjects();
            Object v0 = v4.nextElement();
            if((v0 instanceof ASN1TaggedObject)) {
                if(((ASN1TaggedObject)v0).getTagNo() == 0) {
                    this.namingAuthority = NamingAuthority.getInstance(((ASN1TaggedObject)v0), true);
                    v0 = v4.nextElement();
                }
                else {
                    throw new IllegalArgumentException("Bad tag number: " + ((ASN1TaggedObject)v0).getTagNo());
                }
            }

            this.professionItems = ASN1Sequence.getInstance(v0);
            String v1 = "Bad object encountered: ";
            if(v4.hasMoreElements()) {
                v0 = v4.nextElement();
                if((v0 instanceof ASN1Sequence)) {
                    this.professionOIDs = ASN1Sequence.getInstance(v0);
                }
                else if((v0 instanceof ASN1PrintableString)) {
                    this.registrationNumber = ASN1PrintableString.getInstance(v0).getString();
                }
                else if((v0 instanceof ASN1OctetString)) {
                    this.addProfessionInfo = ASN1OctetString.getInstance(v0);
                }
                else {
                    throw new IllegalArgumentException(v1 + v0.getClass());
                }
            }

            if(v4.hasMoreElements()) {
                v0 = v4.nextElement();
                if((v0 instanceof ASN1PrintableString)) {
                    this.registrationNumber = ASN1PrintableString.getInstance(v0).getString();
                }
                else if((v0 instanceof DEROctetString)) {
                    this.addProfessionInfo = ((ASN1OctetString)v0);
                }
                else {
                    throw new IllegalArgumentException(v1 + v0.getClass());
                }
            }

            if(v4.hasMoreElements()) {
                Object v4_1 = v4.nextElement();
                if((v4_1 instanceof DEROctetString)) {
                    this.addProfessionInfo = ((ASN1OctetString)v4_1);
                    return;
                }

                throw new IllegalArgumentException(v1 + v4_1.getClass());
            }

            return;
        }

        throw new IllegalArgumentException("Bad sequence size: " + arg4.size());
    }

    public ProfessionInfo(NamingAuthority arg1, DirectoryString[] arg2, ASN1ObjectIdentifier[] arg3, String arg4, ASN1OctetString arg5) {
        super();
        this.namingAuthority = arg1;
        this.professionItems = new DERSequence(((ASN1Encodable[])arg2));
        if(arg3 != null) {
            this.professionOIDs = new DERSequence(((ASN1Encodable[])arg3));
        }

        this.registrationNumber = arg4;
        this.addProfessionInfo = arg5;
    }

    public ASN1OctetString getAddProfessionInfo() {
        return this.addProfessionInfo;
    }

    public static ProfessionInfo getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ProfessionInfo)) {
            }
            else if((arg3 instanceof ASN1Sequence)) {
                return new ProfessionInfo(((ASN1Sequence)arg3));
            }
            else {
                throw new IllegalArgumentException("illegal object in getInstance: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public NamingAuthority getNamingAuthority() {
        return this.namingAuthority;
    }

    public DirectoryString[] getProfessionItems() {
        DirectoryString[] v0 = new DirectoryString[this.professionItems.size()];
        Enumeration v4 = this.professionItems.getObjects();
        int v1;
        for(v1 = 0; v4.hasMoreElements(); ++v1) {
            v0[v1] = DirectoryString.getInstance(v4.nextElement());
        }

        return v0;
    }

    public ASN1ObjectIdentifier[] getProfessionOIDs() {
        ASN1Sequence v0 = this.professionOIDs;
        int v1 = 0;
        if(v0 == null) {
            return new ASN1ObjectIdentifier[0];
        }

        ASN1ObjectIdentifier[] v0_1 = new ASN1ObjectIdentifier[v0.size()];
        Enumeration v4 = this.professionOIDs.getObjects();
        while(v4.hasMoreElements()) {
            v0_1[v1] = ASN1ObjectIdentifier.getInstance(v4.nextElement());
            ++v1;
        }

        return v0_1;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(5);
        if(this.namingAuthority != null) {
            v0.add(new DERTaggedObject(true, 0, this.namingAuthority));
        }

        v0.add(this.professionItems);
        ASN1Sequence v1 = this.professionOIDs;
        if(v1 != null) {
            v0.add(((ASN1Encodable)v1));
        }

        if(this.registrationNumber != null) {
            v0.add(new DERPrintableString(this.registrationNumber, true));
        }

        ASN1OctetString v5 = this.addProfessionInfo;
        if(v5 != null) {
            v0.add(((ASN1Encodable)v5));
        }

        return new DERSequence(v0);
    }
}

