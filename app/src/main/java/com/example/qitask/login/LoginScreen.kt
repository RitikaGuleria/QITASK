package com.example.qitask.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.qitask.R
import com.example.qitask.TransparentTextField
import com.example.qitask.ui.theme.QITASKTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


@Composable
fun LoginScreen(navHostController: NavHostController?)
{
    val emailValue= rememberSaveable{ mutableStateOf("") }
    val passwordValue= rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val focusManager= LocalFocusManager.current


    Column(modifier= Modifier.fillMaxHeight())
    {
        TopAppBar(navHostController)
        Card(shape = RoundedCornerShape(65.dp),modifier= Modifier.padding(8.dp))
        {
            Column(modifier = Modifier.padding(26.dp))
            {
                Text(text = "SignIn into your",
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp)
                Text(text = "Account",
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp)
                Spacer(modifier = Modifier.height(38.dp))

                Text(text = "Email",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp)
                TransparentTextField(textFieldValue = emailValue,
                    textLabel = "johndoe@gmail.com",
                    keyboardType = KeyboardType.Email,
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    ),
                    imeAction = ImeAction.Next,
                    trailingIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icons.Default.Message
                        }
                    }
                )


                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Password",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp)
                TransparentTextField(textFieldValue = passwordValue,
                    textLabel = "Password",
                    keyboardType = KeyboardType.Password,
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                        }
                    ),
                    imeAction = ImeAction.Done,
                    trailingIcon = {
                        IconButton(onClick = { passwordVisibility = !passwordVisibility })
                        {
                            Icon(imageVector = if (passwordVisibility) {
                                Icons.Default.Visibility
                            } else {
                                Icons.Default.VisibilityOff
                            },
                                contentDescription = "toggle password icon")
                        }
                    },
                    visualTransformation = if (passwordVisibility) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    }
                )
                Text(text = "forget password ?",
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(top = 6.dp),
                    color = Color.Red,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold)
                Text(text = "Login with", fontSize = 16.sp, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp))


                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.align(Alignment.CenterHorizontally))
                {
                    Image(painter = painterResource(id = R.drawable.google), contentDescription = "")
                    Image(painter = painterResource(id = R.drawable.ff), contentDescription = "")

                }

                Row(Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp)) {
                    Text(text = "Don't have an account?", color = Color.Gray, fontSize = 16.sp)
                    Text(text = " Register now",modifier= Modifier.clickable { navHostController?.navigate("register") }, color = Color.Red, fontSize = 16.sp)
                }
            }
        }

        Card(shape = RoundedCornerShape(65.dp), modifier= Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(50.dp))
        {
            Button(onClick = {navHostController?.navigate("homescreen") },colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)) {
                Text(text = "LOG IN", fontSize = 18.sp, color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QITASKTheme {
        LoginScreen(null)
    }
}