/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.workflow327.data

import android.app.Activity
import android.content.Context
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialException
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.workflow327.ui.common.AuthConfig
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton



data class UserProfile(
  val id: String,
  val email: String,
  val name: String,
  val profilePictureUrl: String? = null
)

sealed class AuthState {
  object Loading : AuthState()
  object NotAuthenticated : AuthState()
  data class Authenticated(val user: UserProfile) : AuthState()
  data class Error(val message: String) : AuthState()
}

@Singleton
class AuthRepository @Inject constructor(
  @ApplicationContext private val context: Context
) {
  private val credentialManager = CredentialManager.create(context)
  
  private val _authState = MutableStateFlow<AuthState>(AuthState.NotAuthenticated)
  val authState: StateFlow<AuthState> = _authState.asStateFlow()
  
  suspend fun signInWithGoogle(activity: Activity? = null): Result<UserProfile> {
    return try {
      _authState.value = AuthState.Loading

      // Require Activity context for Credential Manager
      if (activity == null) {
        throw IllegalArgumentException("Activity required for Google Sign-In")
      }

      val googleIdOption = GetGoogleIdOption.Builder()
        .setServerClientId(AuthConfig.googleClientId)
        .setFilterByAuthorizedAccounts(false)
        .setAutoSelectEnabled(false)
        .build()

      val request = GetCredentialRequest.Builder()
        .addCredentialOption(googleIdOption)
        .build()
      
      val result = credentialManager.getCredential(
        request = request,
        context = activity,
      )
      
      val credential = GoogleIdTokenCredential.createFrom(result.credential.data)
      
      val userProfile = UserProfile(
        id = credential.id,
        email = credential.id,
        name = credential.displayName ?: "Unknown User",
        profilePictureUrl = credential.profilePictureUri?.toString()
      )
      
      _authState.value = AuthState.Authenticated(userProfile)
      Result.success(userProfile)
      
    } catch (e: GetCredentialException) {
      val errorMessage = when {
        e.message?.contains("16") == true -> "Configuration error: Please verify your SHA-1 fingerprint and web client ID are correctly set in Firebase Console"
        e.message?.contains("Cannot find matching credential") == true -> "No Google account found. Please add a Google account to your device"
        e.message?.contains("28433") == true -> "Credential configuration mismatch. Check Firebase setup"
        else -> "Google Sign-In failed: ${e.message}"
      }
      _authState.value = AuthState.Error(errorMessage)
      Result.failure(e)
    } catch (e: Exception) {
      val errorMessage = "Unexpected error during sign-in: ${e.message}"
      _authState.value = AuthState.Error(errorMessage)
      Result.failure(e)
    }
  }
  
  suspend fun signOut() {
    try {
      // Clear any cached credentials
      _authState.value = AuthState.NotAuthenticated
    } catch (e: Exception) {
      // Even if clearing fails, we still want to mark as not authenticated
      _authState.value = AuthState.NotAuthenticated
    }
  }
  
  suspend fun skipToDemo() {
    // Create a demo user profile for testing purposes
    val demoUser = UserProfile(
      id = "demo_user",
      email = "demo@workflow327.com",
      name = "Demo User",
      profilePictureUrl = null
    )
    _authState.value = AuthState.Authenticated(demoUser)
  }
  
  fun getCurrentUser(): UserProfile? {
    return when (val state = _authState.value) {
      is AuthState.Authenticated -> state.user
      else -> null
    }
  }
  
  fun isAuthenticated(): Boolean {
    return _authState.value is AuthState.Authenticated
  }
}