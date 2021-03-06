/*
 * Copyright (c) 2016 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.common.truth;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class FailureStrategyTest {

  @Test
  public void testTruthFramesAreStrippedFromStackTrace() throws Exception {
    boolean threw = true;
    try {
      Truth.THROW_ASSERTION_ERROR.fail("test");
      threw = false;
    } catch (AssertionError expected) {
      for (StackTraceElement stackTraceElement : expected.getStackTrace()) {
        assertThat(stackTraceElement.getClassName()).doesNotContain("com.google.common.truth");
      }
    }
    assertThat(threw).isTrue();
  }
}
