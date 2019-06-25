package co.com.project.scp.exceptions;

public enum ExceptionMessages {

    EXCEPTION_INVALID_DOCUMENT_NUMBER("Numero de documento Invalido"),


    EXCEPTION_AL_BUSCAR_ELEMENTO("No se encontro el elemento"),
    EXCP_OS_UNSOPORTED("Sistema operativo no soportado"),
	EXCEPTION_AL_CERRAR_INGRESO_CLAVE("No cerro sesion en ingreso clave"),
	EXCEPTION_AL_HACER_SCROLL("Error al hacer el scroll"),
	EXCEPTION_AL_OCULTAR_TECLADO("Error al ocultar el teclado"),
	EXCEPTION_AL_REFRESCAR_PANTALLA("Error al refrescar la pantalla"),
	EXCEPTION_AL_SELECCIONAR_UN_MES("Error al convertir numero de mes a nombre"),
	EXCEPTION_AL_SELECCIONAR_UN_TIPO_DOCUMENTO("Error al completar el numero de documento para IOS"),
	EXCEPTION_ERRORAL_PRESIONAR_BOTON("Error al presionar un boton"),
	EXCEPTION_ERROR_LEER_ARCHIVO("Error al abrir el archivo"),
    EXCEPTION_NO_CREATE_DRIVER("Error al crear el driver"),
    EXCEPTION_NO_SE_ENCONTRO_PLATAFORMA("Error al encontar la plataforma a ejecutar");

    private final String mensaje;

    private ExceptionMessages(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return this.mensaje;
    }

}
