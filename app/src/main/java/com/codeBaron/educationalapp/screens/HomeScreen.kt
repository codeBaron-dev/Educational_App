@file:OptIn(ExperimentalMaterial3Api::class)

package com.codeBaron.educationalapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codeBaron.educationalapp.R
import com.codeBaron.educationalapp.navigation.BottomNav
import com.codeBaron.educationalapp.ui.theme.EducationalAppTheme
import com.codeBaron.educationalapp.ui.theme.Purple40

/**
 * @author Anyanwu Nicholas
 * @Note This project was developed with "JUST UI in MIND" in mind, somethings with
 * done with real-world best practice(s).
 */

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    var searchText by remember { mutableStateOf("") }
    Scaffold(
        bottomBar = { BottomNav() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.category),
                        contentDescription = "image description",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .offset(x = 0.dp, y = 0.dp)
                            .width(39.81281.dp)
                            .height(39.81281.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.undraw_male_avatar),
                        contentDescription = "image description",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .offset(x = 0.dp, y = 0.dp)
                            .width(39.81281.dp)
                            .height(39.81281.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Hello, Habibah",
                    fontSize = 24.sp,
                    style = MaterialTheme.typography.bodyLarge,
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "What do you want to learn?",
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(30.dp))

                OutlinedTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = { Text(text = "Search....") },
                    shape = RoundedCornerShape(8.dp),
                    textStyle = MaterialTheme.typography.bodyLarge,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Purple40,
                        unfocusedBorderColor = Purple40
                    ),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.outline_search_24),
                            contentDescription = "Search Icon",
                            tint = Color.Gray
                        )
                    }
                )

                Spacer(modifier = Modifier.height(10.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(143.76848.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Purple40
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "New Course!",
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White
                            )
                            Text(
                                text = "User Experience Class",
                                style = MaterialTheme.typography.bodyLarge,
                                color = Color.White
                            )

                            Card(
                                modifier = Modifier
                                    .width(75.69458.dp)
                                    .height(26.84729.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color(0xBFC983DE)
                                )
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "View now",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = Color.White
                                    )
                                }
                            }
                        }

                        Image(
                            painter = painterResource(id = R.drawable.remote_work),
                            contentDescription = "image description",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .width(168.dp)
                                .height(102.89655.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Course",
                        fontSize = 24.sp,
                        style = MaterialTheme.typography.bodyLarge,
                    )

                    Text(
                        text = "View all",
                        fontSize = 14.sp,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Gray
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "All",
                        fontSize = 14.sp,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Gray
                    )

                    Card(
                        modifier = Modifier
                            .width(75.69458.dp)
                            .height(26.84729.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Purple40
                        )
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Design",
                                fontSize = 14.sp,
                                style = MaterialTheme.typography.bodyLarge,
                                color = Color.White
                            )
                        }
                    }

                    Text(
                        text = "Programming",
                        fontSize = 14.sp,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Gray
                    )

                    Text(
                        text = "UI/UX",
                        fontSize = 14.sp,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Gray
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(25.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(110.59113.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(size = 17.69458.dp)
                        )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.camera_layout),
                        contentDescription = "image description",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .padding(0.dp)
                            .width(68.56651.dp)
                            .height(68.56651.dp)
                    )

                    Column {
                        Text(
                            text = "Photoshop Course",
                            fontSize = 14.sp,
                            style = MaterialTheme.typography.bodyLarge,
                        )

                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Row {
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_star_24),
                                    contentDescription = "image description",
                                    contentScale = ContentScale.FillBounds,
                                )

                                Text(
                                    text = "4.6",
                                    fontSize = 14.sp,
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = Color.Gray
                                )
                            }

                            Row {
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_access_time_filled_24),
                                    contentDescription = "image description",
                                    contentScale = ContentScale.FillBounds,
                                )

                                Text(
                                    text = "10h 30m",
                                    fontSize = 14.sp,
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = Color.Gray
                                )
                            }
                        }
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(25.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(110.59113.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(size = 17.69458.dp)
                        )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cube),
                        contentDescription = "image description",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .padding(0.dp)
                            .width(68.56651.dp)
                            .height(68.56651.dp)
                    )

                    Column {
                        Text(
                            text = "3D Design",
                            fontSize = 14.sp,
                            style = MaterialTheme.typography.bodyLarge,
                        )

                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Row {
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_star_24),
                                    contentDescription = "image description",
                                    contentScale = ContentScale.FillBounds,
                                )

                                Text(
                                    text = "4.6",
                                    fontSize = 14.sp,
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = Color.Gray
                                )
                            }

                            Row {
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_access_time_filled_24),
                                    contentDescription = "image description",
                                    contentScale = ContentScale.FillBounds,
                                )

                                Text(
                                    text = "10h 30m",
                                    fontSize = 14.sp,
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = Color.Gray
                                )
                            }
                        }
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(25.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(110.59113.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(size = 17.69458.dp)
                        )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.camera_layout),
                        contentDescription = "image description",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .padding(0.dp)
                            .width(68.56651.dp)
                            .height(68.56651.dp)
                    )

                    Column {
                        Text(
                            text = "Virtual Reality Course",
                            fontSize = 14.sp,
                            style = MaterialTheme.typography.bodyLarge,
                        )

                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Row {
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_star_24),
                                    contentDescription = "image description",
                                    contentScale = ContentScale.FillBounds,
                                )

                                Text(
                                    text = "4.6",
                                    fontSize = 14.sp,
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = Color.Gray
                                )
                            }

                            Row {
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_access_time_filled_24),
                                    contentDescription = "image description",
                                    contentScale = ContentScale.FillBounds,
                                )

                                Text(
                                    text = "10h 30m",
                                    fontSize = 14.sp,
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = Color.Gray
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    EducationalAppTheme {
        HomeScreen()
    }
}