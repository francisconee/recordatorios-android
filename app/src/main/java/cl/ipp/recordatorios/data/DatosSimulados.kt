package cl.ipp.recordatorios.data

import cl.ipp.recordatorios.domain.Categoria
import cl.ipp.recordatorios.domain.EstadoRecordatorio
import cl.ipp.recordatorios.domain.Prioridad
import cl.ipp.recordatorios.domain.Recordatorio

object DatosSimulados {
    val trabajo = Categoria("Trabajo")
    val estudio = Categoria("Estudio")
    val hogar = Categoria("Hogar")
    val salud = Categoria("Salud")

    val recordatorios: List<Recordatorio> = listOf(
        Recordatorio(1, "Entregar Actividad 1", estudio, Prioridad.Alta, EstadoRecordatorio.Pendiente, fechaLimite = "05-11-2026"),
        Recordatorio(2, "Pagar cuenta de la luz", hogar, Prioridad.Alta, EstadoRecordatorio.Pendiente, descripcion = "Pagar por la app del banco"),
        Recordatorio(3, "Reunión de equipo", trabajo, Prioridad.Media, EstadoRecordatorio.Completado),
        Recordatorio(4, "Comprar arena para los gatos", hogar, Prioridad.Baja, EstadoRecordatorio.Pendiente, ubicacion = "Supermercado"),
        Recordatorio(5, "Pedir hora al dentista", salud, Prioridad.Media, EstadoRecordatorio.Vencido, fechaLimite = "31-10-2026"),
        Recordatorio(6, "Estudiar", estudio, Prioridad.Baja, EstadoRecordatorio.Completado)
    )

    val categorias: Set<Categoria> = recordatorios.map { it.categoria }.toSet()

    val colorPorCategoria: Map<Categoria, Long> = mapOf(
        trabajo to 0xFF1E88E5,
        estudio to 0xFF8E24AA,
        hogar to 0xFF43A047,
        salud to 0xFFE53935
    )

    fun filtrarPorEstado(estado: EstadoRecordatorio): List<Recordatorio> =
        recordatorios.filter { it.estado == estado }

    fun filtrarPorPrioridad(prioridad: Prioridad): List<Recordatorio> =
        recordatorios.filter { it.prioridad == prioridad }
}