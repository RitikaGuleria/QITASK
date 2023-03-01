package com.example.qitask.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.R
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.qitask.TransparentTextField
import com.example.qitask.ui.theme.QITASKTheme

@Composable
fun RegisterationScreen(navHostController: NavHostController?)
{
    val nameValue= rememberSaveable{ mutableStateOf("")}
    val emailValue= rememberSaveable{ mutableStateOf("") }
    val contactValue= rememberSaveable{ mutableStateOf("")}
    val passwordValue= rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val focusManager= LocalFocusManager.current
    val checkedState= remember { mutableStateOf(false)}
    var expanded by remember {
        mutableStateOf(false)
    }

    Column(modifier= Modifier.wrapContentHeight())
    {
        TopAppBar(navHostController)

        Card(shape = RoundedCornerShape(55.dp), modifier = Modifier.padding(2.dp))
        {
            Column(modifier = Modifier.padding(26.dp))
            {
                Text(text = "Create an",
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp)
                Text(text = "Account",
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp)
                Spacer(modifier = Modifier.height(14.dp))

                Text(text = "Name",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp)
                TransparentTextField(textFieldValue = nameValue,
                    textLabel = "John Doe",
                    keyboardType = KeyboardType.Text,
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    ),
                    imeAction = ImeAction.Next,
                    trailingIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icons.Default.Person
                        }
                    })
                Spacer(modifier = Modifier.height(6.dp))


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

                Spacer(modifier = Modifier.height(6.dp))
                Text(text = "Contact No.",color=Color.Black, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Row()
                {
                    Image(painter = painterResource(id = com.example.qitask.R.drawable.i), contentDescription = "",modifier=Modifier.size(50.dp))
                    Text(text = "IN",color=Color.Black, fontSize = 18.sp, modifier=Modifier.padding(top=12.dp,bottom=12.dp,end=8.dp))
                    Text(text = "+91",color=Color.Black,fontSize=18.sp, modifier=Modifier.padding(top=12.dp,bottom=12.dp))
                    Image(imageVector = if(expanded) Icons.Filled.ArrowDropUp else Icons.Filled.ArrowDropDown, contentDescription = "",modifier=Modifier.padding(top=12.dp,bottom=12.dp,end=8.dp))
                    TransparentTextField(textFieldValue = contactValue,
                        textLabel = "7876056231",
                        keyboardType = KeyboardType.Number,
                        keyboardActions = KeyboardActions(onNext = {focusManager.moveFocus(
                            FocusDirection.Down)}),
                        imeAction = ImeAction.Next,
                        trailingIcon = { IconButton(onClick = { /*TODO*/ }) {
                            Icons.Default.Call
                        }}
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))
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

                Spacer(modifier = Modifier.height(0.dp))
                Row(modifier=Modifier.align(Alignment.CenterHorizontally)) {
                    Checkbox(checked =checkedState.value , onCheckedChange = {checkedState.value=it},modifier=Modifier.wrapContentSize(Alignment.Center))
                    Text(text = "I agree with ",color=Color.Black, fontWeight = FontWeight.Bold, fontSize = 17.sp,modifier=Modifier.padding(top=10.dp))
                    Text(text = "terms and condition",color=Color.Red, textDecoration = TextDecoration.Underline, fontWeight = FontWeight.Bold, fontSize = 17.sp,modifier=Modifier.padding(top=10.dp))
                }

                Spacer(modifier = Modifier.height(0.dp))
                Row(modifier=Modifier.align(Alignment.CenterHorizontally)) {
                    Text(text = "Already have an account? ",color=Color.Gray, fontWeight = FontWeight.Bold, fontSize = 16.sp,modifier=Modifier.padding(top=10.dp))
                    Text(text = "Sign in!",color=Color.Red, fontWeight = FontWeight.Bold, fontSize = 16.sp,modifier= Modifier
                        .padding(top = 10.dp)
                        .clickable { navHostController?.navigate("login") })
                }

                Spacer(modifier = Modifier.height(0.dp))
                Card(shape = RoundedCornerShape(65.dp), modifier= Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .height(50.dp))
                {
                    Button(onClick = { navHostController?.navigate("homescreen") },colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)) {
                        Text(text = "REGISTER", fontSize = 12.sp, color = Color.White)
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    QITASKTheme() {
        RegisterationScreen(null)
    }
}