# Superset Support

[Apache Superset](https://superset.apache.org) is a modern data exploration and visualization platform.It uses [SQLAlchemy](https://docs.sqlalchemy.org/en/13/index.html) to query data.

Although [Mysql Dialect](https://superset.apache.org/docs/databases/mysql) can be used, it does not support `largeint`. So we developed [StarRocks Dialect](https://github.com/StarRocks/starrocks/blob/main/contrib/sqlalchemy-connector).

## Environment

- Python 3.x
- mysqlclient (pip install mysqlclient)
- [Apache Superset](https://superset.apache.org)


Notice: If `mysqlclient` is not installed, an exception will be thrown:
```
No module named 'MySQLdb'
```

## Installation

Since `dialect` does not contribute to `SQLAlchemy`, it needs to be installed from the source code.

If you install `superset` with Docker, install `sqlalchemy-starrocks` with `root`.

Install from [Source Code](https://github.com/StarRocks/starrocks/blob/main/contrib/sqlalchemy-connector)
```
pip install .
```
Uninstall
```
pip uninstall sqlalchemy-starrocks
```

## Usage

To connect to StarRocks with SQLAlchemy, the following URL pattern can be used:

```
starrocks://<username>:<password>@<host>:<port>/<database>[?charset=utf8]
```

## Basic Example
### Sqlalchemy Example
It is recommended to use python 3.x to connect to the StarRocks database, eg:
```
from sqlalchemy import create_engine
import pandas as pd
conn = create_engine('starrocks://root:@x.x.x.x:9030/superset_db?charset=utf8')
sql = """select * from xxx"""
df = pd.read_sql(sql, conn)
```

### Superset Example
In superset, use `Other` database, and set url is：
```
starrocks://root:@x.x.x.x:9030/superset_db?charset=utf8
```

