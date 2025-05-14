package com.example.parcial1_josehernandez_pedrolucero

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.parcial1_josehernandez_pedrolucero.ui.theme.Parcial1_JoseHernandez_PedroLuceroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Parcial1_JoseHernandez_PedroLuceroTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = Color(0xFFCCD5AE)
                    ){
                        Nota()
                }
            }
        }
    }
}

@Composable
fun Nota() {
    var calificacion by remember { mutableStateOf("") }
    val context = LocalContext.current


    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text(
            text = "Parcial #1",
            style =MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "Pedro Lucero",
            style =MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "José Hernandez",
            style =MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "Ingrese la nota a validar",
            style =MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value =calificacion,
            onValueChange ={calificacion = it},
            label ={Text("Calificacion")}
        )
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick ={
                val cal =calificacion.toFloatOrNull()
                if(cal != null && cal >= 91 && cal <= 100){
                    Toast.makeText(context, "A (Excelente)", Toast.LENGTH_SHORT).show()
                }else if (cal != null && cal >= 81 && cal <= 90){
                    Toast.makeText(context, "B (Bueno)", Toast.LENGTH_SHORT).show()
                }else if (cal != null && cal >= 71 && cal <= 80){
                    Toast.makeText(context, "C (Regular)", Toast.LENGTH_SHORT).show()
                }else if (cal != null && cal >= 61 && cal <= 70){
                    Toast.makeText(context, "D (Mas o menos regular)", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context, "No Aprobado", Toast.LENGTH_SHORT).show()
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF344E41))
        ){
            Text("Obtener Resultado")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotaPreview() {
    Parcial1_JoseHernandez_PedroLuceroTheme {
        Nota()
    }
}