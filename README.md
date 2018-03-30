Euler-fun
==========


### Rationale

Have fun coding with Euler problems (projecteuler.net). 

http://projecteuler.net/profile/Zenith.ACM.png

Actually the PE does not requires much coding knowledge, but rather some Math background. Then we can apply some more techniques to get more efficient results.

### Usage

**Basic Usage**

Build the target of each language, for example target Jar in the euler sub-folder then run it:

```
  $ cd euler
  $ mvn clean install -DskipTests
  $ java -jar target/euler-1.0.0-SNAPSHOT.jar 003
```

or

```
  $ cd euler
  $ mvn compile exec:java -Dexec.mainClass=vn.ducquoc.euler.EulerMain
```

or 

```
  $ mvn compile exec:java -Dexec.mainClass=vn.ducquoc.euler.EulerMain -Dexec.args="003" -f euler/pom.xml
```

See also [euler/README.md](euler/README.md)
