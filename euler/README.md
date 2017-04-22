Euler-fun euler
==========


### Rationale

Simple solutions to Euler problems (projecteuler.net). 
Using Java and JRuby to have better solved time!

<img src="http://projecteuler.net/profile/ducquoc_vn.png"></img>

### Building from Source

(Given you already have maven and java setup in your PC/env)

  $ mvn clean install -DskipTests

### Usage

**Basic Usage**

Running the JAR will no param to solve Euler001 (https://projecteuler.net/problem=1)

  $ java -jar target/euler-1.0.0-SNAPSHOT.jar

Running the JAR with param 'NNN' will solve EulerNNN (https://projecteuler.net/problem=NNN)

  $ java -jar target/euler-1.0.0-SNAPSHOT.jar 003


#### Sample output

  $ java -jar target/euler-1.0.0-SNAPSHOT.jar 003

`
Apr 05, 2017 10:02:10 AM vn.ducquoc.euler.EulerMain main
INFO: *** Solve it with S.I M.P L.E in mind. Result:
6857
Apr 05, 2017 10:02:10 AM vn.ducquoc.euler.EulerThread run
INFO: *** Sovled in 0.001464493 seconds
`

  $ java -jar target/euler-1.0.0-SNAPSHOT.jar 004

`
Apr 05, 2017 10:02:31 AM vn.ducquoc.euler.EulerMain main
INFO: *** Solve it with S.I M.P L.E in mind. Result:
906609
Apr 05, 2017 10:02:31 AM vn.ducquoc.euler.EulerThread run
INFO: *** Sovled in 0.005005034 seconds
`
