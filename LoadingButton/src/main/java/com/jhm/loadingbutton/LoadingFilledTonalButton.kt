package com.jhm.loadingbutton

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LoadingFilledTonalButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    buttonShape: Shape = ButtonDefaults.filledTonalShape,
    buttonColors: ButtonColors = ButtonDefaults.filledTonalButtonColors(),
    buttonElevation: ButtonElevation? = ButtonDefaults.filledTonalButtonElevation(),
    buttonBorder: BorderStroke? = null,
    buttonContentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    buttonInteractionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    buttonText: String,
    startIcon: ImageVector? = null,
    endIcon: ImageVector? = null,
    isLoading: Boolean,
    circularProgressIndicatorSize: Dp = LoadingButtonDefaults.circularProgressIndicatorSize,
    circularProgressIndicatorColor: Color = ProgressIndicatorDefaults.circularColor,
    circularProgressIndicatorStrokeWidth: Dp = LoadingButtonDefaults.circularProgressIndicatorStrokeWidth,
    circularProgressIndicatorTrackColor: Color = ProgressIndicatorDefaults.circularTrackColor,
    circularProgressIndicatorStrokeCap: StrokeCap = ProgressIndicatorDefaults.CircularIndeterminateStrokeCap
) {
    FilledTonalButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled && !isLoading,
        shape = buttonShape,
        colors = buttonColors,
        elevation = buttonElevation,
        border = buttonBorder,
        contentPadding = buttonContentPadding,
        interactionSource = buttonInteractionSource
    ) {
        ButtonContent(
            isLoading = isLoading,
            startIcon = startIcon,
            endIcon = endIcon,
            buttonText = buttonText,
            circularProgressIndicatorSize = circularProgressIndicatorSize,
            circularProgressIndicatorColor = circularProgressIndicatorColor,
            circularProgressIndicatorStrokeWidth = circularProgressIndicatorStrokeWidth,
            circularProgressIndicatorTrackColor = circularProgressIndicatorTrackColor,
            circularProgressIndicatorStrokeCap = circularProgressIndicatorStrokeCap
        )
    }
}