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

package org.uiautomation.ios;

import org.uiautomation.ios.communication.device.DeviceType;
import org.uiautomation.ios.application.APPIOSApplication;
import org.uiautomation.ios.application.IPAApplication;
import org.uiautomation.ios.utils.ClassicCommands;

public class SimulatorDevice extends Device {

  @Override
  public IOSCapabilities getCapability() {
    IOSCapabilities res = new IOSCapabilities();
    res.setCapability(IOSCapabilities.SIMULATOR, true);
    res.setCapability(IOSCapabilities.UI_SDK_VERSION, ClassicCommands.getDefaultSDK());
    res.setCapability(IOSCapabilities.UI_SDK_VERSION + "_Alt",
                      new String[]{"5.0", "5.1", "6.0", "6.1"});
    res.setCapability(IOSCapabilities.DEVICE, DeviceType.iphone);
    res.setCapability(IOSCapabilities.DEVICE + "_Alt",
                      new DeviceType[]{DeviceType.iphone, DeviceType.ipad});

    return res;
  }

  @Override
  public boolean canRun(APPIOSApplication app) {
    if (app instanceof IPAApplication) {
      return false;
    }
    return true;
  }
  @Override
  public String toString(){
    return "Simulator[" + (isBusy()? "in use by ios-driver" : "available") + ']';
  }
}
