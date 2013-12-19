#!/bin/bash

java -cp /opt/hsqldb-2.3.0/hsqldb/lib/hsqldb.jar org.hsqldb.server.Server --database.0 mem:mydb --dbname.0 workdb
