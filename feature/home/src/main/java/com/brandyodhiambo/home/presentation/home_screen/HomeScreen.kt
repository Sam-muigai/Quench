package com.brandyodhiambo.home.presentation.home_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.brandyodhiambo.common.R
import com.brandyodhiambo.common.domain.model.GoalWaterIntake
import com.brandyodhiambo.common.domain.model.IdealWaterIntake
import com.brandyodhiambo.common.domain.model.SelectedDrink
import com.brandyodhiambo.common.presentation.component.WaterIntakeDialog
import com.brandyodhiambo.designsystem.components.CircularButton
import com.brandyodhiambo.designsystem.theme.lightBlue
import com.brandyodhiambo.designsystem.theme.primaryColor
import com.brandyodhiambo.designsystem.theme.roboto
import com.brandyodhiambo.home.presentation.component.CircularRating
import com.brandyodhiambo.home.presentation.component.IdealIntakeGoalDialog
import com.brandyodhiambo.home.presentation.component.SelectDrinkComposable
import com.brandyodhiambo.home.presentation.component.TimeSetterDialog
import com.ramcosta.composedestinations.annotation.Destination

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val openTimeDialog = remember { mutableStateOf(false) }
    val openGoalDialog = remember { mutableStateOf(false) }
    val idealWaterIntakeDialog = remember { mutableStateOf(false) }
    val selectedDrinkDialog = remember { mutableStateOf(false) }

    // to be changed to selectedDrinks
    val waterleveltime = listOf(
        Intake("100 Ml", "12:30 Pm"),
        Intake("300 Ml", "18:30 Pm"),
        Intake("250 Ml", "11:30 Pm"),
        Intake("150 Ml", "19:30 Pm")
    )
    Scaffold(
        backgroundColor = primaryColor
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyColumn {
                item {
                    WaterIntake(
                        openGoalDialog = openGoalDialog,
                        idealWaterIntakeDialog = idealWaterIntakeDialog,
                        viewModel = viewModel
                    )
                }
                item {
                    WaterRecord(
                        openDialog = openTimeDialog,
                        selectedDrinkDialog = selectedDrinkDialog
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(8.dp))
                }
                items(waterleveltime) { intake ->
                    WaterIntakeTimeAndLevel(intake = intake)
                }
            }

            if (openTimeDialog.value) {
                Dialog(onDismissRequest = { openTimeDialog.value }) {
                   TimeSetterDialog(openDialogCustom = openTimeDialog)
                    // CongratulationsDialog(openDialogCustom = openTimeDialog)
                }
            }

            if (openGoalDialog.value) {
                Dialog(onDismissRequest = { openGoalDialog.value }) {
                    WaterIntakeDialog(
                        openCustomDialog = openGoalDialog,
                        currentWaterIntakeText = viewModel.goalWaterIntakeValue.value,
                        currentWaterIntakeFormText = viewModel.goalWaterForm.value,
                        onCurrentWaterIntakeTextChange = {
                            viewModel.setGoalWaterIntakeValue(it)
                        },
                        onCurrentWaterIntakeFormTextChange = {
                            viewModel.setGoalWaterForm(it)
                        },
                        onOkayClick = {
                            val goalWaterIntakeToInsert = GoalWaterIntake(
                                waterIntake = viewModel.goalWaterIntakeValue.value.toInt(),
                                form = viewModel.goalWaterForm.value
                            )
                            viewModel.insertGoalWaterIntake(goalWaterIntakeToInsert)
                        }
                    )
                }
            }

            if (idealWaterIntakeDialog.value) {
                Dialog(onDismissRequest = { idealWaterIntakeDialog.value }) {
                    IdealIntakeGoalDialog(
                        idealCustomDialog = idealWaterIntakeDialog,
                        currentIdealIntakeText = viewModel.idealWaterIntakeValue.value ,
                        currentIdealIntakeFormText = viewModel.idealWaterForm.value,
                        onCurrentIdealIntakeTextChange = {
                            viewModel.setIdealWaterIntakeValue(it)
                        },
                        onCurrentIdealIntakeFormTextChange = {
                            viewModel.setIdealWaterForm(it)
                        },
                        onOkayClick = {
                            val idealWaterIntakeToInsert = IdealWaterIntake(
                                waterIntake = viewModel.idealWaterIntakeValue.value.toInt(),
                                form = viewModel.idealWaterForm.value
                            )
                            viewModel.insertIdealWaterIntake(idealWaterIntakeToInsert)
                        }
                    )
                }
            }

            if (selectedDrinkDialog.value) {
                Dialog(onDismissRequest = { selectedDrinkDialog.value }) {
                    SelectDrinkComposable(
                        openDialog = selectedDrinkDialog,
                        onCurrentSelectedDrinkTime = {
                            viewModel.setSelectedTime(it)
                        },
                        onCurrentSelectedDrinkIcon = {
                            viewModel.setSelectedIcon(it)
                        },
                        onCurrentSelectedDrinkSize = {
                            viewModel.setSize(it)
                        },
                        onClick = {
                            viewModel.insertSelectedDrink(
                                SelectedDrink(
                                    drinkValue = viewModel.size.value,
                                    icon = viewModel.selectedIcon.value,
                                    time = viewModel.selectedTime.value
                                )
                            )
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun WaterIntake(
    openGoalDialog: MutableState<Boolean>,
    idealWaterIntakeDialog: MutableState<Boolean>,
    viewModel: HomeViewModel
) {
    val idealWaterIntake = viewModel.idealWaterIntakeFromDb.observeAsState()
    val waterIntake = idealWaterIntake.value?.waterIntake ?: 0
    val form = idealWaterIntake.value?.form ?: "ml"

    val goalWaterIntakeFromDb = viewModel.goalWaterIntakeFromDb.observeAsState()
    val goalWaterIntake = goalWaterIntakeFromDb.value?.waterIntake ?: 0
    val goalForm = goalWaterIntakeFromDb.value?.form ?: "ml"
    Card(
        modifier = Modifier
            .height(100.dp)
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_glass),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable {
                        idealWaterIntakeDialog.value = true
                    }
                ) {
                    Text(text = "Ideal water intake", fontSize = 14.sp, color = Color.Gray,fontFamily = roboto)
                    Text(
                        text = "$waterIntake $form",
                        fontSize = 16.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold,
                        fontFamily = roboto
                    )
                }
            }
            Divider(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(2.dp),
                thickness = 2.dp,
                color = primaryColor
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.ic_cup), contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable {
                        openGoalDialog.value = true
                    }
                ) {
                    Text(
                        text = "Water intake goal",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        fontFamily = roboto
                    )
                    Text(
                        text = "$goalWaterIntake $goalForm",
                        fontSize = 16.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold,
                        fontFamily = roboto
                    )
                }
            }
        }
    }
}

