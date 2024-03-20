package com.example.biometrics

sealed interface BiometricResult{
    data object HardwareUnavailable : BiometricManager.BiometricResult
    data object FeatureUnavailable : BiometricManager.BiometricResult
    data class AuthenticationError(val error:String): BiometricManager.BiometricResult
    data object AuthenticationFailed: BiometricManager.BiometricResult
    data object AuthenticationSuccess:BiometricManager.BiometricResult
    data object AuthenticationNotSet: BiometricManager.BiometricResult
    
}