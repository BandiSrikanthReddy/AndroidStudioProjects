package com.example.loginpage

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.R
import com.example.loginpage.ui.theme.LoginPageTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            LoginPageTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login()
                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Button(onClick = {
                            var Navigate=Intent(this@MainActivity,AnotherActivity::class.java)
                            startActivity(Navigate);
                        }, modifier = Modifier.fillMaxWidth()) {
                            Text(text = "Navigate", fontSize = 18.sp)
                        }
                    }

                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Login(){
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var isErrorInUsername by remember {
        mutableStateOf(false)
    }

    Box(modifier=Modifier.fillMaxSize()) {
//        Image(painter = painterResource(id = androidx.core.R.drawable.notification_template_icon_low_bg),
//            contentDescription = "Login",
//            modifier = Modifier
//                .fillMaxSize()
//                .blur(6.dp),
//            contentScale = ContentScale.Crop
//        )
        //Hi- add in New Comment
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp)
                .alpha(0.6f)
                .clip(
                    CutCornerShape(
                        topStart = 8.dp,
                        topEnd = 16.dp,
                        bottomStart = 16.dp,
                        bottomEnd = 8.dp
                    )
                )
                .background(MaterialTheme.colorScheme.background)
        )
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround) {

            LoginHeader()
            Spacer(modifier = Modifier.height(8.dp))
            LoginFields(username,
                password,
                onUsernameChange = {
                    username=it
                    //isErrorInUsername=Patterns.EMAIL_ADDRESS.matcher(username).matches().not()
                },
                onPasswordChange = {
                    password=it
                },
                onForgotPasswordClick = {
                    //Here we can write code to link

                }
            )
            LoginFooter(
                onSignInClick = {},
                onSignUpClick = {}
            )
        }
    }
}
@Composable
fun LoginHeader(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Welcome Back",
            fontSize = 36.sp,
            fontWeight = FontWeight.ExtraBold)
        Text(text="Sign in to continue",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold)
    }
}

@Composable
fun LoginFields(username:String,password:String,
                            onUsernameChange:(String)->Unit,onPasswordChange:(String)->Unit,
                            onForgotPasswordClick:()->Unit){

    Column {
        //Spacer(modifier = Modifier.height(8.dp))
        ReusableField(value = username,
            label = "UserName",
            placeholder = "Enter your Email address",
            onValueChange = onUsernameChange,
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = "Email")
            }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next)

        )


        Spacer(modifier = Modifier.height(8.dp))

        ReusableField(value = password,
            label = "Password",
            placeholder = "Enter your password",
            onValueChange = onPasswordChange,
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Icon(Icons.Default.Lock , contentDescription = "Password")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Go)
        )

        TextButton(onClick = onForgotPasswordClick,
            //{var Navigate=Intent(this@MainActivity,AnotherActivity::class.java)
             //   startActivity(Navigate);}
                    modifier = Modifier.align(Alignment.End)) {
            Text(text = "Forgot Password?")
        }
    }

}

@Composable
fun LoginFooter(
    onSignInClick:()->Unit,
    onSignUpClick:()->Unit
){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = onSignInClick, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Sign In")
        }
        TextButton(onClick = onSignUpClick) {
            Text(text = "Don't have an account, click here")
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReusableField(value:String,
              label:String,
              placeholder:String,
              visualTransformation: VisualTransformation=VisualTransformation.None,
              keyboardOptions: KeyboardOptions=KeyboardOptions.Default,
              leadingIcon:@Composable (() -> Unit)?=null,
              trailingIcon: @Composable (() -> Unit)?=null,
              onValueChange:(String)-> Unit)//,supportingText:Boolean)
{


    OutlinedTextField(value = value, onValueChange = onValueChange,
        label = {Text(text = label)},
        placeholder = { Text(text = placeholder)},
        visualTransformation=visualTransformation,
        keyboardOptions=keyboardOptions,
        leadingIcon=leadingIcon,
        trailingIcon=trailingIcon)
        //supportingText = {
          //  if(supportingText){
            //    Text(text = "Enter a Valid email address")
          //  }
       // })



}