package com.example.biometrics

import android.annotation.SuppressLint
import android.hardware.biometrics.BiometricManager.Authenticators.BIOMETRIC_STRONG
import android.hardware.biometrics.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt

class BiometricManager(
    private val activity:AppCompatActivity
) {
    @SuppressLint("WrongConstant")
    fun showBiometricPrompt(
        title:String,
        description:String
    ){
        val manager = BiometricManager.from(activity)
        val authenticators = if(Build.VERSION.SDK_INT>=30){
            BIOMETRIC_STRONG or DEVICE_CREDENTIAL
        }else BIOMETRIC_STRONG

        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle(title)
            .setDescription(description)
            .setAllowedAuthenticators(authenticators)

        if(Build.VERSION.SDK_INT< 30){
            promptInfo.setNegativeButtonText("Cancel")
        }
    }

    sealed interface BiometricResult{
        data object HardwareUnavailable : BiometricResult
        data object FeatureUnavailable :BiometricResult
        data class AuthenticationError(val error:String): BiometricResult
    }
}