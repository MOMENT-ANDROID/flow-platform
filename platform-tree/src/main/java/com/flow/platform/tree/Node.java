/*
 * Copyright 2018 fir.im
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flow.platform.tree;

import java.util.LinkedList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yang
 */
@ToString(of = {"path"})
@EqualsAndHashCode(of = {"path"})
public final class Node {

    /**
     * Name of node
     */
    @Getter
    @Setter
    private String name;

    /**
     * Path of current node
     */
    @Getter
    @Setter
    private NodePath path;

    /**
     * Status of node
     */
    @Getter
    @Setter
    private NodeStatus status;

    @Getter
    @Setter
    private String content;

    /**
     * Groovy condition script
     */
    @Getter
    @Setter
    private String condition;

    /**
     * Allow failure on node
     */
    @Getter
    @Setter
    private boolean failure;

    /**
     * Children nodes
     */
    @Getter
    private List<Node> children = new LinkedList<>();
}
