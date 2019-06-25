package co.com.project.scp.model.enums;

public enum DocumentType {


    CC("CC - Cédula ciudadanía", 0),
    IEPJ("IEPJ - Id extranjero PJ no residente en Colombia", 1),
    RC("RC - Registro civil", 2),
    FD("FD - Fideicomiso", 3),
    PAS("PAS - Pasaporte", 4),
    NIT("NIT - NIT", 5),
    CE("CE - Cèdula extranjería", 6),
    TI("TI - Tarjeta de identidad", 7),
    IEPN("IEPN - Id del extranjero PN no residente en Colombia", 8),
    CD("CD - Carnet diplomático", 9);

    private final String documentTypeName;
    private final int indexSelectOption;

    DocumentType(final String documentTypeName, final int indexSelectOption) {
        this.documentTypeName = documentTypeName;
        this.indexSelectOption = indexSelectOption;
    }

    public String getDocumentTypeName() {
        return documentTypeName;
    }

    public int getIndexSelectOption() {
        return indexSelectOption;
    }


}

