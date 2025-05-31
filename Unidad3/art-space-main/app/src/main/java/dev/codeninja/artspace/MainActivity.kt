package dev.codeninja.artspace

// Importa las clases necesarias de Android y Jetpack Compose
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.codeninja.artspace.ui.theme.ArtSpaceTheme

// Define la actividad principal que extiende ComponentActivity
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		// Establece el contenido de la actividad usando Jetpack Compose
		setContent {
			// Aplica el tema personalizado de la app
			ArtSpaceTheme {
				// Crea un contenedor Surface con el color de fondo del tema
				Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
					// Muestra la pantalla principal
					ArtSpaceScreen()
				}
			}
		}
	}
}

// Función composable que representa la pantalla principal
@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
	// Referencias a los recursos de imagen (drawables)
	val firstArtwork = R.drawable.denji_face
	val secondArtwork = R.drawable.zero_two_face
	val thirdArtwork = R.drawable.sanji_face
	val fourthArtwork = R.drawable.naruto_face

	// Estado para el título actual (referencia a un recurso string)
	var title by remember {
		mutableStateOf(R.string.denji)
	}

	// Estado para el año actual (referencia a un recurso string)
	var year by remember {
		mutableStateOf(R.string.denji_year)
	}

	// Estado para la imagen actual (referencia drawable)
	var currentArtwork by remember {
		mutableStateOf(firstArtwork)
	}

	// Estado duplicado (innecesario) para el recurso de imagen
	var imageResource by remember {
		mutableStateOf(currentArtwork)
	}

	// Contenedor en columna, centrado horizontalmente
	Column(
		modifier = modifier
			.fillMaxWidth(), // La columna ocupa todo el ancho disponible
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		// Muestra la imagen actual
		ArtworkDisplay(currentArtwork = currentArtwork)

		// Espaciado entre elementos
		Spacer(modifier = modifier.size(16.dp))

		// Muestra el título y año de la obra
		ArtworkTitle(title = title, year = year)

		// Más espacio entre elementos
		Spacer(modifier = modifier.size(25.dp))

		// Fila que contiene los botones "Previous" y "Next"
		Row(
			modifier = modifier.padding(horizontal = 8.dp),
			horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
		) {
			// Botón "Previous" para retroceder en la galería
			Button(
				onClick = {
					// Lógica para cambiar a la imagen anterior
					when (currentArtwork) {
						firstArtwork -> {
							currentArtwork = fourthArtwork
							title = R.string.naruto
							year = R.string.naruto_year
						}
						secondArtwork -> {
							currentArtwork = firstArtwork
							title = R.string.denji
							year = R.string.denji_year
						}
						thirdArtwork -> {
							currentArtwork = secondArtwork
							title = R.string.zero_two
							year = R.string.zero_two_year
						}
						else -> {
							currentArtwork = thirdArtwork
							title = R.string.sanji
							year = R.string.sanji_year
						}
					}
				},
				// Colores personalizados del botón
				colors = ButtonDefaults.buttonColors(
					backgroundColor = colorResource(id = R.color.gray_900)
				),
				// Elevación del botón en diferentes estados
				elevation = ButtonDefaults.elevation(
					defaultElevation = 1.dp,
					pressedElevation = 0.dp,
					focusedElevation = 0.dp
				)
			) {
				// Texto dentro del botón "Previous"
				Text(
					text = "Previous",
					fontSize = 16.sp,
					fontWeight = FontWeight.Medium,
					color = colorResource(id = R.color.blue_300)
				)
			}

			// Botón "Next" para avanzar en la galería
			Button(
				onClick = {
					// Lógica para cambiar a la siguiente imagen
					when (currentArtwork) {
						firstArtwork -> {
							currentArtwork = secondArtwork
							title = R.string.zero_two
							year = R.string.zero_two_year
						}
						secondArtwork -> {
							currentArtwork = thirdArtwork
							title = R.string.sanji
							year = R.string.sanji_year
						}
						thirdArtwork -> {
							currentArtwork = fourthArtwork
							title = R.string.naruto
							year = R.string.naruto_year
						}
						else -> {
							currentArtwork = firstArtwork
							title = R.string.denji
							year = R.string.denji_year
						}
					}
				},
				// Colores personalizados del botón
				colors = ButtonDefaults.buttonColors(
					backgroundColor = colorResource(id = R.color.blue_300)
				),
				// Elevación del botón en diferentes estados
				elevation = ButtonDefaults.elevation(
					defaultElevation = 1.dp,
					pressedElevation = 0.dp,
					focusedElevation = 0.dp
				)
			) {
				// Texto dentro del botón "Next"
				Text(
					text = "Next",
					fontSize = 16.sp,
					fontWeight = FontWeight.Medium,
					color = colorResource(id = R.color.gray_900)
				)
			}
		}
	}
}

// Composable que muestra la imagen actual
@Composable
fun ArtworkDisplay(
	modifier: Modifier = Modifier,
	@DrawableRes currentArtwork: Int // Recurso drawable de la imagen actual
) {
	Image(
		painter = painterResource(currentArtwork), // Carga la imagen del recurso
		contentDescription = stringResource(id = R.string.zero_two), // Descripción accesible (puede mejorarse dinámicamente)
		modifier = modifier.fillMaxWidth(), // La imagen ocupa todo el ancho
		contentScale = ContentScale.FillWidth // Escala la imagen para ajustarse al ancho
	)
}

// Composable que muestra el título y año de la obra
@Composable
fun ArtworkTitle(
	@StringRes title: Int, // Recurso de string para el título
	@StringRes year: Int   // Recurso de string para el año
) {
	Column (
		horizontalAlignment = Alignment.CenterHorizontally // Centra el contenido
	) {
		// Texto del título de la obra
		Text(
			text = stringResource(id = title), // Obtiene el string desde recursos
			fontWeight = FontWeight.Bold,
			color = colorResource(id = R.color.blue_100),
			fontSize = 32.sp
		)

		// Texto del año de la obra
		Text(
			text = "— ${stringResource(id = year)} —", // Año con guiones decorativos
			fontSize = 16.sp,
			fontWeight = FontWeight.Medium,
			color = colorResource(id = R.color.gray_300)
		)
	}
}

// Vista previa del componente ArtSpaceScreen en el editor
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	ArtSpaceTheme {
		ArtSpaceScreen()
	}
}
