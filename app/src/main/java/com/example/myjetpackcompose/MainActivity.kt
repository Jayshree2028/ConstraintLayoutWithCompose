package com.example.myjetpackcompose

import android.R
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myjetpackcompose.ui.theme.MYJETPACKCOMPOSETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginForm();
        }
    }

    @Composable
    fun LoginForm() {

        var username by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        Surface {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp)
            ) {
                Text(
                    text = "\tHello, \n Welcome to the login Page.",
                    fontSize = 25.sp,
                    color = Color.Blue,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 50.dp, 0.dp, 0.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(value = username,
                    onValueChange = {
                        username = it
                    },
                    leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Person") },
                    label = {
                        Text(text = "username")
                    })
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(value = password, onValueChange = {
                    password = it
                },
                    leadingIcon = { Icon(Icons.Default.Info, contentDescription = "password") },
                    label = {
                        Text(text = "Password")
                    })
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { },

                    ) {
                    Text(text = "Login")

                }

            }
        }

    }

    @Preview(showSystemUi = true, showBackground = true)
    @Composable
    fun LoginPreview() {
        LoginForm()
    }
}
