package com.brandyodhiambo.quench.views.screens.settings

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brandyodhiambo.quench.R
import com.brandyodhiambo.quench.views.ui.theme.blackColor
import com.brandyodhiambo.quench.views.ui.theme.primaryColor
import com.ramcosta.composedestinations.annotation.Destination

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun SettingScreen() {
  Scaffold(
      backgroundColor = primaryColor
  ) { paddingValues ->
      Box(
          modifier = Modifier
              .fillMaxSize()
              .padding(paddingValues)
      ){
          LazyColumn{
              item {
                UnitsWaterIntake()
              }
              item {
                  Goals()
              }
              item {
                  ReminderWaterIntake()
              }
          }
      }
  }
}

@Composable
fun UnitsWaterIntake() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 16.dp, end = 16.dp)
        ,
        elevation = 4.dp
    ){
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Water Unit",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = blackColor
                    )

                }
                Text(
                    text = "ml",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = primaryColor
                )
            }
            Divider(modifier = Modifier
                .height(1.dp)
                .padding(start = 8.dp, end = 8.dp), color = Color.Gray, thickness = 1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Weight Unit",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = blackColor
                    )

                }
                Text(
                    text = "Kg",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = primaryColor
                )
            }
            Divider(modifier = Modifier
                .height(1.dp)
                .padding(start = 8.dp, end = 8.dp), color = Color.Gray, thickness = 1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Time Formate",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = blackColor
                    )

                }
                Text(
                    text = "12 hours",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = primaryColor
                )
            }
            Divider(modifier = Modifier
                .height(1.dp)
                .padding(start = 8.dp, end = 8.dp), color = Color.Gray, thickness = 1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Date Format",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = blackColor
                    )

                }
                Text(
                    text = "dd/mm/yy",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = primaryColor
                )
            }
        }
    }
}

@Composable
fun ReminderWaterIntake() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
        ,
        elevation = 4.dp
    ){
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Reminder Schedule",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = blackColor
                    )

                }
                Image(painter = painterResource(id = R.drawable.ic_chevron_right), contentDescription = null)

            }
            Divider(modifier = Modifier
                .height(1.dp)
                .padding(start = 8.dp, end = 8.dp), color = Color.Gray, thickness = 1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Reminder Sound",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = blackColor
                    )

                }
                Image(painter = painterResource(id = R.drawable.ic_chevron_right), contentDescription = null)

            }
            Divider(modifier = Modifier
                .height(1.dp)
                .padding(start = 8.dp, end = 8.dp), color = Color.Gray, thickness = 1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Reminder Mode",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = blackColor
                    )

                }
                Image(painter = painterResource(id = R.drawable.ic_chevron_right), contentDescription = null)

            }
            Divider(modifier = Modifier
                .height(1.dp)
                .padding(start = 8.dp, end = 8.dp), color = Color.Gray, thickness = 1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Reminder",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = blackColor
                    )

                }
               Image(painter = painterResource(id = R.drawable.ic_chevron_right), contentDescription = null)
            }
        }
    }
}

@Composable
fun Goals() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 16.dp, end = 16.dp)
        ,
        elevation = 4.dp
    ){
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Gender",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = blackColor
                    )

                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Male",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = primaryColor
                    )
                    Image(painter = painterResource(id = R.drawable.ic_chevron_right), contentDescription = null)
                }
            }
            Divider(modifier = Modifier
                .height(1.dp)
                .padding(start = 8.dp, end = 8.dp), color = Color.Gray, thickness = 1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Intake Goal",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = blackColor
                    )

                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "2400ml",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = primaryColor
                    )
                    Image(painter = painterResource(id = R.drawable.ic_chevron_right), contentDescription = null)
                }
            }
            Divider(modifier = Modifier
                .height(1.dp)
                .padding(start = 8.dp, end = 8.dp), color = Color.Gray, thickness = 1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Language",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = blackColor
                    )

                }
               Row(
                   verticalAlignment = Alignment.CenterVertically,
                   horizontalArrangement = Arrangement.SpaceBetween
               ) {
                   Text(
                       text = "English",
                       fontSize = 16.sp,
                       fontWeight = FontWeight.SemiBold,
                       color = primaryColor
                   )
                   Image(painter = painterResource(id = R.drawable.ic_chevron_right), contentDescription = null)
               }
            }
        }
    }
}