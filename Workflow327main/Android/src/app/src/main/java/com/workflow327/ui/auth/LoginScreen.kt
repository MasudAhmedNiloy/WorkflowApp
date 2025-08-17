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

package com.workflow327.ui.auth

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.workflow327.data.AuthState

@Composable
fun LoginScreen(
  onLoginSuccess: () -> Unit,
  modifier: Modifier = Modifier,
  viewModel: LoginViewModel = hiltViewModel()
) {
  val authState by viewModel.authState.collectAsStateWithLifecycle()
  val context = LocalContext.current
  val activity = context as? Activity
  
  LaunchedEffect(authState) {
    if (authState is AuthState.Authenticated) {
      onLoginSuccess()
    }
  }
  
  Box(
    modifier = modifier
      .fillMaxSize()
      .padding(24.dp),
    contentAlignment = Alignment.Center
  ) {
    Card(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
      elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
      shape = RoundedCornerShape(16.dp)
    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
      ) {
        // App Logo/Icon
        Icon(
          painter = painterResource(id = android.R.drawable.ic_dialog_info),
          contentDescription = "327 Workflow Logo",
          modifier = Modifier.size(80.dp),
          tint = MaterialTheme.colorScheme.primary
        )
        
        // Welcome Text
        Column(
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
          Text(
            text = "Welcome to 327 Workflow",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
          )
          
          Text(
            text = "AI-powered workflow automation with M1 & M2 models",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
          )
        }
        
        // Feature highlights
        Column(
          verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
          FeatureItem("• Local AI Models (M1 & M2)")
          FeatureItem("• Full Device Access")
          FeatureItem("• Workflow Automation")
          FeatureItem("• Secure Authentication")
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Google Sign-In Button
        when (authState) {
          is AuthState.Loading -> {
            Button(
              onClick = { },
              modifier = Modifier.fillMaxWidth(),
              enabled = false
            ) {
              CircularProgressIndicator(
                modifier = Modifier.size(20.dp),
                strokeWidth = 2.dp,
                color = MaterialTheme.colorScheme.onPrimary
              )
              Spacer(modifier = Modifier.width(8.dp))
              Text("Signing in...")
            }
          }
          
          is AuthState.Error -> {
            Column {
              Button(
                onClick = { viewModel.signInWithGoogle(activity) },
                modifier = Modifier.fillMaxWidth()
              ) {
                Icon(
                  imageVector = Icons.Filled.AccountCircle,
                  contentDescription = null,
                  modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Sign in with Google")
              }
              
              Spacer(modifier = Modifier.height(8.dp))
              
              Text(
                text = (authState as AuthState.Error).message,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
              )
            }
          }
          
          else -> {
            Button(
              onClick = { viewModel.signInWithGoogle(activity) },
              modifier = Modifier.fillMaxWidth()
            ) {
              Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
              )
              Spacer(modifier = Modifier.width(8.dp))
              Text("Sign in with Google")
            }
          }
        }
        
        // Skip for demo
        TextButton(
          onClick = { onLoginSuccess() },
          modifier = Modifier.fillMaxWidth()
        ) {
          Text(
            text = "Skip for Demo",
            style = MaterialTheme.typography.bodyMedium
          )
        }
      }
    }
  }
}

@Composable
private fun FeatureItem(text: String) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Start
  ) {
    Text(
      text = text,
      style = MaterialTheme.typography.bodyMedium,
      color = MaterialTheme.colorScheme.onSurfaceVariant
    )
  }
}