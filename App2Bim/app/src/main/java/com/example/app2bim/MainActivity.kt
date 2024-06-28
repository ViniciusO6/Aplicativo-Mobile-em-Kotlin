package com.example.app2bim

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app2bim.ui.theme.App2BimTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App2BimTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { App(navController) }
        composable("produto1") { Produto1() }
        composable("produto2") { Produto2() }
        composable("produto3") { Produto3() }
        composable("produto4") { Produto4() }
        composable("produto5") { Produto5() }
    }
}

@Composable
fun App(navController: NavController) {
    var iconeCasa = painterResource(R.drawable.casa)
    var iconePerfil = painterResource(R.drawable.a_perfil)
    var iconeCarrinho = painterResource(R.drawable.carrinho_de_compras)
    var iconeImage1 = painterResource(R.drawable.arduino)
    var iconeImage2 = painterResource(R.drawable.bra_o_robotico)
    var iconeImage3 = painterResource(R.drawable.rele)
    var iconeImage4 = painterResource(R.drawable.sensor)
    var iconeImage5 = painterResource(R.drawable.chassi)

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ){

        Row(
            Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .height(80.dp), // Modificadores primeiro
            verticalAlignment = Alignment.CenterVertically




        ){
            Spacer(modifier = Modifier.width(10.dp));
            Column(){
                Image(
                    painter = iconeCasa,
                    contentDescription = null,
                    Modifier
                        .size(30.dp)
                )

            }

            Spacer(Modifier.weight(1f))

            Row(){
                Image(
                    painter = iconePerfil,
                    contentDescription = null,
                    Modifier
                        .size(28.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Image(
                    painter = iconeCarrinho,
                    contentDescription = null,
                    Modifier
                        .size(30.dp)
                )
            }
        }

        LazyColumn {
            items(1) {
                Anuncio(iconeImage1, "Placa Uno Rev3 R3 Atmega328 Smd + Cabo Usb + Pinos", "R$ 30,00", "produto1", navController)
                Anuncio(iconeImage2, "Kit Braço Robótico Acrílico 4 Servos Parafusos Arduino", "R$ 123,00", "produto2", navController)
                Anuncio(iconeImage3, "Driver Motor Ponte H Dupla L298n Arduino Pic Automação", "R$ 27,55", "produto3", navController)
                Anuncio(iconeImage4, "Módulo Sensor Ultrassonico Hc Sr04 Arduino Pic Raspberry", "R$ 14,90", "produto4", navController)
                Anuncio(iconeImage5, "Kit Chassi 2wd Rodas Carro Smart Car Robô Projeto Arduino", "R$ 59,95", "produto5", navController)
            }
        }
    }
}

@Composable
fun Anuncio(imagem: Painter, titulo: String = "", preco: String = "",  rota: String = "", navController: NavController)
{
    Row (
        Modifier
            .padding(top = 30.dp)
            .padding(bottom = 10.dp)
    ){
        Row (
            Modifier
                .fillMaxWidth()
                .background(Color.White)
                .height(200.dp)
                .padding(start = 10.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically



        ){
            Image(

                contentScale = ContentScale.Crop,
                painter = imagem,
                contentDescription = null,
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp),

                )

            Column(modifier = Modifier.padding(start = 10.dp)) {

                Text(
                    titulo,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .padding(start = 10.dp)
                )


                Text(
                    preco,
                    fontSize = 25.sp,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .padding(start = 10.dp)

                )

                Button(
                    onClick = { navController.navigate(rota) },
                    modifier = Modifier
                        .width(120.dp)
                        .padding(start = 6.dp)
                ) {
                    Text(
                        text = "Comprar",
                    )
                }
            }
        }
    }
    Row(
        Modifier
            .fillMaxWidth()
            .height(3.dp)
            .background(Color(0xFFFFFFDDDDDD))
    ) {

    }
}

@Composable
fun produto(imagem: Painter, titulo: String = "", preco: String = "", preco2: String = ""){
    var iconeCasa = painterResource(R.drawable.casa)
    var iconePerfil = painterResource(R.drawable.a_perfil)
    var iconeCarrinho = painterResource(R.drawable.carrinho_de_compras)

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .height(80.dp), // Modificadores primeiro
            verticalAlignment = Alignment.CenterVertically


        ) {
            Spacer(modifier = Modifier.width(10.dp));

            Column() {
                Image(
                    painter = iconeCasa,
                    contentDescription = null,
                    Modifier
                        .size(30.dp)
                )

            }

            Spacer(Modifier.weight(1f))

            Row(

            ) {
                Image(
                    painter = iconePerfil,
                    contentDescription = null,
                    Modifier
                        .size(28.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Image(
                    painter = iconeCarrinho,
                    contentDescription = null,
                    Modifier
                        .size(30.dp)
                )
            }
        }
            Row(
                Modifier
                    .height(20.dp)
            ) {

            }
            Row(
                Modifier
                    .width(350.dp)
                    .align(Alignment.CenterHorizontally),
                Arrangement.Center
            ) {
                Text(
                    titulo,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 23.sp,
                    modifier = Modifier
                )
            }
            Row(
                Modifier
                    .height(20.dp)
            ) {

            }
        Row(

            Modifier
                .fillMaxWidth()
                .height(350.dp)
                .background(Color.Black),
                Arrangement.Center

        ) {
            Image(
                contentScale = ContentScale.Crop,
                painter = imagem,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        Column(
            Modifier
                .background(Color.White)
                .fillMaxWidth()
                .height(100.dp)
                .padding(top = 20.dp)
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(40.dp)
            ) {
                Text(
                    preco,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 0.dp)
                        .padding(start = 10.dp)
                        .padding(top = 0.dp)
                )
            }
            Row(

            ) {
                Text(
                    preco2,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(bottom = 0.dp)
                        .padding(start = 12.dp)
                        .padding(top = 0.dp)
                )
            }

        }
        Button(onClick = {

        },
            Modifier
                .padding(top = 8.dp)
                .padding(start = 8.dp)
                .padding(end = 8.dp)
                .height(50.dp)
                .fillMaxWidth()
        ) {
            Text("Comprar",
            fontSize = 25.sp,)
            Modifier
                .padding(start = 10.dp)
        }
    }
}

@Composable
fun Produto1() {
    produto(painterResource(R.drawable.arduino), "Placa Uno Rev3 R3 Atmega328 Smd + Cabo Usb + Pinos", "R$ 30,00", "12x de R$ 2,50")
}

@Composable
fun Produto2() {
    produto(painterResource(R.drawable.bra_o_robotico), "Kit Braço Robótico Acrílico 4 Servos Parafusos Arduino", "R$ 123,00", "12x de R$ 10,30")
}

@Composable
fun Produto3() {
    produto(painterResource(R.drawable.rele), "Driver Motor Ponte H Dupla L298n Arduino Pic Automação", "R$ 27,55", "12x de R$ 2,30")
}

@Composable
fun Produto4() {
    produto(painterResource(R.drawable.sensor), "Módulo Sensor Ultrassonico Hc Sr04 Arduino Pic Raspberry", "R$ 14,90", "12x de R$ 1,25")
}

@Composable
fun Produto5() {
    produto(painterResource(R.drawable.chassi), "Kit Chassi 2wd Rodas Carro Smart Car Robô Projeto Arduino", "R$ 59,95", "12x de R$ 4,99")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App2BimTheme {
        AppNavigation()
    }
}