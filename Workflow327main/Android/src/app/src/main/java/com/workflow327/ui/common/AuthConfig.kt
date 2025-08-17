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

package com.workflow327.ui.common

import androidx.core.net.toUri
import net.openid.appauth.AuthorizationServiceConfiguration

object AuthConfig {
  // Google OAuth Client ID for Web Application  
  // Using the Firebase project number - you may need to configure OAuth in Firebase Console
  const val googleClientId = "185268756345-i15lgqd3dclckev7somsf0pj6pjcg8bh.apps.googleusercontent.com"
 
  
  // Hugging Face Client ID.
  // For demo purposes, using a placeholder - replace with your actual client ID
  const val huggingFaceClientId = "workflow327"

  // Registered redirect URI for Hugging Face.
  // The scheme needs to match the
  // "android.defaultConfig.manifestPlaceholders["appAuthRedirectScheme"]" field in
  // "build.gradle.kts".
  const val huggingFaceRedirectUri = "com.workflow327://oauth/huggingface"

  // OAuth 2.0 Endpoints (Authorization + Token Exchange) for Hugging Face
  private const val authEndpoint = "https://huggingface.co/oauth/authorize"
  private const val tokenEndpoint = "https://huggingface.co/oauth/token"

  // OAuth service configuration for Hugging Face (AppAuth library requires this)
  val huggingFaceAuthServiceConfig =
    AuthorizationServiceConfiguration(
      authEndpoint.toUri(), // Authorization endpoint
      tokenEndpoint.toUri(), // Token exchange endpoint
    )
  
  // Aliases for backward compatibility
  val authServiceConfig = huggingFaceAuthServiceConfig
  val clientId = huggingFaceClientId
  val redirectUri = huggingFaceRedirectUri
}
