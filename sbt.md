# SBT

## create jar from scala project

[sbt-assembly](https://github.com/sbt/sbt-assembly)

add

```sbt
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.9")
```

to

```bash
project/assembly.sbt
```

in

```bash
build.sbt
```

add

```sbt
assemblyJarName in assembly := "something.jar"
mainClass in assembly := Some("com.example.Main")
```

## Excluding JARs and files (example in case of Spark)

```sbt
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "0.8.0-incubating" % "provided",
  "org.apache.hadoop" % "hadoop-client" % "2.0.0-cdh4.4.0" % "provided"
)
```

## Build jar

```sbt
> assembly
```

or

```bash
sbt assembly
```

run

```bash
java -cp path/something.jar package/mainObject
```

or

```bash
scala -cp path/something.jar
```

or in scala repl:

```scala
scala> :require something.jar
```
