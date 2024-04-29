# **BeautyBook Project QA**
This README provides This README provides comprehensive information on the BeautyBook project's QA process, tools, 
and integration with Jenkins for continuous integration and delivery (CI/CD).

## Overview:
_The BeautyBook project QA process encompasses various tools and practices to ensure the quality and reliability of the software product. 
This document outlines the tools used, project structure, and instructions for contributing to the project._

## Tools Used:
* **Jira**: Project management, issue tracking, and agile development.**https://aleksandracheidze.atlassian.net/jira/software/projects/BEUT/boards/1
* **TestLink**: Test case management, test plan creation, and test execution tracking. https://testlink.ait-tr.de/index.php?caller=login&viewer=
* **MindMap**: Visualizing project structure, test plans, and test coverage.https://drive.mindmup.com/map/1TnzZIRMjHBj9fccOW7N7AGMRhHfi_jqG
* **API Testing**: Conducting API tests using specialized frameworks and tools. https://github.com/NataljaRoehm/beautybook_project_QA/tree/main/src/test/java/beautybook/API/tests
* **Jenkins**: Integration for continuous integration and delivery, automating the build, test, and deployment processes.
* .**idea**: Directory containing project-specific settings for IntelliJ IDEA.

## Project Structure:
* **src**: Source code directory containing project files.
* **gradle/wrapper**: Contains Gradle wrapper files for project build automation.
* .**gitignore**: Specifies intentionally untracked files to be ignored by Git.
* **build.gradle**: Gradle build script defining project dependencies and configurations.
* **gradlew, gradlew.bat**: Gradle wrapper scripts for project build automation.
* **settings.gradle**: Specifies the modules (projects) to include in the build.

## Jenkins Integration:
Jenkins is integrated into the BeautyBook project's CI/CD pipeline to automate the following processes:
* **Build**: Automatically build the project whenever changes are pushed to the repository.
* **Test**: Execute automated tests, including unit tests, integration tests, and API tests.
* **Deploy**: Deploy the application to a staging environment for further testing and validation.

## Usage:IntelliJ IDEA
* **Clone Repository**: Clone the BeautyBook project repository to your local machine.
* **Setup Environment**: Set up the required development environment, including JDK, IDE, and necessary dependencies.
* **Import Project**: Import the project into your preferred IDE (e.g., IntelliJ IDEA).
* **Run Tests**: Execute tests using the IDE's test runner or Gradle commands.
* **Contribute**: Add classes, tests, or improve existing functionality.
* **Commit Changes**: Commit changes to your local branch and push them to the remote repository.
* **Create Pull Request**: Merge your changes into the main branch via a pull request.

## Additional Links:
* Swagger API Documentation: https://beauty-project-ki2b5.ondigitalocean.app/swagger-ui/index.html#/
* Frontend Application: https://beaty-project-2-0-dwyu.vercel.app/

## Contributing:
Contributions to the BeautyBook project are welcome! Please follow the project's contribution guidelines and code of conduct.

