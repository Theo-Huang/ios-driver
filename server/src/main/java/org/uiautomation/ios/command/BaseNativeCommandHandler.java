/*
 * Copyright 2012-2013 eBay Software Foundation and ios-driver committers
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.uiautomation.ios.command;

import org.uiautomation.ios.UIAModels.configuration.WorkingMode;
import org.uiautomation.ios.communication.WebDriverLikeRequest;
import org.uiautomation.ios.IOSServerManager;
import org.uiautomation.ios.application.IOSRunningApplication;

public abstract class BaseNativeCommandHandler extends BaseCommandHandler {

  public BaseNativeCommandHandler(IOSServerManager driver, WebDriverLikeRequest request) {
    super(driver, request);
  }

  protected IOSRunningApplication getAUT() {
    return getServer().getSession(getRequest().getSession()).getApplication();
  }

  protected <T> T getConfiguration(String key) {
    return getConfiguration(key, (T) null);
  }

  protected <T> T getConfiguration(String key, T defaultValue) {
    T nativeSpecific = getConf(WorkingMode.Native + "." + key);
    if (nativeSpecific != null) {
      return nativeSpecific;
    } else {
      return super.getConf(key, defaultValue);
    }
  }

}
