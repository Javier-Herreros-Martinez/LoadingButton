package com.jhm.loadingbutton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
internal fun ButtonContent(
    buttonText: String,
    startIcon: ImageVector?,
    endIcon: ImageVector?,
    isLoading: Boolean,
    circularProgressIndicatorSize: Dp,
    circularProgressIndicatorColor: Color,
    circularProgressIndicatorStrokeWidth: Dp,
    circularProgressIndicatorTrackColor: Color,
    circularProgressIndicatorStrokeCap: StrokeCap
) {
    Box(
        modifier = Modifier.width(IntrinsicSize.Max),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val iconColor = if(isLoading) Color.Transparent else LocalContentColor.current
            if(startIcon != null) {
                Icon(
                    imageVector = startIcon,
                    contentDescription = null,
                    tint = iconColor
                )
            }

            Text(
                text = buttonText,
                color = if(isLoading) Color.Transparent else Color.Unspecified
            )

            if(endIcon != null) {
                Icon(
                    imageVector = endIcon,
                    contentDescription = null,
                    tint = iconColor
                )
            }
        }

        if(isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(circularProgressIndicatorSize),
                color = circularProgressIndicatorColor,
                strokeWidth = circularProgressIndicatorStrokeWidth,
                trackColor = circularProgressIndicatorTrackColor,
                strokeCap = circularProgressIndicatorStrokeCap
            )
        }
    }
}