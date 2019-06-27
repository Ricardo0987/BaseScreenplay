package co.com.project.scp.exceptions;

public enum ExceptionMessages {

    EXCP_OS_UNSOPORTED("Sistema operativo no soportado"),
    EXCEPTION_NO_SE_ENCONTRO_PLATAFORMA("Error al encontar la plataforma a ejecutar");

    private final String mensaje;

    private ExceptionMessages(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return this.mensaje;
    }

}
