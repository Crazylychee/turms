/*
 * Copyright (C) 2019 The Turms Project
 * https://github.com/turms-im/turms
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.web.reactive.result.method.annotation;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.ReactiveAdapterRegistry;
import org.springframework.http.codec.HttpMessageReader;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.reactive.result.method.InvocableHandlerMethod;
import org.springframework.web.reactive.result.method.TurmsHandlerMethod;

import java.util.List;

/**
 * @author James Chen
 */
public class TurmsControllerMethodResolver extends ControllerMethodResolver {

    public TurmsControllerMethodResolver(ArgumentResolverConfigurer customResolvers,
                                         ReactiveAdapterRegistry adapterRegistry,
                                         ConfigurableApplicationContext context,
                                         List<HttpMessageReader<?>> readers) {
        super(customResolvers, adapterRegistry, context, readers);
    }

    @Override
    public TurmsHandlerMethod getRequestMappingMethod(HandlerMethod handlerMethod) {
        InvocableHandlerMethod invocable = super.getRequestMappingMethod(handlerMethod);
        TurmsHandlerMethod method = new TurmsHandlerMethod(invocable);
        method.setArgumentResolvers(invocable.getResolvers());
        return method;
    }
}
