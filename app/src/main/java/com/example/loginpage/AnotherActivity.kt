package com.example.loginpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginpage.ui.theme.LoginPageTheme

class AnotherActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginPageTheme {

                    Surface(color=MaterialTheme.colorScheme.background) {
//                        DisplayImg()

                        Column(horizontalAlignment = Alignment.CenterHorizontally){
                            DisplayImg()
                        }
//                        Column(horizontalAlignment = Alignment.CenterHorizontally){
//                            DisplayImg()
//
//                        }
                    }
                }
            }
        }
    }

@Composable
fun DisplayImg(){
//    var scrollState= rememberScrollState()

    Column(//modifier = Modifier.verticalScroll(state = scrollState)
            modifier = Modifier
//            .fillMaxWidth()
            .fillMaxSize()
        .padding(10.dp)
        .verticalScroll(state = ScrollState(8)),
       horizontalAlignment = Alignment.Start) {

        Row() {
 
            //LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = 2.sp)
            MyImage()
            MyImage()
            MyImage()
            // ProductGrid()
            // LazyVerticalGrid(columns = GridCells.Fixed(2)){
            // items(3){
            //           MyImage()
            //         }
            //  }
        }
        Row() {
            MyImage()
            MyImage()
            MyImage()
        }

        Row() {
            MyImage()
            MyImage()
            MyImage()
        }
        Row() {
            MyImage()
            MyImage()
            MyImage()
        }
        Row() {
            MyImage()
            MyImage()
            MyImage()
        }
        Row() {
            MyImage()
            MyImage()
            MyImage()
        }
        Row() {
            MyImage()
            MyImage()
            MyImage()
        }
        Row() {
            MyImage()
            MyImage()
            MyImage()
        }
        Row() {
            MyImage()
            MyImage()
            MyImage()
        }
        Row() {
            MyImage()
            MyImage()
            MyImage()
        }
    }

}

@Composable
fun MyImage(){
    //Text(text = "Hello")
    Image(painter = painterResource(id = R.drawable.candles),
        contentDescription = "Image",
        modifier = Modifier
            .padding(2.dp)
            .width(120.dp)
            .height(120.dp)
            .clip(RoundedCornerShape(16.dp))  // .clip(RoundedCornerShape(16.dp)) or clip(CutCornerShape(16.dp))   or .clip(androidx.compose.foundation.shape.CircleShape)

            .border(2.dp, Color.Gray, shape = RoundedCornerShape(16.dp)),// or .border(2.dp,Color.Gray, shape = CutCornerShape(16.dp)) or .border(2.dp,Color.Gray, shape = androidx.compose.foundation.shape.CircleShape)
//            .border(2.dp, Color.Red,shape)
//            .clip(CircleShape)
//            .padding(top = 100.dp, bottom = 15.dp),

        contentScale = ContentScale.FillWidth,  //Total Circle then  use like  contentScale = ContentScale.Crop in CircleShape
    //        alpha = .2f   // It is Using Image Blur


    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductGrid(){

}
@Preview(showBackground =true, widthDp = 390, heightDp = 800)
@Composable
fun DefaultPreview(){
    LoginPageTheme {
        DisplayImg()
//        Column{
//            MyImage()
//            MyImage()
//
//        }
    }
}


