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

import android.content.Context
import androidx.datastore.core.DataStore
import com.workflow327.AppLifecycleProvider
import com.workflow327.WorkflowLifecycleProvider
import com.workflow327.proto.Settings

/**
 * App container for Dependency injection.
 *
 * This interface defines the dependencies required by the application.
 */
interface AppContainer {
  val context: Context
  val lifecycleProvider: AppLifecycleProvider
  val dataStoreRepository: DataStoreRepository
}

/**
 * Default implementation of the AppContainer interface.
 *
 * This class provides concrete implementations for the application's dependencies,
 */
class DefaultAppContainer(ctx: Context, dataStore: DataStore<Settings>) : AppContainer {
  override val context = ctx
  override val lifecycleProvider = WorkflowLifecycleProvider()
  override val dataStoreRepository = DefaultDataStoreRepository(dataStore)
}
