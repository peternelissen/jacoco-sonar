A first maven command collect the coverage of all modules in the same `.exec` file:
```bash
$ mvn clean install
```
A second maven command generate the JaCoCo XML report and send it to SonarQube:
```bash
$ mvn jacoco:report sonar:sonar
```
