// Copyright 2021-present StarRocks, Inc. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.


package com.starrocks.sql.ast;

import com.starrocks.analysis.Delimiter;
import com.starrocks.analysis.ParseNode;

public class ColumnSeparator implements ParseNode {
    private final String oriSeparator;
    private final String separator;

    public ColumnSeparator(String separator) {
        this.oriSeparator = separator;
        this.separator = Delimiter.convertDelimiter(oriSeparator);
    }

    public String getColumnSeparator() {
        return separator;
    }

    public String toSql() {
        return "'" + oriSeparator + "'";
    }

    @Override
    public String toString() {
        return toSql();
    }
}
