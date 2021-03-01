/*
 * Copyright 2019 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.netty.handler.ssl.util;

import io.netty.util.internal.ObjectUtil;

import java.security.KeyStore;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;

public final class TrustManagerFactoryWrapper extends SimpleTrustManagerFactory {
    private final TrustManager tm;

    public TrustManagerFactoryWrapper(TrustManager tm) {
        this.tm = ObjectUtil.checkNotNull(tm, "tm");
    }

    @Override
    protected void engineInit(KeyStore keyStore) throws Exception { }

    @Override
    protected void engineInit(ManagerFactoryParameters managerFactoryParameters)
            throws Exception { }

    @Override
    protected TrustManager[] engineGetTrustManagers() {
        return new TrustManager[] {tm};
    }
}
