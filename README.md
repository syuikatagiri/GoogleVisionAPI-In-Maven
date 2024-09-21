# GoogleVisionAPI-In-Maven

## Environment

### Maven 
    C:\Users\syui5>mvn -v
    Apache Maven 3.9.9 (8e8579a9e76f7d015ee5ec7bfcdc97d260186937)
    Maven home: C:\maven
    Java version: 1.8.0_401, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-1.8\jre
    Default locale: ja_JP, platform encoding: MS932
    OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"

### Google Cloud Vison API
    <dependencyManagement>
      <dependencies>
        <dependency>
          <groupId>com.google.cloud</groupId>
          <artifactId>libraries-bom</artifactId>
          <version>26.39.0	</version>
          <type>pom</type>
          <scope>import</scope>
        </dependency>
      </dependencies>
      
### JAVA
    C:\Users\syui5>java -version
    java version "1.8.0_401"
    Java(TM) SE Runtime Environment (build 1.8.0_401-b10)
    Java HotSpot(TM) 64-Bit Server VM (build 25.401-b10, mixed mode)
