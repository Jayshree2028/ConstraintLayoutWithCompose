package com.example.myjetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun ConstraintLayoutPractice() {
    ConstraintLayout(
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
            .fillMaxSize()
    ) {
        val (backIcon, moreIcon, greetingMsg, profileImage, followers, followersText, following, followingText,
            bottomSheetCard, serviceText, consultationIcon, consultationText, androidIcon, androidText, iosIcon,
            iosText) = createRefs()
        val (flutterIcon, flutterText, reactNativeIcon, reatNativeText, webIcon, webText) = createRefs()
        val horizontalCenterGuideline = createGuidelineFromTop(0.40f)
        val topGuideLine = createGuidelineFromTop(16.dp)
        val startGuideLine = createGuidelineFromStart(16.dp)
        val endGuideLine = createGuidelineFromEnd(16.dp)
        createHorizontalChain(backIcon, moreIcon, chainStyle = ChainStyle.SpreadInside)

        Image(painter = painterResource(id = R.drawable.ic_back), contentDescription = "backIcon",
            modifier = Modifier
                .constrainAs(backIcon) {
                    top.linkTo(topGuideLine)
                    start.linkTo(startGuideLine)
                }
                .padding(start = 16.dp)
                .size(24.dp)
        )
        Image(painter = painterResource(id = R.drawable.ic_more), contentDescription = "moreIcon",
            modifier = Modifier
                .constrainAs(moreIcon) {
                    top.linkTo(topGuideLine)
                    end.linkTo(endGuideLine)
                }
                .padding(end = 16.dp)
                .size(24.dp)

        )
        val greetingBarrier =
            createEndBarrier(greetingMsg, followers, followersText, following, followingText)
        val userName = "Alex"
        val nameWithUser = "Welcome! \n$userName"
        Text(text = nameWithUser,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.constrainAs(greetingMsg) {
                top.linkTo(backIcon.bottom, margin = 32.dp)
                start.linkTo(startGuideLine)
            }
        )
        Text(text = "21.K",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.constrainAs(followers) {
                top.linkTo(greetingMsg.bottom, 50.dp)
                start.linkTo(greetingMsg.start)
                end.linkTo(followersText.end)
            })
        Text(text = "Followers",
            color = Color.Gray,
            modifier = Modifier.constrainAs(followersText) {
                top.linkTo(followers.bottom, 4.dp)
                start.linkTo(greetingMsg.start)
            })
        Text(
            text = "100",
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp,
            color = Color.Black,
            modifier = Modifier.constrainAs(following) {
                top.linkTo(greetingMsg.bottom, 50.dp)
                end.linkTo(profileImage.start, 10.dp)
            }
        )
        Text(text = "Following",
            color = Color.Gray,
            modifier = Modifier.constrainAs(followingText) {
                top.linkTo(following.bottom, 4.dp)
                end.linkTo(profileImage.start)
            }
        )
        Image(painter = painterResource(id = R.drawable.profile),
            contentDescription = "ProfileImage",
            contentScale = ContentScale.Inside,
            modifier = Modifier.constrainAs(profileImage) {
                top.linkTo(moreIcon.bottom)
                start.linkTo(greetingBarrier)
                end.linkTo(moreIcon.end)
                bottom.linkTo(horizontalCenterGuideline)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            })
        Card(
            elevation = 8.dp,
            shape = RoundedCornerShape(
                topStart = 32.dp,
                topEnd = 32.dp
            ),
            modifier = Modifier.constrainAs(bottomSheetCard) {
                top.linkTo(horizontalCenterGuideline)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                height = Dimension.fillToConstraints
                width = Dimension.fillToConstraints
            }
        ) {

        }
        Text(text = "My Services",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.constrainAs(serviceText) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(bottomSheetCard.top, margin = 16.dp)
            })
        createHorizontalChain(
            consultationIcon,
            androidIcon,
            iosIcon,
            chainStyle = ChainStyle.Spread
        )
        Image(painter = painterResource(id = R.drawable.talk), contentDescription = "consultation",
            modifier = Modifier
                .constrainAs(consultationIcon) {
                    top.linkTo(serviceText.bottom, margin = 10.dp)

                }
                .size(50.dp)
        )
        Image(painter = painterResource(id = R.drawable.android), contentDescription = "android",
            modifier = Modifier
                .constrainAs(androidIcon) {
                    bottom.linkTo(consultationIcon.bottom)
                    top.linkTo(consultationIcon.top)

                }
                .size(50.dp)
        )
        Image(painter = painterResource(id = R.drawable.apple), contentDescription = "ios",
            modifier = Modifier
                .constrainAs(iosIcon) {
                    bottom.linkTo(consultationIcon.bottom)
                    top.linkTo(consultationIcon.top)
                }
                .size(50.dp)
        )
        Text(text = "Consultation",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.constrainAs(consultationText) {
                end.linkTo(consultationIcon.end)
                top.linkTo(consultationIcon.bottom, 10.dp)
                start.linkTo(consultationIcon.start)
            })
        Text(text = "Android",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.constrainAs(androidText) {
                top.linkTo(androidIcon.bottom, 10.dp)
                end.linkTo(androidIcon.end)
                start.linkTo(androidIcon.start)
            })
        Text(text = "iOS",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.constrainAs(iosText) {
                top.linkTo(iosIcon.bottom, 10.dp)
                end.linkTo(iosIcon.end)
                start.linkTo(iosIcon.start)
            })
        createHorizontalChain(flutterIcon, reactNativeIcon, webIcon, chainStyle = ChainStyle.Spread)
        Image(painter = painterResource(id = R.drawable.flutter), contentDescription = "Flutter",
            modifier = Modifier
                .constrainAs(flutterIcon) {
                    top.linkTo(consultationText.bottom, margin = 16.dp)
                }
                .size(50.dp)
        )
        Image(painter = painterResource(id = R.drawable.react_native),
            contentDescription = "React Native",
            modifier = Modifier
                .constrainAs(reactNativeIcon) {
                    top.linkTo(androidText.bottom, margin = 16.dp)
                }
                .size(50.dp)
        )
        Image(painter = painterResource(id = R.drawable.web), contentDescription = "Web",
            modifier = Modifier
                .constrainAs(webIcon) {
                    top.linkTo(iosText.bottom, margin = 16.dp)
                }
                .size(50.dp)
        )
        Text(text = "Flutter",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.constrainAs(flutterText) {
                top.linkTo(flutterIcon.bottom, 12.dp)
                start.linkTo(flutterIcon.start)
                end.linkTo(flutterIcon.end)
            })
        Text(text = "React Native",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.constrainAs(reatNativeText) {
                top.linkTo(reactNativeIcon.bottom, 12.dp)
                start.linkTo(reactNativeIcon.start)
                end.linkTo(reactNativeIcon.end)
            })

        Text(text = "Web",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.constrainAs(webText) {
                top.linkTo(webIcon.bottom, 12.dp)
                start.linkTo(webIcon.start)
                end.linkTo(webIcon.end)
            })
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ConstraintLayoutPracticePreview() {
    ConstraintLayoutPractice()
}