@Composable
fun WaterRecord(
    openDialog: MutableState<Boolean>,
    selectedDrinkDialog: MutableState<Boolean>,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
            .padding(start = 16.dp, end = 16.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            val per = 2400f/800f
            CircularRating(percentage = per, drunk = 800, goal = 2400)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CircularButton(
                    backgroundColor = lightBlue,
                    icon = R.drawable.ic_clock,
                    title = "12:04 AM",
                    onClick = {
                        openDialog.value = true
                    }
                )
                CircularButton(
                    backgroundColor = lightBlue,
                    icon = R.drawable.ic_glass,
                    title = "Add Level",
                    onClick = {
                        // Todo
                    }
                )
                CircularButton(
                    backgroundColor = lightBlue,
                    icon = R.drawable.ic_glass,
                    title = "100 Ml",
                    onClick = {
                        selectedDrinkDialog.value = true
                    }
                )
            }
        }
    }
}

@Composable
fun WaterIntakeTimeAndLevel(
    intake: Intake
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_glass),
                    contentDescription = null
                )
                Text(text = intake.level, fontFamily = roboto, fontSize = 16.sp, fontWeight = FontWeight.W400)
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = intake.time,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontFamily = roboto,
                    fontWeight = FontWeight.W300
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_chevron),
                        tint = Color.Gray,
                        contentDescription = null
                    )
                }
            }
        }
        Divider(
            thickness = 1.dp,
            color = Color.Gray
        )
    }
}

data class Intake(
    val level: String,
    val time: String
)
