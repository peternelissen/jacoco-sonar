# example project

M3 is the final JAR en uses M2. M2 uses M1. M1 has no dependencies.

In M1 there is a class M1 with 3 methods, they are covered by M1, M2 en M3.
In M2 there is a class M2 with 2 methods, they are covered by     M2 en M3.
In M3 there is a class M3 with 1 methods, they are covered by           M3.


# Run the projects

Run sonar on port 9000 (see below)
mvn clean verify sonar:sonar
Look at localhost:9000
Code coverage should be 100%.

# Example 1

Uses binary format of jacoco. Easy to use. 100% coverage.

# Other solutions

## seperate maven module

Jacoco’s solution is to create a report project and use the report-aggregate. https://github.com/jacoco/jacoco/tree/master/jacoco-maven-plugin.test/it/it-report-aggregate 2
This is not feasable for all our old projects. We dont want to create a seperate maven module just to have the coverage done right. This solution is too intrusive on the structure of the project.

## report and report aggregate (see example 4)

Another solution that I tried is to use the report and the report-aggregate goal for all projects. There are in total 6 reports, 2 for each module. And the sum of reports is correct. But there are two problems in this example. In the code of example-4, problem 2 is fixed. Problem 1 is not.

Problem 1:

The report-aggregate goal only takes code coverage of direct maven dependencies, not indirect ones. In my example, M2 is a dependency of M3. M1 is an indirect dependency of M3, as its a dependency of M2.

I dont want to make M1 a direct dependency of M3, that’s architecturally not correct. (example: M3 should not call classes of M1, it should use a facade layer in M2, which in his turn calls M1).

Problem 2:

A minor issue, but as all modules (m1, m2, m3) have tests, I need to add all xml reports to the sonar property.
But keep in mind that for 3 maven modules, it results in this (report + report aggregate per module): <sonar.coverage.jacoco.xmlReportPaths>…/jacoco-m1/target/site/jacoco-ut/jacoco.xml,…/jacoco-m1/target/site/jacoco-aggregate/jacoco.xml/jacoco.xml,…/jacoco-m2/target/site/jacoco-ut/jacoco.xml,…/jacoco-m2/target/site/jacoco-aggregate/jacoco.xml/jacoco.xml,…/jacoco-m3/target/site/jacoco-ut/jacoco.xml,…/jacoco-m3/target/site/jacoco-aggregate/jacoco.xml</sonar.coverage.jacoco.xmlReportPaths>
For projects with 6 or more maven modules, its getting a out of hand.

# Run sonar on localhost:9000

1 - Sonar initaliseren

Maak ergens een map aan. Bijvoorbeeld C:\data\sonar-gitlab-example\sonar

docker run --rm -p 9000:9000 -v C:\data\sonar-gitlab-example\sonar\conf:/opt/sonarqube/conf -v C:\data\sonar-gitlab-example\sonar\extensions:/opt/sonarqube/extensions -v C:\data\sonar-gitlab-example\sonar\data:/opt/sonarqube/data sonarqube:community-beta --init

2 - Database

in sonar.properties een DB definieren. Makkelijkste: sonar.jdbc.url=jdbc:h2:file:/opt/sonarqube/h2/h2;AUTO_SERVER=TRUE

3 - sonar starten en naam geven

docker run -d --name sonar -p 9000:9000 -v C:\data\sonar-gitlab-example\sonar\conf:/opt/sonarqube/conf -v C:\data\sonar-gitlab-example\sonar\extensions:/opt/sonarqube/extensions -v C:\data\sonar-gitlab-example\sonar\data:/opt/sonarqube/data -v C:\data\sonar-gitlab-example\sonar\h2:/opt/sonarqube/h2 sonarqube:community-beta

4 - sonar herstarten / logs bekijken
docker start sonar
docker logs sonar -f
