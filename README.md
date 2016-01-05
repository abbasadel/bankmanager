Bank Account Manager
=============
## Modules

* **Core**: Contains the domain models and common classes and exceptions
* **Service**: Contains services interfaces and implementation of any if necessary
* **Business**: Contains the Managers classes that contain the business logic
* **Persistence-hsql**: Implementation of Persistence layer using HSQL
* **Persistence-Simple**: Implementation of Persistence layer using HashMap
* **Web**: The web application
* **jms-consumer**: JMS Consumer developer as an app to be deployed in the same web container/server

### Switch Persistence Implementation
Edit Business/pom.xml and use switch the dependency to the other implementation
### Future Improvements
- Add javadoc to all methods
- Test JMS Integration
- Test exceptional cases
- Add wadl description to the rest endpoint
### Usage

```sh
git clone https://github.com/abbasadel/bankmanager.git
cd bankmanager
sh ./serve.sh
#or mvn jetty:run -pl ./Web

```
Then navigate to http://localhost:8080/
