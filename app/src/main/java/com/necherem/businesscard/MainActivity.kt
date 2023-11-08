package com.necherem.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.necherem.businesscard.ui.theme.BusinessCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Body(
                        fullName ="Kay Necherem",
                        title = "Android Developer Extraordinaire",
                        phoneNumber = "+234 (0) 813 413 2644",
                        socialMediaHandle = "@kaynecherem",
                        emailAddress = "kaynecherem@gmail.com"
                    )                }
            }
        }
    }
}

@Composable
fun Body(fullName: String, title: String, phoneNumber: String, emailAddress: String, socialMediaHandle: String, modifier : Modifier = Modifier){
    Column (
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFD2E8D4))
    ){
        Labels(
            fullName = fullName,
            title = title
        )
        ContactInfo(
            phoneNumber = phoneNumber,
            socialMediaHandle = socialMediaHandle,
            emailAddress = emailAddress,
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Body(
            fullName ="Kay Necherem",
            title = "Android Developer Extraordinaire",
            phoneNumber = "+234 (0) 813 413 2644",
            socialMediaHandle = "@kaynecherem",
            emailAddress = "kaynecherem@gmail.com"
        )
    }
}

@Composable
fun Labels(fullName: String, title: String, modifier : Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Column(
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Box {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .background(color = Color(0xFF073042))
                    .height(150.dp)
                    .width(150.dp)
            )
        }
        Text(
            text = fullName,
            fontWeight = FontWeight.Light,
            textAlign = TextAlign.Center,
            color = Color(0xFF111913),
            fontSize = 40.sp,
            modifier = Modifier
        )
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF278052),
            modifier = Modifier
                .align(alignment = CenterHorizontally)
        )
    }
}

@Composable
fun ContactInfo(phoneNumber: String, socialMediaHandle: String, emailAddress: String, modifier: Modifier = Modifier ) {
    Column {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center){
            Icon(
                Icons.Filled.Phone,
                contentDescription = null,
                tint = Color(0xFF278052),
                modifier = Modifier
                        .size(16.dp)
            )
            Spacer(Modifier.size(10.dp))
            Text(
                text = phoneNumber,
                color = Color(0xFF111913),
                fontSize = 16.sp
            )
        }
        Spacer(Modifier.size(10.dp))
        Row {
            Icon(
                Icons.Filled.Share,
                contentDescription = null,
                tint = Color(0xFF278052),
                modifier = Modifier
                    .size(16.dp)
            )
            Spacer(Modifier.size(10.dp))
            Text(
                text = socialMediaHandle,
                color = Color(0xFF111913),
                fontSize = 16.sp
            )
        }
        Spacer(Modifier.size(10.dp))
        Row {
            Icon(
                Icons.Filled.Email,
                contentDescription = null,
                tint = Color(0xFF278052),
                modifier = Modifier
                    .size(16.dp)
            )
            Spacer(Modifier.size(10.dp))
            Text(
                text = emailAddress,
                color = Color(0xFF111913),
                fontSize = 16.sp
            )
        }
    }


}