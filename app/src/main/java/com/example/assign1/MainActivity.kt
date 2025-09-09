package com.example.assign1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assign1.ui.theme.Assign1Theme
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assign1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column (modifier = Modifier.padding(top= 10.dp)) {
                        var name = "Alice Han"
                        var email by remember { mutableStateOf("alicehan@bu.edu") }
                        var personal by remember {mutableStateOf(false)}
                        NameAndEmail(name, email, modifier = Modifier.padding(innerPadding))
                        Button(onClick = { email = if (personal) {"alicehan@bu.edu"} else {"alicehan8@gmail.com" }; personal = !personal}) {
                            Text(text = if (personal) {"Get school email"} else {"Get personal email"})
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun NameAndEmail(name: String, email: String, modifier: Modifier = Modifier) {
    Text(
        text = "Name: $name \nEmail: $email",
        modifier = modifier
    )
}

@Composable
fun ButtonClick() {
    Text(text = "\nyou clicked a button!!!!")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Column (modifier = Modifier.padding(top= 10.dp)) {
        Assign1Theme {
            Greeting("Android")
            var name = "Alice Han"
            var email by remember { mutableStateOf("alicehan@bu.edu") }
            NameAndEmail(name, email)
            Button(onClick = {email = "alicehan8@gmail.com"}){
                Text(text = "Get personal email")
            }
        }
    }
}