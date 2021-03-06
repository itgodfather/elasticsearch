/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.client.ccr;

import org.elasticsearch.client.AbstractResponseTestCase;
import org.elasticsearch.common.xcontent.XContentParser;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.xpack.core.ccr.action.PutFollowAction;

import java.io.IOException;

import static org.hamcrest.Matchers.is;

public class PutFollowResponseTests extends AbstractResponseTestCase<PutFollowAction.Response, PutFollowResponse> {

    @Override
    protected PutFollowAction.Response createServerTestInstance(XContentType xContentType) {
        return new PutFollowAction.Response(randomBoolean(), randomBoolean(), randomBoolean());
    }

    @Override
    protected PutFollowResponse doParseToClientInstance(XContentParser parser) throws IOException {
        return PutFollowResponse.fromXContent(parser);
    }

    @Override
    protected void assertInstances(PutFollowAction.Response serverTestInstance, PutFollowResponse clientInstance) {
        assertThat(serverTestInstance.isFollowIndexCreated(), is(clientInstance.isFollowIndexCreated()));
        assertThat(serverTestInstance.isFollowIndexShardsAcked(), is(clientInstance.isFollowIndexShardsAcked()));
        assertThat(serverTestInstance.isIndexFollowingStarted(), is(clientInstance.isIndexFollowingStarted()));
    }
}
