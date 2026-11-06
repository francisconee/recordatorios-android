package cl.ipp.recordatorios.domain

data class Categoria(val nombre: String)

sealed class Prioridad(val nombre: String) {
    object Alta : Prioridad("Alta")
    object Media : Prioridad("Media")
    object Baja : Prioridad("Baja")
}

sealed class EstadoRecordatorio(val nombre: String) {
    object Pendiente : EstadoRecordatorio("Pendiente")
    object Completado : EstadoRecordatorio("Completado")
    object Vencido : EstadoRecordatorio("Vencido")
}

data class Recordatorio(
    val id: Int,
    val titulo: String,
    val categoria: Categoria,
    val prioridad: Prioridad,
    val estado: EstadoRecordatorio,
    val descripcion: String? = null,
    val fechaLimite: String? = null,
    val ubicacion: String? = null
) {
    init {
        require(titulo.isNotBlank()) { "El título es obligatorio" }
        require(titulo.length >= 4) { "El título debe tener al menos 4 caracteres" }
    }
}