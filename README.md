# sori

A website written in noir. 
Here it is on-line
http://el-sori.herokuapp.com/welcome
http://el-sori.herokuapp.com/home

##  LOCAL INSTALLATION
First  you need to have installed:
+ mongodb
+ create db "db" with auth user "root", password "root"
+ setenv var with this key/value "MONGOHQ_URL" "mongodb://root:root@127.0.0.1:27017/db"

## Usage

```bash
start mongod from console: $mongod --auth
lein deps
lein run

```
ENJOY!

## License

Copyright (C) 2011 juanantonioruz@gmail.com

Distributed under the Eclipse Public License, the same as Clojure.

