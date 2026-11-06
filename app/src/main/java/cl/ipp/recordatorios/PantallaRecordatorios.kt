package cl.ipp.recordatorios

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cl.ipp.recordatorios.data.DatosSimulados
import cl.ipp.recordatorios.domain.EstadoRecordatorio
import cl.ipp.recordatorios.domain.Prioridad
import cl.ipp.recordatorios.domain.Recordatorio
import cl.ipp.recordatorios.ui.theme.RecordatoriosTheme

@Composable
fun PantallaRecordatorios(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = stringResource(R.string.titulo_pantalla),
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = stringResource(
                R.string.resumen,
                DatosSimulados.recordatorios.size,
                DatosSimulados.categorias.size,
                DatosSimulados.filtrarPorEstado(EstadoRecordatorio.Pendiente).size,
                DatosSimulados.filtrarPorPrioridad(Prioridad.Alta).size
            )
        )
        DatosSimulados.recordatorios.forEach { recordatorio ->
            TarjetaRecordatorio(recordatorio)
        }
    }
}

@Composable
fun TarjetaRecordatorio(recordatorio: Recordatorio) {
    val colorCategoria = Color(DatosSimulados.colorPorCategoria[recordatorio.categoria] ?: 0xFF757575)

    Card(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = recordatorio.titulo,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = recordatorio.categoria.nombre,
                color = Color.White,
                modifier = Modifier
                    .background(colorCategoria, RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            )
            Text(stringResource(R.string.prioridad, recordatorio.prioridad.nombre))
            Text(stringResource(R.string.estado, recordatorio.estado.nombre))
            recordatorio.fechaLimite?.let {
                Text(stringResource(R.string.fecha_limite, it))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaRecordatoriosPreview() {
    RecordatoriosTheme {
        PantallaRecordatorios()
    }
}